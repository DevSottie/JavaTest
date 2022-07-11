package com.sigabem.apiCalculaFrete.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.apiCalculaFrete.dto.CotacaoRequestDto;
import com.sigabem.apiCalculaFrete.dto.CotacaoResponseDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepDto;
import com.sigabem.apiCalculaFrete.model.Cotacao;
import com.sigabem.apiCalculaFrete.parser.CotacaoParser;
import com.sigabem.apiCalculaFrete.repository.CalculaFreteRepository;

@Service
public class CalculaFreteService {
	
	@Autowired
	private CalculaFreteRepository calculaFreteRepository;
	
	public List<Cotacao> buscaCotacoes(){
		return calculaFreteRepository.findAll().stream().toList();
	}
	
	public CotacaoResponseDto calculaFrete(ViaCepDto cepValidadoOrigem, ViaCepDto cepValidadoDestino, CotacaoRequestDto cotacaoRequest){
		CotacaoResponseDto cotacaoResponse = new CotacaoResponseDto();
		CotacaoParser parser = new CotacaoParser();
		Cotacao cotacao = new Cotacao();
		Calendar dataPrevistaEntrega = Calendar.getInstance();
		
		double vlTotalFrete = cotacaoRequest.getPeso();
		System.out.print(dataPrevistaEntrega);
		
		if(cepValidadoOrigem.getUf().equals(cepValidadoDestino.getUf()) && !cepValidadoOrigem.getDdd().equals(cepValidadoDestino.getDdd())) {
			vlTotalFrete = vlTotalFrete * 0.25;
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 3);
			
		} else if(cepValidadoOrigem.getDdd().equals(cepValidadoDestino.getDdd())) {
			vlTotalFrete = vlTotalFrete * 0.5;
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 1);
		} else {
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 10);
		}
		
		cotacaoResponse = parser.requestToResponse(cepValidadoOrigem, cepValidadoDestino, vlTotalFrete, dataPrevistaEntrega);
		
		cotacao = parser.toModel(cotacaoRequest, cotacaoResponse, dataPrevistaEntrega);
		
		calculaFreteRepository.save(cotacao);
		
		return cotacaoResponse;
	}
	
}
