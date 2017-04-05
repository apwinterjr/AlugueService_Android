package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicha.as_android.R;

import java.util.Calendar;

public class CriarActivity extends Activity {

    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_criar);
        dialogData();
    }

    public void dialogData() {
        Button btn = (Button) findViewById(R.id.btnSelecionarData);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CriarActivity.this, listner, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            TextView txtDataSelecionada = (TextView) findViewById(R.id.txtDataCriarPreAluguel);
            txtDataSelecionada.setText("Data: " + dayOfMonth + "/" + month + "/" + year);
        }
    };

    public void adicionarProduto(View v) {
        Intent intent = new Intent(getApplicationContext(), SelecionarProdutoActivity.class);
        startActivityForResult(intent, 1);
    }

    public void selecionarCliente(View v) {
        Intent intent = new Intent(getApplicationContext(), SelecionarClienteActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String s = data.getStringExtra("id");
                Toast.makeText(this,"Cliente: " + s, Toast.LENGTH_SHORT).show();
            }
        }


    }

}
