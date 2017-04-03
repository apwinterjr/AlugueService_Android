package com.example.nicha.as_android.control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nicha.as_android.R;

public class PaginaPrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
    }

    public void entrarPreAluguel (View v){
        Intent intent =  new Intent(v.getContext(), com.example.nicha.as_android.control.pre_aluguel.MenuActivity.class);
        startActivity(intent);
    }

    public void entrarProduto (View v){
        Intent intent = new Intent(getApplicationContext(), com.example.nicha.as_android.control.produto.MenuActivity.class);
        startActivity(intent);
    }
}
