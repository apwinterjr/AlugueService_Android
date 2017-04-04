package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.Util.Json;
import com.example.nicha.as_android.Util.ProdutoAdapter;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SelecionarProdutoActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_selecionar_produto);
        loadProdutos();
    }

    private void loadProdutos()
    {
        new DownloadFromWS().execute();
    }

    private class DownloadFromWS extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... params)
        {
            String resultado = null;

            try
            {
                URL url = new URL("http://10.0.2.2:9999/AlugueServiceWS/WS/Produto/Pesquisar");
                resultado = Json.conexaoJsonGet(url);

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            try
            {
                ProdutoDTO produtoDto = Json.convertJSONtoProdutoDTOLista(s);
                if (produtoDto.isOk()){
                    ArrayAdapter<Produto> produtoAdapter = new ProdutoAdapter(SelecionarProdutoActivity.this, R.layout.lista_produto,produtoDto.getLista());
                    ListView listViewProduto = (ListView) findViewById(R.id.listProdutos);
                    listViewProduto.setAdapter(produtoAdapter);
                }
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }

    }
}
