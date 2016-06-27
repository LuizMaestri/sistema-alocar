package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.manager.UIManager;

public class MenuTeste extends JPanel {

	private static final long serialVersionUID = 1L;

	public MenuTeste() {
		setLayout(null);

		JButton btnAlocarLaboratorio = new JButton("Alocar Laboratório");
		btnAlocarLaboratorio.setBounds(420, 124, 222, 35);
		btnAlocarLaboratorio.addActionListener(a -> {
			UIManager.setPanel(new AlocarLaboratorio());
		});
		add(btnAlocarLaboratorio);

		JButton btnAlocarTurma = new JButton("Alocar Turma");
		btnAlocarTurma.setBounds(420, 170, 222, 35);
		btnAlocarTurma.addActionListener(a -> {
			UIManager.setPanel(new AlocarTurma());
		});
		add(btnAlocarTurma);

		JButton btnAssociarProfA = new JButton("Associar Prof a Disc");
		btnAssociarProfA.setBounds(420, 216, 222, 35);
		btnAssociarProfA.addActionListener(a -> {
			UIManager.setPanel(new AssociarProfDisc());
		});
		add(btnAssociarProfA);

		JButton btnChecarInfoDe = new JButton("Checar info de Aloc");
		btnChecarInfoDe.setBounds(420, 262, 222, 35);
		btnChecarInfoDe.addActionListener(a -> {
			UIManager.setPanel(new ChecarInfAlocacao());
		});
		add(btnChecarInfoDe);

		JButton btnCrudTurmas = new JButton("CRUD Turmas");
		btnCrudTurmas.setBounds(420, 308, 222, 35);
		btnCrudTurmas.addActionListener(a -> {
			UIManager.setPanel(new CRUDTurmas());
		});
		add(btnCrudTurmas);

		JButton btnInformarCargasHorarias = new JButton("Informar Cargas Horárias");
		btnInformarCargasHorarias.setBounds(420, 354, 222, 35);
		btnInformarCargasHorarias.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarCargasHoraria());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnInformarCargasHorarias);

		JButton btnSolicitarAlocacao = new JButton("Solicitar Alocaaao");
		btnSolicitarAlocacao.setBounds(420, 446, 222, 35);
		btnSolicitarAlocacao.addActionListener(a -> {
			try {
				UIManager.setPanel(new SolicitarAlocacaoLaboratorio());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnSolicitarAlocacao);

		JButton btnInformarHorariosLivres = new JButton("Informar Horarios Livres");
		btnInformarHorariosLivres.setBounds(420, 400, 222, 35);
		btnInformarHorariosLivres.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarHorariosLivres());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(btnInformarHorariosLivres);
	}

}
