package view.panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.manager.UIManager;

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
		label.setBackground(new Color(255, 255, 255	));
		label.setBounds(315, 212, 364, 173);
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		add(label);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(464, 332, 89, 27);		
		btnLogin.addActionListener(a -> {
			UIManager.setPanel(new MenuTeste());
		});
		add(btnLogin);
	}
}
