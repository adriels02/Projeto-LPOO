package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gerenciamento de clientes em hotelaria");
		lblNewLabel_1.setForeground(new Color(243, 160, 37));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 253, 514, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/interfaces/imagens/TELAABERTURAmaiorPrancheta 4-100.jpg")));
		lblNewLabel.setBounds(0, 0, 534, 361);
		contentPane.add(lblNewLabel);
	}
}
