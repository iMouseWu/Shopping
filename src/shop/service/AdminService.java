package shop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import shop.dao.AdminDao;
import shop.dao.BookDao;

import com.opensymphony.xwork2.ActionContext;

public class AdminService {
	public static boolean CheckLogin(String username,String password) throws SQLException, ClassNotFoundException{
	ResultSet resultSet = AdminDao.Login(username, password);
    if(resultSet.next()){
	return true;
    }else{
    return false;	
    }
}
}