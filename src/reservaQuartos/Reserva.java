package reservaQuartos;

public class Reserva {
	private int id;
	private Quarto quarto;
	private int dataEntrada;
	private int dataSaida;
	private boolean confirmacao;
	
	public Reserva(int id, Quarto quarto, int dataEntrada, int dataSaida, boolean confirmacao) {
		super();
		this.id = id;
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.confirmacao = confirmacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public int getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(int dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(int dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean isConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(boolean confirmacao) {
		this.confirmacao = confirmacao;
	}
	
	
}
