package ConexaoBancodeDados;

//import java.sql.connetion;
public class Conexao {
	public static void main (String[] args) {
	
		try {
			Class.forName("com.msql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			
			System.out.println ("Banco de dados não encontrado");
		}
			
		
	
		
		
		
	}

}
