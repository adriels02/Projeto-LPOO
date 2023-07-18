package servicosCore;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class HistoricoTranslado {

	private int idReserva;
	private String enderecoColeta;
	private String enderecoDestino;
	private int numeroPassageiros;
	private LocalDate data;
	private LocalTime hora;
	private int idViagem;
	

	public HistoricoTranslado(int idReserva, String enderecoColeta, String enderecoDestino, int passageiros,LocalDate data, LocalTime horario) {
		this.idReserva = idReserva;
		this.enderecoColeta = enderecoColeta;
		this.enderecoDestino = enderecoDestino;
		this.numeroPassageiros = passageiros;
		this.data = data;
		this.hora = horario;
	}
	
	public HistoricoTranslado() {
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public String getEnderecoColeta() {
		return enderecoColeta;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}


	public int getNumeroPassageiros() {
		return numeroPassageiros;
	}

	public Date getData() {
		 Date date = java.sql.Date.valueOf(data);
		 
		 return date;
	}

	public Time getHora() {
			Time time = java.sql.Time.valueOf(hora);
		return time;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setEnderecoColeta(String enderecoColeta) {
		this.enderecoColeta = enderecoColeta;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public void setNumeroPassageiros(int numeroPassageiros) {
		this.numeroPassageiros = numeroPassageiros;
	}

	public void setData(LocalDate date) {
		this.data = date;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
}
