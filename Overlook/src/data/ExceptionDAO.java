package data;

public class ExceptionDAO extends Exception{
		public ExceptionDAO(String mensagem){
		super (mensagem);
		}
		public ExceptionDAO(String mensagem, Exception causa) {
			super(mensagem, causa);
		}
	}

