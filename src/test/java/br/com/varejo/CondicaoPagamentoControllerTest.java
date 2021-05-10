package br.com.varejo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.varejo.api.cadastro.controller.CondicaoPagamentoController;
import br.com.varejo.api.cadastro.service.CondicaoPagamentoServico;

@ExtendWith(SpringExtension.class)
class CondicaoPagamentoControllerTest {
	
	@InjectMocks
	private CondicaoPagamentoController controller;
	
	@Mock
	private CondicaoPagamentoServico service;
	
	@BeforeEach
	public void setup() {
		ResponseEntity<?> lista = controller.listar();
		BDDMockito.when(this.service.listar()).thenReturn(lista);
	}

	@Test
	public void listar() {
		ResponseEntity.ok(service.listar());
	}

}