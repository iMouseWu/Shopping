package shop.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import shop.bean.UserBean;
import shop.dao.BookDao;

public class AjaxAction extends ActionSupport{
	

   public String reajax() throws ClassNotFoundException, SQLException{
	   HttpServletRequest request = ServletActionContext.getRequest();
	   String username = request.getParameter("username");
	   String password = request.getParameter("password");
	   ResultSet resultSet = BookDao.Login(username, password);
	    if(resultSet.next()){
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		session.put("user", user);
		return "succeed";
	    }else{
	    return "error";	
	    }
   }
      public String loadajax(){
    	ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
  		UserBean user = (UserBean)session.get("user");
  		if(user == null){
  			return "error";	
  		}else{
  			return "succeed";
  		}
	   
	   
   }
      public String delesession(){
    	  ActionContext context = ActionContext.getContext();
  		  Map session = context.getSession();
  		  session.remove("user");
  		  return "succeed";
      }
}
