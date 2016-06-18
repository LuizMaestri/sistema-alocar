package view.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InformarCargasHoraria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField pesquisa, extensao, administrativa;

	public InformarCargasHoraria() {
		setLayout(null);

		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesquisa.setBounds(169, 177, 150, 14);
		add(lblPesquisa);

		JLabel lblExtenso = new JLabel("Extens\u00E3o:");
		lblExtenso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExtenso.setBounds(425, 177, 150, 14);
		add(lblExtenso);

		JLabel lblAdministrativa = new JLabel("Administrativa:");
		lblAdministrativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdministrativa.setBounds(674, 177, 150, 14);
		add(lblAdministrativa);

		pesquisa = new JTextField();
		pesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pesquisa.setBounds(169, 202, 150, 27);
		add(pesquisa);
		pesquisa.setColumns(10);

		extensao = new JTextField();
		extensao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		extensao.setBounds(425, 202, 150, 27);
		add(extensao);
		extensao.setColumns(10);

		administrativa = new JTextField();
		administrativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		administrativa.setBounds(674, 202, 150, 27);
		add(administrativa);
		administrativa.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(373, 286, 89, 27);
		btnSalvar.addActionListener(a -> {

		});
		add(btnSalvar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(510, 286, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);
	}

}
