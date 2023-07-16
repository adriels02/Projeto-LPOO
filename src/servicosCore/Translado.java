package servicosCore;

import java.time.*;

public class Translado extends Servico {

	private String nome;
	private String descricao;
	private double preco;

	public Translado(String nome, String descricao, int preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(int preco) {
		this.preco = preco;
	}


	public String historicoDeViagem(String enderecoColeta, String enderecoDestino, int passageiros , LocalDate data, LocalTime horario) throws ServicosException {

		if (enderecoColeta.isBlank()) {
			throw new ServicosException("O endereço de coleta está vazio");
		}
		
		if (enderecoDestino.isBlank()) {
			throw new ServicosException("O endereço do Destino está vazio");
		}
		
		if (passageiros <= 0) {
			throw new ServicosException("O número de passageiros é inválido");
		}
		
		if (passageiros > 12) {
			throw new ServicosException("Número de passageiros excede o limite de transporte(12).");
		}
		
		if (enderecoColeta.equals(enderecoDestino)) {
			throw new ServicosException("Os endereços de coleta e destino estão iguais");
			
		}
		
		
		
		return "coleta: " + enderecoColeta + " / destino: " + enderecoDestino
				+ " /passageiros: " + passageiros + " / Data: " + data + " / Hora: " + horario;
	}

}