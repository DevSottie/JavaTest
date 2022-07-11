package com.sigabem.apiCalculaFrete.service;

import org.springframework.stereotype.Service;

import com.sigabem.apiCalculaFrete.dto.ViaCepDto;
import com.sigabem.apiCalculaFrete.repository.ViaCepRepository;

@Service
public class ViaCepService {
	
	public ViaCepDto consultaCep(String cep){
		ViaCepDto viaCepDto = ViaCepRepository.consultaCep(cep);
		return viaCepDto;
	}
}
