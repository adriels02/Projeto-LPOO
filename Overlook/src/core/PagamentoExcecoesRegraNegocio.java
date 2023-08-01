package core;

public class PagamentoExcecoesRegraNegocio extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3028856277033424149L;

	public PagamentoExcecoesRegraNegocio(String message, Exception cause) {
		super(message, cause);
		
	}

	public PagamentoExcecoesRegraNegocio(String message) {
		super(message);
		
	}


	

}
