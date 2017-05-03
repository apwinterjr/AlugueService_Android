package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nicha.as_android.R;

public class ConsultarActivity extends Activity {

    EditText editTextIdPreAluguel;
    Button btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_consultar);
        editTextIdPreAluguel = (EditText) findViewById(R.id.txtPreAluguel);
        btnConsultar = (Button) findViewById(R.id.btnConsultarPreVenda);
    }

    public void consultarPreAluguel(View v){
        Integer id = Integer.parseInt(editTextIdPreAluguel.getText().toString());
        Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
