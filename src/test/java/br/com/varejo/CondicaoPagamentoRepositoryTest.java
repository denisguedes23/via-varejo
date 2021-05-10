package br.com.varejo;

import java.math.BigDecimal;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.varejo.api.cadastro.model.CondicaoPagamento;
import br.com.varejo.api.cadastro.repository.CondicaoPagamentoRepositorio;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("Testes para CondicaoPagamentoRepository")
class CondicaoPagamentoRepositoryTest {
	
	@Autowired
	private CondicaoPagamentoRepositorio repository;
	
	@Test
	@DisplayName("Salvar CondicaoPagamento com sucesso!")
	public void savePersistCondicaoPagamento() {
		CondicaoPagamento entidade = new CondicaoPagamento();
		entidade.setQtdeParcelas(10);
		entidade.setValorEntrada(BigDecimal.valueOf(20));
		CondicaoPagamento entidadeSave = this.repository.save(entidade);
		Assertions.assertThat(entidadeSave).isNotNull();
		Assertions.assertThat(entidadeSave.getId()).isNotNull();
		Assertions.assertThat(entidadeSave.getQtdeParcelas()).isEqualTo(entidade.getQtdeParcelas());
		Assertions.assertThat(entidadeSave.getValorEntrada()).isEqualTo(entidade.getValorEntrada());
	}
	
	@Test
	@DisplayName("Alterar CondicaoPagamento com sucesso!")
	public void editCondicaoPagamento() {
		CondicaoPagamento entidade = new CondicaoPagamento();
		entidade.setId(1L);
		entidade.setQtdeParcelas(10);
		entidade.setValorEntrada(BigDecimal.valueOf(20));
		CondicaoPagamento entidadeSave = this.repository.saveAndFlush(entidade);
		Assertions.assertThat(entidadeSave).isNotNull();
		Assertions.assertThat(entidadeSave.getId()).isNotNull();
		Assertions.assertThat(entidadeSave.getQtdeParcelas()).isEqualTo(entidade.getQtdeParcelas());
		Assertions.assertThat(entidadeSave.getValorEntrada()).isEqualTo(entidade.getValorEntrada());
	}
	
	@Test
	@DisplayName("Deletar CondicaoPagamento com sucesso!")
	public void deleteCondicaoPagamento() {
		CondicaoPagamento entidade = new CondicaoPagamento();
		entidade.setId(1L);
		this.repository.delete(entidade);
		
		Optional<CondicaoPagamento> entidadeOptional = this.repository.findById(entidade.getId());
		Assertions.assertThat(entidadeOptional.isPresent());
	}

}
