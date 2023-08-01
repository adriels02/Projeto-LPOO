package br.edu.ifpe.paulista.relatorio.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaRelatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7826610023978124960L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorio.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(142, 275, 307, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser jdc1 = new JDateChooser();
		jdc1.setBounds(133, 46, 127, 20);
		panel.add(jdc1);
		

		
		JDateChooser jdc1_1 = new JDateChooser();
		jdc1_1.setBounds(133, 101, 127, 20);
		panel.add(jdc1_1);
		
		JLabel lblNewLabel = new JLabel("Data inicial");
		lblNewLabel.setBounds(38, 33, 85, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Final");
		lblNewLabel_1.setBounds(38, 101, 62, 14);
		panel.add(lblNewLabel_1);
		
		JButton gerarRelatorio = new JButton("Gerar Relatorio");
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		gerarRelatorio.setBackground(new Color(225, 225, 225));
		gerarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		gerarRelatorio.setForeground(new Color(38, 9, 55));
		gerarRelatorio.setBounds(343, 467, 106, 23);
		contentPane.add(gerarRelatorio);
		
		JButton btnNewButton_7 = new JButton("Menu");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                dispose();
				
			}
		});
		btnNewButton_7.setBackground(new Color(255, 128, 64));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
		btnSignOut.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(750, 170, 480, 320);
		contentPane.add(lblLogoTelas);
		
		
		JButton btnBotao6 = new JButton("New button");
		btnBotao6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao6.setForeground(new Color(38, 9, 55));
		btnBotao6.setBackground(new Color(225, 225, 225));
		btnBotao6.setBounds(32, 415, 100, 23);
		contentPane.add(btnBotao6);
		
		JButton btnBotao5 = new JButton("New button");
		btnBotao5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao5.setForeground(new Color(38, 9, 55));
		btnBotao5.setBackground(new Color(225, 225, 225));
		btnBotao5.setBounds(32, 387, 100, 23);
		contentPane.add(btnBotao5);
		
		JButton btnBotao4 = new JButton("New button");
		btnBotao4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao4.setForeground(new Color(38, 9, 55));
		btnBotao4.setBackground(new Color(225, 225, 225));
		btnBotao4.setBounds(32, 359, 100, 23);
		contentPane.add(btnBotao4);
		
		JButton btnBotao3 = new JButton("New button");
		btnBotao3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao3.setForeground(new Color(38, 9, 55));
		btnBotao3.setBackground(new Color(225, 225, 225));
		btnBotao3.setBounds(32, 331, 100, 23);
		contentPane.add(btnBotao3);
		
		JButton btnBotao2 = new JButton("New button");
		btnBotao2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao2.setForeground(new Color(38, 9, 55));
		btnBotao2.setBackground(new Color(225, 225, 225));
		btnBotao2.setBounds(32, 303, 100, 23);
		contentPane.add(btnBotao2);
		
		JButton btnBotao1 = new JButton("New button");
		btnBotao1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao1.setForeground(new Color(38, 9, 55));
		btnBotao1.setBackground(new Color(225, 225, 225));
		btnBotao1.setBounds(32, 275, 100, 23);
		contentPane.add(btnBotao1);
		btnBotao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		
		
		JLabel lblTituloRelatorio = new JLabel("Relatório");
		lblTituloRelatorio.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTituloRelatorio.setForeground(new Color(38, 9, 55));
		lblTituloRelatorio.setBounds(32, 141, 139, 42);
		contentPane.add(lblTituloRelatorio);
		
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
	

	}
}
