package br.com.varejo.api.cadastro.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.varejo.api.cadastro.generico.model.GenericBaseModel;

@Entity
@Table(name = "tb_condicao_pagamento_parcela", schema = "varejo")
public class CondicaoPagamentoParcela extends GenericBaseModel<Long> {

	@JsonBackReference("condicao_pagamento")
	@ManyToOne
	@JoinColumn(name="condicao_pagamento_id",referencedColumnName="id")
	private CondicaoPagamento condicaoPagamento;

	@Column(name = "numero_parcela")
	private Integer numeroParcela;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "taxa_juros_mes")
	private BigDecimal taxaJurosAoMes;

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}

	public void setTaxaJurosAoMes(BigDecimal taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

}
