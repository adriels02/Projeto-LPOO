package quartoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import quartoGUI.InterfaceCadastroDeQuartos;
import bdConexao.AcessoBancodeDados;
import servicosBD.BDException;
import quartoCORE.Quarto;

public class QuartoDAO {
	
	static Connection conn;

	public static void cadastrarQuarto(Quarto quarto) throws BDException {
		String sql = "INSERT INTO Quarto(numeroQuarto,andar, tipoQuarto, disponibilidade, precoQuarto,\r\n"
				+ "	capacidade,descricaoQuarto) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			conn = new AcessoBancodeDados().conexaoBD();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quarto.getNumeroQuarto());
			stmt.setInt(2, quarto.getAndar());
			stmt.setString(3, quarto.getTipoQuarto());
			stmt.setBoolean(4, quarto.isDisponibilidade());
			stmt.setDouble(5, quarto.getPrecoQuarto());
			stmt.setInt(6, quarto.getCapacidade());
			stmt.setString(7, quarto.getDescricaoQuarto());
			stmt.executeUpdate() ;
			
		} catch (SQLException e) {
			throw new BDException("Ocorreu um erro ao tentar cadastrar o quarto: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
                throw new BDException("Erro ao fechar a conexão: " + e);
			} finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new BDException("Erro ao fechar a conexão: " + e);
                }
            }
		}
	}
	
	
	public ArrayList<Quarto> listarQuartos(int numeroQuarto) throws BDException {
		ArrayList<Quarto> quartos = new ArrayList<>();
		String sql = "SELECT * FROM Quarto WHERE andar LIKE ? ORDER BY numeroQuarto";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = (PreparedStatement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               Quarto quarto = new Quarto(); 
               quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
               quarto.setAndar(rs.getInt("andar"));
               quarto.setTipoQuarto(rs.getString("tipoQuarto"));
               quarto.setDisponibilidade(rs.getBoolean("disponibilidade"));
               quarto.setPrecoQuarto(rs.getDouble("precoQuarto"));
               quarto.setCapacidade(rs.getInt("capacidade"));
               quarto.setDescricaoQuarto(rs.getString("descricao"));
               
               quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw new BDException("Erro ao listar quartos: " + e);
        } finally {
        	try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
                throw new BDException("Erro ao fechar a conexão: " + e);
			} finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new BDException("Erro ao fechar a conexão: " + e);
                }
            }
        }
		return quartos;
	}
	
	public void editar (Quarto quarto)throws BDException {
		String sql = "UPDATE Quarto SET numeroQuarto = ?, andar = ?, tipoQuarto = ?, disponibilidade = ?, \\r\\n"
				+ ", precoQuarto = ?, capacidade = ?, descricao = ? WHERE numeroQuarto = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quarto.getNumeroQuarto());
			stmt.setInt(2, quarto.getAndar());
			stmt.setString(3, quarto.getTipoQuarto());
			stmt.setBoolean(4, quarto.isDisponibilidade());
			stmt.setDouble(5, quarto.getPrecoQuarto());
			stmt.setInt(6, quarto.getCapacidade());
			stmt.setString(7, quarto.getDescricaoQuarto());
			stmt.execute();
			
		}catch (SQLException e) {
			throw new BDException("Erro ao editar cadastro do quarto: " + e);
		}finally {
        	try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
                throw new BDException("Erro ao fechar a conexão: " + e);
			} finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new BDException("Erro ao fechar a conexão: " + e);
                }
            }
        }
	}
	
	public void deletar (Quarto quarto) throws BDException{
		String sql= "DELETE FROM Quarto WHERE numeroQuarto = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quarto.getNumeroQuarto());
			stmt.execute();
			
		}catch (SQLException e) {
			throw new BDException("Erro ao apagar quarto: " + e);
		}finally {
        	try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
                throw new BDException("Erro ao fechar a conexão: " + e);
			} finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new BDException("Erro ao fechar a conexão: " + e);
                }
            }
	}
		
	 }
	
	   public DefaultTableModel carregarTabela() throws BDException {
	    	DefaultTableModel modelo = new DefaultTableModel();
	    	modelo.setNumRows(0);

	        modelo.addColumn("N° Quarto");
	        modelo.addColumn("Andar");
	        modelo.addColumn("Tipo de Quarto");
	        modelo.addColumn("Disponibilidade");
	        modelo.addColumn("Valor Diaria");
	        modelo.addColumn("Capacidade");
	        modelo.addColumn("Descricao");

	        PreparedStatement stmt = null;
	        Connection conn = null;

	        try {
	            conn = new AcessoBancodeDados().conexaoBD();
	            ResultSet rs;

	            stmt = conn.prepareStatement("SELECT * FROM Quarto");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                modelo.addRow(new Object[]{
	                        rs.getInt(1),
	                        rs.getInt(2),
	                        rs.getString(3),
	                        rs.getBoolean(4),
	                        rs.getDouble(5),
	                        rs.getInt(6),
	                        rs.getString(7)
	                });
	            }
	        } catch (SQLException e) {
				throw new BDException("Erro ao apagar quarto: " + e);
			}finally {
	        	try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
	                throw new BDException("Erro ao fechar a conexão: " + e);
				} finally {
	                try {
	                    if (conn != null) {
	                        conn.close();
	                    }
	                } catch (SQLException e) {
	                    throw new BDException("Erro ao fechar a conexão: " + e);
	                }
	            }
		}
			return modelo;
			
		 }
	       
}




