package servicos;

import java.time.*;

public class Translado extends Servico {

	private String enderecoColeta;
	private String enderecoDestino;
	private int passageiros;
	private LocalTime horario;
	private LocalDate data;

	public Translado(int passageiros, String enderecoColeta, String enderecoDestino, LocalTime horario,
			LocalDate data) {

		this.passageiros = passageiros;
		this.enderecoColeta = enderecoColeta;
		this.enderecoDestino = enderecoDestino;
		this.horario = horario;
		this.data = data;

	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	public String getEnderecoColeta() {
		return enderecoColeta;
	}

	public void setEnderecoColeta(String enderecoColeta) {
		this.enderecoColeta = enderecoColeta;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public String historicoDeViagem() {

		return "coleta: " + enderecoColeta + " / destino: " + enderecoDestino
				+ " /passageiros: " + passageiros + " / Data: " + data + " / Hora: " + horario;
	}

}
