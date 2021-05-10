package br.com.varejo.api.cadastro.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.varejo.api.cadastro.generico.service.GenericBaseService;
import br.com.varejo.api.cadastro.model.CondicaoPagamento;
import br.com.varejo.api.cadastro.model.CondicaoPagamentoParcela;
import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.model.json.ParcelaJson;
import br.com.varejo.api.cadastro.repository.CondicaoPagamentoRepositorio;
import br.com.varejo.api.config.error.AplicationException;

@Service
public class CondicaoPagamentoServico extends GenericBaseService<CondicaoPagamentoRepositorio, CondicaoPagamento, Long> {
	
	@Autowired
	private ProdutoService produtoService;
	
	private BigDecimal valorSelic;

	@Override
	public CondicaoPagamento buscarPorId(Long id) {
		CondicaoPagamento condicaoPagamento = super.buscarPorId(id);
		condicaoPagamento.getCondicaoPagamentoParcela().sort(Comparator.comparing(CondicaoPagamentoParcela::getNumeroParcela));
		return condicaoPagamento;
	}
	
	private void selic() {
		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = localDate.format(formatter);
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.bcb.gov.br")
				.path("dados/serie/bcdata.sgs.11/dados?formato=json")
				.path("&dataInicial=")
				.path(formattedString)
				.path("&dataFinal=")
				.path(formattedString)
				.build();
		
		ParcelaJson[] entidade = new RestTemplate().getForObject(uri.toString(), ParcelaJson[].class);
		
		for (int i = 0 ; i < entidade.length; i++) {
			valorSelic = entidade[i].getValor();
		}
	}

	public CondicaoPagamento calcularParcelas(String codigo, BigDecimal valorEntrada, Integer qtdParcela) {
		Produto produto = produtoService.buscarPorCodigo(codigo).orElseThrow(() -> new AplicationException("Produto não encontrado!"));
		selic();
		if (qtdParcela != null && qtdParcela > 0) {
			CondicaoPagamento condicao = new CondicaoPagamento();
			condicao.setValorEntrada(valorEntrada);
			condicao.setQtdeParcelas(qtdParcela);
			for(int i = 1; i <= qtdParcela; i++) {
				CondicaoPagamentoParcela parcela = new CondicaoPagamentoParcela();
				parcela.setNumeroParcela(i);
				parcela.setValor(produto.getValor().divide(new BigDecimal(i), 2, RoundingMode.HALF_UP));
		        if(i > 5) {
		        	parcela.setTaxaJurosAoMes(valorSelic);
		        }
		        condicao.getCondicaoPagamentoParcela().add(parcela);
			}
			produto.setCondicaoPagamento(condicao);
			produto.getCondicaoPagamento().getCondicaoPagamentoParcela().sort(Comparator.comparing(CondicaoPagamentoParcela::getNumeroParcela));
		}

		return produto.getCondicaoPagamento();
	}

}
