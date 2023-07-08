package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Login;

public class LoginDAO 
{

	public boolean validate(Login login) throws ClassNotFoundException, SQLException {
		String username=login.getUsername();
		String password=login.getPassword();
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from login");
		while(rs.next())
				{
		if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
		{
		return true;
		}
	}
	 conm.closeConnnection(); 
	return false;
}

}