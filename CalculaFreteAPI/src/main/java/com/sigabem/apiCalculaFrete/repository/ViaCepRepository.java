package com.sigabem.apiCalculaFrete.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;

@Repository
public class ViaCepRepository{
	
	public static ViaCepResponseDto consultaCep(String cep){
		
		RestTemplate restTemplate = new RestTemplate();
		ViaCepResponseDto cepValidado = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", ViaCepResponseDto.class);
		
		return cepValidado;
	}
}
