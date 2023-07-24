package servicosCore;

public class CoreException extends Exception {

	CoreException(String mensagem) {
		super(mensagem);
	}

	CoreException(String mensagem, Exception causa) {

		super(mensagem, causa);
	}

}
