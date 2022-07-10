package com.sigabem.apiCalculaFrete.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CotacaoRequestDto {
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 9)
	private String cepOrigem;
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 9)
	private String cepDestino;
	
	@NotNull
	@NotBlank
	private double peso;
	
	@NotNull
	@NotBlank
	private String nomeDestinatario;

}
