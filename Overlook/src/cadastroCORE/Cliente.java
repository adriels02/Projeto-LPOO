package cadastroCORE;

import java.sql.Date;
import java.util.ArrayList;
import cadastroBD.CadastroClienteDAO;
import cadastroBD.ExceptionDAO;
import cadastroCORE.CadastroController;

public class Cliente {

	private String nome;
private String cpf;
private String telefone;
private String email;
private Date dataNascimento;

public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public Cliente(String nome, String cpf, String telefone, String email, Date dataNascimento) {
super();
this.nome = nome;
this.cpf = cpf;
this.telefone = telefone;
this.email = email;
this.dataNascimento = dataNascimento;
}
public Cliente() {
}
public String getCpf() {
return cpf;
}
public void setCpf(String cpf) {
this.cpf = cpf;
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
 public Date getDataNascimento() {
	 
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}
public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
 new CadastroClienteDAO().cadastrarCliente(cliente);
 }
 public ArrayList<Cliente> listarClientes(String CPF) throws ExceptionDAO {
 return new CadastroClienteDAO().listarClientes(CPF);
 }
 public void alterarCadastro(Cliente cliente) throws ExceptionDAO {
 new CadastroClienteDAO().alterarCadastro(cliente);
 }
 public void apagarCadastro(Cliente cliente) throws ExceptionDAO {
 new CadastroClienteDAO().apagarCadastro(cliente);
 }
}