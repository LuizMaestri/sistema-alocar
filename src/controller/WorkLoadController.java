package controller;

import javax.swing.JOptionPane;

import professor.Professor;
import professor.ProfessorService;
import view.manager.UIManager;

public class WorkLoadController implements IController {

	public WorkLoadController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

	public void verificarDados(String pesquisaP, String extensaoP, String administrativaP) {
		int max = 32;
		
		int pesquisa = Integer.parseInt(pesquisaP);
		int extensao = Integer.parseInt(extensaoP);
		int administrativa = Integer.parseInt(administrativaP);

		if ((pesquisa + extensao + administrativa) <= max) {
			salvarCargaHoraria(pesquisa, extensao, administrativa);
		} else {
			JOptionPane.showMessageDialog(null, "Garga informada superior ao permitido!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void salvarCargaHoraria(int pesquisa, int extensao, int administrativa) {
		UserController controller = UIManager.getController();
		Professor professor = controller.getLoggedUser();
		professor.setAdm(administrativa);
		professor.setExtension(extensao);
		professor.setResearch(pesquisa);
		controller.getUserService().save(professor);
	}

}
