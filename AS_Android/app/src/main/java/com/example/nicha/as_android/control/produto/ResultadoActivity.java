package com.example.nicha.as_android.control.produto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nicha.as_android.R;

public class ResultadoActivity extends Activity
{

    TextView textIDConsultarProduto;
    TextView textNomeConsultarProduto;
    TextView txtPrecoConsultarProduto;
    TextView textTamanhoConsultarProduto;
    TextView textDescricaoConsultarProduto;
    TextView txtStatusConsultarProduto;
    Button compartilharProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_consulta_resultado);
        textIDConsultarProduto = (TextView) findViewById(R.id.textIDConsultarProduto);
        textNomeConsultarProduto = (TextView) findViewById(R.id.textNomeConsultarProduto);
        txtPrecoConsultarProduto = (TextView) findViewById(R.id.txtPrecoConsultarProduto);
        textTamanhoConsultarProduto = (TextView) findViewById(R.id.textTamanhoConsultarProduto);
        textDescricaoConsultarProduto = (TextView) findViewById(R.id.textDescricaoConsultarProduto);
        txtStatusConsultarProduto = (TextView) findViewById(R.id.txtStatusConsultarProduto);
        compartilharProduto = (Button) findViewById(R.id.btnCompartilharProduto);
        load();
    }

    public void compartilhar(View v)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "[" + ConsultarActivity.produtoSelecionado.getIdProduto() + "] " + ConsultarActivity.produtoSelecionado.getNome() + " - R$" + ConsultarActivity.produtoSelecionado.getValor() + ".");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void load()
    {
        textIDConsultarProduto.setText("ID: " + ConsultarActivity.produtoSelecionado.getIdProduto());
        textNomeConsultarProduto.setText("Nome: " + ConsultarActivity.produtoSelecionado.getNome());
        txtPrecoConsultarProduto.setText("Preço: " + ConsultarActivity.produtoSelecionado.getValor());
        textTamanhoConsultarProduto.setText("Tamanho: " + ConsultarActivity.produtoSelecionado.getTamanho());
        textDescricaoConsultarProduto.setText("Descrição: " + ConsultarActivity.produtoSelecionado.getDescricao());
        switch (ConsultarActivity.produtoSelecionado.getStatus())
        {
            case 0:
                txtStatusConsultarProduto.setText("Status: " + "Inativo");
                break;
            case 1:
                txtStatusConsultarProduto.setText("Status: " + "Ativo");
                break;
            case 2:
                txtStatusConsultarProduto.setText("Status: " + "Alugado");
                break;
            case 3:
                txtStatusConsultarProduto.setText("Status: " + "Pré-alugado");
                break;
            case 4:
                txtStatusConsultarProduto.setText("Status: " + "Manutenção");
                break;
            case 5:
                txtStatusConsultarProduto.setText("Status: " + "Lavagem");
        }
    }
}
