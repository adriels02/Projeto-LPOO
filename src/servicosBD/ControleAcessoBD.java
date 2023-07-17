package servicosBD;

import servicosCore.HistoricoTranslado;
import servicosCore.Translado;

public interface ControleAcessoBD {




	public void registroTranslado(HistoricoTranslado translado) throws BDException;
	
	public void registroServicoTranslado(Translado translado) throws BDException;

}