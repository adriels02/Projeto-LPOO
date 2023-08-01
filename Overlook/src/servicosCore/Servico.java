package servicosCore;

public class Servico {
	
	private int idServico;
	private int idReserva;
	private String nome;
	private String descricao;
	private double preco;

	public Servico(int idReserva, String nome, String descricao, double preco) {

		this.idReserva = idReserva;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Servico() {
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	


}