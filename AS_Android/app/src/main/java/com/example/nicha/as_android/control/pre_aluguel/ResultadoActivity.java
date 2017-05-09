package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.dto.PreAluguelDTO;
import com.example.nicha.as_android.model.PreAluguel;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;
import com.example.nicha.as_android.util.Util;

import java.net.URL;
import java.util.List;

public class ResultadoActivity extends Activity
{

    PreAluguelDTO preAluguelDto;
    TextView txtCpfCliente;
    TextView txtNomeCliente;
    TextView txtTelefoneCliente;
    TextView txtIdOperador;
    PreAluguel preAlugzuel;
    ListView listViewProdutoPreAluguel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_resultado);
        preAluguelDto = new PreAluguelDTO();
        txtNomeCliente = (TextView) findViewById(R.id.txtNomeConsultarPreAluguel);
        txtCpfCliente = (TextView) findViewById(R.id.txtCpfConsultarPreAluguel);
        txtTelefoneCliente = (TextView) findViewById(R.id.txtTelefoneConsultarPreAluguel);
        listViewProdutoPreAluguel = (ListView) findViewById(R.id.listViewProdutosConsultar);

        txtNomeCliente.setText("Nome: " + ConsultarActivity.preAluguel.getCliente().getNome() + " " + ConsultarActivity.preAluguel.getCliente().getSobrenome());
        txtCpfCliente.setText("CPF: " + ConsultarActivity.preAluguel.getCliente().getCpf());
        txtTelefoneCliente.setText("Telefone: " + ConsultarActivity.preAluguel.getCliente().getTelefone());
        List<Produto> produtos =(List<Produto>) ConsultarActivity.preAluguel.getListaProdutos();
        adicionarNaListView(produtos);

    }


    public void adicionarNaListView(List<Produto> produtos)
    {
        ProdutoAdapter ProdutoAdapter = new ProdutoAdapter(ResultadoActivity.this, R.layout.lista_produto, produtos);
        listViewProdutoPreAluguel.setAdapter(ProdutoAdapter);
    }
}
