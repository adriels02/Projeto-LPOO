package data;

import core.PagamentoEntidade;

public interface PagamentoRepository {
	public PagamentoEntidade BuscarDadosFatura(int idFatura) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.
	
	public void inserirDadosBDFaturaReceberId(PagamentoEntidade pgmt) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.
	
	public PagamentoEntidade selectsBdUsandoCpf(String c) throws PagamentoDataException; // Quando chamado forca a construcao do metodo na classe e forca o lancamento da excecao.

	public PagamentoEntidade selectsBdUsandoIdreserva(int idFatura, PagamentoEntidade pgmt) throws PagamentoDataException;
	
	public PagamentoEntidade PegaridFatura(PagamentoEntidade pgmt)throws PagamentoDataException;
	

	
}
