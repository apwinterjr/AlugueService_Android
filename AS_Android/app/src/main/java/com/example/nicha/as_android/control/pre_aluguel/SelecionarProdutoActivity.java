package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
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
import com.example.nicha.as_android.util.Utilitario;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SelecionarProdutoActivity extends Activity
{
    ListView listViewProduto;
    Produto p;

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
                p = (Produto) listViewProduto.getItemAtPosition(position);
                Intent intent = new Intent();
                if(adicionarProdutoNaLista(p)){
                    setResult(RESULT_OK, intent);
                    p.setStatus(3);
                    new AtualizarProduto().execute();
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

    private class AtualizarProduto extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            try
            {
                URL url = new URL(Utilitario.URL_WS+"Produto/Atualizar");
                Json.alterarProduto(p,url);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }


            return null;
        }
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
                    List<Produto> list = new ArrayList<Produto>();
                    for (Produto p: produtoDto.getLista())
                    {
                        if(p.getStatus() == 1){
                            list.add(p);
                        }
                    }
                    ArrayAdapter<Produto> produtoAdapter = new ProdutoAdapter(SelecionarProdutoActivity.this, R.layout.lista_produto,list);
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
