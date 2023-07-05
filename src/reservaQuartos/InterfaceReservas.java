package reservaQuartos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceReservas {

	private JFrame frmCadastroDasReservas;
	private JTextField textfNomeCliente;
	private JTextField textfCPF;
	private JTextField textfCelular;
	private JTextField textfNumero;
	private JTextField textfValorDiaria;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textfDiasEstadia;
	private JTextField textfPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceReservas window = new InterfaceReservas();
					window.frmCadastroDasReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceReservas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDasReservas = new JFrame();
		frmCadastroDasReservas.setTitle("CADASTRO DAS RESERVAS");
		frmCadastroDasReservas.setBounds(100, 100, 807, 474);
		frmCadastroDasReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDasReservas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(339, 11, 101, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(10, 45, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_1);
		
		textfNomeCliente = new JTextField();
		textfNomeCliente.setBounds(10, 82, 341, 20);
		frmCadastroDasReservas.getContentPane().add(textfNomeCliente);
		textfNomeCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(405, 45, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_2);
		
		textfCPF = new JTextField();
		textfCPF.setBounds(405, 82, 157, 20);
		frmCadastroDasReservas.getContentPane().add(textfCPF);
		textfCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Celular:");
		lblNewLabel_3.setBounds(610, 45, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_3);
		
		textfCelular = new JTextField();
		textfCelular.setBounds(610, 82, 126, 20);
		frmCadastroDasReservas.getContentPane().add(textfCelular);
		textfCelular.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Número:");
		lblNewLabel_4.setBounds(10, 113, 62, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo do Quarto:");
		lblNewLabel_5.setBounds(192, 113, 101, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_5);
		
		textfNumero = new JTextField();
		textfNumero.setBounds(10, 138, 147, 20);
		frmCadastroDasReservas.getContentPane().add(textfNumero);
		textfNumero.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Andar:");
		lblNewLabel_6.setBounds(405, 113, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_6);
		
		JSpinner spinnerAndar = new JSpinner();
		spinnerAndar.setBounds(405, 138, 157, 20);
		frmCadastroDasReservas.getContentPane().add(spinnerAndar);
		
		JComboBox cbxTipoQuarto = new JComboBox();
		cbxTipoQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		cbxTipoQuarto.setBounds(192, 137, 159, 22);
		frmCadastroDasReservas.getContentPane().add(cbxTipoQuarto);
		
		JLabel lblNewLabel_7 = new JLabel("Valor Diária:");
		lblNewLabel_7.setBounds(610, 113, 101, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_7);
		
		textfValorDiaria = new JTextField();
		textfValorDiaria.setBounds(610, 138, 126, 20);
		frmCadastroDasReservas.getContentPane().add(textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JButton btnBuscarNome = new JButton("Buscar");
		btnBuscarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarNome.setBounds(73, 45, 84, 14);
		frmCadastroDasReservas.getContentPane().add(btnBuscarNome);
		
		JButton btnBuscarNumero = new JButton("Buscar");
		btnBuscarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarNumero.setBounds(73, 113, 84, 14);
		frmCadastroDasReservas.getContentPane().add(btnBuscarNumero);
		
		JLabel lblNewLabel_8 = new JLabel("Entrada:");
		lblNewLabel_8.setBounds(10, 176, 74, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(10, 201, 101, 20);
		frmCadastroDasReservas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Saída:");
		lblNewLabel_9.setBounds(192, 176, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 201, 84, 20);
		frmCadastroDasReservas.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Mês:");
		lblNewLabel_10.setBounds(405, 176, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(405, 200, 84, 22);
		frmCadastroDasReservas.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Ano:");
		lblNewLabel_11.setBounds(610, 176, 46, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2023", "2024", "2025"}));
		comboBox_1.setBounds(610, 200, 84, 22);
		frmCadastroDasReservas.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("Forma de Pagamento:");
		lblNewLabel_12.setBounds(405, 258, 140, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_12);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cartão", "Dinheiro"}));
		comboBox_2.setBounds(405, 283, 159, 22);
		frmCadastroDasReservas.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_13 = new JLabel("Pagamento:");
		lblNewLabel_13.setBounds(192, 258, 147, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_13);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Efetuado", "Não Efetuado"}));
		comboBox_3.setBounds(192, 283, 147, 22);
		frmCadastroDasReservas.getContentPane().add(comboBox_3);
		
		JButton btnCriarNovaReserva = new JButton("Novo");
		btnCriarNovaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarNovaReserva.setBounds(104, 375, 89, 23);
		frmCadastroDasReservas.getContentPane().add(btnCriarNovaReserva);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(222, 375, 89, 23);
		frmCadastroDasReservas.getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel_14 = new JLabel("Dias da estadia:");
		lblNewLabel_14.setBounds(10, 258, 101, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_14);
		
		textfDiasEstadia = new JTextField();
		textfDiasEstadia.setBounds(10, 283, 101, 20);
		frmCadastroDasReservas.getContentPane().add(textfDiasEstadia);
		textfDiasEstadia.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Total à pagar:");
		lblNewLabel_15.setBounds(405, 379, 84, 14);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_15);
		
		textfPagar = new JTextField();
		textfPagar.setBounds(499, 376, 86, 20);
		frmCadastroDasReservas.getContentPane().add(textfPagar);
		textfPagar.setColumns(10);
	}
}
