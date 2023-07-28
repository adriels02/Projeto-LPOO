package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifpe.paulista.pagamento.gui.TelaApresentacaoPagamento;
import br.edu.ifpe.paulista.relatorio.gui.TelaRelatorio;
import cadastroGUI.CadastroInterface;
import cadastroGUI.InterfaceCadastroDependentes;
import cadastroGUI.InterfaceConsultaHospedes;
import reservaQuartos.InterfaceReservas;
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
		
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		mnNewMenu.setForeground(new Color(38, 9, 55));
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		mnNewMenu_1.setForeground(new Color(38, 9, 55));
		mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		mnNewMenu_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnNewMenu_2.setForeground(new Color(38, 9, 55));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("CheckIn-CheckOut");
		mnNewMenu_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnNewMenu_3.setForeground(new Color(38, 9, 55));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Pagamento");
		mnNewMenu_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnNewMenu_4.setForeground(new Color(38, 9, 55));
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
				TelaApresentacaoPagamento telaApresentacaoPagamento = new TelaApresentacaoPagamento();
				telaApresentacaoPagamento.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Rápido");
		lblNewLabel.setForeground(new Color(246, 169, 50));
		lblNewLabel.setBounds(253, 111, 199, 64);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
					
			
		JButton bntNovoCadastro = new JButton("Cadastro Cliente");
		bntNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntNovoCadastro.setForeground(new Color(38, 9, 55));
		bntNovoCadastro.setBounds(183, 236, 160, 90);
		bntNovoCadastro.setBackground(new Color(225, 225, 225));
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
		contentPane.add(bntNovoCadastro);
		
		JButton bntServico = new JButton("Serviços");
		bntServico.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntServico.setForeground(new Color(38, 9, 55));
		bntServico.setBounds(363, 236, 160, 90);
		bntServico.setBackground(new Color(225, 225, 225));
		bntServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServicos interfaceServicos =  new InterfaceServicos();
				interfaceServicos.setVisible(true);
				dispose();
			}
		});
		contentPane.add(bntServico);
		
		JButton bntReserva = new JButton("Reserva");
		bntReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntReserva.setForeground(new Color(38, 9, 55));
		bntReserva.setBounds(183, 344, 160, 90);
		bntReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					InterfaceReservas window = new InterfaceReservas();
					window.frmCadastroDasReservas.setVisible(true);
					dispose();
				
				
				
			}
		});
		bntReserva.setBackground(new Color(225, 225, 225));
		contentPane.add(bntReserva);
		
		JButton bntCheckIn = new JButton("Check");
		bntCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntCheckIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntCheckIn.setForeground(new Color(38, 9, 55));
		bntCheckIn.setBounds(363, 344, 160, 90);
		bntCheckIn.setBackground(new Color(225, 225, 225));
		contentPane.add(bntCheckIn);
		
		JButton bntCheckOut = new JButton("Pagamento");
		bntCheckOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntCheckOut.setForeground(new Color(38, 9, 55));
		bntCheckOut.setBounds(183, 454, 160, 90);
		bntCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentacaoPagamento telaApresentacao = new TelaApresentacaoPagamento();
				telaApresentacao.setVisible(true);
				dispose();
			}
		});
		bntCheckOut.setBackground(new Color(225, 225, 225));
		contentPane.add(bntCheckOut);
		
		JButton bntConsulta = new JButton("Consulta");
		bntConsulta.setForeground(new Color(38, 9, 55));
		bntConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntConsulta.setBounds(363, 454, 160, 90);
		bntConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsultaHospedes ic = new InterfaceConsultaHospedes();
				ic.setVisible(true);
				dispose();
			}
		});
		bntConsulta.setBackground(new Color(225, 225, 225));
		contentPane.add(bntConsulta);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1232, 11, 30, 30);
		contentPane.add(btnFecharTela);
		
		JButton btnSignOut = new JButton("");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial objTelaInicial  = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();	
			}
		});
		btnSignOut.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1195, 11, 30, 30);
		contentPane.add(btnSignOut);
				
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(664, 210, 480, 320);
		contentPane.add(lblLogoTelas);
				
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
				
		
		JLabel lblImagemTela = new JLabel("");
		lblImagemTela.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/fundo azul 1280x720.png")));
		lblImagemTela.setBounds(0, 0, 1280, 699);
		contentPane.add(lblImagemTela);
		



		
		
	}
}
