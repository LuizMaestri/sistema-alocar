package controller;

import static utils.Constants.CONTROLLER;

import javax.swing.JOptionPane;

import professor.Professor;

public class WorkLoadController implements IController {

	public WorkLoadController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

	public void verificarDados(String pesquisaP, String extensaoP, String administrativaP) {

		int pesquisa = Integer.parseInt(pesquisaP);
		int extensao = Integer.parseInt(extensaoP);
		int administrativa = Integer.parseInt(administrativaP);

		if ((pesquisa + extensao + administrativa) < 33 && (pesquisa + extensao + administrativa) > 7) {
			salvarCargaHoraria(pesquisa, extensao, administrativa);
		} else {
			JOptionPane.showMessageDialog(null, "Carga horária informada fora do permitido!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void salvarCargaHoraria(int pesquisa, int extensao, int administrativa) {
		Professor professor = CONTROLLER.getLoggedUser();
		professor.setAdm(administrativa);
		professor.setExtension(extensao);
		professor.setResearch(pesquisa);
		boolean save = CONTROLLER.getUserService().save(professor);
		if (save)
			CONTROLLER.setLoggedUser(professor);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", null, JOptionPane.OK_OPTION);
	}

}
