package com.example.nicha.as_android.model;

/**
 * Created by nicha on 03/04/2017.
 */

public class Configuracao {

    /*
     * Variáveis de instância
     */

    private Integer idConfiguracao;
    private Float multa;
    private Float cupom;
    private String contrato;

	/*
	 * Função construtora
	 */

    public Configuracao() {

    }

	/*
	 * Métodos de acesso
	 */

    /**
     * Método get para idConf
     *
     * @return idConf
     */

    public Integer getIdConfiguracao() {
        return idConfiguracao;
    }

    /**
     * Método set para idConf
     *
     * @param idConf
     */
    public void setIdConfiguracao(Integer idConfiguracao) {
        this.idConfiguracao = idConfiguracao;
    }

    /**
     * Método get para multa
     *
     * @return multa
     */

    public Float getMulta() {
        return multa;
    }

    /**
     * Método set para multa
     *
     * @param multa
     */
    public void setMulta(Float multa) {
        this.multa = multa;
    }

    /**
     * Método get para cupom
     *
     * @return cupom
     */

    public Float getCupom() {
        return cupom;
    }

    /**
     * Método set para cupom
     *
     * @param cupom
     */
    public void setCupom(Float cupom) {
        this.cupom = cupom;
    }

    /**
     * @return the contrato
     */

    public String getContrato()
    {
        return contrato;
    }

    /**
     * @param pContrato the contrato to set
     */
    public void setContrato(String pContrato)
    {
        contrato = pContrato;
    }

}
