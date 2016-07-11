package view.dialogs;

import controller.ClassController;
import course.Course;
import discipline.Discipline;
import exception.InvalidParamsException;
import utils.Constants;
import utils.DayOfWeek;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.EnumMap;

import static utils.Constants.*;

/**
 * @author luiz-maestri
 *         11/07/16.
 */
public class HoraryDialog extends JDialog {

    private EnumMap<DayOfWeek, ArrayList<Integer>> horary;

    public HoraryDialog(Frame frame, Course curso, Discipline disciplina, int capacidade, int creditos, int qtdTurmas) {
        super(frame);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //getContentPane().setLayout(null);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        horary = new EnumMap<>(DayOfWeek.class);
        setSize(300, 500);

        criarComboBox();
        JLabel segunda = new JLabel("Segunda-feira");
        add(segunda).setBounds(10, 10, 89, 27);
        JLabel terca = new JLabel("Terça-feira");
        add(terca).setBounds(10, 80, 89, 27);
        JLabel quarta = new JLabel("Quarta-feira");
        add(quarta).setBounds(10, 150, 89, 27);
        JLabel quinta = new JLabel("Quinta-feira");
        add(quinta).setBounds(10, 210, 89, 27);
        JLabel sexta = new JLabel("Sexta-feira");
        add(sexta).setBounds(10, 280, 89, 27);
        JLabel sabado = new JLabel("Sábado");
        add(sabado).setBounds(10, 350, 89, 27);
        JButton botao = new JButton("salvar");
        botao.addActionListener(e -> {
            try {
                new ClassController().save(curso, disciplina,
                        capacidade, creditos, qtdTurmas, horary);
            } catch (InvalidParamsException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Dados Inválidos", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Criado com sucesso", "Criação",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
        add(botao).setBounds(10, 420, 89, 27);
    }

    private void criarComboBox(){
        int len = HOURS.length;
        String[] hoursIni = new String[len];
        String[] hoursFim = new String[len];
        String[] saturdayIni = new String[len];
        String[] saturdayFim = new String[len];
        for (int index = 0; index < len; index++) {
            hoursIni[index] = HOURS[index].split(" - ")[0];
            hoursFim[index] = HOURS[index].split(" - ")[1];
        }
        for (int index = 0; index < 6; index++) {
            saturdayIni[index] = HOURS[index].split(" - ")[0];
            saturdayFim[index] = HOURS[index].split(" - ")[1];
        }
        for(int index = 0; index < 6; index++){
            JComboBox<String> comboIni = new JComboBox<>(index != 5?hoursIni: saturdayIni);
            JComboBox<String> comboFim = new JComboBox<>(index != 5?hoursFim: saturdayFim);
            final int finalIndex = index;
            comboIni.insertItemAt("Inicio da aula", 0);
            comboIni.addItemListener(a -> action(finalIndex, comboIni, comboFim));
            comboIni.setSelectedIndex(0);
            add(comboIni).setBounds(10, 37 + 70* index, 120, 27);
            comboFim.insertItemAt("Final da aula", 0);
            comboFim.setSelectedIndex(0);
            comboFim.addItemListener(a -> action(finalIndex, comboIni, comboFim));
            add(comboFim).setBounds(160, 37 + 70* index, 120, 27);
        }
    }
    
    private void action(int index, JComboBox<String> comboIni, JComboBox<String> comboFim){
        DayOfWeek key = DayOfWeek.values()[index];
        horary.remove(key);
        int indexIni = comboIni.getSelectedIndex() - 1;
        int indexFim = comboFim.getSelectedIndex() - 1;
        if (indexIni != -1 && indexFim != -1 && indexIni <= indexFim){
            ArrayList<Integer> hours = new ArrayList<>();
            for (;indexIni <= indexFim; indexIni++) hours.add(indexIni);
            horary.put(key, hours);
        }
    }
}
