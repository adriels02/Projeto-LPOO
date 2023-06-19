package servicos;

public class Wifi extends Servico {

	private String nome; // Nome do Wi-Fi
	private String senha; // senha do Wi-Fi

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Wifi(double preco, String descricao, String id, String nome, String senha) {
		super(preco, descricao, id);
		this.nome = nome;
		this.senha = senha;
	}

}
