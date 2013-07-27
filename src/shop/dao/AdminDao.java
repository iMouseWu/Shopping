package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	static String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping";
	static String dbUser="sa";
	static String userPwd="sql";
public static ResultSet Login(String username,String password)throws SQLException,ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from db_admin where adminusername='"+username+"' and adminpassword='"+password+"'");
		return resultSet;
	}
}
