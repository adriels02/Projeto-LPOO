package cadastroBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdConexao.AcessoBancodeDados;
import cadastroCORE.Dependentes;

public class CadastroDependenteDAO {
    Connection connection;

    public void cadastrarDependente(Dependentes dependente) throws ExceptionDAO {
        String sql = "INSERT INTO Dependente (cpf, nome, telefone, dataNascDependente, cpf_cliente) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        connection = new AcessoBancodeDados().conexaoBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dependente.getCpfDependente());
            preparedStatement.setString(2, dependente.getNomeDependente());
            preparedStatement.setString(3, dependente.getTelefoneDependente());
            preparedStatement.setDate(4, dependente.getDataNascimentoDependente());
            preparedStatement.setString(5, dependente.getCpfTitular());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar Dependente: " + e);
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

    public ArrayList<Dependentes> listarDependentes(String cpf) throws ExceptionDAO {
        String sql = "SELECT * FROM Dependente WHERE cpf_cliente = ? ORDER BY cpf";
        PreparedStatement preparedStatement = null;
        ArrayList<Dependentes> dependentes = new ArrayList<>();
        connection = new AcessoBancodeDados().conexaoBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Dependentes dependente = new Dependentes();
                dependente.setNomeDependente(rs.getString("nome"));
                dependente.setCpfDependente(rs.getString("cpf"));
                dependente.setTelefoneDependente(rs.getString("telefone"));
                dependente.setDataNascimentoDependente(rs.getDate("dataNascDependente"));
                dependente.setCpfTitular(rs.getString("cpf_cliente"));
                dependentes.add(dependente);
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar dependente: " + e);
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
        return dependentes;
    }

    public void alterarCadastroDependente(Dependentes dependente) throws ExceptionDAO {
        String sql = "UPDATE Dependente SET nome = ?, telefone = ?, dataNascDependente = ? WHERE cpf = ? AND cpf_cliente = ?";
        PreparedStatement preparedStatement = null;
        connection = new AcessoBancodeDados().conexaoBD();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dependente.getNomeDependente());
            preparedStatement.setString(2, dependente.getTelefoneDependente());
            preparedStatement.setDate(3, dependente.getDataNascimentoDependente());
            preparedStatement.setString(4, dependente.getCpfDependente());
            preparedStatement.setString(5, dependente.getCpfTitular());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao atualizar dependente: " + e);
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

    public void apagarCadastroDependente(Dependentes dependente) throws ExceptionDAO {
        String sql = "DELETE FROM Dependente WHERE cpf = ? AND cpf_cliente = ?";
        PreparedStatement preparedStatement = null;
        connection = new AcessoBancodeDados().conexaoBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dependente.getCpfDependente());
            preparedStatement.setString(2, dependente.getCpfTitular());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar dependente: " + e);
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
