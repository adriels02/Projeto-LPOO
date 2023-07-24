package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import bdTransferencia.UsuarioTransferencia;
import bdConexao.*;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLException;
//import java.sql.ResultSet;
import java.awt.event.ActionEvent;
//import javax.swing.JFormattedTextField;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltarTelaInicial = new JButton("Tela Inicial");
		btnVoltarTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial objTelaInicial  = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();	
			}
		});
		btnVoltarTelaInicial.setBounds(757, 389, 144, 23);
		contentPane.add(btnVoltarTelaInicial);
		
		txtNovoUsuario = new JTextField();
		txtNovoUsuario.setBounds(619, 183, 275, 20);
		contentPane.add(txtNovoUsuario);
		txtNovoUsuario.setColumns(10);
		
		
		
		btnNovoUsuario = new JButton("Novo Usuário");
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InserirUsuario();
				limparCampos();
				
			}
		});
		btnNovoUsuario.setBounds(618, 389, 130, 23);
		contentPane.add(btnNovoUsuario);
		
		lblNomeNvUsuario = new JLabel("Usuário");
		lblNomeNvUsuario.setBounds(622, 160, 144, 14);
		contentPane.add(lblNomeNvUsuario);
		
		lblSenhaNvUsuario = new JLabel("Senha");
		lblSenhaNvUsuario.setBounds(622, 221, 144, 14);
		contentPane.add(lblSenhaNvUsuario);
		
		lblSenhaDeLiberao = new JLabel("Senha de Liberação");
		lblSenhaDeLiberao.setBounds(619, 325, 144, 14);
		contentPane.add(lblSenhaDeLiberao);
		
		txtSenhaLiberacao = new JPasswordField();
		txtSenhaLiberacao.setBounds(618, 346, 283, 20);
		contentPane.add(txtSenhaLiberacao);
		
		txtSenhaNovoUsuario = new JPasswordField();
		txtSenhaNovoUsuario.setBounds(620, 240, 283, 20);
		contentPane.add(txtSenhaNovoUsuario);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(620, 271, 144, 14);
		contentPane.add(lblConfirmarSenha);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(618, 296, 283, 20);
		contentPane.add(txtConfirmarSenha);
		
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
	

	
	/*@SuppressWarnings("deprecation")
	private void ExcluirUsuario() {
		
		String nomeNovoUsuario;
		@SuppressWarnings("unused")
		String senhaLiberacao;
		
		nomeNovoUsuario=txtNovoUsuario.getText();
		senhaLiberacao = txtSenhaLiberacao.getText();
		
		UsuarioTransferencia objUsuarioTransferencia = new UsuarioTransferencia();
		objUsuarioTransferencia.setNomeUsuario(nomeNovoUsuario);
		
		UsuarioConexao objUsuarioConexao = new UsuarioConexao ();
		objUsuarioConexao.excluirUsuario(objUsuarioTransferencia);
		
		
	}
	
	
	
	private void ExcluirUsuario() {
			
		int idUsuario;
		idUsuario = Integer.parseInt(txtCodigo.getText());
		UsuarioTransferencia objUsuarioTransferencia = new UsuarioTransferencia();
		objUsuarioTransferencia.setIdUsuario(idUsuario);
		
		UsuarioConexao objUsuarioConexao = new UsuarioConexao ();
		objUsuarioConexao.excluirUsuario(objUsuarioTransferencia);
		
		
	}*/
	
	
		
}

