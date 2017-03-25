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
        Intent intent = new Intent(getApplicationContext(), PaginaPrincipal_PreAluguelActivity.class);
        startActivity(intent);
    }

    public void entrarProduto (View v){
        Intent intent = new Intent(getApplicationContext(), PaginaPrincipial_ProdutosActivity.class);
        startActivity(intent);
    }
}
