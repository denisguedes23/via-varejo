package br.com.varejo.api.config.error;

public class AplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AplicationException() {
		super();
	}

	public AplicationException(String mensagem) {
		super(mensagem);
	}

	public AplicationException(Exception e) {
		super(e);
	}
}
