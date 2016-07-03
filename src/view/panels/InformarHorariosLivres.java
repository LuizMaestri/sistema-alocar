package view.panels;

import utils.DayOfWeek;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.HourController;
import exception.InvalidParamsException;
import view.manager.UIManager;

public class InformarHorariosLivres extends JPanel {

    private static final long serialVersionUID = 1L;
    private EnumMap<DayOfWeek, ArrayList<Integer>> freeTime = new EnumMap<>(DayOfWeek.class);

    public InformarHorariosLivres() {
        setLayout(null);

        JLabel lblMsg = new JLabel("Marque seus horários disponíveis nos campos correspondentes");
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

        JLabel lblTerca = new JLabel("Terça-Feira");
        lblTerca.setHorizontalAlignment(SwingConstants.CENTER);
        lblTerca.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTerca.setBounds(326, 73, 110, 23);
        add(lblTerca);

        JLabel lblQuarta = new JLabel("Quarta-Feira");
        lblQuarta.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuarta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuarta.setBounds(458, 73, 107, 23);
        add(lblQuarta);

        JLabel lblQuinta = new JLabel("Quinta-Feira");
        lblQuinta.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuinta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuinta.setBounds(587, 73, 109, 23);
        add(lblQuinta);

        JLabel lblSexta = new JLabel("Sexta-Feira");
        lblSexta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSexta.setHorizontalAlignment(SwingConstants.CENTER);
        lblSexta.setBounds(718, 73, 108, 23);
        add(lblSexta);

        JLabel lblSabado = new JLabel("Sábado");
        lblSabado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSabado.setHorizontalAlignment(SwingConstants.CENTER);
        lblSabado.setBounds(848, 73, 110, 23);
        add(lblSabado);

        DayOfWeek[] days = DayOfWeek.values();
        for (int index = 0; index < days.length; index++)
            startComboBox(new  JCheckBox[!days[index].isSaturday()? 14: 5], days[index], 194 + 132*index);

        JButton btnCancelar = new JButton("Voltar");
        btnCancelar.setBounds(393, 509, 90, 27);
        btnCancelar.addActionListener(a -> UIManager.setPanel(new MenuTeste()));
        add(btnCancelar);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(542, 509, 90, 27);
        btnEnviar.addActionListener(a -> {
        	try {
				new HourController().updateFreeTime(freeTime);
			} catch (InvalidParamsException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Por favor, preencha os dados", JOptionPane.ERROR_MESSAGE);
			}
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
    
    private void startComboBox(JCheckBox[] combo, DayOfWeek day, int x){
        String[] horarios = {
                "07:30 - 08:20", "08:20 - 09:10", "09:10 - 10:00", "10:10 - 11:00", "11:00 - 11:50",
                "13:30 - 14:20", "14:20 - 15:10", "15:10 - 16:00", "16:20 - 17:10", "17:10 - 18:00",
                "18:30 - 19:20", "19:20 - 20:10", "20:20 - 21:10", "21:10 - 22:00"
        };
        for (int index = 0; index < combo.length; index++){
            combo[index] = new JCheckBox(horarios[index]);
            int y = 111 + index * 26;
            if (index > 4) y += 5;
            if (index > 9) y += 8;
            combo[index].setBounds(x, y, 110, 23);
            add(combo[index]);
            int finalIndex = index;
            combo[index].addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    ArrayList<Integer> integers = freeTime.get(day);
                    if (integers == null) integers = new ArrayList<>();
                    integers.add(finalIndex);
                    freeTime.put(day, integers);
                } else {
                    ArrayList<Integer> integers = freeTime.get(day);
                    integers.remove(new Integer(finalIndex));
                    freeTime.put(day, integers);
                }
            });
        }
    }
}
