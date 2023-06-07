package serviços;

public class Translado extends Serviço {

	private String enderecoColeta;
	private String enderecoDestino;
	
	
	public Translado(double preco, String descricao) {
		super(preco, descricao, descricao);

	}


	public String getEnderecoColeta() {
		return enderecoColeta;
	}


	public void setEnderecoColeta(String enderecoColeta) {
		this.enderecoColeta = enderecoColeta;
	}


	public String getEnderecoDestino() {
		return enderecoDestino;
	}


	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}


	
	
	
	
	
}
