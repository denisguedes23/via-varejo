package br.com.varejo.api.cadastro.generico.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.varejo.api.cadastro.generico.model.IGenericBaseModel;
import br.com.varejo.api.cadastro.generico.service.IGenericBaseService;
import io.swagger.annotations.ApiOperation;

public class GenericBaseController<S extends IGenericBaseService<E, T>, E extends IGenericBaseModel, T> {

	@Autowired
	protected S servico;

	// Novo
	@PostMapping
	public ResponseEntity<?> novo(@Valid @RequestBody E entidade, HttpServletResponse response) {

		E novo = servico.incluir(entidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	}

	// Editar
	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody E entidade, HttpServletRequest request) {
		ResponseEntity<?> response = ResponseEntity.ok(servico.editar(entidade));
		return response;
	}

	// Remover
	@DeleteMapping("/{codigo}")
	public void excluir(@PathVariable T codigo) {
		servico.excluir(codigo);		
	}

	//Buscar por código
	@GetMapping("/{codigo}")
	@ApiOperation(value = "Listar produtos pelo código")
	public ResponseEntity<?> buscarPorId(@PathVariable T codigo) throws Exception {
		E entidade = servico.buscarPorId(codigo);
		if (entidade == null) {
			return ResponseEntity.notFound().build();
		}
		ResponseEntity<?> response = ResponseEntity.ok(entidade);
		return response;
	}
	
	//Listar
	@GetMapping("/listar")
	@ApiOperation(value = "Listar produtos")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(servico.listar());
	}

}

