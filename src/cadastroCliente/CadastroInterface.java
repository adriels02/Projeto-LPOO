package cadastroCliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInterface frame = new CadastroInterface();
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
	public CadastroInterface() {
		setTitle("Cadastro Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sobrenome");
		lblNewLabel_2.setBounds(152, 36, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 53, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 53, 313, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("RG");
		lblNewLabel_3.setBounds(10, 84, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setBounds(152, 84, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setBounds(293, 84, 58, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 107, 121, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(152, 107, 121, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(293, 107, 172, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setBounds(10, 138, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 158, 209, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pessoa Física");
		rdbtnNewRadioButton.setBounds(242, 157, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Pessoa Jurídica");
		rdbtnNewRadioButton_1.setBounds(356, 157, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Dados Reserva");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 189, 88, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nº Reserva");
		lblNewLabel_8.setBounds(10, 214, 121, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 233, 121, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Nº Apt");
		lblNewLabel_9.setBounds(152, 214, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(152, 233, 93, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo Apt");
		lblNewLabel_10.setBounds(263, 214, 88, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(265, 233, 200, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Nº Diárias");
		lblNewLabel_11.setBounds(10, 264, 88, 14);
		contentPane.add(lblNewLabel_11);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(485, 0, 17, 381);
		contentPane.add(scrollBar);
		
		textField_9 = new JTextField();
		textField_9.setBounds(10, 280, 121, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Valor Diárias");
		lblNewLabel_12.setBounds(152, 264, 93, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_10 = new JTextField();
		textField_10.setBounds(152, 280, 93, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Qtd Adultos");
		lblNewLabel_13.setBounds(263, 264, 73, 14);
		contentPane.add(lblNewLabel_13);
		
		textField_11 = new JTextField();
		textField_11.setBounds(263, 280, 99, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Qtd Criança");
		lblNewLabel_14.setBounds(372, 264, 73, 14);
		contentPane.add(lblNewLabel_14);
		
		textField_12 = new JTextField();
		textField_12.setBounds(372, 280, 93, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Data Reserva");
		lblNewLabel_15.setBounds(10, 311, 88, 14);
		contentPane.add(lblNewLabel_15);
		
		textField_13 = new JTextField();
		textField_13.setBounds(10, 332, 121, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Hora Entrada");
		lblNewLabel_16.setBounds(152, 311, 93, 14);
		contentPane.add(lblNewLabel_16);
		
		textField_14 = new JTextField();
		textField_14.setBounds(152, 332, 93, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Hora Saída");
		lblNewLabel_17.setBounds(263, 311, 99, 14);
		contentPane.add(lblNewLabel_17);
		
		textField_15 = new JTextField();
		textField_15.setBounds(263, 332, 99, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(376, 331, 89, 23);
		contentPane.add(btnNewButton);
	}
}
