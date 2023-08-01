package bdConexao;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class ValidarCaracteres extends PlainDocument  {
	
		public enum TipoEntrada{

			NUMEROINTERIRO, NUMERODECIMAL, NOME, DATA;
		};
		
		private int qtdCaracteres;
		private TipoEntrada tpEntrada;
		
		
		public ValidarCaracteres (int qtdCaracteres, TipoEntrada tpEntrada) {
			
			this.qtdCaracteres = qtdCaracteres;
			this.tpEntrada = tpEntrada;
		}
		

		public void insertString (int i, String string, AttributeSet as) throws BadLocationException {
			
			if (string == null || getLength() == qtdCaracteres ) {
				
				return;
			}
			
			int totalCaracter = getLength() + string.length();
			
			
			String regras= "";
			switch (tpEntrada){
			case NUMEROINTERIRO: regras = "[^0-9]"; break;
			case NUMERODECIMAL:  regras = "[^0-9,.]"; break;
			case NOME:           regras = "[^A-Za-z ]"; break;
			case DATA:           regras = "[^0-9/]"; break;
			
			
			
			}
			
			string = string.replaceAll(regras,"");
			
			if (totalCaracter<= qtdCaracteres) {
				super.insertString(i, string, as);
				
			} else {
				String nova = string.substring(0,qtdCaracteres);
				super.insertString(i, nova, as);
				
				
			}
			 
		}
		

	}
	
