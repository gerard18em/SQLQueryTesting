import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe per realitzar la connexió amb la DB configurada al Login
 * 
 * @author Adrià i Gerard
 * 
 */
public class ConnectionHandler {

	String userName, password, IP, port, databaseName;
	Connection connection;

	public ConnectionHandler() {

	}

	public void setConf(String userName, String password, String IP,
			String port, String databaseName) {
		this.userName = userName;
		this.password = password;
		this.IP = IP;
		this.port = port;
		this.databaseName = databaseName;
	}

	/**
	 * Construeix la connexió MySQL
	 * 
	 * @return true si la connexió s'ha realitzar correctament (False, en cas
	 *         contrari)
	 */
	public boolean buildConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + IP + "/"
					+ databaseName, userName, password);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Mètode per a realitzar la consulta SQL
	 * 
	 * @param query
	 *            consulta a realitzar (SQL)
	 * @return true si la consulta s'ha realitzar correctament (False, en cas
	 *             contrari)
	 */
	public boolean doStatement(String query) {
		try {
			Statement statement = connection.createStatement();
			// Comprovació que comença amb SELECT i ho transforma en minuscula
			if (query.toLowerCase().startsWith("select")) {
				if (statement.executeQuery(query) != null) {
					return true;
				}
			} else {
				if (statement.executeUpdate(query) != 0) {
					return true;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
