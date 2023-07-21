package br.edu.ifpe.paulista.pagamento.data;

import br.edu.ifpe.paulista.pagamento.core.PagamentoEntidade;

public interface PagamentoRepository {
	public PagamentoEntidade BuscarDadosFatura(int idFatura) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.
	
	public void InserirDadosBDFatura(PagamentoEntidade pgmt) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.
	
	public PagamentoEntidade BDConstruirEntidade(String c, String tipoPagamento) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.
	

	
}
