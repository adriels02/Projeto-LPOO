package br.edu.ifpe.paulista.pagamento.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPagamento {
	private static final String url = "192.168.0.7";
	
	private static final String driver = "com.mysql.jdbc.Driver";
		
	private static final String nome = "murilo";
	
	private static final String senha = "#BDhotel123";

	public static Connection getConnection() {
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


