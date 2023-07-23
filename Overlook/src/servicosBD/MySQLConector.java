package servicosBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import servicosCore.Arrumacao;
import servicosCore.HistoricoTranslado;
import servicosCore.RestaurantePedidos;
import servicosCore.Servico;
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
			throw new BDException("Ocorreu um erro: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			}
		}

	}

	public void registroServico(Servico servico) throws BDException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
			stmt = conn.prepareStatement("INSERT INTO servico(idReserva ,nomeServico , descricaoServico, precoServico) VALUES(?,?,?,?)");
			stmt.setInt(1, servico.getIdReserva());
			stmt.setString(2, servico.getNome());
			stmt.setString(3, servico.getDescricao());
			stmt.setDouble(4, servico.getPreco());
			stmt.execute();

		} catch (Exception e) {
			throw new BDException("Ocorreu um erro: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
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
			throw new BDException("Ocorreu um erro: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			}
		}
		
		return historicos;

	}

		public void alterarArrumacao(Arrumacao arrumacao) throws BDException {
			
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
				stmt = conn.prepareStatement("UPDATE arrumacao SET estado = ? WHERE numeroQuarto = ?");
				stmt.setString(1, arrumacao.getEstado());
				stmt.setInt(2, arrumacao.getNumeroQuarto());
				stmt.execute();

				int linhasAfetadas = stmt.executeUpdate();
				
				if (linhasAfetadas == 0) {
					throw new BDException("O número do quarto digitado é inválido");
				}
								
			} catch (Exception mensagem) {
				throw new BDException("Ocorreu um erro: " + mensagem.getMessage());

			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}

			}
		}
		
		public List<Arrumacao> leituraArrumacao() throws BDException {

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
				List<Arrumacao> limpeza = new ArrayList<>();
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
				stmt = conn.prepareStatement("SELECT * FROM arrumacao");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					 Arrumacao tabela = new Arrumacao();
					tabela.setNumeroQuarto(rs.getInt("numeroQuarto"));
					tabela.setEstado(rs.getString("estado"));
					
					limpeza.add(tabela);
				}				
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
			}
			
			return limpeza;

		}

		
		public void registroRestaurante(RestaurantePedidos pedidos) throws BDException {
			
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
				stmt = conn.prepareStatement("INSERT INTO restaurantepedidos(idReserva, refeicao, quantidade, dia, hora, observacao) VALUES(?,?,?,?,?,?)");
				stmt.setInt(1,pedidos.getIdReserva());
				stmt.setString(2, pedidos.getRefeicao());
				stmt.setInt(3, pedidos.getQuantidade());
				stmt.setDate(4, pedidos.getData());
				stmt.setTime(5, pedidos.getTime());
				stmt.setString(6, pedidos.getObservacao());
				stmt.execute();

								
			} catch (Exception mensagem) {
				throw new BDException("Ocorreu um erro: " + mensagem.getMessage());

			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}

			}
		}
		
		public List<RestaurantePedidos> leituraPedidos() throws BDException {

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
				List<RestaurantePedidos> comanda = new ArrayList<>();
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook", "root", "7135937");
				stmt = conn.prepareStatement("SELECT * FROM restaurantepedidos");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					 RestaurantePedidos tabela = new RestaurantePedidos();
					tabela.setIdpedido(rs.getInt("idPedido"));
					tabela.setIdReserva(rs.getInt("idReserva"));
					tabela.setRefeicao(rs.getString("refeicao"));
					tabela.setQuantidade(rs.getInt("quantidade"));
					Date data =	rs.getDate("dia");				
					tabela.setData(data.toLocalDate());
					
					Time time = rs.getTime("hora");
					tabela.setTime(time.toLocalTime());
					
					tabela.setObservacao(rs.getString("observacao"));
					comanda.add(tabela);
				}				
			} catch (Exception e) {
				throw new BDException("Ocorreu um erro: " + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					throw new BDException("Ocorreu um erro: " + e.getMessage());
				}
			}
			
			return comanda;

		}
	
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
