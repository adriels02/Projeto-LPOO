package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import core.ValidarCaracteres;
import javax.swing.ImageIcon;

public class InterfaceCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textData;
	private JTextField textAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCheckIn frame = new InterfaceCheckIn();
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
	public InterfaceCheckIn() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCheckIn.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 332);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(new Color(38, 9, 55));
		lblNome.setBounds(30, 118, 46, 14);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(118, 114, 319, 23);
		textNome.setColumns(10);
		textNome.setDocument(new ValidarCaracteres(45, ValidarCaracteres.TipoEntrada.NOME));
		
		JLabel lblNewLabelDataCheckIn = new JLabel("Data");
		lblNewLabelDataCheckIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelDataCheckIn.setForeground(new Color(38, 9, 55));
		lblNewLabelDataCheckIn.setBounds(30, 164, 81, 14);
		
		JLabel lblBemVindo = new JLabel("Bem vindo ao Check-In");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBemVindo.setForeground(new Color(38, 9, 55));
		lblBemVindo.setBounds(21, 33, 432, 36);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textData = new JTextField();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setBounds(118, 160, 319, 23);
		textData.setColumns(10);
		textData.setDocument(new ValidarCaracteres(10, ValidarCaracteres.TipoEntrada.DATA));
		
		JLabel lblNewLabelAtualizar = new JLabel("Atualizar");
		lblNewLabelAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelAtualizar.setForeground(new Color(38, 9, 55));
		lblNewLabelAtualizar.setBounds(30, 214, 81, 14);
		
		textAtualizar = new JTextField();
		textAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAtualizar.setBounds(118, 210, 319, 23);
		textAtualizar.setColumns(10);
		
		JButton btnNewButton = new JButton("Realizar Check-In");
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBounds(24, 277, 142, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
		

			
		});
		
		JButton btnNewButton_1 = new JButton("Deletar ");
		btnNewButton_1.setBackground(new Color(225, 225, 225));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(38, 9, 55));
		btnNewButton_1.setBounds(185, 275, 119, 23);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.setBackground(new Color(225, 225, 225));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(38, 9, 55));
		btnNewButton_2.setBounds(322, 275, 116, 23);
		contentPane.setLayout(null);
		contentPane.add(lblBemVindo);
		contentPane.add(lblNome);
		contentPane.add(textNome);
		contentPane.add(lblNewLabelDataCheckIn);
		contentPane.add(textData);
		contentPane.add(lblNewLabelAtualizar);
		contentPane.add(textAtualizar);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.setIcon(new ImageIcon(InterfaceCheckIn.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
				
		});
		btnFecharTela.setBounds(438, 0, 30, 30);
		contentPane.add(btnFecharTela);
	}
}

