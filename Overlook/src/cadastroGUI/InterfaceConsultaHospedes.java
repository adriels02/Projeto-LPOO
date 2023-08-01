package cadastroGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cadastroBD.CadastroClienteDAO;
import cadastroBD.CadastroDependenteDAO;
import cadastroBD.ExceptionDAO;
import cadastroCORE.CadastroController;
import cadastroCORE.CadastroControllerDependentes;
import cadastroCORE.Cliente;
import cadastroCORE.Dependentes;
import interfaces.MenuPrincipal;
import interfaces.TelaInicial;

public class InterfaceConsultaHospedes extends JFrame {

    private JPanel contentPane;
    private JTextField textfConsultaCpf;
    private JTable table;
    private JTextField txtfConsultaDependentes;
    private JTable table_dependentes;

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

    public InterfaceConsultaHospedes() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/iconeOverlook.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 676, 458);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton_3 = new JButton("Alterar");
        btnNewButton_3.setBackground(new Color(225, 225, 225));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_3.setForeground(new Color(38, 9, 55));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarCadastro();
            }
        });

        table_dependentes = new JTable();
        table_dependentes.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "CPF", "Nome", "Telefone", "Data Nascimento", "CPF Titular" }
        ));
        table_dependentes.setBounds(34, 515, 633, 171);
        contentPane.add(table_dependentes);
        btnNewButton_3.setBounds(584, 341, 89, 23);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Limpar");
        btnNewButton_4.setForeground(new Color(38, 9, 55));
        btnNewButton_4.setBackground(new Color(225, 225, 225));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textfConsultaCpf.setText("");
                textfConsultaCpf.requestFocus();
            }
        });
        
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4.setBounds(288, 341, 89, 23);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_2 = new JButton("Apagar");
        btnNewButton_2.setBackground(new Color(225, 225, 225));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setForeground(new Color(38, 9, 55));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apagarCadastro();
            }
        });
        btnNewButton_2.setBounds(486, 341, 89, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton = new JButton("Atualizar");
        btnNewButton.setForeground(new Color(38, 9, 55));
        btnNewButton.setBackground(new Color(225, 225, 225));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarTodosHospedes();
                
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(387, 341, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2_1 = new JButton("Apagar");
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		apagarDependente();
        	}
        });
        btnNewButton_2_1.setForeground(new Color(38, 9, 55));
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2_1.setBackground(new Color(225, 225, 225));
        btnNewButton_2_1.setBounds(489, 674, 89, 23);
        contentPane.add(btnNewButton_2_1);

        JButton btnNewButton_4_1 = new JButton("Limpar");
        btnNewButton_4_1.setBackground(new Color(225, 225, 225));
        btnNewButton_4_1.setForeground(new Color(38, 9, 55));
        btnNewButton_4_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtfConsultaDependentes.setText("");
                txtfConsultaDependentes.requestFocus();
        	}
        });
        btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4_1.setBounds(291, 674, 89, 23);
        contentPane.add(btnNewButton_4_1);

        txtfConsultaDependentes = new JTextField();
        txtfConsultaDependentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtfConsultaDependentes.setColumns(10);
        txtfConsultaDependentes.setBounds(335, 450, 242, 23);
        contentPane.add(txtfConsultaDependentes);

        JButton bttConsultarDependentes = new JButton("Consultar");
        bttConsultarDependentes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarDependentes();
            }
        });
        bttConsultarDependentes.setForeground(new Color(38, 9, 55));
        bttConsultarDependentes.setFont(new Font("Tahoma", Font.BOLD, 11));
        bttConsultarDependentes.setBackground(new Color(225, 225, 225));
        bttConsultarDependentes.setBounds(586, 450, 89, 23);
        contentPane.add(bttConsultarDependentes);

        JButton btnNewButton_5 = new JButton("Atualizar");
        btnNewButton_5.setBackground(new Color(225, 225, 225));
        btnNewButton_5.setForeground(new Color(38, 9, 55));
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		consultarTodosDependentes();
        	}
        });
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_5.setBounds(390, 674, 89, 23);
        contentPane.add(btnNewButton_5);

        JButton btnNewButton_3_1 = new JButton("Alterar");
        btnNewButton_3_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		alterarDependente();
        	}
        });
        btnNewButton_3_1.setForeground(new Color(38, 9, 55));
        btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_3_1.setBackground(new Color(225, 225, 225));
        btnNewButton_3_1.setBounds(587, 674, 89, 23);
        contentPane.add(btnNewButton_3_1);

        JLabel lblInforme_1 = new JLabel("Informe o CPF do hóspede que deseja consultar");
        lblInforme_1.setForeground(new Color(38, 9, 55));
        lblInforme_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInforme_1.setBounds(43, 454, 282, 14);
        contentPane.add(lblInforme_1);

        JLabel lblTituloHospedes = new JLabel("Consultar Hóspede");
        lblTituloHospedes.setForeground(new Color(38, 9, 55));
        lblTituloHospedes.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTituloHospedes.setBounds(40, 63, 314, 42);
        contentPane.add(lblTituloHospedes);

        JLabel lblInforme = new JLabel("Informe o CPF do hóspede que deseja consultar");
        lblInforme.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInforme.setForeground(new Color(38, 9, 55));
        lblInforme.setBounds(40, 121, 282, 14);
        contentPane.add(lblInforme);

        textfConsultaCpf = new JTextField();
        textfConsultaCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textfConsultaCpf.setBounds(332, 117, 242, 23);
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
        btnNewButton_1.setBounds(583, 117, 89, 23);
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
        scrollPane.setBounds(40, 151, 635, 171);
        contentPane.add(scrollPane);

        JButton btnFecharTela = new JButton("");
        btnFecharTela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnFecharTela.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
        btnFecharTela.setBounds(1250, 0, 30, 30);
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
        btnSignOut.setBounds(1213, 0, 30, 30);
        contentPane.add(btnSignOut);

        JLabel lblLogoTelas = new JLabel("");
        lblLogoTelas.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
        lblLogoTelas.setBounds(750, 170, 480, 320);
        contentPane.add(lblLogoTelas);

        JButton btnMenuPrincipal = new JButton("Menu");
        btnMenuPrincipal.setBounds(2, 1, 65, 23);
        contentPane.add(btnMenuPrincipal);
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

        JLabel lblConsultarDependentes = new JLabel("Consultar Dependentes");
        lblConsultarDependentes.setForeground(new Color(38, 9, 55));
        lblConsultarDependentes.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblConsultarDependentes.setBounds(37, 397, 439, 42);
        contentPane.add(lblConsultarDependentes);

        JScrollPane scrollPane_1 = new JScrollPane(table_dependentes);
        scrollPane_1.setBounds(40, 492, 633, 171);
        contentPane.add(scrollPane_1);

        String[] colunasDependentes = { "CPF", "Nome", "Telefone", "Data Nascimento", "CPF Titular" };
        DefaultTableModel modelDependentes = new DefaultTableModel(colunasDependentes, 0) {
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        table_dependentes.setModel(modelDependentes);
        
                JLabel lblLogoTransparente = new JLabel("0");
                lblLogoTransparente.setIcon(new ImageIcon(InterfaceConsultaHospedes.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
                lblLogoTransparente.setBounds(0, 0, 758, 758);
                contentPane.add(lblLogoTransparente);

        consultarTodosHospedes();
        consultarTodosDependentes();
    }

    private void consultarHospedes() {
        try {
            if (textfConsultaCpf.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo de consulta em branco");
            } else {
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
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes");
        }
    }

    private void apagarCadastro() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para apagar o cadastro.");
        }

        try {
            String cpf = (String) table.getValueAt(selectedRow, 0);
            CadastroController cadastroController = new CadastroController();

            cadastroController.apagarCadastro(cpf);

            ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar cadastro");
        }
    }

    private void alterarCadastro() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para alterar o cadastro.");
        }
        boolean sucesso;
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

            CadastroController cadastroController = new CadastroController();
            sucesso = cadastroController.alterarCadastro(nome, cpf, telefone, email, dataNascimento);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro: ");
        }
    }

    private void consultarTodosHospedes() {
        try {
            CadastroClienteDAO dao = new CadastroClienteDAO();
            ArrayList<Cliente> clientes = dao.listarTodosClientes();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado no banco de dados.");
            } else {
                for (Cliente cliente : clientes) {
                    Object[] rowData = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
                            cliente.getEmail(), cliente.getDataNascimento() };
                    model.addRow(rowData);
                }
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes");
        }
    }

    private void consultarDependentes() {
        try {
            if (txtfConsultaDependentes.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo de consulta em branco");
            } else {
                String cpfTitular = txtfConsultaDependentes.getText();
                CadastroDependenteDAO dao = new CadastroDependenteDAO();
                ArrayList<Dependentes> dependentes = dao.listarDependentes(cpfTitular);

                DefaultTableModel model = (DefaultTableModel) table_dependentes.getModel();
                model.setRowCount(0);

                if (dependentes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum dependente encontrado com o CPF do titular informado.");
                } else {
                    for (Dependentes dependente : dependentes) {
                        Object[] rowData = { dependente.getCpfDependente(), dependente.getNomeDependente(), dependente.getTelefoneDependente(),
                                dependente.getDataNascimentoDependente(), dependente.getCpfTitular() };
                        model.addRow(rowData);
                    }
                }
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar dependentes");
        }
    }
    private void consultarTodosDependentes() {
        try {
            CadastroDependenteDAO dao = new CadastroDependenteDAO();
            ArrayList<Dependentes> dependentes = dao.listarTodosDependentes();

            DefaultTableModel model = (DefaultTableModel) table_dependentes.getModel();
            model.setRowCount(0);

            if (dependentes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado no banco de dados.");
            } else {
                for (Dependentes dependente : dependentes) {
                    Object[] rowData = { dependente.getCpfDependente(), dependente.getNomeDependente(), dependente.getTelefoneDependente(), dependente.getDataNascimentoDependente(), dependente.getCpfTitular()};
                    model.addRow(rowData);
                }
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes");
        }
    }
    
    private void alterarDependente() {
        int selectedRow = table_dependentes.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um dependente na tabela para alterar o cadastro.");
        }
        boolean sucesso;
        try {
            String cpfDependente = (String) table_dependentes.getValueAt(selectedRow, 0);
            String nomeDependente = (String) table_dependentes.getValueAt(selectedRow, 1);
            String telefoneDependente = (String) table_dependentes.getValueAt(selectedRow, 2);
            java.sql.Date dataNascimentoDependente = (java.sql.Date) table_dependentes.getValueAt(selectedRow, 3);
            String cpfTitular = (String) table_dependentes.getValueAt(selectedRow, 4);

            Dependentes dependente = new Dependentes();
            dependente.setCpfDependente(cpfDependente);
            dependente.setNomeDependente(nomeDependente);
            dependente.setTelefoneDependente(telefoneDependente);
            dependente.setCpfTitular(cpfTitular);
            dependente.setDataNascimento(dataNascimentoDependente);

            CadastroControllerDependentes cadastroControllerDependentes = new CadastroControllerDependentes();
            sucesso = cadastroControllerDependentes.alterarCadastroDependente(nomeDependente,cpfDependente,telefoneDependente,dataNascimentoDependente,cpfTitular);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro");
        }
    }
    
    private void apagarDependente() {
        int selectedRow = table_dependentes.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um dependente na tabela para apagar o cadastro.");
        }

        try {
            String cpf = (String) table_dependentes.getValueAt(selectedRow, 0);
            String cpfTitular = (String) table_dependentes.getValueAt(selectedRow, 4);
            CadastroControllerDependentes cadastroControllerDependente = new CadastroControllerDependentes();

            cadastroControllerDependente.apagarCadastroDependente(cpf,cpfTitular);

            ((DefaultTableModel) table_dependentes.getModel()).removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar cadastro");
        }
    }
    
}
