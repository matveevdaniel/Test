import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	String userName = "root";
	String password = "root";
	String connectionUrl = "jdbc:mysql://localhost:3306/db_danik";

	// Class.forName("com.mysql.jdbc.Driver");
	try (Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {

	    Statement statement = conn.createStatement();
	    statement.executeUpdate("DROP TABLE IF EXISTS Book");
	    statement.executeUpdate(
	         "CREATE TABLE IF NOT EXISTS Book(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,name CHAR(30) NOT NULL);");
	    statement.executeUpdate("INSERT INTO Book(name) values('Inferno')");
	    statement.executeUpdate("INSERT INTO Book SET name='Salomon'");

	    ResultSet resultSet = statement.executeQuery("SELECT* FROM book");
	    while (resultSet.next()) {
		System.out.print(resultSet.getInt("id"));
		System.out.println(" " + resultSet.getString("name"));

	    }
	} catch (Exception e) {

	}
    }

}
