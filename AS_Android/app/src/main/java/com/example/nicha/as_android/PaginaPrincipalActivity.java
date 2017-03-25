package com.example.nicha.as_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaginaPrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
    }

    public void entrarPreAluguel (View v){
        Intent intent =  new Intent(v.getContext(), com.example.nicha.as_android.pre_aluguel.MenuActivity.class);
        startActivity(intent);
    }

    public void entrarProduto (View v){
        Intent intent = new Intent(getApplicationContext(), com.example.nicha.as_android.produto.MenuActivity.class);
        startActivity(intent);
    }
}
