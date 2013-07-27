package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao {
	static String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping";
	static String dbUser="sa";
	static String userPwd="sql";
	/*获取订单表的结果集*/
	 public static ResultSet getOrder()throws SQLException,ClassNotFoundException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			ResultSet resultSet=statement.executeQuery
					("select * from db_orders ");
			return resultSet;
	}
	 /*往订单表插入新的订单*/
	 public static void insertOrder(String ordernum,String booknumber,String price,String date,String user)throws SQLException,ClassNotFoundException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("insert into db_orders VALUES("+ordernum+","+booknumber+","+price+",'"+date+"',"+user+")");
			}
	 /*删除订单*/
	 public static void delOrder(String order) throws SQLException, ClassNotFoundException{
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("delete from db_orders where db_ordernum="+order+"");
		 
	 }
}
