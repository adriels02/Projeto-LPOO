package servicosCore;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Restaurante extends Servico {

	

	public Restaurante(int id,String refeicao ,int quantidade) {
		super(id, "Serviço do restaurante", "Refeição: " + refeicao, 20 * quantidade);
	}

	

}
