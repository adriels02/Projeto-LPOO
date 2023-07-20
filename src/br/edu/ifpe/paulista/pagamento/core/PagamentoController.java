package br.edu.ifpe.paulista.pagamento.core;

import br.edu.ifpe.paulista.pagamento.data.PagamentoDataException;
import br.edu.ifpe.paulista.pagamento.data.PagamentoRepository;
import br.edu.ifpe.paulista.pagamento.data.PagamentoDAO;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;  
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;  

public class PagamentoController {

	private PagamentoRepository repository;

	public PagamentoController() throws PagamentoExcecoesRegraNegocio {
		try {
			repository = new PagamentoDAO();

		} catch (PagamentoDataException e) {

			throw new PagamentoExcecoesRegraNegocio(e.getMessage(), e);
		}
	}

	public PagamentoController(PagamentoRepository repository) {
		this.repository = repository;

	}

	public boolean acharCHInvalido(String c) throws PagamentoExcecoesRegraNegocio {
		char[] ch = c.toCharArray();
		boolean invalido = false;
		for (int i = 0; i < ch.length;) {
			switch (ch[i]) {
			case '0':
				i++;
				break;
			case '1':
				i++;
				break;
			case '2':
				i++;
				break;
			case '3':
				i++;
				break;
			case '4':
				i++;
				break;
			case '5':
				i++;
				break;
			case '6':
				i++;
				break;
			case '7':
				i++;
				break;
			case '8':
				i++;
				break;
			case '9':
				i++;
				break;
			default:
				invalido = true;
			}
		}
		return invalido;
	}
	public void criarPdf(PagamentoEntidade pgmt) throws PagamentoExcecoesRegraNegocio {
		final String senhaUser = "honduras";  
		final String senhaMaster = "senegal";
		final String enderecoDocumentos = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();  
		ArrayList<String> nomeServico = pgmt.getNomeServico();
		ArrayList<Double> precoServico = pgmt.getPrecoServico();
		HashMap<String, String> mapNomePreco = new HashMap<String, String>(); 
		try {
			FileOutputStream fos = new FileOutputStream(enderecoDocumentos+"\\"+ pgmt.getIdFatura() +".pdf");  

			Document doc = new Document();

			PdfWriter writer = PdfWriter.getInstance(doc, fos);  

			writer.setEncryption(senhaUser.getBytes(), senhaMaster.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);  

			doc.open();

			doc.add(new Paragraph("                      		  Overlook"));  
			doc.add(new Paragraph("                                       "));  
			doc.add(new Paragraph("                                       "));  
			doc.add(new Paragraph("                                       "));  
			doc.add(new Paragraph("                                       "));  
			doc.add(new Paragraph("                                       "));  
			doc.add(new Paragraph("Nome:" + pgmt.getNomecliente()));  
			doc.add(new Paragraph("Cpf/Cnpj:" + pgmt.getCpfOuCnpj()+""));
			doc.add(new Paragraph("Tipo de Pagamento:" + pgmt.getTipoPagamento()+""));
			doc.add(new Paragraph("Data:" + pgmt.getData()+""));
			doc.add(new Paragraph("ID da Fatura:" + pgmt.getIdFatura()+""));
			doc.add(new Paragraph("Preço do(s) Quarto(s):" + pgmt.getPrecoQuarto()+""));
			
			
			for (int i = 0; i < nomeServico.size(); i++) {
			    mapNomePreco.put(nomeServico.get(i), precoServico.get(i).toString());
			}
			for (String i : mapNomePreco.keySet()) {
			      doc.add(new Paragraph("Serviço: " + i + " Preço: R$" + mapNomePreco.get(i)));
			    }
			doc.add(new Paragraph("Total										R$" + pgmt.getPrecoQuarto()+""));
			doc.close();
			fos.close(); 
		}
		catch (Exception e) {
			throw new PagamentoExcecoesRegraNegocio("erro ao criar pdf");
			}
	}

	public void inserirDadosController(PagamentoEntidade pgmt) throws PagamentoExcecoesRegraNegocio {

	}

	public void buscarDadosController(int idFatura) throws PagamentoExcecoesRegraNegocio {

	}

	public void construirEntidadeController(String c, String tipoPagamento) throws PagamentoExcecoesRegraNegocio {
		

		try { 
			if (c.trim().isBlank()) {

			throw new PagamentoExcecoesRegraNegocio("Insira os números do documento");
		}

		if (acharCHInvalido(c) == true) {

			throw new PagamentoExcecoesRegraNegocio("Símbolo inválido inserido. Por favor Tente novamente Com somente números.");
		}

			PagamentoEntidade pgmt = repository.BDConstruirEntidade(c, tipoPagamento);
			criarPdf(pgmt);


		} catch (PagamentoDataException e) {

			throw new PagamentoExcecoesRegraNegocio("Erro ao gerar pdf", e);

		}
	}

}
