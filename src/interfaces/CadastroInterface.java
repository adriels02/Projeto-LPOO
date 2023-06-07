package interfaces;

import cadastroCliente.Cliente;
import java.awt.BorderLayout;

import reservaQuartos.Reserva;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import cadastroCliente.ArmazenarCadastroCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtfNome;
	private JTextField txtfSobrenome;
	private JTextField txtfRg;
	private JTextField txtfCpf;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados Cliente");
		lblNewLabel.setBounds(10, 11, 121, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 36, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sobrenome");
		lblNewLabel_2.setBounds(152, 36, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		txtfNome = new JTextField();
		txtfNome.setBounds(10, 53, 121, 20);
		contentPane.add(txtfNome);
		txtfNome.setColumns(10);
		
		txtfSobrenome = new JTextField();
		txtfSobrenome.setBounds(152, 53, 312, 20);
		contentPane.add(txtfSobrenome);
		txtfSobrenome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("RG");
		lblNewLabel_3.setBounds(10, 84, 43, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setBounds(152, 84, 32, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setBounds(293, 84, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		txtfRg = new JTextField();
		txtfRg.setBounds(10, 109, 121, 20);
		contentPane.add(txtfRg);
		txtfRg.setColumns(10);
		
		txtfCpf = new JTextField();
		txtfCpf.setBounds(152, 109, 121, 20);
		contentPane.add(txtfCpf);
		txtfCpf.setColumns(10);
		
		txtfTelefone = new JTextField();
		txtfTelefone.setBounds(293, 109, 171, 20);
		contentPane.add(txtfTelefone);
		txtfTelefone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setBounds(10, 140, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		txtfEmail = new JTextField();
		txtfEmail.setBounds(10, 160, 235, 20);
		contentPane.add(txtfEmail);
		txtfEmail.setColumns(10);
		
		JRadioButton bttPessoaFisica = new JRadioButton("Pessoa Física");
		bttPessoaFisica.setBounds(251, 159, 110, 23);
		contentPane.add(bttPessoaFisica);
		
		JRadioButton bttPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		bttPessoaJuridica.setBounds(368, 159, 128, 23);
		contentPane.add(bttPessoaJuridica);
		
		bg.add(bttPessoaJuridica);
		bg.add(bttPessoaFisica);
		
		JLabel lblNewLabel_7 = new JLabel("Dados Reserva");
		lblNewLabel_7.setBounds(10, 193, 121, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nº Reserva");
		lblNewLabel_8.setBounds(10, 218, 121, 14);
		contentPane.add(lblNewLabel_8);
		
		txtfNumeroReserva = new JTextField();
		txtfNumeroReserva.setBounds(10, 237, 121, 20);
		contentPane.add(txtfNumeroReserva);
		txtfNumeroReserva.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Nº Apt");
		lblNewLabel_9.setBounds(152, 218, 59, 14);
		contentPane.add(lblNewLabel_9);
		
		txtfNumeroApt = new JTextField();
		txtfNumeroApt.setBounds(152, 237, 93, 20);
		contentPane.add(txtfNumeroApt);
		txtfNumeroApt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo Apt");
		lblNewLabel_10.setBounds(262, 218, 99, 14);
		contentPane.add(lblNewLabel_10);
		
		txtfTipoApt = new JTextField();
		txtfTipoApt.setBounds(262, 237, 202, 20);
		contentPane.add(txtfTipoApt);
		txtfTipoApt.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Nº Diárias");
		lblNewLabel_11.setBounds(10, 268, 121, 14);
		contentPane.add(lblNewLabel_11);
		
		txtfNumeroDiarias = new JTextField();
		txtfNumeroDiarias.setBounds(10, 285, 121, 20);
		contentPane.add(txtfNumeroDiarias);
		txtfNumeroDiarias.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Valor Diárias");
		lblNewLabel_12.setBounds(152, 268, 93, 14);
		contentPane.add(lblNewLabel_12);
		
		txtfValorDiarias = new JTextField();
		txtfValorDiarias.setBounds(152, 285, 93, 20);
		contentPane.add(txtfValorDiarias);
		txtfValorDiarias.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Qtd Adulto");
		lblNewLabel_13.setBounds(262, 268, 99, 14);
		contentPane.add(lblNewLabel_13);
		
		txtfQtdAdulto = new JTextField();
		txtfQtdAdulto.setBounds(262, 285, 99, 20);
		contentPane.add(txtfQtdAdulto);
		txtfQtdAdulto.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Qtd Criança");
		lblNewLabel_14.setBounds(365, 268, 84, 14);
		contentPane.add(lblNewLabel_14);
		
		txtfQtdCrianca = new JTextField();
		txtfQtdCrianca.setBounds(365, 285, 99, 20);
		contentPane.add(txtfQtdCrianca);
		txtfQtdCrianca.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Data Reserva");
		lblNewLabel_15.setBounds(10, 316, 66, 14);
		contentPane.add(lblNewLabel_15);
		
		txtfDataReserva = new JTextField();
		txtfDataReserva.setBounds(10, 336, 121, 20);
		contentPane.add(txtfDataReserva);
		txtfDataReserva.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Hora Entrada");
		lblNewLabel_16.setBounds(152, 316, 93, 14);
		contentPane.add(lblNewLabel_16);
		
		txtfHoraEntrada = new JTextField();
		txtfHoraEntrada.setBounds(152, 336, 93, 20);
		contentPane.add(txtfHoraEntrada);
		txtfHoraEntrada.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Hora Saída");
		lblNewLabel_17.setBounds(262, 316, 99, 14);
		contentPane.add(lblNewLabel_17);
		
		txtfHoraSaida = new JTextField();
		txtfHoraSaida.setBounds(262, 336, 99, 20);
		contentPane.add(txtfHoraSaida);
		txtfHoraSaida.setColumns(10);
		
		JButton bttFinalizar = new JButton("Finalizar");
		bttFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtfNome.getText());
				cliente.setSobrenome(txtfSobrenome.getText());
				cliente.setCpf(txtfCpf.getText());
				cliente.setRg(txtfRg.getText());
				cliente.setEmail(txtfEmail.getText());
				cliente.setTelefone(txtfTelefone.getText());
			
				
				
				if (armazenarCadastro.salvar(cliente)) {
					JOptionPane.showMessageDialog(null,"Hóspede cadastrado com sucesso!");
					txtfNome.setText("");
					txtfSobrenome.setText("");
					txtfCpf.setText("");
					txtfRg.setText("");
					txtfEmail.setText("");
					txtfTelefone.setText("");
					txtfNome.setText("");
					
					txtfNome.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null,"Erro! Cadastro não realizado.");
				}
			}
		});
		bttFinalizar.setBounds(371, 335, 99, 23);
		bttFinalizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(bttFinalizar);
	}
	
}
