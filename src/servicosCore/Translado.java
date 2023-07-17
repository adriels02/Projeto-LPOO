package servicosCore;

import java.time.*;

public class Translado extends Servico {
	
	
	public Translado( int id, int passageiros) {
		super(id, "Translado", "Serviço de transporte hoteleiro", 30 * passageiros);
	}
	
	
	
	
	
	
	
	
	public String historicoDeViagem(String enderecoColeta, String enderecoDestino, int passageiros , LocalDate data, LocalTime horario) throws ServicosException {

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
		
		
		
		return "coleta: " + enderecoColeta + " / destino: " + enderecoDestino
				+ " /passageiros: " + passageiros + " / Data: " + data + " / Hora: " + horario;
	}

}