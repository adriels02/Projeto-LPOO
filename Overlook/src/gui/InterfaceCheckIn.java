package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class InterfaceCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCheckIn;
	private JTextField textFieldAtualizar;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabelDataCheckIn = new JLabel("Data Check-In");
		
		JLabel lblNewLabel_1 = new JLabel("Bem vindo ao Check-In");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldCheckIn = new JTextField();
		textFieldCheckIn.setColumns(10);
		
		JLabel lblNewLabelAtualizar = new JLabel("Atualizar");
		
		textFieldAtualizar = new JTextField();
		textFieldAtualizar.setColumns(10);
		
		JButton btnNewButton = new JButton("Realizar Check-In");
		btnNewButton.addMouseListener(new MouseAdapter() {
		

			
		});
		
		JButton btnNewButton_1 = new JButton("Deletar ");
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabelDataCheckIn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textFieldCheckIn, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabelAtualizar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(textFieldAtualizar, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_1)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabelDataCheckIn))
						.addComponent(textFieldCheckIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabelAtualizar)
						.addComponent(textFieldAtualizar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

