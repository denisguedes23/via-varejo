package br.com.varejo.api.cadastro.generico.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericBaseModel<T extends Serializable> implements IGenericBaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

}
