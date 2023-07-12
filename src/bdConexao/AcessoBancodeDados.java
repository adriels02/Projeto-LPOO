package bdConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AcessoBancodeDados{
	
	public Connection conexaoBD() {
		Connection conexao = null;
		
		
		try {
			Class.forName("com.mysq.jdbc.Driver");
			String acessoBD = "jdbc:mysql://localhost:3306/overlook?user=root&password=#123Mila123*";
			conexao = DriverManager.getConnection(acessoBD);
			
		} catch (ClassNotFoundException e){
		    System.out.println("Banco de dados não localizado");
		
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cessar o Banco de Dados " + e.getMessage());
		}
		
		return conexao;
		
		
	}

}
