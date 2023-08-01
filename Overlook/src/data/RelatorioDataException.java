package data;

public class RelatorioDataException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6019126697775559115L;

	public RelatorioDataException(String message, Exception cause) {
		super(message, cause);
		
	}

	public RelatorioDataException(String message) {
		super(message);
		
	}
}
