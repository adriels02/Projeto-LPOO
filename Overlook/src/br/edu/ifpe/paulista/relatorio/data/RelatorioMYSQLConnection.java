package br.edu.ifpe.paulista.relatorio.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RelatorioMYSQLConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://db4free.net:3306/overlook_db";
	
	private static final String nome = "overlook_user";
	
	private static final String senha = "#BDhotel123";

	public static Connection getConnection() throws RelatorioDataException { // Quando chamado estabelece uma conexao ao SQL usado os atributos da Classe.
		try {
			Class.forName(driver);
			
			return DriverManager.getConnection(url, nome, senha);
			
		} catch (ClassNotFoundException e) {
			
			throw new RelatorioDataException("Class not found.");
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}

