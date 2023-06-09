package serviços;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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

		JLabel lblNewLabel = new JLabel("<<< Voltar");
		lblNewLabel.setBounds(15, 16, 76, 14);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceServiços interfaceServiços = new InterfaceServiços();
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

		JLabel lblNewLabel_1 = new JLabel("Translado");
		lblNewLabel_1.setBounds(293, 13, 93, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel("Serviço de transporte");
		lblNewLabel_2.setBounds(263, 38, 154, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Endereço coleta:");
		lblNewLabel_3.setBounds(27, 87, 117, 14);

		txtEnderecoColeta = new JTextField();
		txtEnderecoColeta.setBounds(15, 116, 129, 20);
		txtEnderecoColeta.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Endereço Destino:");
		lblNewLabel_4.setBounds(27, 150, 117, 14);

		txtEnderecoDestino = new JTextField();
		txtEnderecoDestino.setBounds(15, 175, 129, 20);
		txtEnderecoDestino.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Quantidade de Passageiros:");
		lblNewLabel_5.setBounds(5, 206, 162, 14);

		txtQuantidadePassageiros = new JTextField();
		txtQuantidadePassageiros.setBounds(15, 231, 129, 20);
		txtQuantidadePassageiros.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Data:");
		lblNewLabel_6.setBounds(60, 262, 46, 14);

		txtData = new JTextField();
		txtData.setBounds(15, 291, 129, 20);
		txtData.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Hora:");
		lblNewLabel_7.setBounds(60, 323, 46, 14);

		txtHora = new JTextField();
		txtHora.setBounds(15, 349, 129, 20);
		txtHora.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Histórico de viagens:");
		lblNewLabel_8.setBounds(360, 119, 121, 14);

		JButton btnRemoverHistorico = new JButton("Remover");
		btnRemoverHistorico.setBounds(399, 401, 89, 23);
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
		btnRemoverHistorico.setEnabled(false);
		list.setBounds(175, 149, 496, 240);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnRemoverHistorico.setEnabled(true);

			}
		});

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(15, 401, 129, 23);
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
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(txtEnderecoColeta);
		contentPane.add(lblNewLabel_4);
		contentPane.add(txtEnderecoDestino);
		contentPane.add(lblNewLabel_5);
		contentPane.add(txtQuantidadePassageiros);
		contentPane.add(lblNewLabel_6);
		contentPane.add(txtData);
		contentPane.add(lblNewLabel_7);
		contentPane.add(txtHora);
		contentPane.add(lblNewLabel_8);
		contentPane.add(btnRemoverHistorico);
		contentPane.add(list);
		contentPane.add(btnNewButton);

	}
}
