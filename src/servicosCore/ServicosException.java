package servicosCore;

public class ServicosException extends Exception {

	ServicosException(String mensagem) {
		super(mensagem);
	}

	ServicosException(String mensagem, Exception causa) {

		super(mensagem, causa);
	}

}
