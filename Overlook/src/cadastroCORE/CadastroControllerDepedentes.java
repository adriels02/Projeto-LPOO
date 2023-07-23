package cadastroCORE;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import cadastroBD.ExceptionDAO;

public class CadastroControllerDepedentes {

	public boolean cadastrarDependente(String nomeDependente, String cpfTitular, String cpfDependente, String telefoneDependente,Date dataNascimentoDependente) throws ParseException {
		 
		if (nomeDependente != null && nomeDependente.length() > 0 && cpfTitular != null && cpfTitular.length() > 0 && cpfDependente != null && cpfDependente.length() > 0 && telefoneDependente != null && telefoneDependente.length() > 0 && dataNascimentoDependente != null) {


Dependentes dependente = new Dependentes(nomeDependente, cpfTitular,cpfDependente,telefoneDependente,dataNascimentoDependente);
try {
dependente.cadastrarDependente(dependente);
return true;
} catch (ExceptionDAO e) {
e.printStackTrace();
return false;
}
}
return false;
}
	
	public ArrayList<Dependentes> listarDependentes(String cpf) throws ExceptionDAO {
		 return new Dependentes().listarDependentes(cpf);
		 }
	
	
		 public boolean alterarCadastroDependente(String nomeDependente, String cpfTitular, String cpfDependente, String telefoneDependente,Date dataNascimentoDependente) {
		 if (nomeDependente != null && nomeDependente.length() > 0 && cpfTitular != null && cpfTitular.length() > 0 && cpfDependente != null && cpfDependente.length() > 0 && telefoneDependente != null && telefoneDependente.length() > 0 && dataNascimentoDependente != null) {
		 Dependentes dependente = new Dependentes(nomeDependente, cpfTitular,cpfDependente,telefoneDependente,dataNascimentoDependente);
		 try {
		 dependente.alterarCadastroDependente(dependente);
		 return true;
		 } catch (ExceptionDAO e) {
		 e.printStackTrace();
		 return false;
		 }
		 }
		 return false;
		 }
	
		 
		 public boolean apagarCadastroDependente(String cpf) {
			 if (cpf != null && cpf.length() > 0) {
			 Dependentes dependente = new Dependentes();
			 dependente.setCpfDependente(cpf);
			 try {
			 dependente.apagarCadastroDependente(dependente);
			 return true;
			 } catch (ExceptionDAO e) {
			 e.printStackTrace();
			 return false;
			 }
			 }
			 return false;
			 }
		 
}
