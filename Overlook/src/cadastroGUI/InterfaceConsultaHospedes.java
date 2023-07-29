package cadastroGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import cadastroCORE.Cliente;

import cadastroBD.CadastroClienteDAO;
import cadastroBD.ExceptionDAO;
import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InterfaceConsultaHospedes extends JFrame {

    private JPanel contentPane;
    private JTextField textfConsultaCpf;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceConsultaHospedes frame = new InterfaceConsultaHospedes();
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
    public InterfaceConsultaHospedes() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/iconeOverlook.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 676, 458);
        setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JButton btnMenuPrincipal = new JButton("Menu");
        btnMenuPrincipal.setForeground(new Color(255, 255, 255));
        btnMenuPrincipal.setBackground(new Color(255, 128, 64));
        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
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

        JLabel lblTituloHospedes = new JLabel("Consultar Hóspede");
        lblTituloHospedes.setForeground(new Color(38, 9, 55));
        lblTituloHospedes.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTituloHospedes.setBounds(26, 164, 314, 42);
        contentPane.add(lblTituloHospedes);

        JLabel lblInforme = new JLabel("Informe o CPF do hóspede que deseja consultar");
        lblInforme.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInforme.setForeground(new Color(38, 9, 55));
        lblInforme.setBounds(26, 255, 282, 14);
        contentPane.add(lblInforme);

        textfConsultaCpf = new JTextField();
        textfConsultaCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textfConsultaCpf.setBounds(318, 253, 242, 20);
        contentPane.add(textfConsultaCpf);
        textfConsultaCpf.setColumns(10);

        JButton btnNewButton_1 = new JButton("Consultar");
        btnNewButton_1.setBackground(new Color(225, 225, 225));
        btnNewButton_1.setForeground(new Color(38, 9, 55));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarHospedes();
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setBounds(569, 252, 89, 23);
        contentPane.add(btnNewButton_1);

        table = new JTable();
        table.setBounds(10, 108, 635, 157);
        contentPane.add(table);

        String[] colunas = { "CPF", "Nome", "Telefone", "Email", "Data Nascimento" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            
            public boolean isCellEditable(int row, int column) {
                return true; 
            }
        };
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(26, 309, 635, 171);
        contentPane.add(scrollPane);

        JButton btnNewButton_2 = new JButton("Apagar");
        btnNewButton_2.setBackground(new Color(225, 225, 225));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setForeground(new Color(38, 9, 55));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apagarCadastro();
            }
        });
        btnNewButton_2.setBounds(472, 499, 89, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Alterar");
        btnNewButton_3.setBackground(new Color(225, 225, 225));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_3.setForeground(new Color(38, 9, 55));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarCadastro();
            }
        });
        btnNewButton_3.setBounds(570, 499, 89, 23);
        contentPane.add(btnNewButton_3);
        
        JButton btnFecharTela = new JButton("");
        btnFecharTela.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnFecharTela.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
        btnSignOut.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
        btnSignOut.setBounds(1195, 11, 30, 30);
        contentPane.add(btnSignOut);
        
        JLabel lblLogoTelas = new JLabel("");
        lblLogoTelas.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
        lblLogoTelas.setBounds(750, 170, 480, 320);
        contentPane.add(lblLogoTelas);
        
        JLabel lblLogoTransparente = new JLabel("0");
        lblLogoTransparente.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
        lblLogoTransparente.setBounds(0, 0, 758, 758);
        contentPane.add(lblLogoTransparente);
    }

    private void consultarHospedes() {
        try {
            String cpf = textfConsultaCpf.getText();
            CadastroClienteDAO dao = new CadastroClienteDAO();
            ArrayList<Cliente> clientes = dao.listarClientes(cpf);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o CPF informado.");
            } else {
                for (Cliente cliente : clientes) {
                    Object[] rowData = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
                            cliente.getEmail(), cliente.getDataNascimento() };
                    model.addRow(rowData);
                }
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void apagarCadastro() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para apagar o cadastro.",
                    "Selecione um Cliente", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String cpf = (String) table.getValueAt(selectedRow, 0);
            CadastroClienteDAO dao = new CadastroClienteDAO();
            Cliente cliente = new Cliente();
            cliente.setCpf(cpf);
            dao.apagarCadastro(cliente);

            ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso.");
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar cadastro: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterarCadastro() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para alterar o cadastro.",
                    "Selecione um Cliente", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String cpf = (String) table.getValueAt(selectedRow, 0);
            String nome = (String) table.getValueAt(selectedRow, 1);
            String telefone = (String) table.getValueAt(selectedRow, 2);
            String email = (String) table.getValueAt(selectedRow, 3);
            java.sql.Date dataNascimento = (java.sql.Date) table.getValueAt(selectedRow, 4);

            Cliente cliente = new Cliente();
            cliente.setCpf(cpf);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setDataNascimento(dataNascimento);

            CadastroClienteDAO dao = new CadastroClienteDAO();
            dao.alterarCadastro(cliente);

            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
