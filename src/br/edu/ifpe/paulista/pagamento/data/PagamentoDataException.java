package br.edu.ifpe.paulista.pagamento.data;

public class PagamentoDataException extends Exception {

	public PagamentoDataException(String message) {
		super(message);
	}
	
	public PagamentoDataException(String message, Exception cause) {
		super(message, cause);
	}
	
}
