package br.edu.ifpe.paulista.pagamento;

import java.sql.Date;

public class EntidadePagamento {
	private int idFatura;
	private int idCliente;
	private int idReserva;
	private String tipoPagamento;
	private double precoFinal;
	private String cpf;
	private Date data;
	private String nomecliente;
	private String nomeServicos[];
	private int precoSrevicos[];
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String[] getNomeServicos() {
		return nomeServicos;
	}
	public void setNomeServicos(String[] nomeServicos) {
		this.nomeServicos = nomeServicos;
	}
	public int[] getPrecoSrevicos() {
		return precoSrevicos;
	}
	public void setPrecoSrevicos(int[] precoSrevicos) {
		this.precoSrevicos = precoSrevicos;
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
	
}
