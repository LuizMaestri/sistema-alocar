package view.panels;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import classes.Classes;
import controller.ClassController;
import discipline.Discipline;

public class CRUDTurmas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField qtdTurmas;
	private JTextField capacidade;
	private JTextField creditos;
	private JComboBox<Discipline> disciplina;
	private ClassController classController;
	private List<Classes> classes;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CRUDTurmas() {
		classController = new ClassController();
		DefaultTableModel tableModel = new DefaultTableModel();
		for (String coluna: new String[]{"Disciplina", "Turma", "Créditos"})
			tableModel.addColumn(coluna);
		table = new JTable(tableModel);
		setLayout(null);


		preencherTabela();

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(47, 60, 410, 427);
		add(scroll);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(78, 537, 89, 27);
		btnAlterar.addActionListener(a -> {
			// TODO criar método para achar quantidade de turmas e pensar
			// em como alterar os outras turmas da disciplina
			int index = table.getSelectedRow();
			Classes classes1 = classes.get(index);
			capacidade.setText(classes1.getCapacity()+"");
			creditos.setText(classes1.getCredits()+"");
			disciplina.setSelectedIndex(0);
			//qtdTurmas.setText();
		});
		add(btnAlterar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(204, 537, 89, 27);
		btnDeletar.addActionListener(a -> {
			int index = table.getSelectedRow();
			classController.delete(classes.get(index).getId());
			preencherTabela();
		});
		add(btnDeletar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(334, 537, 89, 27);
		btnSair.addActionListener(a -> {
			
		});
		add(btnSair);


		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 5, 2, 590);
		add(separator);
		

		JLabel lblCadastrarTurma = new JLabel("Cadastrar turma");
		lblCadastrarTurma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarTurma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrarTurma.setBounds(511, 141, 479, 27);
		add(lblCadastrarTurma);
		
		JLabel lblQuantidadeDeTurmas = new JLabel("Quantidade de turmas:");
		lblQuantidadeDeTurmas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeDeTurmas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidadeDeTurmas.setBounds(511, 230, 148, 14);
		add(lblQuantidadeDeTurmas);
		
		qtdTurmas = new JTextField();
		qtdTurmas.setBounds(669, 222, 235, 27);
		add(qtdTurmas);
		qtdTurmas.setColumns(10);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisciplina.setBounds(521, 265, 138, 22);
		add(lblDisciplina);		
		
		disciplina =
				new JComboBox(
						new DefaultComboBoxModel(
								classController.listDisciplines().toArray()
								)
						);
		disciplina.setBounds(669, 260, 235, 27);
		add(disciplina);
		
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

		JLabel lblCreditos = new JLabel("Créditos:");
		lblCreditos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreditos.setBounds(511, 336, 148, 25);
		add(lblCreditos);		
		
		creditos = new JTextField();
		creditos.setBounds(669, 336, 235, 27);
		add(creditos);
		creditos.setColumns(10);		
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(693, 375, 89, 27);
		btnCriar.addActionListener(a -> {

			//TODO IF (se existir id no banco de dados, jogar mensagem de erro "já existe"

			//ELSE o fazer já pronto + mensagem de sucesso(fazer).
			classController.save(Integer.parseInt(capacidade.getText()),
					(Discipline)disciplina.getSelectedItem(), Integer.parseInt(creditos.getText()),
					Integer.parseInt(qtdTurmas.getText())
					);

			preencherTabela();
		});
		add(btnCriar);

		//TODO criar um segundo botão para salvar depois de clicar em alterar (setVisible)
		//fazer os botoões como atributos da classe não variaveis do método

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(802, 375, 89, 27);
		btnLimpar.addActionListener(a -> {
			capacidade.setText("");
			creditos.setText("");
			disciplina.setSelectedIndex(0);
			qtdTurmas.setText("");
		});
		add(btnLimpar);		
		
	}

	private void preencherTabela(){
		classes = classController.listClasses();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int index = tableModel.getRowCount()-1; index >= 0; index--)
			tableModel.removeRow(index);
		for (Classes classes2 : classes) {
			Object[] linha = new Object[3];
			linha[0] = classes2.getDiscipline().getName();
			linha[1] = classes2.getDiscipline().getId() + classes2.getClassNumber();
			linha[2] = classes2.getCredits();
			tableModel.addRow(linha);
		}
	}
}
