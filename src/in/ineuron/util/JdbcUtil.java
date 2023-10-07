package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
		
	}
 
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
public static Connection getJdbcConnection() throws SQLException, IOException {
	Connection connection=null;
	HikariConfig config=new HikariConfig("src\\in\\ineuron\\properties\\db.properties");
	HikariDataSource dataSource = new HikariDataSource(config);
		//	physicalConnection();
		//Logical connection
	 connection=dataSource.getConnection();
	 
	
    return connection;
}

@SuppressWarnings("unused")
private static void physicalConnection() throws FileNotFoundException, IOException, SQLException {
	Connection connection=null;
	FileInputStream fis=new FileInputStream("src\\in\\ineuron\\properties\\db.properties");
	Properties properties =new Properties();
	properties.load(fis);
	
	String url=properties.getProperty("url");
	String userName=properties.getProperty("user");
	String password=properties.getProperty("password");
	 
	connection=DriverManager.getConnection(url, userName,password);
}
}
