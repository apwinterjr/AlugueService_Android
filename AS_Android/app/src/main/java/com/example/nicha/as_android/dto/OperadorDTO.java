package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Operador;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class OperadorDTO extends BaseDTO<Operador>
{
    @Override
    public String toString()
    {
        return "OperadorDTO [isOk()=" + isOk() + ", getMensagem()=" + getMensagem() + "]";
    }

    /* Construtores da classe */
    public OperadorDTO()
    {
        super();
    }

    public OperadorDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public OperadorDTO(boolean pOk, String pMensagem, Operador pOperador)
    {
        super(pOk, pMensagem, pOperador);
    }

    public OperadorDTO(boolean pOk, String pMensagem, List<Operador> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Operador getOperador()
    {
        return getObjeto();
    }

    public void setOperador(Operador pOperador)
    {
        setObjeto(pOperador);
    }
}
