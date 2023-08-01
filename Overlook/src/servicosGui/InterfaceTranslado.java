package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import bdConexao.Validador;
import interfaces.TelaInicial;
import servicosBD.BDException;
import servicosBD.MySQLConector;
import servicosCore.ControladorDeAcessos;
import servicosCore.HistoricoTranslado;
import servicosCore.CoreException;
import servicosCore.Translado;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class InterfaceTranslado extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnderecoColeta;
	private JTextField txtEnderecoDestino;
	private JTextField txtQuantidadePassageiros;
	private LocalTime horaFormatada;
	private LocalDate dataFormatada;
	private int numeroPassageiros;
	private JTextField txtIdReserva;
	private JTable table;
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
	
	DefaultTableModel model = new DefaultTableModel() {
	    
	    public boolean isCellEditable(int row, int column) {
	       
	        return false;
	    }
	};

	private TableModel modeloTabelaTranslado() {
	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "idViagem",
	            "Endereço Coleta", "Endereço Destino", "Passageiros", "Data", "Hora", "id Reserva" }) {
	        Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
	                Object.class, Object.class };	       
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };

	    tableModel.setNumRows(0);

	    try {
	        MySQLConector leitor = new MySQLConector();

	        for (HistoricoTranslado p : leitor.leituraTabela()) {
	            tableModel.addRow(new Object[] { p.getIdViagem(), p.getEnderecoColeta(), p.getEnderecoDestino(),
	                    p.getNumeroPassageiros(), p.getData(), p.getHora(), p.getIdReserva() });
	        }

	    } catch (Exception exception) {
	        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a tabela");
	    }

	    return tableModel;
	}



	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceTranslado frame = new InterfaceTranslado();
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
	public InterfaceTranslado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceTranslado.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 504);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Id Reserva");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(38, 9, 55));
		lblNewLabel_9.setBounds(33, 202, 206, 14);
		contentPane.add(lblNewLabel_9);
		
				JLabel lblNewLabel_8 = new JLabel("Histórico de viagens");
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_8.setForeground(new Color(38, 9, 55));
				lblNewLabel_8.setBounds(1088, 115, 151, 14);
				contentPane.add(lblNewLabel_8);
		
		txtIdReserva = new JTextField();
		txtIdReserva.setBounds(33, 218, 297, 23);
		txtIdReserva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		contentPane.add(txtIdReserva);
		txtIdReserva.setColumns(10);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(1, 26, 872, 0);
		txtIdReserva.setDocument(new Validador(50));
		JButton btnRemoverHistorico = new JButton("Remover");
		btnRemoverHistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoverHistorico.setForeground(new Color(38, 9, 55));
		btnRemoverHistorico.setBounds(769, 686, 157, 23);
		btnRemoverHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				if (!table.isSelectionEmpty()) {
//					String elementoSelecionado = (String) table.getSelectedValue();
//					historicoTranslado.removeElement(elementoSelecionado);
//					table.revalidate();
//					table.repaint();
//				}
				btnRemoverHistorico.setEnabled(false);

			}
		});

		table.setModel(modeloTabelaTranslado());
		contentPane.add(table);

		JFormattedTextField ftxtfData = new JFormattedTextField(setMascara("##/##/####"));
		ftxtfData.setBounds(33, 551, 126, 23);
		contentPane.add(ftxtfData);

		JFormattedTextField ftxtHora = new JFormattedTextField(setMascara("##:##"));
		ftxtHora.setBounds(173, 551, 157, 23);
		contentPane.add(ftxtHora);

		JButton btnAdicionarhistorico = new JButton("Adicionar");
		btnAdicionarhistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionarhistorico.setForeground(new Color(38, 9, 55));
		btnAdicionarhistorico.setBounds(100, 621, 151, 23);
		btnAdicionarhistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				String QuantidadeDePassageiros = txtQuantidadePassageiros.getText();
				if (QuantidadeDePassageiros.equals("")) {
					QuantidadeDePassageiros = "0";
				}
				
				String idReserva = txtIdReserva.getText();
				if (idReserva.equals("")) {
					idReserva = "0";
				}
				
				int numeroidReserva = Integer.parseInt(idReserva);
				int numeroPassageiros = Integer.parseInt(QuantidadeDePassageiros);

				try {
					DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate data = LocalDate.parse(ftxtfData.getText(), formatterDate);

					DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
					LocalTime hora = LocalTime.parse(ftxtHora.getText(), formatterTime);

					dataFormatada = data;
					horaFormatada = hora;

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null,"Data digitada é inválida");	
				}

				try {

				ControladorDeAcessos historicotranslado = new ControladorDeAcessos();
					historicotranslado.RegistroHistoricoDeViagem(numeroidReserva ,txtEnderecoColeta.getText(),
							txtEnderecoDestino.getText(), numeroPassageiros, dataFormatada, horaFormatada);
	
				ControladorDeAcessos registroServico = new ControladorDeAcessos();
					 registroServico.registroServicoTranslado(numeroidReserva, numeroPassageiros);
					 
					 JOptionPane.showMessageDialog(null,"Registro efetuado com sucesso");
					 
						ftxtfData.setText("");
						txtEnderecoColeta.setText("");
						txtEnderecoDestino.setText("");
						ftxtHora.setText("");
						txtQuantidadePassageiros.setText("");
						txtIdReserva.setText("");
						table.setModel(modeloTabelaTranslado());
						
				} catch (CoreException exception) {

					JOptionPane.showMessageDialog(null,"Erro: " + exception.getMessage());
				}


			}
		});

		JLabel lblNewLabel_1 = new JLabel("Translado");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(33, 62, 165, 42);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Serviço de transporte");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setBounds(31, 101, 197, 27);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Endereço coleta");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setBounds(33, 287, 205, 14);
		contentPane.add(lblNewLabel_3);

		txtEnderecoColeta = new JTextField();
		txtEnderecoColeta.setBounds(33, 302, 297, 23);
		txtEnderecoColeta.setColumns(10);
		contentPane.add(txtEnderecoColeta);
		txtEnderecoColeta.setDocument(new Validador(200));

		JLabel lblNewLabel_4 = new JLabel("Endereço Destino");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(33, 366, 208, 14);
		contentPane.add(lblNewLabel_4);

		
		txtEnderecoDestino = new JTextField();
		txtEnderecoDestino.setBounds(33, 381, 297, 23);
		txtEnderecoDestino.setColumns(10);
		contentPane.add(txtEnderecoDestino);
		txtEnderecoDestino.setDocument(new Validador(200));

		JLabel lblNewLabel_5 = new JLabel("Quantidade de Passageiros");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(33, 454, 207, 14);
		contentPane.add(lblNewLabel_5);

		txtQuantidadePassageiros = new JTextField();
		txtQuantidadePassageiros.setBounds(33, 469, 297, 23);
		txtQuantidadePassageiros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtQuantidadePassageiros.setColumns(10);
		contentPane.add(txtQuantidadePassageiros);
		txtQuantidadePassageiros.setDocument(new Validador(2));
		
		JLabel lblNewLabel_6 = new JLabel("Data");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setBounds(33, 535, 90, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Hora");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(new Color(38, 9, 55));
		lblNewLabel_7.setBounds(175, 535, 70, 14);
		contentPane.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(365, 139, 874, 537);
		contentPane.add(scrollPane);
		contentPane.add(btnAdicionarhistorico);

		btnRemoverHistorico.setEnabled(false);
		contentPane.add(btnRemoverHistorico);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				InterfaceServicos interfaceServicos = new InterfaceServicos();
				interfaceServicos.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(InterfaceTranslado.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
		btnNewButton.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceTranslado.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		contentPane.add(btnFecharTela);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(InterfaceTranslado.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnNewButton_1.setBounds(1213, 0, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfaceTranslado.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(100, 0, 758, 758);
		contentPane.add(lblLogoTransparente);

		
			
		
	}
}