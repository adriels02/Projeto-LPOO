package core;

public class Arrumacao extends Servico {

	private int numeroQuarto;
	private String estado;
	
	
	public Arrumacao(double preco, String descricao, int id, String nome) {
		super(id, nome, descricao, preco);

	}
	
	public Arrumacao(int numeroQuarto, String estado) {
		super();
		this.estado = estado;
		this.numeroQuarto = numeroQuarto;	
	}

	public Arrumacao() {
		
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
