package serviços;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Restaurante extends Serviço {

	private double precoCafeDaManha;
	private double precoAlmoco;
	private double precoJantar;

	public Restaurante(String descricao, String id) {

		super(descricao, id);

	}
	
	public Restaurante() {

		super();

	}

	public double getPrecoCafeDaManha() {
		return precoCafeDaManha;
	}

	public void setPrecoCafeDaManha(double precoCafeDaManha) {
		this.precoCafeDaManha = precoCafeDaManha;
	}

	public double getPrecoAlmoco() {
		return precoAlmoco;
	}

	public void setPrecoAlmoco(double precoAlmoco) {
		this.precoAlmoco = precoAlmoco;
	}

	public double getPrecoJantar() {
		return precoJantar;
	}

	public void setPrecoJantar(double precoJantar) {
		this.precoJantar = precoJantar;
	}
	
	public String historicoRestaurante(String refeicao,int id, String observacao) {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String tempoAtual = now.format(formatter);
		
		
		return "Data e hora solicitada: " + tempoAtual + " / Tipo de refeição: " + refeicao + " / ID do quarto: " + id + " / Observação: " + observacao;
	}

}
