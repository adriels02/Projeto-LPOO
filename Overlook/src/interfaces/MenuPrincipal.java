package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reservaQuartos.*;
import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import br.edu.ifpe.paulista.pagamento.gui.TelaApresentaçaoPagamento;
import br.edu.ifpe.paulista.relatorio.gui.TelaRelatorio;
import cadastroGUI.CadastroInterface;
import cadastroGUI.InterfaceCadastroDependentes;
import cadastroGUI.InterfaceConsultaHospedes;
import servicosGui.InterfaceArrumacao;
import servicosGui.InterfaceEstacionamento;
import servicosGui.InterfaceRestaurante;
import servicosGui.InterfaceServicoDeQuarto;
import servicosGui.InterfaceServicos;
import servicosGui.InterfaceTranslado;
import servicosGui.InterfaceWiFi;


public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4903225871769519708L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		//abrir no meio da tela
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface interfaceCadastroCliente = new CadastroInterface();
				interfaceCadastroCliente.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dependentes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCadastroDependentes ict = new InterfaceCadastroDependentes();
				ict.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Usuário");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial tl = new TelaInicial();
				tl.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Consulta");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsultaHospedes ict = new InterfaceConsultaHospedes();
				ict.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_1 = new JMenu("Serviços");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Restaurante");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceRestaurante interfaceRestaurante = new InterfaceRestaurante();
				interfaceRestaurante.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Translado");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceTranslado interfaceTranslado = new InterfaceTranslado();
				interfaceTranslado.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("wifi");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceWiFi interfaceWifi =  new InterfaceWiFi();
				interfaceWifi.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Estacionamento");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceEstacionamento it = new InterfaceEstacionamento();
				it.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Arrumação");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceArrumacao ia = new InterfaceArrumacao();
				ia.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Serviço de quarto");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServicoDeQuarto isq = new InterfaceServicoDeQuarto();
				isq.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("Reservas");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Check Out");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Pagamento");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Relatório Geral");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaRelatorio telaRelatorio = new TelaRelatorio();
				telaRelatorio.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Pagamento");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentaçaoPagamento telaApresentacaoPagamento = new TelaApresentaçaoPagamento();
				telaApresentacaoPagamento.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 18, 0, 0};
		gbl_contentPane.rowHeights = new int[]{45, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Menu Rápido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 7;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		
		//IMAGEM 
		JLabel imgMenuInicial = new JLabel("");
		imgMenuInicial.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/telainicilILUSTRAÇAOPrancheta 9.png")));
		panel.add(imgMenuInicial); 
					
			
		JButton bntNovoCadastro = new JButton("Novo Cadastro");
		bntNovoCadastro.setBackground(new Color(223, 223, 255));
		bntNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface cadastroInterface =  new CadastroInterface();
				cadastroInterface.setVisible(true);
				dispose();
				
				/*if(txtUsuario.getText().isEmpty() || String.valueOf(txtSenha.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null,"Erro ao cadastrar! Por favor preencha todos os campos de texto.");
				txtUsuario.setText("");
				txtSenha.setText("");
				txtUsuario.requestFocus();
		}
			else {
				login.setUsuario(txtUsuario.getText());
				login.setSenha(String.valueOf(txtSenha.getPassword()));
				JOptionPane.showMessageDialog(null,"Login cadastrado com sucesso!");
				txtUsuario.setText("");
				txtSenha.setText("");
				txtUsuario.requestFocus();
			}*/
				
				
					
				
			}
		});
		GridBagConstraints gbc_bntNovoCadastro = new GridBagConstraints();
		gbc_bntNovoCadastro.fill = GridBagConstraints.BOTH;
		gbc_bntNovoCadastro.insets = new Insets(0, 0, 5, 5);
		gbc_bntNovoCadastro.gridx = 0;
		gbc_bntNovoCadastro.gridy = 1;
		contentPane.add(bntNovoCadastro, gbc_bntNovoCadastro);
		
		JButton bntServico = new JButton("Novo Serviço");
		bntServico.setBackground(new Color(223, 223, 255));
		bntServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServicos interfaceServicos =  new InterfaceServicos();
				interfaceServicos.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_bntServico = new GridBagConstraints();
		gbc_bntServico.fill = GridBagConstraints.BOTH;
		gbc_bntServico.insets = new Insets(0, 0, 5, 5);
		gbc_bntServico.gridx = 0;
		gbc_bntServico.gridy = 2;
		contentPane.add(bntServico, gbc_bntServico);
		
		JButton bntReserva = new JButton("Reserva");
		bntReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					InterfaceReservas window = new InterfaceReservas();
					window.frmCadastroDasReservas.setVisible(true);
					dispose();
				
				
				
			}
		});
		bntReserva.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_bntReserva = new GridBagConstraints();
		gbc_bntReserva.fill = GridBagConstraints.BOTH;
		gbc_bntReserva.insets = new Insets(0, 0, 5, 5);
		gbc_bntReserva.gridx = 0;
		gbc_bntReserva.gridy = 3;
		contentPane.add(bntReserva, gbc_bntReserva);
		
		JButton bntCheckIn = new JButton("CheckIn-CheckOut");
		bntCheckIn.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_bntCheckIn = new GridBagConstraints();
		gbc_bntCheckIn.fill = GridBagConstraints.BOTH;
		gbc_bntCheckIn.insets = new Insets(0, 0, 5, 5);
		gbc_bntCheckIn.gridx = 0;
		gbc_bntCheckIn.gridy = 4;
		contentPane.add(bntCheckIn, gbc_bntCheckIn);
		
		JButton bntCheckOut = new JButton("Pagamento");
		bntCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentaçaoPagamento telaApresentacao = new TelaApresentaçaoPagamento();
				telaApresentacao.setVisible(true);
				dispose();
			}
		});
		bntCheckOut.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_bntCheckOut = new GridBagConstraints();
		gbc_bntCheckOut.fill = GridBagConstraints.BOTH;
		gbc_bntCheckOut.insets = new Insets(0, 0, 5, 5);
		gbc_bntCheckOut.gridx = 0;
		gbc_bntCheckOut.gridy = 5;
		contentPane.add(bntCheckOut, gbc_bntCheckOut);
		
		JButton bntConsulta = new JButton("Consulta");
		bntConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsultaHospedes ic = new InterfaceConsultaHospedes();
				ic.setVisible(true);
				dispose();
			}
		});
		bntConsulta.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_bntConsulta = new GridBagConstraints();
		gbc_bntConsulta.fill = GridBagConstraints.BOTH;
		gbc_bntConsulta.insets = new Insets(0, 0, 0, 5);
		gbc_bntConsulta.gridx = 0;
		gbc_bntConsulta.gridy = 6;
		contentPane.add(bntConsulta, gbc_bntConsulta);
	}
}
