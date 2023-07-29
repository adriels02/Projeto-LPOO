package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import servicosCore.Arrumacao;
import servicosCore.ControladorDeAcessos;
import servicosCore.Restaurante;
import servicosCore.RestaurantePedidos;
import servicosCore.CoreException;

import javax.swing.event.ListSelectionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.TelaInicial;
import servicosBD.BDException;
import servicosBD.MySQLConector;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class InterfaceRestaurante extends JFrame {


	private JPanel contentPane;
	private ButtonGroup grupoBotoesRefeicao = new ButtonGroup();
	private JTextField txtObservacoes;
	private JTextField txtIdReserva;
	private JTable table;
	private JTextField txtQuantidadeRefeicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceRestaurante frame = new InterfaceRestaurante();
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
	public InterfaceRestaurante() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceRestaurante.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 407);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
								contentPane.setLayout(null);
				
						JLabel lblTituloRestaurante = new JLabel("Restaurante");
						lblTituloRestaurante.setForeground(new Color(38, 9, 55));
						lblTituloRestaurante.setBounds(68, 98, 251, 42);
						lblTituloRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 30));
						contentPane.add(lblTituloRestaurante);
				
				JLabel lblError = new JLabel("");
				lblError.setBounds(0, 0, 0, 0);
				lblError.setForeground(new Color(255, 0, 0));
				contentPane.add(lblError);
						
								JLabel lblNewLabel_3 = new JLabel("Histórico de Pedidos");
								lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
								lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
								lblNewLabel_3.setForeground(new Color(38, 9, 55));
								lblNewLabel_3.setBounds(1047, 104, 184, 14);
								contentPane.add(lblNewLabel_3);
				
						JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
						rdbtnCafeDaManha.setBackground(new Color(255, 255, 255));
						rdbtnCafeDaManha.setFont(new Font("Tahoma", Font.BOLD, 11));
						rdbtnCafeDaManha.setForeground(new Color(38, 9, 55));
						rdbtnCafeDaManha.setBounds(68, 313, 115, 23);
						grupoBotoesRefeicao.add(rdbtnCafeDaManha);
						contentPane.add(rdbtnCafeDaManha);
						
						JButton btnRemoverHistorico = new JButton("Remover");
						btnRemoverHistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
						btnRemoverHistorico.setForeground(new Color(38, 9, 55));
						btnRemoverHistorico.setBounds(1140, 651, 91, 23);
						btnRemoverHistorico.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
				
						JLabel lblNewLabel_2 = new JLabel("Observação");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_2.setForeground(new Color(38, 9, 55));
						lblNewLabel_2.setBounds(233, 426, 136, 14);
						contentPane.add(lblNewLabel_2);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(513, 128, 718, 511);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID pedido", "ID Reserva", "Refei\u00E7\u00E3o", "Quantidade", "Data", "Hora", "Observa\u00E7\u00E3o"
					}
				));
				scrollPane.setViewportView(table);
		
				JRadioButton rdbtnAlmoco = new JRadioButton("Almoço");
				rdbtnAlmoco.setBackground(new Color(255, 255, 255));
				rdbtnAlmoco.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnAlmoco.setForeground(new Color(38, 9, 55));
				rdbtnAlmoco.setBounds(68, 360, 106, 23);
				grupoBotoesRefeicao.add(rdbtnAlmoco);
				contentPane.add(rdbtnAlmoco);
								
										txtObservacoes = new JTextField();
										txtObservacoes.setBounds(233, 451, 251, 23);
										contentPane.add(txtObservacoes);
										txtObservacoes.setColumns(10);
						
								JRadioButton rdbtnJantar = new JRadioButton("Jantar");
								rdbtnJantar.setBackground(new Color(255, 255, 255));
								rdbtnJantar.setFont(new Font("Tahoma", Font.BOLD, 11));
								rdbtnJantar.setForeground(new Color(38, 9, 55));
								rdbtnJantar.setBounds(68, 412, 106, 23);
								grupoBotoesRefeicao.add(rdbtnJantar);
								contentPane.add(rdbtnJantar);
				
						JLabel lblNewLabel_4 = new JLabel("ID Reserva");
						lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_4.setForeground(new Color(38, 9, 55));
						lblNewLabel_4.setBounds(233, 252, 136, 14);
						contentPane.add(lblNewLabel_4);
		
				txtIdReserva = new JTextField();
				txtIdReserva.setBounds(233, 277, 251, 23);
				txtIdReserva.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				
				JLabel lblNewLabel_5 = new JLabel("Quantidade de Refeições");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_5.setForeground(new Color(38, 9, 55));
				lblNewLabel_5.setBounds(233, 335, 155, 14);
				contentPane.add(lblNewLabel_5);
				contentPane.add(txtIdReserva);
				txtIdReserva.setColumns(10);
		
				JButton btnAdicionar = new JButton("Adicionar");
				btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnAdicionar.setForeground(new Color(38, 9, 55));
				btnAdicionar.setBounds(384, 545, 100, 23);
				btnAdicionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						lblError.setText("");
						String refeicao = null;

						if (rdbtnAlmoco.isSelected()) {

							refeicao = "Almoço";
						}

						else if (rdbtnJantar.isSelected()) {

							refeicao = "Jantar";
						}

						else if (rdbtnCafeDaManha.isSelected()) {

							refeicao = "Café da manhã";
						}

						else {

							refeicao = "";
						}
	
						String idString = txtIdReserva.getText();
						
						if (idString.equals("")) {
							idString = "0";
						}

						
						int id = Integer.parseInt(idString);

						String quantidadeString = txtQuantidadeRefeicao.getText();
						
						if (quantidadeString.equals("")) {
							quantidadeString = "0";
						}
				
						int quantidade = Integer.parseInt(quantidadeString);
												
						LocalTime time = LocalTime.now();
						LocalDate data = LocalDate.now();
						
						
						try {

							ControladorDeAcessos controlador = new ControladorDeAcessos();
							controlador.registroRestaurante(id, refeicao, quantidade, data, time,
									txtObservacoes.getText());

							
							
							
							
						} catch (CoreException mensagem) {

							lblError.setText(mensagem.getMessage());

						}

						txtQuantidadeRefeicao.setText("");
						txtObservacoes.setText("");
						grupoBotoesRefeicao.clearSelection();
						txtIdReserva.setText("");

					}
				});
				
				txtQuantidadeRefeicao = new JTextField();
				txtQuantidadeRefeicao.setBounds(233, 360, 251, 23);
				txtQuantidadeRefeicao.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres = "0987654321";
						if (!caracteres.contains(e.getKeyChar() + "")) {
							e.consume();
						}
					}
				});
				contentPane.add(txtQuantidadeRefeicao);
				txtQuantidadeRefeicao.setColumns(10);
				contentPane.add(btnAdicionar);
			
				
				DefaultTableModel tableModel = new DefaultTableModel(
					    new Object[][] {},
					    new String[] {
						"ID pedido", "ID Reserva", "Refei\u00E7\u00E3o", "Quantidade", "Data", "Hora", "Observa\u00E7\u00E3o"
					    }
					);
					
				try {
				    MySQLConector leitor = new MySQLConector();

				    for (RestaurantePedidos p : leitor.leituraPedidos()) {
				        tableModel.addRow(new Object[] {
				            p.getIdpedido(), p.getIdReserva(), p.getRefeicao(), p.getQuantidade(), p.getData(), p.getTime(), p.getObservacao()
			        });
				    }
				} catch (BDException exception) {
					lblError.setText(exception.getMessage());			
					}
				
				table.setModel(tableModel);
				
			
				JButton btnNewButton = new JButton("Atualizar");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton.setForeground(new Color(38, 9, 55));
				btnNewButton.setBounds(1019, 651, 100, 23);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						lblError.setText("Tabela atualizada");
						
						
						tableModel.setNumRows(0);
						
						DefaultTableModel tableModel = new DefaultTableModel(
							    new Object[][] {},
							    new String[] {
								"ID pedido", "ID Reserva", "Refei\u00E7\u00E3o", "Quantidade", "Data", "Hora", "Observa\u00E7\u00E3o"
							    }
							);
							
						try {
						    MySQLConector leitor = new MySQLConector();

						    for (RestaurantePedidos p : leitor.leituraPedidos()) {
						        tableModel.addRow(new Object[] {
						            p.getIdpedido(), p.getIdReserva(), p.getRefeicao(), p.getQuantidade(), p.getData(), p.getTime(), p.getObservacao()
					        });
						    }
						} catch (BDException exception) {
							lblError.setText(exception.getMessage());			
							}
						
						table.setModel(tableModel);
					}
				});
				contentPane.add(btnNewButton);
		
				
				btnRemoverHistorico.setEnabled(false);
				contentPane.add(btnRemoverHistorico);
				
				JButton btnServicos = new JButton("");
				btnServicos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						InterfaceServicos interfaceServicos = new InterfaceServicos();
						interfaceServicos.setVisible(true);
						dispose();	
			
					}
				});
				btnServicos.setIcon(new ImageIcon(InterfaceRestaurante.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
				btnServicos.setBounds(0, 0, 65, 23);
				contentPane.add(btnServicos);
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				btnNewButton_1.setIcon(new ImageIcon(InterfaceRestaurante.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
				btnNewButton_1.setBounds(1250, 0, 30, 30);
				contentPane.add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						TelaInicial objTelaInicial = new TelaInicial();
						objTelaInicial.setVisible(true);
						dispose();
					}
				});
				btnNewButton_2.setIcon(new ImageIcon(InterfaceRestaurante.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
				btnNewButton_2.setBounds(1213, 0, 30, 30);
				contentPane.add(btnNewButton_2);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(InterfaceRestaurante.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
				lblNewLabel.setBounds(200, 0, 758, 758);
				contentPane.add(lblNewLabel);
				
				JLabel lblLogoPequena = new JLabel("");
				lblLogoPequena.setIcon(new ImageIcon(InterfaceRestaurante.class.getResource("/interfaces/imagens/logo 220 x150.png")));
				lblLogoPequena.setBounds(63, 554, 220, 150);
				contentPane.add(lblLogoPequena);
	}
}