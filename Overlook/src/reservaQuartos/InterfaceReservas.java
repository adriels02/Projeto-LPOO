package reservaQuartos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import interfaces.MenuPrincipal;
import servicosBD.BDException;
import servicosBD.MySQLConector;
import servicosCore.ControladorDeAcessos;
import servicosCore.CoreException;
import servicosCore.RestaurantePedidos;

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
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;

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
		frmCadastroDasReservas.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceReservas.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDasReservas.setBounds(100, 100, 807, 474);
		frmCadastroDasReservas.setLocationRelativeTo(null);
		frmCadastroDasReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{63, 118, 130, 35, 34, 7, 97, 89, 63, 0};
		gridBagLayout.rowHeights = new int[]{0, 17, 23, 20, 38, 20, 14, 20, 48, 14, 20, 48, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCadastroDasReservas.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				frmCadastroDasReservas.dispose();
				
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		frmCadastroDasReservas.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel(" Número do Quarto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 1.0;
		gbc_lblNewLabel_4.weightx = 1.0;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 1.0;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 2;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		ftxtNumero = new JTextField();
		ftxtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
				
			}
		});
		GridBagConstraints gbc_ftxtNumero = new GridBagConstraints();
		gbc_ftxtNumero.weighty = 1.0;
		gbc_ftxtNumero.weightx = 1.0;
		gbc_ftxtNumero.anchor = GridBagConstraints.NORTH;
		gbc_ftxtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtNumero.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtNumero.gridx = 1;
		gbc_ftxtNumero.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(ftxtNumero, gbc_ftxtNumero);
		ftxtNumero.setColumns(10);
		
		JFormattedTextField ftxtCpf = new JFormattedTextField(setMascara("###########"));
		GridBagConstraints gbc_ftxtCpf = new GridBagConstraints();
		gbc_ftxtCpf.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtCpf.gridx = 6;
		gbc_ftxtCpf.gridy = 3;
		frmCadastroDasReservas.getContentPane().add(ftxtCpf, gbc_ftxtCpf);
		
		JLabel lblNewLabel_8 = new JLabel(" Data de Entrada:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.weighty = 1.0;
		gbc_lblNewLabel_8.weightx = 1.0;
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Data de Saída:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.weighty = 1.0;
		gbc_lblNewLabel_9.weightx = 1.0;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel("Observação:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 4;
		frmCadastroDasReservas.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JFormattedTextField ftxtEntrada = new JFormattedTextField(setMascara("##-##-####"));
		GridBagConstraints gbc_ftxtEntrada = new GridBagConstraints();
		gbc_ftxtEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtEntrada.gridx = 1;
		gbc_ftxtEntrada.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(ftxtEntrada, gbc_ftxtEntrada);
		
		JFormattedTextField ftxtSaida = new JFormattedTextField(setMascara("##-##-####"));
		GridBagConstraints gbc_ftxtSaida = new GridBagConstraints();
		gbc_ftxtSaida.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtSaida.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtSaida.gridx = 2;
		gbc_ftxtSaida.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(ftxtSaida, gbc_ftxtSaida);
		
		txtObservacoes = new JTextField();
		GridBagConstraints gbc_txtObservacoes = new GridBagConstraints();
		gbc_txtObservacoes.gridwidth = 2;
		gbc_txtObservacoes.anchor = GridBagConstraints.SOUTH;
		gbc_txtObservacoes.insets = new Insets(0, 0, 5, 5);
		gbc_txtObservacoes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtObservacoes.gridx = 6;
		gbc_txtObservacoes.gridy = 5;
		frmCadastroDasReservas.getContentPane().add(txtObservacoes, gbc_txtObservacoes);
		txtObservacoes.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		frmCadastroDasReservas.getContentPane().add(scrollPane, gbc_scrollPane);
		
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
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Realizar ");
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
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);		
		
		JButton btnNewButton_1 = new JButton("Consultar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 11;
		frmCadastroDasReservas.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

		
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
}

