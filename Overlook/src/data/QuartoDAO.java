package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import core.Quarto;

public class QuartoDAO {
	
	static Connection conn;

	public static void cadastrarQuarto(Quarto quarto) throws BDException {
		String sql = "INSERT INTO Quarto(numeroQuarto,andar, tipoQuarto, disponibilidade, precoQuarto, capacidade,descricaoQuarto) VALUES(?,?,?,?,?,?,?)";
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
			stmt.execute() ;
			
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
		ArrayList<Quarto> quartos = new ArrayList<Quarto>();
		String sql = "SELECT * FROM Quarto WHERE numeroQuarto = ? ORDER BY numeroQuarto";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, numeroQuarto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               Quarto quarto = new Quarto(); 
               quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
               quarto.setAndar(rs.getInt("andar"));
               quarto.setTipoQuarto(rs.getString("tipoQuarto"));
               quarto.setDisponibilidade(rs.getBoolean("disponibilidade"));
               quarto.setPrecoQuarto(rs.getDouble("precoQuarto"));
               quarto.setCapacidade(rs.getInt("capacidade"));
               quarto.setDescricaoQuarto(rs.getString("descricaoQuarto"));
               
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
	
	public ArrayList<Quarto> listar() throws BDException {
		ArrayList<Quarto> quartos = new ArrayList<Quarto>();
		String sql = "SELECT * FROM Quarto ";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               Quarto quarto = new Quarto(); 
               quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
               quarto.setAndar(rs.getInt("andar"));
               quarto.setTipoQuarto(rs.getString("tipoQuarto"));
               quarto.setDisponibilidade(rs.getBoolean("disponibilidade"));
               quarto.setPrecoQuarto(rs.getDouble("precoQuarto"));
               quarto.setCapacidade(rs.getInt("capacidade"));
               quarto.setDescricaoQuarto(rs.getString("descricaoQuarto"));
               
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
	
	
	public  boolean editar (Quarto quarto)throws BDException {
		String sql = "UPDATE Quarto SET numeroQuarto = ?, idReserva = null, andar = ?, tipoQuarto = ?, disponibilidade = ?, precoQuarto = ?, capacidade = ?, descricaoQuarto = ? WHERE numeroQuarto = ?";
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
		return false;
	}
	
	public boolean deletar (Quarto quarto) throws BDException{
		String sql= "DELETE FROM Quarto WHERE numeroQuarto = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quarto.getNumeroQuarto());
			int rowsDeleted = stmt.executeUpdate();
	        
		       
			return rowsDeleted > 0;
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
	       
	   public boolean VerificarNumeroQuarto (int numeroCadastro) throws BDException {
		   		String sql = "SELECT COUNT(*) FROM Quarto WHERE numeroQuarto = ?";
		   		PreparedStatement stmt = null;
		        
		        try  { 
		        	conn = new AcessoBancodeDados().conexaoBD();
		        	stmt = conn.prepareStatement(sql);
		            stmt.setInt(1, numeroCadastro);
		            
		            ResultSet resultSet = stmt.executeQuery();
		            
		            if (resultSet.next()) {
		                int count = resultSet.getInt(1);
		                if (count > 0) {
		                	 JOptionPane.showMessageDialog(null,"Já existe um quarto com esse número." );
		                }   
		            }
		        }catch (SQLException e) {
					throw new BDException("Erro ao verificar número do quarto " + e);
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
				return true;
	   } 
}





