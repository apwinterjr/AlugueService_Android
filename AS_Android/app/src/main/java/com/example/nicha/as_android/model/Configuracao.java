package com.example.nicha.as_android.model;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.nicha.as_android.control.pre_aluguel.CriarActivity;
import com.example.nicha.as_android.dto.ConfiguracaoDTO;
import com.example.nicha.as_android.dto.PreAluguelDTO;
import com.example.nicha.as_android.util.Json;
import com.example.nicha.as_android.util.Util;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

/**
 * Created by nicha on 03/04/2017.
 */

public class Configuracao
{

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

    public Configuracao()
    {

    }

    public void pesquisarUltimo()
    {
        new Download().execute();
    }

    private class Download extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            String resultado = null;

            try
            {
                URL url = new URL(Util.URL_WS + "Configuracao/PesquisarUltimo");
                resultado = Json.recuperar(url);

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return resultado;
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            ConfiguracaoDTO configuracaoDTO = new ConfiguracaoDTO();
            configuracaoDTO = configuracaoDTO.fromJson(s);
            if (configuracaoDTO.isOk())
            {
                multa = configuracaoDTO.getConfiguracao().getMulta();
                cupom = configuracaoDTO.getConfiguracao().getCupom();
                contrato = configuracaoDTO.getConfiguracao().getContrato();
                idConfiguracao = configuracaoDTO.getConfiguracao().getIdConfiguracao();

            }
        }
    }



	/*
	 * Métodos de acesso
	 */

    /**
     * Método get para idConf
     *
     * @return idConf
     */

    public Integer getIdConfiguracao()
    {
        return idConfiguracao;
    }

    /**
     * Método set para idConf
     *
     *
     */
    public void setIdConfiguracao(Integer idConfiguracao)
    {
        this.idConfiguracao = idConfiguracao;
    }

    /**
     * Método get para multa
     *
     * @return multa
     */

    public Float getMulta()
    {
        return multa;
    }

    /**
     * Método set para multa
     *
     * @param multa
     */
    public void setMulta(Float multa)
    {
        this.multa = multa;
    }

    /**
     * Método get para cupom
     *
     * @return cupom
     */

    public Float getCupom()
    {
        return cupom;
    }

    /**
     * Método set para cupom
     *
     * @param cupom
     */
    public void setCupom(Float cupom)
    {
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


    public Configuracao fromJson(String s){
        return new Gson().fromJson(s,Configuracao.class);
    }

    public String toJson (Configuracao c){
        return new Gson().toJson(c);
    }
}
