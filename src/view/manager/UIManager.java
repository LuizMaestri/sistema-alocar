package view.manager;

import view.Window;
import view.panels.Login;
import java.awt.Component;
import java.io.File;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UIManager {

	private static Window prog;

	private static void open(String title) {
		String iconPath = "resources" + File.separator + "icone.png";
		LookAndFeel.aparenciaNimbus();
		prog = new Window();
		setPanel(new Login());
		prog.setTitle(title);
		prog.pack();
		prog.setIconImage(new ImageIcon(iconPath).getImage());
		prog.setDefaultCloseOperation(EXIT_ON_CLOSE);
		prog.setSize(1000, 650);
		prog.setLocationRelativeTo(null);
		prog.setResizable(false);
		prog.setVisible(true);
	}

	public static void setPanel(JPanel panel) {
		JPanel currentPanel = prog.getPanel();
		currentPanel.removeAll();
		for (Component comp : panel.getComponents())
			currentPanel.add(comp);
		String backPath = "resources" + File.separator + "background.jpg";
		currentPanel.add(new JLabel(new ImageIcon(backPath))).setBounds(0, 0, 1000, 600);
		currentPanel.repaint();
	}

	public static void run() {
		open("Sistema Alocador");
	}
}
