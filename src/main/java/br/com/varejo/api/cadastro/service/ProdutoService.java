package br.com.varejo.api.cadastro.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.varejo.api.cadastro.generico.service.GenericBaseService;
import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.model.filter.ProdutoFilter;
import br.com.varejo.api.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoService extends GenericBaseService<ProdutoRepository, Produto, Long>{
	
	public Page<Produto> pesquisar(ProdutoFilter filtro, Pageable pageable) {
		return repositorio.pesquisar(filtro, pageable);
	}
	
	public Produto buscarPorNome(String nome) {
		return repositorio.findByNome(nome);
	}
	
	public Optional<Produto> buscarPorCodigo(String codigo){
		return repositorio.findByCodigo(codigo);
	}
	
}
