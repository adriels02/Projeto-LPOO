package br.edu.ifpe.paulista.pagamento.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.edu.ifpe.paulista.pagamento.core.PagamentoEntidade;

public class PagamentoDAO extends PagamentoGenericDAO implements PagamentoRepository {
	
	public PagamentoDAO() throws PagamentoDataException { //Construtor da Classe.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new PagamentoDataException("Conexao com o banco de daodos nao estabelecida", e);
		}
	}

	public void InserirDadosBDFatura(PagamentoEntidade pgmt) throws PagamentoDataException { //Insere na tabela fatura do MYSQL usando metodo de PagamentoGenericDAO.
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

	public PagamentoEntidade BDConstruirEntidade(String c, String tipoPagamento) throws PagamentoDataException { // Verifica se foi informado um cpf ou cnpj. Constroi a entidade EntidadePagamento por meio de consultas ao banco de dados, em diversas tabelas e da return com a entidade. 
		PagamentoEntidade pgmt = new PagamentoEntidade();

		try {
			if (c.trim().length() == 11) {
				String selectidCliente = "SELECT * FROM pessoaFisica WHERE cpf = ?";
				PreparedStatement stmt = getConnection().prepareStatement(selectidCliente);

				stmt.setString(1, c );
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					pgmt.setIdCliente(rs.getInt("idCliente"));
					
				}
				
				String selectNomeCliente = "SELECT nomeCliente FROM Cliente WHERE idCliente = ?";
				
				stmt = getConnection().prepareStatement(selectNomeCliente);
				stmt.setInt(1, pgmt.getIdCliente());
				
				while (rs.next()) {
					
				pgmt.setNomecliente(rs.getString("nomeCliente"));
				
				}
				
				String selectReserva = "SELECT * FROM Reserva WHERE idCliente = ?";
				
				stmt = getConnection().prepareStatement(selectReserva);
				stmt.setInt(1, pgmt.getIdCliente());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setData(rs.getDate("dataSaida"));
					pgmt.setIdReserva(rs.getInt("idReserva"));
				}

				String selectServicos = "SELECT * FROM Servicos WHERE idReserva = ?";
				
				stmt = getConnection().prepareStatement(selectServicos);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();
				
				ArrayList<String> nomeServico = new ArrayList<String>();
				ArrayList<Double> precoServico = new ArrayList<Double>();
				
				while (rs.next()) {
					
					nomeServico.add(rs.getString("nomeServico"));
					precoServico.add(rs.getDouble("precoServico"));
					
				}
				
				pgmt.setPrecoServico(precoServico);
				pgmt.setNomeServico(nomeServico);
				
				String selectPrecoQuarto = "SELECT * FROM quarto WHERE idReserva = ?";
				
				stmt = getConnection().prepareStatement(selectPrecoQuarto);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setPrecoQuarto(rs.getDouble("precoQuarto"));
				}
				String totalPrecoServico = "SELECT SUM(precoServico) FROM servico WHERE idReserva = ?";
				stmt = getConnection().prepareStatement(totalPrecoServico);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setPrecoFinal(rs.getDouble("precoServico") + pgmt.getPrecoFinal());
				}

				rs.close();
				stmt.close();
				getConnection().close();
				return pgmt;
				
			} else if(c.length()==14) {

				String selectidCliente = "SELECT * FROM pessoaJuridica WHERE cnpj = ?";
				PreparedStatement stmt = getConnection().prepareStatement(selectidCliente);

				stmt.setString(1, c );
				ResultSet rs = stmt.executeQuery();
		
				while (rs.next()) {
					
					pgmt.setIdCliente(rs.getInt("idCliente"));

				}
				String selectNomeCliente = "SELECT * FROM Cliente WHERE idCliente = ?";
				stmt = getConnection().prepareStatement(selectNomeCliente);
				stmt.setInt(1, pgmt.getIdCliente());
				while (rs.next()) {
				
					pgmt.setNomecliente(rs.getString("nomeCliente"));
				}

				String selectReserva = "SELECT * FROM Reserva WHERE idCliente = ?";
				stmt = getConnection().prepareStatement(selectReserva);
				stmt.setInt(1, pgmt.getIdCliente());
				rs = stmt.executeQuery();

				while (rs.next()) {
					
					pgmt.setData(rs.getDate("dataSaida"));
					pgmt.setIdReserva(rs.getInt("idReserva"));
				}

				String selectServicos = "SELECT * FROM Servico WHERE idReserva = ?";
				stmt = getConnection().prepareStatement(selectServicos);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();
				
				ArrayList<String> nomeServico = new ArrayList<String>();
				ArrayList<Double> precoServico = new ArrayList<Double>();
				
				while (rs.next()) {
					
					nomeServico.add(rs.getString("nomeServico"));
					precoServico.add(rs.getDouble("precoServico"));
				}	
		
				pgmt.setPrecoServico(precoServico);
				pgmt.setNomeServico(nomeServico);

				String selectPrecoQuarto = "SELECT * FROM Quarto WHERE idReserva = ?";
				
				stmt = getConnection().prepareStatement(selectPrecoQuarto);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setPrecoQuarto(rs.getDouble("precoQuarto"));
				}
				String totalPrecoQuarto = "SELECT SUM(precoQuarto) AS totalQuarto FROM Quarto WHERE idReserva = ?";
				
				stmt = getConnection().prepareStatement(totalPrecoQuarto);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setPrecoFinal(rs.getDouble("totalQuarto"));
				}
				String totalPrecoServico = "SELECT SUM(precoServico) AS totalServico FROM Servico WHERE idReserva = ?";
				
				stmt = getConnection().prepareStatement(totalPrecoServico);
				stmt.setInt(1, pgmt.getIdReserva());
				rs = stmt.executeQuery();

				while (rs.next()) {
					pgmt.setPrecoFinal(rs.getDouble("totalServico") + pgmt.getPrecoFinal());
				}


				rs.close();
				stmt.close();
				getConnection().close();
				return pgmt;
			
			}else {
				
				throw new PagamentoDataException("Número inválido");
			
			}
		
		} catch (SQLException e) {
			throw new PagamentoDataException("Informações não encontradas no banco de dados.", e) ;

		}	
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