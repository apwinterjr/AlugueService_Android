package com.example.nicha.as_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void autenticar(){
        EditText login = (EditText) findViewById(R.id.txtUsuario);
        EditText senha = (EditText) findViewById(R.id.txtSenha);

        if (login.getText().equals("1") && senha.getText().equals("admin"))
        {
            Intent intent =  new Intent(getApplicationContext(), PaginaPrincipalActivity.class);
        }
    }
}
