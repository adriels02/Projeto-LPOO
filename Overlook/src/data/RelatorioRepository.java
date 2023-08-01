package data;

import core.RelatorioEntidade;

public interface RelatorioRepository {
	public RelatorioEntidade selectRestaurante(String dataInicial, String dataFinal) throws RelatorioDataException ;
}
