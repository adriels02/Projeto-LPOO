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

		public void RegistroHistoricoDeViagem(int idReserva, String enderecoColeta, String enderecoDestino, int passageiros,
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

		HistoricoTranslado translado = new HistoricoTranslado(idReserva, enderecoColeta, enderecoDestino, passageiros, data, horario);

		try {
			repositorio.registroTranslado(translado);
		} catch (BDException mensagem) {
			throw new ServicosException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void registroServiçoTranslado(int id, int passageiros) throws ServicosException {

		Translado translado = new Translado(id, passageiros);

		try {
			repositorio.registroServico(translado);
		} catch (BDException mensagem) {
			throw new ServicosException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void alterarArrumacao(int numeroQuarto , String estado) throws ServicosException {
		
		
			if (numeroQuarto == 0) {
				throw new ServicosException("Numero do Quarto é inválido");
			}
		
			Arrumacao arrumacao = new Arrumacao(numeroQuarto, estado);
			
			
			try {
				
				repositorio.alterarArrumacao(arrumacao);	
				
			}	catch (BDException mensagem) {
				throw new ServicosException(mensagem.getMessage(), mensagem);
				
				
			}
	}
	
	public void registroServiçoEstacionamento(int id, int vagas) throws ServicosException {
		
			if (id == 0) {
				throw new ServicosException("O número de id é inválido");			
			}
		
			if (vagas == 0) {
				throw new ServicosException("O número de vagas é inválido");			
			}
		
			if (vagas > 3) {
				throw new ServicosException("O número digitado excedeu o limite de registros de vagas deuma só vez, que são 3 vagas");			
			}
		
		Estacionamento estacionamento = new Estacionamento(id, vagas);

		try {
			repositorio.registroServico(estacionamento);
		} catch (BDException mensagem) {
			throw new ServicosException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void registroRestaurante (int idReserva, String refeicao, int quantidade, LocalDate data, LocalTime time, String observacao) throws ServicosException{
		
			if (refeicao.equals("")) {
				throw new ServicosException("O Tipo de refeição não foi selecionado");
			}
		
			if (idReserva == 0) {
				throw new ServicosException("O ID da pessoa digitado é inválido. Por favor, digite um número válido.");			
			}
		
			if (quantidade == 0) {
				throw new ServicosException("Quantidade da refeição é inválida. por favor, digite um número válido");
			}
		
			RestaurantePedidos restaurante = new RestaurantePedidos(data, time, quantidade, idReserva, observacao, refeicao);
			
			try {

				repositorio.registroRestaurante(restaurante);

			} catch (BDException mensagem) {
				throw new ServicosException(mensagem.getMessage(), mensagem);
			}

		}
	
	
	
	
}