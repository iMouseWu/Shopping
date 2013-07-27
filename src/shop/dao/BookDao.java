package shop.dao;

import java.io.UnsupportedEncodingException;
import java.sql.*;

public class BookDao {
	
	static String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping";
	static String dbUser="sa";
	static String userPwd="sql";
/*��ȡ�̶��û���������Ľ����*/
public static ResultSet Login(String username,String password)throws SQLException,ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from db_user where username="+username+" and password="+password+"");
		return resultSet;
	}
/*��ȡ�ؼ�ͼ��Ľ����*/
   public static ResultSet getSpecialBook()throws SQLException,ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='�ؼ���'");
		return resultSet;
	}
/*��ȡ�����ṩ�Ľ����*/
   public static ResultSet getSuggestBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='�����ع�'");
		return resultSet;
		
		}
/*��ȡ��ͯͼ������*/
   public static ResultSet getChildrenBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='��ͯͼ��'");
		return resultSet;
		}
 /*��ȡ�ഺͼ������*/
   public static ResultSet getYoungBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booksort='�ഺ��ѧ'");
		return resultSet;
		}
   
   /*��ȡָ��Booknumber�Ľ����*/
   public static ResultSet getBook(String booknumber)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery
				("select * from book where booknumber="+booknumber+"");
		return resultSet;
		}
   /*��ȡָ���鱾���ֵĽ����*/
   public static ResultSet getBookByName(String bookname)throws SQLException,ClassNotFoundException, UnsupportedEncodingException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		String name=new String(bookname.getBytes("iso-8859-1"),"utf-8");
		ResultSet resultSet=statement.executeQuery
				("select * from book where  bookname='"+name+"'");
		return resultSet;
		}
   /*��ȡȫ����Ʒ�Ľ����*/
   public static ResultSet getAllBook()throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		ResultSet resultSet=statement.executeQuery
				("select * from book");
		return resultSet;
		}
/*ɾ��ָ����ŵ�ͼ��*/
   public static void deleteBook(String number)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		statement.executeUpdate("delete from book where booknumber="+number+"");
		}
   
   /*����ͼ��۸�*/
   public static void updateBook(String number,String price)throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement();
		statement.executeUpdate("update book set bookprice="+price+" where booknumber="+number+"");
		}
   /*����µ�ͼ��*/
   public static void inserBook(String sort,String number,String name,String price,String author,String press,String address) throws SQLException, ClassNotFoundException, UnsupportedEncodingException{
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(sConnStr,dbUser,userPwd);
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		statement.executeUpdate("insert into book values ('"+sort+"','"+number+"','"+name+"','"+price+"','"+author+"','"+press+"','"+address+"')");
   }
   
}
