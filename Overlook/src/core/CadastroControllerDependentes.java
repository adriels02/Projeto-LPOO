package core;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.ExceptionDAO;

public class CadastroControllerDependentes {

	public boolean cadastrarDependente(String nomeDependente, String cpfTitular, String cpfDependente,
			String telefoneDependente, String dataNascimentoDependente) throws ParseException {

		if (nomeDependente != null && nomeDependente.length() > 0 && cpfTitular != null && cpfTitular.length() > 0
				&& cpfDependente != null && cpfDependente.length() > 0 && telefoneDependente != null
				&& telefoneDependente.length() > 0 && dataNascimentoDependente != null) {
			
			
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			Date data = new Date(formato.parse(dataNascimentoDependente).getTime());
			
			Dependentes dependente = new Dependentes(nomeDependente, cpfTitular, cpfDependente, telefoneDependente,data);
			try {
				dependente.cadastrarDependente(dependente);
				return true;
			} catch (ExceptionDAO e) {
				JOptionPane.showMessageDialog(null, "Erro!");
				return false;
			}
		}
		return false;
	}

	public ArrayList<Dependentes> listarDependentes(String cpf) throws ExceptionDAO {
		return new Dependentes().listarDependentes(cpf);
	}

	public boolean alterarCadastroDependente(String nomeDependente, String cpfDependente, String telefoneDependente,
			Date dataNascimentoDependente, String cpfTitular) {
		if (nomeDependente != null && nomeDependente.length() > 0 && cpfTitular != null && cpfTitular.length() > 0
				&& cpfDependente != null && cpfDependente.length() > 0 && telefoneDependente != null
				&& telefoneDependente.length() > 0 && dataNascimentoDependente != null) {
			Dependentes dependente = new Dependentes(nomeDependente, cpfTitular, cpfDependente, telefoneDependente,
					dataNascimentoDependente);
			try {
				dependente.alterarCadastroDependente(dependente);
				return true;
			} catch (ExceptionDAO e) {
				JOptionPane.showMessageDialog(null, "Erro!");
				return false;
			}
		}
		return false;
	}

	public boolean apagarCadastroDependente(String cpf, String cpfTitular) {
		if (cpf != null && cpf.length() > 0 && cpfTitular != null && cpfTitular.length() > 0) {
			Dependentes dependente = new Dependentes();
			dependente.setCpfDependente(cpf);
			dependente.setCpfTitular(cpfTitular);
			try {
				dependente.apagarCadastroDependente(dependente);
				return true;
			} catch (ExceptionDAO e) {
				JOptionPane.showMessageDialog(null, "Erro!");
				return false;
			}
		}
		return false;
	}

}
