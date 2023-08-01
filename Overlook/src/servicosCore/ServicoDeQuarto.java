package servicosCore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import servicosBD.BDException;
import servicosBD.MySQLConector;

public class ServicoDeQuarto extends Servico {


	public ServicoDeQuarto(int id, int quantidadeRefeicoes, String refeicao ) throws BDException {
		super(id, "Serviço de Quarto", "Itens pedidos: " + quantidadeRefeicoes + " " + refeicao, adicionarPreco() * quantidadeRefeicoes + adicionarTaxa());
		
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

 public static double adicionarTaxa() throws BDException {
		
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