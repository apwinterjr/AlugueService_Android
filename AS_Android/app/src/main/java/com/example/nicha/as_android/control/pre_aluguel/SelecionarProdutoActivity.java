package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;

import org.json.JSONException;

import java.net.URL;

public class SelecionarProdutoActivity extends Activity
{
    ListView listViewProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_selecionar_produto);
        listViewProduto = (ListView) findViewById(R.id.listProdutos);
        loadProdutos();
        listViewProduto.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Produto p = (Produto) listViewProduto.getItemAtPosition(position);
                Intent intent = new Intent();
                if(adicionarProdutoNaLista(p)){
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }

    private Boolean adicionarProdutoNaLista(Produto p){
        Boolean ok = true;
        for (Produto produto : CriarActivity.listaProdutoSelecionado
             )
        {
            if(produto.getIdProduto() == p.getIdProduto()){

                ok = false;
            }
        }
        if (ok){
            CriarActivity.listaProdutoSelecionado.add(p);
            return true;
        }else {
            return false;
        }

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
                URL url = new URL(com.example.nicha.as_android.util.Utilitario.URL_WS+"Produto/Pesquisar");
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
                }else{
                    Toast.makeText(SelecionarProdutoActivity.this, produtoDto.getMensagem(), Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }

    }
}
