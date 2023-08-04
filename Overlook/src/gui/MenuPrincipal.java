package gui;

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
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;*/
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;


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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(246, 169, 50));
		lblNewLabel.setBounds(98, 148, 524, 64);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
					
			
		JButton bntNovoCadastro = new JButton("Cadastrar Cliente");
		bntNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntNovoCadastro.setForeground(new Color(38, 9, 55));
		bntNovoCadastro.setBounds(98, 254, 160, 80);
		bntNovoCadastro.setBackground(new Color(225, 225, 225));
		bntNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface cadastroInterface =  new CadastroInterface();
				cadastroInterface.setVisible(true);
				dispose();
				
				
				
			}
		});
		contentPane.add(bntNovoCadastro);
		
		JButton bntServico = new JButton("Serviços");
		bntServico.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntServico.setForeground(new Color(38, 9, 55));
		bntServico.setBounds(279, 254, 160, 80);
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
		bntReserva.setBounds(462, 256, 160, 80);
		bntReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					InterfaceReservas window = new InterfaceReservas();
					window.frmCadastroDasReservas.setVisible(true);
					dispose();
				
				
				
			}
		});
		bntReserva.setBackground(new Color(225, 225, 225));
		contentPane.add(bntReserva);
		
		JButton bntCheckIn = new JButton("Check-In");
		bntCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceCheckIn objInterfaceCheckIn =  new InterfaceCheckIn();
				objInterfaceCheckIn.setVisible(true);
				
				
			}
		});
		bntCheckIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntCheckIn.setForeground(new Color(38, 9, 55));
		bntCheckIn.setBounds(462, 354, 160, 35);
		bntCheckIn.setBackground(new Color(225, 225, 225));
		contentPane.add(bntCheckIn);
		
		JButton bntCheckOut = new JButton("Pagamento");
		bntCheckOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntCheckOut.setForeground(new Color(38, 9, 55));
		bntCheckOut.setBounds(98, 455, 160, 80);
		bntCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApresentacaoPagamento telaApresentacao = new TelaApresentacaoPagamento();
				telaApresentacao.setVisible(true);
				dispose();
			}
		});
		bntCheckOut.setBackground(new Color(225, 225, 225));
		contentPane.add(bntCheckOut);
		
		JButton bntConsulta = new JButton("Hóspedes");
		bntConsulta.setForeground(new Color(38, 9, 55));
		bntConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		bntConsulta.setBounds(98, 354, 160, 80);
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
		btnFecharTela.setBounds(1250, 0, 30, 30);
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
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);
				
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(716, 189, 480, 320);
		contentPane.add(lblLogoTelas);
				
		
		JButton btnQuartos = new JButton("Quartos");
		btnQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				InterfaceCadastroDeQuartos objInterfaceCadastroDeQuartos  = new InterfaceCadastroDeQuartos();
				objInterfaceCadastroDeQuartos.frmCadastroDeQuartos.setVisible(true);
								dispose();		
				
			}
		});
		btnQuartos.setBackground(new Color(225, 225, 225));
		btnQuartos.setForeground(new Color(38, 9, 55));
		btnQuartos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuartos.setBounds(279, 354, 160, 80);
		contentPane.add(btnQuartos);
		
		JButton btnRelatorios = new JButton("Relatórios");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaRelatorio objTelaRelatorio = new TelaRelatorio();
				objTelaRelatorio.setVisible(true);
				dispose();
				
			}
		});
		btnRelatorios.setBackground(new Color(225, 225, 225));
		btnRelatorios.setForeground(new Color(38, 9, 55));
		btnRelatorios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRelatorios.setBounds(279, 455, 160, 80);
		contentPane.add(btnRelatorios);
		
		
		JButton btnPrecos = new JButton("Preços");
		btnPrecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfacePrecos objInterfacePrecos = new InterfacePrecos();
				objInterfacePrecos.setVisible(true);
				dispose();
				
				
			}
		});
		btnPrecos.setForeground(new Color(38, 9, 55));
		btnPrecos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrecos.setBackground(new Color(225, 225, 225));
		btnPrecos.setBounds(462, 455, 160, 80);
		contentPane.add(btnPrecos);
			
		JButton btnCheckout = new JButton("Check-Out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCheckOut objInterfaceCheckOut =  new InterfaceCheckOut();
				objInterfaceCheckOut.setVisible(true);
				
				
				
			}
		});
		btnCheckout.setForeground(new Color(38, 9, 55));
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCheckout.setBackground(new Color(225, 225, 225));
		btnCheckout.setBounds(462, 399, 160, 35);
		contentPane.add(btnCheckout);
		
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
				
		
		JLabel lblImagemTela = new JLabel("");
		lblImagemTela.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/fundo azul 1280x720.png")));
		lblImagemTela.setBounds(0, 0, 1280, 720);
		contentPane.add(lblImagemTela);
		




		



		
		
	}
}
