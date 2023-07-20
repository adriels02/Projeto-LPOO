package cadastroBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cadastroCORE.Cliente;
import bdConexao.AcessoBancodeDados;
import cadastroBD.ExceptionDAO;

public class CadastroClienteDAO {

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "INSERT INTO Cliente (NomeCliente, cpf, telefone, email, dataNascimento) VALUES (?, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook","root","#123Mila123*");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setString(4, cliente.getDataNascimento());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar cliente: " + e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
                }
            }
        }
    }

    public ArrayList<Cliente> listarClientes(String cpf) throws ExceptionDAO {
        String sql = "SELECT * FROM Cliente WHERE cpf LIKE ? ORDER BY cpf";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
        	connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook","root","#123Mila123*");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + cpf + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nomeCliente"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar hóspede: " + e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
                }
            }
        }
        return clientes;
    }

    public void alterarCadastro(Cliente cliente) throws ExceptionDAO {
        String sql = "UPDATE Cliente SET nomeCliente = ? WHERE cpf = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        	connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook","root","#123Mila123*");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar cadastro: " + e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
                }
            }
        }
    }

    public void apagarCadastro(Cliente cliente) throws ExceptionDAO {
        String sql = "DELETE FROM Cliente WHERE Nome = ? AND CPF = ? AND Telefone = ? AND email = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        	connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/overlook","root","#123Mila123*");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar o cadastro: " + e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
                }
            }
        }
    }
}
