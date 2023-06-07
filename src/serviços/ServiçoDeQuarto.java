package serviços;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiçoDeQuarto extends Serviço {

	LocalDateTime dataHoraAtual = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	String dataHoraFormatada = dataHoraAtual.format(formatter);
	private double taxa;

	public ServiçoDeQuarto(double preco, String descricao, String id, double taxa) {
		super(preco, descricao, id);
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
