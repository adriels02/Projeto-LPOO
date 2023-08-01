package quartoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import bdConexao.AcessoBancodeDados;
import cadastroBD.ExceptionDAO;
import cadastroCORE.Cliente;
import servicosBD.BDException;
import quartoCORE.Quarto;

public class QuartoDAO {
	public int totalRegistro;
	
	public void conectar () throws BDException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception Mensagem) {
			throw new BDException("Ocorreu o seguinte erro: " + Mensagem);
		}
	}

	public static void cadastrarQuarto(Quarto quarto) throws BDException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(
					"INSERT INTO Quarto(numeroQuarto,andar, tipoQuarto, disponibilidade, precoQuarto,\r\n"
					+ "	capacidade,descricaoQuarto) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, quarto.getNumeroQuarto());
			stmt.setInt(2, quarto.getAndar());
			stmt.setString(3, quarto.getTipoQuarto());
			stmt.setBoolean(4, quarto.isDisponibilidade());
			stmt.setDouble(5, quarto.getPrecoQuarto());
			stmt.setString(6, quarto.getCapacidade());
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
	
	
	public DefaultTableModel mostrarQuarto (String buscar) throws BDException {
		DefaultTableModel modelo; //Dados carregados na tabela, definido como modelo.
		String[]titulos = {"Numero","Andar","TipoQuarto","Estado", "Preco","Capacidade", "Descricao" };
		String[]registro = new String[7];
		totalRegistro = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		modelo = new DefaultTableModel (null, titulos);
		String sql = "SELECT * FROM Quarto WHERE anadar LIKE '%" + buscar + "%' ORDER BY numeroQuarto";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = (PreparedStatement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               registro [0] = rs.getString("numeroQuarto");
               registro [1] = rs.getString("andar");
               registro [2] = rs.getString("TipoQuarto");
               registro [3] = rs.getString("Disponibilidade");
               registro [4] = rs.getString("precoQuarto");
               registro [5] = rs.getString("Capacidade");
               registro [6] = rs.getString("Descricao");
               
               totalRegistro++;
               modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            throw new BDException("Erro ao exibir quarto: " + e);
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
	
	public void editarQuarto (Quarto quarto)throws BDException {
		String sql = "UPDATE Quarto SET numeroQuarto = ?, andar = ?, tipoQuarto = ?, disponibilidade = ?, \\r\\n"
				+ ", precoQuarto = ?, capacidade = ?, descricao = ? WHERE numeroQuarto = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, quarto.getNumeroQuarto());
			stmt.setInt(2, quarto.getAndar());
			stmt.setString(3, quarto.getTipoQuarto());
			stmt.setBoolean(4, quarto.isDisponibilidade());
			stmt.setDouble(5, quarto.getPrecoQuarto());
			stmt.setString(6, quarto.getCapacidade());
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
	
	public void deletarQuarto (Quarto quarto) throws BDException{
		String sql= "DELETE FROM Quarto WHERE numeroQuarto = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/overlook_db", "overlook_user", "#BDhotel123");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, quarto.getNumeroQuarto());
			
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

	
}




