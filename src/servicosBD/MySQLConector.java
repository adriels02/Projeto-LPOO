package servicosBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import servicosCore.Translado;

public class MySQLConector implements ControleAcessoBD{

	public MySQLConector() throws BDException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception Mensagem) {
			throw new BDException("deu beyblade aqui " + Mensagem);
		}
	}

	public void registroTranslado(Translado translado) throws BDException { 
		
		try {
			Connection conn = DriverManager.getConnection("");
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO cliente(idcliente ) VALUES(?)");
			stmt.setDouble(1, 6);
//			stmt.setString(2, translado.getNome());
//			stmt.setString(3, translado.getDescricao());
//			stmt.setDouble(4, translado.getPreco());
			stmt.execute();
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}

	}

}