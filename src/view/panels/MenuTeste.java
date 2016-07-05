package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.manager.UIManager;
import static utils.Constants.CONTROLLER;

public class MenuTeste extends JPanel {

	private static final long serialVersionUID = 1L;

	public MenuTeste() {
		setLayout(null);

		JButton btnAlocarLaboratorio = new JButton("Alocar Laborat�rio");
		btnAlocarLaboratorio.setBounds(404, 124, 222, 35);
		btnAlocarLaboratorio.addActionListener(a -> UIManager.setPanel(new AlocarLaboratorio()));
		add(btnAlocarLaboratorio);

		JButton btnAlocarTurma = new JButton("Alocar Turma");
		btnAlocarTurma.setBounds(404, 170, 222, 35);
		btnAlocarTurma.addActionListener(a -> UIManager.setPanel(new AlocarTurma()));
		add(btnAlocarTurma);

		JButton btnAssociarProfA = new JButton("Associar Professor � Disciplina");
		btnAssociarProfA.setBounds(404, 216, 222, 35);
		btnAssociarProfA.addActionListener(a -> UIManager.setPanel(new AssociarProfDisc()));
		add(btnAssociarProfA);

		JButton btnChecarInfoDe = new JButton("Checar informa��es de Aloca��o");
		btnChecarInfoDe.setBounds(404, 262, 222, 35);
		btnChecarInfoDe.addActionListener(a -> UIManager.setPanel(new ChecarInfAlocacao()));
		add(btnChecarInfoDe);

		JButton btnCrudTurmas = new JButton("CRUD Turmas");
		btnCrudTurmas.setBounds(404, 308, 222, 35);
		btnCrudTurmas.addActionListener(a -> UIManager.setPanel(new CRUDTurmas()));
		add(btnCrudTurmas);

		JButton btnInformarCargasHorarias = new JButton("Informar Cargas Hor�rias");
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

		JButton btnSolicitarAlocacao = new JButton("Solicitar Aloca��o");
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

		JButton btnInformarHorariosLivres = new JButton("Informar Hor�rios Livres");
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
		btnLogout.addActionListener(e ->{
			CONTROLLER.Logout();
            UIManager.setPanel(new Login());
		});
		btnLogout.setBounds(855, 538, 89, 27);
		add(btnLogout);
	}
}
