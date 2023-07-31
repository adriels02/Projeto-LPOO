package cadastroGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bdConexao.Validador;
import cadastroCORE.CadastroController;
import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtfNome;
	private JTextField txtfCpf;
	private JTextField txtfDataNascimento;
	private JTextField txtfTelefone;
	private JTextField txtfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInterface frame = new CadastroInterface();
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
	public CadastroInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroInterface.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 411);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtfNome.setText("");
				txtfDataNascimento.setText("");
				txtfCpf.setText("");
				txtfEmail.setText("");
				txtfTelefone.setText("");
				
				
				txtfNome.requestFocus();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(315, 379, 110, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(38, 9, 55));
		lblNewLabel.setBounds(71, 66, 487, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(71, 185, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		txtfNome = new JTextField();
		txtfNome.setBounds(71, 205, 487, 23);
		contentPane.add(txtfNome);
		txtfNome.setColumns(10);
		
		Validador validadorNome = new Validador(45);
        txtfNome.setDocument(validadorNome);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setBounds(71, 258, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(38, 9, 55));
		lblNewLabel_4.setBounds(211, 258, 133, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(38, 9, 55));
		lblNewLabel_5.setBounds(362, 258, 63, 14);
		contentPane.add(lblNewLabel_5);
		
		txtfCpf = new JTextField();
		txtfCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtfCpf.setBounds(71, 277, 134, 23);
		contentPane.add(txtfCpf);
		txtfCpf.setColumns(10);
		Validador validadorCpf = new Validador(11);
		txtfCpf.setDocument(validadorCpf);
		
		
		txtfTelefone = new JTextField();
		txtfTelefone.addKeyListener(new KeyAdapter() {
			
			
		});
		txtfTelefone.setBounds(362, 277, 201, 23);
		contentPane.add(txtfTelefone);
		txtfTelefone.setColumns(10);
		Validador validadorTelefone = new Validador(20);
		txtfTelefone.setDocument(validadorTelefone);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setForeground(new Color(38, 9, 55));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(71, 325, 81, 14);
		contentPane.add(lblNewLabel_6);
		
		txtfEmail = new JTextField();
		txtfEmail.setBounds(71, 345, 492, 23);
		contentPane.add(txtfEmail);
		txtfEmail.setColumns(10);
		Validador validadorEmail = new Validador(40);
		txtfEmail.setDocument(validadorEmail);
		
		JButton bntFinalizarCadastro = new JButton("Finalizar");
		bntFinalizarCadastro.setBackground(new Color(225, 225, 225));
		bntFinalizarCadastro.setForeground(new Color(38, 9, 55));
		bntFinalizarCadastro.setBounds(432, 379, 131, 23);
		
		try {
	        MaskFormatter dataFormato = new MaskFormatter("##/##/####");
	        JFormattedTextField dataNascimentoField = new JFormattedTextField(dataFormato);
	        dataNascimentoField.setBounds(210, 277, 147, 23);
	        contentPane.add(dataNascimentoField);
	        txtfDataNascimento = dataNascimentoField;
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Formato de data inconpatível");
	    }
		
		

		bntFinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		boolean sucesso;
				try {
					CadastroController cadastroController = new CadastroController();
					sucesso = cadastroController.cadastrarCliente(txtfNome.getText(), txtfCpf.getText(), txtfTelefone.getText(),txtfEmail.getText(),txtfDataNascimento.getText());
					if (sucesso) {
						JOptionPane.showMessageDialog(null,"Cadastro concluído com sucesso");
						txtfNome.setText("");
						txtfDataNascimento.setText("");
						txtfCpf.setText("");
						txtfEmail.setText("");
						txtfTelefone.setText("");
						
						
						txtfNome.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
					}
				} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro");
			}
			}	
		});
		bntFinalizarCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(bntFinalizarCadastro);
		
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel_18);
		
		JButton btnCadastrarDependentes = new JButton("Cadastro Dependentes");
		btnCadastrarDependentes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarDependentes.setForeground(new Color(38, 9, 55));
		btnCadastrarDependentes.setBackground(new Color(225, 225, 225));
		btnCadastrarDependentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceCadastroDependentes ich = new InterfaceCadastroDependentes();
				ich.setVisible(true);
				dispose();
			}
		});
		btnCadastrarDependentes.setBounds(384, 459, 179, 23);
		contentPane.add(btnCadastrarDependentes);
		
		JButton btnNenuPrincipal = new JButton("Menu");
		btnNenuPrincipal.setBounds(0, 0, 65, 23);
		contentPane.add(btnNenuPrincipal);
		btnNenuPrincipal.setBackground(new Color(255, 128, 64));
		btnNenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNenuPrincipal.setForeground(new Color(255, 255, 255));
		btnNenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		
						
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		contentPane.add(btnFecharTela);
		
		JButton btnSigOut = new JButton("");
		btnSigOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();

			}
		});
		btnSigOut.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSigOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSigOut);
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(CadastroInterface.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(712, 208, 480, 320);
		contentPane.add(lblLogoTelas);
		
		JLabel lblNewLabel_2 = new JLabel("Dados do Cliente");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(72, 160, 133, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Adicionar Dependentes");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(71, 461, 179, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("* Finalize o cadastro antes de adicionar um dependente");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(211, 434, 351, 14);
		contentPane.add(lblNewLabel_8);
		

		
	
		

	}
}
