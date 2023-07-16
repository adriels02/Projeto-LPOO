package servicosCore;

public class Estacionamento extends Servico {

	private int reservaDeVagas;

	public Estacionamento(double preco, String descricao, String id, int reservaDeVagas) {
		super(preco, descricao, id);
		this.reservaDeVagas = reservaDeVagas;
	}

	public int getReservaDeVagas() {
		return reservaDeVagas;
	}

	public void setReservaDeVagas(int reservaDeVagas) {
		this.reservaDeVagas = reservaDeVagas;
	}

	public void setPreco() {
		super.setPreco(getPreco() * reservaDeVagas);
	}

}
