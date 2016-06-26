package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import view.manager.UIManager;

import javax.swing.JButton;

public class SolicitarAlocacaoLaboratorio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField periodoIni, periodoFim;
	private JComboBox turma, laboratorio;

	public SolicitarAlocacaoLaboratorio() throws ParseException {
		setLayout(null);
		
		turma = new JComboBox();
		turma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		turma.setBounds(423, 130, 180, 27);
		add(turma);
		
		laboratorio = new JComboBox();
		laboratorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		laboratorio.setBounds(423, 84, 180, 27);
		add(laboratorio);
		
		periodoFim = new JFormattedTextField(new MaskFormatter("##/##/"+String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
		periodoFim.setBounds(525, 226, 86, 27);
		add(periodoFim);
		periodoFim.setColumns(10);
		
		periodoIni =  new JFormattedTextField(new MaskFormatter("##/##/"+String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
		periodoIni.setBounds(379, 226, 86, 27);
		add(periodoIni);
		periodoIni.setColumns(10);
		
		JCheckBox segunda = new JCheckBox("Segunda-Feira");
		segunda.setBounds(341, 332, 124, 23);
		add(segunda);
		
		JCheckBox terca = new JCheckBox("Terça-Feira");
		terca.setBounds(341, 366, 124, 23);
		add(terca);
		
		JCheckBox quarta = new JCheckBox("Quarta-Feira");
		quarta.setBounds(481, 332, 122, 23);
		add(quarta);
		
		JCheckBox quinta = new JCheckBox("Quinta-Feira");
		quinta.setBounds(481, 366, 122, 23);
		add(quinta);
		
		JCheckBox sexta = new JCheckBox("Sexta-Feira");
		sexta.setBounds(609, 332, 102, 23);
		add(sexta);
		
		JCheckBox sabado = new JCheckBox("Sábado");
		sabado.setBounds(609, 366, 97, 23);
		add(sabado);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDe.setBounds(335, 229, 40, 14);
		add(lblDe);
		
		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(475, 229, 40, 14);
		add(lblA);
		
		JLabel lblPeriodo = new JLabel("Período: ");
		lblPeriodo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPeriodo.setBounds(338, 188, 89, 14);
		add(lblPeriodo);
		
		JLabel lblExDdmm = new JLabel("ex: dd/mm/aaaa");
		lblExDdmm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExDdmm.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblExDdmm.setBounds(379, 254, 86, 14);
		add(lblExDdmm);
		
		JLabel label_1 = new JLabel("ex: dd/mm/aaaa");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(525, 254, 86, 14);
		add(label_1);
		
		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label.setBackground(Color.WHITE);
		label.setBounds(335, 205, 302, 67);
		add(label);
		
		JLabel lblSolicitaoDeAlocacao = new JLabel("Solicitação de alocação de laboratório");
		lblSolicitaoDeAlocacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitaoDeAlocacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSolicitaoDeAlocacao.setBounds(10, 11, 980, 27);
		add(lblSolicitaoDeAlocacao);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(335, 320, 386, 79);
		add(label_2);
		
		JLabel lblDiasDaSemana = new JLabel("Dias da semana:");
		lblDiasDaSemana.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiasDaSemana.setBounds(335, 298, 118, 23);
		add(lblDiasDaSemana);
		
		JLabel lblLaboratorio = new JLabel("Laboratório: ");
		lblLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLaboratorio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLaboratorio.setBounds(335, 87, 78, 14);
		add(lblLaboratorio);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTurma.setBounds(335, 133, 78, 14);
		add(lblTurma);
		
		JButton btnSolicitarLaboratorio = new JButton("Solicitar Laboratório");
		btnSolicitarLaboratorio.setBounds(372, 455, 143, 27);
		btnSolicitarLaboratorio.addActionListener(a -> {

		});
		add(btnSolicitarLaboratorio);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(563, 455, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);
		
	}
}
