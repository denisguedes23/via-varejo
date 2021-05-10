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

import br.com.varejo.api.cadastro.model.Produto;
import br.com.varejo.api.cadastro.repository.ProdutoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("Testes para ProdutoRepository")
class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Test
	@DisplayName("Salvar Produto com sucesso!")
	public void savePersistProduto() {
		Produto entidade = new Produto();
		entidade.setCodigo("001");
		entidade.setNome("Video Game Xbox One");
		entidade.setValor(BigDecimal.valueOf(1200));
		Produto entidadeSave = this.repository.save(entidade);
		Assertions.assertThat(entidadeSave).isNotNull();
		Assertions.assertThat(entidadeSave.getId()).isNotNull();
		Assertions.assertThat(entidadeSave.getCodigo()).isEqualTo(entidade.getCodigo());
		Assertions.assertThat(entidadeSave.getNome()).isEqualTo(entidade.getNome());

	}
	
	@Test
	@DisplayName("Alterar Produto com sucesso!")
	public void editProduto() {
		Produto entidade = new Produto();
		entidade.setId(1L);
		entidade.setCodigo("001");
		entidade.setNome("Video Game Xbox One");
		entidade.setValor(BigDecimal.valueOf(1200));
		Produto entidadeSave = this.repository.saveAndFlush(entidade);
		Assertions.assertThat(entidadeSave).isNotNull();
		Assertions.assertThat(entidadeSave.getId()).isNotNull();
		Assertions.assertThat(entidadeSave.getCodigo()).isEqualTo(entidade.getCodigo());
		Assertions.assertThat(entidadeSave.getNome()).isEqualTo(entidade.getNome());
	}
	
	@Test
	@DisplayName("Deletar Produto com sucesso!")
	public void deleteProduto() {
		Produto entidade = new Produto();
		entidade.setId(1L);
		this.repository.delete(entidade);
		
		Optional<Produto> entidadeOptional = this.repository.findById(entidade.getId());
		Assertions.assertThat(entidadeOptional.isPresent());
	}

}
