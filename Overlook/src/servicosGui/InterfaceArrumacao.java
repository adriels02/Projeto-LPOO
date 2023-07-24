package servicosGui;
import servicosCore.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servicosBD.BDException;
import servicosBD.MySQLConector;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceArrumacao extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuarto;
	private JTable table;

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
					InterfaceArrumacao frame = new InterfaceArrumacao();
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
	public InterfaceArrumacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				GridBagLayout gbl_contentPane = new GridBagLayout();
				gbl_contentPane.columnWidths = new int[] {88, 88, 88, 88, 88, 88, 60, 0};
				gbl_contentPane.rowHeights = new int[]{50, 30, 50, 50, 50, 0, 0};
				gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				contentPane.setLayout(gbl_contentPane);
						
								JLabel lblVoltar = new JLabel("<<< Voltar");
								lblVoltar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {

										InterfaceServicos interfaceServicos = new InterfaceServicos();
										interfaceServicos.setVisible(true);
										dispose();

									}

									@Override
									public void mouseEntered(MouseEvent e) {
										lblVoltar.setForeground(Color.RED);
									}

									@Override
									public void mouseExited(MouseEvent e) {
										lblVoltar.setForeground(Color.BLACK);
									}
								});
								GridBagConstraints gbc_lblVoltar = new GridBagConstraints();
								gbc_lblVoltar.anchor = GridBagConstraints.NORTH;
								gbc_lblVoltar.weighty = 1.0;
								gbc_lblVoltar.weightx = 1.0;
								gbc_lblVoltar.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblVoltar.insets = new Insets(0, 0, 5, 5);
								gbc_lblVoltar.gridx = 0;
								gbc_lblVoltar.gridy = 0;
								contentPane.add(lblVoltar, gbc_lblVoltar);
				
						JLabel lblNewLabel_1 = new JLabel("Arrumação");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.gridwidth = 7;
						gbc_lblNewLabel_1.weighty = 1.0;
						gbc_lblNewLabel_1.weightx = 1.0;
						gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
						gbc_lblNewLabel_1.gridx = 0;
						gbc_lblNewLabel_1.gridy = 0;
						contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				JLabel lblErro = new JLabel("");
				lblErro.setForeground(new Color(255, 0, 0));
				GridBagConstraints gbc_lblErro = new GridBagConstraints();
				gbc_lblErro.weighty = 1.0;
				gbc_lblErro.weightx = 1.0;
				gbc_lblErro.gridwidth = 7;
				gbc_lblErro.insets = new Insets(0, 0, 5, 0);
				gbc_lblErro.gridx = 0;
				gbc_lblErro.gridy = 1;
				contentPane.add(lblErro, gbc_lblErro);
				
				JLabel lblNewLabel = new JLabel("Número do Quarto:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.weighty = 1.0;
				gbc_lblNewLabel.weightx = 1.0;
				gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 2;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
				txtQuarto = new JTextField();
				txtQuarto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				GridBagConstraints gbc_txtQuarto = new GridBagConstraints();
				gbc_txtQuarto.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtQuarto.weighty = 1.0;
				gbc_txtQuarto.weightx = 1.0;
				gbc_txtQuarto.insets = new Insets(0, 0, 5, 5);
				gbc_txtQuarto.gridx = 1;
				gbc_txtQuarto.gridy = 2;
				contentPane.add(txtQuarto, gbc_txtQuarto);
				txtQuarto.setColumns(10);
				
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.gridwidth = 4;
				gbc_scrollPane.gridheight = 3;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 3;
				gbc_scrollPane.gridy = 2;
				contentPane.add(scrollPane, gbc_scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00FAmero Quarto", "estado"
					}
				));
				
				
				
				scrollPane.setViewportView(table);
				
				JLabel lblNewLabel_2 = new JLabel("Status:");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.weighty = 1.0;
				gbc_lblNewLabel_2.weightx = 1.0;
				gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 3;
				contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arrumado", "Desarrumado"}));
				comboBox.setMaximumRowCount(2);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.weighty = 1.0;
				gbc_comboBox.weightx = 1.0;
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 3;
				contentPane.add(comboBox, gbc_comboBox);
				
				JButton btnAlterarStatusArrumacao = new JButton("Alterar");
				btnAlterarStatusArrumacao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
									
						lblErro.setText("");
												
						String quarto = txtQuarto.getText();
						if (quarto.equals("")) {
							quarto = "0";
						}
						
						int numeroQuarto = Integer.parseInt(quarto);
								
						
						try {
							
							if (comboBox.getSelectedItem().equals("Arrumado")) {
								
								ControladorDeAcessos controlador = new ControladorDeAcessos();
								controlador.alterarArrumacao(numeroQuarto, "Arrumado");
								
							}
								
							
							if (comboBox.getSelectedItem().equals("Desarrumado")) {
								
								ControladorDeAcessos controlador = new ControladorDeAcessos();
													controlador.alterarArrumacao(numeroQuarto, "Desarrumado");
									
							}													
							
						} catch (CoreException mensagem) {
							
							lblErro.setText(mensagem.getMessage());					
						}
		
				    }
				});
				
				
				DefaultTableModel tableModel = new DefaultTableModel(
					    new Object[][] {},
					    new String[] {
					        "Número do Quarto", "estado"
					    }
					);
					
				try {
				    MySQLConector leitor = new MySQLConector();

				    for (Arrumacao p : leitor.leituraArrumacao()) {
				        tableModel.addRow(new Object[] {
				            p.getNumeroQuarto(), p.getEstado()
			        });
				    }
				} catch (BDException exception) {
					lblErro.setText(exception.getMessage());			
					}
				
				table.setModel(tableModel);
				
				
				
				
				GridBagConstraints gbc_btnAlterarStatusArrumacao = new GridBagConstraints();
				gbc_btnAlterarStatusArrumacao.weighty = 1.0;
				gbc_btnAlterarStatusArrumacao.weightx = 1.0;
				gbc_btnAlterarStatusArrumacao.insets = new Insets(0, 0, 5, 5);
				gbc_btnAlterarStatusArrumacao.gridx = 1;
				gbc_btnAlterarStatusArrumacao.gridy = 4;
				contentPane.add(btnAlterarStatusArrumacao, gbc_btnAlterarStatusArrumacao);
				
				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						lblErro.setText("Tabela atualizada");
						
						tableModel.setNumRows(0);
						
						DefaultTableModel tableModel = new DefaultTableModel(
							    new Object[][] {},
							    new String[] {
							        "Número do Quarto", "estado"
							    }
							);
							
						try {
						    MySQLConector leitor = new MySQLConector();

						    for (Arrumacao p : leitor.leituraArrumacao()) {
						        tableModel.addRow(new Object[] {
						            p.getNumeroQuarto(), p.getEstado()
					        });
						    }
						} catch (BDException exception) {
							lblErro.setText(exception.getMessage());			
							}
						
						table.setModel(tableModel);
						
						
					}
				});
				GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
				gbc_btnAtualizar.gridwidth = 4;
				gbc_btnAtualizar.weighty = 1.0;
				gbc_btnAtualizar.weightx = 1.0;
				gbc_btnAtualizar.gridx = 3;
				gbc_btnAtualizar.gridy = 5;
				contentPane.add(btnAtualizar, gbc_btnAtualizar);
	}
}
