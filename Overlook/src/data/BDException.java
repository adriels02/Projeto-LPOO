package data;

public class BDException extends Exception {

	public BDException(String mensagem) {
		super(mensagem);
	}

	public BDException(String mensagem, Exception causa) {
		super(mensagem, causa);
	}
}
