package com.example.nicha.as_android.control.produto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.control.pre_aluguel.*;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_status);
        listViewProdutoSelecionado = (ListView) findViewById(R.id.ListStatusProdutoSelecionado);
        listaProdutoSelecionado = new ArrayList<Produto>();
        editTextIdProduto = (EditText) findViewById(R.id.editTextIdProdutoStatus);

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
        URL url = null;
        try
        {
            url = new URL("http://10.0.2.2:9999/AlugueServiceWS/WS/Produto/Pesquisar/Recuperar/" + editTextIdProduto.getText().toString());
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        String json = Json.recuperar(url);
        if (json != null)
        {
            ProdutoDTO produtoDto = new ProdutoDTO();
            produtoDto = Json.toProdutoDTO(json);
            if (produtoDto.isOk())
            {
                listaProdutoSelecionado.add(produtoDto.getProduto());
                adicionarNaListView(listaProdutoSelecionado);
            } else
            {
                Toast.makeText(this, produtoDto.getMensagem(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void removerProdutoLista(View v)
    {
        if(produtoSelecionado != null || produtoSelecionado.getIdProduto() != 0){
            listaProdutoSelecionado.remove(produtoSelecionado);
            adicionarNaListView(listaProdutoSelecionado);
            Toast.makeText(this, produtoSelecionado.getNome() + " removido", Toast.LENGTH_SHORT).show();
            produtoSelecionado = new Produto();
        }else{
            Toast.makeText(this, "Nenhum produto selecionado.", Toast.LENGTH_SHORT).show();
        }

    }

    public void adicionarNaListView(List<Produto> produtos)
    {
        ProdutoAdapter ProdutoAdapter = new ProdutoAdapter(StatusActivity.this, R.layout.lista_produto, produtos);
        listViewProdutoSelecionado.setAdapter(ProdutoAdapter);
    }

}
