package view.panels;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class InformarHorariosLivres extends JPanel {

	private static final long serialVersionUID = 1L;

	public InformarHorariosLivres() throws ParseException {
		setLayout(null);

		JLabel lblMsg = new JLabel("Marque seus hor\u00E1rios dispon\u00EDveis nos campos correspondentes");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMsg.setBounds(10, 11, 980, 38);
		add(lblMsg);

		JLabel lblMatutino = new JLabel("Matutino");
		lblMatutino.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatutino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatutino.setBounds(42, 121, 132, 108);
		add(lblMatutino);

		JLabel lblVespertino = new JLabel("Vespertino");
		lblVespertino.setHorizontalAlignment(SwingConstants.CENTER);
		lblVespertino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVespertino.setBounds(42, 250, 132, 123);
		add(lblVespertino);

		JLabel lblNoturno = new JLabel("Noturno");
		lblNoturno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoturno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoturno.setBounds(42, 384, 132, 101);
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

		JCheckBox seg1 = new JCheckBox("07:30 - 08:20");
		seg1.setBounds(194, 111, 110, 23);
		add(seg1);

		JCheckBox seg2 = new JCheckBox("08:20 - 09:10");
		seg2.setBounds(194, 137, 110, 23);
		add(seg2);

		JCheckBox seg3 = new JCheckBox("09:10 - 10:00");
		seg3.setBounds(194, 163, 110, 23);
		add(seg3);

		JCheckBox seg4 = new JCheckBox("10:10 - 11:00");
		seg4.setBounds(194, 189, 110, 23);
		add(seg4);

		JCheckBox seg5 = new JCheckBox("11:00 - 11:50");
		seg5.setBounds(194, 215, 110, 23);
		add(seg5);

		JCheckBox seg6 = new JCheckBox("13:30 - 14:20");
		seg6.setBounds(194, 246, 110, 23);
		add(seg6);

		JCheckBox seg7 = new JCheckBox("14:20 - 15:10");
		seg7.setBounds(194, 272, 110, 23);
		add(seg7);

		JCheckBox seg8 = new JCheckBox("15:10 - 16:00");
		seg8.setBounds(194, 298, 110, 23);
		add(seg8);

		JCheckBox seg9 = new JCheckBox("16:20 - 17:10");
		seg9.setBounds(194, 324, 110, 23);
		add(seg9);

		JCheckBox seg10 = new JCheckBox("17:10 - 18:00");
		seg10.setBounds(194, 350, 110, 23);
		add(seg10);

		JCheckBox seg11 = new JCheckBox("18:30 - 19:20");
		seg11.setBounds(194, 384, 110, 23);
		add(seg11);

		JCheckBox seg12 = new JCheckBox("19:20 - 20:10");
		seg12.setBounds(194, 410, 110, 23);
		add(seg12);

		JCheckBox seg13 = new JCheckBox("20:20 - 21:10");
		seg13.setBounds(194, 436, 110, 23);
		add(seg13);

		JCheckBox seg14 = new JCheckBox("21:10 - 22:00");
		seg14.setBounds(194, 462, 110, 23);
		add(seg14);

		JCheckBox ter1 = new JCheckBox("07:30 - 08:20");
		ter1.setBounds(326, 111, 110, 23);
		add(ter1);

		JCheckBox ter2 = new JCheckBox("08:20 - 09:10");
		ter2.setBounds(326, 137, 110, 23);
		add(ter2);

		JCheckBox ter3 = new JCheckBox("09:10 - 10:00");
		ter3.setBounds(326, 163, 110, 23);
		add(ter3);

		JCheckBox ter4 = new JCheckBox("10:10 - 11:00");
		ter4.setBounds(326, 189, 110, 23);
		add(ter4);

		JCheckBox ter5 = new JCheckBox("11:00 - 11:50");
		ter5.setBounds(326, 215, 110, 23);
		add(ter5);

		JCheckBox ter6 = new JCheckBox("13:30 - 14:20");
		ter6.setBounds(326, 246, 110, 23);
		add(ter6);

		JCheckBox ter7 = new JCheckBox("14:20 - 15:10");
		ter7.setBounds(326, 272, 110, 23);
		add(ter7);

		JCheckBox ter8 = new JCheckBox("15:10 - 16:00");
		ter8.setBounds(326, 298, 110, 23);
		add(ter8);

		JCheckBox ter9 = new JCheckBox("16:20 - 17:10");
		ter9.setBounds(326, 324, 110, 23);
		add(ter9);

		JCheckBox ter10 = new JCheckBox("17:10 - 18:00");
		ter10.setBounds(326, 350, 110, 23);
		add(ter10);

		JCheckBox ter11 = new JCheckBox("18:30 - 19:20");
		ter11.setBounds(326, 384, 110, 23);
		add(ter11);

		JCheckBox ter12 = new JCheckBox("19:20 - 20:10");
		ter12.setBounds(326, 410, 110, 23);
		add(ter12);

		JCheckBox ter13 = new JCheckBox("20:20 - 21:10");
		ter13.setBounds(326, 436, 110, 23);
		add(ter13);

		JCheckBox ter14 = new JCheckBox("21:10 - 22:00");
		ter14.setBounds(326, 462, 110, 23);
		add(ter14);

		JCheckBox qua1 = new JCheckBox("07:30 - 08:20");
		qua1.setBounds(458, 111, 110, 23);
		add(qua1);

		JCheckBox qua2 = new JCheckBox("08:20 - 09:10");
		qua2.setBounds(458, 137, 110, 23);
		add(qua2);

		JCheckBox qua3 = new JCheckBox("09:10 - 10:00");
		qua3.setBounds(458, 163, 110, 23);
		add(qua3);

		JCheckBox qua4 = new JCheckBox("10:10 - 11:00");
		qua4.setBounds(458, 189, 110, 23);
		add(qua4);

		JCheckBox qua5 = new JCheckBox("11:00 - 11:50");
		qua5.setBounds(458, 215, 110, 23);
		add(qua5);

		JCheckBox qua6 = new JCheckBox("13:30 - 14:20");
		qua6.setBounds(458, 246, 110, 23);
		add(qua6);

		JCheckBox qua7 = new JCheckBox("14:20 - 15:10");
		qua7.setBounds(458, 272, 110, 23);
		add(qua7);

		JCheckBox qua8 = new JCheckBox("15:10 - 16:00");
		qua8.setBounds(458, 298, 110, 23);
		add(qua8);

		JCheckBox qua9 = new JCheckBox("16:20 - 17:10");
		qua9.setBounds(458, 324, 110, 23);
		add(qua9);

		JCheckBox qua10 = new JCheckBox("17:10 - 18:00");
		qua10.setBounds(458, 350, 110, 23);
		add(qua10);

		JCheckBox qua11 = new JCheckBox("18:30 - 19:20");
		qua11.setBounds(458, 384, 110, 23);
		add(qua11);

		JCheckBox qua12 = new JCheckBox("19:20 - 20:10");
		qua12.setBounds(458, 410, 110, 23);
		add(qua12);

		JCheckBox qua13 = new JCheckBox("20:20 - 21:10");
		qua13.setBounds(458, 436, 110, 23);
		add(qua13);

		JCheckBox qua14 = new JCheckBox("21:10 - 22:00");
		qua14.setBounds(458, 462, 110, 23);
		add(qua14);

		JCheckBox qui1 = new JCheckBox("07:30 - 08:20");
		qui1.setBounds(587, 111, 110, 23);
		add(qui1);

		JCheckBox qui2 = new JCheckBox("08:20 - 09:10");
		qui2.setBounds(587, 137, 110, 23);
		add(qui2);

		JCheckBox qui3 = new JCheckBox("09:10 - 10:00");
		qui3.setBounds(587, 163, 110, 23);
		add(qui3);

		JCheckBox qui4 = new JCheckBox("10:10 - 11:00");
		qui4.setBounds(587, 189, 110, 23);
		add(qui4);

		JCheckBox qui5 = new JCheckBox("11:00 - 11:50");
		qui5.setBounds(587, 215, 110, 23);
		add(qui5);

		JCheckBox qui6 = new JCheckBox("13:30 - 14:20");
		qui6.setBounds(587, 246, 110, 23);
		add(qui6);

		JCheckBox qui7 = new JCheckBox("14:20 - 15:10");
		qui7.setBounds(587, 272, 110, 23);
		add(qui7);

		JCheckBox qui8 = new JCheckBox("15:10 - 16:00");
		qui8.setBounds(587, 298, 110, 23);
		add(qui8);

		JCheckBox qui9 = new JCheckBox("16:20 - 17:10");
		qui9.setBounds(587, 324, 110, 23);
		add(qui9);

		JCheckBox qui10 = new JCheckBox("17:10 - 18:00");
		qui10.setBounds(587, 350, 110, 23);
		add(qui10);

		JCheckBox qui11 = new JCheckBox("18:30 - 19:20");
		qui11.setBounds(587, 384, 110, 23);
		add(qui11);

		JCheckBox qui12 = new JCheckBox("19:20 - 20:10");
		qui12.setBounds(587, 410, 110, 23);
		add(qui12);

		JCheckBox qui13 = new JCheckBox("20:20 - 21:10");
		qui13.setBounds(587, 436, 110, 23);
		add(qui13);

		JCheckBox qui14 = new JCheckBox("21:10 - 22:00");
		qui14.setBounds(587, 462, 110, 23);
		add(qui14);

		JCheckBox sex1 = new JCheckBox("07:30 - 08:20");
		sex1.setBounds(716, 111, 110, 23);
		add(sex1);

		JCheckBox sex2 = new JCheckBox("08:20 - 09:10");
		sex2.setBounds(716, 137, 110, 23);
		add(sex2);

		JCheckBox sex3 = new JCheckBox("09:10 - 10:00");
		sex3.setBounds(716, 163, 110, 23);
		add(sex3);

		JCheckBox sex4 = new JCheckBox("10:10 - 11:00");
		sex4.setBounds(716, 189, 110, 23);
		add(sex4);

		JCheckBox sex5 = new JCheckBox("11:00 - 11:50");
		sex5.setBounds(716, 215, 110, 23);
		add(sex5);

		JCheckBox sex6 = new JCheckBox("13:30 - 14:20");
		sex6.setBounds(716, 246, 110, 23);
		add(sex6);

		JCheckBox sex7 = new JCheckBox("14:20 - 15:10");
		sex7.setBounds(716, 272, 110, 23);
		add(sex7);

		JCheckBox sex8 = new JCheckBox("15:10 - 16:00");
		sex8.setBounds(716, 298, 110, 23);
		add(sex8);

		JCheckBox sex9 = new JCheckBox("16:20 - 17:10");
		sex9.setBounds(716, 324, 110, 23);
		add(sex9);

		JCheckBox sex10 = new JCheckBox("17:10 - 18:00");
		sex10.setBounds(716, 350, 110, 23);
		add(sex10);

		JCheckBox sex11 = new JCheckBox("18:30 - 19:20");
		sex11.setBounds(716, 384, 110, 23);
		add(sex11);

		JCheckBox sex12 = new JCheckBox("19:20 - 20:10");
		sex12.setBounds(716, 410, 110, 23);
		add(sex12);

		JCheckBox sex13 = new JCheckBox("20:20 - 21:10");
		sex13.setBounds(716, 436, 110, 23);
		add(sex13);

		JCheckBox sex14 = new JCheckBox("21:10 - 22:00");
		sex14.setBounds(716, 462, 110, 23);
		add(sex14);

		JCheckBox sab1 = new JCheckBox("07:30 - 08:20");
		sab1.setBounds(848, 111, 110, 23);
		add(sab1);

		JCheckBox sab2 = new JCheckBox("08:20 - 09:10");
		sab2.setBounds(848, 137, 110, 23);
		add(sab2);

		JCheckBox sab3 = new JCheckBox("09:10 - 10:00");
		sab3.setBounds(848, 163, 110, 23);
		add(sab3);

		JCheckBox sab4 = new JCheckBox("10:10 - 11:00");
		sab4.setBounds(848, 189, 110, 23);
		add(sab4);

		JCheckBox sab5 = new JCheckBox("11:00 - 11:50");
		sab5.setBounds(848, 215, 110, 23);
		add(sab5);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(393, 509, 90, 27);
		btnCancelar.addActionListener(a -> {

		});
		add(btnCancelar);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(542, 509, 90, 27);
		btnEnviar.addActionListener(a -> {

		});
		add(btnEnviar);

		JSeparator separator = new JSeparator();
		separator.setBounds(32, 107, 937, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 240, 937, 3);
		add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(32, 380, 937, 2);
		add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(32, 490, 937, 2);
		add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(446, 62, 2, 430);
		add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(575, 62, 2, 430);
		add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(706, 62, 2, 430);
		add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(836, 62, 2, 430);
		add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setBounds(968, 62, 2, 430);
		add(separator_9);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(184, 60, 786, 2);
		add(separator_12);

		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBounds(32, 109, 2, 381);
		add(separator_11);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(314, 62, 2, 430);
		add(separator_2);

		JSeparator separator_10 = new JSeparator();
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setBounds(184, 62, 2, 430);
		add(separator_10);

	}
}
