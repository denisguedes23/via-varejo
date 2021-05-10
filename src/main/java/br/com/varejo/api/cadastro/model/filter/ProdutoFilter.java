/*
 * 21/07/2009
 */
package br.com.varejo.api.cadastro.model.filter;

public class ProdutoFilter {

	private Long codigo;
	
    private String nome;
    
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
