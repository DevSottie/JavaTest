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
	private double peso;
	
	@NotNull
	@NotBlank
	private String nomeDestinatario;

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

}
