package com.example.nicha.as_android.dto;

import com.example.nicha.as_android.model.Configuracao;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by nicha on 06/05/2017.
 */
public class ConfiguracaoDTO extends BaseDTO<Configuracao>
{

    /* Construtores da classe */
    public ConfiguracaoDTO()
    {
        super();
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem, Configuracao pConfiguracao)
    {
        super(pOk, pMensagem, pConfiguracao);
    }

    public ConfiguracaoDTO(boolean pOk, String pMensagem, List<Configuracao> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    public ConfiguracaoDTO fromJson(String s){
        Configuracao configuracao = new Configuracao();
        boolean ok = false;
        String mensagem = "";
        try
        {
            JSONObject localObj = new JSONObject(s);
            ok = localObj.getBoolean("ok");
            mensagem = localObj.getString("mensagem");
            JSONObject configuracaoJson = localObj.getJSONObject("configuracao");
            configuracao.setIdConfiguracao(configuracaoJson.getInt("idConfiguracao"));
            configuracao.setMulta(Float.valueOf(configuracaoJson.getString("multa")));
            configuracao.setCupom(Float.valueOf(configuracaoJson.getString("cupom")));
            configuracao.setContrato(configuracaoJson.getString("contrato"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return new ConfiguracaoDTO(ok,mensagem,configuracao);
    }

    /* Métodos de acesso */
    public Configuracao getConfiguracao()
    {
        return getObjeto();
    }

    public void setConfiguracao(Configuracao pConfiguracao)
    {
        setObjeto(pConfiguracao);
    }

}

