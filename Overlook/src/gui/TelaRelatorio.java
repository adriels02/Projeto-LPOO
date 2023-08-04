package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;

import core.RelatorioController;
import core.RelatorioEntidade;
import core.RelatorioExcecoesRegraNegocio;
import data.RelatorioDataException;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaRelatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7826610023978124960L;
	private JPanel contentPane;
	private JLabel errorLabel= new JLabel("x");;
	public static final String KEY1 = "Café da Manhã";
	public static final String KEY2 = "Jantar";
	public static final String KEY3 = "Almoço";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorio.class.getResource("/interfaces/imagens/iconeOverlook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280,720); 
		setLocationRelativeTo(null);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(225, 225, 225));
		panel.setBounds(142, 275, 307, 163);
		contentPane.add(panel);
		panel.setLayout(null);

		JDateChooser jdc1 = new JDateChooser();
		jdc1.setBounds(133, 46, 127, 20);
		panel.add(jdc1);



		JDateChooser jdc1_1 = new JDateChooser();
		jdc1_1.setBounds(133, 101, 127, 20);
		panel.add(jdc1_1);

		JLabel lblNewLabel = new JLabel("Data inicial");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(38, 9, 55));
		lblNewLabel.setBounds(38, 45, 85, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data Final");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(38, 9, 55));
		lblNewLabel_1.setBounds(38, 100, 85, 23);
		panel.add(lblNewLabel_1);

		JButton gerarRelatorio = new JButton("Restaurante");
		gerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RelatorioController rc = new RelatorioController();
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String dataInicial = dateFormat.format(jdc1.getDate());
					String dataFinal = dateFormat.format(jdc1_1.getDate());					
					
					//atribui a um objeto de RelatorioController a um de RelatorioEntidade
					RelatorioEntidade t = rc.selectRestaurante(dataInicial, dataFinal);
					
					//usamos gets de RelatorioEntidade
					int almoco = t.getAlmoco();
					int jantar= t.getJantar();
					int cafeManha= t.getCafeManha();
					
					//Para criar o grafico em pizza passamos as chaves e os valores para o Dataset.
					DefaultPieDataset dataset = new DefaultPieDataset();
					dataset.setValue(KEY1, cafeManha);
					dataset.setValue(KEY2, jantar);
					dataset.setValue(KEY3, almoco);
					
				
					// exception para o caso das datas nao retornarem com valres minimos parra contruir um grafico
					if(cafeManha==0 && jantar==0 && almoco==0)throw new RelatorioDataException("Não existe valores"
					+ " para atribuir a um Gráfico. Escolha outras Datas.");
					
					//criar o grafico pizza
					JFreeChart someChart = ChartFactory.createPieChart(
							"Gráfico Restaurante", dataset, true, true, false);
					PiePlot plot = (PiePlot) someChart.getPlot();
					plot.setSectionPaint(KEY1, Color.green);
					plot.setSectionPaint(KEY2, Color.red);
					plot.setSectionPaint(KEY2, Color.blue);
					plot.setExplodePercent(KEY1, 0.10);
					plot.setSimpleLabels(true);

					//3 parametros para definiçao dos labels. Do frame criado com o grafico de pizza. {0} é a string ex: Almoco: . {1} é o valor ex: 30.
					//{2} é a porcentagem.
					//o segundo e terceiro parametros são referentes ao tipo de decimal usado para o valor e porcentagem.
					StandardPieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
							"{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
					plot.setLabelGenerator(gen);

					//cria o jfframe do grafico pizza
					JFrame f = new JFrame("");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.getContentPane().add(new ChartPanel(someChart) {
						@Override
						public Dimension getPreferredSize() {
							return new Dimension(400, 300);
						}
					});
					f.pack();
					f.setLocationRelativeTo(null);
					f.setVisible(true);

				}catch (Exception e8) {
					errorLabel.setText(e8.getMessage());
					errorLabel.setVisible(true);
				}


			}
		});
		gerarRelatorio.setBackground(new Color(225, 225, 225));
		gerarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		gerarRelatorio.setForeground(new Color(38, 9, 55));
		gerarRelatorio.setBounds(0, 415, 132, 23);
		contentPane.add(gerarRelatorio);

		JButton btnNewButton_7 = new JButton("Menu");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();

			}
		});
		btnNewButton_7.setBackground(new Color(255, 128, 64));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(0, 0, 65, 23);
		contentPane.add(btnNewButton_7);

		JButton btnFecharTela = new JButton("");
		btnFecharTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFecharTela.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/Botao Fechar quadrado 30x30.png")));
		btnFecharTela.setBounds(1250, 0, 30, 30);
		contentPane.add(btnFecharTela);

		JButton btnSignOut = new JButton("");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial objTelaInicial = new TelaInicial();
				objTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnSignOut.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/Botao sign out 30x30.png")));
		btnSignOut.setBounds(1213, 0, 30, 30);
		contentPane.add(btnSignOut);

		JLabel lblLogoTelas = new JLabel("");
		lblLogoTelas.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/logo telas 480x320.png")));
		lblLogoTelas.setBounds(750, 170, 480, 320);
		contentPane.add(lblLogoTelas);
		errorLabel.setLocation(142, 475);
		errorLabel.setSize(579, 42);


		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);

		JButton btnBotao5 = new JButton("TODO\r\n");
		btnBotao5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao5.setForeground(new Color(38, 9, 55));
		btnBotao5.setBackground(new Color(225, 225, 225));
		btnBotao5.setBounds(0, 387, 132, 23);
		contentPane.add(btnBotao5);

		JButton btnBotao4 = new JButton("TODO");
		btnBotao4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao4.setForeground(new Color(38, 9, 55));
		btnBotao4.setBackground(new Color(225, 225, 225));
		btnBotao4.setBounds(0, 359, 132, 23);
		contentPane.add(btnBotao4);

		JButton btnBotao3 = new JButton("TODO");
		btnBotao3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao3.setForeground(new Color(38, 9, 55));
		btnBotao3.setBackground(new Color(225, 225, 225));
		btnBotao3.setBounds(0, 331, 132, 23);
		contentPane.add(btnBotao3);

		JButton btnBotao2 = new JButton("TODO");
		btnBotao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBotao2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao2.setForeground(new Color(38, 9, 55));
		btnBotao2.setBackground(new Color(225, 225, 225));
		btnBotao2.setBounds(0, 303, 132, 23);
		contentPane.add(btnBotao2);

		JButton btnBotao1 = new JButton("TODO\r\n");
		btnBotao1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBotao1.setForeground(new Color(38, 9, 55));
		btnBotao1.setBackground(new Color(225, 225, 225));
		btnBotao1.setBounds(0, 275, 132, 23);
		contentPane.add(btnBotao1);
		btnBotao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	


		JLabel lblTituloRelatorio = new JLabel("Relatórios");
		lblTituloRelatorio.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTituloRelatorio.setForeground(new Color(38, 9, 55));
		lblTituloRelatorio.setBounds(32, 141, 352, 42);
		contentPane.add(lblTituloRelatorio);

		JLabel lblInstrucoes = new JLabel("Seleciona as datas de início e fim");
		lblInstrucoes.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstrucoes.setForeground(new Color(38, 9, 55));
		lblInstrucoes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInstrucoes.setBounds(142, 240, 317, 32);
		contentPane.add(lblInstrucoes);


		JLabel lblLogoTransparente = new JLabel("");
		lblLogoTransparente.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/interfaces/imagens/icone logo transparente 758x758.png")));
		lblLogoTransparente.setBounds(0, 0, 758, 758);
		contentPane.add(lblLogoTransparente);
		


	}
}
