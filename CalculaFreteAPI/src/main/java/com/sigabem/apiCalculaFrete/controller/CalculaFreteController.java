package com.sigabem.apiCalculaFrete.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sigabem.apiCalculaFrete.dto.CotacaoRequestDto;
import com.sigabem.apiCalculaFrete.dto.CotacaoResponseDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;
import com.sigabem.apiCalculaFrete.model.Cotacao;
import com.sigabem.apiCalculaFrete.service.CalculaFreteService;
import com.sigabem.apiCalculaFrete.service.ViaCepService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@ResponseBody
@RequestMapping("/api/v1/calculafrete")
@Api(value = "API REST Calcula Frete")
@CrossOrigin(origins="*")
public class CalculaFreteController {
	
	@Autowired
	private CalculaFreteService calculaFreteService;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@PostMapping
	@ApiOperation(value = "Retorna o valor total do frete, data de entrega e ceps de origem e destino")
	public ResponseEntity<CotacaoResponseDto> mostraCotacao(@RequestBody @Valid CotacaoRequestDto cotacaoRequest){
		ViaCepResponseDto cepValidadoOrigem = viaCepService.consultaCep(cotacaoRequest.getCepOrigem());
		ViaCepResponseDto cepValidadoDestino = viaCepService.consultaCep(cotacaoRequest.getCepDestino());
		
		CotacaoResponseDto cotacaoResponse = calculaFreteService.calculaFrete(cepValidadoOrigem, cepValidadoDestino, cotacaoRequest);
		
		return ResponseEntity.ok().body(cotacaoResponse);
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna a lista de todas as cotacoes já feitas e as datas em que foram consultadas")
	public ResponseEntity<List<Cotacao>> buscaCotacoes(){
		List<Cotacao> cotacoes = calculaFreteService.buscaCotacoes();
		return ResponseEntity.ok().body(cotacoes);
	}

}
