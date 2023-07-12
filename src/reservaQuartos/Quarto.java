package reservaQuartos;

public class Quarto {
	private int idQuartos;
	private String numeroQuarto;
	private String tipoQuarto;
	private String disponibilidade;
	private double precoQuarto;
	private String capacidade;
	private String descricaoQuarto;
	
	public Quarto(int idQuartos, String numeroQuarto, String tipoQuarto, String disponibilidade, double precoQuarto,
			String capacidade, String descricaoQuarto) {
		super();
		this.idQuartos = idQuartos;
		this.numeroQuarto = numeroQuarto;
		this.tipoQuarto = tipoQuarto;
		this.disponibilidade = disponibilidade;
		this.precoQuarto = precoQuarto;
		this.capacidade = capacidade;
		this.descricaoQuarto = descricaoQuarto;
	}

	public int getIdQuartos() {
		return idQuartos;
	}

	public void setIdQuartos(int idQuartos) {
		this.idQuartos = idQuartos;
	}

	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public double getPrecoQuarto() {
		return precoQuarto;
	}

	public void setPrecoQuarto(double precoQuarto) {
		this.precoQuarto = precoQuarto;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}

	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
	}
	
	
	
}
	
	
	