package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.ConnectionFactory;

public class CheckOutController {

    public void insert(CheckOut checkOut) {
        String sql = "INSERT INTO CheckOut (nome, checkOut, status) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, checkOut.getNome());
            statement.setDate(2, new Date(checkOut.getCheckOut().getTime()));
            statement.setBoolean(3, checkOut.isStatus());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar o check-out: " + ex.getMessage(), ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar o statement: " + ex.getMessage(), ex);
            } finally {
                ConnectionFactory.closeConnection(connection);
            }
        }
    }


    public void update(CheckOut checkOut) {
        String sql = "UPDATE CheckOut SET nome = ?, checkOut = ?, status = ? WHERE idCheckOut = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, checkOut.getNome());
            statement.setDate(2, new Date(checkOut.getCheckOut().getTime()));
            statement.setBoolean(3, checkOut.isStatus());
            statement.setInt(4, checkOut.getIdCheckOut());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar o check-out: " + ex.getMessage(), ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar o statement: " + ex.getMessage(), ex);
            } finally {
                ConnectionFactory.closeConnection(connection);
            }
        }
    }
    public void delete(int idCheckOut) {
        String sql = "DELETE FROM CheckOut WHERE idCheckOut = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, idCheckOut);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o check-out: " + ex.getMessage(), ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar o statement: " + ex.getMessage(), ex);
            } finally {
                ConnectionFactory.closeConnection(connection);
            }
        }
    }

    public List<CheckOut> getAll() {
        String sql = "SELECT * FROM CheckOut";

        List<CheckOut> checkOuts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CheckOut checkOut = new CheckOut(0, sql, null, null, false);
                checkOut.setIdCheckOut(resultSet.getInt("idCheckOut"));
                checkOut.setNome(resultSet.getString("nome"));
                checkOut.setCheckOut(resultSet.getDate("checkOut"));
                checkOut.setStatus(resultSet.getBoolean("status"));
                checkOuts.add(checkOut);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar a lista de check-outs: " + ex.getMessage(), ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar o resultSet: " + ex.getMessage(), ex);
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException("Erro ao fechar o statement: " + ex.getMessage(), ex);
                } finally {
                    ConnectionFactory.closeConnection(connection);
                }
            }
        }

        return checkOuts;
    }
}
