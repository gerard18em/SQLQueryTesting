import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

	public boolean buildConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + IP + "/"
					+ databaseName, userName, password);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void doStatement(String query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// Arreglar, sempre ho realitza encara que no existeixi
		} catch (Exception e) {
			e.printStackTrace();
			new Exception();
		}
	}

}
