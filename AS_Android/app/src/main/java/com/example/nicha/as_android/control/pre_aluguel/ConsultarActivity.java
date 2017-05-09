package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.dto.PreAluguelDTO;
import com.example.nicha.as_android.model.PreAluguel;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.Util;

import java.net.URL;

public class ConsultarActivity extends Activity {

    EditText editTextIdPreAluguel;
    Button btnConsultar;
    PreAluguelDTO preAluguelDto;
    static PreAluguel preAluguel;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_consultar);
        preAluguel = new PreAluguel();
        preAluguelDto = new PreAluguelDTO();
        editTextIdPreAluguel = (EditText) findViewById(R.id.txtPreAluguel);
        btnConsultar = (Button) findViewById(R.id.btnConsultarPreVenda);
    }

    public void consultarPreAluguel(View v){
        id = Integer.parseInt(editTextIdPreAluguel.getText().toString());
        new  ConsultarPreVenda().execute();
    }


    private class ConsultarPreVenda extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            String resultado = null;

            try
            {
                URL url = new URL(Util.URL_WS+"PreAluguel/Pesquisar");
                resultado = Json.conexaoJsonGet(url);

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return resultado;
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            preAluguelDto = Json.toPreAluguelDTO(s);
            if(preAluguelDto.isOk())
            {
                for (PreAluguel p : preAluguelDto.getLista())
                {
                    if (p.getIdPreAluguel() == id)
                    {
                        preAluguel = p;
                    }
                }
                if (preAluguel.getIdPreAluguel() != 0)
                {
                    Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
                    startActivity(intent);
                } else
                {
                    Toast.makeText(ConsultarActivity.this, "Nenhum produto encontrado.", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(ConsultarActivity.this, preAluguelDto.getMensagem(), Toast.LENGTH_SHORT).show();}

        }
    }
}
