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

		int research = Integer.parseInt(researchP);
		int extension = Integer.parseInt(extensionP);
		int adm = Integer.parseInt(admP);

		if ((research + extension + adm) < 33 && (research - extension - adm) > 7) {
			save(research, extension, adm);
		} else {
			JOptionPane.showMessageDialog(null, "Carga horária informada fora do permitido!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void save(int research, int extension, int adm) {
		Professor professor = CONTROLLER.getLoggedUser();
		professor.setAdm(adm);
		professor.setExtension(extension);
		professor.setResearch(research);
		if (CONTROLLER.getUserService().save(professor))
			CONTROLLER.setLoggedUser(professor);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
	}

}
