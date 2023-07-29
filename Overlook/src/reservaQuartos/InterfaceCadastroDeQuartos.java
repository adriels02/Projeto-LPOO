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

import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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
		frmCadastroDeQuartos.getContentPane().setBackground(new Color(255, 255, 255));
		frmCadastroDeQuartos.setResizable(false);
		frmCadastroDeQuartos.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDeQuartos.setBounds(100, 100, 807, 474);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeQuartos.setSize(1280,720); 
		frmCadastroDeQuartos.setLocationRelativeTo(null);
		frmCadastroDeQuartos.setUndecorated(true);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(240, 240, 240));
		table_1.setBounds(522, 210, 723, 312);
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
		frmCadastroDeQuartos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Cadastro do Quarto");
		lblNewLabel.setBounds(29, 50, 350, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(0, 0, 0, 0);
		frmCadastroDeQuartos.getContentPane().add(list);
		
		JLabel lblListaDeQuartos = new JLabel("Lista de Quartos");
		lblListaDeQuartos.setBounds(522, 50, 279, 42);
		lblListaDeQuartos.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmCadastroDeQuartos.getContentPane().add(lblListaDeQuartos);
		
		JLabel lblNmero = new JLabel(" Número");
		lblNmero.setForeground(new Color(38, 9, 55));
		lblNmero.setBounds(29, 158, 69, 15);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNmero);
		
		textfNumQuarto = new JTextField();
		textfNumQuarto.setBounds(98, 154, 123, 23);
		textfNumQuarto.setForeground(new Color(0, 0, 0));
		frmCadastroDeQuartos.getContentPane().add(textfNumQuarto);
		textfNumQuarto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Andar");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(308, 158, 44, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBackground(new Color(225, 225, 225));
		btnNewButton_3.setForeground(new Color(38, 9, 55));
		btnNewButton_3.setBounds(856, 154, 120, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(356, 154, 114, 23);
		frmCadastroDeQuartos.getContentPane().add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Pesquisar");
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setBounds(522, 158, 139, 15);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(586, 154, 251, 23);
		frmCadastroDeQuartos.getContentPane().add(textField);
		textField.setColumns(10);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Apagar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBackground(new Color(225, 225, 225));
		btnNewButton_4.setForeground(new Color(38, 9, 55));
		btnNewButton_4.setBounds(990, 154, 120, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sair");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBackground(new Color(225, 225, 225));
		btnNewButton_5.setForeground(new Color(38, 9, 55));
		btnNewButton_5.setBounds(1125, 154, 120, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel(" Descrição ");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setBounds(29, 210, 69, 15);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_2);
		
		JTextArea textaDescricao = new JTextArea();
		textaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textaDescricao.setBackground(new Color(240, 240, 240));
		textaDescricao.setBounds(98, 210, 372, 138);
		frmCadastroDeQuartos.getContentPane().add(textaDescricao);
		frmCadastroDeQuartos.getContentPane().add(table_1);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setForeground(new Color(38, 9, 55));
		btnNovo.setBackground(new Color(225, 225, 225));
		btnNovo.setBounds(29, 660, 156, 23);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel(" Valor Diária");
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setBounds(29, 398, 76, 15);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_3);
		
		textfValorDiaria = new JTextField();
		textfValorDiaria.setBounds(128, 394, 136, 23);
		frmCadastroDeQuartos.getContentPane().add(textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(308, 398, 44, 15);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_4);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setForeground(new Color(38, 9, 55));
		cbxEstado.setBounds(356, 394, 85, 23);
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponível", "Ocupado", "Manutenção"}));
		frmCadastroDeQuartos.getContentPane().add(cbxEstado);
		
		JLabel lblTotalRegistros = new JLabel("");
		lblTotalRegistros.setBounds(0, 0, 0, 0);
		frmCadastroDeQuartos.getContentPane().add(lblTotalRegistros);
		
		JLabel lblNewLabel_5 = new JLabel(" Tipo de Quarto");
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(29, 477, 92, 15);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_5);
		
		JComboBox cbxTipoDeQuarto = new JComboBox();
		cbxTipoDeQuarto.setForeground(new Color(38, 9, 55));
		cbxTipoDeQuarto.setBounds(128, 474, 165, 23);
		cbxTipoDeQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		frmCadastroDeQuartos.getContentPane().add(cbxTipoDeQuarto);
		
		JLabel lblNewLabel_8 = new JLabel(" Capacidade");
		lblNewLabel_8.setForeground(new Color(38, 9, 55));
		lblNewLabel_8.setBounds(29, 557, 76, 15);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(38, 9, 55));
		comboBox.setBounds(128, 554, 164, 23);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		frmCadastroDeQuartos.getContentPane().add(comboBox);
		frmCadastroDeQuartos.getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setForeground(new Color(38, 9, 55));
		btnSalvar.setBackground(new Color(225, 225, 225));
		btnSalvar.setBounds(190, 660, 125, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setForeground(new Color(38, 9, 55));
		btnLimpar.setBackground(new Color(225, 225, 225));
		btnLimpar.setBounds(320, 660, 173, 23);
		frmCadastroDeQuartos.getContentPane().add(btnLimpar);
		
		JLabel lblNewLabel_7 = new JLabel("Total Registros");
		lblNewLabel_7.setForeground(new Color(38, 9, 55));
		lblNewLabel_7.setBounds(523, 540, 128, 15);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_7);
		

		JLabel lblLogoPequena = new JLabel("");
		lblLogoPequena.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/logo 220 x150.png")));
		lblLogoPequena.setBounds(897, 549, 220, 150);
		frmCadastroDeQuartos.getContentPane().add(lblLogoPequena);
		
		JButton btnMenuPrincipal = new JButton("Menu");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				frmCadastroDeQuartos.dispose();
			}
		});
		btnMenuPrincipal.setBackground(new Color(255, 128, 64));
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.setBounds(0, 0, 65, 23);
		frmCadastroDeQuartos.getContentPane().add(btnMenuPrincipal);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmCadastroDeQuartos.dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		frmCadastroDeQuartos.getContentPane().add(btnFecharTela);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				frmCadastroDeQuartos.dispose();
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnNewButton.setBounds(1211, 0, 30, 30);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton);
		
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		frmCadastroDeQuartos.getContentPane().add(lblLogoTransparente);
		
	}
}
