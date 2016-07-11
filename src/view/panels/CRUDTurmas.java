package view.panels;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import classes.Classes;
import controller.ClassController;
import course.Course;
import discipline.Discipline;
import exception.InvalidParamsException;
import utils.NumericAndLengthFilter;
import view.dialogs.HoraryDialog;
import view.manager.UIManager;

public class CRUDTurmas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField qtdTurmas;
	private JTextField capacidade;
	private JTextField creditos;
    private JComboBox<Course> curso;
	private JComboBox<Discipline> disciplina;
	private ClassController classController;
	private List<Classes> classes;
	private boolean criar = true;
	private Classes classes1;

    private void limparCampo(JTextField nomeCampo) {
        ((AbstractDocument) nomeCampo.getDocument()).setDocumentFilter(null);
        nomeCampo.setText("");
        ((AbstractDocument) nomeCampo.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CRUDTurmas() {

        classController = new ClassController();
        qtdTurmas = new JTextField();
        JButton btnCriar = new JButton("Criar");
        JButton btnLimpar = new JButton("Limpar");

        ArrayList<Course> optionsCourse = classController.listCourses();
        optionsCourse.add(0, null);
        curso = new JComboBox(new DefaultComboBoxModel(optionsCourse.toArray()));
        curso.setBounds(669, 185, 235, 27);
        add(curso);

		ArrayList<Discipline> optionsDiscipline = classController.listDisciplines();
		optionsDiscipline.add(0, null);
		disciplina = new JComboBox(new DefaultComboBoxModel(optionsDiscipline.toArray()));
		disciplina.setBounds(669, 222, 235, 27);
		add(disciplina);

		DefaultTableModel tableModel = new DefaultTableModel();
		for (String coluna : new String[] { "Disciplina", "Turma", "Créditos" })
			tableModel.addColumn(coluna);
		table = new JTable(tableModel);
		table.setCellEditor(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(a -> {
			criar = false;
			int index = table.getSelectedRow();
			if (index != -1) {
				limparCampo(capacidade);
				limparCampo(creditos);
				classes1 = classes.get(index);
				capacidade.setText(classes1.getCapacity() + "");
				creditos.setText(classes1.getCredits() + "");
				disciplina.getModel().setSelectedItem(classes1.getDiscipline());
				btnCriar.setText("Salvar");
				btnCriar.repaint();
				btnLimpar.setText("Cancelar");
				btnLimpar.repaint();
				limparCampo(qtdTurmas);
				qtdTurmas.setEnabled(false);
				disciplina.setEnabled(false);
				curso.setEnabled(false);
			}
		});
		setLayout(null);

		preencherTabela();

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(47, 60, 410, 427);
		add(scroll);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(78, 537, 89, 27);
		btnAlterar.addActionListener(a -> {
			criar = false;
			int index = table.getSelectedRow();
			if (index != -1) {
				classes1 = classes.get(index);
				capacidade.setText(classes1.getCapacity() + "");
				creditos.setText(classes1.getCredits() + "");
				disciplina.getModel().setSelectedItem(classes1.getDiscipline());
				btnCriar.setText("Salvar");
				btnCriar.repaint();
                btnLimpar.setText("Cancelar");
                btnLimpar.repaint();
                limparCampo(qtdTurmas);
				qtdTurmas.setEnabled(false);
				disciplina.setEnabled(false);
                curso.setEnabled(false);
			}
		});
		add(btnAlterar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(204, 537, 89, 27);
		btnDeletar.addActionListener(a -> {
			int index = table.getSelectedRow();
			if (index != -1) {
                Classes selecionado = classes.get(index);
                Object[] confirme = { "Confirmar", "Cancelar" };
                int confirmar = JOptionPane.showOptionDialog(null, "Você irá excluir a turma: " + selecionado.getDiscipline().getName() + ", " +
                                selecionado.toString().replace("-", "do curso:") + ". Tem certeza?", "Confirmação",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirme, confirme[0]);
                if (confirmar == 0) {
                    classController.delete(selecionado.getId());
                    classes1 = null;
                    criar = true;
                    btnCriar.setText("Criar");
                    btnCriar.repaint();
                    btnLimpar.setText("Limpar");
                    btnLimpar.repaint();
                    qtdTurmas.setEnabled(true);
                    disciplina.setEnabled(true);
                    curso.setEnabled(true);
                    curso.setSelectedIndex(0);
                    disciplina.setSelectedIndex(0);
					limparCampo(capacidade);
					limparCampo(creditos);
					limparCampo(qtdTurmas);
                    preencherTabela();
                }
			}
		});
		add(btnDeletar);

		JButton btnSair = new JButton("Voltar");
		btnSair.setBounds(334, 537, 89, 27);
		btnSair.addActionListener(a -> UIManager.setPanel(new Menu()));
		add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 5, 2, 590);
		add(separator);

		JLabel lblCadastrarTurma = new JLabel("Cadastrar turma");
		lblCadastrarTurma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarTurma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrarTurma.setBounds(511, 145, 479, 27);
		add(lblCadastrarTurma);
        
        JLabel lblCursos = new JLabel("Curso:");
        lblCursos.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCursos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCursos.setBounds(521, 185, 138, 27);
        add(lblCursos);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisciplina.setBounds(521, 222, 138, 27);
		add(lblDisciplina);

        JLabel lblQuantidadeDeTurmas = new JLabel("Quantidade de turmas:");
        lblQuantidadeDeTurmas.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblQuantidadeDeTurmas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQuantidadeDeTurmas.setBounds(511, 265, 148, 14);
        add(lblQuantidadeDeTurmas);

        ((AbstractDocument) qtdTurmas.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
        qtdTurmas.setBounds(669, 260, 235, 27);
        add(qtdTurmas);
        qtdTurmas.setColumns(10);

		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidade.setBounds(531, 300, 128, 21);
		add(lblCapacidade);

		capacidade = new JTextField();
		((AbstractDocument) capacidade.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
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
		((AbstractDocument) creditos.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
		creditos.setBounds(669, 336, 235, 27);
		add(creditos);
		creditos.setColumns(10);

		btnCriar.setBounds(693, 375, 89, 27);
		btnCriar.addActionListener(a -> {
			if (criar) {
				try {
					new HoraryDialog(new JFrame(),(Course) curso.getSelectedItem(), (Discipline) disciplina.getSelectedItem(),
                            Integer.parseInt(capacidade.getText()), Integer.parseInt(creditos.getText()),
                            Integer.parseInt(qtdTurmas.getText()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha os dados", "Dados Inválidos",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				try {

					classController.update(classes1, Integer.parseInt(capacidade.getText()),
							Integer.parseInt(creditos.getText()));
					JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Alteração",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (InvalidParamsException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Dados Inválidos", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha os dados", "Dados Inválidos",
							JOptionPane.ERROR_MESSAGE);
				}
				classes1 = null;
				criar = true;
				btnCriar.setText("Criar");
				btnCriar.repaint();
                btnLimpar.setText("Limpar");
                btnLimpar.repaint();
				qtdTurmas.setEnabled(true);
				disciplina.setEnabled(true);
                curso.setEnabled(true);
			}
            curso.setSelectedIndex(0);
            disciplina.setSelectedIndex(0);
            limparCampo(qtdTurmas);
            limparCampo(capacidade);
            limparCampo(creditos);
			preencherTabela();
		});
		add(btnCriar);


		btnLimpar.setBounds(802, 375, 89, 27);
		btnLimpar.addActionListener(a -> {
            if (!criar) {
                classes1 = null;
                criar = true;
                btnCriar.setText("Criar");
                btnCriar.repaint();
                btnLimpar.setText("Limpar");
                btnLimpar.repaint();
                qtdTurmas.setEnabled(true);
                disciplina.setEnabled(true);
                curso.setEnabled(true);
            }
            curso.setSelectedIndex(0);
            disciplina.setSelectedIndex(0);
            limparCampo(qtdTurmas);
			limparCampo(capacidade);
            limparCampo(creditos);
        });
		add(btnLimpar);

	}

	private void preencherTabela() {
		classes = classController.listClasses();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int index = tableModel.getRowCount() - 1; index >= 0; index--)
			tableModel.removeRow(index);
		classes.forEach(classes2 -> {
			Object[] linha = new Object[3];
			linha[0] = classes2.getDiscipline().getName();
			linha[1] = classes2.getDiscipline().getId() + classes2.getClassNumber();
			linha[2] = classes2.getCredits();
			tableModel.addRow(linha);
		});
	}
}
