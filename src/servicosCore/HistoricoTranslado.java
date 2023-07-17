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

	

	public HistoricoTranslado(int idReserva, String enderecoColeta, String enderecoDestino, int passageiros,LocalDate data, LocalTime horario) {
		this.idReserva = idReserva;
		this.enderecoColeta = enderecoColeta;
		this.enderecoDestino = enderecoDestino;
		this.numeroPassageiros = passageiros;
		this.data = data;
		this.hora = horario;
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
}
