package shop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.bean.BookBean;
import shop.bean.OrderBean;
import shop.dao.BookDao;
import shop.dao.OrderDao;

public class OrderService {
	/*���������Ķ�����*/
	public static String getOrdernumber() throws SQLException, ClassNotFoundException{
		ResultSet resultSet = OrderDao.getOrder();
		if(resultSet.next()){
		   resultSet.last();
		   return Integer.parseInt(resultSet.getString(1))+1+"";
		}else{
		   return "20130101";
		}
		
	}
	/*���붩��*/
	public static void insertOrder(OrderBean orderBean) throws ClassNotFoundException, SQLException{
		String ordernum = orderBean.getOrdernum();
		String booknumber = orderBean.getBooknumber();
		String price = orderBean.getPrice();
		String date = orderBean.getDate();
		String user = orderBean.getUser();
		OrderDao.insertOrder(ordernum,booknumber,price,date,user);
	}
	/*�������еĶ���List*/
	public static List<OrderBean> getallOrder() throws SQLException, ClassNotFoundException{
	ResultSet resultSet = OrderDao.getOrder();
	List<OrderBean> list = new ArrayList();
	while(resultSet.next()){
		OrderBean product=new OrderBean();
		product.setOrdernum(resultSet.getString(1));
		product.setBooknumber(resultSet.getString(2));
		product.setPrice(resultSet.getString(3));
		product.setDate(resultSet.getString(4));
		product.setUser(resultSet.getString(5));
		list.add(product);
	}
	return list;
	}
	/*ɾ������*/
	public static void delOrders(String order) throws ClassNotFoundException, SQLException{
		OrderDao.delOrder(order);
		
	}
}
