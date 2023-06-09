package serviços;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class InterfaceRestaurante extends JFrame {

	DefaultListModel<String> historicoPedidos = new DefaultListModel<>();
	JList list = new JList(historicoPedidos);

	private JPanel contentPane;
	private ButtonGroup grupoBotoesRefeicao = new ButtonGroup();
	private JTextField txtObservacoes;
	private JTextField txtIDQuarto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceRestaurante frame = new InterfaceRestaurante();
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
	public InterfaceRestaurante() {
		setTitle("Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 379);
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
		lblNewLabel.setBounds(10, 11, 69, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Restaurante");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(226, 8, 114, 14);
		contentPane.add(lblNewLabel_1);

		JRadioButton rdbtnCafeDaManha = new JRadioButton("Café da manhã");
		grupoBotoesRefeicao.add(rdbtnCafeDaManha);
		rdbtnCafeDaManha.setBounds(10, 133, 109, 23);
		contentPane.add(rdbtnCafeDaManha);

		JRadioButton rdbtnAlmoco = new JRadioButton("Almoço");
		grupoBotoesRefeicao.add(rdbtnAlmoco);
		rdbtnAlmoco.setBounds(10, 159, 109, 23);
		contentPane.add(rdbtnAlmoco);

		JRadioButton rdbtnJantar = new JRadioButton("Jantar");
		grupoBotoesRefeicao.add(rdbtnJantar);
		rdbtnJantar.setBounds(10, 185, 109, 23);
		contentPane.add(rdbtnJantar);

		JButton btnRemoverHistorico = new JButton("Remover");
		btnRemoverHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!list.isSelectionEmpty()) {
					String elementoSelecionado = (String) list.getSelectedValue();
					historicoPedidos.removeElement(elementoSelecionado);
					list.revalidate();
					list.repaint();
				}
				btnRemoverHistorico.setEnabled(false);

			}
		});
		btnRemoverHistorico.setEnabled(false);
		btnRemoverHistorico.setBounds(361, 297, 89, 23);
		contentPane.add(btnRemoverHistorico);

		txtObservacoes = new JTextField();
		txtObservacoes.setBounds(141, 136, 103, 23);
		contentPane.add(txtObservacoes);
		txtObservacoes.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Observação para alergias etc:");
		lblNewLabel_2.setBounds(112, 100, 157, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Histórico de pedidos:");
		lblNewLabel_3.setBounds(350, 100, 134, 14);
		contentPane.add(lblNewLabel_3);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				btnRemoverHistorico.setEnabled(true);
			}
		});

		list.setBounds(280, 136, 250, 150);
		contentPane.add(list);

		txtIDQuarto = new JTextField();
		txtIDQuarto.setBounds(13, 240, 86, 20);
		contentPane.add(txtIDQuarto);
		txtIDQuarto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("ID do quarto:");
		lblNewLabel_4.setBounds(20, 215, 86, 14);
		contentPane.add(lblNewLabel_4);

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
				historicoPedidos.addElement(restaurante.historicoRestaurante(refeicao, id, txtObservacoes.getText()));

				txtObservacoes.setText("");
				grupoBotoesRefeicao.clearSelection();
				txtIDQuarto.setText("");

			}
		});
		btnAdicionar.setBounds(10, 283, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
