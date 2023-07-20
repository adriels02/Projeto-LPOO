package servicosBD;

import servicosCore.Arrumacao;
import servicosCore.HistoricoTranslado;
import servicosCore.RestaurantePedidos;
import servicosCore.Servico;
import servicosCore.Translado;

public interface ControleAcessoBD {




	public void registroTranslado(HistoricoTranslado translado) throws BDException;
	
	public void registroServico(Servico servico) throws BDException;
	
	public void alterarArrumacao(Arrumacao arrumacao) throws BDException;
	
	public void registroRestaurante(RestaurantePedidos pedidos) throws BDException;

}