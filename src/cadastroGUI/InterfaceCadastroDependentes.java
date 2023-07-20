package cadastroGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastroCORE.CadastroController;
import interfaces.MenuPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceCadastroDependentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtfNomeDependente;
	private JTextField txtfCpfTitular;
	private JTextField txtfCpfDependente;
	private JTextField txtfDataNascimentoDependente;
	private JTextField txtfTelefoneDependente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastroDependentes frame = new InterfaceCadastroDependentes();
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
	public InterfaceCadastroDependentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 423);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface cd = new CadastroInterface();
				cd.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Dependentes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo");
		lblNewLabel_1.setBounds(10, 38, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txtfNomeDependente = new JTextField();
		txtfNomeDependente.setBounds(10, 63, 375, 20);
		contentPane.add(txtfNomeDependente);
		txtfNomeDependente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF do Titular");
		lblNewLabel_2.setBounds(395, 38, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		txtfCpfTitular = new JTextField();
		txtfCpfTitular.setBounds(395, 63, 216, 20);
		contentPane.add(txtfCpfTitular);
		txtfCpfTitular.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF do Dependente");
		lblNewLabel_3.setBounds(10, 94, 148, 14);
		contentPane.add(lblNewLabel_3);
		
		txtfCpfDependente = new JTextField();
		txtfCpfDependente.setBounds(10, 119, 178, 20);
		contentPane.add(txtfCpfDependente);
		txtfCpfDependente.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Concluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface ci = new CadastroInterface();
				ci.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(522, 300, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Data Nascimento");
		lblNewLabel_4.setBounds(198, 94, 132, 14);
		contentPane.add(lblNewLabel_4);
		
		txtfDataNascimentoDependente = new JTextField();
		txtfDataNascimentoDependente.setBounds(198, 119, 187, 20);
		contentPane.add(txtfDataNascimentoDependente);
		txtfDataNascimentoDependente.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setBounds(395, 94, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtfTelefoneDependente = new JTextField();
		txtfTelefoneDependente.setBounds(395, 119, 216, 20);
		contentPane.add(txtfTelefoneDependente);
		txtfTelefoneDependente.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean sucesso;
				try {
					CadastroController cadastroController = new CadastroController();
					sucesso = cadastroController.cadastrarCliente(txtfNomeDependente.getText(), txtfCpfTitular.getText(), txtfCpfDependente.getText(),txtfTelefoneDependente.getText(),txtfDataNascimentoDependente.getText());
					if (sucesso) {
						JOptionPane.showMessageDialog(null,"Cadastro concluído com sucesso");
						txtfNomeDependente.setText("");
						txtfDataNascimentoDependente.setText("");
						txtfCpfTitular.setText("");
						txtfCpfDependente.setText("");
						txtfTelefoneDependente.setText("");
					
						
						txtfNomeDependente.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar o dependente");
					}
				} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro: " + ex);
			}
				
			}
		});
		btnNewButton_2.setBounds(522, 169, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Novo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfNomeDependente.setText("");
				txtfDataNascimentoDependente.setText("");
				txtfCpfTitular.setText("");
				txtfCpfDependente.setText("");
				txtfTelefoneDependente.setText("");
				
				
				txtfNomeDependente.requestFocus();
			}
		});
		btnNewButton_3.setBounds(423, 169, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}