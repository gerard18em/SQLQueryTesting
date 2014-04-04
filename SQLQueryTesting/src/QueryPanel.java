import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe per realitzar les operacions SQL
 * 
 * @author Adrià i Gerard
 * 
 */
public class QueryPanel extends JPanel {

	SQLQueryTesting sqt;
	JTextArea textArea;

	/**
	 * Constructor del panell de fer sentències
	 * 
	 * @param sqt
	 *            Classe principal
	 */
	public QueryPanel(final SQLQueryTesting sqt) {
		// És la finestra principal
		this.sqt = sqt;

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 351, 190);
		add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnExecute = new JButton("EXECUTA");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// VErifica si la sentencia és correcta o no. Mostra un missatge
				// de confirmació segons el resultat
				if (sqt.connection.doStatement(textArea.getText().toString())) {
					JOptionPane.showMessageDialog(sqt,
							"Query executed sucefully.");
				} else {
					JOptionPane.showMessageDialog(sqt,
							"A problem ocurred, aborting query.");

				}

			}
		});
		btnExecute.setBounds(248, 212, 110, 56);
		add(btnExecute);

	}
}
