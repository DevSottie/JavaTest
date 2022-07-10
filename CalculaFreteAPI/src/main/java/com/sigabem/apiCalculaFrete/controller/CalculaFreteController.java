package com.sigabem.apiCalculaFrete.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sigabem.apiCalculaFrete.dto.CotacaoRequestDto;
import com.sigabem.apiCalculaFrete.dto.CotacaoResponseDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepRequestDto;
import com.sigabem.apiCalculaFrete.dto.ViaCepResponseDto;
import com.sigabem.apiCalculaFrete.model.Cotacao;
import com.sigabem.apiCalculaFrete.service.CalculaFreteService;
import com.sigabem.apiCalculaFrete.service.ViaCepService;

@Controller
@ResponseBody
@RequestMapping("/api/v1/calculafrete")
public class CalculaFreteController {
	
	@Autowired
	private CalculaFreteService calculaFreteService;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@PostMapping
	public ResponseEntity<CotacaoResponseDto> mostraCotacao(@RequestBody @Valid CotacaoRequestDto cotacaoRequest){
		ViaCepResponseDto cepValidado = ;  
		CotacaoResponseDto cotacaoResponse = new CotacaoResponseDto();
		return ResponseEntity.ok().body(cotacaoResponse);
	}

}
