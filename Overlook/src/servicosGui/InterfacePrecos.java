package servicosGui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bdConexao.Validador;
import interfaces.MenuPrincipal;
import servicosBD.MySQLConector;
import servicosCore.ControladorDeAcessos;
import servicosCore.HistoricoTranslado;
import servicosCore.Precos;

public class InterfacePrecos extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuartoCasal;
	private JTextField txtRefeicaoRestaurante;
	private JTextField txtQuartoSolteiro;
	private JTextField txtServicoQuarto;
	private JTextField txtViagemTranslado;
	private JTextField txtVagaEstacionamento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	private TableModel modeloTabelaPrecos() {
		
		
		DefaultTableModel tableModel = new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			    		"ID", "Nome", "Pre\u00E7o"
			    }
			) {
			    Class[] columnTypes = new Class[] {
			        Object.class, Object.class, Object.class
			    };			  
			};
			
			tableModel.setNumRows(0);
			
			try {
		    MySQLConector leitor = new MySQLConector();

		    for (Precos p : leitor.leituraPrecos()) {
		        tableModel.addRow(new Object[] {
		            p.getId(), p.getNome(), p.getPreco()
	            
	        });
		    }
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null,"Ocorreu um erro ao atualizar a tabela" + exception);
				
			}
		
		
		return tableModel;
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrecos frame = new InterfacePrecos();
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
	public InterfacePrecos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Menu Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
				dispose();
			}
		});
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preços");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(565, 11, 56, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quarto Casal:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(88, 64, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quarto Solteiro:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(979, 64, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Refeição Restaurante:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(38, 165, 136, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Taxa serviço de Quarto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(27, 287, 136, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Viagem Translado:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(966, 165, 116, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vaga Estacionamento:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(946, 287, 136, 14);
		contentPane.add(lblNewLabel_6);
		
		txtQuartoCasal = new JTextField();
		txtQuartoCasal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtQuartoCasal.setBounds(173, 62, 86, 20);
		contentPane.add(txtQuartoCasal);
		txtQuartoCasal.setColumns(10);
		txtQuartoCasal.setDocument(new Validador (7));
		
		txtRefeicaoRestaurante = new JTextField();
		txtRefeicaoRestaurante.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtRefeicaoRestaurante.setBounds(173, 163, 86, 20);
		contentPane.add(txtRefeicaoRestaurante);
		txtRefeicaoRestaurante.setColumns(10);
		txtRefeicaoRestaurante.setDocument(new Validador (7));
		
		txtQuartoSolteiro = new JTextField();
		txtQuartoSolteiro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtQuartoSolteiro.setBounds(1086, 62, 86, 20);
		contentPane.add(txtQuartoSolteiro);
		txtQuartoSolteiro.setColumns(10);
		txtQuartoSolteiro.setDocument(new Validador(7));
		
		txtServicoQuarto = new JTextField();
		txtServicoQuarto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtServicoQuarto.setBounds(173, 285, 86, 20);
		contentPane.add(txtServicoQuarto);
		txtServicoQuarto.setColumns(10);
		txtServicoQuarto.setDocument(new Validador(7));
		
		txtViagemTranslado = new JTextField();
		txtViagemTranslado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtViagemTranslado.setBounds(1086, 163, 86, 20);
		contentPane.add(txtViagemTranslado);
		txtViagemTranslado.setColumns(10);
		txtViagemTranslado.setDocument(new Validador(7));
		
		txtVagaEstacionamento = new JTextField();
		txtVagaEstacionamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtVagaEstacionamento.setBounds(1086, 285, 86, 20);
		contentPane.add(txtVagaEstacionamento);
		txtVagaEstacionamento.setColumns(10);
		txtVagaEstacionamento.setDocument(new Validador(7));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 375, 877, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Pre\u00E7o"
			}
		));
		scrollPane.setViewportView(table);
		
		table.setModel(modeloTabelaPrecos());
		
		JButton btnQuartoCasal = new JButton("Alterar");
		btnQuartoCasal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
				int id = 3;
					
				ControladorDeAcessos controlador = new ControladorDeAcessos();
									 controlador.mudarPreco(txtQuartoCasal.getText(), id);
									 table.setModel(modeloTabelaPrecos());
									 txtQuartoCasal.setText("");
									 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
				} catch (Exception exception) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
					
				}
						
				
			}
		});
		
		btnQuartoCasal.setBounds(170, 89, 89, 23);
		contentPane.add(btnQuartoCasal);
		
		JButton btnRefeicaoRestaurante = new JButton("Alterar");
		btnRefeicaoRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 4;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoCasal.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoCasal.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnRefeicaoRestaurante.setBounds(170, 195, 89, 23);
		contentPane.add(btnRefeicaoRestaurante);
		
		JButton btnServicoDeQuarto = new JButton("Alterar");
		btnServicoDeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 5;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoCasal.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoCasal.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnServicoDeQuarto.setBounds(173, 313, 89, 23);
		contentPane.add(btnServicoDeQuarto);
		
		JButton btnQuartoSolteiro = new JButton("Alterar");
		btnQuartoSolteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 1;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoCasal.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoCasal.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnQuartoSolteiro.setBounds(1086, 89, 89, 23);
		contentPane.add(btnQuartoSolteiro);
		
		JButton btnViagemTranslado = new JButton("Alterar");
		btnViagemTranslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 7;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoCasal.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoCasal.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnViagemTranslado.setBounds(1086, 194, 89, 23);
		contentPane.add(btnViagemTranslado);
		
		JButton btnVagaEstacionamento = new JButton("Alterar");
		btnVagaEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 6;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoCasal.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoCasal.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnVagaEstacionamento.setBounds(1086, 313, 89, 23);
		contentPane.add(btnVagaEstacionamento);
	}
}
