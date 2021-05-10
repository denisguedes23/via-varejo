package br.com.varejo.api.cadastro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.varejo.api.cadastro.generico.controller.GenericBaseController;
import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.service.ProdutoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/produto")
@Api("Produto")
public class ProdutoController extends GenericBaseController<ProdutoService, Produto, Long> {
	
}
