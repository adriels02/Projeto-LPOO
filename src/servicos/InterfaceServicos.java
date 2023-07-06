package servicos;

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
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InterfaceServicos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceServicos frame = new InterfaceServicos();
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
	public InterfaceServicos() {
		setTitle("Serviços");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 208, 208, 0 };
		gbl_contentPane.rowHeights = new int[] { 56, 56, 56, 56, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnTranslado = new JButton("Translado");
		btnTranslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceTranslado interfaceTranslado = new InterfaceTranslado();
				interfaceTranslado.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Serviços:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btnTranslado = new GridBagConstraints();
		gbc_btnTranslado.fill = GridBagConstraints.BOTH;
		gbc_btnTranslado.insets = new Insets(0, 0, 5, 5);
		gbc_btnTranslado.gridx = 0;
		gbc_btnTranslado.gridy = 1;
		contentPane.add(btnTranslado, gbc_btnTranslado);

		JButton btnRestaurante = new JButton("Restaurante");
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceRestaurante interfaceRestaurante = new InterfaceRestaurante();
				interfaceRestaurante.setVisible(true);
				dispose();
			}
		});

		JButton btnWiFi = new JButton("Wi-Fi");
		btnWiFi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceWiFi interfaceWiFi = new InterfaceWiFi();
				interfaceWiFi.setVisible(true);
				dispose();
			}
		});

		JButton btnArrumacao = new JButton("Arrumação");
		btnArrumacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InterfaceArrumacao interfaceArrumacao = new InterfaceArrumacao();
				interfaceArrumacao.setVisible(true);
				dispose();

			}
		});
		GridBagConstraints gbc_btnArrumacao = new GridBagConstraints();
		gbc_btnArrumacao.fill = GridBagConstraints.BOTH;
		gbc_btnArrumacao.insets = new Insets(0, 0, 5, 0);
		gbc_btnArrumacao.gridx = 1;
		gbc_btnArrumacao.gridy = 1;
		contentPane.add(btnArrumacao, gbc_btnArrumacao);
		GridBagConstraints gbc_btnWiFi = new GridBagConstraints();
		gbc_btnWiFi.fill = GridBagConstraints.BOTH;
		gbc_btnWiFi.insets = new Insets(0, 0, 5, 5);
		gbc_btnWiFi.gridx = 0;
		gbc_btnWiFi.gridy = 2;
		contentPane.add(btnWiFi, gbc_btnWiFi);
		GridBagConstraints gbc_btnRestaurante = new GridBagConstraints();
		gbc_btnRestaurante.fill = GridBagConstraints.BOTH;
		gbc_btnRestaurante.insets = new Insets(0, 0, 5, 0);
		gbc_btnRestaurante.gridx = 1;
		gbc_btnRestaurante.gridy = 2;
		contentPane.add(btnRestaurante, gbc_btnRestaurante);

		JButton btnServicoDeQuarto = new JButton("Serviço de quarto");
		btnServicoDeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServicoDeQuarto interfaceServicoDeQuarto = new InterfaceServicoDeQuarto();
				interfaceServicoDeQuarto.setVisible(true);
				dispose();

			}
		});

		JButton btnEstacionamento = new JButton("Estacionamento");
		btnEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceEstacionamento interfaceEstacionamento = new InterfaceEstacionamento();
				interfaceEstacionamento.setVisible(true);
				dispose();

			}
		});
		GridBagConstraints gbc_btnEstacionamento = new GridBagConstraints();
		gbc_btnEstacionamento.fill = GridBagConstraints.BOTH;
		gbc_btnEstacionamento.insets = new Insets(0, 0, 0, 5);
		gbc_btnEstacionamento.gridx = 0;
		gbc_btnEstacionamento.gridy = 3;
		contentPane.add(btnEstacionamento, gbc_btnEstacionamento);
		GridBagConstraints gbc_btnServicoDeQuarto = new GridBagConstraints();
		gbc_btnServicoDeQuarto.fill = GridBagConstraints.BOTH;
		gbc_btnServicoDeQuarto.gridx = 1;
		gbc_btnServicoDeQuarto.gridy = 3;
		contentPane.add(btnServicoDeQuarto, gbc_btnServicoDeQuarto);
	}
}
