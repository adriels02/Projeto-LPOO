package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import core.UsuarioTransferencia;
import data.UsuarioConexao;



public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1906081639557822650L;
	private JPanel contentPane;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 426);
		//a tela abrir inteira fixa
		//setExtendedState(MAXIMIZED_BOTH);
		
		setSize(1000,720); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//abrir no meio da tela
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JLabel lblNewLabel_3 = new JLabel("Usuário");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(597, 336, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(593, 353, 345, 30);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(597, 441, 59, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(593, 458, 345, 30);
		contentPane.add(txtSenha);
		
		JButton btnCadastroNovoUsuario = new JButton("CADASTRE");
		btnCadastroNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCadastroNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaNovoUsuarioSistema objTelaNovoUsuarioSistema  = new TelaNovoUsuarioSistema();
				objTelaNovoUsuarioSistema.setVisible(true);
				dispose();			

			}
		});
		btnCadastroNovoUsuario.setForeground(new Color(38, 9, 55));
		btnCadastroNovoUsuario.setBackground(new Color(225, 225, 225));
		btnCadastroNovoUsuario.setBounds(790, 252, 143, 15);
		contentPane.add(btnCadastroNovoUsuario);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		Logar();
		txtUsuario.setText("");
		txtSenha.setText("");
									
			}
		});
	    
		JLabel lblMensagemNvUsuarioLinha1 = new JLabel("Para criar um novo usuário click");
		lblMensagemNvUsuarioLinha1.setForeground(new Color(38, 9, 55));
		lblMensagemNvUsuarioLinha1.setBounds(601, 252, 238, 15);
		contentPane.add(lblMensagemNvUsuarioLinha1);

		btnEntrar.setForeground(new Color(38, 9, 55));
		btnEntrar.setBackground(new Color(225, 225, 225));
		btnEntrar.setBounds(703, 522, 124, 23);
		contentPane.add(btnEntrar);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setForeground(new Color(255, 255, 255));
		btnFecharTela.setBackground(new Color(255, 255, 255));
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		
		btnFecharTela.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFecharTela.setBounds(950, 11, 30, 30);
		contentPane.add(btnFecharTela);
		
				
		JLabel lblBemVindo = new JLabel("Bem Vindo!");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(new Color(15, 19, 51));
		lblBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBemVindo.setBounds(667, 151, 196, 30);
		contentPane.add(lblBemVindo);
		
		JLabel lblFraseTelaInicial = new JLabel("Gerenciamento de clientes em hotelaria");
		lblFraseTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseTelaInicial.setForeground(new Color(246, 169, 50));
		lblFraseTelaInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFraseTelaInicial.setBounds(128, 413, 326, 14);
		contentPane.add(lblFraseTelaInicial);
		
		JLabel lblTelaLogin = new JLabel("");
		lblTelaLogin.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/Tela Login1 1000x720.png")));
		lblTelaLogin.setBounds(0, 0, 1000, 720);
		contentPane.add(lblTelaLogin);
		


						   	
	}
	
	@SuppressWarnings("deprecation")
	private void Logar() {
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
			    MenuPrincipal objMenuPrincipal = new MenuPrincipal();
				//para tornar a tela visivel 
				objMenuPrincipal.setVisible(true);
				//fechar a tela anterior
				dispose();
			}				
			
			else {
			  JOptionPane.showMessageDialog( null, "Dados inválidos", "Mensagem",JOptionPane.ERROR_MESSAGE);
			
		}
			
			} catch (SQLException erro) {
			  JOptionPane.showMessageDialog( null, "TelaInicial" + erro);
				
			}
		
	}
}
