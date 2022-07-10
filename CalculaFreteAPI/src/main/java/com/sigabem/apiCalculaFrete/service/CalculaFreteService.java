package com.sigabem.apiCalculaFrete.service;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.apiCalculaFrete.dto.CotacaoRequestDto;
import com.sigabem.apiCalculaFrete.dto.CotacaoResponseDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepRequestDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;
import com.sigabem.apiCalculaFrete.model.Cotacao;
import com.sigabem.apiCalculaFrete.parser.CotacaoParser;
import com.sigabem.apiCalculaFrete.repository.CalculaFreteRepository;

@Service
public class CalculaFreteService {
	
	@Autowired
	private CalculaFreteRepository calculaFreteRepository;
	
	public CotacaoResponseDto calculaFrete(ViaCepResponseDto cepValidadoOrigem, ViaCepResponseDto cepValidadoDestino, CotacaoRequestDto cotacaoRequest){
		CotacaoResponseDto cotacaoResponse = new CotacaoResponseDto();
		CotacaoParser parser = new CotacaoParser();
		Cotacao cotacao = new Cotacao();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar dataPrevistaEntrega = Calendar.getInstance();
		
		double vlTotalFrete = cotacaoRequest.getPeso();
		System.out.print(dataPrevistaEntrega);
		
		if(cepValidadoOrigem.getUf().equals(cepValidadoDestino.getUf()) && !cepValidadoOrigem.getDdd().equals(cepValidadoDestino.getDdd())) {
			vlTotalFrete = vlTotalFrete * 0.25;
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 3);
			//dataPrevistaEntrega = dataPrevistaEntrega + " + 3 dias";
			
		} else if(cepValidadoOrigem.getDdd().equals(cepValidadoDestino.getDdd())) {
			vlTotalFrete = vlTotalFrete * 0.5;
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 1);
			//dataPrevistaEntrega = dataPrevistaEntrega + " + 1 dia";
		} else {
			dataPrevistaEntrega.add((GregorianCalendar.DAY_OF_MONTH), 10);
			//dataPrevistaEntrega = dataPrevistaEntrega + " + 10 dias";
		}
		
		cotacaoResponse = parser.requestToResponse(cepValidadoOrigem, cepValidadoDestino, vlTotalFrete, dataPrevistaEntrega);
		
		cotacao = parser.toModel(cotacaoRequest, cotacaoResponse, dataPrevistaEntrega);
		
		calculaFreteRepository.save(cotacao);
		
		return cotacaoResponse;
	}
	
}
