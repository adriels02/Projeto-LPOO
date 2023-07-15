package br.edu.ifpe.paulista.pagamento.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PagamentoMYSQLConnection {
	private static final String url = "";
	
	private static final String driver = "com.mysql.jdbc.Driver";
		
	private static final String nome = "";
	
	private static final String senha = "";

	public static Connection getConnection() { // Quando chamado estabelece uma conexao ao SQL usado os atributos da Classe.
		System.out.println("Conectando ao Banco de Dados");
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


