package com.sigabem.apiCalculaFrete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.apiCalculaFrete.dto.ViaCepRequestDto;
import com.sigabem.apiCalculaFrete.repository.ViaCepRepository;

@Service
public class ViaCepService {
	
	@Autowired
	private ViaCepRepository viaCepRepository;
	
	public ViaCepRequestDto consultaCep(String cep) {
		ViaCepRequestDto viaCepDto = consultaCep(cep);
		return viaCepDto;
	}
}
