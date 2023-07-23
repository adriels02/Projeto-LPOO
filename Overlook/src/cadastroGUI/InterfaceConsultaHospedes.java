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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 676, 458);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JButton btnNewButton = new JButton("Voltar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        menuBar.add(btnNewButton);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Consultar Hóspede");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(10, 11, 190, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Informe o CPF do hóspede que deseja consultar");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(10, 36, 282, 14);
        contentPane.add(lblNewLabel_2);

        textfConsultaCpf = new JTextField();
        textfConsultaCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textfConsultaCpf.setBounds(288, 34, 259, 20);
        contentPane.add(textfConsultaCpf);
        textfConsultaCpf.setColumns(10);

        JButton btnNewButton_1 = new JButton("Consultar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarHospedes();
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setBounds(556, 33, 89, 23);
        contentPane.add(btnNewButton_1);

        table = new JTable();
        table.setBounds(10, 108, 635, 157);
        contentPane.add(table);

        String[] colunas = { "CPF", "Nome", "Telefone", "Email", "Data Nascimento" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true; 
            }
        };
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 108, 635, 157);
        contentPane.add(scrollPane);

        JButton btnNewButton_2 = new JButton("Apagar");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apagarCadastro();
            }
        });
        btnNewButton_2.setBounds(458, 276, 89, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Alterar");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarCadastro();
            }
        });
        btnNewButton_3.setBounds(556, 276, 89, 23);
        contentPane.add(btnNewButton_3);
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
