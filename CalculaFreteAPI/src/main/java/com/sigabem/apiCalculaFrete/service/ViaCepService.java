package com.sigabem.apiCalculaFrete.service;

import org.springframework.stereotype.Service;

import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;
import com.sigabem.apiCalculaFrete.repository.ViaCepRepository;

@Service
public class ViaCepService {
	
	public ViaCepResponseDto consultaCep(String cep){
		ViaCepResponseDto viaCepDto = ViaCepRepository.consultaCep(cep);
		return viaCepDto;
	}
}
