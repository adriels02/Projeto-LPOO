package core;

public class Precos {

	private int id;
	private String nome;
	private double preco;

	public Precos() {
	}

	public Precos(double preco, int id) {
		this.preco = preco;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
