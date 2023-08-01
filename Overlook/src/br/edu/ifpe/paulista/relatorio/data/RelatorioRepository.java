package br.edu.ifpe.paulista.relatorio.data;

import br.edu.ifpe.paulista.relatorio.core.RelatorioEntidade;

public interface RelatorioRepository {
	public RelatorioEntidade selectRestaurante(String dataInicial, String dataFinal) throws RelatorioDataException ;
}
