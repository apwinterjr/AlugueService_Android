package com.example.nicha.as_android.Util;

import android.util.Log;

import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Produto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicha on 03/04/2017.
 */

public class Json
{

    public static String webToString(InputStream inputStream)
    {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null)
            {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return localString;
    }

    public static ProdutoDTO convertJSONtoProdutoDTOLista(String jsonFile) throws JSONException
    {
        ProdutoDTO prodDto = new ProdutoDTO();
        JSONObject localObj = new JSONObject(jsonFile);
        boolean ok = localObj.getBoolean("ok");
        String mensagem = localObj.getString("mensagem");
        JSONArray produtos = localObj.getJSONArray("lista");
        List<Produto> listaProduto = new ArrayList<Produto>();
        for (int j = 0; j < produtos.length(); j++)
        {
            JSONObject jsonObject = produtos.getJSONObject(j);
            Produto produto = new Produto();
            produto.setIdProduto(jsonObject.getInt("idProduto"));
            produto.setNome(jsonObject.getString("nome"));
            produto.setValor((BigDecimal.valueOf(jsonObject.getDouble("valor")).floatValue()));
            produto.setTamanho(jsonObject.getString("tamanho"));
            produto.setGenero(jsonObject.getString("genero"));
            produto.setDescricao(jsonObject.getString("descricao"));
            produto.setStatus(jsonObject.getInt("status"));
            produto.setQuantidadeAluguel(jsonObject.getInt("quantidadeAluguel"));
            produto.setDiretorioImagem(jsonObject.getString("diretorioImagem"));
            produto.setDataCriacao(jsonObject.getLong("dataCriacao"));
            produto.setOperadorCriador(jsonObject.getInt("operadorCriador"));
            listaProduto.add(produto);
        }
        prodDto.setOk(ok);
        prodDto.setMensagem(mensagem);
        prodDto.setLista(listaProduto);
        return prodDto;
    }


    public static String conexaoJsonGet(URL url)
    {
        HttpURLConnection urlConnection = null;
        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            String result = webToString(urlConnection.getInputStream());
            return result;
        } catch (Exception e)
        {
            Log.e("Error", "Error ", e);
            return null;
        } finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
        }

    }
}
