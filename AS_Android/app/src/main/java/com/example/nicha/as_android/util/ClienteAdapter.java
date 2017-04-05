package com.example.nicha.as_android.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.model.Cliente;
import com.example.nicha.as_android.model.Produto;

import java.util.List;

/**
 * Created by nicha on 04/04/2017.
 */

public class ClienteAdapter extends ArrayAdapter<Cliente>
{
    private List<Cliente> clientes;
    private int layout;

    public ClienteAdapter(Context context, int resource, List<Cliente> clientes)
    {
        super(context, resource, clientes);
        this.clientes = clientes;
        layout = resource;
    }


    public View getView(int position, View contentView, ViewGroup parent)
    {
        View localView = contentView;

        if (localView == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout, null);
        }

        Cliente cliente = clientes.get(position);

        if (cliente != null)
        {
            TextView txtNome = (TextView) localView.findViewById(R.id.txtNomeProduto);
            TextView txtValor = (TextView) localView.findViewById(R.id.txtValorProduto);
            TextView txtId = (TextView) localView.findViewById(R.id.txtIdLista);

            if (txtNome != null)
            {
                txtNome.setText(cliente.getNome());
            }
            if (txtValor != null)
            {
                txtValor.setText(cliente.getCpf().toString());
            }
            if (txtId != null){
                txtId.setText(cliente.getIdCliente());
            }
        }
        return localView;
    }


}
