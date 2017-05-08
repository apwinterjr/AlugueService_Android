package com.example.nicha.as_android.model;

import com.google.gson.Gson;

/**
 * Created by nicha on 03/04/2017.
 */

public class Cliente {

    /*
     * Variáveis de instância
     */


    private int      idCliente;
    private String   nome;
    private String   sobrenome;
    private String   cpf;
    private long     dataNascimento;
    private String   email;
    private String   telefone;
    private String   celular;
    private Endereco endereco;
    private int      status;
    private long     dataCriacao;
    private Integer  operadorCriador;

    /*
     * Função construtora
     */

    public Cliente()
    {

        endereco = new Endereco();
    }

    /*
     * Métodos de acesso
     */

    /**
     * Método get para idCliente
     *
     * @return idCliente
     */

    public int getIdCliente()
    {
        return idCliente;
    }

    /**
     * Método set para idCliente
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    /**
     * Método get para nome
     *
     * @return nome
     */

    public String getNome()
    {
        return nome;
    }

    /**
     * Método set para nome
     *
     * @param nome
     */

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Método get para sobrenome
     *
     * @return sobrenome
     */


    public String getSobrenome()
    {
        return sobrenome;
    }

    /**
     * Método set para sobrenome
     *
     * @param sobrenome
     */

    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    /**
     * Método get para telefone
     *
     * @return telefone
     */


    public String getTelefone()
    {
        return telefone;
    }

    /**
     * Método set para telefone
     *
     * @param telefone
     */

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    /**
     * Método get para celular
     *
     * @return celular
     */


    public String getCelular()
    {
        return celular;
    }

    /**
     * Método set para celular
     *
     * @param celular
     */

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    /**
     * Método get para cpf
     *
     * @return cpf
     */


    public String getCpf()
    {
        return cpf;
    }

    /**
     * Método set para cpf
     *
     * @param cpf
     */

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    /**
     * Método get para endereco
     *
     * @return endereco
     */


    public Endereco getEndereco()
    {
        return endereco;
    }

    /**
     * Método set para endereco
     *
     * @param endereco
     */

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    /**
     * Método get para status
     *
     * @return status
     */


    public int getStatus()
    {
        return status;
    }

    /**
     * Métodoset para status
     *
     * @param status
     */

    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * Método get para quantidadeCupom
     *
     * @return quantidadeCupom
     */

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador
     *            the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

    public long getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(long pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

    public long getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(long pDataCriacao)
    {
        dataCriacao = pDataCriacao;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    @Override
    public String toString()
    {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", celular=" + celular
                + ", cpf=" + cpf + ", endereco=" + endereco + ", status=" + status + "]";
    }

    public Cliente fromJson(String s){
        return new Gson().fromJson(s,Cliente.class);
    }

    public String toJson (Cliente c){
        return new Gson().toJson(c);
    }


}
