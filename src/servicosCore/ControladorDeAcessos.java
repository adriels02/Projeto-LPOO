package servicosCore;

import java.time.LocalDate;
import java.time.LocalTime;
import servicosBD.BDException;
import servicosBD.ControleAcessoBD;
import servicosBD.MySQLConector;

public class ControladorDeAcessos {

	private ControleAcessoBD repositorio;

	public ControladorDeAcessos(ControleAcessoBD repositorio) {
		this.repositorio = repositorio;
	}

	public ControladorDeAcessos() throws ServicosException {
		try {
			repositorio = new MySQLConector();
		} catch (BDException mensagem) {
			throw new ServicosException(mensagem.getMessage(), mensagem);
		}
	}

	public void RegistroHistoricoDeViagem(String enderecoColeta, String enderecoDestino, int passageiros,
			LocalDate data, LocalTime horario) throws ServicosException {

		if (enderecoColeta.isBlank()) {
			throw new ServicosException("O endereço de coleta está vazio");
		}

		if (enderecoDestino.isBlank()) {
			throw new ServicosException("O endereço do Destino está vazio");
		}

		if (passageiros <= 0) {
			throw new ServicosException("O número de passageiros é inválido");
		}

		if (passageiros > 12) {
			throw new ServicosException("Número de passageiros excede o limite de transporte(12).");
		}

		if (enderecoColeta.equals(enderecoDestino)) {
			throw new ServicosException("Os endereços de coleta e destino estão iguais");
		}

		Translado translado = new Translado("teste", "descricao", 10);

		try {
			repositorio.registroTranslado(translado);
		} catch (BDException mensagem) {
			throw new ServicosException(mensagem.getMessage(), mensagem);
		}
	}

}