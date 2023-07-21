package servicosCore;

import java.time.*;

public class Translado extends Servico {
	
	
	public Translado( int id, int passageiros) {
		super(id, "Translado", "Serviço de transporte hoteleiro", 30 * passageiros);
	}
}

	