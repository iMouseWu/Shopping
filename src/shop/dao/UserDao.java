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
	/*�����û�*/
	 public static void insertUser(String username,String password)throws SQLException,ClassNotFoundException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
            statement.executeUpdate("insert into db_user values("+username+","+password+") ");
			}
	 /*�����û����޸��û�����*/
	 public static void updateUser(String username,String password) throws SQLException, ClassNotFoundException{
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("UPDATE db_user set password="+password+" where  username="+username+" ");
	 }
	 /*ɾ���û�*/
	 public static void deleteUser(String username) throws SQLException, ClassNotFoundException{
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			statement.executeUpdate("delete from db_user where username="+username+"");
	 }
	 /*���������û��Ľ����*/
	 public static ResultSet viewuser() throws SQLException, ClassNotFoundException{
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			ResultSet rs = statement.executeQuery("select * from db_user");
			return rs;
	 }

}
