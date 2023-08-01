package core;

import java.time.LocalDateTime;

public class RegistroServicoDeQuarto {
	private int IdRegistro;
	private int numeroDoQuarto;
	private int numeroReserva;
	private int quantidadeRefeicao;
	private String refeicao;
	private LocalDateTime datahora;
	private String observacoes;

	

	public RegistroServicoDeQuarto() {
		super();
	}





	public RegistroServicoDeQuarto(int numeroDoQuarto, int numeroReserva, int numeroDeRefeicao, String refeicao,
			LocalDateTime datahora, String observacoes) {
	
		this.numeroDoQuarto = numeroDoQuarto;
		this.numeroReserva = numeroReserva;
		this.quantidadeRefeicao = numeroDeRefeicao;
		this.refeicao = refeicao;
		this.datahora = datahora;
		this.observacoes = observacoes;
	}





	public int getIdRegistro() {
		return IdRegistro;
	}





	public void setIdRegistro(int idRegistro) {
		IdRegistro = idRegistro;
	}





	public int getNumeroDoQuarto() {
		return numeroDoQuarto;
	}



	public void setNumeroDoQuarto(int numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}



	public int getNumeroReserva() {
		return numeroReserva;
	}



	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}



	public int getQuantidadeRefeicao() {
		return quantidadeRefeicao;
	}



	public void setQuantidadeRefeicao(int quantidadeRefeicao) {
		this.quantidadeRefeicao = quantidadeRefeicao;
	}



	public String getRefeicao() {
		return refeicao;
	}



	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}



	public LocalDateTime getDatahora() {
		return datahora;
	}



	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}



	public String getObservacoes() {
		return observacoes;
	}



	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
