package com.sigabem.apiCalculaFrete.parser;

import java.text.DateFormat;
import java.util.Calendar;

import com.sigabem.apiCalculaFrete.dto.CotacaoRequestDto;
import com.sigabem.apiCalculaFrete.dto.CotacaoResponseDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;
import com.sigabem.apiCalculaFrete.model.Cotacao;

public class CotacaoParser {
	
	public CotacaoResponseDto requestToResponse(ViaCepResponseDto cepValidadoOrigem, ViaCepResponseDto cepValidadoDestino, double vlTotalFrete, Calendar dataPrevistaEntrega) {
		CotacaoResponseDto cotacaoResponseDto = new CotacaoResponseDto();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		cotacaoResponseDto.setCepDestino(cepValidadoDestino.getCep());
		cotacaoResponseDto.setCepOrigem(cepValidadoOrigem.getCep());
		cotacaoResponseDto.setDataPrevistaEntrega(dateFormat.format(dataPrevistaEntrega.getTime()));
		cotacaoResponseDto.setVlTotalFrete(vlTotalFrete);
		
		return cotacaoResponseDto;
	}
	
	public Cotacao toModel(CotacaoRequestDto cotacaoRequest, CotacaoResponseDto cotacaoResponse, Calendar dataPrevistaEntrega) {
		Cotacao cotacao = new Cotacao();
		
		cotacao.setDataConsulta(Calendar.getInstance());
		cotacao.setCepDestino(cotacaoResponse.getCepDestino());
		cotacao.setCepOrigem(cotacaoResponse.getCepOrigem());
		cotacao.setPeso(cotacaoRequest.getPeso());
		cotacao.setNomeDestinatario(cotacaoRequest.getNomeDestinatario());
		cotacao.setVlTotalFrete(cotacaoResponse.getVlTotalFrete());
		cotacao.setDataPrevistaEntrega(dataPrevistaEntrega);
		
		return cotacao;
	}
}
