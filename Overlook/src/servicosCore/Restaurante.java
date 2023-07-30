package servicosCore;

import java.time.*;
import java.time.format.DateTimeFormatter;

import servicosBD.BDException;
import servicosBD.MySQLConector;


public class Restaurante extends Servico {

	

	public Restaurante(int id,String refeicao ,int quantidade) throws BDException {
		super(id, "Serviço do restaurante", "Refeição: " + refeicao, adicionarPreco() * quantidade);
	}

	public static double adicionarPreco() throws BDException {
		
		double valor;
		
		try {
			MySQLConector conector = new MySQLConector();
		valor =	conector.consultarPreco(4);
			
		} catch (Exception e) {
		
			throw new BDException("erro: " + e.getMessage());
		}
		
		return valor;
	}

}
