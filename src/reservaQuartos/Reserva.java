package reservaQuartos;

import java.time.LocalDateTime;

public class Reserva {
	private int numeroQuarto;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private String observacaoReserva;
	
	public Reserva(int numeroQuarto, LocalDateTime dataEntrada, LocalDateTime dataSaida, String observacaoReserva) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.observacaoReserva = observacaoReserva;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getObservacaoReserva() {
		return observacaoReserva;
	}

	public void setObservacaoReserva(String observacaoReserva) {
		this.observacaoReserva = observacaoReserva;
	}
	
}
