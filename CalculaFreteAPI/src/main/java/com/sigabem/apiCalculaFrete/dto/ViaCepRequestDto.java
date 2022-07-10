package com.sigabem.apiCalculaFrete.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ViaCepRequestDto {
	
	@NotBlank
	@NotNull
	private String cep;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
