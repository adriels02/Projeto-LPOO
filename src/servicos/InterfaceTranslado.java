package servicos;

import java.awt.Color;
import java.awt.EventQueue;

import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.accessibility.AccessibleContext;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InterfaceTranslado extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnderecoColeta;
	private JTextField txtEnderecoDestino;
	private JTextField txtQuantidadePassageiros;
	private JTextField txtData;
	private JTextField txtHora;

	DefaultListModel<String> historicoTranslado = new DefaultListModel<>();
	JList list = new JList(historicoTranslado);

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
					InterfaceTranslado frame = new InterfaceTranslado();
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
	public InterfaceTranslado() {
		setTitle("Translado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{162, 211, 272, 0};
		gbl_contentPane.rowHeights = new int[]{17, 14, 35, 14, 20, 15, 20, 14, 20, 14, 20, 14, 40, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
				JButton btnNewButton = new JButton("Adicionar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String QuantidadeDePassadeiros = txtQuantidadePassageiros.getText();
						int numeroPassageiros = Integer.parseInt(QuantidadeDePassadeiros);

						DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate data = LocalDate.parse(txtData.getText(), formatterDate);

						DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
						LocalTime hora = LocalTime.parse(txtHora.getText(), formatterTime);

						Translado translado = new Translado(numeroPassageiros, txtEnderecoColeta.getText(),
								txtEnderecoDestino.getText(), hora, data);
						historicoTranslado.addElement(translado.historicoDeViagem());

						txtData.setText("");
						txtEnderecoColeta.setText("");
						txtEnderecoDestino.setText("");
						txtHora.setText("");
						txtQuantidadePassageiros.setText("");

					}
				});
						
								JLabel lblNewLabel = new JLabel("<<< Voltar");
								lblNewLabel.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										InterfaceServicos interfaceServiços = new InterfaceServicos();
										interfaceServiços.setVisible(true);
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
								gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel.gridx = 0;
								gbc_lblNewLabel.gridy = 0;
								contentPane.add(lblNewLabel, gbc_lblNewLabel);
										
												JLabel lblNewLabel_1 = new JLabel("Translado");
												lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
												GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
												gbc_lblNewLabel_1.gridwidth = 4;
												gbc_lblNewLabel_1.weighty = 1.0;
												gbc_lblNewLabel_1.weightx = 1.0;
												gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
												gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
												gbc_lblNewLabel_1.gridx = 0;
												gbc_lblNewLabel_1.gridy = 0;
												contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
								
										JLabel lblNewLabel_2 = new JLabel("Serviço de transporte");
										lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
										GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
										gbc_lblNewLabel_2.weighty = 1.0;
										gbc_lblNewLabel_2.weightx = 1.0;
										gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
										gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_2.gridwidth = 4;
										gbc_lblNewLabel_2.gridx = 0;
										gbc_lblNewLabel_2.gridy = 1;
										contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
						
								JLabel lblNewLabel_3 = new JLabel("Endereço coleta:");
								GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
								gbc_lblNewLabel_3.weighty = 1.0;
								gbc_lblNewLabel_3.weightx = 1.0;
								gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
								gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_3.gridx = 0;
								gbc_lblNewLabel_3.gridy = 3;
								contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
										
												JLabel lblNewLabel_8 = new JLabel("Histórico de viagens:");
												GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
												gbc_lblNewLabel_8.weighty = 1.0;
												gbc_lblNewLabel_8.weightx = 1.0;
												gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
												gbc_lblNewLabel_8.gridwidth = 3;
												gbc_lblNewLabel_8.gridx = 1;
												gbc_lblNewLabel_8.gridy = 3;
												contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
								
										txtEnderecoColeta = new JTextField();
										txtEnderecoColeta.setColumns(10);
										GridBagConstraints gbc_txtEnderecoColeta = new GridBagConstraints();
										gbc_txtEnderecoColeta.weighty = 1.0;
										gbc_txtEnderecoColeta.weightx = 1.0;
										gbc_txtEnderecoColeta.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtEnderecoColeta.insets = new Insets(0, 0, 5, 5);
										gbc_txtEnderecoColeta.gridx = 0;
										gbc_txtEnderecoColeta.gridy = 4;
										contentPane.add(txtEnderecoColeta, gbc_txtEnderecoColeta);
						
								JLabel lblNewLabel_4 = new JLabel("Endereço Destino:");
								GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
								gbc_lblNewLabel_4.weighty = 1.0;
								gbc_lblNewLabel_4.weightx = 1.0;
								gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
								gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_4.gridx = 0;
								gbc_lblNewLabel_4.gridy = 5;
								contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
						
								JButton btnRemoverHistorico = new JButton("Remover");
								btnRemoverHistorico.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										if (!list.isSelectionEmpty()) {
											String elementoSelecionado = (String) list.getSelectedValue();
											historicoTranslado.removeElement(elementoSelecionado);
											list.revalidate();
											list.repaint();
										}
										btnRemoverHistorico.setEnabled(false);

									}
								});
								
								list.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(ListSelectionEvent e) {
										btnRemoverHistorico.setEnabled(true);
						
									}
								});
								GridBagConstraints gbc_list = new GridBagConstraints();
								gbc_list.weighty = 1.0;
								gbc_list.weightx = 1.0;
								gbc_list.fill = GridBagConstraints.BOTH;
								gbc_list.insets = new Insets(0, 0, 5, 0);
								gbc_list.gridheight = 9;
								gbc_list.gridwidth = 2;
								gbc_list.gridx = 1;
								gbc_list.gridy = 4;
								contentPane.add(list, gbc_list);
						
								txtEnderecoDestino = new JTextField();
								txtEnderecoDestino.setColumns(10);
								GridBagConstraints gbc_txtEnderecoDestino = new GridBagConstraints();
								gbc_txtEnderecoDestino.weighty = 1.0;
								gbc_txtEnderecoDestino.weightx = 1.0;
								gbc_txtEnderecoDestino.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtEnderecoDestino.insets = new Insets(0, 0, 5, 5);
								gbc_txtEnderecoDestino.gridx = 0;
								gbc_txtEnderecoDestino.gridy = 6;
								contentPane.add(txtEnderecoDestino, gbc_txtEnderecoDestino);
						
								JLabel lblNewLabel_5 = new JLabel("Quantidade de Passageiros:");
								GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
								gbc_lblNewLabel_5.weighty = 1.0;
								gbc_lblNewLabel_5.weightx = 1.0;
								gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTH;
								gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_5.gridx = 0;
								gbc_lblNewLabel_5.gridy = 7;
								contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
				
						txtQuantidadePassageiros = new JTextField();
						txtQuantidadePassageiros.setColumns(10);
						GridBagConstraints gbc_txtQuantidadePassageiros = new GridBagConstraints();
						gbc_txtQuantidadePassageiros.weighty = 1.0;
						gbc_txtQuantidadePassageiros.weightx = 1.0;
						gbc_txtQuantidadePassageiros.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtQuantidadePassageiros.insets = new Insets(0, 0, 5, 5);
						gbc_txtQuantidadePassageiros.gridx = 0;
						gbc_txtQuantidadePassageiros.gridy = 8;
						contentPane.add(txtQuantidadePassageiros, gbc_txtQuantidadePassageiros);
						
								JLabel lblNewLabel_6 = new JLabel("Data:");
								GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
								gbc_lblNewLabel_6.weighty = 1.0;
								gbc_lblNewLabel_6.weightx = 1.0;
								gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTH;
								gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_6.gridx = 0;
								gbc_lblNewLabel_6.gridy = 9;
								contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
						
								txtData = new JTextField();
								txtData.setColumns(10);
								GridBagConstraints gbc_txtData = new GridBagConstraints();
								gbc_txtData.weighty = 1.0;
								gbc_txtData.weightx = 1.0;
								gbc_txtData.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtData.insets = new Insets(0, 0, 5, 5);
								gbc_txtData.gridx = 0;
								gbc_txtData.gridy = 10;
								contentPane.add(txtData, gbc_txtData);
				
						JLabel lblNewLabel_7 = new JLabel("Hora:");
						GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
						gbc_lblNewLabel_7.weighty = 1.0;
						gbc_lblNewLabel_7.weightx = 1.0;
						gbc_lblNewLabel_7.anchor = GridBagConstraints.SOUTH;
						gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_7.gridx = 0;
						gbc_lblNewLabel_7.gridy = 11;
						contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
				
						txtHora = new JTextField();
						txtHora.setColumns(10);
						GridBagConstraints gbc_txtHora = new GridBagConstraints();
						gbc_txtHora.weighty = 1.0;
						gbc_txtHora.weightx = 1.0;
						gbc_txtHora.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtHora.insets = new Insets(0, 0, 5, 5);
						gbc_txtHora.gridx = 0;
						gbc_txtHora.gridy = 12;
						contentPane.add(txtHora, gbc_txtHora);
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.weighty = 1.0;
				gbc_btnNewButton.weightx = 1.0;
				gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 0;
				gbc_btnNewButton.gridy = 13;
				contentPane.add(btnNewButton, gbc_btnNewButton);
		
				
				btnRemoverHistorico.setEnabled(false);
				GridBagConstraints gbc_btnRemoverHistorico = new GridBagConstraints();
				gbc_btnRemoverHistorico.gridwidth = 2;
				gbc_btnRemoverHistorico.weighty = 1.0;
				gbc_btnRemoverHistorico.weightx = 1.0;
				gbc_btnRemoverHistorico.anchor = GridBagConstraints.NORTH;
				gbc_btnRemoverHistorico.gridx = 1;
				gbc_btnRemoverHistorico.gridy = 13;
				contentPane.add(btnRemoverHistorico, gbc_btnRemoverHistorico);

	}
}
