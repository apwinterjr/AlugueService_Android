package com.example.nicha.as_android.control.produto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.control.pre_aluguel.*;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;
import com.example.nicha.as_android.util.Utilitario;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StatusActivity extends Activity
{

    List<Produto> listaProdutoSelecionado;
    ListView listViewProdutoSelecionado;
    EditText editTextIdProduto;
    Produto produtoSelecionado;
    String idProduto;
    Spinner spinnerStatus;
    String[] status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_status);
        listViewProdutoSelecionado = (ListView) findViewById(R.id.ListStatusProdutoSelecionado);
        listaProdutoSelecionado = new ArrayList<Produto>();
        editTextIdProduto = (EditText) findViewById(R.id.editTextIdProdutoStatus);
        spinnerStatus = (Spinner) findViewById(R.id.spinnerStatus);
        status = new String[]{"Ativo", "Inativo", "Manutenção", "Lavagem"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, status);
        spinnerStatus.setAdapter(adapter);
        listViewProdutoSelecionado.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                produtoSelecionado = new Produto();
                produtoSelecionado = (Produto) listViewProdutoSelecionado.getItemAtPosition(position);
                Toast.makeText(StatusActivity.this, produtoSelecionado.getNome() + " selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void adicionarProdutoNaLista(View v)
    {
        idProduto = editTextIdProduto.getText().toString();
        Boolean adiciona = true;
        Integer id = Integer.parseInt(idProduto);
        for (Produto p : listaProdutoSelecionado)
        {
            if (p.getIdProduto().equals(id))
            {
                adiciona = false;
            }
        }
        if (adiciona)
        {
            new DownloadFromWS().execute();
        }else {
            Toast.makeText(this, "Produto já consta na lista.", Toast.LENGTH_SHORT).show();
        }
    }

    public void removerProdutoLista(View v)
    {
        if (produtoSelecionado != null || produtoSelecionado.getIdProduto() != 0)
        {
            listaProdutoSelecionado.remove(produtoSelecionado);
            adicionarNaListView(listaProdutoSelecionado);
            Toast.makeText(this, produtoSelecionado.getNome() + " removido", Toast.LENGTH_SHORT).show();
            produtoSelecionado = new Produto();
        } else
        {
            Toast.makeText(this, "Nenhum produto selecionado.", Toast.LENGTH_SHORT).show();
        }

    }

    public void adicionarNaListView(List<Produto> produtos)
    {
        ProdutoAdapter ProdutoAdapter = new ProdutoAdapter(StatusActivity.this, R.layout.lista_produto, produtos);
        listViewProdutoSelecionado.setAdapter(ProdutoAdapter);
    }


    private class DownloadFromWS extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... params)
        {
            URL url = null;
            try
            {
                url = new URL(Utilitario.URL_WS + "Produto/Recuperar/" + idProduto);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            String json = Json.recuperar(url);
            return json;

        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            ProdutoDTO produtoDto = new ProdutoDTO();
            produtoDto = Json.toProdutoDTO(s);
            if (produtoDto.isOk())
            {
                listaProdutoSelecionado.add(produtoDto.getProduto());
                adicionarNaListView(listaProdutoSelecionado);
            } else
            {
                Toast.makeText(StatusActivity.this, produtoDto.getMensagem(), Toast.LENGTH_SHORT).show();
            }

        }

    }
}
