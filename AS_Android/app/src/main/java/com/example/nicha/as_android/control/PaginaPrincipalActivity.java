package com.example.nicha.as_android.control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

import io.fabric.sdk.android.Fabric;

import static android.R.attr.data;

public class PaginaPrincipalActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "rvPAeH3sUrPLmeq9RPAgpbuVi";
    private static final String TWITTER_SECRET = "Ep0JvcaCqLUOtOabLXJMhmPm75edNGw0ri5bU7kUFRng3h6Xhi";
    TwitterLoginButton btnTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        btnTwitter = (TwitterLoginButton) findViewById(R.id.btnTwitter);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        btnTwitter.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                TwitterSession session = TwitterCore.getInstance().getSessionManager()
                        .getActiveSession();
                Intent intent = new ComposerActivity.Builder(PaginaPrincipalActivity.this)
                        .session(session)
                        .createIntent();
                startActivity(intent);
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(PaginaPrincipalActivity.this, "Erro ao autenticar com Twitter.", Toast.LENGTH_SHORT).show();
                exception.printStackTrace();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        btnTwitter.onActivityResult(requestCode, resultCode, data);
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
