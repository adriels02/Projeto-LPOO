package servicosGui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import servicosCore.ControladorDeAcessos;
import servicosCore.ServicosException;
import servicosCore.Translado;

public class InterfaceTranslado extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnderecoColeta;
	private JTextField txtEnderecoDestino;
	private JTextField txtQuantidadePassageiros;
	private LocalTime horaFormatada;
	private LocalDate dataFormatada;
	private int numeroPassageiros;

	DefaultListModel<String> historicoTranslado = new DefaultListModel<>();
	JList list = new JList(historicoTranslado);

	/**
	 * Launch the application.
	 */

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}

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
		gbl_contentPane.columnWidths = new int[] { 162, 211, 272, 0 };
		gbl_contentPane.rowHeights = new int[] { 17, 14, 35, 14, 20, 15, 20, 14, 20, 14, 20, 14, 40, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 4;
		gbc_lblError.insets = new Insets(0, 0, 5, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 2;
		contentPane.add(lblError, gbc_lblError);

		JFormattedTextField ftxtfData = new JFormattedTextField(setMascara("##/##/####"));
		GridBagConstraints gbc_ftxtfData = new GridBagConstraints();
		gbc_ftxtfData.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtfData.weighty = 1.0;
		gbc_ftxtfData.weightx = 1.0;
		gbc_ftxtfData.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtfData.gridx = 0;
		gbc_ftxtfData.gridy = 10;
		contentPane.add(ftxtfData, gbc_ftxtfData);

		JFormattedTextField ftxtHora = new JFormattedTextField(setMascara("##:##"));
		GridBagConstraints gbc_ftxtHora = new GridBagConstraints();
		gbc_ftxtHora.weighty = 1.0;
		gbc_ftxtHora.weightx = 1.0;
		gbc_ftxtHora.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtHora.gridx = 0;
		gbc_ftxtHora.gridy = 12;
		contentPane.add(ftxtHora, gbc_ftxtHora);

		JButton btnAdicionarhistorico = new JButton("Adicionar");
		btnAdicionarhistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String QuantidadeDePassadeiros = txtQuantidadePassageiros.getText();
				if (QuantidadeDePassadeiros.equals("")) {
					QuantidadeDePassadeiros = "0";
				}
				int numeroPassageiros = Integer.parseInt(QuantidadeDePassadeiros);

				try {
					DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate data = LocalDate.parse(ftxtfData.getText(), formatterDate);

					DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
					LocalTime hora = LocalTime.parse(ftxtHora.getText(), formatterTime);

					dataFormatada = data;
					horaFormatada = hora;

				} catch (Exception exception) {
					lblError.setText(exception.getMessage());
					lblError.setVisible(true);
				}

				try {

				ControladorDeAcessos translado = new ControladorDeAcessos();
					translado.RegistroHistoricoDeViagem(txtEnderecoColeta.getText(),
							txtEnderecoDestino.getText(), numeroPassageiros, dataFormatada, horaFormatada);

				} catch (ServicosException exception) {

					lblError.setText(exception.getMessage());
				}

				ftxtfData.setText("");
				txtEnderecoColeta.setText("");
				txtEnderecoDestino.setText("");
				ftxtHora.setText("");
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
		gbc_list.insets = new Insets(0, 0, 5, 5);
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
		txtQuantidadePassageiros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
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

		JLabel lblNewLabel_7 = new JLabel("Hora:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weighty = 1.0;
		gbc_lblNewLabel_7.weightx = 1.0;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 11;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		GridBagConstraints gbc_btnAdicionarhistorico = new GridBagConstraints();
		gbc_btnAdicionarhistorico.weighty = 1.0;
		gbc_btnAdicionarhistorico.weightx = 1.0;
		gbc_btnAdicionarhistorico.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdicionarhistorico.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionarhistorico.gridx = 0;
		gbc_btnAdicionarhistorico.gridy = 13;
		contentPane.add(btnAdicionarhistorico, gbc_btnAdicionarhistorico);

		btnRemoverHistorico.setEnabled(false);
		GridBagConstraints gbc_btnRemoverHistorico = new GridBagConstraints();
		gbc_btnRemoverHistorico.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemoverHistorico.gridwidth = 2;
		gbc_btnRemoverHistorico.weighty = 1.0;
		gbc_btnRemoverHistorico.weightx = 1.0;
		gbc_btnRemoverHistorico.anchor = GridBagConstraints.NORTH;
		gbc_btnRemoverHistorico.gridx = 1;
		gbc_btnRemoverHistorico.gridy = 13;
		contentPane.add(btnRemoverHistorico, gbc_btnRemoverHistorico);

	}
}