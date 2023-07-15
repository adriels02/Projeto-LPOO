package br.edu.ifpe.paulista.pagamento.data;

public class PagamentoDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5718830080523520350L;

	public PagamentoDataException(String message) { // Quando chamado constroi uma excecao e recebe a messagem fornecida.
		super(message);
	}
	
	public PagamentoDataException(String message, Exception cause) { // Quando chamado constroi uma excecao e recebe a messagem e causa fornecida.
		super(message, cause);
	}
	
}
