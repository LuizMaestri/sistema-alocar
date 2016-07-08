package view.panels;

import controller.AssociationController;
import professor.Professor;
import view.manager.UIManager;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;

import static java.awt.Font.*;
import static javax.swing.SwingConstants.CENTER;

public class AssociarProfDisc extends JPanel {

	private static final long serialVersionUID = 1L;

	public AssociarProfDisc() {
		setLayout(null);

        AssociationController controller = new AssociationController();
        ArrayList<Professor> all = controller.getProfessor();
        ArrayList<Professor> add = controller.getProfessor();

        DefaultListModel<Professor> listModel = new DefaultListModel<>();
        all.forEach(listModel::addElement);
        JList<Professor> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list)).setBounds(141, 119, 300, 361);

        DefaultListModel<Professor> listModelAdd = new DefaultListModel<>();
        add.forEach(listModelAdd::addElement);
        JList<Professor> listAdd = new JList<>(listModelAdd);
        listAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(listAdd)).setBounds(553, 119, 300, 361);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(a -> {
            controller.save(add);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		});
		add(btnSalvar).setBounds(390, 546, 89, 27);

		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(a -> UIManager.setPanel(new Menu()));
		add(btnSair).setBounds(516, 546, 89, 27);

		JButton btnAdd = new JButton(">>");
		btnAdd.addActionListener(a -> {
            int index = list.getSelectedIndex();
            if (index != -1){
                add.forEach(listModelAdd::removeElement);
                all.forEach(listModel::removeElement);
                add.add(all.remove(index));
                all.forEach(listModel::addElement);
                add.forEach(listModelAdd::addElement);
            }
        });
		add(btnAdd).setBounds(471, 269, 54, 23);

		JButton btnRemove = new JButton("<<");
		btnRemove.addActionListener(a -> {
            int index = listAdd.getSelectedIndex();
            if (index != -1){
                add.forEach(listModelAdd::removeElement);
                all.forEach(listModel::removeElement);
                all.add(add.remove(index));
                all.forEach(listModel::addElement);
                add.forEach(listModelAdd::addElement);
            }
		});
		add(btnRemove).setBounds(471, 305, 54, 23);

        Font font = new Font("Tahoma", BOLD, 14);
		JLabel lblProfessores = new JLabel("Professores", CENTER);
		lblProfessores.setFont(font);
		add(lblProfessores).setBounds(141, 80, 300, 28);

		JLabel lblAssociados = new JLabel("Associados", CENTER);
		lblAssociados.setFont(font);
		add(lblAssociados).setBounds(553, 80, 300, 28);

		JLabel lblTitulo = new JLabel(
                "Selecione os professores capacitados a ministrar as disciplinas",
                CENTER
        );
		lblTitulo.setFont(font);
		add(lblTitulo).setBounds(141, 11, 712, 43);
	}
}
