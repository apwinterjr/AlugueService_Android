package com.example.nicha.as_android.model;

/**
 * Created by nicha on 03/04/2017.
 */

public class Produto {

	/*
	 * Variáveis de instância
	 */

    private Integer idProduto;
    private String nome;
    private Float valor;
    private String tamanho;
    private String genero;
    private String descricao;
    private Integer status;
    private Integer quantidadeAluguel;
    private String diretorioImagem;
    private long dataCriacao;
    private Integer operadorCriador;

	/*
	 * Função construtora
	 */

    public Produto() {

    }

	/*
	 * Métodos de acesso
	 */

    /**
     * Método get para idProduto
     *
     * @return idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * Método set para idProduto
     *
     * @param idProduto
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Método get para nome
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método set para nome
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método get para descricao
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método set para descricao
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    /**
     * Método get para valor
     *
     * @return valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * Método set para valor
     *
     * @param valor
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * Método get para status
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Método set para status
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Método get para tamanho
     *
     * @return tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Método set para tamanho
     *
     * @param tamanho
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Método get para genero
     *
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Método set para genero
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método get para genero
     *
     * @return genero
     */
    public long getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Método set para genero
     *
     * @param genero
     */
    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the quantidadeAluguel
     */
    public Integer getQuantidadeAluguel()
    {
        return quantidadeAluguel;
    }

    /**
     * @param pQuantidadeAluguel the quantidadeAluguel to set
     */
    public void setQuantidadeAluguel(Integer pQuantidadeAluguel)
    {
        quantidadeAluguel = pQuantidadeAluguel;
    }

    /**
     * @return the diretorioImagem
     */
    public String getDiretorioImagem()
    {
        return diretorioImagem;
    }

    /**
     * @param pDiretorioImagem the diretorioImagem to set
     */
    public void setDiretorioImagem(String pDiretorioImagem)
    {
        diretorioImagem = pDiretorioImagem;
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


}
