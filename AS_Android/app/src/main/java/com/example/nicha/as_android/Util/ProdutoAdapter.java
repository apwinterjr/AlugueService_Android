package com.example.nicha.as_android.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nicha.as_android.R;
import com.example.nicha.as_android.model.Produto;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto>
{
    private List<Produto> produtos;
    private int layout;

    public ProdutoAdapter(Context context, int resource, List<Produto> produtos){
        super(context,resource,produtos);
        this.produtos = produtos;
        layout = resource;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        View localView = contentView;

        if(localView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout,null);
        }

        Produto produto = produtos.get(position);

        if(produto != null){
            TextView txtNome = (TextView) localView.findViewById(R.id.txtNomeProduto);
            TextView txtValor = (TextView) localView.findViewById(R.id.txtValorProduto);
            TextView txtId = (TextView) localView.findViewById(R.id.txtIdLista);

            if(txtNome != null){
                txtNome.setText(produto.getNome());
            }
            if(txtValor != null){
                txtValor.setText(produto.getValor().toString());
            }
            if (txtId != null){
                txtId.setText(produto.getIdProduto());
            }
        }
        return localView;
    }
}
