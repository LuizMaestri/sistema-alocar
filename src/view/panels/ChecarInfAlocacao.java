package view.panels;

import allocate.Allocate;
import controller.AllocationController;
import view.manager.UIManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static utils.Constants.HOURS;

public class ChecarInfAlocacao extends JPanel {

	private static final long serialVersionUID = 1L;

	public ChecarInfAlocacao() {
		setLayout(null);

		AllocationController controller = new AllocationController();
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

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(40, 59, 423, 461);
		add(scroll);

		JButton btnSair = new JButton("Voltar");
		btnSair.setBounds(206, 550, 89, 27);
		btnSair.addActionListener(a -> UIManager.setPanel(new Menu()));
		add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 5, 2, 590);
		add(separator);

		JTextPane textPane = new JTextPane();
		textPane.setText(
				allocate != null?
						allocate.getError() != null?
								allocate.getError().getMessage()
								: "Alocação realizada com sucesso!"
						: "Sem tentativas de alocação anteriores"
		);
		textPane.setEditable(false);
		textPane.setBounds(538, 59, 423, 508);
		add(textPane);

		JLabel lblErros = new JLabel("Informações");
		lblErros.setHorizontalAlignment(SwingConstants.CENTER);
		lblErros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErros.setBounds(538, 11, 423, 37);
		add(lblErros);
	}
}
