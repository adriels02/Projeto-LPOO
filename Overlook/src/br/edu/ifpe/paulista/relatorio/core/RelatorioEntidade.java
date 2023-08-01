package br.edu.ifpe.paulista.relatorio.core;

public class RelatorioEntidade {

	private int totalReservas;
	private double duracaoMediaEstadia;
	private String ServicosMaisContratados;
	private String ServicosMenosContratados;
	private double valorMedioFaturas;
	private double valorMedioServicos;
	private String QuartoMaisReservado;
	private String QuartoMenosReservado;

	public int getTotalReservas() {
		return totalReservas;
	}
	public void setTotalReservas(int totalReservas) {
		this.totalReservas = totalReservas;
	}
	public double getDuracaoMediaEstadia() {
		return duracaoMediaEstadia;
	}
	public void setDuracaoMediaEstadia(double duracaoMediaEstadia) {
		this.duracaoMediaEstadia = duracaoMediaEstadia;
	}
	public String getServicosMaisContratados() {
		return ServicosMaisContratados;
	}
	public void setServicosMaisContratados(String servicosMaisContratados) {
		ServicosMaisContratados = servicosMaisContratados;
	}
	public String getServicosMenosContratados() {
		return ServicosMenosContratados;
	}
	public void setServicosMenosContratados(String servicosMenosContratados) {
		ServicosMenosContratados = servicosMenosContratados;
	}
	public double getValorMedioFaturas() {
		return valorMedioFaturas;
	}
	public void setValorMedioFaturas(double valorMedioFaturas) {
		this.valorMedioFaturas = valorMedioFaturas;
	}
	public double getValorMedioServicos() {
		return valorMedioServicos;
	}
	public void setValorMedioServicos(double valorMedioServicos) {
		this.valorMedioServicos = valorMedioServicos;
	}
	public String getQuartoMaisReservado() {
		return QuartoMaisReservado;
	}
	public void setQuartoMaisReservado(String quartoMaisReservado) {
		QuartoMaisReservado = quartoMaisReservado;
	}
	public String getQuartoMenosReservado() {
		return QuartoMenosReservado;
	}
	public void setQuartoMenosReservado(String quartoMenosReservado) {
		QuartoMenosReservado = quartoMenosReservado;
	}
}
