package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.PreAluguel;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class PreAluguelDTO extends BaseDTO<PreAluguel>
{

    /* Construtores da classe */
    public PreAluguelDTO()
    {
        super();
    }

    public PreAluguelDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, PreAluguel pPreAluguel)
    {
        super(pOk, pMensagem, pPreAluguel);
    }

    public PreAluguelDTO(boolean pOk, String pMensagem, List<PreAluguel> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public PreAluguel getPreAluguel()
    {
        return getObjeto();
    }

    public void setPreAluguel(PreAluguel pPreAluguel)
    {
        setObjeto(pPreAluguel);
    }


}
