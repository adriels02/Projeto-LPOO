package bdInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FomularioLoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FomularioLoginInterface frame = new FomularioLoginInterface();
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
	public FomularioLoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeUsuario = new JLabel("Usu\u00E1rio");
		nomeUsuario.setBounds(149, 45, 36, 14);
		contentPane.add(nomeUsuario);
		
		textField = new JTextField();
		textField.setBounds(148, 60, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel senhaUsuario = new JLabel("Senha");
		senhaUsuario.setBounds(152, 98, 30, 14);
		contentPane.add(senhaUsuario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 113, 146, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton botaoEntrarsISistema = new JButton("Entrar");
		botaoEntrarsISistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog( null, "Usuário: " + nomeUsuario.getText());
			}
		});
		botaoEntrarsISistema.setBounds(177, 157, 89, 23);
		contentPane.add(botaoEntrarsISistema);
	}
}
