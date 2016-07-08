package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import gpda.GPDAService;
import professor.Professor;
import view.manager.UIManager;
import static utils.Constants.CONTROLLER;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		setLayout(null);
        Professor professor = CONTROLLER.getLoggedUser();

        JButton btnAlocarLaboratorio = new JButton("Alocar Laboratário");
        btnAlocarLaboratorio.setBounds(404, 124, 222, 35);
        btnAlocarLaboratorio.addActionListener(a -> UIManager.setPanel(new AlocarLaboratorio()));
        add(btnAlocarLaboratorio).setEnabled(professor.isAdmin());

        JButton btnAlocarTurma = new JButton("Alocar Turma");
        btnAlocarTurma.setBounds(404, 170, 222, 35);
        btnAlocarTurma.addActionListener(a -> UIManager.setPanel(new AlocarTurma()));
        add(btnAlocarTurma).setEnabled(professor.isAdmin());

        JButton btnCrudTurmas = new JButton("CRUD Turmas");
        btnCrudTurmas.setBounds(404, 308, 222, 35);
        btnCrudTurmas.addActionListener(a -> UIManager.setPanel(new CRUDTurmas()));
        add(btnCrudTurmas).setEnabled(professor.isAdmin());

        JButton btnAssociarProfA = new JButton("Associar Professor ao GPDA");
        btnAssociarProfA.setBounds(404, 216, 222, 35);
        btnAssociarProfA.addActionListener(a -> UIManager.setPanel(new AssociarProfDisc()));
        add(btnAssociarProfA).setEnabled(new GPDAService().getByCoordinator(professor) != null);

		JButton btnChecarInfoDe = new JButton("Checar informações de Alocação");
		btnChecarInfoDe.setBounds(404, 262, 222, 35);
		btnChecarInfoDe.addActionListener(a -> UIManager.setPanel(new ChecarInfAlocacao()));
		add(btnChecarInfoDe);

		JButton btnInformarCargasHorarias = new JButton("Informar Cargas Horárias");
		btnInformarCargasHorarias.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarCargasHoraria());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		add(btnInformarCargasHorarias).setBounds(404, 354, 222, 35);

		JButton btnSolicitarAlocacao = new JButton("Solicitar Alocação");
		btnSolicitarAlocacao.addActionListener(a -> {
			try {
				UIManager.setPanel(new SolicitarAlocacaoLaboratorio());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		add(btnSolicitarAlocacao).setBounds(404, 446, 222, 35);

		JButton btnInformarHorariosLivres = new JButton("Informar Horários Livres");
		btnInformarHorariosLivres.addActionListener(a -> {
			try {
				UIManager.setPanel(new InformarHorariosLivres());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		add(btnInformarHorariosLivres).setBounds(404, 400, 222, 35);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(e ->{
			CONTROLLER.Logout();
            UIManager.setPanel(new Login());
		});
		add(btnLogout).setBounds(855, 538, 89, 27);
	}
}
