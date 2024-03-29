package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.PagamentoEntidade;

public class PagamentoDAO extends PagamentoGenericDAO implements PagamentoRepository {

	public PagamentoDAO() throws PagamentoDataException { //Construtor da Classe.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new PagamentoDataException("Conexão com o banco de daodos não estabelecida", e);
		}
	}
	public PagamentoEntidade PegaridFatura(PagamentoEntidade pgmt) throws PagamentoDataException{

		try {
			String selectIdFatura = "SELECT idFatura FROM Fatura WHERE idReserva = ?";
			PreparedStatement stmt = getConnection().prepareStatement(selectIdFatura);
			stmt.setInt(1, pgmt.getIdReserva());
			ResultSet rs = stmt.executeQuery();


			while (rs.next()) {

				pgmt.setIdFatura(rs.getInt("idFatura"));
			}
			rs.close();
			stmt.close();
			getConnection().close();

			return pgmt;
			} catch (SQLException e) {
				throw new PagamentoDataException("Acesso negado", e);
		}

	}
	public void inserirDadosBDFaturaReceberId(PagamentoEntidade pgmt) throws PagamentoDataException { //Insere na tabela fatura do MYSQL usando metodo de PagamentoGenericDAO.
		try {

			String ins = "INSERT INTO Fatura(idReserva,  tipoPagamento, precoFinal) VALUES(?,?,?)";
			insert(ins, pgmt.getIdReserva(), pgmt.getTipoPagamento(), pgmt.getPrecoFinal());


		} catch (Exception e) {

			throw new PagamentoDataException("Acesso negado", e) ;
		}
	}

	public PagamentoEntidade BuscarDadosFatura(int idFatura) throws PagamentoDataException {// Busca atributos para entidade EntidadePagamento por meio de consultas na tabela fatura e da return com a entidade.

		try {
			String selectFatura = "SELECT * FROM fatura WHERE idFatura = ?";
			PagamentoEntidade pgmt = null;
			PreparedStatement stmt = getConnection().prepareStatement(selectFatura);

			stmt.setInt(1, idFatura);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt = new PagamentoEntidade();
				pgmt.setIdFatura(rs.getInt("idFatura"));
				pgmt.setIdReserva(rs.getInt("idReserva"));
				pgmt.setTipoPagamento(rs.getString("tipoPagamento"));
				pgmt.setPrecoFinal(rs.getDouble("precoFinal"));
			}

			rs.close();
			stmt.close();
			getConnection().close();

			return pgmt;
		} catch (Exception e) {
			throw new PagamentoDataException("Acesso negado", e) ;

		}
	}
	public PagamentoEntidade selectsBdUsandoIdreserva(int r, PagamentoEntidade pgmt) throws PagamentoDataException {
		try {


			PreparedStatement stmt;
			ResultSet rs;
			String selectServicos = "SELECT nomeServico FROM Servico WHERE idReserva = ?";
			stmt = getConnection().prepareStatement(selectServicos);
			stmt.setInt(1, r);
			rs = stmt.executeQuery();

			ArrayList<String> nomeServico = new ArrayList<String>();

			while (rs.next()) {

				nomeServico.add(rs.getString("nomeServico"));
			}

			pgmt.setNomeServico(nomeServico);

			String selectPrecosServicos = "SELECT precoServico FROM Servico WHERE idReserva = ?";

			stmt = getConnection().prepareStatement(selectPrecosServicos);
			stmt.setInt(1, r );
			rs = stmt.executeQuery();

			ArrayList<Double> precoServico = new ArrayList<Double>();

			while (rs.next()) {

				precoServico.add(rs.getDouble("precoServico"));
			}	

			pgmt.setPrecoServico(precoServico);


			String selectPrecoQuarto = "SELECT precoQuarto FROM Quarto WHERE idReserva = ?";

			stmt = getConnection().prepareStatement(selectPrecoQuarto);
			stmt.setInt(1, r);
			rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setTotalPrecoQuarto(rs.getDouble("precoQuarto"));
			}
			String totalPrecoQuarto = "SELECT SUM(precoQuarto) AS totalQuarto FROM Quarto WHERE idReserva = ?";

			stmt = getConnection().prepareStatement(totalPrecoQuarto);
			stmt.setInt(1, r);
			rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setTotalPrecoQuarto(rs.getDouble("totalQuarto"));
			}
			String totalPrecoServico = "SELECT SUM(precoServico) AS totalServico FROM Servico WHERE idReserva = ?";

			stmt = getConnection().prepareStatement(totalPrecoServico);
			stmt.setInt(1, r);
			rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setPrecoFinal(rs.getDouble("totalServico") + pgmt.getTotalPrecoQuarto());
			}
			return pgmt;

		}
		catch (SQLException e) {
			throw new PagamentoDataException("Falha nos querys usando a id da reserva.", e) ;

		}

	}

	public PagamentoEntidade selectsBdUsandoCpf(String c) throws PagamentoDataException { // Verifica se foi informado um cpf ou cnpj. Constroi a entidade EntidadePagamento por meio de consultas ao banco de dados, em diversas tabelas e da return com a entidade. 


		try {

			PagamentoEntidade pgmt = new PagamentoEntidade();
			ResultSet rs;
			PreparedStatement stmt;

			String selectNomeCliente = "SELECT nomeCliente FROM Cliente WHERE cpf = ?";
			stmt = getConnection().prepareStatement(selectNomeCliente);
			stmt.setString(1, c );
			rs = stmt.executeQuery();


			while (rs.next()) {

				pgmt.setNomecliente(rs.getString("nomeCliente"));

			}
			String selectdataNasc = "SELECT dataNascCliente FROM Cliente WHERE cpf = ?";

			stmt = getConnection().prepareStatement(selectdataNasc);
			stmt.setString(1, c);
			rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setDataNasc(rs.getString("dataNascCliente"));
			}

			ArrayList<Integer> reservas = new ArrayList<Integer>();		

			String selectidReservas = "SELECT idReserva FROM Reserva WHERE cpf = ?";
			stmt = getConnection().prepareStatement(selectidReservas);
			stmt.setString(1, c );
			rs = stmt.executeQuery();


			while (rs.next()) {
				int x =rs.getInt("idReserva");
				reservas.add(x);

			}


			//ArrayList para as reservas sem faturas.
			ArrayList<Integer> reservasNaoFaturadas = new ArrayList<Integer>();

			String selectidReservasJaFaturadas = "SELECT * FROM Fatura WHERE idReserva = ?";
			stmt = getConnection().prepareStatement(selectidReservasJaFaturadas);

			//metodo que adiciona as reservas sem faturas ao ArrayList
			lbl: for(int r:reservas) {

					stmt.setInt(1,r);
					rs = stmt.executeQuery();
					while(rs.next()) {
						continue lbl;
					}
					reservasNaoFaturadas.add(r);
					pgmt.setReservasNaoFaturadas(reservasNaoFaturadas);
				}
			return pgmt;//return com o objeto PagamentoEntidade construido.

	}
		catch (SQLException e) {
			throw new PagamentoDataException("Falha nos querys das informações do banco de dados.", e) ;

		}

	}
}

