package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import serviços.InterfaceRestaurante;
import serviços.InterfaceServiços;
import serviços.InterfaceTranslado;
import serviços.InterfaceWiFi;
import javax.swing.ImageIcon;
import java.awt.Color;
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface interfaceCadastroCliente = new CadastroInterface();
				interfaceCadastroCliente.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionário");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Usuário");
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_1 = new JMenu("Serviços");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Restaurante");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceRestaurante interfaceRestaurante = new InterfaceRestaurante();
				interfaceRestaurante.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Translado");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceTranslado interfaceTranslado = new InterfaceTranslado();
				interfaceTranslado.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("wifi");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceWiFi interfaceWifi =  new InterfaceWiFi();
				interfaceWifi.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Estacionamento");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Arrumação");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Serviço de quarto");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("Reservas");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Check Out");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Controle");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Relatório Geral");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Relatório Clientes");
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Relatório Funcionários");
		mnNewMenu_4.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 18, 0, 0};
		gbl_contentPane.rowHeights = new int[]{45, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Menu Rápido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 7;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaces/imagens/telainicilILUSTRAÇAOPrancheta 9.png")));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Novo Cadastro");
		btnNewButton.setBackground(new Color(223, 223, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInterface cadastroInterface =  new CadastroInterface();
				cadastroInterface.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Novo Serviço");
		btnNewButton_1.setBackground(new Color(223, 223, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceServiços interfaceServicos =  new InterfaceServiços();
				interfaceServicos.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reserva");
		btnNewButton_2.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Check In");
		btnNewButton_3.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 5;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Consulta");
		btnNewButton_5.setBackground(new Color(223, 223, 255));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 6;
		contentPane.add(btnNewButton_5, gbc_btnNewButton_5);
	}
}
