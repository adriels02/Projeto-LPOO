package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import core.PagamentoController;
import core.PagamentoExcecoesRegraNegocio;
import core.ValidarCaracteres;


public class TelaApresentacaoPagamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7150131932644221333L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JLabel errorLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApresentacaoPagamento frame = new TelaApresentacaoPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaApresentacaoPagamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 480);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblTextoInformativo = new JLabel("Insira o CPF e selecione a forma de");
		lblTextoInformativo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextoInformativo.setForeground(new Color(38, 9, 55));
		lblTextoInformativo.setBounds(108, 480, 294, 16);
		contentPane.add(lblTextoInformativo);

		JLabel lblTextoInformativo_1 = new JLabel("pagamento para gerar o comprovante");
		lblTextoInformativo_1.setForeground(new Color(38, 9, 55));
		lblTextoInformativo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextoInformativo_1.setBounds(108, 493, 250, 16);
		contentPane.add(lblTextoInformativo_1);



		JRadioButton rdbtnCartaoCredito = new JRadioButton("Cartão de crédito");
		rdbtnCartaoCredito.setBackground(new Color(38, 9, 55));
		rdbtnCartaoCredito.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCartaoCredito.setForeground(new Color(255, 255, 255));
		rdbtnCartaoCredito.setBounds(124, 259, 158, 23);
		buttonGroup.add(rdbtnCartaoCredito);
		contentPane.add(rdbtnCartaoCredito);

		JButton btnMenuPrincipal = new JButton("Menu");
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuPrincipal.setBounds(0, 0, 65, 23);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});

		JRadioButton rdbtnBoleto = new JRadioButton("Boleto");
		rdbtnBoleto.setBackground(new Color(38, 9, 55));
		rdbtnBoleto.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBoleto.setForeground(new Color(255, 255, 255));
		rdbtnBoleto.setBounds(124, 287, 109, 23);
		buttonGroup.add(rdbtnBoleto);
		contentPane.add(rdbtnBoleto);
		btnMenuPrincipal.setBackground(new Color(255, 128, 64));
		contentPane.add(btnMenuPrincipal);

		JRadioButton rdbtnPix = new JRadioButton("Pix");
		rdbtnPix.setBackground(new Color(38, 9, 55));
		rdbtnPix.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnPix.setForeground(new Color(255, 255, 255));
		rdbtnPix.setBounds(124, 315, 109, 23);
		buttonGroup.add(rdbtnPix);
		contentPane.add(rdbtnPix);

		JRadioButton rdbtnCartaoDebito = new JRadioButton("Cartão de débito");
		rdbtnCartaoDebito.setBackground(new Color(38, 9, 55));
		rdbtnCartaoDebito.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCartaoDebito.setForeground(new Color(255, 255, 255));
		rdbtnCartaoDebito.setBounds(124, 343, 158, 23);
		buttonGroup.add(rdbtnCartaoDebito);
		contentPane.add(rdbtnCartaoDebito);

		JRadioButton rdbtnTED = new JRadioButton("TED");
		rdbtnTED.setBackground(new Color(38, 9, 55));
		rdbtnTED.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnTED.setForeground(new Color(255, 255, 255));
		rdbtnTED.setBounds(124, 371, 109, 23);
		buttonGroup.add(rdbtnTED);
		contentPane.add(rdbtnTED);

		errorLabel = new JLabel("error");
		errorLabel.setBounds(108, 635, 1072, 22);

		JButton btnGerarpdf = new JButton("Gerar Comprovante");
		btnGerarpdf.setBackground(new Color(225, 225, 225));
		btnGerarpdf.setForeground(new Color(38, 9, 55));
		btnGerarpdf.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGerarpdf.setBounds(108, 555, 167, 23);
		btnGerarpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PagamentoController pcontrol = new PagamentoController();
					String tipopgmt;
					if(rdbtnPix.isSelected()){
						tipopgmt = "Pix";
					}
					else if(rdbtnCartaoCredito.isSelected()){
						tipopgmt = "Cartão de Crédito";
					}
					else if(rdbtnTED.isSelected()){
						tipopgmt = "TED";
					}
					else if(rdbtnBoleto.isSelected()){
						tipopgmt = "Boleto";
					}
					else if(rdbtnCartaoDebito.isSelected()){
						tipopgmt="Cartão de débito";					}
					else {
						throw new PagamentoExcecoesRegraNegocio("Selecione um Tipo De Pagamento");
					}
					try {
						pcontrol.construirEntidadeController(textField.getText(), tipopgmt);
					} catch (IOException e1) {
						throw new PagamentoExcecoesRegraNegocio("Erro nas operações I/O");
					}
					textField.setText("");
					errorLabel.setText("Fatura salva com sucesso na pasta de documentos");
					errorLabel.setForeground(new Color(0, 250, 0));
					errorLabel.setVisible(true);
				} catch (PagamentoExcecoesRegraNegocio e1) {
					errorLabel.setText(e1.getMessage());
					errorLabel.setVisible(true);


				}

			}
		});
		contentPane.add(btnGerarpdf);
		
		textField = new JTextField();
		textField.setBounds(108, 512, 222, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new ValidarCaracteres(11, ValidarCaracteres.TipoEntrada.NUMEROINTERIRO));


		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		

		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		contentPane.add(btnFecharTela);

		JButton btnSignOut = new JButton("");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();

			}
		});
		btnSignOut.setIcon(new ImageIcon(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);


		JLabel lblNewLabel = new JLabel("Pagamento");
		lblNewLabel.setForeground(new Color(38, 9, 55));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(108, 141, 173, 42);
		contentPane.add(lblNewLabel);


		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(700, 210, 480, 320);
		contentPane.add(lblLogoTelas);


		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/bloco azul 222 x 170.png")));
		lblNewLabel_1.setBackground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(108, 242, 222, 170);
		contentPane.add(lblNewLabel_1);



		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(TelaApresentacaoPagamento.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);











	}
}
