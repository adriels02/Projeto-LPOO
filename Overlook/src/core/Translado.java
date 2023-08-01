package core;

import java.time.*;

import javax.swing.JOptionPane;

import data.BDException;
import data.ControleAcessoBD;
import data.MySQLConector;



public class Translado extends Servico {
	
	
	
	public Translado( int id, int passageiros) throws BDException {
		
		super(id, "Translado", "Serviço de transporte hoteleiro",adicionarPreco() * passageiros);
		
		
	
	}
	
		
		public static double adicionarPreco() throws BDException {
			
			double valor;
			
			try {
				MySQLConector conector = new MySQLConector();
			valor =	conector.consultarPreco(7);
				
			} catch (Exception e) {
			
				throw new BDException("erro: " + e.getMessage());
			}
			
			return valor;
		}
		
	
}

