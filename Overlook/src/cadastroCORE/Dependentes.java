package cadastroCORE;

import java.sql.Date;
import java.util.ArrayList;

import cadastroBD.CadastroDependenteDAO;
import cadastroBD.ExceptionDAO;

public class Dependentes {
	private String nomeDependente;
	private String cpfTitular;
	private String cpfDependente;
	private String telefoneDependente;
	private Date dataNascimentoDependente;
	


	public Dependentes(String nomeDependente, String cpfTitular, String cpfDependente, String telefoneDependente,
			Date dataNascimentoDependente) {
		super();
		this.nomeDependente = nomeDependente;
		this.cpfTitular = cpfTitular;
		this.cpfDependente = cpfDependente;
		this.telefoneDependente = telefoneDependente;
		this.dataNascimentoDependente = dataNascimentoDependente;
	}
	public Dependentes() {
	}
	public String getNomeDependente() {
		return nomeDependente;
	}
	public void setNomeDependente(String nomeDependente) {
		this.nomeDependente = nomeDependente;
	}
	public String getCpfDependente() {
		return cpfDependente;
	}
	public void setCpfDependente(String cpfDependente) {
		this.cpfDependente = cpfDependente;
	}
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	public String getTelefoneDependente() {
		return telefoneDependente;
	}
	public void setTelefoneDependente(String telefoneDependente) {
		this.telefoneDependente = telefoneDependente;
	}
	public Date getDataNascimentoDependente() {
		return dataNascimentoDependente;
	}
	public void setDataNascimentoDependente(Date dataNascimentoDependente) {
		this.dataNascimentoDependente = dataNascimentoDependente;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimentoDependente = dataNascimento;
	}
	
	public void cadastrarDependente(Dependentes dependente) throws ExceptionDAO {
	 new CadastroDependenteDAO().cadastrarDependente(dependente);
	 }
	 public ArrayList<Dependentes> listarDependentes(String cpf) throws ExceptionDAO {
	 return new CadastroDependenteDAO().listarDependentes(cpf);
	 }
	 public void alterarCadastroDependente(Dependentes dependente) throws ExceptionDAO {
	 new CadastroDependenteDAO().alterarCadastroDependente(dependente);
	 }
	 public void apagarCadastroDependente(Dependentes dependente) throws ExceptionDAO {
	 new CadastroDependenteDAO().apagarCadastroDependente(dependente);
	 }
}
