package com.sigabem.apiCalculaFrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigabem.apiCalculaFrete.model.Cotacao;

@Repository
public interface CalculaFreteRepository extends JpaRepository<Cotacao, Long>{

}
