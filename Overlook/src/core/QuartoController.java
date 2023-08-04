package core;
//package quartoCORE;
//
//import servicosBD.BDException;
//import quartoCORE.Quarto;
//import quartoBD.QuartoDAO;
//
//
//public class QuartoController {
//	
//	public boolean cadastrarQuarto (String numeroQuarto, int andar,String tipoQuarto,String disponibilidade,
//			double precoQuarto,String capacidade,String descricaoQuarto) throws BDException {
//		
//		if(numeroQuarto != null && numeroQuarto.length() == 0 ) {
//			throw new BDException ("Insira um número de quarto válido");
//		}
//		if (descricaoQuarto != null && descricaoQuarto.length() == 0 ) {
//			throw new BDException ("Insira uma descrição para o quarto");
//		}
//		 try {
//			 double preco = Double.parseDouble(precoQuarto + "");
//	         if (preco < 0) {
//	                throw new NumberFormatException();
//	            }
//	        } catch (NumberFormatException ex) {
//	            throw new BDException("Insira um preço válido");
//	        }
//		if(precoQuarto < 0 ) {
//			throw new BDException ("Insira um preço válido");
//		}
//		
//		int quarto = Integer.parseInt(numeroQuarto);
//		
//		Quarto quarto = new Quarto(quarto, andar, tipoQuarto, disponibilidade,precoQuarto, capacidade, descricaoQuarto);
//			try {
//				quarto.cadastrarQuarto(quarto);
//				return true;
//			}catch (BDException e){
//				
//			}
//	}
//}
