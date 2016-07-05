package controller;

import static javax.swing.JOptionPane.OK_OPTION;
import static utils.Constants.CONTROLLER;

import javax.swing.JOptionPane;

import professor.Professor;

public class WorkLoadController implements IController {

	public WorkLoadController() {}

	@Override
	public void loadData() {}

	public void parseData(String researchP, String extensionP, String admP) {

		int reseach = Integer.parseInt(researchP);
		int extension = Integer.parseInt(extensionP);
		int adm = Integer.parseInt(admP);

		if ((reseach + extension + adm) < 33 && (reseach + extension + adm) > 7) {
			save(reseach, extension, adm);
		} else {
			JOptionPane.showMessageDialog(null, "Carga horária informada fora do permitido!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void save(int reseach, int extension, int adm) {
		Professor professor = CONTROLLER.getLoggedUser();
		professor.setAdm(adm);
		professor.setExtension(extension);
		professor.setResearch(reseach);
		boolean save = CONTROLLER.getUserService().save(professor);
		if (save)
			CONTROLLER.setLoggedUser(professor);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", null, OK_OPTION);
	}

}
