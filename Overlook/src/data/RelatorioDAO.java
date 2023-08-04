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
		this.connection = RelatorioMYSQLConnection.getConnection();// atribui o cconnection com os  dados de acesso ao banco ao conection desta classe
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new RelatorioDataException("Conexão com o banco de daodos não estabelecida", e);
		}
	}
	public RelatorioEntidade selectRestaurante(String dataInicial, String dataFinal) throws RelatorioDataException {//tomo 2 parametros com as datas para o between 
		try {
			PreparedStatement stmt;
			RelatorioEntidade relentd =new RelatorioEntidade();
			ResultSet rs;
			String selectQntdAlmoco = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Almoço' AND dia BETWEEN ? AND ?";//select para pegar a quantidade de almocos usando as 2 datas
			stmt = getConnection().prepareStatement(selectQntdAlmoco);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
		

			while (rs.next()) {
				
				relentd.setAlmoco(rs.getInt("SUM(quantidade)"));//quantidade de almocos durante aquele periodo
			}
			
			String selectQntdCafeDaManha = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Café da manhã' AND dia BETWEEN ? AND ?";//select para pegar a quantidades de cafes da manhas usando as 2 datas
			stmt = getConnection().prepareStatement(selectQntdCafeDaManha);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
		


			while (rs.next()) {
				
				relentd.setCafeManha(rs.getInt("SUM(quantidade)"));//quantidade de cafe da manha durante aquele periodo.
			}
			
			String selectQntdJantar = "SELECT SUM(quantidade) FROM Restaurante_Pedidos WHERE refeicao = 'Jantar' AND dia BETWEEN ? AND ?";//select para pegar a quatidade de jantares usando as 2 datas.
			stmt = getConnection().prepareStatement(selectQntdJantar);
			stmt.setDate(1, java.sql.Date.valueOf(dataInicial));
			stmt.setDate(2, java.sql.Date.valueOf(dataFinal));
			rs = stmt.executeQuery();
		


			while (rs.next()) {
				
				relentd.setJantar(rs.getInt("SUM(quantidade)")); // quantidade de jantares durante aquele periodo.
			}
			

			return relentd;// return da entidade que ao longo do metodo recebeu os valores com os 3 sets.

		} catch (SQLException e) {

			throw new RelatorioDataException("Erro na consulta ao Banco De Dados.");
		}
	}
}

