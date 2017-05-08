package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Operador;
import com.example.nicha.as_android.model.PreAluguel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;


<<<<<<< HEAD

=======
>>>>>>> 30bc2b7588451301fd8aaaac6daa9bc0481a9b33
public class PreAluguelDTO extends BaseDTO<PreAluguel> implements Serializable
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



    /* Método de conversão*/

    public String toJson(PreAluguelDTO preAluguelDTO)
    {
        return new Gson().toJson(preAluguelDTO);
    }
}
