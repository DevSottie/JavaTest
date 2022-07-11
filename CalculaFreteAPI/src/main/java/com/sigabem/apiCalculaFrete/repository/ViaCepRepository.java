package com.sigabem.apiCalculaFrete.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sigabem.apiCalculaFrete.dto.ViaCepDto;

@Repository
public class ViaCepRepository{
	
	public static ViaCepDto consultaCep(String cep){
		
		RestTemplate restTemplate = new RestTemplate();
		ViaCepDto cepValidado = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", ViaCepDto.class);
		
		return cepValidado;
	}
}
