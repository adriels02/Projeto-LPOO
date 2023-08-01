package core;

public class Quarto {
	private int numeroQuarto;
	private int andar;
	private String tipoQuarto;
	private boolean disponibilidade;
	private double precoQuarto;
	private int capacidade;
	private String descricaoQuarto;
	
	public Quarto() {
		
	}
	public Quarto(int numeroQuarto, int andar, String tipoQuarto, boolean disponibilidade, double precoQuarto,
			int capacidade, String descricaoQuarto) {
		
		this.numeroQuarto = numeroQuarto;
		this.andar = andar;
		this.tipoQuarto = tipoQuarto;
		this.disponibilidade = false;
		this.precoQuarto = precoQuarto;
		this.capacidade = capacidade;
		this.descricaoQuarto = descricaoQuarto;
	}
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public double getPrecoQuarto() {
		return precoQuarto;
	}
	public void setPrecoQuarto(double precoQuarto) {
		this.precoQuarto = precoQuarto;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}
	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
	}
	
	
	
}	
	