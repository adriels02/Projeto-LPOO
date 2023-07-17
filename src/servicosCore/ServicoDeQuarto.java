package servicosCore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServicoDeQuarto extends Servico {

	LocalDateTime dataHoraAtual = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	String dataHoraFormatada = dataHoraAtual.format(formatter);
	private double taxa;

	public ServicoDeQuarto(int id, String nome, String descricao,double preco, double taxa) {
		super(id, nome, descricao, preco);
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double precoCafeDaManha(Restaurante restaurante) {

		return taxa + restaurante.getPrecoCafeDaManha();

	}

	public double precoAlmoco(Restaurante restaurante) {

		return taxa + restaurante.getPrecoAlmoco();

	}

	public double precoJantar(Restaurante restaurante) {

		return taxa + restaurante.getPrecoJantar();

	}

}