package view.panels;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AssociarProfDisc extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList list, listAdd;
	private DefaultListModel listModel, listModelAdd;

	public AssociarProfDisc() {
		setLayout(null);

		list = new JList();
		listModel = new DefaultListModel();
		list.setModel(listModel);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(141, 119, 300, 361);
		list.addListSelectionListener(arg0 -> {

		});
		add(scroll);

		listAdd = new JList();
		listModelAdd = new DefaultListModel();
		listAdd.setModel(listModelAdd);
		JScrollPane scrollAdd = new JScrollPane(listAdd);
		scrollAdd.setBounds(553, 119, 300, 361);
		add(scrollAdd);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(390, 546, 89, 27);
		btnSalvar.addActionListener(a -> {

		});
		add(btnSalvar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(516, 546, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);

		JButton btnAdd = new JButton(">>");
		btnAdd.setBounds(471, 269, 54, 23);
		btnAdd.addActionListener(a -> {
			list.getSelectedValue();

			listModel.clear();
			listModelAdd.clear();
		});
		add(btnAdd);

		JButton btnRemove = new JButton("<<");
		btnRemove.setBounds(471, 305, 54, 23);
		btnRemove.addActionListener(a -> {
			// associado = new Associado(listAdd.getSelectedValue());
			// listaAssociados.add(associado);
			// listaProfessores.remove(id);
			listModel.clear();
			listModelAdd.removeElement(list.getSelectedValue());

		});
		add(btnRemove);

		JLabel lblProfessores = new JLabel("Professores");
		lblProfessores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfessores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessores.setBounds(141, 80, 300, 28);
		add(lblProfessores);

		JLabel lblAssociados = new JLabel("Associados");
		lblAssociados.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssociados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAssociados.setBounds(553, 80, 300, 28);
		add(lblAssociados);

		JLabel lblTitulo = new JLabel("Selecione os professores capacitados a ministrar as disciplinas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(141, 11, 712, 43);
		add(lblTitulo);

	}
}
