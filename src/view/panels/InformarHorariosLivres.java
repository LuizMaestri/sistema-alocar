package view.panels;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class InformarHorariosLivres extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField segMatIni, segMatFim, segVespIni, segVespFim, segNotIni, segNotFim, terMatIni, terMatFim,
			terVespIni, terVespFim, terNotIni, terNotFim, quaMatIni, quaMatFim, quaVespIni, quaVespFim, quaNotIni,
			quaNotFim, quiMatIni, quiMatFim, quiVespIni, quiVespFim, quiNotIni, quiNotFim, sexMatIni, sexMatFim,
			sexVespIni, sexVespFim, sexNotIni, sexNotFim, sabMatIni, sabMatFim;

	public InformarHorariosLivres() throws ParseException {
		setLayout(null);

		segMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		segMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segMatIni.setBounds(194, 121, 110, 27);
		add(segMatIni);
		segMatIni.setColumns(10);

		segMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		segMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segMatFim.setBounds(194, 159, 110, 27);
		add(segMatFim);
		segMatFim.setColumns(10);

		segVespIni = new JFormattedTextField(new MaskFormatter("##:##"));
		segVespIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segVespIni.setColumns(10);
		segVespIni.setBounds(194, 211, 110, 27);
		add(segVespIni);

		segVespFim = new JFormattedTextField(new MaskFormatter("##:##"));
		segVespFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segVespFim.setColumns(10);
		segVespFim.setBounds(194, 247, 110, 27);
		add(segVespFim);

		segNotIni = new JFormattedTextField(new MaskFormatter("##:##"));
		segNotIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segNotIni.setColumns(10);
		segNotIni.setBounds(194, 298, 110, 27);
		add(segNotIni);

		segNotFim = new JFormattedTextField(new MaskFormatter("##:##"));
		segNotFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		segNotFim.setColumns(10);
		segNotFim.setBounds(194, 337, 110, 27);
		add(segNotFim);

		terMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		terMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terMatIni.setColumns(10);
		terMatIni.setBounds(326, 121, 110, 27);
		add(terMatIni);

		terMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		terMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terMatFim.setColumns(10);
		terMatFim.setBounds(326, 159, 110, 27);
		add(terMatFim);

		terVespIni = new JFormattedTextField(new MaskFormatter("##:##"));
		terVespIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terVespIni.setColumns(10);
		terVespIni.setBounds(326, 211, 110, 27);
		add(terVespIni);

		terVespFim = new JFormattedTextField(new MaskFormatter("##:##"));
		terVespFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terVespFim.setColumns(10);
		terVespFim.setBounds(326, 247, 110, 27);
		add(terVespFim);

		terNotIni = new JFormattedTextField(new MaskFormatter("##:##"));
		terNotIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terNotIni.setColumns(10);
		terNotIni.setBounds(326, 298, 110, 27);
		add(terNotIni);

		terNotFim = new JFormattedTextField(new MaskFormatter("##:##"));
		terNotFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terNotFim.setColumns(10);
		terNotFim.setBounds(326, 337, 110, 27);
		add(terNotFim);

		quaMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quaMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaMatIni.setColumns(10);
		quaMatIni.setBounds(458, 121, 110, 27);
		add(quaMatIni);

		quaMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quaMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaMatFim.setColumns(10);
		quaMatFim.setBounds(458, 159, 110, 27);
		add(quaMatFim);

		quaVespIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quaVespIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaVespIni.setColumns(10);
		quaVespIni.setBounds(458, 211, 110, 27);
		add(quaVespIni);

		quaVespFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quaVespFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaVespFim.setColumns(10);
		quaVespFim.setBounds(458, 247, 110, 27);
		add(quaVespFim);

		quaNotIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quaNotIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaNotIni.setColumns(10);
		quaNotIni.setBounds(458, 298, 110, 27);
		add(quaNotIni);

		quaNotFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quaNotFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quaNotFim.setColumns(10);
		quaNotFim.setBounds(458, 337, 110, 27);
		add(quaNotFim);

		quiMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quiMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiMatIni.setColumns(10);
		quiMatIni.setBounds(586, 121, 110, 27);
		add(quiMatIni);

		quiMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quiMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiMatFim.setColumns(10);
		quiMatFim.setBounds(587, 159, 110, 27);
		add(quiMatFim);

		quiVespIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quiVespIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiVespIni.setColumns(10);
		quiVespIni.setBounds(586, 211, 110, 27);
		add(quiVespIni);

		quiVespFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quiVespFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiVespFim.setColumns(10);
		quiVespFim.setBounds(586, 247, 110, 27);
		add(quiVespFim);

		quiNotIni = new JFormattedTextField(new MaskFormatter("##:##"));
		quiNotIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiNotIni.setColumns(10);
		quiNotIni.setBounds(586, 298, 110, 27);
		add(quiNotIni);

		quiNotFim = new JFormattedTextField(new MaskFormatter("##:##"));
		quiNotFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quiNotFim.setColumns(10);
		quiNotFim.setBounds(587, 337, 110, 27);
		add(quiNotFim);

		sexMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		sexMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexMatIni.setColumns(10);
		sexMatIni.setBounds(718, 121, 110, 27);
		add(sexMatIni);

		sexMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		sexMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexMatFim.setColumns(10);
		sexMatFim.setBounds(718, 159, 110, 27);
		add(sexMatFim);

		sexVespIni = new JFormattedTextField(new MaskFormatter("##:##"));
		sexVespIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexVespIni.setColumns(10);
		sexVespIni.setBounds(718, 211, 110, 27);
		add(sexVespIni);

		sexVespFim = new JFormattedTextField(new MaskFormatter("##:##"));
		sexVespFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexVespFim.setColumns(10);
		sexVespFim.setBounds(718, 247, 110, 27);
		add(sexVespFim);

		sexNotIni = new JFormattedTextField(new MaskFormatter("##:##"));
		sexNotIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexNotIni.setColumns(10);
		sexNotIni.setBounds(718, 298, 110, 27);
		add(sexNotIni);

		sexNotFim = new JFormattedTextField(new MaskFormatter("##:##"));
		sexNotFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexNotFim.setColumns(10);
		sexNotFim.setBounds(718, 337, 110, 27);
		add(sexNotFim);

		sabMatIni = new JFormattedTextField(new MaskFormatter("##:##"));
		sabMatIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sabMatIni.setColumns(10);
		sabMatIni.setBounds(848, 121, 110, 27);
		add(sabMatIni);

		sabMatFim = new JFormattedTextField(new MaskFormatter("##:##"));
		sabMatFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sabMatFim.setColumns(10);
		sabMatFim.setBounds(848, 159, 110, 27);
		add(sabMatFim);

		JLabel lblMsg = new JLabel("Informe seus hor\u00E1rios dispon\u00EDveis nos campos correspondentes");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMsg.setBounds(10, 11, 980, 38);
		add(lblMsg);

		JLabel lblMatutino = new JLabel("Matutino");
		lblMatutino.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatutino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatutino.setBounds(42, 121, 132, 65);
		add(lblMatutino);

		JLabel lblVespertino = new JLabel("Vespertino");
		lblVespertino.setHorizontalAlignment(SwingConstants.CENTER);
		lblVespertino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVespertino.setBounds(42, 211, 132, 63);
		add(lblVespertino);

		JLabel lblNoturno = new JLabel("Noturno");
		lblNoturno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoturno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoturno.setBounds(42, 298, 132, 66);
		add(lblNoturno);

		JLabel lblSegunda = new JLabel("Segunda-Feira");
		lblSegunda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSegunda.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegunda.setBounds(194, 73, 110, 23);
		add(lblSegunda);

		JLabel lblTera = new JLabel("Ter\u00E7a-Feira");
		lblTera.setHorizontalAlignment(SwingConstants.CENTER);
		lblTera.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTera.setBounds(326, 73, 110, 23);
		add(lblTera);

		JLabel lblQuartafeira = new JLabel("Quarta-Feira");
		lblQuartafeira.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuartafeira.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuartafeira.setBounds(458, 73, 107, 23);
		add(lblQuartafeira);

		JLabel lblQuintafeira = new JLabel("Quinta-Feira");
		lblQuintafeira.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuintafeira.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuintafeira.setBounds(587, 73, 109, 23);
		add(lblQuintafeira);

		JLabel lblSextafeira = new JLabel("Sexta-Feira");
		lblSextafeira.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSextafeira.setHorizontalAlignment(SwingConstants.CENTER);
		lblSextafeira.setBounds(718, 73, 108, 23);
		add(lblSextafeira);

		JLabel lblSbado = new JLabel("S\u00E1bado");
		lblSbado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSbado.setHorizontalAlignment(SwingConstants.CENTER);
		lblSbado.setBounds(848, 73, 110, 23);
		add(lblSbado);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(389, 453, 90, 27);
		btnCancelar.addActionListener(a -> {

		});
		add(btnCancelar);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(538, 453, 90, 27);
		btnEnviar.addActionListener(a -> {

		});
		add(btnEnviar);

		JSeparator separator = new JSeparator();
		separator.setBounds(32, 107, 937, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 197, 937, 3);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(314, 62, 2, 315);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(32, 285, 937, 2);
		add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(32, 375, 937, 2);
		add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(446, 62, 2, 315);
		add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(575, 62, 2, 315);
		add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(706, 62, 2, 315);
		add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(836, 62, 2, 315);
		add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setBounds(968, 62, 2, 315);
		add(separator_9);

		JSeparator separator_10 = new JSeparator();
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setBounds(184, 62, 2, 315);
		add(separator_10);

		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBounds(32, 109, 2, 268);
		add(separator_11);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(184, 60, 786, 2);
		add(separator_12);
	}
}
