package view.panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CRUDTurmas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField qtdTurmas;
	private JTextField capacidade;

	public CRUDTurmas() {
		setLayout(null);

		String[] colunas = { "Disciplina", "Turma", "Créditos"};
		Object[][] dados = { { "APS", "3456", "4"} };

		table = new JTable(dados, colunas);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(47, 60, 410, 427);
		add(scroll);

		String[] lista = { "", "teste" };

		JComboBox comboBox = new JComboBox(lista);
		comboBox.setBounds(669, 260, 235, 27);
		add(comboBox);

		textField = new JTextField();
		textField.setBounds(669, 336, 235, 27);
		add(textField);
		textField.setColumns(10);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(693, 375, 89, 27);
		btnCriar.addActionListener(a -> {

		});
		add(btnCriar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(802, 375, 89, 27);
		btnCancelar.addActionListener(a -> {

		});
		add(btnCancelar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(78, 537, 89, 27);
		btnAlterar.addActionListener(a -> {

		});
		add(btnAlterar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(204, 537, 89, 27);
		btnDeletar.addActionListener(a -> {

		});
		add(btnDeletar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(334, 537, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisciplina.setBounds(521, 265, 138, 22);
		add(lblDisciplina);

		JLabel lblCrditos = new JLabel("Cr\u00E9ditos:");
		lblCrditos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCrditos.setBounds(511, 336, 148, 25);
		add(lblCrditos);

		JLabel lblCadastrarTurma = new JLabel("Cadastrar turma");
		lblCadastrarTurma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarTurma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrarTurma.setBounds(511, 141, 479, 27);
		add(lblCadastrarTurma);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 5, 2, 590);
		add(separator);
		
		JLabel lblQuantidadeDeTurmas = new JLabel("Quantidade de turmas:");
		lblQuantidadeDeTurmas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeDeTurmas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidadeDeTurmas.setBounds(511, 230, 148, 14);
		add(lblQuantidadeDeTurmas);
		
		qtdTurmas = new JTextField();
		qtdTurmas.setBounds(669, 222, 235, 27);
		add(qtdTurmas);
		qtdTurmas.setColumns(10);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidade.setBounds(531, 300, 128, 21);
		add(lblCapacidade);
		
		capacidade = new JTextField();
		capacidade.setText("");
		capacidade.setBounds(669, 298, 235, 27);
		add(capacidade);
		capacidade.setColumns(10);

	}
}
