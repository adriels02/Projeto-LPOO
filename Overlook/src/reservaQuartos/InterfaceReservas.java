package reservaQuartos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import interfaces.MenuPrincipal;
import interfaces.TelaInicial;
import servicosBD.BDException;
import servicosBD.MySQLConector;
import servicosCore.ControladorDeAcessos;
import servicosCore.CoreException;

public class InterfaceReservas {

	public JFrame frmCadastroDasReservas;
	private JTextField ftxtNumero;
	private JTable table;
	private JTextField txtObservacoes;

	/**
	 * Launch the application.
	 */
	
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (ParseException ex) {
		}
		return mask;
	}
	
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
		frmCadastroDasReservas.getContentPane().setBackground(new Color(255, 255, 255));
		frmCadastroDasReservas.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceReservas.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDasReservas.setBounds(100, 100, 807, 474);
		frmCadastroDasReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDasReservas.setSize(1280,720); 
		frmCadastroDasReservas.setLocationRelativeTo(null);
		frmCadastroDasReservas.setUndecorated(true);
		
		JButton btnNewButton_3 = new JButton("Menu");
		btnNewButton_3.setBackground(new Color(255, 128, 64));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(0, 2, 65, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				frmCadastroDasReservas.dispose();
				
				
				
			}
		});
		frmCadastroDasReservas.getContentPane().setLayout(null);
		frmCadastroDasReservas.getContentPane().add(btnNewButton_3);
		
		JLabel lblTituloReservas = new JLabel("Reservas");
		lblTituloReservas.setForeground(new Color(38, 9, 55));
		lblTituloReservas.setBounds(63, 30, 187, 42);
		lblTituloReservas.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmCadastroDasReservas.getContentPane().add(lblTituloReservas);
		
		JLabel lblNewLabel_4 = new JLabel(" Número do Quarto");
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(63, 88, 305, 15);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setBounds(445, 88, 24, 15);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_2);
		
		ftxtNumero = new JTextField();
		ftxtNumero.setBounds(63, 105, 320, 23);
		ftxtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
				
			}
		});
		frmCadastroDasReservas.getContentPane().add(ftxtNumero);
		ftxtNumero.setColumns(10);
		
		JFormattedTextField ftxtCpf = new JFormattedTextField(setMascara("###########"));
		ftxtCpf.setBounds(445, 105, 284, 23);
		frmCadastroDasReservas.getContentPane().add(ftxtCpf);
		
		JLabel lblNewLabel_8 = new JLabel(" Data de Entrada");
		lblNewLabel_8.setForeground(new Color(38, 9, 55));
		lblNewLabel_8.setBounds(63, 147, 97, 15);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Data de Saída");
		lblNewLabel_9.setForeground(new Color(38, 9, 55));
		lblNewLabel_9.setBounds(233, 148, 79, 15);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel("Observação");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(445, 148, 67, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_1);
		
		JFormattedTextField ftxtEntrada = new JFormattedTextField(setMascara("##-##-####"));
		ftxtEntrada.setBounds(63, 164, 150, 23);
		frmCadastroDasReservas.getContentPane().add(ftxtEntrada);
		
		JFormattedTextField ftxtSaida = new JFormattedTextField(setMascara("##-##-####"));
		ftxtSaida.setBounds(233, 164, 150, 23);
		frmCadastroDasReservas.getContentPane().add(ftxtSaida);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setBounds(445, 164, 284, 23);
		frmCadastroDasReservas.getContentPane().add(txtObservacoes);
		txtObservacoes.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 199, 1148, 436);
		frmCadastroDasReservas.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Reserva", "CPF", "Data Entrada", "Data sa\u00EDda", "Observa\u00E7\u00E3o", "N\u00FAmero Quarto"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(38, 9, 55));
		btnNewButton.setBounds(905, 650, 90, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tableModel = new DefaultTableModel(
					    new Object[][] {},
					    new String[] {
					    	"Id Reserva", "CPF", "Data Entrada", "Data sa\u00EDda", "Observa\u00E7\u00E3o", "N\u00FAmero Quarto"

					    }
					);
					
			try {
				    MySQLConector leitor = new MySQLConector();

				    for (Reserva p : leitor.leituraReservas()) {
				        tableModel.addRow(new Object[] {
				            p.getIdReserva(), p.getCPF(), p.getDataEntrada(), p.getDataSaida(), p.getObservacaoReserva(), p.getNumeroQuarto()
			        });
				    }
			} catch (BDException exception) {
					JOptionPane.showMessageDialog(null,"Erro: " + exception);	
					}
				
				table.setModel(tableModel);

			}
		});
		frmCadastroDasReservas.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Realizar ");
		btnNewButton_2.setBackground(new Color(225, 225, 225));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(38, 9, 55));
		btnNewButton_2.setBounds(1005, 650, 101, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numeroQuarto = ftxtNumero.getText();
				if (numeroQuarto.equals("")) {
					numeroQuarto = "0";					
				}
				
				try { 
					
				int inteiroQuarto = Integer.parseInt(numeroQuarto);
				
				DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate dataEntrada = LocalDate.parse(ftxtEntrada.getText(), formatterDate);

		
				LocalDate dataSaida = LocalDate.parse(ftxtSaida.getText(), formatterDate);
				
				
				ControladorDeAcessos controlador = new ControladorDeAcessos();
									 controlador.registroReserva(inteiroQuarto, ftxtCpf.getText(),dataEntrada, dataSaida, txtObservacoes.getText());
					
					
				} catch (CoreException mensagem) {
					
					JOptionPane.showMessageDialog(null,"Erro: " + mensagem);	
					
					
				}
							
				txtObservacoes.setText("");
				ftxtCpf.setText("");
				ftxtEntrada.setText("");
				ftxtSaida.setText("");
				ftxtNumero.setText("");
				
								
			}
		});
		frmCadastroDasReservas.getContentPane().add(btnNewButton_2);		
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBackground(new Color(225, 225, 225));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(38, 9, 55));
		btnNewButton_1.setBounds(1116, 650, 92, 23);
		frmCadastroDasReservas.getContentPane().add(btnNewButton_1);

		
		DefaultTableModel tableModel = new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			    	"Id Reserva", "CPF", "Data Entrada", "Data sa\u00EDda", "Observa\u00E7\u00E3o", "N\u00FAmero Quarto"

			    }
			);
			
	try {
		    MySQLConector leitor = new MySQLConector();

		    for (Reserva p : leitor.leituraReservas()) {
		        tableModel.addRow(new Object[] {
		            p.getIdReserva(), p.getCPF(), p.getDataEntrada(), p.getDataSaida(), p.getObservacaoReserva(), p.getNumeroQuarto()
	        });
		    }
	} catch (BDException exception) {
			JOptionPane.showMessageDialog(null,"Erro: " + exception);	
			}
		
		table.setModel(tableModel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfaceReservas.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblNewLabel.setBounds(70, 0, 758, 758);
		frmCadastroDasReservas.getContentPane().add(lblNewLabel);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmCadastroDasReservas.dispose();
				
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceReservas.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		frmCadastroDasReservas.getContentPane().add(btnFecharTela);
		
		JButton btnSignOut = new JButton("");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				frmCadastroDasReservas.dispose();
				
			}
		});
		btnSignOut.setIcon(new ImageIcon(InterfaceReservas.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		frmCadastroDasReservas.getContentPane().add(btnSignOut);
		
		JLabel lblLogoPequena = new JLabel("");
		lblLogoPequena.setIcon(new ImageIcon(InterfaceReservas.class.getResource("/interfaces/imagens/logo 220 x150.png")));
		lblLogoPequena.setBounds(905, 40, 220, 150);
		frmCadastroDasReservas.getContentPane().add(lblLogoPequena);

		
		
		
		
		
		
	}
}

