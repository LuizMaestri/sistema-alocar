package view.panels;

import allocate.Allocate;
import controller.AllocationController;
import view.manager.UIManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static utils.Constants.HOURS;

public class AlocarTurma extends JPanel {
	private static final long serialVersionUID = 1L;

	public AlocarTurma() {
		setLayout(null);

        AllocationController controller = new AllocationController();

		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.addActionListener(e -> {

        });
		add(btnAlocar).setBounds(446, 488, 89, 27);

		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(e -> UIManager.setPanel(new Menu()));
		add(btnSair).setBounds(603, 488, 89, 27);

		Allocate allocate = controller.getInfos();
		DefaultTableModel tableModel = new DefaultTableModel();
		for (String coluna : new String[] { "Turma", "Professor", "Sala", "Horário", "Créditos" })
			tableModel.addColumn(coluna);
		if (allocate != null)
			allocate.getRooms().forEach(room ->
					room.getOccupation().entrySet().forEach(day ->
							controller.getClasses(day.getValue()).forEach(classes -> {
								ArrayList<String> hourString = new ArrayList<>();
								classes.getHorary().get(day.getKey()).forEach(hour ->hourString.add(HOURS[hour]));
								Object[] linha = new Object[5];
								linha[0] = classes.toString();
								linha[1] = classes.getProfessor().getName();
								linha[2] = room.toString();
								linha[3] = day + "  " +
										hourString.get(0).split("-")[0] + "-" +
										hourString.get(hourString.size() - 1).split("-")[1];
								linha[0] = hourString.size();
								tableModel.addRow(linha);
							})
					)
			);
		JTable table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);

		add(new JScrollPane(table)).setBounds(47, 60, 901, 355);

        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.addActionListener(e -> {

        });
        add(btnImprimir).setBounds(300, 486, 89, 27);

	}
}
