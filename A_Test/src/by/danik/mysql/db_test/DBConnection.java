package by.danik.mysql.db_test;

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

//	try {
//	    Class.forName("com.mysql.jdbc.Driver");
//	} catch (ClassNotFoundException e1) {
//	    // TODO Auto-generated catch block
//	    e1.printStackTrace();
//	}
	
	try (Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {

	    Statement statement = conn.createStatement();
	    statement.executeUpdate("DROP TABLE IF EXISTS Book");
	    statement.executeUpdate(
	         "CREATE TABLE IF NOT EXISTS Book(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,book_name CHAR(30) NOT NULL,book_author CHAR(50) NULL);");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Инферно',' Вася_Рогов')");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Война и Мир',' Лев_Толстой')");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Путешествие',' Жюль_Верн')");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Отцы и детя',' Вася_Пупкин')");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Хмурые дни ',' Валера_КСО')");
	    statement.executeUpdate("INSERT INTO Book(book_name,book_author) values('Будапешт  ',' Польский_пацык')");
	    statement.executeUpdate("INSERT INTO Book SET book_name='Саломон'");

	    ResultSet resultSet = statement.executeQuery("SELECT* FROM book");
	    while (resultSet.next( )) {
		System.out.print(resultSet.getInt("id"));
		System.out.print(" " + resultSet.getString("book_name"));
		System.out.println(" " + resultSet.getString("book_author"));
		
	    }
	} catch (Exception e) {

	}
    }

}

