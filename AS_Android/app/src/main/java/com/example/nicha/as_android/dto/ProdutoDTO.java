package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Produto;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class ProdutoDTO extends BaseDTO<Produto>
{

    /* Construtores da classe */
    public ProdutoDTO()
    {
        super();
    }

    public ProdutoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, Produto pProduto)
    {
        super(pOk, pMensagem, pProduto);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, List<Produto> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Produto getProduto()
    {
        return getObjeto();
    }

    public void setProduto(Produto pProduto)
    {
        setObjeto(pProduto);
    }

}
