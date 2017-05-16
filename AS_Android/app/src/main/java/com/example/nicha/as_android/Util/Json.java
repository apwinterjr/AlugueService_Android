package com.example.nicha.as_android.util;

import android.util.JsonWriter;
import android.util.Log;

import com.example.nicha.as_android.dto.OperadorDTO;
import com.example.nicha.as_android.dto.PreAluguelDTO;
import com.example.nicha.as_android.model.PreAluguel;
import com.google.gson.*;
import com.example.nicha.as_android.dto.ClienteDTO;
import com.example.nicha.as_android.dto.ProdutoDTO;
import com.example.nicha.as_android.model.Cliente;
import com.example.nicha.as_android.model.Endereco;
import com.example.nicha.as_android.model.Operador;
import com.example.nicha.as_android.model.Produto;
import com.google.gson.internal.Primitives;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by nicha on 03/04/2017.
 */

public class Json
{
    private static Gson g = new Gson();

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

    public static ClienteDTO convertJSONtoClienteDtoLista(String jsonFile) throws JSONException
    {
        ClienteDTO clienteDto = new ClienteDTO();
        JSONObject localObj = new JSONObject(jsonFile);
        boolean ok = localObj.getBoolean("ok");
        String mensagem = localObj.getString("mensagem");
        JSONArray clientes = localObj.getJSONArray("lista");
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        for (int j = 0; j < clientes.length(); j++)
        {
            JSONObject jsonObject = clientes.getJSONObject(j);
            JSONObject jsonObjectEndereco = jsonObject.getJSONObject("endereco");
            Cliente cliente = new Cliente();
            Endereco endereco = new Endereco();

            cliente.setIdCliente(jsonObject.getInt("idCliente"));
            cliente.setNome(jsonObject.getString("nome"));
            cliente.setSobrenome(jsonObject.getString("sobrenome"));
            cliente.setCpf(jsonObject.getString("cpf"));
            cliente.setDataNascimento(jsonObject.getLong("dataNascimento"));
            cliente.setEmail(jsonObject.getString("email"));
            cliente.setTelefone(jsonObject.getString("telefone"));
            cliente.setCelular(jsonObject.getString("celular"));
            cliente.setStatus(jsonObject.getInt("status"));
            cliente.setDataCriacao(jsonObject.getLong("dataCriacao"));
            cliente.setOperadorCriador(jsonObject.getInt("operadorCriador"));

            endereco.setRua(jsonObjectEndereco.getString("rua"));
            endereco.setNumero(jsonObjectEndereco.getString("numero"));
            endereco.setCidade(jsonObjectEndereco.getString("cidade"));
            endereco.setCep(jsonObjectEndereco.getString("cep"));
            endereco.setBairro(jsonObjectEndereco.getString("bairro"));

            cliente.setEndereco(endereco);
            listaCliente.add(cliente);
        }
        clienteDto.setOk(ok);
        clienteDto.setMensagem(mensagem);
        clienteDto.setLista(listaCliente);
        return clienteDto;
    }

    private static String getOperadorJson(Operador operador)
    {

        return g.toJson(operador);
    }

    public static OperadorDTO jsonToOperadorDTO(String s)
    {
        OperadorDTO operadorDTO = new OperadorDTO();
        JSONObject localObj = null;
        try
        {
            localObj = new JSONObject(s);
            boolean ok = localObj.getBoolean("ok");
            String mensagem = localObj.getString("mensagem");
            JSONObject operadorJson = localObj.getJSONObject("operador");
            Operador operador = new Operador();
            operador.setIdOperador(operadorJson.getInt("idOperador"));
            operador.setNome(operadorJson.getString("nome"));
            operador.setStatus(operadorJson.getInt("status"));
            operador.setDataCriacao(operadorJson.getLong("dataCriacao"));
            operador.setOperadorCriador(operadorJson.getInt("operadorCriador"));
            operador.setSobrenome(operadorJson.getString("sobrenome"));
            operador.setCpf(operadorJson.getString("cpf"));
            operador.setDataNascimento(operadorJson.getLong("dataNascimento"));
            operador.setEmail(operadorJson.getString("email"));
            operador.setTelefone(operadorJson.getString("telefone"));
            operador.setCelular(operadorJson.getString("celular"));
            operador.setStatus(operadorJson.getInt("status"));
            operador.setDataCriacao(operadorJson.getLong("dataCriacao"));
            operador.setOperadorCriador(operadorJson.getInt("operadorCriador"));
            operadorDTO.setOk(ok);
            operadorDTO.setMensagem(mensagem);
            operadorDTO.setOperador(operador);
            return operadorDTO;
        } catch (JSONException e)
        {
            e.printStackTrace();
            return new OperadorDTO(false, "Erro ao transformar json em objeto.");
        }

    }

    public static String conexaoJsonPostLogin(URL url, Operador operador) throws ProtocolException
    {


        HttpURLConnection urlConnection = null;

        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            //urlConnection.setReadTimeout(10000 /* milliseconds */);
            //urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestProperty("Content-Type",
                    "application/json");
            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            wr.write(getOperadorJson(operador));
            wr.flush();

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

    public static void alterarProduto(List<Produto> list, URL url)
    {
        for (Produto p : list)
        {
            alterarProduto(p, url);
        }
    }

    public static String alterarProduto(Produto produto, URL url)
    {
        HttpURLConnection urlConnection = null;

        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("PUT");
            //urlConnection.setReadTimeout(10000 /* milliseconds */);
            //urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestProperty("Content-Type",
                    "application/json");
            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            wr.write(toJson(produto));
            wr.flush();

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

    public static PreAluguelDTO toPreAluguelDTO(String s)
    {
        return g.fromJson(s, PreAluguelDTO.class);
    }

    public static String toJson(Object obj)
    {
        return g.toJson(obj);
    }


    public static String recuperar(URL url)
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

    public static ProdutoDTO toProdutoDTO(String json)
    {
        return g.fromJson(json, ProdutoDTO.class);
    }


    public static String conexaoJsonPostPreAluguel(URL url, PreAluguel preAluguel) throws ProtocolException
    {


        HttpURLConnection urlConnection = null;

        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            //urlConnection.setReadTimeout(10000 /* milliseconds */);
            //urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestProperty("Content-Type",
                    "application/json");
            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            wr.write(toJson(preAluguel));
            wr.flush();

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

    public static PreAluguelDTO jsonToPreAlugueDTO(String s)
    {
        return g.fromJson(s, PreAluguelDTO.class);
    }


}

