package br.com.varejo.api.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.repository.query.ProdutoRepositoryQuery;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {
	
	public Produto findByNome(String nome);
	
	public Optional<Produto> findByCodigo(String codigo);
}
