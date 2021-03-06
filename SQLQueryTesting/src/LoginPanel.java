import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe per mostrar el login amb la validaci� de DB
 * 
 * @author Adri� i Gerard
 * 
 */
public class LoginPanel extends JPanel {

	private JTextField txtUser, txtPassword;
	private JLabel txtIP, txtPort, lblError;
	private JComboBox cmbDB;
	private SQLQueryTesting sqt;

	/**
	 * Create the panel.
	 */
	public LoginPanel(final SQLQueryTesting sqt) {
		this.sqt = sqt;
		setLayout(null);

		cmbDB = new JComboBox();
		cmbDB.setBounds(149, 27, 167, 20);
		add(cmbDB);
		sqt.getXMLConf();
		ArrayList<String> result = sqt.parser.getDatabaseNames();
		for (String e : result) {
			cmbDB.addItem(e);
		}
		cmbDB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Recollim les dades del Port iIP
				txtIP.setText(sqt.parser.getIP(cmbDB.getSelectedItem()
						.toString()));
				txtPort.setText(sqt.parser.getPort(cmbDB.getSelectedItem()
						.toString()));
			}
		});
		JLabel lblUsuari = new JLabel("Usuari:");
		lblUsuari.setBounds(50, 72, 64, 14);
		add(lblUsuari);

		JLabel lblContrasenya = new JLabel("Contrasenya:");
		lblContrasenya.setBounds(50, 111, 79, 14);
		add(lblContrasenya);

		JLabel lblIp = new JLabel("IP: ");
		lblIp.setBounds(50, 150, 46, 14);
		add(lblIp);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(50, 193, 46, 14);
		add(lblPort);

		txtUser = new JTextField();
		txtUser.setBounds(149, 69, 86, 20);
		add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(149, 108, 86, 20);
		add(txtPassword);
		txtPassword.setColumns(10);

		txtIP = new JLabel();
		txtIP.setBounds(149, 144, 86, 20);
		add(txtIP);

		txtPort = new JLabel();
		txtPort.setBounds(149, 187, 86, 20);
		add(txtPort);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Configurar la connexi� amb les dades introduides
				sqt.connection.setConf(txtUser.getText().toString(),
						txtPassword.getText().toString(), txtIP.getText()
								.toString(), txtPort.getText().toString(),
						cmbDB.getSelectedItem().toString());
				// Validar Usuari-Psw
				validateUser();
			}

		});
		btnLogin.setBounds(121, 239, 89, 23);
		add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("");
				txtPassword.setText("");
				txtIP.setText("");
				txtPort.setText("");
				cmbDB.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(232, 239, 89, 23);
		add(btnReset);

		JLabel lblBaseDades = new JLabel("Base Dades:");
		lblBaseDades.setBounds(50, 30, 79, 14);
		add(lblBaseDades);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 218, 330, 14);
		add(lblError);

	}

	/**
	 * M�tode per validar un usuari
	 */
	public void validateUser() {
		// Si la connexi� es correcta canvia al panell de consultes SQL, sino,
		// ens avisa amb un missatge d'error de connexi�.
		if (!sqt.connection.buildConnection()) {
			lblError.setText("Error de connexi�");
		} else {
			sqt.changeTo(new QueryPanel(sqt));

		}

	}
}
