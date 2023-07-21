package cadastroCORE;

import cadastroBD.CadastroClienteDAO;
import cadastroBD.ExceptionDAO;

public class Dependentes {
	private String nomeDependente;
	private String cpfTitular;
	private String cpfDependente;
	public Dependentes(String nomeDependente, String cpfTitular, String cpfDependente, String telefoneDependente,
			String dataNascimentoDependente) {
		super();
		this.nomeDependente = nomeDependente;
		this.cpfTitular = cpfTitular;
		this.cpfDependente = cpfDependente;
		this.telefoneDependente = telefoneDependente;
		this.dataNascimentoDependente = dataNascimentoDependente;
	}

	private String telefoneDependente;
	private String dataNascimentoDependente;
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
	public String getDataNascimentoDependente() {
		return dataNascimentoDependente;
	}
	public void setDataNascimentoDependente(String dataNascimentoDependente) {
		this.dataNascimentoDependente = dataNascimentoDependente;
	}
	
	public void cadastrarDependente(Cliente cliente) throws ExceptionDAO {
		 new CadastroClienteDAO().cadastrarCliente(cliente);
		 }
}
