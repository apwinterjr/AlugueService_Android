package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Produto;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class ProdutoDTO
{


    private boolean ok;
    private String mensagem;
    private Produto produto;
    private List<Produto> lista;

    /* Construtores da classe */
    public ProdutoDTO()
    {

    }

    public ProdutoDTO(boolean pOk, String pMensagem)
    {
        ok = pOk;
        mensagem = pMensagem;
    }

    public ProdutoDTO(boolean pOk, String pMensagem, Produto pProduto)
    {
        ok = pOk;
        mensagem = pMensagem;
        produto = pProduto;
    }

    public ProdutoDTO(boolean pOk, String pMensagem, List<Produto> pLista)
    {
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    /* Métodos de acesso */
    public Produto getProduto()
    {
        return produto;
    }

    public void setProduto(Produto pProduto)
    {
        produto = pProduto;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean pOk) {
        ok = pOk;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String pMensagem) {
        mensagem = pMensagem;
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> pLista) {
        lista = pLista;
    }


}
