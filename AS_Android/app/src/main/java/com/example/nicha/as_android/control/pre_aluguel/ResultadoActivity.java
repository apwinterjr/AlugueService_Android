package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.dto.PreAluguelDTO;
import com.example.nicha.as_android.model.PreAluguel;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.Util;

import java.net.URL;

public class ResultadoActivity extends Activity
{

    PreAluguelDTO preAluguelDto;
    TextView txtNomeCliente;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_resultado);
        preAluguelDto = new PreAluguelDTO();
        txtNomeCliente = (TextView) findViewById(R.id.txtNomeConsultarPreAluguel);
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            id = (Integer) b.get("id");
            new ConsultarPreVenda().execute();
        }
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
            PreAluguel preAluguel = new PreAluguel();
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
                    txtNomeCliente.setText("Nome: " + preAluguelDto.getPreAluguel().getCliente().getNome() + " " + preAluguelDto.getPreAluguel().getCliente().getSobrenome());
                } else
                {
                    Toast.makeText(ResultadoActivity.this, preAluguelDto.getMensagem(), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(ResultadoActivity.this, preAluguelDto.getMensagem(), Toast.LENGTH_SHORT).show();}

        }
    }
}
