package core;

import data.BDException;
import data.MySQLConector;

public class Estacionamento extends Servico {

	public Estacionamento(int vagas, int id) throws BDException {
		
		super(id, "Estacionamento", "Serviço de estacionamento do hotel", adicionarPreco() * vagas);
		
	}
	
	public static double adicionarPreco() throws BDException {
		
		double valor;
		
		try {
			MySQLConector conector = new MySQLConector();
		valor =	conector.consultarPreco(6);
			
		} catch (Exception e) {
		
			throw new BDException("erro: " + e.getMessage());
		}
		
		return valor;
	}
	
	
	
	
	
	
	
}
