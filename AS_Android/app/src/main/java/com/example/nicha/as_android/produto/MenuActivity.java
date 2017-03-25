package com.example.nicha.as_android.produto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nicha.as_android.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_menu);
    }

    public void entrarStatusProduto(View v){
        Intent intent =  new Intent(getApplicationContext(), StatusActivity.class);
        startActivity(intent);
    }

    public void entrarConsultarProduto(View v){
        Intent intent = new Intent(getApplicationContext(), ConsultarActivity.class);
        startActivity(intent);
    }
}
