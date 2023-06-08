package cadastroCliente;

public class Cliente {
private String nome;
private String sobrenome;
private String cpf;
private String cnpj;
private String telefone;
private String email;
private boolean pessoaFisica;
private boolean pessoaJuridica;
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getSobrenome() {
	return sobrenome;
}
public void setSobrenome(String sobrenome) {
	this.sobrenome = sobrenome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getCnpj() {
	return cnpj;
}
public void setCnpj(String rg) {
	this.cnpj = rg;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean isPessoaFisica() {
	return pessoaFisica;
}
public void setPessoaFisica(boolean pessoaFisica) {
	this.pessoaFisica = pessoaFisica;
}
public boolean isPessoaJuridica() {
	return pessoaJuridica;
}
public void setPessoaJuridica(boolean pessoaJuridica) {
	this.pessoaJuridica = pessoaJuridica;
}



}
