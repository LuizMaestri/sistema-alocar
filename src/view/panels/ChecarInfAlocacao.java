package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import view.manager.UIManager;

import javax.swing.JLabel;
import java.awt.Font;

public class ChecarInfAlocacao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public ChecarInfAlocacao() {
		setLayout(null);

		String[] colunas = { "Turma", "Sala", "Horário", "Créditos" };
		Object[][] dados = { { "3456", "234", "18:30", "4" } };
		table = new JTable(dados, colunas);
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
