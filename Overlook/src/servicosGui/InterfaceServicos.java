package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InterfaceServicos extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("");

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceServicos frame = new InterfaceServicos();
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
	public InterfaceServicos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceServicos.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnTranslado = new JButton("Translado");
		btnTranslado.setBackground(new Color(225, 225, 225));
		btnTranslado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTranslado.setForeground(new Color(38, 9, 55));
		btnTranslado.setBounds(176, 270, 160, 80);
		btnTranslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceTranslado interfaceTranslado = new InterfaceTranslado();
				interfaceTranslado.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Serviços");
		lblNewLabel.setForeground(new Color(246, 169, 50));
		lblNewLabel.setBounds(276, 174, 139, 42);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		contentPane.add(btnTranslado);

		JButton btnRestaurante = new JButton("Restaurante");
		btnRestaurante.setForeground(new Color(38, 9, 55));
		btnRestaurante.setBackground(new Color(225, 225, 225));
		btnRestaurante.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRestaurante.setBounds(357, 372, 160, 80);
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceRestaurante interfaceRestaurante = new InterfaceRestaurante();
				interfaceRestaurante.setVisible(true);
				dispose();
			}
		});

		JButton btnWiFi = new JButton("Wi-Fi");
		btnWiFi.setForeground(new Color(38, 9, 55));
		btnWiFi.setBackground(new Color(225, 225, 225));
		btnWiFi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnWiFi.setBounds(176, 372, 160, 80);
		btnWiFi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceWiFi interfaceWiFi = new InterfaceWiFi();
				interfaceWiFi.setVisible(true);
				dispose();
			}
		});

		JButton btnArrumacao = new JButton("Arrumação");
		btnArrumacao.setForeground(new Color(38, 9, 55));
		btnArrumacao.setBackground(new Color(225, 225, 225));
		btnArrumacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnArrumacao.setBounds(357, 270, 160, 80);
		btnArrumacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InterfaceArrumacao interfaceArrumacao = new InterfaceArrumacao();
				interfaceArrumacao.setVisible(true);
				dispose();

			}
		});
		contentPane.add(btnArrumacao);
		contentPane.add(btnWiFi);
		contentPane.add(btnRestaurante);

		JButton btnServicoDeQuarto = new JButton("Serviço de Quarto");
		btnServicoDeQuarto.setForeground(new Color(38, 9, 55));
		btnServicoDeQuarto.setBackground(new Color(225, 225, 225));
		btnServicoDeQuarto.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnServicoDeQuarto.setBounds(357, 475, 160, 80);
		btnServicoDeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServicoDeQuarto interfaceServicoDeQuarto = new InterfaceServicoDeQuarto();
				interfaceServicoDeQuarto.setVisible(true);
				dispose();

			}
		});

		JButton btnEstacionamento = new JButton("Estacionamento");
		btnEstacionamento.setForeground(new Color(38, 9, 55));
		btnEstacionamento.setBackground(new Color(225, 225, 225));
		btnEstacionamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEstacionamento.setBounds(176, 475, 160, 80);
		btnEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceEstacionamento interfaceEstacionamento = new InterfaceEstacionamento();
				interfaceEstacionamento.setVisible(true);
				dispose();

			}
		});
		contentPane.add(btnEstacionamento);
		contentPane.add(btnServicoDeQuarto);
		btnNewButton.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/Botao Menu 65x23.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
		btnSignOut.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);
		
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(656, 189, 480, 320);
		contentPane.add(lblLogoTelas);
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InterfaceServicos.class.getResource("/interfaces/imagens/fundo azul 1280x720.png")));
		lblNewLabel_1.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel_1);
		

	}
}
