package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bean.HouseInfo;

public class DBHelper {
	private String mySqlUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private String username = "****";
	private String password = "*****";
	private Connection connection;
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(mySqlUrl, username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {
		try {
			if(connection!=null)
				connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
