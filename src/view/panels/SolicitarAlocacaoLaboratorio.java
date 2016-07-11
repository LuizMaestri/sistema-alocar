package view.panels;

import classes.Classes;
import controller.RequestCheckController;
import exception.InvalidParamsException;
import room.Room;
//import sun.plugin2.message.ShowStatusMessage;
import view.manager.UIManager;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import static java.awt.Color.WHITE;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class SolicitarAlocacaoLaboratorio extends JPanel {

	private static final long serialVersionUID = 1L;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SolicitarAlocacaoLaboratorio() throws ParseException {
		setLayout(null);

		RequestCheckController controller = new RequestCheckController();

		Font tahoma12 = new Font("Tahoma", PLAIN, 12);
		Font tahoma9 = new Font("Tahoma", PLAIN, 9);
        Font dialog12 = new Font("Dialog", PLAIN, 12);

        JComboBox<Room> laboratorio = new JComboBox(new DefaultComboBoxModel(controller.getLabs().toArray()));
		laboratorio.setFont(tahoma12);
		add(laboratorio).setBounds(423, 84, 180, 27);

        JTextField periodoFim = new JFormattedTextField(new MaskFormatter("##/##/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
		periodoFim.setColumns(10);
		add(periodoFim).setBounds(525, 226, 86, 27);

        JTextField periodoIni = new JFormattedTextField(new MaskFormatter("##/##/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
		periodoIni.setColumns(10);
		add(periodoIni).setBounds(379, 226, 86, 27);

        JCheckBox[] semana = new JCheckBox[6];
        semana[0] = new JCheckBox("Segunda-Feira");
		add( semana[0]).setBounds(341, 332, 124, 23);

        semana[1] = new JCheckBox("Terça-Feira");
		add(semana[1]).setBounds(341, 366, 124, 23);

        semana[2] = new JCheckBox("Quarta-Feira");
		add(semana[2]).setBounds(481, 332, 122, 23);

        semana[3] = new JCheckBox("Quinta-Feira");
		add(semana[3]).setBounds(481, 366, 122, 23);

        semana[4] = new JCheckBox("Sexta-Feira");
		add(semana[4]).setBounds(609, 332, 102, 23);

        semana[5] = new JCheckBox("Sábado");
        add(semana[5]).setBounds(609, 366, 97, 23);

        JComboBox<Classes> turma = new JComboBox(new DefaultComboBoxModel(controller.getClasses().toArray()));
        turma.setFont(tahoma12);
        turma.addItemListener(e -> {
            laboratorio.setSelectedIndex(0);
            for (JCheckBox checkBox : semana) checkBox.setSelected(false);
            ((Classes) turma.getModel().getSelectedItem()).getHorary().entrySet().forEach(day ->{
                if (day.getValue() != null) semana[day.getKey().ordinal()].setSelected(true);
            });
        });
        add(turma).setBounds(423, 130, 180, 27);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(tahoma12);
		lblDe.setHorizontalAlignment(RIGHT);
        add(lblDe).setBounds(335, 229, 40, 14);

		JLabel lblA = new JLabel("a", CENTER);
		lblA.setFont(dialog12);
		add(lblA).setBounds(475, 229, 40, 14);

		JLabel lblPeriodo = new JLabel("Período: ");
		lblPeriodo.setFont(dialog12);
		add(lblPeriodo).setBounds(338, 188, 89, 14);

		JLabel lblExDdmm = new JLabel("ex: dd/mm/aaaa", RIGHT);
		lblExDdmm.setFont(tahoma9);
		add(lblExDdmm).setBounds(379, 254, 86, 14);

		JLabel label_1 = new JLabel("ex: dd/mm/aaaa", RIGHT);
		label_1.setFont(tahoma9);
		add(label_1).setBounds(525, 254, 86, 14);

		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label.setBackground(WHITE);
		add(label).setBounds(335, 205, 302, 67);

		JLabel lblSolicitaoDeAlocacao = new JLabel("Solicitação de alocação de laboratório", CENTER);
		lblSolicitaoDeAlocacao.setFont(new Font("Tahoma", BOLD, 14));
		add(lblSolicitaoDeAlocacao).setBounds(10, 11, 980, 27);

		JLabel label_2 = new JLabel("");
		label_2.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label_2.setBackground(WHITE);
        add(label_2).setBounds(335, 320, 386, 79);

		JLabel lblDiasDaSemana = new JLabel("Dias da semana:");
		lblDiasDaSemana.setFont(tahoma12);
        add(lblDiasDaSemana).setBounds(335, 298, 118, 23);

		JLabel lblLaboratorio = new JLabel("Laboratório: ", RIGHT);
		lblLaboratorio.setFont(tahoma12);
        add(lblLaboratorio).setBounds(335, 87, 78, 14);

		JLabel lblTurma = new JLabel("Turma:", RIGHT);
		lblTurma.setFont(tahoma12);
		add(lblTurma).setBounds(335, 133, 78, 14);
		
		JButton btnSolicitarLaboratorio = new JButton("Solicitar Laboratório");
		btnSolicitarLaboratorio.addActionListener(a -> {
            ArrayList<Integer> dias = new ArrayList<>();
            for (int index = 0, len = semana.length; index < len; index++)
                if (semana[index].isSelected())
                    dias.add(index);
            try {
                controller.save(periodoIni.getText(), periodoFim.getText(), laboratorio.getSelectedItem(), turma.getSelectedItem(), dias);
                showMessageDialog(null, "Solicitação enviada com sucesso", "Criação", INFORMATION_MESSAGE);
            } catch (InvalidParamsException e) {
                showMessageDialog(null, e.getMessage(), "Erro", ERROR_MESSAGE);
            }
        });
		add(btnSolicitarLaboratorio).setBounds(372, 455, 143, 27);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(a -> UIManager.setPanel(new Menu()));
		add(btnSair).setBounds(563, 455, 89, 27);
		
	}
}
