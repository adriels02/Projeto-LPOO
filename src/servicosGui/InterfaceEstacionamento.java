package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class InterfaceEstacionamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidadeVeiculos;
	private JTextField txtIdQuarto;

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
		setTitle("Estacionamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{70, 153, 87, 0};
		gbl_contentPane.rowHeights = new int[]{55, 0, 50, 30, 45, 55, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
				JLabel lblNewLabel = new JLabel("<<< Voltar");
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
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.weighty = 1.0;
				gbc_lblNewLabel.weightx = 1.0;
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estacionamento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblErro = new JLabel("");
		lblErro.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblErro = new GridBagConstraints();
		gbc_lblErro.weighty = 1.0;
		gbc_lblErro.weightx = 1.0;
		gbc_lblErro.gridwidth = 3;
		gbc_lblErro.insets = new Insets(0, 0, 5, 5);
		gbc_lblErro.gridx = 0;
		gbc_lblErro.gridy = 1;
		contentPane.add(lblErro, gbc_lblErro);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de veículos:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 1.0;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID do quarto:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 1.0;
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtQuantidadeVeiculos = new JTextField();
		txtQuantidadeVeiculos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
		GridBagConstraints gbc_txtQuantidadeVeiculos = new GridBagConstraints();
		gbc_txtQuantidadeVeiculos.weighty = 1.0;
		gbc_txtQuantidadeVeiculos.weightx = 1.0;
		gbc_txtQuantidadeVeiculos.insets = new Insets(0, 40, 5, 40);
		gbc_txtQuantidadeVeiculos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantidadeVeiculos.gridx = 0;
		gbc_txtQuantidadeVeiculos.gridy = 3;
		contentPane.add(txtQuantidadeVeiculos, gbc_txtQuantidadeVeiculos);
		txtQuantidadeVeiculos.setColumns(10);
		
		txtIdQuarto = new JTextField();
		txtIdQuarto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
		GridBagConstraints gbc_txtIdQuarto = new GridBagConstraints();
		gbc_txtIdQuarto.weighty = 1.0;
		gbc_txtIdQuarto.weightx = 1.0;
		gbc_txtIdQuarto.insets = new Insets(0, 40, 5, 40);
		gbc_txtIdQuarto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdQuarto.gridx = 2;
		gbc_txtIdQuarto.gridy = 3;
		contentPane.add(txtIdQuarto, gbc_txtIdQuarto);
		txtIdQuarto.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdicionar.weighty = 1.0;
		gbc_btnAdicionar.weightx = 1.0;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 1;
		gbc_btnAdicionar.gridy = 5;
		contentPane.add(btnAdicionar, gbc_btnAdicionar);
	}
}
