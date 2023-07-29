package br.edu.ifpe.paulista.pagamento.core;

import br.edu.ifpe.paulista.pagamento.data.PagamentoDataException;
import br.edu.ifpe.paulista.pagamento.data.PagamentoRepository;
import br.edu.ifpe.paulista.pagamento.data.PagamentoDAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
			if(invalido==true) return invalido;
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
		String senhaUser = "12";
		String senhaMaster = "12";
		String enderecoDocumentos = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		ArrayList<String> nomeServico = pgmt.getNomeServico();
		ArrayList<Double> precoServico = pgmt.getPrecoServico();
		ArrayList<Integer> reservasNaoFaturadas = pgmt.getReservasNaoFaturadas();
		HashMap<String, String> mapNomePreco = new HashMap<String, String>();
		try {



			for(int r : reservasNaoFaturadas) {

				FileOutputStream fos = new FileOutputStream(enderecoDocumentos + "\\Id da fatura" + pgmt.getIdFatura() + " " + pgmt.getData() + ".pdf");

				Document doc = new Document();

				PdfWriter writer = PdfWriter.getInstance(doc, fos);

				writer.setEncryption(senhaUser.getBytes(), senhaMaster.getBytes(), PdfWriter.ALLOW_PRINTING,
						PdfWriter.ENCRYPTION_AES_128);

				doc.open();

				doc.add(new Paragraph("                      		  Overlook"));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("Nome:       " + pgmt.getNomecliente()));
				doc.add(new Paragraph("Cpf:        " + pgmt.getCpfOuCnpj() + ""));
				doc.add(new Paragraph("Tipo de Pagamento:  " + pgmt.getTipoPagamento() + ""));


				doc.add(new Paragraph("IdReserva:          " + r + ""));
				doc.add(new Paragraph("Data:     " + pgmt.getData() + ""));
				doc.add(new Paragraph("ID da Fatura:" + pgmt.getIdFatura() + ""));
				doc.add(new Paragraph("Preço do Quarto:" + pgmt.getPrecoQuarto() + ""));
				for (int i = 0; i < nomeServico.size(); i++) {
					mapNomePreco.put(nomeServico.get(i), precoServico.get(i).toString());
				}
				for (String i : mapNomePreco.keySet()) {
					doc.add(new Paragraph("Serviço: " + i + " Preço: R$" + mapNomePreco.get(i)));
				}
				doc.add(new Paragraph("Total:         R$" + pgmt.getPrecoQuarto() + ""));



				doc.close();
				fos.close();

			}
		} catch (Exception e) {
			throw new PagamentoExcecoesRegraNegocio("erro ao criar pdf");
		}
	}

	public void inserirDadosController(PagamentoEntidade pgmt) throws PagamentoExcecoesRegraNegocio {
		try {
			repository.inserirDadosBDFaturaReceberId(pgmt);

		} catch (PagamentoDataException e) {

			throw new PagamentoExcecoesRegraNegocio("Erro ao Inserir Dados ao Banco", e);

		}
	}

	public void buscarDadosController(int idFatura) throws PagamentoExcecoesRegraNegocio {

		try {

			repository.BuscarDadosFatura(idFatura);

		} catch (PagamentoDataException e) {
			throw new PagamentoExcecoesRegraNegocio("Erro na Busca ao Banco", e);
		}

	}


	public int PegaridFatura(PagamentoEntidade pgmt) throws PagamentoExcecoesRegraNegocio {
		try {

			repository.PegaridFatura(pgmt);

		} catch (PagamentoDataException e) {
			throw new PagamentoExcecoesRegraNegocio("Erro na Busca ao Banco", e);
		}
		return pgmt.getIdFatura();
	}

	public void construirEntidadeController(String c, String tipoPagamento) throws PagamentoExcecoesRegraNegocio, IOException, DocumentException {

		try {

			if (c.isBlank()) {

				throw new PagamentoExcecoesRegraNegocio("Insira os números do documento");
			}

			if (c.length() != 11) {

				throw new PagamentoExcecoesRegraNegocio("Um cpf deve conter 11 digitos");
			}

			if (acharCHInvalido(c) == true) {

				throw new PagamentoExcecoesRegraNegocio("Símbolo inválido inserido. Por favor tente novamente com somente números.");

			}

			PagamentoEntidade pgmt = repository.selectsBdUsandoCpf(c);
			ArrayList<Integer> reservasNaoFaturadas = pgmt.getReservasNaoFaturadas();

			if (pgmt.getReservasNaoFaturadas().size() < 1){

				throw new PagamentoExcecoesRegraNegocio("Esse Cpf Não Possui Reservas Sem Faturas.");
			}
			for(int r : reservasNaoFaturadas) {

				PagamentoController pgc = new PagamentoController();
				repository.selectsBdUsandoIdreserva(r, pgmt);
				pgmt.setTipoPagamento(tipoPagamento);
				pgmt.setIdReserva(r);
				String senhaUser = "honduras";
				String senhaMaster = "senegal";
				String enderecoDocumentos = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
				ArrayList<String> nomeServico = pgmt.getNomeServico();
				ArrayList<Double> precoServico = pgmt.getPrecoServico();
				HashMap<String, String> mapNomePreco = new HashMap<String, String>();
				pgc.inserirDadosController(pgmt);
				pgc.PegaridFatura(pgmt);



				FileOutputStream fos = new FileOutputStream(enderecoDocumentos + "\\" + pgmt.getIdFatura() + ".pdf");

				Document doc = new Document();

				PdfWriter writer = PdfWriter.getInstance(doc, fos);

				writer.setEncryption(senhaUser.getBytes(), senhaMaster.getBytes(), PdfWriter.ALLOW_PRINTING,
						PdfWriter.ENCRYPTION_AES_128);

				doc.open();

				doc.add(new Paragraph("                      		  Overlook"));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("                                       "));
				doc.add(new Paragraph("Nome:       " + pgmt.getNomecliente()));
				doc.add(new Paragraph("Cpf:        " + c + ""));
				doc.add(new Paragraph("Tipo de Pagamento:  " + pgmt.getTipoPagamento() + ""));


				doc.add(new Paragraph("IdReserva:          " + r + ""));
				doc.add(new Paragraph("Data:     " + pgmt.getData() + ""));
				doc.add(new Paragraph("ID da Fatura:" + pgmt.getIdFatura() + ""));
				doc.add(new Paragraph("Preço do Quarto:" + pgmt.getPrecoQuarto() + ""));
				for (int i = 0; i < nomeServico.size(); i++) {
					mapNomePreco.put(nomeServico.get(i), precoServico.get(i).toString());
				}
				for (String i : mapNomePreco.keySet()) {
					doc.add(new Paragraph("Serviço: " + i + " Preço: R$" + mapNomePreco.get(i)));
				}
				doc.add(new Paragraph("Total:         R$" + pgmt.getPrecoFinal() + ""));



				doc.close();
				fos.close();

			}
		} catch (PagamentoDataException e) {

			throw new PagamentoExcecoesRegraNegocio("Erro ao acessar o banco de dados.", e);

		} catch (IOException e) {

			throw new PagamentoExcecoesRegraNegocio("Erro na selecao da pasta.", e);

		} catch (DocumentException e) {

			throw new PagamentoExcecoesRegraNegocio("Erro na criacao do pdf.", e);

		}
	}

}
