package serviços;

public class Serviços {

	private String descricao;
	private double preco;

	public Serviços(String descriçao, double preco) {

		this.descricao = descriçao;
		this.preco = preco;
	}
	
	public Serviços(double preco) {
		this.preco = preco;
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

}
