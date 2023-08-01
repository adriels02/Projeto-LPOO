package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.CoreException;
import core.Validador;
import core.Wifi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InterfaceWiFi extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeSetado;
	private JTextField txtSenhaSetada;
	private JTextField txtNomeGet;
	private JTextField txtSenhaGet;

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
					InterfaceWiFi frame = new InterfaceWiFi();
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
	public InterfaceWiFi() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InterfaceWiFi.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 441);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Wi-Fi");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(147, 126, 103, 42);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1);

		JLabel lblError = new JLabel("");
		lblError.setBounds(0, 0, 0, 0);
		lblError.setForeground(new Color(255, 0, 0));
		contentPane.add(lblError);

		txtNomeSetado = new JTextField();
		txtNomeSetado.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeSetado.setBackground(new Color(225, 225, 225));
		txtNomeSetado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNomeSetado.setForeground(new Color(38, 9, 55));
		txtNomeSetado.setBounds(145, 264, 161, 23);
		txtNomeSetado.setEditable(false);
		contentPane.add(txtNomeSetado);
		txtNomeSetado.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Nome");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(38, 9, 55));
		lblNewLabel_9.setBounds(95, 487, 44, 14);
		contentPane.add(lblNewLabel_9);

		txtNomeGet = new JTextField();
		txtNomeGet.setBounds(145, 483, 161, 23);
		contentPane.add(txtNomeGet);
		txtNomeGet.setColumns(10);
		txtNomeGet.setDocument(new Validador(20));

		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(95, 268, 43, 14);
		contentPane.add(lblNewLabel_5);

		txtSenhaSetada = new JTextField();
		txtSenhaSetada.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenhaSetada.setBackground(new Color(225, 225, 225));
		txtSenhaSetada.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSenhaSetada.setForeground(new Color(38, 9, 55));
		txtSenhaSetada.setBounds(145, 315, 161, 23);
		txtSenhaSetada.setEditable(false);
		contentPane.add(txtSenhaSetada);
		txtSenhaSetada.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Senha");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(new Color(38, 9, 55));
		lblNewLabel_10.setBounds(95, 540, 47, 14);
		contentPane.add(lblNewLabel_10);

		txtSenhaGet = new JTextField();
		txtSenhaGet.setBounds(145, 536, 161, 23);
		contentPane.add(txtSenhaGet);
		txtSenhaGet.setColumns(10);
		txtSenhaGet.setDocument(new Validador(20));

		Wifi wifi = new Wifi();
		txtNomeSetado.setText(wifi.getNome());
		txtSenhaSetada.setText(wifi.getSenha());

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBounds(145, 594, 120, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Wifi wifii = new Wifi();
					wifii.registrarInformacoes(txtNomeGet.getText(), txtSenhaGet.getText());

					txtNomeSetado.setText(wifii.getNome());
					txtSenhaSetada.setText(wifii.getSenha());
					
					JOptionPane.showMessageDialog(null,"Mudança efetuada com sucesso!");	
					txtNomeGet.setText("");
					txtSenhaGet.setText("");

				} catch (CoreException mensagem) {

					JOptionPane.showMessageDialog(null,"Ocorreu um erro: "  + mensagem.getMessage());	

				}
			}
		});
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("Senha");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setBounds(95, 319, 46, 14);
		contentPane.add(lblNewLabel_6);

		JButton btnServicos = new JButton("");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InterfaceServicos interfaceServicos = new InterfaceServicos();
				interfaceServicos.setVisible(true);
				dispose();

			}
		});
		btnServicos.setIcon(
				new ImageIcon(InterfaceWiFi.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
		btnServicos.setBackground(new Color(255, 128, 64));
		btnServicos.setBounds(0, 0, 65, 23);
		contentPane.add(btnServicos);

		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFecharTela.setIcon(
				new ImageIcon(InterfaceWiFi.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
		btnSignOut.setIcon(
				new ImageIcon(InterfaceWiFi.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);

		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas
				.setIcon(new ImageIcon(InterfaceWiFi.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(750, 219, 480, 320);
		contentPane.add(lblLogoTelas);

		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(
				InterfaceWiFi.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
	}
}
