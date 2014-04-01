import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class QueryPanel extends JPanel {
	
	SQLQueryTesting sqt;
	JTextArea textArea;
	
	public QueryPanel(final SQLQueryTesting sqt) {
		
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
				try {
					sqt.connection.doStatement(textArea.getText().toString());
					JOptionPane.showMessageDialog(sqt, "Query executed sucefully.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(sqt, "A problem ocurred, aborting query.");
				}
			}
		});
		btnExecute.setBounds(248, 212, 110, 56);
		add(btnExecute);

	}
}
