package com.example.nicha.as_android.model;

/**
 * Created by nicha on 03/04/2017.
 */

public class Endereco {


    /*
     * Variáveis de instância
     */

    private String rua;

    private String numero;

    private String cidade;

    private String cep;

    private String bairro;

    /*
     * Métodos de acesso
     */

    /**
     * Método get para rua
     *
     * @return rua
     */
    public String getRua()
    {
        return rua;
    }

    /**
     * Método set para rua
     *
     * @param rua
     */
    public void setRua(String rua)
    {
        this.rua = rua;
    }

    /**
     * Método get para numero
     *
     * @return numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * Método set para numero
     *
     * @param numero
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * Método get para cidade
     *
     * @return cidade
     */
    public String getCidade()
    {
        return cidade;
    }

    /**
     * Método set para cidade
     *
     * @param cidade
     */
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    /**
     * Método get para cep
     *
     * @return cep
     */
    public String getCep()
    {
        return cep;
    }

    /**
     * Método set para cep
     *
     * @param cep
     */
    public void setCep(String cep)
    {
        this.cep = cep;
    }

    /**
     * Método get para bairro
     *
     * @return bairro
     */
    public String getBairro()
    {
        return bairro;
    }

    /**
     * Método set para bairro
     *
     * @param bairro
     */
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

}
