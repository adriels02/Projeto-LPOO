package servicosBD;

import reservaQuartos.Reserva;
import servicosCore.Arrumacao;
import servicosCore.HistoricoTranslado;
import servicosCore.Precos;
import servicosCore.RegistroServicoDeQuarto;
import servicosCore.RestaurantePedidos;
import servicosCore.Servico;
import servicosCore.Translado;

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