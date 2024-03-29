package core;


import data.RelatorioDAO;
import data.RelatorioDataException;
import data.RelatorioRepository;

public class RelatorioController {

	private RelatorioRepository repository;

	public RelatorioController() throws RelatorioExcecoesRegraNegocio {
		try {
			repository = new RelatorioDAO();
		} catch (RelatorioDataException e) {

			throw new RelatorioExcecoesRegraNegocio(e.getMessage(), e);
		}
	}

	public RelatorioController(RelatorioRepository repository) {
		this.repository = repository;

	}
	public RelatorioEntidade selectRestaurante(String dataIniial, String dataFinal) throws RelatorioExcecoesRegraNegocio {
		try {

			RelatorioEntidade relaent = repository.selectRestaurante(dataIniial, dataFinal);
			return relaent;
		} catch (Exception e) {

			throw new RelatorioExcecoesRegraNegocio("erro.");

		}
	}

}
