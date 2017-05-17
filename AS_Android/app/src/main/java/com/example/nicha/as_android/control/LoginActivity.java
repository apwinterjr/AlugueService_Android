package com.example.nicha.as_android.control;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.dto.OperadorDTO;
import com.example.nicha.as_android.model.Operador;

import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.Utilitario;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import net.danlew.android.joda.JodaTimeAndroid;

import io.fabric.sdk.android.Fabric;

import java.net.URL;


public class LoginActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "rvPAeH3sUrPLmeq9RPAgpbuVi";
    private static final String TWITTER_SECRET = "Ep0JvcaCqLUOtOabLXJMhmPm75edNGw0ri5bU7kUFRng3h6Xhi";



    Operador operador;
    public static Operador operadorLogado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_login);
        operador = new Operador();
        EditText l = (EditText) findViewById(R.id.txtUsuario);
        l.requestFocus();
    }

    public void autenticar(View v){
        EditText l = (EditText) findViewById(R.id.txtUsuario);
        EditText s = (EditText) findViewById(R.id.txtSenha);
        String login = l.getText().toString();
        String senha = s.getText().toString();
        operador.setLogin(login);
        operador.setSenha(senha);

        new Autenticar().execute();
    }

    private class Autenticar extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            String resultado = null;

            try
            {
                URL url = new URL(Utilitario.URL_WS+"Operador/Autenticar");
                resultado = Json.conexaoJsonPostLogin(url,operador);

            } catch (Exception e)
            {
                Toast.makeText(LoginActivity.this, "Link incorreto para o servidor.", Toast.LENGTH_SHORT).show();
            }
            return resultado;
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            OperadorDTO operadorDTO = Json.jsonToOperadorDTO(s);
            if (operadorDTO.isOk())
            {
                operadorLogado = operadorDTO.getOperador();
                Intent intent =  new Intent(getApplicationContext(), PaginaPrincipalActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(LoginActivity.this, operadorDTO.getMensagem(), Toast.LENGTH_SHORT).show();
            }

        }
    }

}
