package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import core.RelatorioEntidade;

public class RelatorioDAO implements RelatorioRepository {
	private Connection connection;


	protected Connection getConnection() { //getter do atributo da classe
		return connection;
	}


	public RelatorioDAO() throws RelatorioDataException {
		this.connection = RelatorioMYSQLConnection.getConnection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new RelatorioDataException("Conexão com o banco de daodos não estabelecida", e);
		}
	}
	public RelatorioEntidade selectRestaurante(String dataInicial, String dataFinal) throws RelatorioDataException {
		try {
			PreparedStatement stmt;
			RelatorioEntidade relentd =new RelatorioEntidade();
			ResultSet rs;
			String selectQntdAlmoco = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Almoço' AND dia BETWEEN ? AND ?";
			stmt = getConnection().prepareStatement(selectQntdAlmoco);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
			/*
			 * int almoco = 0; int jantar = 0; int cafeManha = 0;
			 */


			while (rs.next()) {
				
				relentd.setAlmoco(rs.getInt("SUM(quantidade)"));
				
				//String x = rs.getString("refeicao");
				/*
				 * if ( x == "Café da manhã") { cafeManha++; } else if (x == "Almoço") {
				 * almoco++; }
				 * 
				 * else if (x == "Jantar") { jantar++; }
				 */
			}
			
			String selectQntdCafeDaManha = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Café da manhã' AND dia BETWEEN ? AND ?";
			stmt = getConnection().prepareStatement(selectQntdCafeDaManha);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
		


			while (rs.next()) {
				
				relentd.setCafeManha(rs.getInt("SUM(quantidade)"));
			}
			
			String selectQntdJantar = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Jantar' AND dia BETWEEN ? AND ?";
			stmt = getConnection().prepareStatement(selectQntdJantar);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
		


			while (rs.next()) {
				
				relentd.setJantar(rs.getInt("SUM(quantidade)"));
			}
			/*
			 * relentd.setAlmoco(almoco); relentd.setCafeManha(cafeManha);
			 * relentd.setJantar(jantar);
			 */

			return relentd;

		} catch (SQLException e) {

			throw new RelatorioDataException("Erro na consulta ao Banco De Dados.");
		}
	}
}

