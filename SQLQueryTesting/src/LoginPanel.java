import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPanel extends JPanel {
	private JTextField txtUser;
	private JTextField txtPassword;
	private JLabel txtIP;
	private JLabel txtPort;
	private JComboBox cmbDB;
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		cmbDB = new JComboBox();
		cmbDB.setBounds(124, 27, 167, 20);
		add(cmbDB);
		
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
		txtUser.setBounds(124, 69, 86, 20);
		add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(124, 108, 86, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtIP = new JLabel();
		txtIP.setBounds(124, 147, 86, 20);
		add(txtIP);
		
		txtPort = new JLabel();
		txtPort.setBounds(124, 190, 86, 20);
		add(txtPort);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(121, 239, 89, 23);
		add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("");
				txtPassword.setText("");
				txtIP.setText("");
				txtPort.setText("");
				cmbDB.setSelectedIndex(0);
			}
		});
		btnCancel.setBounds(232, 239, 89, 23);
		add(btnCancel);
		
		JLabel lblBaseDades = new JLabel("Base Dades:");
		lblBaseDades.setBounds(50, 30, 64, 14);
		add(lblBaseDades);

	}
}
