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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	Login login = new Login();
	private JTextField txtfUsuario;
	private JPasswordField senhatxtf;
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
		setResizable(false);
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Usuário");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(327, 188, 43, 14);
		contentPane.add(lblNewLabel_3);
		
		txtfUsuario = new JTextField();
		txtfUsuario.setColumns(10);
		txtfUsuario.setBounds(327, 213, 198, 20);
		contentPane.add(txtfUsuario);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(327, 244, 35, 14);
		contentPane.add(lblNewLabel_3_1);
		
		senhatxtf = new JPasswordField();
		senhatxtf.setBounds(327, 269, 198, 20);
		contentPane.add(senhatxtf);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(txtfUsuario.getText().isEmpty() || String.valueOf(senhatxtf.getPassword()).isEmpty()) {
						JOptionPane.showMessageDialog(null,"Erro ao cadastrar! Por favor preencha todos os campos de texto.");
						txtfUsuario.setText("");
						senhatxtf.setText("");
						txtfUsuario.requestFocus();
				}
					else {
						login.setUsuario(txtfUsuario.getText());
						login.setSenha(String.valueOf(senhatxtf.getPassword()));
						JOptionPane.showMessageDialog(null,"Login cadastrado com sucesso!");
						txtfUsuario.setText("");
						senhatxtf.setText("");
						txtfUsuario.requestFocus();
					}
				

			}
		});
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(327, 303, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtfUsuario.getText().equals(login.getUsuario()) && String.valueOf(senhatxtf.getPassword()).equals(login.getSenha())) {
					MenuPrincipal menu = new MenuPrincipal();
					menu.setVisible(true);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(btnEntrar, "E-mail ou senha incorretos!");
				}
				
				
			}
		});
	
		btnEntrar.setForeground(new Color(38, 9, 55));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(440, 303, 85, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/TELAINICIALPrancheta 8-100.jpg")));
		lblNewLabel.setBounds(0, 0, 550, 390);
		contentPane.add(lblNewLabel);
	}
}
