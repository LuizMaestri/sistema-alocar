package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AlocarTurma extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;

	public AlocarTurma() {
		setLayout(null);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(300, 486, 89, 27);
		add(btnImprimir);

		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.setBounds(446, 488, 89, 27);
		add(btnAlocar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(603, 488, 89, 27);
		add(btnSair);

		String[] colunas = { "Professor", "Turma", "Disciplina", "Horário", "Créditos", "Sala" };
		Object[][] dados = { { "Fulano", "3456", "APS", "18:30", "4", "109" },
				{ "Ciclano", "3456", "APS", "18:30", "4", "109" } };
		table = new JTable(dados, colunas);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(47, 60, 901, 355);
		add(scroll);

	}
}
