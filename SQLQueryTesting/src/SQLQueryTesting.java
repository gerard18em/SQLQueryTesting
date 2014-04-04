import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe per mostrar la finestra pricipal
 * 
 * @author Adri� i Gerard
 * 
 */
public class SQLQueryTesting extends JFrame {

	XMLParser parser;
	ConnectionHandler connection;

	/**
	 * Classe principal del programa
	 * 
	 * @param args
	 *            No s'utilitza
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

	public SQLQueryTesting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		add(new LoginPanel(this));
		setVisible(true);
		setResizable(false);
		connection = new ConnectionHandler();
	}

	// M�tode per obtenir la configuraci� de la base de dades (XML) i
	// parsejar-lo
	public void getXMLConf() {
		parser = new XMLParser();
		parser.setPath("/databases.xml");
		parser.build();
		parser.setTagName("database");
	}

	// M�tode per canviar de finestres
	public void changeTo(JPanel nextPanel) {
		getContentPane().removeAll();
		getContentPane().add(nextPanel);
		revalidate();
		repaint();

	}

}
