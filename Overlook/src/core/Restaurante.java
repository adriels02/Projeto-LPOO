package core;

import java.time.*;
import java.time.format.DateTimeFormatter;

import data.BDException;
import data.MySQLConector;


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
		
			throw new BDException( e.getMessage());
		}
		
		return valor;
	}

}
