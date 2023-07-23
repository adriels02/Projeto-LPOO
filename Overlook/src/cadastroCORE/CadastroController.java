package cadastroCORE;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import cadastroBD.ExceptionDAO;
import cadastroCORE.Cliente;
import cadastroGUI.CadastroInterface;

public class CadastroController {
 
	public boolean cadastrarCliente(String nome, String cpf, String telefone, String email, String dataNascimento) throws ParseException {
 
		if (nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && telefone != null && telefone.length() > 0 && email != null && email.length() > 0) {
 
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
			
			Date data = new Date(formato.parse(dataNascimento).getTime());

			
 Cliente cliente = new Cliente(nome, cpf,telefone, email, data);
 try {
 cliente.cadastrarCliente(cliente);
 return true;
 } catch (ExceptionDAO e) {
 e.printStackTrace();
 return false;
 }
 }
 return false;
 }
 
 public ArrayList<Cliente> listarClientes(String CPF) throws ExceptionDAO {
 return new Cliente().listarClientes(CPF);
 }
 
 
 public boolean alterarCadastro(String nome, String cpf, String telefone, String email, Date dataNascimento) {
 if (nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && telefone != 
null && telefone.length() > 0 && email != null && email.length() > 0 && dataNascimento != null) {
 Cliente cliente = new Cliente(nome,cpf,telefone, email,dataNascimento);
 try {
 cliente.alterarCadastro(cliente);
 return true;
 } catch (ExceptionDAO e) {
 e.printStackTrace();
 return false;
 }
 }
 return false;
 }
 
 
 public boolean apagarCadastro(String cpf) {
 if (cpf != null && cpf.length() > 0) {
 Cliente cliente = new Cliente();
 cliente.setCpf(cpf);
 try {
 cliente.apagarCadastro(cliente);
 return true;
 } catch (ExceptionDAO e) {
 e.printStackTrace();
 return false;
 }
 }
 return false;
 }

 
 
}