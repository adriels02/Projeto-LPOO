package data;

import core.Arrumacao;
import core.HistoricoTranslado;
import core.Precos;
import core.RegistroServicoDeQuarto;
import core.Reserva;
import core.RestaurantePedidos;
import core.Servico;
import core.Translado;

public interface ControleAcessoBD {




	public void registroTranslado(HistoricoTranslado translado) throws BDException;
	
	public void registroServico(Servico servico) throws BDException;
	
	public void alterarArrumacao(Arrumacao arrumacao) throws BDException;
	
	public void registroRestaurante(RestaurantePedidos pedidos) throws BDException;
	
	public void registroReserva(Reserva reserva) throws BDException;
	
	public void registroPrecos(Precos precos) throws BDException;
	
	public void registroServicoDeQuarto(RegistroServicoDeQuarto registro) throws BDException;
	
	public void exclusaoHistoricoTranslado(int id) throws BDException;
	
	public void exclusaoServico(int id) throws BDException;

	public void exclusaoServicoQuarto(int id) throws BDException;

	public void exclusaoRestaurante(int id) throws BDException;

}