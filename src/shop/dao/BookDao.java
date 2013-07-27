package shop.dao;

import java.io.UnsupportedEncodingException;
import java.sql.*;

public class BookDao {
	
	static String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping";
	static String dbUser="sa";
	static String userPwd="sql";
/*获取固定用户名和密码的结果集*/
public static ResultSet Login(String username,String password)throws SQLException,ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from db_user where username="+username+" and password="+password+"");
		return resultSet;
	}
/*获取特价图书的结果集*/
   public static ResultSet getSpecialBook()throws SQLException,ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='特价书'");
		return resultSet;
	}
/*获取独家提供的结果集*/
   public static ResultSet getSuggestBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='独家特供'");
		return resultSet;
		
		}
/*获取儿童图书结果集*/
   public static ResultSet getChildrenBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='儿童图书'");
		return resultSet;
		}
 /*获取青春图书结果集*/
   public static ResultSet getYoungBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='青春文学'");
		return resultSet;
		}
   
   /*获取指定Booknumber的结果集*/
   public static ResultSet getBook(String booknumber)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booknumber="+booknumber+"");
		return resultSet;
		}
   /*获取指定书本名字的结果集*/
   public static ResultSet getBookByName(String bookname)throws SQLException,ClassNotFoundException, UnsupportedEncodingException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		String name=new String(bookname.getBytes("iso-8859-1"),"utf-8");
		ResultSet resultSet=statement.executeQuery
				("select * from book where  bookname='"+name+"'");
		return resultSet;
		}
   /*获取全部商品的结果集*/
   public static ResultSet getAllBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		ResultSet resultSet=statement.executeQuery
				("select * from book");
		return resultSet;
		}
/*删除指定编号的图书*/
   public static void deleteBook(String number)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		statement.executeUpdate("delete from book where booknumber="+number+"");
		}
   
   /*更新图书价格*/
   public static void updateBook(String number,String price)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		statement.executeUpdate("update book set bookprice="+price+" where booknumber="+number+"");
		}
   /*添加新的图书*/
   public static void inserBook(String sort,String number,String name,String price,String author,String press,String address) throws SQLException, ClassNotFoundException, UnsupportedEncodingException{
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		statement.executeUpdate("insert into book values ('"+sort+"','"+number+"','"+name+"','"+price+"','"+author+"','"+press+"','"+address+"')");
   }
   
}
