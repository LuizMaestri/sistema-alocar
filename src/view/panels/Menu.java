package view.panels;

import javax.swing.*;

import controller.AllocationController;
import exception.AllocationProfessorException;
import exception.AllocationRoomException;
import gpda.GPDAService;
import labs.LabsRequest;
import labs.LabsRequestService;
import professor.Professor;
import view.manager.UIManager;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static utils.Constants.CONTROLLER;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		setLayout(null);
        Professor professor = CONTROLLER.getLoggedUser();

        LabsRequestService requestService = new LabsRequestService();
        ArrayList<LabsRequest> requests = requestService.getList().stream()
				.filter(request -> professor.equals(request.getClasses().getProfessor()))
				.collect(Collectors.toCollection(ArrayList::new));

		requests.forEach(request -> {
            ArrayList<String> date = request.getDate();
			String msg = "Sua Solicitação de Laboraório para a turma " +
					request.getClasses() + "no periodo de" + date.get(0) + " à " +
                    date.get(1) + (request.isApproved() ? ", " : ", não ") + "Foi Aprovada.";
			JOptionPane.showMessageDialog(null, msg, "Solicitão de Laboratório", JOptionPane.INFORMATION_MESSAGE);
            requestService.delete(request.getId());
		});

        JButton btnAlocarLaboratorio = new JButton("Alocar Laboratário");
        btnAlocarLaboratorio.setBounds(404, 124, 222, 35);
        btnAlocarLaboratorio.addActionListener(a -> UIManager.setPanel(new AlocarLaboratorio()));
        add(btnAlocarLaboratorio).setEnabled(professor.isAdmin());

        JButton btnAlocarTurma = new JButton("Alocar Turma");
        btnAlocarTurma.setBounds(404, 170, 222, 35);
        btnAlocarTurma.addActionListener(a -> {
			try {
				AllocationController controller = new AllocationController();
				controller.clean();
				controller.allocateClasses();
			} catch (NullPointerException | AllocationProfessorException | AllocationRoomException e) {
				JOptionPane.showMessageDialog(
						null,
						"Não foi possivel Realizar a alocação",
						"Erro ao Alocar",
						JOptionPane.ERROR_MESSAGE
				);
			}
			UIManager.setPanel(new AlocarTurma());
		});
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
