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

public class InterfaceCadastroDeQuartos {

	private JFrame frmCadastroDeQuartos;
	private JTextField textfNumQuarto;
	private JTextField tfDescricao;
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
		frmCadastroDeQuartos.setTitle("CADASTRO DE QUARTOS");
		frmCadastroDeQuartos.setBounds(100, 100, 807, 474);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeQuartos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro do Quarto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 133, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel);
		
		JLabel lblListaDeQuartos = new JLabel("Lista de Quartos");
		lblListaDeQuartos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaDeQuartos.setBounds(369, 11, 117, 14);
		frmCadastroDeQuartos.getContentPane().add(lblListaDeQuartos);
		
		JLabel lblNmero = new JLabel("Número: ");
		lblNmero.setBounds(10, 36, 59, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNmero);
		
		textfNumQuarto = new JTextField();
		textfNumQuarto.setForeground(new Color(0, 0, 0));
		textfNumQuarto.setBounds(79, 33, 86, 20);
		frmCadastroDeQuartos.getContentPane().add(textfNumQuarto);
		textfNumQuarto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Andar: ");
		lblNewLabel_1.setBounds(192, 36, 46, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_1);
		
		tfDescricao = new JTextField();
		tfDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		tfDescricao.setForeground(new Color(0, 0, 0));
		tfDescricao.setBounds(79, 76, 258, 104);
		frmCadastroDeQuartos.getContentPane().add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(251, 33, 86, 20);
		frmCadastroDeQuartos.getContentPane().add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição: ");
		lblNewLabel_2.setBounds(10, 79, 69, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(124, 366, 89, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Valor Diária: ");
		lblNewLabel_3.setBounds(10, 209, 76, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_3);
		
		textfValorDiaria = new JTextField();
		textfValorDiaria.setBounds(96, 206, 86, 20);
		frmCadastroDeQuartos.getContentPane().add(textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(192, 209, 46, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_4);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponível", "Indisponível"}));
		cbxEstado.setBounds(248, 205, 89, 22);
		frmCadastroDeQuartos.getContentPane().add(cbxEstado);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Quarto:");
		lblNewLabel_5.setBounds(10, 259, 86, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_5);
		
		JComboBox cbxTipoDeQuarto = new JComboBox();
		cbxTipoDeQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		cbxTipoDeQuarto.setBounds(114, 255, 99, 22);
		frmCadastroDeQuartos.getContentPane().add(cbxTipoDeQuarto);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(25, 366, 89, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setBounds(223, 366, 89, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Pesquisar");
		lblNewLabel_6.setBounds(369, 36, 59, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_6);
		
		JList list = new JList();
		list.setBounds(369, 162, 150, 0);
		frmCadastroDeQuartos.getContentPane().add(list);
		
		textField = new JTextField();
		textField.setBounds(433, 36, 86, 20);
		frmCadastroDeQuartos.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setBounds(529, 32, 76, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Apagar");
		btnNewButton_4.setBounds(615, 32, 76, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sair");
		btnNewButton_5.setBounds(701, 32, 65, 23);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_5);
	
		
		table_1 = new JTable();
		table_1.setBounds(402, 102, 364, 192);
		frmCadastroDeQuartos.getContentPane().add(table_1);
		
		JLabel lblNewLabel_7 = new JLabel("Total Registros:");
		lblNewLabel_7.setBounds(505, 322, 99, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_7);
		
		JLabel lblTotalRegistros = new JLabel("");
		lblTotalRegistros.setBounds(623, 322, 46, 14);
		frmCadastroDeQuartos.getContentPane().add(lblTotalRegistros);
		
		JLabel lblNewLabel_8 = new JLabel("Capacidade:");
		lblNewLabel_8.setBounds(10, 295, 76, 14);
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBounds(114, 291, 99, 22);
		frmCadastroDeQuartos.getContentPane().add(comboBox);
	}
}
