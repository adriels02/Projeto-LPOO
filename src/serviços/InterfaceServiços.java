package serviços;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceServiços extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceServiços frame = new InterfaceServiços();
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
	public InterfaceServiços() {
		setTitle("Serviços");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serviços:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(183, 11, 84, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnTranslado = new JButton("Translado");
		btnTranslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceTranslado interfaceTranslado = new InterfaceTranslado();
				interfaceTranslado.setVisible(true);
				dispose();
			}
		});
		btnTranslado.setBounds(34, 68, 138, 23);
		contentPane.add(btnTranslado);
		
		JButton btnWiFi = new JButton("Wi-Fi");
		btnWiFi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceWiFi interfaceWiFi = new InterfaceWiFi();
				interfaceWiFi.setVisible(true);
				dispose();
			}
		});
		btnWiFi.setBounds(34, 130, 138, 23);
		contentPane.add(btnWiFi);
		
		JButton btnEstacionamento = new JButton("Estacionamento");
		btnEstacionamento.setBounds(34, 191, 138, 23);
		contentPane.add(btnEstacionamento);
		
		JButton btnArrumacao = new JButton("Arrumação");
		btnArrumacao.setBounds(261, 68, 138, 23);
		contentPane.add(btnArrumacao);
		
		JButton btnRestaurante = new JButton("Restaurante");
		btnRestaurante.setBounds(261, 130, 138, 23);
		contentPane.add(btnRestaurante);
		
		JButton btnServicoDeQuarto = new JButton("Serviço de quarto");
		btnServicoDeQuarto.setBounds(261, 191, 138, 23);
		contentPane.add(btnServicoDeQuarto);
	}
}
