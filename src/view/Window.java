package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import view.manager.UIManager;
import view.panels.MenuTeste;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;

	public Window() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 21);

		menuBar.add(new JMenu("Ajuda"))
                .add(new JMenuItem("Menu principal"))
                .addActionListener(a -> {
        			UIManager.setPanel(new MenuTeste());
        		});
		setJMenuBar(menuBar);

		panel = new JPanel(null, true);
		this.getContentPane().add(panel);
	}

	public JPanel getPanel() {
		return panel;
	}

}
