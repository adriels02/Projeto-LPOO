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

import servicosBD.BDException;
import servicosBD.MySQLConector;
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
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {96, 30, 40, 60, 380, 0};
		gbl_contentPane.rowHeights = new int[]{17, 30, 14, 26, 23, 23, 14, 20, 3, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
						
								JLabel lblNewLabel = new JLabel("<<< Voltar");
								lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblNewLabel.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										InterfaceServicos interfaceServiços = new InterfaceServicos();
										interfaceServiços.setVisible(true);
										dispose();
									}

									@Override
									public void mouseEntered(MouseEvent e) {
										lblNewLabel.setForeground(Color.red);
									}

									@Override
									public void mouseExited(MouseEvent e) {
										lblNewLabel.setForeground(Color.black);
									}
								});
								GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
								gbc_lblNewLabel.weighty = 1.0;
								gbc_lblNewLabel.weightx = 1.0;
								gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel.gridx = 0;
								gbc_lblNewLabel.gridy = 0;
								contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
						JLabel lblNewLabel_1 = new JLabel("Restaurante");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.weighty = 1.0;
						gbc_lblNewLabel_1.weightx = 1.0;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
						gbc_lblNewLabel_1.gridwidth = 5;
						gbc_lblNewLabel_1.gridx = 0;
						gbc_lblNewLabel_1.gridy = 0;
						contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				JLabel lblError = new JLabel("");
				lblError.setForeground(new Color(255, 0, 0));
				GridBagConstraints gbc_lblError = new GridBagConstraints();
				gbc_lblError.weighty = 1.0;
				gbc_lblError.weightx = 1.0;
				gbc_lblError.gridwidth = 5;
				gbc_lblError.insets = new Insets(0, 0, 5, 0);
				gbc_lblError.gridx = 0;
				gbc_lblError.gridy = 1;
				contentPane.add(lblError, gbc_lblError);
						
								JLabel lblNewLabel_3 = new JLabel("Histórico de pedidos:");
								GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
								gbc_lblNewLabel_3.gridwidth = 2;
								gbc_lblNewLabel_3.weighty = 1.0;
								gbc_lblNewLabel_3.weightx = 1.0;
								gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
								gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
								gbc_lblNewLabel_3.gridx = 3;
								gbc_lblNewLabel_3.gridy = 2;
								contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
				
						JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
						grupoBotoesRefeicao.add(rdbtnCafeDaManha);
						GridBagConstraints gbc_rdbtnCafeDaManha = new GridBagConstraints();
						gbc_rdbtnCafeDaManha.weighty = 1.0;
						gbc_rdbtnCafeDaManha.weightx = 1.0;
						gbc_rdbtnCafeDaManha.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnCafeDaManha.gridx = 0;
						gbc_rdbtnCafeDaManha.gridy = 3;
						contentPane.add(rdbtnCafeDaManha, gbc_rdbtnCafeDaManha);
						
						JButton btnRemoverHistorico = new JButton("Remover");
						btnRemoverHistorico.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
				
						JLabel lblNewLabel_2 = new JLabel("Observação:");
						GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
						gbc_lblNewLabel_2.weighty = 1.0;
						gbc_lblNewLabel_2.weightx = 1.0;
						gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_2.gridx = 2;
						gbc_lblNewLabel_2.gridy = 3;
						contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.gridheight = 6;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 3;
				gbc_scrollPane.gridy = 3;
				contentPane.add(scrollPane, gbc_scrollPane);
				
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
				grupoBotoesRefeicao.add(rdbtnAlmoco);
				GridBagConstraints gbc_rdbtnAlmoco = new GridBagConstraints();
				gbc_rdbtnAlmoco.weighty = 1.0;
				gbc_rdbtnAlmoco.weightx = 1.0;
				gbc_rdbtnAlmoco.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnAlmoco.gridx = 0;
				gbc_rdbtnAlmoco.gridy = 4;
				contentPane.add(rdbtnAlmoco, gbc_rdbtnAlmoco);
								
										txtObservacoes = new JTextField();
										GridBagConstraints gbc_txtObservacoes = new GridBagConstraints();
										gbc_txtObservacoes.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtObservacoes.anchor = GridBagConstraints.WEST;
										gbc_txtObservacoes.weighty = 1.0;
										gbc_txtObservacoes.weightx = 1.0;
										gbc_txtObservacoes.insets = new Insets(0, 0, 5, 5);
										gbc_txtObservacoes.gridx = 2;
										gbc_txtObservacoes.gridy = 4;
										contentPane.add(txtObservacoes, gbc_txtObservacoes);
										txtObservacoes.setColumns(10);
						
								JRadioButton rdbtnJantar = new JRadioButton("Jantar");
								grupoBotoesRefeicao.add(rdbtnJantar);
								GridBagConstraints gbc_rdbtnJantar = new GridBagConstraints();
								gbc_rdbtnJantar.weighty = 1.0;
								gbc_rdbtnJantar.weightx = 1.0;
								gbc_rdbtnJantar.insets = new Insets(0, 0, 5, 5);
								gbc_rdbtnJantar.gridx = 0;
								gbc_rdbtnJantar.gridy = 5;
								contentPane.add(rdbtnJantar, gbc_rdbtnJantar);
				
						JLabel lblNewLabel_4 = new JLabel("ID Reserva:");
						GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
						gbc_lblNewLabel_4.weighty = 1.0;
						gbc_lblNewLabel_4.weightx = 1.0;
						gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
						gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_4.gridx = 0;
						gbc_lblNewLabel_4.gridy = 6;
						contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				txtIdReserva = new JTextField();
				txtIdReserva.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				
				JLabel lblNewLabel_5 = new JLabel("Quantidade de refeições:");
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.weighty = 1.0;
				gbc_lblNewLabel_5.weightx = 1.0;
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.gridx = 2;
				gbc_lblNewLabel_5.gridy = 6;
				contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
				GridBagConstraints gbc_txtIdReserva = new GridBagConstraints();
				gbc_txtIdReserva.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIdReserva.weighty = 1.0;
				gbc_txtIdReserva.weightx = 1.0;
				gbc_txtIdReserva.insets = new Insets(0, 0, 5, 5);
				gbc_txtIdReserva.gridx = 0;
				gbc_txtIdReserva.gridy = 7;
				contentPane.add(txtIdReserva, gbc_txtIdReserva);
				txtIdReserva.setColumns(10);
		
				JButton btnAdicionar = new JButton("Adicionar");
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
				txtQuantidadeRefeicao.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres = "0987654321";
						if (!caracteres.contains(e.getKeyChar() + "")) {
							e.consume();
						}
					}
				});
				GridBagConstraints gbc_txtQuantidadeRefeicao = new GridBagConstraints();
				gbc_txtQuantidadeRefeicao.weighty = 1.0;
				gbc_txtQuantidadeRefeicao.weightx = 1.0;
				gbc_txtQuantidadeRefeicao.insets = new Insets(0, 0, 5, 5);
				gbc_txtQuantidadeRefeicao.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtQuantidadeRefeicao.gridx = 2;
				gbc_txtQuantidadeRefeicao.gridy = 7;
				contentPane.add(txtQuantidadeRefeicao, gbc_txtQuantidadeRefeicao);
				txtQuantidadeRefeicao.setColumns(10);
				GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
				gbc_btnAdicionar.weighty = 1.0;
				gbc_btnAdicionar.weightx = 1.0;
				gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
				gbc_btnAdicionar.gridx = 0;
				gbc_btnAdicionar.gridy = 8;
				contentPane.add(btnAdicionar, gbc_btnAdicionar);
			
				
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
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.weighty = 1.0;
				gbc_btnNewButton.weightx = 1.0;
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 3;
				gbc_btnNewButton.gridy = 9;
				contentPane.add(btnNewButton, gbc_btnNewButton);
		
				
				btnRemoverHistorico.setEnabled(false);
				GridBagConstraints gbc_btnRemoverHistorico = new GridBagConstraints();
				gbc_btnRemoverHistorico.anchor = GridBagConstraints.EAST;
				gbc_btnRemoverHistorico.gridwidth = 2;
				gbc_btnRemoverHistorico.weighty = 1.0;
				gbc_btnRemoverHistorico.weightx = 1.0;
				gbc_btnRemoverHistorico.gridx = 3;
				gbc_btnRemoverHistorico.gridy = 9;
				contentPane.add(btnRemoverHistorico, gbc_btnRemoverHistorico);
	}
}