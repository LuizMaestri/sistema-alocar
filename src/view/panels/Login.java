package view.panels;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exception.InvalidLoginException;
import exception.InvalidParamsException;
import exception.NotExistException;
import view.manager.UIManager;
import static utils.Constants.CONTROLLER;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField password;
	private JTextField textLogin;

	public Login() {
		setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(345, 250, 46, 14);
		add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(345, 281, 46, 14);
		add(lblSenha);

		password = new JPasswordField();
		password.setBounds(401, 275, 216, 27);
		add(password);

		textLogin = new JTextField();
		textLogin.setBounds(401, 244, 216, 27);
		add(textLogin);
		textLogin.setColumns(10);

		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(315, 212, 364, 173);
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		add(label);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(464, 332, 89, 27);
		btnLogin.addActionListener(a -> {
			try {
				char[] chars = password.getPassword();
				String password2 = String.valueOf(chars);
				Long id = Long.parseLong(textLogin.getText());
				CONTROLLER.login(id, password2);
				UIManager.setPanel(new MenuTeste());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Usuário Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidLoginException | InvalidParamsException | NotExistException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btnLogin);
		
	}
}
