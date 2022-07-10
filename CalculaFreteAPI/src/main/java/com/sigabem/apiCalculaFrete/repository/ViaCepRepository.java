package com.sigabem.apiCalculaFrete.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.sigabem.apiCalculaFrete.dto.ViaCepRequestDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;

@Service
public class ViaCepRepository{
	
	public static ViaCepResponseDto consultaCep(String cep) throws Exception{
	
		 try {
	            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
	            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

	            if (conexao.getResponseCode() != 200)
	                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));

	            String output = "";
	            String line;
	            while ((line = resposta.readLine()) != null) {
	                output += line;
	            }

	            Gson gson = new Gson();
	            ViaCepResponseDto endereco = gson.fromJson(new String(output.getBytes()), ViaCepResponseDto.class);

	            return endereco;
	        } catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	
	}
}
