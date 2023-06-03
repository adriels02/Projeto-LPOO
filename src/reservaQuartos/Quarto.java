package reservaQuartos;

public class Quarto {
	private int numeroQuarto;
	private String tipoQuarto;
	private boolean disponibilidade;
	private double precoDiario;
	private int capacidade;
	private String descricao;
	private String observacao;

	
	public Quarto(int numeroQuarto, String tipoQuarto, boolean disponibilidade,double precoDiario, int capacidade,
			String descricao, String observacao) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.tipoQuarto = tipoQuarto;
		this.disponibilidade = disponibilidade;
		this.precoDiario = precoDiario;
		this.capacidade = capacidade;
		this.descricao = descricao;
		this.observacao = observacao;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
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
	
	public double getPrecoDiario() {
		return precoDiario;
	}

	public void setPrecoDiario(double precoDiario) {
		this.precoDiario = precoDiario;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
