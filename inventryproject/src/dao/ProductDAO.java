package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionmanager.ConnectionManager;
import model.Product;

public class ProductDAO 
{
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		//1.Java and JDBC connect
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection(); 
		
		String sql_query = "insert into product(productId,productname,minsellQuantity,price,quantity) values (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinsellQuantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
		
		conm.closeConnnection();
		
	}
	public void display() throws SQLException, ClassNotFoundException
	{
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from product"+ "");
		while(rs.next())
				{
		          System.out.println(rs.getInt("productId")+"|"+rs.getString("productName")+"|"+rs.getInt("minsellquantity")+"|"+rs.getInt("price")+"|"+rs.getInt("quantity"));
	            }
	}
}