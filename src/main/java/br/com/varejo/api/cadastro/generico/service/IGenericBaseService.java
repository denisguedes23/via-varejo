package br.com.varejo.api.cadastro.generico.service;

import br.com.varejo.api.cadastro.generico.model.IGenericBaseModel;

public interface IGenericBaseService<E extends IGenericBaseModel, T> {

	E incluir(E entidade);
	E editar(E entidade) ;
	void excluir(T id);
	E buscarPorId(T id);
	Object listar();
		
}
