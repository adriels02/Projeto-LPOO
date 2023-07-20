package cadastroCORE;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import cadastroBD.ExceptionDAO;
import cadastroCORE.Cliente;
import cadastroGUI.CadastroInterface;

public class CadastroController {
 
	public boolean cadastrarCliente(String nome, String cpf, String telefone, String email,String dataNascimento) throws ParseException {
 
		if (nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && telefone != null && telefone.length() > 0 && email != null && email.length() > 0 && validarCpf(cpf) && validarData(dataNascimento)) {
 
 
 Cliente cliente = new Cliente(nome, cpf,telefone, email, dataNascimento);
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
public boolean validarCpf(String cpf){
 for (int i = 0; i < cpf.length();i++){
 if (! Character.isDigit(cpf.charAt(i))){
 if (! (i==3 || i == 7 || i == 11)){
 return false;
 }
 }
 }
 return true;
} 
 
 public boolean validarData(String dataNascimento){
 if(dataNascimento.length() != 9){
 return false;
 }
 for (int i = 0; i < dataNascimento.length();i++){
 if (! Character.isDigit(dataNascimento.charAt(i))){
 if (! (i==2 || i == 5)){
 return false;
 }
 }
 }
 return true;
} 
 
 
 public ArrayList<Cliente> listarClientes(String CPF) throws ExceptionDAO {
 return new Cliente().listarClientes(CPF);
 }
 public boolean alterarCadastro(String nome, String cpf, String telefone, String email, String dataNascimento) {
 if (nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && telefone != 
null && telefone.length() > 0 && email != null && email.length() > 0 && dataNascimento != null && dataNascimento.length() > 0) {
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


 
 public boolean cadastrarDependente(String nomeDependente, String cpfTitular, String cpfDependente, String telefoneDependente,String dataNascimentoDependente) throws ParseException {
	 
		if (nomeDependente != null && nomeDependente.length() > 0 && cpfTitular != null && cpfTitular.length() > 0 && cpfDependente != null && cpfDependente.length() > 0 && telefoneDependente != null && telefoneDependente.length() > 0 && dataNascimentoDependente != null && dataNascimentoDependente.length() > 0) {


Cliente cliente = new Cliente(nomeDependente, cpfTitular,cpfDependente,telefoneDependente,dataNascimentoDependente);
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

 public boolean validarCpfDependente(String cpfDependente){
for (int i = 0; i < cpfDependente.length();i++){
if (! Character.isDigit(cpfDependente.charAt(i))){
if (! (i==3 || i == 7 || i == 11)){
return false;
}
}
}
return true;
} 
 
 
 
 
 
}