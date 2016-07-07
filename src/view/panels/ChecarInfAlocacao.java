package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import allocate.Allocate;
import classes.Classes;
import classes.ClassesService;
import controller.AllocationController;
import room.Room;
import view.manager.UIManager;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ChecarInfAlocacao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public ChecarInfAlocacao() {
		setLayout(null);

		AllocationController controller = new AllocationController();
		Allocate allocate = controller.getInfos();

		DefaultTableModel tableModel = new DefaultTableModel();
		for (String coluna : new String[] { "Turma", "Sala", "Horário", "Créditos" })
			tableModel.addColumn(coluna);
		ArrayList<Classes> classes = new ArrayList<>();
		allocate.getRooms().forEach(room -> {
			room.getOccupation().entrySet().forEach(day ->  {
				controller.getClasses(day.getValue()).forEach(classes1 -> {
					boolean contains = classes.contains(classes1);

				});
			});
		});
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(40, 59, 423, 461);
		add(scroll);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(206, 550, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 5, 2, 590);
		add(separator);

		JTextPane textPane = new JTextPane();
		textPane.setText(
				"fhfghfgjfgjxfth kuytrwretjyk.kjytseawrQEWRTEHKJHK.HGKJT EWRewrasedfykgulytrstearwtesrydtuyklk; hluktrteawrqeqewratesydfgul hjkhtarwQERTEYDUFGKLI\u00C7\u00C7");
		textPane.setEditable(false);
		textPane.setBounds(538, 59, 423, 508);
		add(textPane);

		JLabel lblErros = new JLabel("Erros");
		lblErros.setHorizontalAlignment(SwingConstants.CENTER);
		lblErros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErros.setBounds(538, 11, 423, 37);
		add(lblErros);
	}

}
