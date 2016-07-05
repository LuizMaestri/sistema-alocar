package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.manager.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTeste extends JPanel {

	private static final long serialVersionUID = 1L;

	public MenuTeste() {
		setLayout(null);

		JButton btnAlocarLaboratorio = new JButton("Alocar Laboratório");
		btnAlocarLaboratorio.setBounds(404, 124, 222, 35);
		btnAlocarLaboratorio.addActionListener(a -> {
			UIManager.setPanel(new AlocarLaboratorio());
		});
		add(btnAlocarLaboratorio);

		JButton btnAlocarTurma = new JButton("Alocar Turma");
		btnAlocarTurma.setBounds(404, 170, 222, 35);
		btnAlocarTurma.addActionListener(a -> {
			UIManager.setPanel(new AlocarTurma());
		});
		add(btnAlocarTurma);

		JButton btnAssociarProfA = new JButton("Associar Professor à Disciplina");
		btnAssociarProfA.setBounds(404, 216, 222, 35);
		btnAssociarProfA.addActionListener(a -> {
			UIManager.setPanel(new AssociarProfDisc());
		});
		add(btnAssociarProfA);

		JButton btnChecarInfoDe = new JButton("Checar informações de Alocação");
		btnChecarInfoDe.setBounds(404, 262, 222, 35);
		btnChecarInfoDe.addActionListener(a -> {
			UIManager.setPanel(new ChecarInfAlocacao());
		});
		add(btnChecarInfoDe);

		JButton btnCrudTurmas = new JButton("CRUD Turmas");
		btnCrudTurmas.setBounds(404, 308, 222, 35);
		btnCrudTurmas.addActionListener(a -> {
			UIManager.setPanel(new CRUDTurmas());
		});
		add(btnCrudTurmas);

		JButton btnInformarCargasHorarias = new JButton("Informar Cargas Horárias");
		btnInformarCargasHorarias.setBounds(404, 354, 222, 35);
		btnInformarCargasHorarias.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarCargasHoraria());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnInformarCargasHorarias);

		JButton btnSolicitarAlocacao = new JButton("Solicitar Alocação");
		btnSolicitarAlocacao.setBounds(404, 446, 222, 35);
		btnSolicitarAlocacao.addActionListener(a -> {
			try {
				UIManager.setPanel(new SolicitarAlocacaoLaboratorio());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnSolicitarAlocacao);

		JButton btnInformarHorariosLivres = new JButton("Informar Horários Livres");
		btnInformarHorariosLivres.setBounds(404, 400, 222, 35);
		btnInformarHorariosLivres.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarHorariosLivres());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnInformarHorariosLivres);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(855, 538, 89, 27);
		add(btnLogout);
	}
}
