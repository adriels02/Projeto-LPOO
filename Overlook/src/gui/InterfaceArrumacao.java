package gui;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.Arrumacao;
import core.ControladorDeAcessos;
import core.CoreException;
import core.Validador;
import data.BDException;
import data.MySQLConector;

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
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

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
	
	private TableModel modeloArrumacao() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Número do Quarto", "Estado" }) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tableModel.setNumRows(0);

		try {
			MySQLConector leitor = new MySQLConector();

			for (Arrumacao p : leitor.leituraArrumacao()) {
				tableModel.addRow(new Object[] { p.getNumeroQuarto(), p.getEstado() });
			}
		} catch (BDException exception) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a tabela");
		}

		return tableModel;
	}
	
	
	public InterfaceArrumacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceArrumacao.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 417);
		setBounds(100, 100, 622, 384);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
								contentPane.setLayout(null);
				
						JLabel lblNewLabel_1 = new JLabel("Arrumação");
						lblNewLabel_1.setForeground(new Color(38, 9, 55));
						lblNewLabel_1.setBounds(60, 80, 150, 42);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
						contentPane.add(lblNewLabel_1);
				
				JLabel lblErro = new JLabel("");
				lblErro.setBounds(0, 0, 0, 0);
				lblErro.setForeground(new Color(255, 0, 0));
				contentPane.add(lblErro);
				
				JLabel lblNewLabel = new JLabel("Nº do Quarto");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setForeground(new Color(38, 9, 55));
				lblNewLabel.setBounds(236, 551, 85, 23);
				contentPane.add(lblNewLabel);
				
				txtQuarto = new JTextField();
				txtQuarto.setBounds(317, 551, 259, 23);
				txtQuarto.setDocument(new Validador(5));
				txtQuarto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				contentPane.add(txtQuarto);
				txtQuarto.setColumns(10);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(624, 133, 621, 499);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00FAmero Quarto", "estado"
					}
				));
				
				
				
				scrollPane.setViewportView(table);
				
				JLabel lblNewLabel_2 = new JLabel("Status");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_2.setForeground(new Color(38, 9, 55));
				lblNewLabel_2.setBounds(236, 609, 85, 23);
				contentPane.add(lblNewLabel_2);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setForeground(new Color(38, 9, 55));
				comboBox.setBounds(317, 609, 259, 23);
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arrumado", "Desarrumado"}));
				comboBox.setMaximumRowCount(2);
				contentPane.add(comboBox);
				
				JButton btnMenuServicos = new JButton("");
				btnMenuServicos.setIcon(new ImageIcon(InterfaceArrumacao.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
				btnMenuServicos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						InterfaceServicos interfaceServicos = new InterfaceServicos();
						interfaceServicos.setVisible(true);
						dispose();

						
					}
				});
				btnMenuServicos.setBackground(new Color(255, 128, 64));
				btnMenuServicos.setForeground(new Color(255, 255, 255));
				btnMenuServicos.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnMenuServicos.setBackground(new Color(255, 128, 64));
				btnMenuServicos.setBounds(0, 0, 65, 23);
				contentPane.add(btnMenuServicos);
				
				
				JButton btnAlterarStatusArrumacao = new JButton("Alterar");
				btnAlterarStatusArrumacao.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnAlterarStatusArrumacao.setForeground(new Color(38, 9, 55));
				btnAlterarStatusArrumacao.setBounds(400, 643, 100, 23);
				btnAlterarStatusArrumacao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
																				
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
													JOptionPane.showMessageDialog(null, "Mudança de status realizada com sucesso");
													txtQuarto.setText("");
													table.setModel(modeloArrumacao());
							}													
							
						} catch (CoreException mensagem) {
							
							JOptionPane.showMessageDialog(null, mensagem.getMessage());			
						}
		
				    }
				});
				
				
				
				table.setModel(modeloArrumacao());
				contentPane.add(btnAlterarStatusArrumacao);
				
				JButton btnFecharTela = new JButton("");
				btnFecharTela.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				btnFecharTela.setIcon(new ImageIcon(InterfaceArrumacao.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
				btnNewButton_1.setIcon(new ImageIcon(InterfaceArrumacao.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
				btnNewButton_1.setBounds(1213, 0, 30, 30);
				contentPane.add(btnNewButton_1);
				
				
				JLabel lblLogoTelas = new JLabel("");
				lblLogoTelas.setIcon(new ImageIcon(InterfaceArrumacao.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
				lblLogoTelas.setBounds(50, 176, 480, 320);
				contentPane.add(lblLogoTelas);
				
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(InterfaceArrumacao.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
				lblNewLabel_3.setBounds(400, 0, 758, 758);
				contentPane.add(lblNewLabel_3);


	}
}
