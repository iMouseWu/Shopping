package shop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.bean.OrderBean;
import shop.bean.UserBean;
import shop.dao.OrderDao;
import shop.dao.UserDao;

public class UserService {
	/*�����û�*/
	public static void insertUser(String username,String password) throws ClassNotFoundException, SQLException{
		UserDao.insertUser(username, password);
	}
	/*ɾ���û�*/
	public static void delteUser(String username) throws ClassNotFoundException, SQLException{
		UserDao.deleteUser(username);
	}
	/*�����û���Ϣ*/
	public static void updateUser(String username,String password) throws ClassNotFoundException, SQLException{
		UserDao.updateUser(username, password);
	}
	/*ȡ�����е��û�����List*/
	public static List<UserBean> viewUser() throws ClassNotFoundException, SQLException{
		ResultSet resultSet =UserDao.viewuser();
		List<UserBean> list = new ArrayList();
		while(resultSet.next()){
			UserBean product=new UserBean();
			product.setUsername(resultSet.getString(1));
			product.setPassword(resultSet.getString(2));
			list.add(product);
		}
		return list;
	}

}
