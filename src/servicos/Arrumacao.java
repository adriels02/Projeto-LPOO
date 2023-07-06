package servicos;

public class Arrumacao extends Servico {

	private boolean arrumado;

	public Arrumacao(double preco, String descricao, String id) {
		super(preco, descricao, id);
	
	}

	public Arrumacao(String descricao, String id, boolean arrumado) {
		super( descricao, id);
		this.arrumado = arrumado;
	}

	public boolean isArrumado() {
		return arrumado;
	}

	public void setArrumado(boolean arrumado) {
		this.arrumado = arrumado;
	}

	
	
	
	
	
	
	
}
