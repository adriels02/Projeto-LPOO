package gui;

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

import core.ControladorDeAcessos;
import core.HistoricoTranslado;
import core.Precos;
import core.Validador;
import data.MySQLConector;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacePrecos.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloPrecos = new JLabel("Preços");
		lblTituloPrecos.setForeground(new Color(38, 9, 55));
		lblTituloPrecos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTituloPrecos.setBounds(43, 85, 224, 42);
		contentPane.add(lblTituloPrecos);
		
		JLabel lblNewLabel_1 = new JLabel("Quarto Casal");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(43, 247, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quarto Solteiro");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(191, 247, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Restaurante");
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(192, 510, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serviço de Quarto");
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(44, 510, 106, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Taxa Translado");
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(191, 385, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estacionamento");
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(43, 385, 97, 14);
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
		txtQuartoCasal.setBounds(43, 268, 89, 23);
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
		txtRefeicaoRestaurante.setBounds(192, 531, 89, 23);
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
		txtQuartoSolteiro.setBounds(191, 267, 89, 23);
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
		txtServicoQuarto.setBounds(44, 531, 89, 23);
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
		txtViagemTranslado.setBounds(191, 405, 89, 23);
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
		txtVagaEstacionamento.setBounds(43, 404, 89, 23);
		contentPane.add(txtVagaEstacionamento);
		txtVagaEstacionamento.setColumns(10);
		txtVagaEstacionamento.setDocument(new Validador(7));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 247, 877, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
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
		btnQuartoCasal.setBackground(new Color(225, 225, 225));
		btnQuartoCasal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuartoCasal.setForeground(new Color(38, 9, 55));
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
		
		btnQuartoCasal.setBounds(43, 299, 89, 23);
		contentPane.add(btnQuartoCasal);
		
		JButton btnRefeicaoRestaurante = new JButton("Alterar");
		btnRefeicaoRestaurante.setBackground(new Color(225, 225, 225));
		btnRefeicaoRestaurante.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefeicaoRestaurante.setForeground(new Color(38, 9, 55));
		btnRefeicaoRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 4;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtRefeicaoRestaurante.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtRefeicaoRestaurante.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnRefeicaoRestaurante.setBounds(192, 562, 89, 23);
		contentPane.add(btnRefeicaoRestaurante);
		
		JButton btnServicoDeQuarto = new JButton("Alterar");
		btnServicoDeQuarto.setBackground(new Color(225, 225, 225));
		btnServicoDeQuarto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnServicoDeQuarto.setForeground(new Color(38, 9, 55));
		btnServicoDeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 5;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtServicoQuarto.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtServicoQuarto.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnServicoDeQuarto.setBounds(44, 562, 89, 23);
		contentPane.add(btnServicoDeQuarto);
		
		JButton btnQuartoSolteiro = new JButton("Alterar");
		btnQuartoSolteiro.setBackground(new Color(225, 225, 225));
		btnQuartoSolteiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuartoSolteiro.setForeground(new Color(38, 9, 55));
		btnQuartoSolteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 1;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtQuartoSolteiro.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtQuartoSolteiro.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnQuartoSolteiro.setBounds(191, 299, 89, 23);
		contentPane.add(btnQuartoSolteiro);
		
		JButton btnViagemTranslado = new JButton("Alterar");
		btnViagemTranslado.setBackground(new Color(225, 225, 225));
		btnViagemTranslado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViagemTranslado.setForeground(new Color(38, 9, 55));
		btnViagemTranslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 7;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtViagemTranslado.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtViagemTranslado.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnViagemTranslado.setBounds(191, 436, 89, 23);
		contentPane.add(btnViagemTranslado);
		
		JButton btnVagaEstacionamento = new JButton("Alterar");
		btnVagaEstacionamento.setBackground(new Color(225, 225, 225));
		btnVagaEstacionamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVagaEstacionamento.setForeground(new Color(38, 9, 55));
		btnVagaEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 6;
						
					ControladorDeAcessos controlador = new ControladorDeAcessos();
										 controlador.mudarPreco(txtVagaEstacionamento.getText(), id);
										 table.setModel(modeloTabelaPrecos());
										 txtVagaEstacionamento.setText("");
										 JOptionPane.showMessageDialog(null,"Registrado com sucesso");
					} catch (Exception exception) {
						
						JOptionPane.showMessageDialog(null,"Ocorreu um erro: " + exception.getMessage() );	
						
					}
			}
		});
		btnVagaEstacionamento.setBounds(43, 436, 89, 23);
		contentPane.add(btnVagaEstacionamento);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfacePrecos.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
		btnNewButton_1.setIcon(new ImageIcon(InterfacePrecos.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnNewButton_1.setBounds(1213, 0, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfacePrecos.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(60, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		
		JLabel lblLogoPequena = new JLabel("");
		lblLogoPequena.setIcon(new ImageIcon(InterfacePrecos.class.getResource("/interfaces/imagens/logo 220 x150.png")));
		lblLogoPequena.setBounds(865, 63, 220, 150);
		contentPane.add(lblLogoPequena);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
				dispose();
			}
		});
	}
}
