package br.com.varejo.api.cadastro.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.varejo.api.cadastro.generico.model.GenericBaseModel;

@Entity
@Table(name = "tb_condicao_pagamento", schema = "varejo")
public class CondicaoPagamento extends GenericBaseModel<Long> {
	
	@Column(name = "valor_entrada")
	private BigDecimal valorEntrada;
	
	@Column(name = "qtde_parcelas")
	private Integer qtdeParcelas;

	@JsonManagedReference("condicao_pagamento")
	@OneToMany(mappedBy = "condicaoPagamento", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CondicaoPagamentoParcela> condicaoPagamentoParcela = new ArrayList<>();

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	public List<CondicaoPagamentoParcela> getCondicaoPagamentoParcela() {
		return condicaoPagamentoParcela;
	}

	public void setCondicaoPagamentoParcela(List<CondicaoPagamentoParcela> condicaoPagamentoParcela) {
		this.condicaoPagamentoParcela = condicaoPagamentoParcela;
	}
	
}
