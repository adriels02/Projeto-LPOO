package br.edu.ifpe.paulista.relatorio.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.edu.ifpe.paulista.pagamento.core.PagamentoEntidade;
import br.edu.ifpe.paulista.pagamento.data.PagamentoDataException;
import br.edu.ifpe.paulista.relatorio.core.RelatorioEntidade;

public class RelatorioDAO implements RelatorioRepository {
	public RelatorioDAO() throws RelatorioDataException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new PagamentoDataException("Conexão com o banco de daodos não estabelecida", e);
		}
	}
	public RelatorioEntidade selectDadosParaGraficos(String dataInicial, String dataFinal) {
		PreparedStatement stmt;
		ResultSet rs;
		String selectServicos = "SELECT numeroQuarto FROM Servico WHERE idReserva = ?";
		stmt = getConnection().prepareStatement(selectServicos);
		stmt.setDa(1, r);
		rs = stmt.executeQuery();

		ArrayList<String> nomeServico = new ArrayList<String>();

		while (rs.next()) {

			nomeServico.add(rs.getString("nomeServico"));
		}

	}
}
