package interfaces;

import java.awt.EventQueue;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bdConexao.UsuarioConexao;
import bdConexao.Validador;
import bdTransferencia.UsuarioTransferencia;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class TelaNovoUsuarioSistema extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4946696028593361643L;
	private JPanel contentPane;
	private JTextField txtNovoUsuario;
	private JButton btnNovoUsuario;
	private JLabel lblNomeNvUsuario;
	private JLabel lblSenhaNvUsuario;
	private JLabel lblSenhaDeLiberao;
	private JPasswordField txtSenhaLiberacao;
	private JPasswordField txtSenhaNovoUsuario;
	private JLabel lblConfirmarSenha;
	private JPasswordField txtConfirmarSenha;
	private JLabel lblIconeUsuario;
	private JTextField lblFraseTelaInicial;
	private JButton lblFecharTela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovoUsuarioSistema frame = new TelaNovoUsuarioSistema();
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
	public TelaNovoUsuarioSistema() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaNovoUsuarioSistema.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setSize(1000,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltarTelaInicial = new JButton("Tela Inicial");
		btnVoltarTelaInicial.setForeground(new Color(38, 9, 55));
		btnVoltarTelaInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarTelaInicial.setBackground(new Color(225, 225, 225));
		btnVoltarTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial objTelaInicial  = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();	
			}
		});
		btnVoltarTelaInicial.setBounds(770, 531, 130, 23);
		contentPane.add(btnVoltarTelaInicial);
		
		txtNovoUsuario = new JTextField();
		txtNovoUsuario.setBounds(618, 325, 282, 20);
		contentPane.add(txtNovoUsuario);
		txtNovoUsuario.setColumns(10);
		//limitador de caracteres
		txtNovoUsuario.setDocument(new Validador (10));
		
		
		
		btnNovoUsuario = new JButton("Cadrastrar Usuário");
		btnNovoUsuario.setForeground(new Color(38, 9, 55));
		btnNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovoUsuario.setBackground(new Color(225, 225, 225));
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InserirUsuario();
				limparCampos();
				
			}
		});
		btnNovoUsuario.setBounds(617, 531, 143, 23);
		contentPane.add(btnNovoUsuario);
		
		lblNomeNvUsuario = new JLabel("Criar usuário até 10 dígitos");
		lblNomeNvUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeNvUsuario.setForeground(new Color(38, 9, 55));
		lblNomeNvUsuario.setBounds(621, 309, 272, 14);
		contentPane.add(lblNomeNvUsuario);
		
		lblSenhaNvUsuario = new JLabel("Criar senha até 8 dígitos");
		lblSenhaNvUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenhaNvUsuario.setForeground(new Color(38, 9, 55));
		lblSenhaNvUsuario.setBounds(621, 367, 279, 14);
		contentPane.add(lblSenhaNvUsuario);
		
		lblSenhaDeLiberao = new JLabel("Chave de Liberação");
		lblSenhaDeLiberao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenhaDeLiberao.setForeground(new Color(38, 9, 55));
		lblSenhaDeLiberao.setBounds(618, 480, 144, 14);
		contentPane.add(lblSenhaDeLiberao);
		
		txtSenhaLiberacao = new JPasswordField();
		txtSenhaLiberacao.setBounds(617, 495, 283, 20);
		contentPane.add(txtSenhaLiberacao);
		
		txtSenhaNovoUsuario = new JPasswordField();
		txtSenhaNovoUsuario.setBounds(619, 382, 283, 20);
		contentPane.add(txtSenhaNovoUsuario);
		txtSenhaNovoUsuario.setDocument(new Validador (8));
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblConfirmarSenha.setForeground(new Color(38, 9, 55));
		lblConfirmarSenha.setBounds(619, 422, 144, 14);
		contentPane.add(lblConfirmarSenha);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(617, 438, 283, 20);
		contentPane.add(txtConfirmarSenha);
		txtConfirmarSenha.setDocument(new Validador (8));
		

		
		lblIconeUsuario = new JLabel("");
		lblIconeUsuario.setIcon(new ImageIcon(TelaNovoUsuarioSistema.class.getResource("/interfaces/imagens/IconeUsuario 182x151.png")));
		lblIconeUsuario.setBounds(668, 85, 182, 151);
		contentPane.add(lblIconeUsuario);
		
		

		JLabel lblFraseTelaInicial = new JLabel("Gerenciamento de clientes em hotelaria");
		lblFraseTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseTelaInicial.setForeground(new Color(246, 169, 50));
		lblFraseTelaInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFraseTelaInicial.setBounds(126, 420, 326, 14);
		contentPane.add(lblFraseTelaInicial);	
		
		
		lblFecharTela = new JButton("");
		lblFecharTela.setIcon(new ImageIcon(TelaNovoUsuarioSistema.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		lblFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		lblFecharTela.setBounds(935, 11, 30, 30);
		contentPane.add(lblFecharTela);
		
		
		JLabel lblImageTelaUsuario = new JLabel("");
		lblImageTelaUsuario.setIcon(new ImageIcon(TelaNovoUsuarioSistema.class.getResource("/interfaces/imagens/imagemTelaUsuario 984x681.png")));
		lblImageTelaUsuario.setBounds(0, 0, 984, 681);
		contentPane.add(lblImageTelaUsuario);
		

		
				
	}
	
	private void limparCampos() {
		
		txtNovoUsuario.setText("");
		txtSenhaNovoUsuario.setText("");
		txtConfirmarSenha.setText("");
		txtSenhaLiberacao.setText("");
		
		
		
	}
	
	@SuppressWarnings({ "deprecation" })
	private void InserirUsuario() {
		
		String nomeNovoUsuario;
		String senhaNovoUsuario;
		String senhaLiberacao;
		String ConfirmarSenha;
		
		nomeNovoUsuario=txtNovoUsuario.getText();
		senhaNovoUsuario = txtSenhaNovoUsuario.getText();
		ConfirmarSenha = txtConfirmarSenha.getText();
		senhaLiberacao = txtSenhaLiberacao.getText();
		
		if ((senhaLiberacao.equals("123overlook")) && (ConfirmarSenha.equals(senhaNovoUsuario))) {
		UsuarioTransferencia objUsuarioTransferencia = new UsuarioTransferencia();
		objUsuarioTransferencia.setNomeUsuario(nomeNovoUsuario);
		objUsuarioTransferencia.setSenhaUsuario(senhaNovoUsuario);
		
		UsuarioConexao objUsuarioConexao = new UsuarioConexao ();
		objUsuarioConexao.inserirUsuario(objUsuarioTransferencia);
				
		JOptionPane.showMessageDialog(null, "Novo usuario inserido");		
	    
	    
		}
				
		else {
			JOptionPane.showMessageDialog(null, "Dados inválidos","Mensagem",JOptionPane.ERROR_MESSAGE);}
		

	}
}

