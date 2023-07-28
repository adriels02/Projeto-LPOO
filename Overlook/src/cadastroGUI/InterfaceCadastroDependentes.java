package cadastroGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastroCORE.CadastroControllerDepedentes;
import cadastroCORE.Dependentes;
import interfaces.TelaInicial;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceCadastroDependentes.class.getResource("/interfaces/imagens/iconeOverlook.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 637, 423);
        setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JButton btnMenuPrincipal = new JButton("Menu");
        btnMenuPrincipal.setBackground(new Color(255, 128, 64));
        btnMenuPrincipal.setForeground(new Color(255, 255, 255));
        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroInterface cd = new CadastroInterface();
                cd.setVisible(true);
                dispose();
            }
        });
        btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
        menuBar.add(btnMenuPrincipal);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Dependentes");
        lblNewLabel.setForeground(new Color(38, 9, 55));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(47, 146, 389, 42);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nome Completo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setForeground(new Color(38, 9, 55));
        lblNewLabel_1.setBounds(45, 267, 120, 14);
        contentPane.add(lblNewLabel_1);

        txtfNomeDependente = new JTextField();
        txtfNomeDependente.setBounds(45, 292, 375, 23);
        contentPane.add(txtfNomeDependente);
        txtfNomeDependente.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("CPF do Titular");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setForeground(new Color(38, 9, 55));
        lblNewLabel_2.setBounds(430, 267, 106, 14);
        contentPane.add(lblNewLabel_2);

        txtfCpfTitular = new JTextField();
        txtfCpfTitular.setBounds(430, 292, 216, 23);
        contentPane.add(txtfCpfTitular);
        txtfCpfTitular.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("CPF do Dependente");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setForeground(new Color(38, 9, 55));
        lblNewLabel_3.setBounds(45, 353, 148, 14);
        contentPane.add(lblNewLabel_3);

        txtfCpfDependente = new JTextField();
        txtfCpfDependente.setBounds(45, 378, 178, 23);
        contentPane.add(txtfCpfDependente);
        txtfCpfDependente.setColumns(10);

        JButton btnNewButton_1 = new JButton("Concluir");
        btnNewButton_1.setBackground(new Color(225, 225, 225));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setForeground(new Color(38, 9, 55));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroInterface ci = new CadastroInterface();
                ci.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(540, 470, 106, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_4 = new JLabel("Data Nascimento");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_4.setForeground(new Color(38, 9, 55));
        lblNewLabel_4.setBounds(233, 353, 132, 14);
        contentPane.add(lblNewLabel_4);

        txtfDataNascimentoDependente = new JTextField();
        txtfDataNascimentoDependente.setBounds(233, 378, 187, 23);
        contentPane.add(txtfDataNascimentoDependente);
        txtfDataNascimentoDependente.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Telefone");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_5.setForeground(new Color(38, 9, 55));
        lblNewLabel_5.setBounds(430, 353, 82, 14);
        contentPane.add(lblNewLabel_5);

        txtfTelefoneDependente = new JTextField();
        txtfTelefoneDependente.setBounds(430, 378, 216, 23);
        contentPane.add(txtfTelefoneDependente);
        txtfTelefoneDependente.setColumns(10);

        JButton btnNewButton_2 = new JButton("Cadastrar");
        btnNewButton_2.setBackground(new Color(225, 225, 225));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setForeground(new Color(38, 9, 55));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarDependente();
            }
        });
        btnNewButton_2.setBounds(540, 428, 106, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Novo");
        btnNewButton_3.setBackground(new Color(225, 225, 225));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_3.setForeground(new Color(38, 9, 55));
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
        btnNewButton_3.setBounds(431, 428, 99, 23);
        contentPane.add(btnNewButton_3);
        
        JButton btnFecharTela = new JButton("");
        btnFecharTela.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        	}
        });
        btnFecharTela.setIcon(new ImageIcon(InterfaceCadastroDependentes.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
        btnFecharTela.setBounds(1232, 11, 30, 30);
        contentPane.add(btnFecharTela);
        
        JButton btnSignOut = new JButton("");
        btnSignOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();
        	}
        });
        btnSignOut.setIcon(new ImageIcon(InterfaceCadastroDependentes.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
        btnSignOut.setBounds(1195, 11, 30, 30);
        contentPane.add(btnSignOut);
        
        JLabel lblLogoTransparente = new JLabel("");
        lblLogoTransparente.setIcon(new ImageIcon(InterfaceCadastroDependentes.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
        lblLogoTransparente.setBounds(0, 0, 758, 758);
        contentPane.add(lblLogoTransparente);
        
        JLabel lblLogoTelas = new JLabel("");
        lblLogoTelas.setIcon(new ImageIcon(InterfaceCadastroDependentes.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
        lblLogoTelas.setBounds(750, 170, 480, 320);
        contentPane.add(lblLogoTelas);
    }

    private void cadastrarDependente() {
        try {
            String nomeDependente = txtfNomeDependente.getText();
            String cpfTitular = txtfCpfTitular.getText();
            String cpfDependente = txtfCpfDependente.getText();
            String telefoneDependente = txtfTelefoneDependente.getText();
            String dataNascimentoDependenteStr = txtfDataNascimentoDependente.getText();

            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
            java.util.Date parsedDate = dateFormat.parse(dataNascimentoDependenteStr);
            java.sql.Date dataNascimentoDependente = new java.sql.Date(parsedDate.getTime());

            CadastroControllerDepedentes controller = new CadastroControllerDepedentes();
            boolean sucesso = controller.cadastrarDependente(nomeDependente, cpfTitular, cpfDependente, telefoneDependente, dataNascimentoDependente);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso");
                txtfNomeDependente.setText("");
                txtfDataNascimentoDependente.setText("");
                txtfCpfTitular.setText("");
                txtfCpfDependente.setText("");
                txtfTelefoneDependente.setText("");
                txtfNomeDependente.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o dependente");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o dependente: " + ex.getMessage());
        }
    }
}
