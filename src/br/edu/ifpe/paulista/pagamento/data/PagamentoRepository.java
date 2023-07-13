package br.edu.ifpe.paulista.pagamento.data;

import br.edu.ifpe.paulista.pagamento.core.EntidadePagamento;

public interface PagamentoRepository {
	public void BuscarDadosFatura() throws PagamentoDataException;
	
	public void InserirDadosBDFatura(EntidadePagamento pgmt) throws PagamentoDataException;
	
	public void BDConstruirEntidade(String c) throws PagamentoDataException;
	

	
}
