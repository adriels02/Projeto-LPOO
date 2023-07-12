package br.edu.ifpe.paulista.pagamento.data;

import br.edu.ifpe.paulista.pagamento.EntidadePagamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO extends PagamentoGenericDAO {

	public void InserirDadosBDFatura(EntidadePagamento pgmt) throws SQLException {
		String ins = "INSERT INTO Fatura(idFatura, idReserva,  tipoPagamento, precoFinal) VALUES(?,?,?,?)";
		insert(ins, pgmt.getIdFatura(), pgmt.getIdReserva(), pgmt.getTipoPagamento(), pgmt.getPrecoFinal());
	}

	public EntidadePagamento BuscarDadosFatura(int idFatura) throws SQLException {
		String selectFatura = "SELECT * FROM fatura WHERE idFatura = ?";
		EntidadePagamento pgmt = null;
		PreparedStatement stmt = getConnection().prepareStatement(selectFatura);

		stmt.setInt(1, idFatura);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			pgmt = new EntidadePagamento();
			pgmt.setIdFatura(rs.getInt("idFatura"));
			pgmt.setIdReserva(rs.getInt("idReserva"));
			pgmt.setTipoPagamento(rs.getString("tipoPagamento"));
			pgmt.setPrecoFinal(rs.getDouble("precoFinal"));
		}

		rs.close();
		stmt.close();
		getConnection().close();

		return pgmt;
	}

	public EntidadePagamento BDConstruirEntidade(String c) throws SQLException {
		EntidadePagamento pgmt = new EntidadePagamento();

		if (c.length() == 11) {
			String selectCliente = "SELECT * FROM pessoaFisica WHERE cpf = ?";
			PreparedStatement stmt = getConnection().prepareStatement(selectCliente);

			stmt.setString(1, c);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setIdCliente(rs.getInt("idCliente"));
				pgmt.setNomecliente(rs.getString("nomeCliente"));
			}
		} else {

			String selectCliente = "SELECT * FROM pessoaJuridica WHERE cnpj = ?";
			PreparedStatement stmt = getConnection().prepareStatement(selectCliente);

			stmt.setString(1, c);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setIdCliente(rs.getInt("idCliente"));
				pgmt.setNomecliente(rs.getString("nomeCliente"));

			}

			String selectReserva = "SELECT * FROM reserva WHERE idCliente = ?";
			stmt = getConnection().prepareStatement(selectReserva);
			stmt.setInt(1, pgmt.getIdCliente());
			rs = stmt.executeQuery();

			while (rs.next()) {
				pgmt.setData(rs.getDate("dataSaida"));
				pgmt.setIdReserva(rs.getInt("idReserva"));
			}

			String selectServicos = "SELECT * FROM servicos WHERE idReserva = ?";
			stmt = getConnection().prepareStatement(selectServicos);
			stmt.setInt(1, pgmt.getIdReserva());
			rs = stmt.executeQuery();

			while (rs.next()) {
				 ArrayList<String> nomeServico = new ArrayList<String>();
				 ArrayList<Double> precoServico = new ArrayList<Double>();
				nomeServico.add(rs.getString("nomeServico"));
				precoServico.add(rs.getDouble("precoServico"));
				pgmt.setPrecoServico(precoServico);
				pgmt.setNomeServico(nomeServico);
			}
			rs.close();
			stmt.close();
			getConnection().close();
		}

		return pgmt;
	}
}

//Verificar padroes onde querys sao atribuidas a entidades 
//caso tenha que separar, seguir mtdo
/*
 * public EntidadePagamento BuscarDadosBDFatura(int idFatura) throws
 * SQLException { String select = "SELECT * FROM fatura WHERE idFatura = ?";
 * EntidadePagamento pgmt = null; PreparedStatement stmt =
 * getConnection().prepareStatement(select);
 * 
 * stmt.setInt(1, idFatura); ResultSet rs = stmt.executeQuery();
 * 
 * while (rs.next()) { pgmt = new EntidadePagamento();
 * pgmt.setIdFatura(rs.getInt("idFatura"));
 * pgmt.setIdReserva(rs.getInt("idReserva"));
 * pgmt.setTipoPagamento(rs.getString("tipoPagamento"));
 * pgmt.setPrecoFinal(rs.getDouble("precoFinal")); }
 * 
 * rs.close(); stmt.close(); getConnection().close();
 * 
 * return pgmt; }
 */
