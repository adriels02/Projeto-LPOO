package core;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
	
	private String CPF;
	private int idReserva;
	private int numeroQuarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String observacaoReserva;
	
	public Reserva(int numeroQuarto,String CPF ,LocalDate dataEntrada, LocalDate dataSaida, String observacaoReserva) {
		super();
		this.CPF = CPF;
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.observacaoReserva = observacaoReserva;
	}

	public Reserva() {
		
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		
		Date date = Date.valueOf(dataEntrada);
		return date ;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		
		Date date = Date.valueOf(dataSaida);
		
		return date;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getObservacaoReserva() {
		return observacaoReserva;
	}

	public void setObservacaoReserva(String observacaoReserva) {
		this.observacaoReserva = observacaoReserva;
	}
	
	
}
