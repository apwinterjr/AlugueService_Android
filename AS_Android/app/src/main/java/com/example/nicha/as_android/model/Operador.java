package com.example.nicha.as_android.model;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class Operador
{

    /*
     * Variáveis de instância
     */
    private int idOperador;
    private String nome;
    private String sobrenome;
    private String cpf;
    private long dataNascimento;
    private String email;
    private String telefone;
    private String celular;
    private Endereco endereco;
    private int status;
    private String login;
    private String senha;
    private int nivel;
    private long dataCriacao;
    private int operadorCriador;

    /*
     * Função construtora
     */

    public Operador()
    {

    }

    /*
     * Métodos de acesso
     */

    /**
     * Método get para idOperador
     *
     * @return idOperador
     */

    public int getIdOperador()
    {
        return idOperador;
    }

    /**
     * Método set para idOperador
     *
     * @param idOperador
     */
    public void setIdOperador(int idOperador)
    {
        this.idOperador = idOperador;
    }

    /**
     * Método get para senha
     *
     * @return senha
     */

    public String getSenha()
    {
        return senha;
    }

    /**
     * Método set para senha
     *
     * @param senha
     */
    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    /**
     * Método get para nivel
     *
     * @return nivel
     */

    public int getNivel()
    {
        return nivel;
    }

    /**
     * Método set para nivel
     *
     * @param nivel
     */
    public void setNivel(int nivel)
    {
        this.nivel = nivel;
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
     * Método set para status
     *
     * @param status
     */

    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * @return the dataNascimento
     */
    public long getDataNascimento()
    {
        return dataNascimento;
    }

    /**
     * @param pDataNascimento the dataNascimento to set
     */
    public void setDataNascimento(long pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param pEmail the email to set
     */
    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    /**
     * @return the login
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * @param pLogin the login to set
     */
    public void setLogin(String pLogin)
    {
        login = pLogin;
    }

    /**
     * @return the dataCriacao
     */
    public long getDataCriacao()
    {
        return dataCriacao;
    }

    /**
     * @param pDataCriacao the dataCriacao to set
     */
    public void setDataCriacao(long pDataCriacao)
    {
        dataCriacao = pDataCriacao;
    }

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + idOperador;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Operador other = (Operador) obj;
        if (idOperador != other.idOperador)
            return false;
        return true;
    }


    public Operador fromJson(String s)
    {
        return new Gson().fromJson(s, Operador.class);
    }

    public String toJson(Operador o)
    {
        return new Gson().toJson(o);
    }
}
