package br.edu.ifpe.paulista.relatorio.core;

public class RelatorioExcecoesRegraNegocio extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199508373712335099L;

	public RelatorioExcecoesRegraNegocio(String message, Exception cause) {
		super(message, cause);
		
	}

	public RelatorioExcecoesRegraNegocio(String message) {
		super(message);
		
	}

}
