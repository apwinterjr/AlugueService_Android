package com.example.nicha.as_android.control.pre_aluguel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class SelecionarClienteActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_aluguel_selecionar_cliente);
        loadClientes();
    }

    private void loadClientes()
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
                ClienteDTO clienteDto = Json.convertJSONtoClienteDtoLista(s);
                if (clienteDto.isOk()){
                    ArrayAdapter<Cliente> clienteAdapter = new ClienteAdapter(SelecionarClienteActivity.this, R.layout.lista_produto,clienteDto.getLista());
                    ListView listViewProduto = (ListView) findViewById(R.id.listProdutos);
                    listViewProduto.setAdapter(clienteAdapter);
                }
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
    }
}
