package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Cliente;

import java.util.List;

/**
 * Created by nicha on 04/04/2017.
 */

public class ClienteDTO extends BaseDTO<Cliente>
{

    public ClienteDTO()
    {
        super();
    }

    public ClienteDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ClienteDTO(boolean pOk, String pMensagem, Cliente pCliente)
    {
        super(pOk, pMensagem, pCliente);
    }

    public ClienteDTO(boolean pOk, String pMensagem, List<Cliente> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Cliente getCliente()
    {
        return getObjeto();
    }

    public void setCliente(Cliente pCliente)
    {
        setObjeto(pCliente);
    }
}
