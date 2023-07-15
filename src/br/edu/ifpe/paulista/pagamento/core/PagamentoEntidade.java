package br.edu.ifpe.paulista.pagamento.core;

import java.sql.Date;
import java.util.ArrayList;

public class PagamentoEntidade {//Entidade e seus getter e setters.
	private int idFatura;
	private int idCliente;
	private int idReserva;
	private String tipoPagamento;
	private double precoFinal;
	private String cpfOuCnpj;
	private Date data;
	private String nomecliente;
	private ArrayList<String> nomeServico = new ArrayList<String>();
	private ArrayList<Double> precoServico = new ArrayList<Double>();
	private double precoQuarto;
	
	public String getCpf() {
		return cpfOuCnpj;
	}
	public void setCpf(String cpf) {
		this.cpfOuCnpj = cpf;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public int getIdFatura() {
		return idFatura;
	}
	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public double getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<String> getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(ArrayList<String> nomeServico) {
		this.nomeServico = nomeServico;
	}
	public ArrayList<Double> getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(ArrayList<Double> precoServico) {
		this.precoServico = precoServico;
	}
	public double getPrecoQuarto() {
		return precoQuarto;
	}
	public void setPrecoQuarto(double precoQuarto) {
		this.precoQuarto = precoQuarto;
	}
	
}
