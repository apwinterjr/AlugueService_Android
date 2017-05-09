package com.example.nicha.as_android.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class PreAluguel {


    /*
     * Variáveis de instância
     */

    private int                 idPreAluguel;
    private int            operadorCriador;
    private Cliente             cliente;
    private Configuracao        configuracao;
    private long                dataPrevista;
    private int                 statusPreAluguel;
    private float               valorAluguel;
    private List<Produto> listaProdutos = new ArrayList<Produto>();

    /*
     * Função construtora
     */
    public PreAluguel()
    {

    }

    /*
     * Métodos de acesso
     */
    /**
     * @return the idPreAluguel
     */

    public int getIdPreAluguel()
    {
        return idPreAluguel;
    }

    /**
     * @param pIdPreAluguel
     *            the idPreAluguel to set
     */
    public void setIdPreAluguel(int pIdPreAluguel)
    {
        idPreAluguel = pIdPreAluguel;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente()
    {
        return cliente;
    }

    /**
     * @param pCliente
     *            the cliente to set
     */
    public void setCliente(Cliente pCliente)
    {
        cliente = pCliente;
    }

    /**
     * @return the configuracao
     */

    public Configuracao getConfiguracao()
    {
        return configuracao;
    }

    /**
     * @param pConfiguracao
     *            the configuracao to set
     */
    public void setConfiguracao(Configuracao pConfiguracao)
    {
        configuracao = pConfiguracao;
    }

    /**
     * @return the dataPrevista
     */

    public long getDataPrevista()
    {
        return dataPrevista;
    }

    /**
     * @param pDataPrevista
     *            the dataPrevista to set
     */
    public void setDataPrevista(long pDataPrevista)
    {
        dataPrevista = pDataPrevista;
    }

    /**
     * @return the statusPreAluguel
     */

    public int getStatusPreAluguel()
    {
        return statusPreAluguel;
    }

    /**
     * @param pStatusPreAluguel
     *            the statusPreAluguel to set
     */
    public void setStatusPreAluguel(int pStatusPreAluguel)
    {
        statusPreAluguel = pStatusPreAluguel;
    }

    /**
     * @return the valorAluguel
     */

    public float getValorAluguel()
    {
        return valorAluguel;
    }

    /**
     * @param pValorAluguel
     *            the valorAluguel to set
     */
    public void setValorAluguel(float pValorAluguel)
    {
        valorAluguel = pValorAluguel;
    }

    /**
     * @return the listaProdutos
     */
    public Collection<Produto> getListaProdutos()
    {
        return listaProdutos;
    }

    /**
     * @param pListaProdutos
     *            the listaProdutos to set
     */
    public void setListaProdutos(List<Produto> pListaProdutos)
    {
        listaProdutos = pListaProdutos;
    }

    /**
     * @return the operadorCriador
     */
    public int getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador
     *            the operadorCriador to set
     */
    public void setOperadorCriador(int pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }
}
