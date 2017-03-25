package com.example.nicha.as_android.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nicha.as_android.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_menu);
    }

    public void entrarCriarPreAluguel (View v){
        Intent intent =  new Intent(getApplicationContext(), CriarActivity.class);
        startActivity(intent);
    }

    public void entrarConsultarPreAluguel (View v){
        Intent intent = new Intent(getApplicationContext(), ConsultarActivity.class);
        startActivity(intent);
    }
}
