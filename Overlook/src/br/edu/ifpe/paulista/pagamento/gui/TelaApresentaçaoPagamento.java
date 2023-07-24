package br.edu.ifpe.paulista.pagamento.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import br.edu.ifpe.paulista.pagamento.core.PagamentoController;
import br.edu.ifpe.paulista.pagamento.core.PagamentoExcecoesRegraNegocio;
import interfaces.MenuPrincipal;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class TelaApresentaçaoPagamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7150131932644221333L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApresentaçaoPagamento frame = new TelaApresentaçaoPagamento();
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
	public TelaApresentaçaoPagamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaApresentaçaoPagamento.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 88, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lbllogo = new JLabel("");
		GridBagConstraints gbc_lbllogo = new GridBagConstraints();
		gbc_lbllogo.gridwidth = 2;
		lbllogo.setIcon(new ImageIcon(TelaApresentaçaoPagamento.class.getResource("/interfaces/imagens/logoOverlook-horizontal.png")));
		gbc_lbllogo.insets = new Insets(0, 0, 5, 5);
		gbc_lbllogo.gridx = 1;
		gbc_lbllogo.gridy = 1;
		contentPane.add(lbllogo, gbc_lbllogo);

		JTextArea txtrBemvindoATela = new JTextArea();
		txtrBemvindoATela.setBackground(SystemColor.control);
		GridBagConstraints gbc_txtrBemvindoATela = new GridBagConstraints();
		gbc_txtrBemvindoATela.gridwidth = 2;
		gbc_txtrBemvindoATela.insets = new Insets(11, 11, 5, 9);
		gbc_txtrBemvindoATela.gridx = 2;
		gbc_txtrBemvindoATela.gridy = 3;
		contentPane.add(txtrBemvindoATela, gbc_txtrBemvindoATela);
		txtrBemvindoATela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrBemvindoATela.setEditable(false);
		txtrBemvindoATela.setText("Bem-vindo a tela de pagamento. Insira somente os números\r\nde um cpf ou cnpj e selecione o um tipo de pagamento,\r\npara gerar um comprovante. ");

		JRadioButton rdbtnCartaoCredito = new JRadioButton("Cartão de crédito");
		buttonGroup.add(rdbtnCartaoCredito);
		GridBagConstraints gbc_rdbtnCartaoCredito = new GridBagConstraints();
		gbc_rdbtnCartaoCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCartaoCredito.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCartaoCredito.gridx = 4;
		gbc_rdbtnCartaoCredito.gridy = 4;
		contentPane.add(rdbtnCartaoCredito, gbc_rdbtnCartaoCredito);

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		
		JRadioButton rdbtnBoleto = new JRadioButton("Boleto");
		buttonGroup.add(rdbtnBoleto);
		GridBagConstraints gbc_rdbtnBoleto = new GridBagConstraints();
		gbc_rdbtnBoleto.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBoleto.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBoleto.gridx = 4;
		gbc_rdbtnBoleto.gridy = 5;
		contentPane.add(rdbtnBoleto, gbc_rdbtnBoleto);

		GridBagConstraints gbc_btntelaprincipal = new GridBagConstraints();
		gbc_btntelaprincipal.insets = new Insets(0, 0, 5, 5);
		btnMenuPrincipal.setBackground(new Color(223, 223, 255));
		gbc_btntelaprincipal.gridx = 1;
		gbc_btntelaprincipal.gridy = 6;
		contentPane.add(btnMenuPrincipal, gbc_btntelaprincipal);

		JRadioButton rdbtnPix = new JRadioButton("Pix");
		buttonGroup.add(rdbtnPix);
		GridBagConstraints gbc_rdbtnPix = new GridBagConstraints();
		gbc_rdbtnPix.insets = new Insets(0, 0, 5, 220);
		gbc_rdbtnPix.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPix.gridx = 4;
		gbc_rdbtnPix.gridy = 6;
		contentPane.add(rdbtnPix, gbc_rdbtnPix);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cartão de débito");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 7;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JRadioButton rdbtnTED = new JRadioButton("TED");
		buttonGroup.add(rdbtnTED);
		GridBagConstraints gbc_rdbtnTED = new GridBagConstraints();
		gbc_rdbtnTED.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTED.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTED.gridx = 4;
		gbc_rdbtnTED.gridy = 8;
		contentPane.add(rdbtnTED, gbc_rdbtnTED);
		
		JLabel errorLabel = new JLabel(" ");

		JButton btnGerarpdf = new JButton("New button");
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
					else {
						tipopgmt="Cartão de débito";
					}
					pcontrol.construirEntidadeController(textField.getText(), tipopgmt);
					textField.setText("");
					errorLabel.setText("Fatura salva com sucesso na pasta de documentos");
				} catch (PagamentoExcecoesRegraNegocio e1) {
					errorLabel.setText(e1.getMessage());
					errorLabel.setVisible(true);
				}

			}
		});

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 10;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		
			errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			errorLabel.setForeground(new Color(255, 0, 0));
			errorLabel.setVisible(false);
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.gridwidth = 2;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 2;
			gbc_lblNewLabel_5.gridy = 11;
			contentPane.add(errorLabel, gbc_lblNewLabel_5);
		GridBagConstraints gbc_btnGerarpdf = new GridBagConstraints();
		gbc_btnGerarpdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnGerarpdf.gridx = 4;
		gbc_btnGerarpdf.gridy = 12;
		contentPane.add(btnGerarpdf, gbc_btnGerarpdf);



	}

}
