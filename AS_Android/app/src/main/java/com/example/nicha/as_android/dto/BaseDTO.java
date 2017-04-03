package com.example.nicha.as_android.dto;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public abstract class BaseDTO<T> {
    /* Atributos normais */
    private boolean ok;
    private String mensagem;
    private T objeto;
    private List<T> lista;

    /* Construtores da classe */
    public BaseDTO() {
        super();
    }

    public BaseDTO(boolean pOk, String pMensagem) {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public BaseDTO(boolean pOk, String pMensagem, T pObjeto) {
        super();
        ok = pOk;
        mensagem = pMensagem;
        objeto = pObjeto;
    }

    public BaseDTO(boolean pOk, String pMensagem, List<T> pLista) {
        super();
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    /* Métodos de acesso */
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

    protected T getObjeto() {
        return objeto;
    }

    protected void setObjeto(T pT) {
        objeto = pT;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> pLista) {
        lista = pLista;
    }
}
