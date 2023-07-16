package servicosCore;

public class Servico {
	
	private String id;
	private double preco;
	private String descricao;

	public Servico() {
		
	}
	
	
	public Servico(double preco, String descricao, String id) {

		this.preco = preco;
		this.descricao = descricao;
		this.id = id;
	}
	
	public Servico( String descricao, String id) {

		this.descricao = descricao;
		this.id = id;
	}
	

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}