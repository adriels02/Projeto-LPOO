package quartoGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import javax.swing.JScrollPane;

public class InterfaceCadastroDeQuartos {

	public JFrame frmCadastroDeQuartos;
	private JTextField textfNumQuarto;
	private JTextField textfValorDiaria;
	private JTextField textfPesquisar;
	private JTable table;
	private JTable tbLista;
	private JTextField textfTipoDeQuarto;

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
	 * @throws BDException 
	 */
	public InterfaceCadastroDeQuartos()  {
		initialize();
		
		 DefaultTableModel modelo =(DefaultTableModel) tbLista.getModel();;
		 QuartoDAO quartoDAO = new QuartoDAO();
			try {
				modelo = quartoDAO.carregarTabela();
				 tbLista.setModel(modelo);
			} catch (BDException e1) {
				 JOptionPane.showMessageDialog(null, "Erro ao carregar!");
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
		textfNumQuarto.transferFocus();
		
		JLabel lblAndar = new JLabel("Andar");
		lblAndar.setForeground(new Color(38, 9, 55));
		lblAndar.setBounds(308, 158, 44, 15);
		lblAndar.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblAndar);
		
		JComboBox cbxAndar = new JComboBox();
		cbxAndar.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		cbxAndar.setBounds(356, 154, 114, 22);
		frmCadastroDeQuartos.getContentPane().add(cbxAndar);
		cbxAndar.transferFocus();
		
		JLabel lblDescricao = new JLabel(" Descrição ");
		lblDescricao.setForeground(new Color(38, 9, 55));
		lblDescricao.setBounds(29, 210, 69, 15);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblDescricao);
		
		JTextArea textaDescricao = new JTextArea();
		textaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textaDescricao.setBackground(new Color(240, 240, 240));
		textaDescricao.setBounds(98, 210, 372, 138);
		frmCadastroDeQuartos.getContentPane().add(textaDescricao);
		
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(225, 225, 225));
		btnEditar.setForeground(new Color(38, 9, 55));
		btnEditar.setBounds(1125, 154, 120, 23);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnEditar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(522, 210, 723, 312);
		frmCadastroDeQuartos.getContentPane().add(scrollPane);
		
		tbLista = new JTable();
		scrollPane.setViewportView(tbLista);
		tbLista.setBackground(new Color(240, 240, 240));
		QuartoDAO quartoDAO = new QuartoDAO();
	    DefaultTableModel modelo =(DefaultTableModel) tbLista.getModel();;
		try {
			modelo = quartoDAO.carregarTabela();
			 tbLista.setModel(modelo);
		} catch (BDException e1) {
			 JOptionPane.showMessageDialog(null, "Erro ao carregar!");
		}
		tbLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Quarto", "Andar", "Tipo de Quarto", "Estado", "Valor Di\u00E1ria", "Capacidade", "Descri\u00E7\u00E3o"
			}
		));
			
		tbLista.getColumnModel().getColumn(0).setPreferredWidth(60);
		tbLista.getColumnModel().getColumn(1).setPreferredWidth(60);
		tbLista.getColumnModel().getColumn(2).setPreferredWidth(130);
		tbLista.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbLista.getColumnModel().getColumn(4).setPreferredWidth(105);
		tbLista.getColumnModel().getColumn(5).setPreferredWidth(80);
		tbLista.getColumnModel().getColumn(6).setPreferredWidth(125);
		
		JLabel lblValorDiaria = new JLabel(" Valor Diária");
		lblValorDiaria.setForeground(new Color(38, 9, 55));
		lblValorDiaria.setBounds(29, 398, 76, 15);
		lblValorDiaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblValorDiaria);
		
		textfValorDiaria = new JTextField();
		textfValorDiaria.setBounds(128, 394, 136, 23);
		frmCadastroDeQuartos.getContentPane().add(textfValorDiaria);
		textfValorDiaria.setColumns(10);
		textfValorDiaria.transferFocus();
		
		JLabel lbEstado = new JLabel("Estado");
		lbEstado.setForeground(new Color(38, 9, 55));
		lbEstado.setBounds(308, 398, 44, 15);
		lbEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lbEstado);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setForeground(new Color(38, 9, 55));
		cbxEstado.setBounds(356, 394, 114, 23);
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponivel", "Indisponivel"}));
		frmCadastroDeQuartos.getContentPane().add(cbxEstado);
		cbxEstado.transferFocus();
		
		JLabel lblTipoDeQuarto = new JLabel(" Tipo de Quarto");
		lblTipoDeQuarto.setForeground(new Color(38, 9, 55));
		lblTipoDeQuarto.setBounds(29, 477, 92, 15);
		lblTipoDeQuarto.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblTipoDeQuarto);
		
		JLabel lblCapacidade = new JLabel(" Capacidade");
		lblCapacidade.setForeground(new Color(38, 9, 55));
		lblCapacidade.setBounds(29, 557, 76, 15);
		lblCapacidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmCadastroDeQuartos.getContentPane().add(lblCapacidade);
		
		JComboBox cbxCapacidade = new JComboBox();
		cbxCapacidade.setForeground(new Color(38, 9, 55));
		cbxCapacidade.setBounds(128, 554, 164, 23);
		cbxCapacidade.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		frmCadastroDeQuartos.getContentPane().add(cbxCapacidade);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setForeground(new Color(38, 9, 55));
		btnSalvar.setBackground(new Color(225, 225, 225));
		btnSalvar.setBounds(190, 660, 162, 23);
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

			        quarto.setNumeroQuarto(Integer.parseInt(textfNumQuarto.getText()));
			        quarto.setTipoQuarto(textfTipoDeQuarto.getText());
			        quarto.setPrecoQuarto(Double.parseDouble(textfValorDiaria.getText()));
			        quarto.setDescricaoQuarto(textaDescricao.getText());
			        quarto.setAndar(Integer.parseInt((String) cbxAndar.getSelectedItem()));
			        quarto.setCapacidade(Integer.parseInt((String) cbxCapacidade.getSelectedItem()));
			        String opcaoSelecionada = cbxEstado.getSelectedItem().toString();
			        if (opcaoSelecionada.equals("Disponivel")) {
			            quarto.setDisponibilidade(true);
			        } else {
			        	quarto.setDisponibilidade(false);
			        }

			        try {
			            QuartoDAO.cadastrarQuarto(quarto);
			
			            JOptionPane.showMessageDialog(null, "Quarto cadastrado!");
			            textfNumQuarto.setText("");
			            textfTipoDeQuarto.setText("");
			            textaDescricao.setText("");
			            textfValorDiaria.setText("");
			            
			        } catch (BDException e1) {
			            JOptionPane.showMessageDialog(null, "Erro ao cadastrar quarto");
			            e1.printStackTrace();
			        }
			}
		});
		frmCadastroDeQuartos.getContentPane().add(btnSalvar);
		

		JLabel lblLogoPequena = new JLabel("");
		lblLogoPequena.setIcon(new ImageIcon(InterfaceCadastroDeQuartos.class.getResource("/interfaces/imagens/logo 220 x150.png")));
		lblLogoPequena.setBounds(897, 557, 220, 142);
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
		
		textfTipoDeQuarto = new JTextField();
		textfTipoDeQuarto.setBounds(128, 474, 136, 20);
		frmCadastroDeQuartos.getContentPane().add(textfTipoDeQuarto);
		textfTipoDeQuarto.setColumns(10);
	}
	
	
	
}
