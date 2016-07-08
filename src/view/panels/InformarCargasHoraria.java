package view.panels;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import utils.NumericAndLengthFilter;

import controller.WorkLoadController;
import view.manager.UIManager;

import static utils.Constants.CONTROLLER;

public class InformarCargasHoraria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField pesquisa, extensao, administrativa;
	private WorkLoadController workLoad = new WorkLoadController();

	public InformarCargasHoraria() throws ParseException {
		setLayout(null);

		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPesquisa.setBounds(169, 177, 150, 14);
		add(lblPesquisa);

		JLabel lblExtensao = new JLabel("Extensão:");
		lblExtensao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExtensao.setBounds(425, 177, 150, 14);
		add(lblExtensao);

		JLabel lblAdministrativa = new JLabel("Administrativa:");
		lblAdministrativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdministrativa.setBounds(674, 177, 150, 14);
		add(lblAdministrativa);

		pesquisa = new JTextField();
		((AbstractDocument) pesquisa.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
		pesquisa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pesquisa.setBounds(169, 202, 150, 27);
		pesquisa.setText(CONTROLLER.getLoggedUser().getResearch()+"");
		add(pesquisa);
		pesquisa.setColumns(10);

		extensao = new JTextField();
		((AbstractDocument) extensao.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
		extensao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		extensao.setBounds(425, 202, 150, 27);
		extensao.setText(CONTROLLER.getLoggedUser().getExtension()+"");
		add(extensao);
		extensao.setColumns(10);

		administrativa = new JTextField();
		((AbstractDocument) administrativa.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
		administrativa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		administrativa.setBounds(674, 202, 150, 27);
		administrativa.setText(CONTROLLER.getLoggedUser().getAdm()+"");
		add(administrativa);
		administrativa.setColumns(10);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(373, 286, 89, 27);
		btnEnviar.addActionListener(a -> workLoad.parseData(pesquisa.getText(), extensao.getText(), administrativa.getText()));
		add(btnEnviar);

		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setBounds(510, 286, 89, 27);
		btnCancelar.addActionListener(a -> UIManager.setPanel(new Menu()));
		add(btnCancelar);
	}

}
