package br.edu.ifpe.paulista.pagamento.core;

import br.edu.ifpe.paulista.pagamento.data.PagamentoDataException;
import br.edu.ifpe.paulista.pagamento.data.PagamentoRepository;
import br.edu.ifpe.paulista.pagamento.data.PagamentoDAO;

public class PagamentoController {

	private PagamentoRepository repository;

	public PagamentoController() throws PagamentoExcecoesRegraNegocio {
		try {
			repository = new PagamentoDAO();

		} catch (PagamentoDataException e) {

			throw new PagamentoExcecoesRegraNegocio(e.getMessage(), e);
		}
	}

	public PagamentoController(PagamentoRepository repository) {
		this.repository = repository;

	}

	public static boolean acharCHInvalido(String c) {
		char[] ch = c.toCharArray();
		boolean invalido = false;
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '1':
				i++;
				break;
			case '2':
				i++;
				break;
			case '3':
				i++;
				break;
			case '4':
				i++;
				break;
			case '5':
				i++;
				break;
			case '6':
				i++;
				break;
			case '7':
				i++;
				break;
			case '8':
				i++;
				break;
			case '9':
				i++;
				break;
			default:
				invalido = true;
			}
		}
		return invalido;
	}

	public void inserirDadosController(PagamentoEntidade pgmt) throws PagamentoExcecoesRegraNegocio {

	}

	public void buscarDadosController(int idFatura) throws PagamentoExcecoesRegraNegocio {

	}

	public void construirEntidadeController(String c) throws PagamentoExcecoesRegraNegocio {
		if (c.trim().isBlank()) {

			throw new PagamentoExcecoesRegraNegocio("Insira os números do documento");
		}

		if (acharCHInvalido(c) == true) {

			throw new PagamentoExcecoesRegraNegocio(
					"Símbolo inválido inserido. Por favor Tente novamente Com somente números.");
		}

		/*
		 * try { EntidadePagamento controllerPgmt = repository.BDConstruirEntidade(c);
		 * 
		 * 
		 * } catch (PagamentoDataException e) {
		 * 
		 * throw new PagamentoExcecoesRegraNegocio(e.getMessage(), e);
		 * 
		 * }
		 */ }

}
