package br.edu.ifpe.paulista.pagamento.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagamentoGenericDAO {
    private Connection connection;

    protected PagamentoGenericDAO() throws PagamentoDataException { //Construtor da classe 
        this.connection = PagamentoMYSQLConnection.getConnection();
    }

    protected Connection getConnection() { //getter do atributo da classe
        return connection;
    }

    protected void insert(String insertSql, Object... parametros) throws SQLException { //Metodo com parametros  insert, comando do Mysql , e com varargs do tipo Object permitindo receber atributos para tabela fatura.
        PreparedStatement pstmt = 
			getConnection().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void update(String updateSql, Object id, Object... parametros) throws SQLException {//Metodo com parametros  update, comando do Mysql , id especificando onde ocorre update e com varargs do tipo Object permitindo receber atributos para tabela fatura.
        PreparedStatement pstmt = 
		getConnection().prepareStatement(updateSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void delete(String deleteSql, Object... parametros) throws SQLException { //Metodo com parametros  delete, comando do Mysql , e com varargs do tipo Object permitindo receber atributos para tabela fatura.
        PreparedStatement pstmt = 
		getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }
}
