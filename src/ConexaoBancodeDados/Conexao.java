package ConexaoBancodeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static void main (String[] args) throws SQLException {
		Connection conexao = null;
	
		try {
			Class.forName("com.msql.jdbc.Driver");
			
			//String acesso = "jdbc;mysql://localhost:3306/overlook?user=root&password=#123Mila123*";
			conexao = DriverManager.getConnection("jdbc;mysql://localhost/overlook", "nome", "senha");
			//ResultSet rs
			
		} catch (ClassNotFoundException e) {
			System.out.println ("Banco de dados não encontrado");
			
		} catch (SQLException e) {
		    System.out.println ("Erro ao acessar o banco" + e.getMessage());
		  
		} finally {
			if (conexao != null) {
				conexao.close();
			} 
			
		
		}		
    }
}
