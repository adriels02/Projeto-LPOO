package interfaces;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
//import interfaces.CadastroInterface;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdConexao.UsuarioConexao;
//import bdInterface.FrmTelaPrincipalView;
import bdTransferencia.UsuarioTransferencia;
import login.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
//import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;




public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1906081639557822650L;
	private JPanel contentPane;
	Login login = new Login();
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
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
		
		setTitle("Tela Login");
		//setSize(1000,720); aumenta a tela mais nao expande os componetes
		//Frame frame = new Frame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 426);
		//setSize(1000,720) a imagem nao está abrindo proporcional;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//abrir no meio da tela
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_3 = new JLabel("Usuário");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(327, 188, 43, 14);
		contentPane.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(325, 206, 198, 20);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(327, 244, 35, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(325, 262, 198, 20);
		contentPane.add(txtSenha);
		
		JButton btnNewButton = new JButton("NOVO CADASTRO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(txtUsuario.getText().isEmpty() || String.valueOf(txtSenha.getPassword()).isEmpty()) {
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
					}
				

			}
		});
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setBounds(351, 137, 118, 14);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				

				try {
				String nomeUsuario, senhaUsuario;
				
				nomeUsuario=txtUsuario.getText();
				senhaUsuario = txtSenha.getText();
				
				UsuarioTransferencia objUsuarioTransferencia = new UsuarioTransferencia();
				objUsuarioTransferencia.setNomeUsuario(nomeUsuario);
				objUsuarioTransferencia.setSenhaUsuario(senhaUsuario);
				
				UsuarioConexao objUsuarioConexao = new UsuarioConexao ();
				ResultSet resultadoUsuarioConexao = objUsuarioConexao.autenticacaoUsuario(objUsuarioTransferencia);
				
				if(resultadoUsuarioConexao.next()) {
				/* chamar tela que eu quero abrir, trocar apos definir tela
					
					Tela (interface) que quer abrir + Nome de objeto criado aqui = tela a ser recebida novamente*/
					//FrmTelaPrincipalView objFrmTelaPrincipalView = new FrmTelaPrincipalView();
					MenuPrincipal objMenuPrincipal = new MenuPrincipal();
					
					//para tornar a tela visivel 
					//objFrmTelaPrincipalView.setVisible(true);
					objMenuPrincipal.setVisible(true);
					
					//fechar a tela anterior
					dispose();
				}				
				/*if (checkUsuario(txtUsuario.getText(),  txtSenha.getText())) {
				
				//System.out.println("Acesso liberado");
				JOptionPane.showMessageDialog( null, "Acesso liberado");
			}*/ 
				
				else {
				JOptionPane.showMessageDialog( null, "Dados inválidos", "Mensagem",JOptionPane.ERROR_MESSAGE);
				
			}
				
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog( null, "TelaInicial" + erro);
					
				}
				/*if (txtfUsuario.getText().equals(login.getUsuario()) && String.valueOf(senhatxtf.getPassword()).equals(login.getSenha())) {
					MenuPrincipal menu = new MenuPrincipal();
					menu.setVisible(true);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(btnEntrar, "E-mail ou senha incorretos!");
				}*/
				
				
			}
		});
	
		btnEntrar.setForeground(new Color(38, 9, 55));
		btnEntrar.setBackground(new Color(225, 225, 225));
		btnEntrar.setBounds(364, 299, 124, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/TELAINICIALPrancheta 8-100.jpg")));
		lblNewLabel.setBounds(0, 0, 550, 390);
		contentPane.add(lblNewLabel);
		
		
    	
	}
}
