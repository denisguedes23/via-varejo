package br.com.varejo.api.cadastro.generico.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.varejo.api.cadastro.generico.model.IGenericBaseModel;

public abstract class GenericBaseService<R extends JpaRepository<E, T>, E extends IGenericBaseModel, T extends Serializable>
		implements IGenericBaseService<E, T> {

	@Autowired
	public R repositorio;

	// Novo
	public E incluir(E entidade) {
		return repositorio.save(entidade);
	}

	// Editar
	@Transactional
	public E editar(E entidade) {
		E result = repositorio.save(entidade);
		return result;
	}

	// remover
	public void excluir(T codigo) {
		repositorio.deleteById(codigo);
	}

	// Buscar por código
	public E buscarPorId(T id) {
		Optional<E> entidade = repositorio.findById(id);
		if (entidade.isPresent()) {
			return entidade.get();
		}
		return null;
	}

	// Listar
	public Object listar() {
		return repositorio.findAll();
	}
}
