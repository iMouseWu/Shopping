package shop.service;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.bean.BookBean;
import shop.bean.BookCartBean;
import shop.dao.BookDao;

public class BookService {
	/*��ȡ�ؼ�ͼ���List*/
	public static List<BookBean> getSpecialBook() throws SQLException,ClassNotFoundException{
		ResultSet resultSet = BookDao.getSpecialBook();
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
		
	}
	/*��ȡ�����ṩͼ��List*/
	public static List<BookBean> getSuggestBook() throws SQLException,ClassNotFoundException{
		ResultSet resultSet = BookDao.getSuggestBook();
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
	}
	/*��ȡ��ͯͼ��List*/
	public static List<BookBean> getChildrenBook() throws SQLException,ClassNotFoundException{
		ResultSet resultSet = BookDao.getChildrenBook();
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
	}
	/*��ȡ�ഺͼ��List*/
	public static List<BookBean> getYoungBook() throws SQLException,ClassNotFoundException{
		ResultSet resultSet = BookDao.getYoungBook();
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
	}
	/*����booknumber��ȡ��Ӧ��bookcartʵ��*/
	public static BookCartBean getBook(String booknumber,String number) throws SQLException,ClassNotFoundException{
		
		ResultSet resultSet = BookDao.getBook(booknumber);
		BookCartBean product=new BookCartBean();
		resultSet.next();
		product.setBooksort(resultSet.getString(1));
		product.setBooknumber(resultSet.getString(2));
		product.setBookname(resultSet.getString(3));
		product.setBookprice(resultSet.getString(4));
		product.setBookauthor(resultSet.getString(5));
		product.setBookpress(resultSet.getString(6));
		product.setBookadress(resultSet.getString(7));
		product.setNumber(number);
		product.setMoney(""+Integer.parseInt(number)*Integer.parseInt(resultSet.getString(4)));
		return product;
	}
	/*��ȡָ����ı����ͼ���List*/
	public static List<BookBean>  getBook(String booknumber) throws SQLException,ClassNotFoundException{
		ResultSet resultSet = BookDao.getBook(booknumber);
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
    }
	/*��ȡָ��ͼ�����ֵ�ͼ��List*/
	public static List<BookBean>  getBookByName(String bookname) throws SQLException,ClassNotFoundException, UnsupportedEncodingException{
		ResultSet resultSet = BookDao.getBookByName(bookname);
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
     }
	/*��ȡ�����鱾��List���ϲ������������*/
	public static List<BookBean> getAllBook() throws SQLException, ClassNotFoundException{
		ResultSet resultSet = BookDao.getAllBook();
		List<BookBean> list = new ArrayList();
		while(resultSet.next()){
			BookBean product=new BookBean();
			product.setBooksort(resultSet.getString(1));
			product.setBooknumber(resultSet.getString(2));
			product.setBookname(resultSet.getString(3));
			product.setBookprice(resultSet.getString(4));
			product.setBookauthor(resultSet.getString(5));
			product.setBookpress(resultSet.getString(6));
			product.setBookadress(resultSet.getString(7));
			list.add(product);
		}
		return list;
	}
	/*ɾ��ָ��number��ͼ��*/
	public static void delectBook(String number ) throws ClassNotFoundException, SQLException{
		BookDao.deleteBook(number);
		
	}
	/*��ȡ����ӵ�ͼ�����*/
	public static String newnumber() throws NumberFormatException, SQLException, ClassNotFoundException{
		ResultSet resultSet = BookDao.getAllBook();
		if(resultSet.next()){
			resultSet.last();
			return Integer.parseInt(resultSet.getString(2))+1+"";
		}else
		 return "1";
	}
	/*���ӻ�ȡ��ͼ���Ÿ���ͼ��۸�*/
	public static void updateBook(String number,String price) throws ClassNotFoundException, SQLException{
		BookDao.updateBook(number, price);
		
	}
	/*����ͼ��*/
	public static void inserBook(String sort,String name,String price,String author,String press,String address) throws NumberFormatException, ClassNotFoundException, SQLException, UnsupportedEncodingException{
		String number = newnumber();
		BookDao.inserBook(sort, number, name, price, author, press, address);
		
	}
	
}
