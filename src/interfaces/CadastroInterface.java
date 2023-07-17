package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cadastroCliente.ArmazenarCadastroCliente;
import cadastroCliente.Cliente;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtfNome;
	private JTextField txtfSobrenome;
	private JTextField txtfCpf;
	private JTextField txtfCnpj;
	private JTextField txtfTelefone;
	private JTextField txtfEmail;
	private JTextField txtfNumeroReserva;
	private JTextField txtfNumeroApt;
	private JTextField txtfTipoApt;
	private JTextField txtfNumeroDiarias;
	private JTextField txtfValorDiarias;
	private JTextField txtfQtdAdulto;
	private JTextField txtfQtdCrianca;
	private JTextField txtfDataReserva;
	private JTextField txtfHoraEntrada;
	private JTextField txtfHoraSaida;
	private ButtonGroup bg = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=-10,19
	 */
	private final JPanel panel = new JPanel();

	ArmazenarCadastroCliente armazenarCadastro = new ArmazenarCadastroCliente();
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
		setBounds(100, 100, 518, 411);
		//abrir no meio da tela
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{121, 93, 22, 0, 68, 131, 0};
		gbl_contentPane.rowHeights = new int[]{14, 14, 20, 14, 20, 0, 0, 14, 23, 14, 14, 20, 14, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Dados Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sobrenome");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtfNome = new JTextField();
		GridBagConstraints gbc_txtfNome = new GridBagConstraints();
		gbc_txtfNome.anchor = GridBagConstraints.NORTH;
		gbc_txtfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtfNome.gridx = 0;
		gbc_txtfNome.gridy = 2;
		contentPane.add(txtfNome, gbc_txtfNome);
		txtfNome.setColumns(10);
		
		txtfSobrenome = new JTextField();
		GridBagConstraints gbc_txtfSobrenome = new GridBagConstraints();
		gbc_txtfSobrenome.anchor = GridBagConstraints.NORTH;
		gbc_txtfSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_txtfSobrenome.gridwidth = 5;
		gbc_txtfSobrenome.gridx = 1;
		gbc_txtfSobrenome.gridy = 2;
		contentPane.add(txtfSobrenome, gbc_txtfSobrenome);
		txtfSobrenome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CNPJ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtfCpf = new JTextField();
		GridBagConstraints gbc_txtfCpf = new GridBagConstraints();
		gbc_txtfCpf.anchor = GridBagConstraints.NORTH;
		gbc_txtfCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfCpf.insets = new Insets(0, 0, 5, 5);
		gbc_txtfCpf.gridx = 0;
		gbc_txtfCpf.gridy = 4;
		contentPane.add(txtfCpf, gbc_txtfCpf);
		txtfCpf.setColumns(10);
		
		txtfCnpj = new JTextField();
		GridBagConstraints gbc_txtfCnpj = new GridBagConstraints();
		gbc_txtfCnpj.anchor = GridBagConstraints.NORTH;
		gbc_txtfCnpj.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfCnpj.insets = new Insets(0, 0, 5, 5);
		gbc_txtfCnpj.gridwidth = 2;
		gbc_txtfCnpj.gridx = 1;
		gbc_txtfCnpj.gridy = 4;
		contentPane.add(txtfCnpj, gbc_txtfCnpj);
		txtfCnpj.setColumns(10);
		
		txtfTelefone = new JTextField();
		GridBagConstraints gbc_txtfTelefone = new GridBagConstraints();
		gbc_txtfTelefone.anchor = GridBagConstraints.NORTH;
		gbc_txtfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtfTelefone.gridwidth = 2;
		gbc_txtfTelefone.gridx = 4;
		gbc_txtfTelefone.gridy = 4;
		contentPane.add(txtfTelefone, gbc_txtfTelefone);
		txtfTelefone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtfEmail = new JTextField();
		GridBagConstraints gbc_txtfEmail = new GridBagConstraints();
		gbc_txtfEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtfEmail.gridwidth = 2;
		gbc_txtfEmail.gridx = 0;
		gbc_txtfEmail.gridy = 6;
		contentPane.add(txtfEmail, gbc_txtfEmail);
		txtfEmail.setColumns(10);
		
		JRadioButton bttPessoaFisica = new JRadioButton("Pessoa Física");
		GridBagConstraints gbc_bttPessoaFisica = new GridBagConstraints();
		gbc_bttPessoaFisica.anchor = GridBagConstraints.NORTH;
		gbc_bttPessoaFisica.fill = GridBagConstraints.HORIZONTAL;
		gbc_bttPessoaFisica.insets = new Insets(0, 0, 5, 5);
		gbc_bttPessoaFisica.gridwidth = 3;
		gbc_bttPessoaFisica.gridx = 2;
		gbc_bttPessoaFisica.gridy = 6;
		contentPane.add(bttPessoaFisica, gbc_bttPessoaFisica);
		bg.add(bttPessoaFisica);
		
		JRadioButton bttPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		GridBagConstraints gbc_bttPessoaJuridica = new GridBagConstraints();
		gbc_bttPessoaJuridica.anchor = GridBagConstraints.NORTH;
		gbc_bttPessoaJuridica.fill = GridBagConstraints.HORIZONTAL;
		gbc_bttPessoaJuridica.insets = new Insets(0, 0, 5, 0);
		gbc_bttPessoaJuridica.gridx = 5;
		gbc_bttPessoaJuridica.gridy = 6;
		contentPane.add(bttPessoaJuridica, gbc_bttPessoaJuridica);
		
		bg.add(bttPessoaJuridica);
		
		JLabel lblNewLabel_7 = new JLabel("Dados Reserva");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nº Reserva");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nº Apt");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 8;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo Apt");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridwidth = 3;
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 8;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtfNumeroReserva = new JTextField();
		GridBagConstraints gbc_txtfNumeroReserva = new GridBagConstraints();
		gbc_txtfNumeroReserva.anchor = GridBagConstraints.NORTH;
		gbc_txtfNumeroReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfNumeroReserva.insets = new Insets(0, 0, 5, 5);
		gbc_txtfNumeroReserva.gridx = 0;
		gbc_txtfNumeroReserva.gridy = 9;
		contentPane.add(txtfNumeroReserva, gbc_txtfNumeroReserva);
		txtfNumeroReserva.setColumns(10);
		
		txtfNumeroApt = new JTextField();
		GridBagConstraints gbc_txtfNumeroApt = new GridBagConstraints();
		gbc_txtfNumeroApt.anchor = GridBagConstraints.NORTH;
		gbc_txtfNumeroApt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfNumeroApt.insets = new Insets(0, 0, 5, 5);
		gbc_txtfNumeroApt.gridx = 1;
		gbc_txtfNumeroApt.gridy = 9;
		contentPane.add(txtfNumeroApt, gbc_txtfNumeroApt);
		txtfNumeroApt.setColumns(10);
		
		txtfTipoApt = new JTextField();
		GridBagConstraints gbc_txtfTipoApt = new GridBagConstraints();
		gbc_txtfTipoApt.anchor = GridBagConstraints.NORTH;
		gbc_txtfTipoApt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfTipoApt.insets = new Insets(0, 0, 5, 0);
		gbc_txtfTipoApt.gridwidth = 4;
		gbc_txtfTipoApt.gridx = 2;
		gbc_txtfTipoApt.gridy = 9;
		contentPane.add(txtfTipoApt, gbc_txtfTipoApt);
		txtfTipoApt.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Nº Diárias");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 10;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Valor Diárias");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 10;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Qtd Adulto");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridwidth = 3;
		gbc_lblNewLabel_13.gridx = 2;
		gbc_lblNewLabel_13.gridy = 10;
		contentPane.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Qtd Criança");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 5;
		gbc_lblNewLabel_14.gridy = 10;
		contentPane.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		txtfNumeroDiarias = new JTextField();
		GridBagConstraints gbc_txtfNumeroDiarias = new GridBagConstraints();
		gbc_txtfNumeroDiarias.anchor = GridBagConstraints.NORTH;
		gbc_txtfNumeroDiarias.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfNumeroDiarias.insets = new Insets(0, 0, 5, 5);
		gbc_txtfNumeroDiarias.gridx = 0;
		gbc_txtfNumeroDiarias.gridy = 11;
		contentPane.add(txtfNumeroDiarias, gbc_txtfNumeroDiarias);
		txtfNumeroDiarias.setColumns(10);
		
		txtfValorDiarias = new JTextField();
		GridBagConstraints gbc_txtfValorDiarias = new GridBagConstraints();
		gbc_txtfValorDiarias.anchor = GridBagConstraints.NORTH;
		gbc_txtfValorDiarias.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfValorDiarias.insets = new Insets(0, 0, 5, 5);
		gbc_txtfValorDiarias.gridx = 1;
		gbc_txtfValorDiarias.gridy = 11;
		contentPane.add(txtfValorDiarias, gbc_txtfValorDiarias);
		txtfValorDiarias.setColumns(10);
		
		txtfQtdAdulto = new JTextField();
		GridBagConstraints gbc_txtfQtdAdulto = new GridBagConstraints();
		gbc_txtfQtdAdulto.anchor = GridBagConstraints.NORTH;
		gbc_txtfQtdAdulto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfQtdAdulto.insets = new Insets(0, 0, 5, 5);
		gbc_txtfQtdAdulto.gridwidth = 3;
		gbc_txtfQtdAdulto.gridx = 2;
		gbc_txtfQtdAdulto.gridy = 11;
		contentPane.add(txtfQtdAdulto, gbc_txtfQtdAdulto);
		txtfQtdAdulto.setColumns(10);
		
		txtfQtdCrianca = new JTextField();
		GridBagConstraints gbc_txtfQtdCrianca = new GridBagConstraints();
		gbc_txtfQtdCrianca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfQtdCrianca.anchor = GridBagConstraints.NORTH;
		gbc_txtfQtdCrianca.insets = new Insets(0, 0, 5, 0);
		gbc_txtfQtdCrianca.gridx = 5;
		gbc_txtfQtdCrianca.gridy = 11;
		contentPane.add(txtfQtdCrianca, gbc_txtfQtdCrianca);
		txtfQtdCrianca.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Data Reserva");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 12;
		contentPane.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Hora Entrada");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 12;
		contentPane.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Hora Saída");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridwidth = 3;
		gbc_lblNewLabel_17.gridx = 2;
		gbc_lblNewLabel_17.gridy = 12;
		contentPane.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		txtfDataReserva = new JTextField();
		GridBagConstraints gbc_txtfDataReserva = new GridBagConstraints();
		gbc_txtfDataReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfDataReserva.insets = new Insets(0, 0, 5, 5);
		gbc_txtfDataReserva.gridx = 0;
		gbc_txtfDataReserva.gridy = 13;
		contentPane.add(txtfDataReserva, gbc_txtfDataReserva);
		txtfDataReserva.setColumns(10);
		
		txtfHoraEntrada = new JTextField();
		GridBagConstraints gbc_txtfHoraEntrada = new GridBagConstraints();
		gbc_txtfHoraEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfHoraEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_txtfHoraEntrada.gridx = 1;
		gbc_txtfHoraEntrada.gridy = 13;
		contentPane.add(txtfHoraEntrada, gbc_txtfHoraEntrada);
		txtfHoraEntrada.setColumns(10);
		
		txtfHoraSaida = new JTextField();
		GridBagConstraints gbc_txtfHoraSaida = new GridBagConstraints();
		gbc_txtfHoraSaida.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfHoraSaida.insets = new Insets(0, 0, 5, 5);
		gbc_txtfHoraSaida.gridwidth = 3;
		gbc_txtfHoraSaida.gridx = 2;
		gbc_txtfHoraSaida.gridy = 13;
		contentPane.add(txtfHoraSaida, gbc_txtfHoraSaida);
		txtfHoraSaida.setColumns(10);
		
		JButton bntFinalizarCadastro = new JButton("Finalizar");
		bntFinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtfNome.getText());
				cliente.setSobrenome(txtfSobrenome.getText());
				cliente.setCpf(txtfCpf.getText());
				cliente.setCnpj(txtfCnpj.getText());
				cliente.setEmail(txtfEmail.getText());
				cliente.setTelefone(txtfTelefone.getText());
			
				
if (txtfNome.getText().isEmpty()||txtfSobrenome.getText().isEmpty()||txtfCpf.getText().isEmpty()||txtfCnpj.getText().isEmpty()||txtfEmail.getText().isEmpty()||txtfTelefone.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Erro! Por favor preencha os campos em branco");
		}
				
else if (armazenarCadastro.salvar(cliente)) {
					JOptionPane.showMessageDialog(null,"Hóspede cadastrado com sucesso!");
					txtfNome.setText("");
					txtfSobrenome.setText("");
					txtfCnpj.setText("");
					txtfCpf.setText("");
					txtfEmail.setText("");
					txtfTelefone.setText("");
					txtfNome.setText("");
					
					txtfNome.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null,"Erro! Cadastro não realizado.");
				}
			}
		});
		bntFinalizarCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_bntFinalizarCadastro = new GridBagConstraints();
		gbc_bntFinalizarCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_bntFinalizarCadastro.anchor = GridBagConstraints.NORTH;
		gbc_bntFinalizarCadastro.gridx = 5;
		gbc_bntFinalizarCadastro.gridy = 13;
		contentPane.add(bntFinalizarCadastro, gbc_bntFinalizarCadastro);
		
		JLabel lblNewLabel_18 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 14;
		contentPane.add(lblNewLabel_18, gbc_lblNewLabel_18);
	}
	
}
