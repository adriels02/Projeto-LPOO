package servicosGui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.TelaInicial;
import servicosCore.Restaurante;
import servicosCore.ServicoDeQuarto;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class InterfaceServicoDeQuarto extends JFrame {

	private JPanel contentPane;

	DefaultListModel<String> historicoServicos = new DefaultListModel<>();

	
	private ButtonGroup grupoBotoesRefeicao = new ButtonGroup();
	private JTextField txtObservacoes;
	private JTextField txtIDQuarto;
	private JTable table;
	private JTextField textField;

	
	
	
	
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
					InterfaceServicoDeQuarto frame = new InterfaceServicoDeQuarto();
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
	public InterfaceServicoDeQuarto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 551);
		setBounds(100, 100, 653, 453);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblTituloServicoQuarto = new JLabel("Serviço de Quarto");
				lblTituloServicoQuarto.setForeground(new Color(38, 9, 55));
				lblTituloServicoQuarto.setBounds(51, 78, 291, 42);
				lblTituloServicoQuarto.setFont(new Font("Tahoma", Font.BOLD, 30));
				contentPane.add(lblTituloServicoQuarto);
						
						JLabel lblError = new JLabel("");
						lblError.setBounds(0, 0, 0, 0);
						lblError.setForeground(new Color(255, 0, 0));
						contentPane.add(lblError);
				
						JLabel lblNewLabel_2 = new JLabel("Observação");
						lblNewLabel_2.setForeground(new Color(38, 9, 55));
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_2.setBounds(298, 370, 113, 14);
						contentPane.add(lblNewLabel_2);
				
						JLabel lblTituloHistorico = new JLabel("Histórico de Serviços");
						lblTituloHistorico.setForeground(new Color(38, 9, 55));
						lblTituloHistorico.setHorizontalAlignment(SwingConstants.RIGHT);
						lblTituloHistorico.setFont(new Font("Tahoma", Font.BOLD, 14));
						lblTituloHistorico.setBounds(1065, 113, 179, 14);
						contentPane.add(lblTituloHistorico);
				
				JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
				rdbtnCafeDaManha.setBackground(new Color(255, 255, 255));
				rdbtnCafeDaManha.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnCafeDaManha.setForeground(new Color(38, 9, 55));
				rdbtnCafeDaManha.setBounds(51, 218, 113, 23);
				grupoBotoesRefeicao.add(rdbtnCafeDaManha);
				contentPane.add(rdbtnCafeDaManha);
		
				txtObservacoes = new JTextField();
				txtObservacoes.setBounds(298, 393, 271, 20);
				contentPane.add(txtObservacoes);
				txtObservacoes.setColumns(10);
				
				JButton btnRemoverHistorico = new JButton("Remover");
				btnRemoverHistorico.setForeground(new Color(38, 9, 55));
				btnRemoverHistorico.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnRemoverHistorico.setBounds(1153, 650, 91, 23);
				
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(607, 134, 637, 504);
								contentPane.add(scrollPane);
								
								table = new JTable();
								scrollPane.setViewportView(table);
						
								JRadioButton rdbtnAlmoco = new JRadioButton("Almoço");
								rdbtnAlmoco.setBackground(new Color(255, 255, 255));
								rdbtnAlmoco.setFont(new Font("Tahoma", Font.BOLD, 11));
								rdbtnAlmoco.setForeground(new Color(38, 9, 55));
								rdbtnAlmoco.setBounds(51, 269, 76, 23);
								grupoBotoesRefeicao.add(rdbtnAlmoco);
								contentPane.add(rdbtnAlmoco);
				
						JRadioButton rdbtnJantar = new JRadioButton("Jantar");
						rdbtnJantar.setBackground(new Color(255, 255, 255));
						rdbtnJantar.setFont(new Font("Tahoma", Font.BOLD, 11));
						rdbtnJantar.setForeground(new Color(38, 9, 55));
						rdbtnJantar.setBounds(51, 322, 65, 23);
						grupoBotoesRefeicao.add(rdbtnJantar);
						contentPane.add(rdbtnJantar);
						
						JLabel lblNewLabel_5 = new JLabel("Id Reserva");
						lblNewLabel_5.setForeground(new Color(38, 9, 55));
						lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_5.setBounds(298, 186, 113, 14);
						contentPane.add(lblNewLabel_5);
				
						JLabel lblNewLabel_4 = new JLabel("Nº do Quarto");
						lblNewLabel_4.setForeground(new Color(38, 9, 55));
						lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel_4.setBounds(298, 272, 91, 14);
						contentPane.add(lblNewLabel_4);
		
				txtIDQuarto = new JTextField();
				txtIDQuarto.setBounds(298, 294, 136, 21);
				txtIDQuarto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				contentPane.add(txtIDQuarto);
				txtIDQuarto.setColumns(10);
		
				
						JButton btnAdicionar = new JButton("Adicionar");
						btnAdicionar.setForeground(new Color(38, 9, 55));
						btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
						btnAdicionar.setBounds(478, 434, 91, 23);
						
						
						textField = new JTextField();
						textField.setBounds(298, 208, 271, 20);
						contentPane.add(textField);
						textField.setColumns(10);
						contentPane.add(btnAdicionar);
				btnRemoverHistorico.setEnabled(false);
				contentPane.add(btnRemoverHistorico);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						InterfaceServicos interfaceServicos = new InterfaceServicos();
						interfaceServicos.setVisible(true);
						dispose();
					}
				});
				btnNewButton.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/Botao servicos 65x23.png")));
				btnNewButton.setBounds(0, 0, 65, 23);
				contentPane.add(btnNewButton);
				
				JButton btnFecharTela = new JButton("");
				btnFecharTela.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				btnFecharTela.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
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
				btnSignOut.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
				btnSignOut.setBounds(1213, 0, 30, 30);
				contentPane.add(btnSignOut);
				
				JLabel lblLogoPequena = new JLabel("");
				lblLogoPequena.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/logo 220 x150.png")));
				lblLogoPequena.setBounds(45, 496, 220, 150);
				contentPane.add(lblLogoPequena);
			
				
				
				
				JLabel lblLogoTransparente = new JLabel("");
				lblLogoTransparente.setIcon(new ImageIcon(InterfaceServicoDeQuarto.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
				lblLogoTransparente.setBounds(160, 0, 758, 758);
				contentPane.add(lblLogoTransparente);
				

		
		
		
		
		
	}

}