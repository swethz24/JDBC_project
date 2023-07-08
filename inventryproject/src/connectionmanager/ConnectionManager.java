package connectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	
	Connection con=null;
 public Connection establishConnection() throws ClassNotFoundException, SQLException	{
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventryproject","root","Swetha@2003");
	 		return con;
	 
 }
 public void closeConnnection() throws SQLException {
	 con.close();
 }

}
