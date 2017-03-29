package com.example.nicha.as_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void autenticar(View v){
        EditText l = (EditText) findViewById(R.id.txtUsuario);
        EditText s = (EditText) findViewById(R.id.txtSenha);
        String pass = "admin";
        String login = l.getText().toString();
        String senha = s.getText().toString();

        if (senha.equals(pass) && login.equals(pass))
        {
            Intent intent =  new Intent(getApplicationContext(), PaginaPrincipalActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Login e/ou senha incorreto.", Toast.LENGTH_SHORT).show();
        }
    }
}
