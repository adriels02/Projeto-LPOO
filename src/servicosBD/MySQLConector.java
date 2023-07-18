package servicosBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
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

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
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
	
		public List<HistoricoTranslado> leituraTabela() throws BDException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			List<HistoricoTranslado> historicos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
			stmt = conn.prepareStatement("SELECT * FROM historicotranslado");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				 HistoricoTranslado translado = new HistoricoTranslado();
				translado.setIdViagem(rs.getInt("idViagem"));
				translado.setEnderecoColeta(rs.getString("enderecoColeta"));
				translado.setEnderecoDestino(rs.getString("enderecoDestino"));
				translado.setNumeroPassageiros(rs.getInt("quantidadePassageiros"));
				
				Date data =	rs.getDate("dia");				
				translado.setData(data.toLocalDate());
				
				Time time = rs.getTime("hora");
				translado.setHora(time.toLocalTime());
				
				translado.setIdReserva(rs.getInt("idReserva"));
				historicos.add(translado);
			}
			
			
			
		} catch (Exception e) {
			throw new BDException("Ocorreu um erro ao fechar o banco de dados: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao fechar o banco de dados: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro ao fechar o banco de dados: " + e.getMessage());
			}
		}
		
		return historicos;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}