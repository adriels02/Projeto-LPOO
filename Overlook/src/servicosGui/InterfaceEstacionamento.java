package servicosGui;

import java.awt.Color;
import servicosCore.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdConexao.Validador;
import interfaces.TelaInicial;
import servicosCore.CoreException;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InterfaceEstacionamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidadeVeiculos;
	private JTextField txtIdReserva;

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
					InterfaceEstacionamento frame = new InterfaceEstacionamento();
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
	public InterfaceEstacionamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceEstacionamento.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 342);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Estacionamento");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(115, 126, 234, 42);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblErro = new JLabel("");
		lblErro.setBounds(0, 0, 0, 0);
		lblErro.setForeground(new Color(255, 0, 0));
		contentPane.add(lblErro);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de veículos");
		lblNewLabel_2.setForeground(new Color(38, 9, 55));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(82, 365, 143, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Reserva");
		lblNewLabel_3.setForeground(new Color(38, 9, 55));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(140, 298, 73, 23);
		contentPane.add(lblNewLabel_3);
		
		txtQuantidadeVeiculos = new JTextField();
		txtQuantidadeVeiculos.setBounds(219, 366, 130, 20);
		txtQuantidadeVeiculos.setDocument(new Validador(2));
		txtQuantidadeVeiculos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
		contentPane.add(txtQuantidadeVeiculos);
		txtQuantidadeVeiculos.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(225, 225, 225));
		btnAdicionar.setForeground(new Color(38, 9, 55));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(219, 474, 130, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String numeroId = txtIdReserva.getText();
				if (numeroId.equals("")) {
					numeroId = "0";
				}
				
				String numeroVagas = txtQuantidadeVeiculos.getText();
				if (numeroVagas.equals("")) {
					numeroVagas = "0";
				}

				int id = Integer.parseInt(numeroId);
				int vagas = Integer.parseInt(numeroVagas);		
				
				try {
					
					ControladorDeAcessos controlador = new ControladorDeAcessos();
					controlador.registroServicoEstacionamento(id, vagas);
					
					JOptionPane.showMessageDialog(null, "Registro feito com sucesso.");
					txtIdReserva.setText("");
					txtQuantidadeVeiculos.setText("");
				}	catch (CoreException exception) {
					
					JOptionPane.showMessageDialog(null, exception.getMessage());
					
				}
				
				
			}
		});
		
		txtIdReserva = new JTextField();
		txtIdReserva.setBounds(219, 299, 130, 20);
		txtIdReserva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
		contentPane.add(txtIdReserva);
		txtIdReserva.setColumns(10);
		contentPane.add(btnAdicionar);
		
		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(InterfaceEstacionamento.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(664, 210, 480, 320);
		contentPane.add(lblLogoTelas);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterfaceServicos interfaceServicos = new InterfaceServicos();
				interfaceServicos.setVisible(true);
				dispose();	
	
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(InterfaceEstacionamento.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(InterfaceEstacionamento.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		
		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(InterfaceEstacionamento.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
		btnSignOut.setIcon(new ImageIcon(InterfaceEstacionamento.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);
		

		

	}
}
