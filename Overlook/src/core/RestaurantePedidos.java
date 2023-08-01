package core;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class RestaurantePedidos {

	private int idpedido;
	private LocalDate data;
	private LocalTime time;
	private int quantidade;
	private int idReserva;
	private String observacao;
	private String refeicao;

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public RestaurantePedidos(LocalDate data, LocalTime time, int quantidade, int idReserva, String observacao,	String refeicao) {
		
		this.data = data;
		this.time = time;
		this.quantidade = quantidade;
		this.idReserva = idReserva;
		this.observacao = observacao;
		this.refeicao = refeicao;
	}
	
	public RestaurantePedidos() {
		
	}

	public Date getData() {
		
		Date dia = Date.valueOf(data);
		
		return dia;
		
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Time getTime() {
		
		Time hora = Time.valueOf(time);
		
		return hora;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}
	
	
	
	
	
	
	
	
	
	
}
