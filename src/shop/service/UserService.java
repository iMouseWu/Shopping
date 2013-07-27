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
	/*增加用户*/
	public static void insertUser(String username,String password) throws ClassNotFoundException, SQLException{
		UserDao.insertUser(username, password);
	}
	/*删除用户*/
	public static void delteUser(String username) throws ClassNotFoundException, SQLException{
		UserDao.deleteUser(username);
	}
	/*更新用户信息*/
	public static void updateUser(String username,String password) throws ClassNotFoundException, SQLException{
		UserDao.updateUser(username, password);
	}
	/*取出所有的用户返回List*/
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
