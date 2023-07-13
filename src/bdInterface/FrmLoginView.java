package bdInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.io.Serializable;
//import javax.swing.SwingConstants;
//import java.awt.Component;

//public class FrmLoginView extends JFrame implements Serializable {
public class FrmLoginView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5222909009672886717L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLoginView frame = new FrmLoginView();
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
	public FrmLoginView() {
		setResizable(false);
		setTitle("Tela Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setForeground(new Color(88, 68, 188));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(256, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(256, 64, 144, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(88, 68, 188));
		lblNewLabel_1.setBounds(256, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(256, 123, 144, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setAlignmentY(1.0f);
		btnEntrar.setAlignmentX(1.0f);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkUsuario(txtUsuario.getText(),  txtSenha.getText() )) {
					
					//System.out.println("Acesso liberado");
					JOptionPane.showMessageDialog( null, "Acesso liberado");
				} else {
					JOptionPane.showMessageDialog( null, "Dados inválidos", "Mensagem",JOptionPane.ERROR_MESSAGE);
					//System.out.println("Acesso Negado");
				}
				
			}
		});
		btnEntrar.setBounds(284, 176, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmLoginView.class.getResource("/imagens/logoOverlookPQ.jpg")));
		lblNewLabel_2.setBounds(82, 23, 112, 112);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmLoginView.class.getResource("/imagens/logoOverlookNome.jpg")));
		lblNewLabel_3.setBounds(24, 151, 228, 88);
		contentPane.add(lblNewLabel_3);
	}
	        
	
	public boolean checkUsuario (String usuario, String login) {
		return usuario.equals("usuario") && login.equals("123");
		
		
	}

}
