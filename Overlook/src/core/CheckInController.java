package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.ConnectionFactory;

public class CheckInController { 

    public void insert(CheckIn checkIn) { 
        String sql = "INSERT INTO CheckIn (nome, checkIn, atualizarCheckIn, status) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, checkIn.getNome());
            statement.setDate(2, new Date(checkIn.getCheckIn().getTime()));
            statement.setDate(3, new Date(checkIn.getAtualizarCheckIn().getTime()));
            statement.setBoolean(4, checkIn.isStatus());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar o check-in: " + ex.getMessage(), ex);
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

    public void update(CheckIn checkIn) { // Troca de CheckOut para CheckIn
        String sql = "UPDATE CheckIn SET nome = ?, checkIn = ?, atualizarCheckIn = ?, status = ? WHERE idCheckIn = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, checkIn.getNome());
            statement.setDate(2, new Date(checkIn.getCheckIn().getTime()));
            statement.setDate(3, new Date(checkIn.getAtualizarCheckIn().getTime()));
            statement.setBoolean(4, checkIn.isStatus());
            statement.setInt(5, checkIn.getIdCheckIn());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar o check-in: " + ex.getMessage(), ex);
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

    public void delete(int idCheckIn) { // Troca de CheckOut para CheckIn
        String sql = "DELETE FROM CheckIn WHERE idCheckIn = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, idCheckIn);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o check-in: " + ex.getMessage(), ex);
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

    public List<CheckIn> getAll() { 
        String sql = "SELECT * FROM CheckIn";

        List<CheckIn> checkIns = new ArrayList<>(); 
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CheckIn checkIn = new CheckIn(0, sql, null, null, false);
                checkIn.setIdCheckIn(resultSet.getInt("idCheckIn"));
                checkIn.setNome(resultSet.getString("nome"));
                checkIn.setCheckIn(resultSet.getDate("checkIn"));
                checkIn.setAtualizarCheckIn(resultSet.getDate("atualizarCheckIn"));
                checkIn.setStatus(resultSet.getBoolean("status"));
                checkIns.add(checkIn);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar a lista de check-ins: " + ex.getMessage(), ex);
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

        return checkIns; 
    }
}