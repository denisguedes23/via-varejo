package br.com.varejo.api.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.varejo.api.cadastro.model.CondicaoPagamento;
import br.com.varejo.api.cadastro.repository.query.CondicaoPagamentoRepositorioQuery;

@Repository
public interface CondicaoPagamentoRepositorio extends JpaRepository<CondicaoPagamento, Long>, CondicaoPagamentoRepositorioQuery {
	
}
