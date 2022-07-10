package com.sigabem.apiCalculaFrete.dto;

import java.util.Calendar;
import java.util.Date;

public class CotacaoResponseDto {

	private double vlTotalFrete;
	private String dataPrevistaEntrega;
	private String cepOrigem;
	private String cepDestino;
	
	
	public double getVlTotalFrete() {
		return vlTotalFrete;
	}
	public void setVlTotalFrete(double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}
	public String getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}
	public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
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
	
}
