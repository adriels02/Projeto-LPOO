package servicosBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import servicosCore.HistoricoTranslado;
import servicosCore.Translado;

public class MySQLConector implements ControleAcessoBD {

	public MySQLConector() throws BDException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception Mensagem) {
			throw new BDException("Ocorreu o seguinte erro: " + Mensagem);
		}
	}

	public void registroTranslado(HistoricoTranslado translado) throws BDException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "");
			stmt = conn.prepareStatement(
					"INSERT INTO historicotranslado(enderecoColeta , enderecoDestino , quantidadePassageiros, dia , hora, idReserva ) VALUES(?,?,?,?,?,?)");
			stmt.setString(1, translado.getEnderecoColeta());
			stmt.setString(2, translado.getEnderecoDestino());
			stmt.setInt(3, translado.getNumeroPassageiros());
			stmt.setDate(4, translado.getData());
			stmt.setTime(5, translado.getHora());
			stmt.setInt(6, translado.getIdReserva());
			stmt.execute();
		} catch (Exception e) {
			throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
			}
		}

	}

	public void registroServicoTranslado(Translado translado) throws BDException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "");
			stmt = conn.prepareStatement(
					"INSERT INTO servico(idReserva ,nomeServico , descricaoServico, precoServico) VALUES(?,?,?,?)");
			stmt.setInt(1, translado.getIdReserva());
			stmt.setString(2, translado.getNome());
			stmt.setString(3, translado.getDescricao());
			stmt.setDouble(4, translado.getPreco());
			stmt.execute();

		} catch (Exception e) {
			throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
			}
		}

	}

}