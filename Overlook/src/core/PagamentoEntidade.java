package core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PagamentoEntidade {//Entidade e seus getter e setters.
	private int idFatura;
	private int idCliente;
	private int idReserva;
	private ArrayList<Integer> reservas = new ArrayList<Integer>();
	private ArrayList<Integer> reservasNaoFaturadas = new ArrayList<Integer>();
	private String tipoPagamento;
	private double precoFinal;
	private String cpfOuCnpj;
	private String data;
	private String dataNasc;
	private String nomecliente;
	private ArrayList<String> nomeServico = new ArrayList<String>();
	private ArrayList<Double> precoServico = new ArrayList<Double>();
	private double precoTotalQuarto;
	public ArrayList<Integer> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Integer> reservas) {
		this.reservas = reservas;
	}
	public ArrayList<Integer> getReservasNaoFaturadas() {
		return reservasNaoFaturadas;
	}
	public void setReservasNaoFaturadas(ArrayList<Integer> reservasFaturadas) {
		this.reservasNaoFaturadas = reservasFaturadas;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpf) {
		this.cpfOuCnpj = cpf;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
	String x = dataNasc.substring(0, 4);
	String y = dataNasc.substring(5, 7);
	String z = dataNasc.substring(8);
		this.dataNasc = z+"/"+y+"/"+x;
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
	public double getTotalPrecoQuarto() {
		return precoTotalQuarto;
	}
	public void setTotalPrecoQuarto(double precoQuarto) {
		this.precoTotalQuarto = precoQuarto;
	}


}
