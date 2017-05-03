package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.wdullaer.materialdatetimepicker.*;
import com.example.nicha.as_android.R;
import com.example.nicha.as_android.model.Cliente;
import com.example.nicha.as_android.model.PreAluguel;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.ProdutoAdapter;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CriarActivity extends Activity
{

    private static PreAluguel preAluguel;
    Calendar calendar = Calendar.getInstance();
    static Cliente clienteSelecionado;
    Produto produtoSelecionado;
    static List<Produto> listaProdutoSelecionado;
    static ListView listViewProdutoSelecionado;
    static TextView txtCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_criar);
        txtCliente = (TextView) findViewById(R.id.txtClienteCriarPreAluguel);
        preAluguel = new PreAluguel();
        listaProdutoSelecionado = new ArrayList<Produto>();
        clienteSelecionado = new Cliente();
        listViewProdutoSelecionado = (ListView) findViewById(R.id.listViewProdutoSelecionado);
        dialogData();
        listViewProdutoSelecionado.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                produtoSelecionado = new Produto();
                produtoSelecionado = (Produto) listViewProdutoSelecionado.getItemAtPosition(position);
                Toast.makeText(CriarActivity.this, produtoSelecionado.getNome() + " selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dialogData()
    {
        Button btn = (Button) findViewById(R.id.btnSelecionarData);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog dpd = new DatePickerDialog().newInstance(listner, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                Calendar dia;
                List<Calendar> diasAtivos = new ArrayList<>();


                for (int i = 1; i <= 30; i++  )
                {
                    dia = Calendar.getInstance();
                    dia.add(Calendar.DATE,i);
                    if(dia.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
                        diasAtivos.add(dia);

                    }
                }
                Calendar[] diasSelecionaveis = diasAtivos.toArray(new Calendar[diasAtivos.size()]);
                dpd.setSelectableDays(diasSelecionaveis);
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });
    }

    DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth)
        {
            TextView txtDataSelecionada = (TextView) findViewById(R.id.txtDataCriarPreAluguel);
            txtDataSelecionada.setText("Data: " + dayOfMonth + "/" + monthOfYear + "/" + year);
        }
    };


    public void adicionarProduto(View v)
    {
        Intent intent = new Intent(getApplicationContext(), SelecionarProdutoActivity.class);
        startActivityForResult(intent, 1);
    }

    public void selecionarCliente(View v)
    {
        Intent intent = new Intent(getApplicationContext(), SelecionarClienteActivity.class);
        startActivityForResult(intent, 2);
    }

    public void adicionarClientePreAluguel(Cliente cliente)
    {
        preAluguel.setCliente(cliente);
        txtCliente.setText("Cliente: " + cliente.getNome() + " "+ cliente.getSobrenome());

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
        ProdutoAdapter ProdutoAdapter = new ProdutoAdapter(CriarActivity.this, R.layout.lista_produto, produtos);
        listViewProdutoSelecionado.setAdapter(ProdutoAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                adicionarNaListView(listaProdutoSelecionado);
                Toast.makeText(this, "Produto adicionado.", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Produto já adicionado na lista.", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 2)
        {
            if (resultCode == RESULT_OK)
            {
                adicionarClientePreAluguel(clienteSelecionado);
                Toast.makeText(this,clienteSelecionado.getNome() + clienteSelecionado.getSobrenome() + " selecionado.", Toast.LENGTH_SHORT).show();

            }
        }


    }

}
