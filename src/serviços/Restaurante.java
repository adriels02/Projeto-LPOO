package serviços;

public class Restaurante extends Serviço {

	private double precoCafeDaManha;
	private double precoAlmoco;
	private double precoJantar;

	public Restaurante(String descricao, String id) {

		super(descricao, id);

	}

	public double getPrecoCafeDaManha() {
		return precoCafeDaManha;
	}

	public void setPrecoCafeDaManha(double precoCafeDaManha) {
		this.precoCafeDaManha = precoCafeDaManha;
	}

	public double getPrecoAlmoco() {
		return precoAlmoco;
	}

	public void setPrecoAlmoco(double precoAlmoco) {
		this.precoAlmoco = precoAlmoco;
	}

	public double getPrecoJantar() {
		return precoJantar;
	}

	public void setPrecoJantar(double precoJantar) {
		this.precoJantar = precoJantar;
	}

}
