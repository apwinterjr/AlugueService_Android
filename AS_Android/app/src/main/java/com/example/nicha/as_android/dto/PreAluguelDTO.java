package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Operador;
import com.example.nicha.as_android.model.PreAluguel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class PreAluguelDTO
{
    private boolean ok;
    private String mensagem;
    private PreAluguel preAluguel;
    private List<PreAluguel> lista;

    /* Construtores da classe */
    public PreAluguelDTO() {

    }

    public PreAluguelDTO(boolean pOk, String pMensagem)
    {
        ok = pOk;
        mensagem = pMensagem;
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, PreAluguel pPreAluguel)
    {
        ok = pOk;
        mensagem = pMensagem;
        preAluguel = pPreAluguel;
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, List<PreAluguel> pLista)
    {
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    /* Métodos de acesso */
    public PreAluguel getPreAluguel()
    {
        return preAluguel;
    }

    public void setPreAluguel(PreAluguel pPreAluguel)
    {
        preAluguel = pPreAluguel;
    }



    /* Método de conversão*/
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

    public List<PreAluguel> getLista() {
        return lista;
    }

    public void setLista(List<PreAluguel> pLista) {
        lista = pLista;
    }

}
