package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import servicosCore.CoreException;
import servicosCore.Wifi;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class InterfaceWiFi extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeSetado;
	private JTextField txtSenhaSetada;
	private JTextField txtNomeGet;
	private JTextField txtSenhaGet;

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
					InterfaceWiFi frame = new InterfaceWiFi();
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
	public InterfaceWiFi() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceWiFi.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 441);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30, 59, 35, 55, 46, 30, 0};
		gbl_contentPane.rowHeights = new int[]{14, 14, 14, 20, 20, 20, 30, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("<<< Voltar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wi-Fi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 6;
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 6;
		gbc_lblError.insets = new Insets(0, 0, 5, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 1;
		contentPane.add(lblError, gbc_lblError);
		
		txtNomeSetado = new JTextField();
		txtNomeSetado.setEditable(false);
		GridBagConstraints gbc_txtNomeSetado = new GridBagConstraints();
		gbc_txtNomeSetado.weightx = 1.0;
		gbc_txtNomeSetado.anchor = GridBagConstraints.EAST;
		gbc_txtNomeSetado.weighty = 1.0;
		gbc_txtNomeSetado.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeSetado.gridwidth = 3;
		gbc_txtNomeSetado.gridx = 0;
		gbc_txtNomeSetado.gridy = 4;
		contentPane.add(txtNomeSetado, gbc_txtNomeSetado);
		txtNomeSetado.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.weighty = 1.0;
		gbc_lblNewLabel_9.weightx = 1.0;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 4;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtNomeGet = new JTextField();
		GridBagConstraints gbc_txtNomeGet = new GridBagConstraints();
		gbc_txtNomeGet.anchor = GridBagConstraints.WEST;
		gbc_txtNomeGet.weighty = 1.0;
		gbc_txtNomeGet.weightx = 1.0;
		gbc_txtNomeGet.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeGet.gridx = 5;
		gbc_txtNomeGet.gridy = 4;
		contentPane.add(txtNomeGet, gbc_txtNomeGet);
		txtNomeGet.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtSenhaSetada = new JTextField();
		txtSenhaSetada.setEditable(false);
		GridBagConstraints gbc_txtSenhaSetada = new GridBagConstraints();
		gbc_txtSenhaSetada.weightx = 1.0;
		gbc_txtSenhaSetada.anchor = GridBagConstraints.EAST;
		gbc_txtSenhaSetada.weighty = 1.0;
		gbc_txtSenhaSetada.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenhaSetada.gridwidth = 3;
		gbc_txtSenhaSetada.gridx = 0;
		gbc_txtSenhaSetada.gridy = 5;
		contentPane.add(txtSenhaSetada, gbc_txtSenhaSetada);
		txtSenhaSetada.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Senha:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.weighty = 1.0;
		gbc_lblNewLabel_10.weightx = 1.0;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 5;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtSenhaGet = new JTextField();
		GridBagConstraints gbc_txtSenhaGet = new GridBagConstraints();
		gbc_txtSenhaGet.anchor = GridBagConstraints.WEST;
		gbc_txtSenhaGet.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenhaGet.weightx = 1.0;
		gbc_txtSenhaGet.weighty = 1.0;
		gbc_txtSenhaGet.gridx = 5;
		gbc_txtSenhaGet.gridy = 5;
		contentPane.add(txtSenhaGet, gbc_txtSenhaGet);
		txtSenhaGet.setColumns(10);
		
		Wifi wifi = new Wifi();
		txtNomeSetado.setText(wifi.getNome());
		txtSenhaSetada.setText(wifi.getSenha());
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Wifi wifii = new Wifi();
					wifii.registrarInformacoes(txtNomeGet.getText(), txtSenhaGet.getText());
					
					txtNomeSetado.setText(wifii.getNome());
					txtSenhaSetada.setText(wifii.getSenha());
					
					txtNomeGet.setText("");
					txtSenhaGet.setText("");
					
				} catch (CoreException mensagem) {
					
					lblError.setText(mensagem.getMessage());
					
				}
				
				
				
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Senha:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.weighty = 1.0;
		gbc_lblNewLabel_6.weightx = 1.0;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
	}
}
