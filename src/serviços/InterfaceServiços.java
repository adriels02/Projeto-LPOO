package serviços;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Font;

public class InterfaceServiços {

	private JFrame frmServios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceServiços window = new InterfaceServiços();
					window.frmServios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceServiços() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServios = new JFrame();
		frmServios.setTitle("Serviços");
		frmServios.setBounds(100, 100, 450, 303);
		frmServios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServios.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serviços:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(195, 11, 65, 14);
		frmServios.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Serviço de quarto");
		btnNewButton.setBounds(48, 61, 117, 23);
		frmServios.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restaurante");
		btnNewButton_1.setBounds(48, 131, 117, 23);
		frmServios.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Wi-Fi");
		btnNewButton_2.setBounds(47, 201, 118, 23);
		frmServios.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Estacionamento");
		btnNewButton_3.setBounds(279, 61, 117, 23);
		frmServios.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Arrumação");
		btnNewButton_4.setBounds(279, 131, 117, 23);
		frmServios.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Translado");
		btnNewButton_5.setBounds(279, 201, 117, 23);
		frmServios.getContentPane().add(btnNewButton_5);
	}
}
