package br.com.varejo.api.cadastro.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.varejo.api.cadastro.generico.model.GenericBaseModel;

@Entity
@Table(name = "tb_produto", schema = "varejo")
public class Produto extends GenericBaseModel<Long> {

	@Size(max = 5)
	@Column(name = "codigo")
	private String codigo;
	
	@Size(max = 255)
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "condicao_pagamento_id", referencedColumnName = "id")
	private CondicaoPagamento condicaoPagamento;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	
}
