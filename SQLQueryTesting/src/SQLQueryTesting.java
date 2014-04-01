import java.awt.EventQueue;

import javax.swing.JFrame;

public class SQLQueryTesting extends JFrame {
	XMLParser parser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLQueryTesting frame = new SQLQueryTesting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SQLQueryTesting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		add(new LoginPanel(this));
		setVisible(true);
		setResizable(false);
	}

	public void getXMLConf() {
		parser = new XMLParser();
		parser.setPath("/databases.xml");
		parser.build();
		parser.setTagName("database");
	}
}
