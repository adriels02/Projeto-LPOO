package servicosCore;

public class Wifi  {

	private String nome = "Stephen King";
	private String senha = "O_ILUMINADO";
	
	
	
	
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


	


	public void registrarInformacoes(String nome, String senha) throws CoreException{
		
		if (nome.isBlank()) {
			throw new CoreException("O campo nome está vazio");			
		}
		
		if (senha.isBlank()) {
			throw new CoreException("O campo senha está vazio");			
		}
		
		if (senha.length() < 8) {
			
			throw new CoreException("A senha precisa ter no mínimo 8 caracteres");
			
		}
		
		
		this.nome = nome;
		this.senha = senha;	
	}
	
	
	
	
	
	
	

}
