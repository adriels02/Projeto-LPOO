package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import core.ValidarCaracteres;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class InterfaceCheckOut extends JFrame {

	private JPanel contentPane;
	private JTextField textData;
	private JTextField textAtualizar;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCheckOut frame = new InterfaceCheckOut();
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
	public InterfaceCheckOut() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCheckOut.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 332);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(38, 9, 55));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(23, 118, 63, 14);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabelDataCheckIn = new JLabel("Data");
		lblNewLabelDataCheckIn.setForeground(new Color(38, 9, 55));
		lblNewLabelDataCheckIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelDataCheckIn.setBounds(23, 164, 63, 14);
		lblNewLabelDataCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblBenvindo = new JLabel("Bem vindo ao Check-Out");
		lblBenvindo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBenvindo.setForeground(new Color(38, 9, 55));
		lblBenvindo.setBounds(11, 33, 432, 36);
		lblBenvindo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textData = new JTextField();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setBounds(111, 160, 319, 23);
		textData.setColumns(10);
		textData.setDocument(new ValidarCaracteres(10, ValidarCaracteres.TipoEntrada.DATA));
		
		JLabel lblNewLabelAtualizar = new JLabel("Atualizar");
		lblNewLabelAtualizar.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabelAtualizar.setForeground(new Color(38, 9, 55));
		lblNewLabelAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelAtualizar.setBounds(23, 214, 83, 14);
		
		textAtualizar = new JTextField();
		textAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAtualizar.setBounds(111, 210, 319, 23);
		textAtualizar.setColumns(10);
		
		JButton btnNewButton = new JButton("Realizar Check-Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBounds(17, 277, 142, 23);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(225, 225, 225));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(38, 9, 55));
		btnNewButton_1.setBounds(178, 277, 119, 23);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBackground(new Color(225, 225, 225));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(38, 9, 55));
		btnNewButton_2.setBounds(315, 277, 116, 23);
		contentPane.setLayout(null);
		contentPane.add(lblBenvindo);
		contentPane.add(lblNome);
		contentPane.add(lblNewLabelDataCheckIn);
		contentPane.add(textData);
		contentPane.add(lblNewLabelAtualizar);
		contentPane.add(textAtualizar);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setColumns(10);
		textNome.setBounds(111, 114, 319, 23);
		
		textNome.setDocument(new ValidarCaracteres(45, ValidarCaracteres.TipoEntrada.NOME));
		contentPane.add(textNome);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceCheckOut.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(438, 0, 30, 30);
		contentPane.add(btnFecharTela);
	}
}


