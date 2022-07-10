package com.sigabem.apiCalculaFrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigabem.apiCalculaFrete.model.Cotacao;

public interface CalculaFreteRepository extends JpaRepository<Cotacao, Long>{

}
