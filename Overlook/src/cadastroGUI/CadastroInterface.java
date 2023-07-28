package cadastroGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import cadastroCORE.CadastroController;
import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtfNome;
	private JTextField txtfCpf;
	private JTextField txtfDataNascimento;
	private JTextField txtfTelefone;
	private JTextField txtfEmail;
	private JTextField txtfNumeroReserva;
	private JTextField txtfNumeroApt;
	private JTextField txtfTipoApt;
	private JTextField txtfNumeroDiarias;
	private JTextField txtfValorDiarias;
	private JTextField txtfQtdAdulto;
	private JTextField txtfQtdCrianca;
	private JTextField txtfDataReserva;
	private JTextField txtfHoraEntrada;
	private JTextField txtfHoraSaida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInterface frame = new CadastroInterface();
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
	public CadastroInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroInterface.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 411);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNenuPrincipal = new JButton("Menu");
		btnNenuPrincipal.setBackground(new Color(255, 128, 64));
		btnNenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNenuPrincipal.setForeground(new Color(255, 255, 255));
		btnNenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		menuBar.add(btnNenuPrincipal);
		
		JMenuItem mntmConsultarHospedes = new JMenuItem("Consultar Hóspedes");
		mntmConsultarHospedes.setForeground(new Color(38, 9, 55));
		mntmConsultarHospedes.setFont(new Font("Tahoma", Font.BOLD, 12));
		mntmConsultarHospedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsultaHospedes ich = new InterfaceConsultaHospedes();
				ich.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmConsultarHospedes);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados Cliente");
		lblNewLabel.setForeground(new Color(38, 9, 55));
		lblNewLabel.setBounds(212, 33, 208, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(73, 112, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		txtfNome = new JTextField();
		txtfNome.setBounds(73, 132, 487, 23);
		contentPane.add(txtfNome);
		txtfNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setBounds(73, 185, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(213, 185, 133, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(364, 185, 63, 14);
		contentPane.add(lblNewLabel_5);
		
		txtfCpf = new JTextField();
		txtfCpf.setBounds(73, 204, 134, 23);
		contentPane.add(txtfCpf);
		txtfCpf.setColumns(10);
		
		txtfDataNascimento = new JTextField();
		txtfDataNascimento.setBounds(212, 204, 147, 23);
		contentPane.add(txtfDataNascimento);
		txtfDataNascimento.setColumns(10);
		
		txtfTelefone = new JTextField();
		txtfTelefone.setBounds(364, 204, 201, 23);
		contentPane.add(txtfTelefone);
		txtfTelefone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(73, 252, 81, 14);
		contentPane.add(lblNewLabel_6);
		
		txtfEmail = new JTextField();
		txtfEmail.setBounds(73, 272, 300, 23);
		contentPane.add(txtfEmail);
		txtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Dados Reserva");
		lblNewLabel_7.setForeground(new Color(38, 9, 55));
		lblNewLabel_7.setBounds(203, 359, 226, 42);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nº Reserva");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(new Color(38, 9, 55));
		lblNewLabel_8.setBounds(73, 431, 116, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nº Apt");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(38, 9, 55));
		lblNewLabel_9.setBounds(194, 431, 105, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo Apt");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(new Color(38, 9, 55));
		lblNewLabel_10.setBounds(304, 431, 123, 14);
		contentPane.add(lblNewLabel_10);
		
		txtfNumeroReserva = new JTextField();
		txtfNumeroReserva.setBounds(73, 451, 116, 23);
		contentPane.add(txtfNumeroReserva);
		txtfNumeroReserva.setColumns(10);
		
		txtfNumeroApt = new JTextField();
		txtfNumeroApt.setBounds(194, 451, 105, 23);
		contentPane.add(txtfNumeroApt);
		txtfNumeroApt.setColumns(10);
		
		txtfTipoApt = new JTextField();
		txtfTipoApt.setBounds(304, 451, 261, 23);
		contentPane.add(txtfTipoApt);
		txtfTipoApt.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Nº Diárias");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(new Color(38, 9, 55));
		lblNewLabel_11.setBounds(73, 500, 116, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Valor Diárias");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setForeground(new Color(38, 9, 55));
		lblNewLabel_12.setBounds(194, 500, 105, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Qtd Adulto");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setForeground(new Color(38, 9, 55));
		lblNewLabel_13.setBounds(304, 500, 123, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Qtd Criança");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setForeground(new Color(38, 9, 55));
		lblNewLabel_14.setBounds(432, 500, 133, 14);
		contentPane.add(lblNewLabel_14);
		
		txtfNumeroDiarias = new JTextField();
		txtfNumeroDiarias.setBounds(73, 519, 116, 23);
		contentPane.add(txtfNumeroDiarias);
		txtfNumeroDiarias.setColumns(10);
		
		txtfValorDiarias = new JTextField();
		txtfValorDiarias.setBounds(194, 519, 105, 23);
		contentPane.add(txtfValorDiarias);
		txtfValorDiarias.setColumns(10);
		
		txtfQtdAdulto = new JTextField();
		txtfQtdAdulto.setBounds(304, 519, 123, 23);
		contentPane.add(txtfQtdAdulto);
		txtfQtdAdulto.setColumns(10);
		
		txtfQtdCrianca = new JTextField();
		txtfQtdCrianca.setBounds(432, 519, 133, 23);
		contentPane.add(txtfQtdCrianca);
		txtfQtdCrianca.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Data Reserva");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setForeground(new Color(38, 9, 55));
		lblNewLabel_15.setBounds(73, 565, 116, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Hora Entrada");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setForeground(new Color(38, 9, 55));
		lblNewLabel_16.setBounds(249, 565, 105, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Hora Saída");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_17.setForeground(new Color(38, 9, 55));
		lblNewLabel_17.setBounds(419, 565, 123, 14);
		contentPane.add(lblNewLabel_17);
		
		txtfDataReserva = new JTextField();
		txtfDataReserva.setBounds(73, 585, 169, 23);
		contentPane.add(txtfDataReserva);
		txtfDataReserva.setColumns(10);
		
		txtfHoraEntrada = new JTextField();
		txtfHoraEntrada.setBounds(247, 585, 164, 23);
		contentPane.add(txtfHoraEntrada);
		txtfHoraEntrada.setColumns(10);
		
		txtfHoraSaida = new JTextField();
		txtfHoraSaida.setBounds(417, 585, 148, 23);
		contentPane.add(txtfHoraSaida);
		txtfHoraSaida.setColumns(10);
		
		JButton bntFinalizarCadastro = new JButton("Finalizar");
		bntFinalizarCadastro.setBackground(new Color(225, 225, 225));
		bntFinalizarCadastro.setForeground(new Color(38, 9, 55));
		bntFinalizarCadastro.setBounds(432, 650, 131, 23);
		bntFinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		boolean sucesso;
				try {
					CadastroController cadastroController = new CadastroController();
					sucesso = cadastroController.cadastrarCliente(txtfNome.getText(), txtfCpf.getText(), txtfTelefone.getText(),txtfEmail.getText(),txtfDataNascimento.getText());
					if (sucesso) {
						JOptionPane.showMessageDialog(null,"Cadastro concluído com sucesso");
						txtfNome.setText("");
						txtfDataNascimento.setText("");
						txtfCpf.setText("");
						txtfEmail.setText("");
						txtfTelefone.setText("");
						
						
						txtfNome.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
					}
				} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro: " + ex);
			}
			}	
		});
		bntFinalizarCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(bntFinalizarCadastro);
		
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel_18);
		
		JButton btnCadastrarDependentes = new JButton("Cadastro Dependentes");
		btnCadastrarDependentes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarDependentes.setForeground(new Color(38, 9, 55));
		btnCadastrarDependentes.setBackground(new Color(225, 225, 225));
		btnCadastrarDependentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceCadastroDependentes ich = new InterfaceCadastroDependentes();
				ich.setVisible(true);
				dispose();
			}
		});
		btnCadastrarDependentes.setBounds(377, 272, 179, 23);
		contentPane.add(btnCadastrarDependentes);
		
				
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1232, 11, 30, 30);
		contentPane.add(btnFecharTela);
		
		JButton btnSigOut = new JButton("");
		btnSigOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();

			}
		});
		btnSigOut.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSigOut.setBounds(1195, 11, 30, 30);
		contentPane.add(btnSigOut);
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(712, 208, 480, 320);
		contentPane.add(lblLogoTelas);
		
	
		

	}
}
