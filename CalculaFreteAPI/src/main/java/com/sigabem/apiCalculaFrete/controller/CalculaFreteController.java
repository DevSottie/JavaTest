package com.sigabem.apiCalculaFrete.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
@ResponseBody
@RequestMapping("/api/v1/calculafrete")
@Tag(name = "Cotações", description = "Endpoint que realiza a cotação do frete e prazo de entrega")
public class CalculaFreteController {
	
	@Autowired
	private CalculaFreteService calculaFreteService;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@PostMapping
	@Operation(
			summary = "Faz a consulta do falor de frete e prazo de envio e salva no banco de dados",
			tags = {"Cotações"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoResponseDto.class))
							),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
				}
			)
	public ResponseEntity<CotacaoResponseDto> mostraCotacao(@RequestBody @Valid CotacaoRequestDto cotacaoRequest){
		ViaCepResponseDto cepValidadoOrigem = viaCepService.consultaCep(cotacaoRequest.getCepOrigem());
		ViaCepResponseDto cepValidadoDestino = viaCepService.consultaCep(cotacaoRequest.getCepDestino());
		
		CotacaoResponseDto cotacaoResponse = calculaFreteService.calculaFrete(cepValidadoOrigem, cepValidadoDestino, cotacaoRequest);
		
		return ResponseEntity.ok().body(cotacaoResponse);
	}
	
	@GetMapping
	@Operation(
			summary = "Lista todas as cotações",
			tags = {"Cotações"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoResponseDto.class))
							),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
				}
		)
	public ResponseEntity<List<Cotacao>> buscaCotacoes(){
		List<Cotacao> cotacoes = calculaFreteService.buscaCotacoes();
		return ResponseEntity.ok().body(cotacoes);
	}

}
