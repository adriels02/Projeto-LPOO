package servicos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class InterfaceArrumacao extends JFrame {

	private JPanel contentPane;
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
					InterfaceArrumacao frame = new InterfaceArrumacao();
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
	public InterfaceArrumacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				GridBagLayout gbl_contentPane = new GridBagLayout();
				gbl_contentPane.columnWidths = new int[]{88, 88, 88, 0, 88, 88, 88, 0};
				gbl_contentPane.rowHeights = new int[]{50, 50, 50, 50, 50, 0};
				gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				contentPane.setLayout(gbl_contentPane);
						
								JLabel lblVoltar = new JLabel("<<< Voltar");
								lblVoltar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {

										InterfaceServicos interfaceServicos = new InterfaceServicos();
										interfaceServicos.setVisible(true);
										dispose();

									}

									@Override
									public void mouseEntered(MouseEvent e) {
										lblVoltar.setForeground(Color.RED);
									}

									@Override
									public void mouseExited(MouseEvent e) {
										lblVoltar.setForeground(Color.BLACK);
									}
								});
								GridBagConstraints gbc_lblVoltar = new GridBagConstraints();
								gbc_lblVoltar.anchor = GridBagConstraints.NORTH;
								gbc_lblVoltar.weighty = 1.0;
								gbc_lblVoltar.weightx = 1.0;
								gbc_lblVoltar.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblVoltar.insets = new Insets(0, 0, 5, 5);
								gbc_lblVoltar.gridx = 0;
								gbc_lblVoltar.gridy = 0;
								contentPane.add(lblVoltar, gbc_lblVoltar);
				
						JLabel lblNewLabel_1 = new JLabel("Arrumação");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.gridwidth = 7;
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
				gbc_lblErro.gridwidth = 7;
				gbc_lblErro.insets = new Insets(0, 0, 5, 5);
				gbc_lblErro.gridx = 0;
				gbc_lblErro.gridy = 1;
				contentPane.add(lblErro, gbc_lblErro);
				
				JLabel lblNewLabel = new JLabel("ID do Quarto:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.weighty = 1.0;
				gbc_lblNewLabel.weightx = 1.0;
				gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 2;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
				textField = new JTextField();
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.weighty = 1.0;
				gbc_textField.weightx = 1.0;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.gridx = 1;
				gbc_textField.gridy = 2;
				contentPane.add(textField, gbc_textField);
				textField.setColumns(10);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Quarto", "Status"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				GridBagConstraints gbc_table = new GridBagConstraints();
				gbc_table.gridheight = 3;
				gbc_table.gridwidth = 2;
				gbc_table.fill = GridBagConstraints.BOTH;
				gbc_table.weighty = 1.0;
				gbc_table.weightx = 1.0;
				gbc_table.gridx = 5;
				gbc_table.gridy = 2;
				contentPane.add(table, gbc_table);
				
				JLabel lblNewLabel_2 = new JLabel("Status:");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.weighty = 1.0;
				gbc_lblNewLabel_2.weightx = 1.0;
				gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 3;
				contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arrumado", "Desarrumado"}));
				comboBox.setMaximumRowCount(2);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.weighty = 1.0;
				gbc_comboBox.weightx = 1.0;
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 3;
				contentPane.add(comboBox, gbc_comboBox);
				
				JButton btnAlterarStatusArrumacao = new JButton("Alterar");
				GridBagConstraints gbc_btnAlterarStatusArrumacao = new GridBagConstraints();
				gbc_btnAlterarStatusArrumacao.gridwidth = 2;
				gbc_btnAlterarStatusArrumacao.weighty = 1.0;
				gbc_btnAlterarStatusArrumacao.weightx = 1.0;
				gbc_btnAlterarStatusArrumacao.insets = new Insets(0, 0, 0, 5);
				gbc_btnAlterarStatusArrumacao.gridx = 0;
				gbc_btnAlterarStatusArrumacao.gridy = 4;
				contentPane.add(btnAlterarStatusArrumacao, gbc_btnAlterarStatusArrumacao);
	}
}
