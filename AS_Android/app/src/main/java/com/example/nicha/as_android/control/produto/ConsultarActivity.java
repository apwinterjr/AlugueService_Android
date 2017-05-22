package com.example.nicha.as_android.control.produto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.control.pre_aluguel.SelecionarProdutoActivity;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;

import org.json.JSONException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConsultarActivity extends Activity
{

    EditText txtIdProduto;
    List<Produto> produtos;
    static Produto produtoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_consultar);
        new DownloadFromWS().execute();
        txtIdProduto = (EditText) findViewById(R.id.txtProdutoConsultar);

    }


    public void consultar(View v)
    {
        if (txtIdProduto.length() > 0)
        {
            for (Produto p : produtos)
            {
                if (p.getIdProduto() == Integer.parseInt(txtIdProduto.getText().toString())){
                    produtoSelecionado = p;
                }
            }
            if (produtoSelecionado.getIdProduto() != 0)
            {
                Intent intent = new Intent(v.getContext(), ResultadoActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Nenhuma produto encontrado.", Toast.LENGTH_SHORT).show();
            }
        } else
        {
            Toast.makeText(this, "Favor informar o id do produto", Toast.LENGTH_SHORT).show();
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
                URL url = new URL(com.example.nicha.as_android.util.Utilitario.URL_WS + "Produto/Pesquisar");
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
                if (produtoDto.isOk())
                {
                    produtos = new ArrayList<Produto>();
                    produtos = produtoDto.getLista();

                } else
                {
                    Toast.makeText(ConsultarActivity.this, produtoDto.getMensagem(), Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }

    }
}
