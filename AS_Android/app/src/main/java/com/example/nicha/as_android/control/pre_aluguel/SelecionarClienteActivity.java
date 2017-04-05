package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.dto.ClienteDTO;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Cliente;
import com.example.nicha.as_android.model.Produto;
import com.example.nicha.as_android.util.ClienteAdapter;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.ProdutoAdapter;

import org.json.JSONException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SelecionarClienteActivity extends Activity
{

    List<Cliente> listaCliente = new ArrayList<Cliente>();
    ListView listViewCliente;
    ClienteDTO clienteDto;
    ArrayAdapter<Cliente> clienteAdapter;
    EditText txtPesquisa;
    Cliente clienteSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_selecionar_cliente);
        listViewCliente = (ListView) findViewById(R.id.listCliente);
        txtPesquisa = (EditText) findViewById(R.id.editTxtPesquisarCliente);
        clienteDto = new ClienteDTO();
        loadClientes();
        listViewCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // TODO: 04/04/2017 Debuggar a seleção de item;
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        clienteSelecionado = new Cliente();
                        TextView itemSelecionado = (TextView) view.findViewById(R.id.txtIdLista);
                        clienteSelecionado.setIdCliente(Integer.parseInt(itemSelecionado.getText().toString()));

                        for (Cliente c : clienteDto.getLista())
                        {
                            if (c.getIdCliente() == clienteSelecionado.getIdCliente())
                            {
                                clienteSelecionado = c;
                                Toast.makeText(SelecionarClienteActivity.this, clienteSelecionado.getNome() + " " + clienteSelecionado.getSobrenome(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                }
        );
    }



        private void loadClientes ()
        {
            new DownloadFromWS().execute();
        }

    public void pesquisarCliente(View v)
    {
        String s = txtPesquisa.getText().toString().toLowerCase().trim();
        if (!s.isEmpty())
        {
            List<Cliente> listaFiltrada = new ArrayList<Cliente>();
            if (listaCliente == null)
            {
                loadClientes();
            }
            for (Cliente cliente : listaCliente
                    )
            {
                if (cliente.getNome().toLowerCase().contains(s) || cliente.getSobrenome().toLowerCase().contains(s) || cliente.getCpf().contains(s))
                {
                    listaFiltrada.add(cliente);
                }
            }
            if (listaFiltrada.size() != 0)
            {
                adicionarNaLista(listaFiltrada);
            }
        } else
        {
            adicionarNaLista(listaCliente);
        }
    }

    public void adicionarNaLista(List<Cliente> clientes)
    {
        clienteAdapter = new ClienteAdapter(SelecionarClienteActivity.this, R.layout.lista_produto, clientes);
        listViewCliente.setAdapter(clienteAdapter);
    }

    private class DownloadFromWS extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            String resultado = null;

            try
            {
                URL url = new URL("http://10.0.2.2:9999/AlugueServiceWS/WS/Cliente/Pesquisar");
                resultado = Json.conexaoJsonGet(url);

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return resultado;
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            try
            {
                clienteDto = Json.convertJSONtoClienteDtoLista(s);
                if (clienteDto.isOk())
                {
                    adicionarNaLista(clienteDto.getLista());
                    listaCliente = clienteDto.getLista();
                }
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
    }
}
