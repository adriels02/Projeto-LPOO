package reservaQuartos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class InterfaceCadastroDeQuartos {

	private JFrame frmCadastroDeQuartos;
	private JTextField textfNumQuarto;
	private JTextField textfValorDiaria;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroDeQuartos window = new InterfaceCadastroDeQuartos();
					window.frmCadastroDeQuartos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceCadastroDeQuartos() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeQuartos = new JFrame();
		frmCadastroDeQuartos.setResizable(false);
		frmCadastroDeQuartos.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDeQuartos.setBounds(100, 100, 807, 474);
		frmCadastroDeQuartos.setLocationRelativeTo(null);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 35, 18, 39, 45, 41, 25, 21, 85, 47, 56, 29, 35, 4, 67, 67, 67, 0};
		gridBagLayout.rowHeights = new int[]{15, 23, 88, 20, 14, 20, 20, 79, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCadastroDeQuartos.getContentPane().setLayout(gridBagLayout);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(294);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(318);
		
		JLabel lblNewLabel = new JLabel(" Cadastro do Quarto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.anchor = GridBagConstraints.NORTHWEST;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		frmCadastroDeQuartos.getContentPane().add(list, gbc_list);
		
		JLabel lblListaDeQuartos = new JLabel("Lista de Quartos");
		lblListaDeQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblListaDeQuartos = new GridBagConstraints();
		gbc_lblListaDeQuartos.weighty = 1.0;
		gbc_lblListaDeQuartos.weightx = 1.0;
		gbc_lblListaDeQuartos.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblListaDeQuartos.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaDeQuartos.gridwidth = 2;
		gbc_lblListaDeQuartos.gridx = 10;
		gbc_lblListaDeQuartos.gridy = 0;
		frmCadastroDeQuartos.getContentPane().add(lblListaDeQuartos, gbc_lblListaDeQuartos);
		
		JLabel lblNmero = new JLabel(" Número: ");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.weighty = 1.0;
		gbc_lblNmero.weightx = 1.0;
		gbc_lblNmero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero.gridwidth = 2;
		gbc_lblNmero.gridx = 0;
		gbc_lblNmero.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(lblNmero, gbc_lblNmero);
		
		textfNumQuarto = new JTextField();
		textfNumQuarto.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_textfNumQuarto = new GridBagConstraints();
		gbc_textfNumQuarto.weighty = 1.0;
		gbc_textfNumQuarto.weightx = 1.0;
		gbc_textfNumQuarto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfNumQuarto.insets = new Insets(0, 0, 5, 5);
		gbc_textfNumQuarto.gridwidth = 3;
		gbc_textfNumQuarto.gridx = 2;
		gbc_textfNumQuarto.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(textfNumQuarto, gbc_textfNumQuarto);
		textfNumQuarto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Andar: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.weighty = 1.0;
		gbc_spinner.weightx = 1.0;
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 8;
		gbc_spinner.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(spinner, gbc_spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Pesquisar");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.weighty = 1.0;
		gbc_lblNewLabel_6.weightx = 1.0;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 10;
		gbc_lblNewLabel_6.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weighty = 1.0;
		gbc_textField.weightx = 1.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 11;
		gbc_textField.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.weighty = 1.0;
		gbc_btnNewButton_3.weightx = 1.0;
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 14;
		gbc_btnNewButton_3.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Apagar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.weighty = 1.0;
		gbc_btnNewButton_4.weightx = 1.0;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 15;
		gbc_btnNewButton_4.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sair");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.weighty = 1.0;
		gbc_btnNewButton_5.weightx = 1.0;
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 16;
		gbc_btnNewButton_5.gridy = 1;
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel(" Descrição: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 1.0;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextArea textaDescricao = new JTextArea();
		GridBagConstraints gbc_textaDescricao = new GridBagConstraints();
		gbc_textaDescricao.weighty = 1.0;
		gbc_textaDescricao.weightx = 1.0;
		gbc_textaDescricao.fill = GridBagConstraints.BOTH;
		gbc_textaDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_textaDescricao.gridwidth = 7;
		gbc_textaDescricao.gridx = 2;
		gbc_textaDescricao.gridy = 2;
		frmCadastroDeQuartos.getContentPane().add(textaDescricao, gbc_textaDescricao);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.weighty = 1.0;
		gbc_table_1.weightx = 1.0;
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.gridheight = 4;
		gbc_table_1.gridwidth = 7;
		gbc_table_1.gridx = 10;
		gbc_table_1.gridy = 2;
		frmCadastroDeQuartos.getContentPane().add(table_1, gbc_table_1);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel(" Valor Diária: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 1.0;
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textfValorDiaria = new JTextField();
		GridBagConstraints gbc_textfValorDiaria = new GridBagConstraints();
		gbc_textfValorDiaria.weighty = 1.0;
		gbc_textfValorDiaria.weightx = 1.0;
		gbc_textfValorDiaria.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfValorDiaria.insets = new Insets(0, 0, 5, 5);
		gbc_textfValorDiaria.gridwidth = 3;
		gbc_textfValorDiaria.gridx = 3;
		gbc_textfValorDiaria.gridy = 3;
		frmCadastroDeQuartos.getContentPane().add(textfValorDiaria, gbc_textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 1.0;
		gbc_lblNewLabel_4.weightx = 1.0;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 3;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponível", "Ocupado", "Manutenção"}));
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.weighty = 1.0;
		gbc_cbxEstado.weightx = 1.0;
		gbc_cbxEstado.anchor = GridBagConstraints.WEST;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.gridx = 8;
		gbc_cbxEstado.gridy = 3;
		frmCadastroDeQuartos.getContentPane().add(cbxEstado, gbc_cbxEstado);
		
		JLabel lblTotalRegistros = new JLabel("");
		GridBagConstraints gbc_lblTotalRegistros = new GridBagConstraints();
		gbc_lblTotalRegistros.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotalRegistros.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalRegistros.gridwidth = 2;
		gbc_lblTotalRegistros.gridx = 14;
		gbc_lblTotalRegistros.gridy = 4;
		frmCadastroDeQuartos.getContentPane().add(lblTotalRegistros, gbc_lblTotalRegistros);
		
		JLabel lblNewLabel_5 = new JLabel(" Tipo de Quarto:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 1.0;
		gbc_lblNewLabel_5.weightx = 1.0;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridwidth = 3;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox cbxTipoDeQuarto = new JComboBox();
		cbxTipoDeQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		GridBagConstraints gbc_cbxTipoDeQuarto = new GridBagConstraints();
		gbc_cbxTipoDeQuarto.weighty = 1.0;
		gbc_cbxTipoDeQuarto.weightx = 1.0;
		gbc_cbxTipoDeQuarto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoDeQuarto.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTipoDeQuarto.gridwidth = 4;
		gbc_cbxTipoDeQuarto.gridx = 3;
		gbc_cbxTipoDeQuarto.gridy = 5;
		frmCadastroDeQuartos.getContentPane().add(cbxTipoDeQuarto, gbc_cbxTipoDeQuarto);
		
		JLabel lblNewLabel_8 = new JLabel(" Capacidade:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.weighty = 1.0;
		gbc_lblNewLabel_8.weightx = 1.0;
		gbc_lblNewLabel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridwidth = 4;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 6;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weighty = 1.0;
		gbc_comboBox.weightx = 1.0;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 6;
		frmCadastroDeQuartos.getContentPane().add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.weighty = 1.0;
		gbc_btnNovo.weightx = 1.0;
		gbc_btnNovo.anchor = GridBagConstraints.NORTH;
		gbc_btnNovo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridwidth = 3;
		gbc_btnNovo.gridx = 1;
		gbc_btnNovo.gridy = 8;
		frmCadastroDeQuartos.getContentPane().add(btnNovo, gbc_btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.weighty = 1.0;
		gbc_btnSalvar.weightx = 1.0;
		gbc_btnSalvar.anchor = GridBagConstraints.NORTH;
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridwidth = 3;
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 8;
		frmCadastroDeQuartos.getContentPane().add(btnSalvar, gbc_btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.weighty = 1.0;
		gbc_btnLimpar.weightx = 1.0;
		gbc_btnLimpar.anchor = GridBagConstraints.NORTH;
		gbc_btnLimpar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpar.gridwidth = 2;
		gbc_btnLimpar.gridx = 7;
		gbc_btnLimpar.gridy = 8;
		frmCadastroDeQuartos.getContentPane().add(btnLimpar, gbc_btnLimpar);
		
		JLabel lblNewLabel_7 = new JLabel("Total Registros:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weighty = 1.0;
		gbc_lblNewLabel_7.weightx = 1.0;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridwidth = 3;
		gbc_lblNewLabel_7.gridx = 12;
		gbc_lblNewLabel_7.gridy = 8;
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
	}
}
