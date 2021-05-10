package br.com.varejo.api.cadastro.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.varejo.api.cadastro.generico.controller.GenericBaseController;
import br.com.varejo.api.cadastro.model.CondicaoPagamento;
import br.com.varejo.api.cadastro.service.CondicaoPagamentoServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/condicao-pagamento")
@Api(value = "Condição de Pagamento")
public class CondicaoPagamentoController extends GenericBaseController<CondicaoPagamentoServico, CondicaoPagamento, Long> {
	
	@GetMapping("/calcular-parcelas")
	@ApiOperation(value = "Calcular parcelas condição de pagamento")
	public ResponseEntity<?> calcularParcelas(@RequestParam String codigo, @RequestParam BigDecimal valorEntrada, @RequestParam Integer qtdParcela)  {
		return ResponseEntity.ok(servico.calcularParcelas(codigo, valorEntrada, qtdParcela));
	}
		
}

