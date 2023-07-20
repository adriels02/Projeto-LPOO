package interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bdConexao.UsuarioConexao;
import bdTransferencia.UsuarioTransferencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;



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
		
		setTitle("Tela Login");
		//Frame frame = new Frame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 426);
		//a tela abrir inteira fixa
		//setExtendedState(MAXIMIZED_BOTH);
		//a imagem nao está abrindo proporcional
		setSize(1000,720); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//abrir no meio da tela
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_3 = new JLabel("Usuário");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(583, 324, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(579, 341, 345, 30);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(583, 429, 59, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(579, 446, 345, 30);
		contentPane.add(txtSenha);
		
		JButton btnNewButton = new JButton("CADASTRAR NOVO USUÁRIO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							

			}
		});
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setBounds(612, 245, 279, 15);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		Logar();
									
			}
		});
	
		btnEntrar.setForeground(new Color(38, 9, 55));
		btnEntrar.setBackground(new Color(225, 225, 225));
		btnEntrar.setBounds(689, 521, 124, 23);
		contentPane.add(btnEntrar);
				
		JLabel lblBemVindo = new JLabel("Bem Vindo!");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(new Color(15, 19, 51));
		lblBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBemVindo.setBounds(653, 170, 196, 30);
		contentPane.add(lblBemVindo);
		
		JLabel lblFraseTelaInicial = new JLabel("Gerenciamento de clientes em hotelaria");
		lblFraseTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseTelaInicial.setForeground(new Color(246, 169, 50));
		lblFraseTelaInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFraseTelaInicial.setBounds(126, 420, 326, 14);
		contentPane.add(lblFraseTelaInicial);
		
		JLabel lblImageTelaInicial = new JLabel("");
		lblImageTelaInicial.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/imageTelaInicial.jpg")));
		lblImageTelaInicial.setBounds(0, 0, 984, 681);
		contentPane.add(lblImageTelaInicial);
		
			
				   	
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
