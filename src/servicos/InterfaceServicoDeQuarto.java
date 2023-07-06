package servicos;

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

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfaceServicoDeQuarto extends JFrame {

	private JPanel contentPane;

	DefaultListModel<String> historicoServicos = new DefaultListModel<>();
	JList list = new JList(historicoServicos);

	
	private ButtonGroup grupoBotoesRefeicao = new ButtonGroup();
	private JTextField txtObservacoes;
	private JTextField txtIDQuarto;

	
	
	
	
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
		setTitle("Serviço de quarto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{109, 121, 250, 0};
		gbl_contentPane.rowHeights = new int[]{17, 30, 14, 26, 23, 23, 14, 20, 3, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
				JLabel lblNewLabel = new JLabel("<<< Voltar");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
				gbc_lblNewLabel.weighty = 1.0;
				gbc_lblNewLabel.weightx = 1.0;
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Serviço de Quarto");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.weighty = 1.0;
				gbc_lblNewLabel_1.weightx = 1.0;
				gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel_1.gridwidth = 3;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 0;
				contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
						
						JLabel lblError = new JLabel("");
						lblError.setForeground(new Color(255, 0, 0));
						GridBagConstraints gbc_lblError = new GridBagConstraints();
						gbc_lblError.weighty = 1.0;
						gbc_lblError.weightx = 1.0;
						gbc_lblError.gridwidth = 3;
						gbc_lblError.insets = new Insets(0, 0, 5, 5);
						gbc_lblError.gridx = 0;
						gbc_lblError.gridy = 1;
						contentPane.add(lblError, gbc_lblError);
				
						JLabel lblNewLabel_2 = new JLabel("Observação:");
						GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
						gbc_lblNewLabel_2.weighty = 1.0;
						gbc_lblNewLabel_2.weightx = 1.0;
						gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_2.gridx = 1;
						gbc_lblNewLabel_2.gridy = 2;
						contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
						JLabel lblNewLabel_3 = new JLabel("Histórico de Serviços:");
						GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
						gbc_lblNewLabel_3.weighty = 1.0;
						gbc_lblNewLabel_3.weightx = 1.0;
						gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
						gbc_lblNewLabel_3.gridx = 2;
						gbc_lblNewLabel_3.gridy = 2;
						contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
				
				JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
				grupoBotoesRefeicao.add(rdbtnCafeDaManha);
				GridBagConstraints gbc_rdbtnCafeDaManha = new GridBagConstraints();
				gbc_rdbtnCafeDaManha.anchor = GridBagConstraints.EAST;
				gbc_rdbtnCafeDaManha.weighty = 1.0;
				gbc_rdbtnCafeDaManha.weightx = 1.0;
				gbc_rdbtnCafeDaManha.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnCafeDaManha.gridx = 0;
				gbc_rdbtnCafeDaManha.gridy = 3;
				contentPane.add(rdbtnCafeDaManha, gbc_rdbtnCafeDaManha);
		
				txtObservacoes = new JTextField();
				GridBagConstraints gbc_txtObservacoes = new GridBagConstraints();
				gbc_txtObservacoes.weighty = 1.0;
				gbc_txtObservacoes.weightx = 1.0;
				gbc_txtObservacoes.insets = new Insets(0, 0, 5, 5);
				gbc_txtObservacoes.gridx = 1;
				gbc_txtObservacoes.gridy = 3;
				contentPane.add(txtObservacoes, gbc_txtObservacoes);
				txtObservacoes.setColumns(10);
				
				JButton btnRemoverHistorico = new JButton("Remover");
				btnRemoverHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (!list.isSelectionEmpty()) {
							String elementoSelecionado = (String) list.getSelectedValue();
							historicoServicos.removeElement(elementoSelecionado);
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
						gbc_list.gridheight = 6;
						gbc_list.gridx = 2;
						gbc_list.gridy = 3;
						contentPane.add(list, gbc_list);
						
								JRadioButton rdbtnAlmoco = new JRadioButton("Almoço");
								grupoBotoesRefeicao.add(rdbtnAlmoco);
								GridBagConstraints gbc_rdbtnAlmoco = new GridBagConstraints();
								gbc_rdbtnAlmoco.weighty = 1.0;
								gbc_rdbtnAlmoco.weightx = 1.0;
								gbc_rdbtnAlmoco.insets = new Insets(0, 0, 5, 5);
								gbc_rdbtnAlmoco.gridx = 0;
								gbc_rdbtnAlmoco.gridy = 4;
								contentPane.add(rdbtnAlmoco, gbc_rdbtnAlmoco);
				
						JRadioButton rdbtnJantar = new JRadioButton("Jantar");
						grupoBotoesRefeicao.add(rdbtnJantar);
						GridBagConstraints gbc_rdbtnJantar = new GridBagConstraints();
						gbc_rdbtnJantar.weighty = 1.0;
						gbc_rdbtnJantar.weightx = 1.0;
						gbc_rdbtnJantar.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnJantar.gridx = 0;
						gbc_rdbtnJantar.gridy = 5;
						contentPane.add(rdbtnJantar, gbc_rdbtnJantar);
				
						JLabel lblNewLabel_4 = new JLabel("ID do quarto:");
						GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
						gbc_lblNewLabel_4.weighty = 1.0;
						gbc_lblNewLabel_4.weightx = 1.0;
						gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_4.gridx = 0;
						gbc_lblNewLabel_4.gridy = 6;
						contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				txtIDQuarto = new JTextField();
				txtIDQuarto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						
						String caracteres="0987654321";
						if(!caracteres.contains(e.getKeyChar()+"")){
						e.consume();
						}
					}
				});
				GridBagConstraints gbc_txtIDQuarto = new GridBagConstraints();
				gbc_txtIDQuarto.weighty = 1.0;
				gbc_txtIDQuarto.weightx = 1.0;
				gbc_txtIDQuarto.insets = new Insets(0, 0, 5, 5);
				gbc_txtIDQuarto.gridx = 0;
				gbc_txtIDQuarto.gridy = 7;
				contentPane.add(txtIDQuarto, gbc_txtIDQuarto);
				txtIDQuarto.setColumns(10);
		
				
						JButton btnAdicionar = new JButton("Adicionar");
						btnAdicionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								String refeicao = null;

								if (rdbtnAlmoco.isSelected()) {

									refeicao = "Almoço";
								}

								if (rdbtnJantar.isSelected()) {

									refeicao = "Jantar";
								}

								if (rdbtnCafeDaManha.isSelected()) {

									refeicao = "Café da manhã";
								}

								int id = Integer.parseInt(txtIDQuarto.getText());

								Restaurante restaurante = new Restaurante();
								historicoServicos.addElement(restaurante.historicoRestaurante(refeicao, id, txtObservacoes.getText()));

								txtObservacoes.setText("");
								grupoBotoesRefeicao.clearSelection();
								txtIDQuarto.setText("");

							}
						});
						GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
						gbc_btnAdicionar.weighty = 1.0;
						gbc_btnAdicionar.weightx = 1.0;
						gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
						gbc_btnAdicionar.gridx = 0;
						gbc_btnAdicionar.gridy = 8;
						contentPane.add(btnAdicionar, gbc_btnAdicionar);
				btnRemoverHistorico.setEnabled(false);
				GridBagConstraints gbc_btnRemoverHistorico = new GridBagConstraints();
				gbc_btnRemoverHistorico.weighty = 1.0;
				gbc_btnRemoverHistorico.weightx = 1.0;
				gbc_btnRemoverHistorico.anchor = GridBagConstraints.NORTH;
				gbc_btnRemoverHistorico.gridx = 2;
				gbc_btnRemoverHistorico.gridy = 9;
				contentPane.add(btnRemoverHistorico, gbc_btnRemoverHistorico);
		
		
		
		
		
		
	}

}
