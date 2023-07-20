package br.edu.ifpe.paulista.pagamento.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PagamentoMYSQLConnection {
	private static final String url = "jdbc:mysql://db4free.net:3306/olamundo";
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
		
	private static final String nome = "usario";
	
	private static final String senha = "PNGEeiRWgQK4Tu@";

	public static Connection getConnection() { // Quando chamado estabelece uma conexao ao SQL usado os atributos da Classe.
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, nome, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}


