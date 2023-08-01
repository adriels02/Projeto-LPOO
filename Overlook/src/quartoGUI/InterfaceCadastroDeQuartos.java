package quartoGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.MenuPrincipal;
import interfaces.TelaInicial;
import quartoBD.QuartoDAO;
import quartoCORE.Quarto;
import servicosBD.BDException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InterfaceCadastroDeQuartos {

	public JFrame frmCadastroDeQuartos;
	private JTextField textfNumQuarto;
	private JTextField textfValorDiaria;
	private JTextField textfPesquisar;
	private JTable table;
	private JTable tbLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroDeQuartos window = new InterfaceCadastroDeQuartos();
					window.frmCadastroDeQuartos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceCadastroDeQuartos() {
		initialize();
		
	}

	public void desativar() {
		textfNumQuarto.setVisible(false);
		Window cbxTipoDeQuarto = null;
		cbxTipoDeQuarto.setVisible(false);
		Window cbxEstado = null;
		cbxEstado.setVisible(false);
		textfValorDiaria.setVisible(false);
		Window textaDescricao = null;
	    textaDescricao.setVisible(false);
	    Window spnAndar = null;
		spnAndar.setVisible(false);
		Window cbxCapacidade = null;
		cbxCapacidade.setVisible(false);
		
		Component btnSalvar = null;
		btnSalvar.setEnabled(false);
		Component btnNovo = null;
		btnNovo.setEnabled(false);
		Component btnCancelar = null;
		btnCancelar.setEnabled(false);	
	}
	
	public void ativar() {
		textfNumQuarto.setVisible(true);
		Window cbxTipoDeQuarto = null;
		cbxTipoDeQuarto.setVisible(true);
		Window cbxEstado = null;
		cbxEstado.setVisible(true);
		textfValorDiaria.setVisible(true);
		Window textaDescricao = null;
	    textaDescricao.setVisible(true);
	    Window spnAndar = null;
		spnAndar.setVisible(true);
		Window cbxCapacidade = null;
		cbxCapacidade.setVisible(true);
		
		Component btnSalvar = null;
		btnSalvar.setEnabled(true);
		Component btnNovo = null;
		btnNovo.setEnabled(true);
		Component btnCancelar = null;
		btnCancelar.setEnabled(true);	
	}
	
	public void mostrar (String buscar) {
		
		try {
			DefaultTableModel modelo;
			QuartoDAO dao = new QuartoDAO();
			modelo = dao.mostrarQuarto(buscar);
			tbLista.setModel(modelo);
			
			JLabel lblTotalRegistros = new JLabel();
			lblTotalRegistros.setText("Total Registro" + Integer.toBinaryString((int) dao.totalRegistro));
			
		}catch (Exception e) {
			
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeQuartos = new JFrame();
		frmCadastroDeQuartos.getContentPane().setBackground(new Color(255, 255, 255));
		frmCadastroDeQuartos.setResizable(false);
		frmCadastroDeQuartos.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		frmCadastroDeQuartos.setBounds(100, 100, 807, 474);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeQuartos.setSize(1280,720); 
		frmCadastroDeQuartos.setLocationRelativeTo(null);
		frmCadastroDeQuartos.setUndecorated(true);
		
		tbLista = new JTable();
		tbLista.setBackground(new Color(240, 240, 240));
		tbLista.setBounds(522, 210, 723, 312);
		tbLista.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tbLista.getColumnModel().getColumn(0).setPreferredWidth(294);
		tbLista.getColumnModel().getColumn(1).setPreferredWidth(318);
		frmCadastroDeQuartos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Cadastro do Quarto");
		lblNewLabel.setBounds(29, 50, 350, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(0, 0, 0, 0);
		frmCadastroDeQuartos.getContentPane().add(list);
		
		JLabel lblListaDeQuartos = new JLabel("Lista de Quartos");
		lblListaDeQuartos.setBounds(522, 50, 279, 42);
		lblListaDeQuartos.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmCadastroDeQuartos.getContentPane().add(lblListaDeQuartos);
		
		JLabel lblNmero = new JLabel(" Número");
		lblNmero.setForeground(new Color(38, 9, 55));
		lblNmero.setBounds(29, 158, 69, 15);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNmero);
		
		textfNumQuarto = new JTextField();
		textfNumQuarto.setBounds(98, 154, 123, 23);
		textfNumQuarto.setForeground(new Color(0, 0, 0));
		frmCadastroDeQuartos.getContentPane().add(textfNumQuarto);
		textfNumQuarto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Andar");
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(308, 158, 44, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBackground(new Color(225, 225, 225));
		btnBuscar.setForeground(new Color(38, 9, 55));
		btnBuscar.setBounds(856, 154, 120, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setForeground(new Color(38, 9, 55));
		lblPesquisar.setBounds(522, 158, 139, 15);
		lblPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblPesquisar);
		
		textfPesquisar = new JTextField();
		textfPesquisar.setBounds(586, 154, 251, 23);
		frmCadastroDeQuartos.getContentPane().add(textfPesquisar);
		textfPesquisar.setColumns(10);
		frmCadastroDeQuartos.getContentPane().add(btnBuscar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApagar.setBackground(new Color(225, 225, 225));
		btnApagar.setForeground(new Color(38, 9, 55));
		btnApagar.setBounds(990, 154, 120, 23);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnApagar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(225, 225, 225));
		btnSair.setForeground(new Color(38, 9, 55));
		btnSair.setBounds(1125, 154, 120, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnSair);
		
		JLabel lblNewLabel_2 = new JLabel(" Descrição ");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setBounds(29, 210, 69, 15);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_2);
		
		JTextArea textaDescricao = new JTextArea();
		textaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textaDescricao.setBackground(new Color(240, 240, 240));
		textaDescricao.setBounds(98, 210, 372, 138);
		frmCadastroDeQuartos.getContentPane().add(textaDescricao);
		frmCadastroDeQuartos.getContentPane().add(tbLista);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setForeground(new Color(38, 9, 55));
		btnNovo.setBackground(new Color(225, 225, 225));
		btnNovo.setBounds(29, 660, 156, 23);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativar();
				btnSalvar.setText("Salvar");
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel(" Valor Diária");
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setBounds(29, 398, 76, 15);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_3);
		
		textfValorDiaria = new JTextField();
		textfValorDiaria.setBounds(128, 394, 136, 23);
		frmCadastroDeQuartos.getContentPane().add(textfValorDiaria);
		textfValorDiaria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(308, 398, 44, 15);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_4);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setForeground(new Color(38, 9, 55));
		cbxEstado.setBounds(356, 394, 114, 23);
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponivel", "Indisponivel"}));
		frmCadastroDeQuartos.getContentPane().add(cbxEstado);
		
		JLabel lblTotalRegistros = new JLabel("");
		lblTotalRegistros.setBounds(0, 0, 0, 0);
		frmCadastroDeQuartos.getContentPane().add(lblTotalRegistros);
		
		
		JLabel lblNewLabel_5 = new JLabel(" Tipo de Quarto");
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(29, 477, 92, 15);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_5);
		
		JComboBox cbxTipoDeQuarto = new JComboBox();
		cbxTipoDeQuarto.setForeground(new Color(38, 9, 55));
		cbxTipoDeQuarto.setBounds(128, 474, 165, 23);
		cbxTipoDeQuarto.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Casal"}));
		
		JComboBox cbxAndar = new JComboBox();
		cbxAndar.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		cbxAndar.setBounds(356, 154, 114, 22);
		frmCadastroDeQuartos.getContentPane().add(cbxAndar);
		frmCadastroDeQuartos.getContentPane().add(cbxTipoDeQuarto);
		
		JLabel lblNewLabel_8 = new JLabel(" Capacidade");
		lblNewLabel_8.setForeground(new Color(38, 9, 55));
		lblNewLabel_8.setBounds(29, 557, 76, 15);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblNewLabel_8);
		
		JComboBox cbxCapacidade = new JComboBox();
		cbxCapacidade.setForeground(new Color(38, 9, 55));
		cbxCapacidade.setBounds(128, 554, 164, 23);
		cbxCapacidade.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		frmCadastroDeQuartos.getContentPane().add(cbxCapacidade);
		frmCadastroDeQuartos.getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setForeground(new Color(38, 9, 55));
		btnSalvar.setBackground(new Color(225, 225, 225));
		btnSalvar.setBounds(190, 660, 125, 23);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (textfNumQuarto.getText()== null || textfNumQuarto.getText().length()== 0) {
					JOptionPane.showConfirmDialog(null, "Insira um número do quarto válido");
					textfNumQuarto.requestFocus();
				}
				if (textaDescricao.getText()== null || textfNumQuarto.getText().length()== 0) {
					JOptionPane.showConfirmDialog(null, "Insira um número do quarto válido");
					textaDescricao.requestFocus();
				}
				 try {
					 double precoQuarto = Double.parseDouble(textfValorDiaria.getText());
					 if (textfValorDiaria.getText().length() <= 0) {
			             throw new NumberFormatException();
			         }
			    } catch (NumberFormatException ex) {
			        	  JOptionPane.showConfirmDialog(null, "Insira um preço válido");
			        	  textfValorDiaria.requestFocus();
			              return;
			    }
				 Quarto quarto = new Quarto();
			     QuartoDAO dao = new QuartoDAO();

			        quarto.setNumeroQuarto(textfNumQuarto.getText());
			        quarto.setTipoQuarto((String) cbxTipoDeQuarto.getSelectedItem());
			        quarto.setPrecoQuarto(Double.parseDouble(textfValorDiaria.getText()));
			        quarto.setDescricaoQuarto(textaDescricao.getText());
			        quarto.setAndar(Integer.parseInt((String) cbxAndar.getSelectedItem()));
			        String opcaoSelecionada = cbxEstado.getSelectedItem().toString();
			        if (opcaoSelecionada.equals("Disponivel")) {
			            quarto.setDisponibilidade(true);
			        } else {
			        	quarto.setDisponibilidade(false);
			        }

			        try {
			            QuartoDAO.cadastrarQuarto(quarto);
			            JOptionPane.showMessageDialog(null, "Quarto cadastrado!");
			        } catch (BDException e1) {
			            JOptionPane.showMessageDialog(null, "Erro ao cadastrar quarto");
			            e1.printStackTrace();
			        }
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setForeground(new Color(38, 9, 55));
		btnCancelar.setBackground(new Color(225, 225, 225));
		btnCancelar.setBounds(320, 660, 173, 23);
		frmCadastroDeQuartos.getContentPane().add(btnCancelar);
		
		JLabel lblTotalRegistro = new JLabel("Total Registros");
		lblTotalRegistro.setForeground(new Color(38, 9, 55));
		lblTotalRegistro.setBounds(523, 540, 128, 15);
		lblTotalRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmCadastroDeQuartos.getContentPane().add(lblTotalRegistro);
		

		JLabel lblLogoPequena = new JLabel("");
		lblLogoPequena.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/logo 220 x150.png")));
		lblLogoPequena.setBounds(897, 549, 220, 150);
		frmCadastroDeQuartos.getContentPane().add(lblLogoPequena);
		
		JButton btnMenuPrincipal = new JButton("Menu");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				frmCadastroDeQuartos.dispose();
			}
		});
		btnMenuPrincipal.setBackground(new Color(255, 128, 64));
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.setBounds(0, 0, 65, 23);
		frmCadastroDeQuartos.getContentPane().add(btnMenuPrincipal);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmCadastroDeQuartos.dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		frmCadastroDeQuartos.getContentPane().add(btnFecharTela);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				frmCadastroDeQuartos.dispose();
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnNewButton.setBounds(1211, 0, 30, 30);
		frmCadastroDeQuartos.getContentPane().add(btnNewButton);
		
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		frmCadastroDeQuartos.getContentPane().add(lblLogoTransparente);
		
		
	}
}
