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

	}

	public void buildConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + IP + "/"
					+ databaseName, userName, password);
		} catch (SQLException e) {
			new Exception();
		}
	}
	
	public void doStatement(String query){
		Statement statement = connection.createStatement();
		statement
				.executeUpdate(query);
		System.out.println("......Taula creada......");
	}

}
