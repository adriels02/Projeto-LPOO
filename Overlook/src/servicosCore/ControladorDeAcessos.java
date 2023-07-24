package servicosCore;

import java.time.LocalDate;
import java.time.LocalTime;
import servicosBD.BDException;
import servicosBD.ControleAcessoBD;
import servicosBD.MySQLConector;
import reservaQuartos.*;

public class ControladorDeAcessos {

	private ControleAcessoBD repositorio;

	public ControladorDeAcessos(ControleAcessoBD repositorio) {
		this.repositorio = repositorio;
	}

	public ControladorDeAcessos() throws CoreException {
		try {
			repositorio = new MySQLConector();
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}

		public void RegistroHistoricoDeViagem(int idReserva, String enderecoColeta, String enderecoDestino, int passageiros,
			LocalDate data, LocalTime horario) throws CoreException {

		
		if (enderecoColeta.isBlank()) {
			throw new CoreException("O endereço de coleta está vazio");
		}

		if (enderecoDestino.isBlank()) {
			throw new CoreException("O endereço do Destino está vazio");
		}

		if (passageiros <= 0) {
			throw new CoreException("O número de passageiros é inválido");
		}

		if (passageiros > 12) {
			throw new CoreException("Número de passageiros excede o limite de transporte(12).");
		}

		if (enderecoColeta.equals(enderecoDestino)) {
			throw new CoreException("Os endereços de coleta e destino estão iguais");
		}

		HistoricoTranslado translado = new HistoricoTranslado(idReserva, enderecoColeta, enderecoDestino, passageiros, data, horario);

		try {
			repositorio.registroTranslado(translado);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void registroServiçoTranslado(int id, int passageiros) throws CoreException {

		Translado translado = new Translado(id, passageiros);

		try {
			repositorio.registroServico(translado);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void alterarArrumacao(int numeroQuarto , String estado) throws CoreException {
		
		
			if (numeroQuarto == 0) {
				throw new CoreException("Numero do Quarto é inválido");
			}
		
			Arrumacao arrumacao = new Arrumacao(numeroQuarto, estado);
			
			
			try {
				
				repositorio.alterarArrumacao(arrumacao);	
				
			}	catch (BDException mensagem) {
				throw new CoreException(mensagem.getMessage(), mensagem);
				
				
			}
	}
	
	public void registroServiçoEstacionamento(int id, int vagas) throws CoreException {
		
			if (id == 0) {
				throw new CoreException("O número de id é inválido");			
			}
		
			if (vagas == 0) {
				throw new CoreException("O número de vagas é inválido");			
			}
		
			if (vagas > 3) {
				throw new CoreException("O número digitado excedeu o limite de registros de vagas deuma só vez, que são 3 vagas");			
			}
		
		Estacionamento estacionamento = new Estacionamento(id, vagas);

		try {
			repositorio.registroServico(estacionamento);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}
	
	public void registroRestaurante (int idReserva, String refeicao, int quantidade, LocalDate data, LocalTime time, String observacao) throws CoreException{
		
			if (refeicao.equals("")) {
				throw new CoreException("O Tipo de refeição não foi selecionado");
			}
		
			if (idReserva == 0) {
				throw new CoreException("O ID da pessoa digitado é inválido. Por favor, digite um número válido.");			
			}
		
			if (quantidade == 0) {
				throw new CoreException("Quantidade da refeição é inválida. por favor, digite um número válido");
			}
		
			RestaurantePedidos restaurante = new RestaurantePedidos(data, time, quantidade, idReserva, observacao, refeicao);
			
			try {

				repositorio.registroRestaurante(restaurante);

			} catch (BDException mensagem) {
				throw new CoreException(mensagem.getMessage(), mensagem);
			}

		}
	
	public void registroServicoRestaurante(int id , String refeicao, int quantidade) throws CoreException {
		
		
		Restaurante restaurante = new Restaurante( id, refeicao, quantidade);
		
		try {
			repositorio.registroServico(restaurante);
		}	catch (BDException mensagem ) {
			
			throw new CoreException(mensagem.getMessage(), mensagem);
			
		}
		
	}
	
	
	public void registroReserva (int numeroQuarto, String CPF,LocalDate dataSaida, LocalDate dataEntrada, String observacoes) throws CoreException {
		
		
			if (numeroQuarto == 0) {
				throw new CoreException("O número do quarto digitado é invalido");
			}
		
			if (CPF.isBlank()){
				throw new CoreException("O campo CPF está vazio");
			}
		
			if (CPF.length() != 11) {
				throw new CoreException("O campo CPF foi preenchido incorretamente.");
			}
		
			Reserva reserva = new Reserva(numeroQuarto, CPF, dataEntrada, dataSaida, observacoes);
		
			try {
				
				
				repositorio.registroReserva(reserva);
				
			}	catch (BDException mensagem) {
				
				throw new CoreException(mensagem.getMessage());
			}
		
	}
	
	
	
	
	
	
	
}