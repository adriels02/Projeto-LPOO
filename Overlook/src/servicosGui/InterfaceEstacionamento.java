package servicosGui;

import java.awt.Color;
import servicosCore.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import servicosCore.ServicosException;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
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
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
				JLabel lblNewLabel = new JLabel("<<< Voltar");
				lblNewLabel.setBounds(6, 6, 65, 16);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						InterfaceServicos interfaceServicos = new InterfaceServicos();
						interfaceServicos.setVisible(true);
						dispose();

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						lblNewLabel.setForeground(Color.red);

					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblNewLabel.setForeground(Color.black);
					}
				});
				contentPane.setLayout(null);
				contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estacionamento");
		lblNewLabel_1.setBounds(180, 6, 124, 60);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblErro = new JLabel("");
		lblErro.setBounds(0, 0, 0, 0);
		lblErro.setForeground(new Color(255, 0, 0));
		contentPane.add(lblErro);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de veículos:");
		lblNewLabel_2.setBounds(110, 86, 116, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Reserva:");
		lblNewLabel_3.setBounds(305, 86, 73, 55);
		contentPane.add(lblNewLabel_3);
		
		txtQuantidadeVeiculos = new JTextField();
		txtQuantidadeVeiculos.setBounds(140, 153, 54, 20);
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
		btnAdicionar.setBounds(164, 241, 173, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				lblErro.setText("");
				
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
					controlador.registroServiçoTranslado(id, vagas);
					
				}	catch (ServicosException exception) {
					
					lblErro.setText(exception.getMessage());
					
				}
				
				
			}
		});
		
		txtIdReserva = new JTextField();
		txtIdReserva.setBounds(305, 153, 54, 20);
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
	}
}
