package view.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AssociarProfDisc extends JPanel {

	private static final long serialVersionUID = 1L;
	

	public AssociarProfDisc() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 29, 250, 27);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(107, 67, 250, 27);
		add(comboBox_1);
		
		JButton btnAssociar = new JButton("Associar");
		btnAssociar.setBounds(106, 138, 89, 27);
		btnAssociar.addActionListener(a -> {

		});
		add(btnAssociar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(268, 138, 89, 27);
		btnSair.addActionListener(a -> {

		});
		add(btnSair);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProfessor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessor.setBounds(10, 31, 87, 14);
		add(lblProfessor);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisciplina.setBounds(20, 72, 77, 14);
		add(lblDisciplina);
		
		
	}
}
