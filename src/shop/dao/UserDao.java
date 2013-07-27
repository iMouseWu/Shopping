package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	static String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping";
	static String dbUser="sa";
	static String userPwd="sql";
	/*新增用户*/
	 public static void insertUser(String username,String password)throws SQLException,ClassNotFoundException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
            statement.executeUpdate("insert into db_user values("+username+","+password+") ");
			}
	 /*根据用户名修改用户密码*/
	 public static void updateUser(String username,String password) throws SQLException, ClassNotFoundException{
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("UPDATE db_user set password="+password+" where  username="+username+" ");
	 }
	 /*删除用户*/
	 public static void deleteUser(String username) throws SQLException, ClassNotFoundException{
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("delete from db_user where username="+username+"");
	 }
	 /*返回所有用户的结果集*/
	 public static ResultSet viewuser() throws SQLException, ClassNotFoundException{
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			ResultSet rs = statement.executeQuery("select * from db_user");
			return rs;
	 }

}
