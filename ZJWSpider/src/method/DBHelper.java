package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private String mySqlUrl="jdbc:mysql://localhost:3306/zhongjiwei?useUnicode=true&characterEncoding=UTF-8";
	private String username = "****";
	private String password = "*************";
	private Connection connection;
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//¼ÓÔØÇý¶¯Àà(×¢²áÇý¶¯Àà)
			connection= DriverManager.getConnection(mySqlUrl, username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	private void close(){
		try {
			if(connection!=null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
