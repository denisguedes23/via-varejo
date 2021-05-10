package br.com.varejo.api.cadastro.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.model.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {

	public Page<Produto> pesquisar(ProdutoFilter filtro, Pageable pageable);

}
