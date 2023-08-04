package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AcessoBancodeDados{
	private static final String url = "jdbc:mysql://db4free.net:3306/overlook_db";
	private static final String usuario = "overlook_user";
	private static final String senha = "#BDhotel123";
	
	
	public Connection conexaoBD() {
		
		Connection conexao = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url,usuario,senha);
			
		} catch (ClassNotFoundException e){
		    System.out.println("Banco de dados não localizado");
		
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog( null, "Ocorreu um erro ao cessar o Banco de Dados ", "Mensagem",JOptionPane.ERROR_MESSAGE);
		}
		
		return conexao;
		
		
	}

}
