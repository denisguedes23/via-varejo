package br.com.varejo.api.cadastro.model.json;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParcelaJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2278237179883725863L;
	
	private String data;
	private BigDecimal valor;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
