package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.ControladorDeAcessos;
import core.RegistroServicoDeQuarto;
import core.Restaurante;
import core.RestaurantePedidos;
import core.ServicoDeQuarto;
import core.Validador;
import data.BDException;
import data.MySQLConector;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InterfaceServicoDeQuarto extends JFrame {

	private JPanel contentPane;	
	private ButtonGroup grupoBotoesRefeicao = new ButtonGroup();
	private JTextField txtObservacoes;
	private JTextField txtNumeroQuarto;
	private JTable table;
	private JTextField txtIdReserva;
	private JTextField txtQuantidadeRefeicao;
	private int idReferenciaExclusao = 0;
	
	private TableModel modeloServicoDeQuarto() {
	    DefaultTableModel tableModel = new DefaultTableModel(
	        new Object[][] {},
	        new String[] {
	        		"ID", "N\u00BA Quarto", "ID Reserva", "Tipo", "N\u00BA Refei\u00E7\u00F5es", "Dia e hora", "Observa\u00E7\u00F5es"        }
	    ) {
	       
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };

	    tableModel.setNumRows(0);

	    try {
	        MySQLConector leitor = new MySQLConector();

	        for (RegistroServicoDeQuarto p : leitor.leituraServicosDeQuarto()) {
	            tableModel.addRow(new Object[] {
	                p.getIdRegistro(), p.getNumeroDoQuarto(), p.getNumeroReserva(), p.getRefeicao(), p.getQuantidadeRefeicao(), p.getDatahora(), p.getObservacoes()
	            });
	            
	        }
	    } catch (BDException exception) {
	        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Atualizar a tabela.");
	    }
	 

	    return tableModel;
	}

	
	
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
					InterfaceServicoDeQuarto frame = new InterfaceServicoDeQuarto();
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
	public InterfaceServicoDeQuarto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 551);
		setBounds(100, 100, 653, 453);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblTituloServicoQuarto = new JLabel("Serviço de Quarto");
				lblTituloServicoQuarto.setForeground(new Color(38, 9, 55));
				lblTituloServicoQuarto.setBounds(51, 78, 291, 42);
				lblTituloServicoQuarto.setFont(new Font("Tahoma", Font.BOLD, 30));
				contentPane.add(lblTituloServicoQuarto);
				
						JLabel lblNewLabel_2 = new JLabel("Observação");
						lblNewLabel_2.setForeground(new Color(38, 9, 55));
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_2.setBounds(298, 370, 113, 14);
						contentPane.add(lblNewLabel_2);
				
						JLabel lblTituloHistorico = new JLabel("Histórico de Serviços de Quarto");
						lblTituloHistorico.setForeground(new Color(38, 9, 55));
						lblTituloHistorico.setHorizontalAlignment(SwingConstants.RIGHT);
						lblTituloHistorico.setFont(new Font("Tahoma", Font.BOLD, 14));
						lblTituloHistorico.setBounds(1003, 113, 241, 14);
						contentPane.add(lblTituloHistorico);
				
				JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
				rdbtnCafeDaManha.setBackground(new Color(255, 255, 255));
				rdbtnCafeDaManha.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnCafeDaManha.setForeground(new Color(38, 9, 55));
				rdbtnCafeDaManha.setBounds(51, 218, 113, 23);
				grupoBotoesRefeicao.add(rdbtnCafeDaManha);
				contentPane.add(rdbtnCafeDaManha);
		
				txtObservacoes = new JTextField();
				txtObservacoes.setBounds(298, 393, 271, 20);
				contentPane.add(txtObservacoes);
				txtObservacoes.setColumns(10);
				
				JButton btnRemoverHistorico = new JButton("Remover");
				btnRemoverHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						try {

							ControladorDeAcessos idExclusao = new ControladorDeAcessos();
							idExclusao.exclusaoServicoQuarto(idReferenciaExclusao);

							JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso");
							table.setModel(modeloServicoDeQuarto());
							idReferenciaExclusao = 0;

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, exception.getMessage());

						}
					
					}
				});
				btnRemoverHistorico.setForeground(new Color(38, 9, 55));
				btnRemoverHistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnRemoverHistorico.setBounds(1153, 650, 91, 23);
				
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(607, 134, 637, 504);
								contentPane.add(scrollPane);
								
								table = new JTable();
								table.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										int linhaSelecionada = table.getSelectedRow();

										if (linhaSelecionada >= 0) {
											Object valorCelula = table.getValueAt(linhaSelecionada, 0);
											idReferenciaExclusao = (int) valorCelula;

										}	
													
									}
								});
								table.setModel(new DefaultTableModel(
									new Object[][] {
									},
									new String[] {
										"ID", "N\u00BA Quarto", "ID Reserva", "Tipo", "N\u00BA Refei\u00E7\u00F5es", "Dia e hora", "Observa\u00E7\u00F5es"
									}
								));
								table.getColumnModel().getColumn(5).setPreferredWidth(89);
								table.getColumnModel().getColumn(5).setMinWidth(123);
								scrollPane.setViewportView(table);
								table.setModel(modeloServicoDeQuarto());
								table.getColumnModel().getColumn(5).setPreferredWidth(110);
								JRadioButton rdbtnAlmoco = new JRadioButton("Almoço");
								rdbtnAlmoco.setBackground(new Color(255, 255, 255));
								rdbtnAlmoco.setFont(new Font("Tahoma", Font.BOLD, 11));
								rdbtnAlmoco.setForeground(new Color(38, 9, 55));
								rdbtnAlmoco.setBounds(51, 269, 76, 23);
								grupoBotoesRefeicao.add(rdbtnAlmoco);
								contentPane.add(rdbtnAlmoco);
				
						JRadioButton rdbtnJantar = new JRadioButton("Jantar");
						rdbtnJantar.setBackground(new Color(255, 255, 255));
						rdbtnJantar.setFont(new Font("Tahoma", Font.BOLD, 11));
						rdbtnJantar.setForeground(new Color(38, 9, 55));
						rdbtnJantar.setBounds(51, 322, 65, 23);
						grupoBotoesRefeicao.add(rdbtnJantar);
						contentPane.add(rdbtnJantar);
						
						JLabel lblNewLabel_5 = new JLabel("Id Reserva");
						lblNewLabel_5.setForeground(new Color(38, 9, 55));
						lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_5.setBounds(298, 186, 113, 14);
						contentPane.add(lblNewLabel_5);
				
						JLabel lblNewLabel_4 = new JLabel("Nº do Quarto");
						lblNewLabel_4.setForeground(new Color(38, 9, 55));
						lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_4.setBounds(298, 272, 91, 14);
						contentPane.add(lblNewLabel_4);
		
						txtNumeroQuarto = new JTextField();
						txtNumeroQuarto.setBounds(298, 294, 136, 21);
						txtNumeroQuarto.setDocument(new Validador(5));
						txtNumeroQuarto.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent e) {

								String caracteres = "0987654321";
								if (!caracteres.contains(e.getKeyChar() + "")) {
									e.consume();
								}
							}
						});
						contentPane.add(txtNumeroQuarto);
						txtNumeroQuarto.setColumns(10);

						JButton btnAdicionar = new JButton("Adicionar");
						btnAdicionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

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

							try {
									ControladorDeAcessos controlador = new ControladorDeAcessos();
									controlador.registroPedidoDeQuarto(txtIdReserva.getText(),
											txtNumeroQuarto.getText(), txtQuantidadeRefeicao.getText(), refeicao,
											txtObservacoes.getText());
									controlador.registroServicoDeQuarto(txtIdReserva.getText(), refeicao,
											txtQuantidadeRefeicao.getText());

									JOptionPane.showMessageDialog(null, "Serviço de quarto registrado com sucesso");
									txtIdReserva.setText("");
									txtNumeroQuarto.setText("");
									txtObservacoes.setText("");
									txtQuantidadeRefeicao.setText("");
									txtQuantidadeRefeicao.setText("");
									grupoBotoesRefeicao.clearSelection();
									table.setModel(modeloServicoDeQuarto());
									table.getColumnModel().getColumn(5).setPreferredWidth(110);

								} catch (Exception exception) {

									JOptionPane.showMessageDialog(null, exception.getMessage());
								}
							}
						});
						btnAdicionar.setForeground(new Color(38, 9, 55));
						btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
						btnAdicionar.setBounds(478, 424, 91, 23);

						txtIdReserva = new JTextField();
						txtIdReserva.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent e) {
								String caracteres = "0987654321";
								if (!caracteres.contains(e.getKeyChar() + "")) {
									e.consume();
								}
							}
						});
						txtIdReserva.setBounds(298, 208, 271, 20);
						contentPane.add(txtIdReserva);
						txtIdReserva.setColumns(10);
						contentPane.add(btnAdicionar);
						txtIdReserva.setDocument(new Validador(50));
						contentPane.add(btnRemoverHistorico);

						JButton btnNewButton = new JButton("");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								InterfaceServicos interfaceServicos = new InterfaceServicos();
								interfaceServicos.setVisible(true);
								dispose();
							}
						});
						btnNewButton.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class
								.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
						btnNewButton.setBounds(0, 0, 65, 23);
						contentPane.add(btnNewButton);

						JButton btnFecharTela = new JButton("");
						btnFecharTela.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								dispose();
							}
				});
				btnFecharTela.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
				btnFecharTela.setBounds(1250, 0, 30, 30);
				contentPane.add(btnFecharTela);
				
				JButton btnSignOut = new JButton("");
				btnSignOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						TelaInicial objTelaInicial = new TelaInicial();
						objTelaInicial.setVisible(true);
						dispose();
						
						
					}
				});
				btnSignOut.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
				btnSignOut.setBounds(1213, 0, 30, 30);
				contentPane.add(btnSignOut);
				
				JLabel lblLogoPequena = new JLabel("");
				lblLogoPequena.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/logo 220 x150.png")));
				lblLogoPequena.setBounds(45, 496, 220, 150);
				contentPane.add(lblLogoPequena);
			
				
				
				
				JLabel lblLogoTransparente = new JLabel("");
				lblLogoTransparente.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
				lblLogoTransparente.setBounds(160, 0, 758, 758);
				contentPane.add(lblLogoTransparente);
				
				JLabel lblQuantidadeRefeicao = new JLabel("Quantidade da Refeição");
				lblQuantidadeRefeicao.setForeground(new Color(38, 9, 55));
				lblQuantidadeRefeicao.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblQuantidadeRefeicao.setBounds(51, 370, 154, 14);
				contentPane.add(lblQuantidadeRefeicao);
				
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
				txtQuantidadeRefeicao.setColumns(10);
				txtQuantidadeRefeicao.setBounds(51, 393, 136, 21);
				contentPane.add(txtQuantidadeRefeicao);
				txtQuantidadeRefeicao.setDocument(new Validador(2));
				

		
		
		
		
		
	}
}