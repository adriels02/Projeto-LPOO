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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

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
		frmCadastroDasReservas.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceReservas.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDasReservas.setBounds(100, 100, 807, 474);
		frmCadastroDasReservas.setLocationRelativeTo(null);
		frmCadastroDasReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{63, 118, 130, 35, 34, 7, 97, 89, 126, 0};
		gridBagLayout.rowHeights = new int[]{17, 23, 20, 38, 20, 14, 20, 48, 14, 20, 68, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCadastroDasReservas.getContentPane().setLayout(gridBagLayout);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCriarNovaReserva = new JButton("Novo");
		btnCriarNovaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnBuscarNome = new JButton("Buscar");
		btnBuscarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBuscarNome = new GridBagConstraints();
		gbc_btnBuscarNome.weighty = 1.0;
		gbc_btnBuscarNome.weightx = 1.0;
		gbc_btnBuscarNome.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscarNome.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarNome.gridx = 1;
		gbc_btnBuscarNome.gridy = 1;
		frmCadastroDasReservas.getContentPane().add(btnBuscarNome, gbc_btnBuscarNome);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 1.0;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 1;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Celular:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 1.0;
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 8;
		gbc_lblNewLabel_3.gridy = 1;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textfNomeCliente = new JTextField();
		GridBagConstraints gbc_textfNomeCliente = new GridBagConstraints();
		gbc_textfNomeCliente.weighty = 1.0;
		gbc_textfNomeCliente.weightx = 1.0;
		gbc_textfNomeCliente.anchor = GridBagConstraints.NORTH;
		gbc_textfNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textfNomeCliente.gridwidth = 4;
		gbc_textfNomeCliente.gridx = 0;
		gbc_textfNomeCliente.gridy = 2;
		frmCadastroDasReservas.getContentPane().add(textfNomeCliente, gbc_textfNomeCliente);
		textfNomeCliente.setColumns(10);
		
		textfCPF = new JTextField();
		GridBagConstraints gbc_textfCPF = new GridBagConstraints();
		gbc_textfCPF.weighty = 1.0;
		gbc_textfCPF.weightx = 1.0;
		gbc_textfCPF.anchor = GridBagConstraints.NORTH;
		gbc_textfCPF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfCPF.insets = new Insets(0, 0, 5, 5);
		gbc_textfCPF.gridwidth = 3;
		gbc_textfCPF.gridx = 5;
		gbc_textfCPF.gridy = 2;
		frmCadastroDasReservas.getContentPane().add(textfCPF, gbc_textfCPF);
		textfCPF.setColumns(10);
		
		JButton btnBuscarNumero = new JButton("Buscar");
		btnBuscarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textfCelular = new JTextField();
		GridBagConstraints gbc_textfCelular = new GridBagConstraints();
		gbc_textfCelular.weighty = 1.0;
		gbc_textfCelular.weightx = 1.0;
		gbc_textfCelular.anchor = GridBagConstraints.NORTH;
		gbc_textfCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfCelular.insets = new Insets(0, 0, 5, 0);
		gbc_textfCelular.gridx = 8;
		gbc_textfCelular.gridy = 2;
		frmCadastroDasReservas.getContentPane().add(textfCelular, gbc_textfCelular);
		textfCelular.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(" Número:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 1.0;
		gbc_lblNewLabel_4.weightx = 1.0;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		GridBagConstraints gbc_btnBuscarNumero = new GridBagConstraints();
		gbc_btnBuscarNumero.weighty = 1.0;
		gbc_btnBuscarNumero.weightx = 1.0;
		gbc_btnBuscarNumero.anchor = GridBagConstraints.WEST;
		gbc_btnBuscarNumero.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarNumero.gridx = 1;
		gbc_btnBuscarNumero.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(btnBuscarNumero, gbc_btnBuscarNumero);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo do Quarto:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 1.0;
		gbc_lblNewLabel_5.weightx = 1.0;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Andar:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.weighty = 1.0;
		gbc_lblNewLabel_6.weightx = 1.0;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Valor Diária:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weighty = 1.0;
		gbc_lblNewLabel_7.weightx = 1.0;
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 8;
		gbc_lblNewLabel_7.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textfNumero = new JTextField();
		GridBagConstraints gbc_textfNumero = new GridBagConstraints();
		gbc_textfNumero.weighty = 1.0;
		gbc_textfNumero.weightx = 1.0;
		gbc_textfNumero.anchor = GridBagConstraints.NORTH;
		gbc_textfNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfNumero.insets = new Insets(0, 0, 5, 5);
		gbc_textfNumero.gridwidth = 2;
		gbc_textfNumero.gridx = 0;
		gbc_textfNumero.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(textfNumero, gbc_textfNumero);
		textfNumero.setColumns(10);
		
		JComboBox cbxTipoQuarto = new JComboBox();
		cbxTipoQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		GridBagConstraints gbc_cbxTipoQuarto = new GridBagConstraints();
		gbc_cbxTipoQuarto.weighty = 1.0;
		gbc_cbxTipoQuarto.weightx = 1.0;
		gbc_cbxTipoQuarto.anchor = GridBagConstraints.NORTH;
		gbc_cbxTipoQuarto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoQuarto.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTipoQuarto.gridwidth = 2;
		gbc_cbxTipoQuarto.gridx = 2;
		gbc_cbxTipoQuarto.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(cbxTipoQuarto, gbc_cbxTipoQuarto);
		
		JSpinner spinnerAndar = new JSpinner();
		GridBagConstraints gbc_spinnerAndar = new GridBagConstraints();
		gbc_spinnerAndar.anchor = GridBagConstraints.NORTH;
		gbc_spinnerAndar.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerAndar.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerAndar.gridwidth = 3;
		gbc_spinnerAndar.gridx = 5;
		gbc_spinnerAndar.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(spinnerAndar, gbc_spinnerAndar);
		
		textfValorDiaria = new JTextField();
		GridBagConstraints gbc_textfValorDiaria = new GridBagConstraints();
		gbc_textfValorDiaria.weighty = 1.0;
		gbc_textfValorDiaria.weightx = 1.0;
		gbc_textfValorDiaria.anchor = GridBagConstraints.NORTH;
		gbc_textfValorDiaria.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfValorDiaria.insets = new Insets(0, 0, 5, 0);
		gbc_textfValorDiaria.gridx = 8;
		gbc_textfValorDiaria.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(textfValorDiaria, gbc_textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel(" Entrada:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.weighty = 1.0;
		gbc_lblNewLabel_8.weightx = 1.0;
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridwidth = 2;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Saída:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.weighty = 1.0;
		gbc_lblNewLabel_9.weightx = 1.0;
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Mês:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.weighty = 1.0;
		gbc_lblNewLabel_10.weightx = 1.0;
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridwidth = 2;
		gbc_lblNewLabel_10.gridx = 5;
		gbc_lblNewLabel_10.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Ano:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.weighty = 1.0;
		gbc_lblNewLabel_11.weightx = 1.0;
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 8;
		gbc_lblNewLabel_11.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.weighty = 1.0;
		gbc_textField.weightx = 1.0;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		frmCadastroDasReservas.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.weighty = 1.0;
		gbc_textField_1.weightx = 1.0;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 6;
		frmCadastroDasReservas.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weighty = 1.0;
		gbc_comboBox.weightx = 1.0;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 6;
		frmCadastroDasReservas.getContentPane().add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2023", "2024", "2025"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.weighty = 1.0;
		gbc_comboBox_1.weightx = 1.0;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 8;
		gbc_comboBox_1.gridy = 6;
		frmCadastroDasReservas.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_14 = new JLabel("Dias da estadia:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_14.weighty = 1.0;
		gbc_lblNewLabel_14.weightx = 1.0;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridwidth = 2;
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 8;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JLabel lblNewLabel_13 = new JLabel("Pagamento:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.weighty = 1.0;
		gbc_lblNewLabel_13.weightx = 1.0;
		gbc_lblNewLabel_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridwidth = 2;
		gbc_lblNewLabel_13.gridx = 2;
		gbc_lblNewLabel_13.gridy = 8;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("Forma de Pagamento:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.weighty = 1.0;
		gbc_lblNewLabel_12.weightx = 1.0;
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridwidth = 2;
		gbc_lblNewLabel_12.gridx = 5;
		gbc_lblNewLabel_12.gridy = 8;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		textfDiasEstadia = new JTextField();
		GridBagConstraints gbc_textfDiasEstadia = new GridBagConstraints();
		gbc_textfDiasEstadia.weighty = 1.0;
		gbc_textfDiasEstadia.weightx = 1.0;
		gbc_textfDiasEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfDiasEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_textfDiasEstadia.gridwidth = 2;
		gbc_textfDiasEstadia.gridx = 0;
		gbc_textfDiasEstadia.gridy = 9;
		frmCadastroDasReservas.getContentPane().add(textfDiasEstadia, gbc_textfDiasEstadia);
		textfDiasEstadia.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Efetuado", "Não Efetuado"}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.weighty = 1.0;
		gbc_comboBox_3.weightx = 1.0;
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridwidth = 2;
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 9;
		frmCadastroDasReservas.getContentPane().add(comboBox_3, gbc_comboBox_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cartão", "Dinheiro"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.weighty = 1.0;
		gbc_comboBox_2.weightx = 1.0;
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridwidth = 3;
		gbc_comboBox_2.gridx = 5;
		gbc_comboBox_2.gridy = 9;
		frmCadastroDasReservas.getContentPane().add(comboBox_2, gbc_comboBox_2);
		GridBagConstraints gbc_btnCriarNovaReserva = new GridBagConstraints();
		gbc_btnCriarNovaReserva.weighty = 1.0;
		gbc_btnCriarNovaReserva.weightx = 1.0;
		gbc_btnCriarNovaReserva.anchor = GridBagConstraints.NORTH;
		gbc_btnCriarNovaReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCriarNovaReserva.insets = new Insets(0, 0, 0, 5);
		gbc_btnCriarNovaReserva.gridx = 1;
		gbc_btnCriarNovaReserva.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(btnCriarNovaReserva, gbc_btnCriarNovaReserva);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.weighty = 1.0;
		gbc_btnSalvar.weightx = 1.0;
		gbc_btnSalvar.anchor = GridBagConstraints.NORTH;
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(btnSalvar, gbc_btnSalvar);
		
		JLabel lblNewLabel_15 = new JLabel("Total à pagar:");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_15.weighty = 1.0;
		gbc_lblNewLabel_15.weightx = 1.0;
		gbc_lblNewLabel_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 6;
		gbc_lblNewLabel_15.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		textfPagar = new JTextField();
		GridBagConstraints gbc_textfPagar = new GridBagConstraints();
		gbc_textfPagar.anchor = GridBagConstraints.NORTH;
		gbc_textfPagar.weighty = 1.0;
		gbc_textfPagar.weightx = 1.0;
		gbc_textfPagar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfPagar.gridx = 7;
		gbc_textfPagar.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(textfPagar, gbc_textfPagar);
		textfPagar.setColumns(10);
	}
}
