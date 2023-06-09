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
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("<<< Voltar");
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
		lblNewLabel.setBounds(10, 11, 76, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Translado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(288, 8, 93, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Serviço de transporte");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(258, 33, 154, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Endereço coleta:");
		lblNewLabel_3.setBounds(22, 83, 117, 14);
		contentPane.add(lblNewLabel_3);

		txtEnderecoColeta = new JTextField();
		txtEnderecoColeta.setBounds(10, 108, 129, 20);
		contentPane.add(txtEnderecoColeta);
		txtEnderecoColeta.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Endereço Destino:");
		lblNewLabel_4.setBounds(22, 139, 117, 14);
		contentPane.add(lblNewLabel_4);

		txtEnderecoDestino = new JTextField();
		txtEnderecoDestino.setBounds(10, 164, 129, 20);
		contentPane.add(txtEnderecoDestino);
		txtEnderecoDestino.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Quantidade de Passageiros:");
		lblNewLabel_5.setBounds(0, 195, 162, 14);
		contentPane.add(lblNewLabel_5);

		txtQuantidadePassageiros = new JTextField();
		txtQuantidadePassageiros.setBounds(10, 220, 129, 20);
		contentPane.add(txtQuantidadePassageiros);
		txtQuantidadePassageiros.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Data:");
		lblNewLabel_6.setBounds(55, 251, 46, 14);
		contentPane.add(lblNewLabel_6);

		txtData = new JTextField();
		txtData.setBounds(10, 280, 129, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Hora:");
		lblNewLabel_7.setBounds(55, 312, 46, 14);
		contentPane.add(lblNewLabel_7);

		txtHora = new JTextField();
		txtHora.setBounds(10, 338, 129, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Histórico de viagens:");
		lblNewLabel_8.setBounds(355, 111, 121, 14);
		contentPane.add(lblNewLabel_8);

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
		btnRemoverHistorico.setEnabled(false);
		btnRemoverHistorico.setBounds(394, 390, 89, 23);
		contentPane.add(btnRemoverHistorico);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnRemoverHistorico.setEnabled(true);

			}
		});
		list.setBounds(170, 138, 496, 240);
		contentPane.add(list);

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

		btnNewButton.setBounds(10, 390, 129, 23);
		contentPane.add(btnNewButton);

	}
}
