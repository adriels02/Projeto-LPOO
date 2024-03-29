package core;

public class RelatorioEntidade {

	private int totalReservas;
	private double duracaoMediaEstadia;
	private String ServicosMaisContratados;
	private String ServicosMenosContratados;
	private double valorMedioFaturas;
	private double valorMedioServicos;
	private String QuartoMaisReservado;
	private String QuartoMenosReservado;
	private int almoco;
	private int cafeManha;
	private int jantar;
	
	public int getAlmoco() {
		return almoco;
	}
	public void setAlmoco(int almoco) {
		this.almoco = almoco;
	}
	public int getCafeManha() {
		return cafeManha;
	}
	public void setCafeManha(int cafeManha) {
		this.cafeManha = cafeManha;
	}
	public int getJantar() {
		return jantar;
	}
	public void setJantar(int jantar) {
		this.jantar = jantar;
	}
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
