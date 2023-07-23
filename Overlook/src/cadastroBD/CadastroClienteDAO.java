package cadastroBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import cadastroCORE.Cliente;
import bdConexao.AcessoBancodeDados;
import cadastroBD.ExceptionDAO;

public class CadastroClienteDAO {
    Connection connection;

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "INSERT INTO Cliente (cpf, nomeCliente, telefone, email, dataNascCliente) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        connection = new AcessoBancodeDados().conexaoBD();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setDate(5, cliente.getDataNascimento());

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
        AcessoBancodeDados acessoBanco = new AcessoBancodeDados();

        try {

            connection = acessoBanco.conexaoBD();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + cpf + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nomeCliente"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDataNascimento(rs.getDate("dataNascCliente"));
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
        String sql = "UPDATE Cliente SET nomeCliente = ?, telefone = ?, email = ?, dataNascCliente = ? WHERE cpf = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        AcessoBancodeDados acessoBanco = new AcessoBancodeDados();
        try {
        	connection = new AcessoBancodeDados().conexaoBD();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTelefone());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setDate(4, cliente.getDataNascimento());
            preparedStatement.setString(5, cliente.getCpf());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao atualizar cadastro: " + e);
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
        String sql = "DELETE FROM Cliente WHERE NomeCliente = ? AND cpf = ? AND telefone = ? AND email = ? AND dataNascCliente = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        AcessoBancodeDados acessoBanco = new AcessoBancodeDados();

        try {
        	connection = new AcessoBancodeDados().conexaoBD();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setDate(5, cliente.getDataNascimento());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar o cadastro: " + e);
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
