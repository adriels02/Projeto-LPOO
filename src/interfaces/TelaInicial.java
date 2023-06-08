package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import interfaces.CadastroInterface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtfUsuario;
	private JPasswordField senhatxtf;
	Login login = new Login();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setForeground(new Color(38, 9, 55));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login.getUsuario().equals(login.getUsuario()) && login.getSenha().equals(login.getSenha())) {
					CadastroInterface cadastro = new CadastroInterface();
					cadastro.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(btnEntrar, "E-mail ou senha incorreto!");
				}
				
				
			}
		});
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login.setUsuario(txtfUsuario.getText());
				login.setSenha(String.valueOf(senhatxtf.getPassword()));
					JOptionPane.showMessageDialog(null,"Login cadastrado com sucesso!");
					txtfUsuario.setText("");
					senhatxtf.setText("");
					
					
					txtfUsuario.requestFocus();
				
			}
		});
		btnNewButton.setBounds(183, 290, 95, 23);
		contentPane.add(btnNewButton);
		btnEntrar.setBounds(288, 290, 89, 23);
		contentPane.add(btnEntrar);
		
		senhatxtf = new JPasswordField();
		senhatxtf.setBounds(145, 259, 232, 20);
		contentPane.add(senhatxtf);
		
		txtfUsuario = new JTextField();
		txtfUsuario.setBounds(145, 209, 232, 20);
		contentPane.add(txtfUsuario);
		txtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usuário");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(222, 79, 31));
		lblNewLabel_3.setBounds(145, 184, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setForeground(new Color(222, 79, 31));
		lblNewLabel_3_1.setBounds(145, 240, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Gerenciamento de clientes em hotelaria");
		lblNewLabel_1.setForeground(new Color(243, 160, 37));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 155, 534, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/OVERLOOKLOGOPrancheta 6.png")));
		lblNewLabel_2.setBounds(0, 29, 524, 144);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/OVERLOOKBACKGROUND1Prancheta 5-100.jpg")));
		lblNewLabel.setBounds(0, 0, 534, 361);
		contentPane.add(lblNewLabel);
	}
}
