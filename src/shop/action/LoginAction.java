package shop.action;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import shop.bean.BookBean;
import shop.bean.UserBean;
import shop.dao.BookDao;
import shop.service.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
     private UserBean user;
     private List<BookBean> specialList;
     private List<BookBean> suggestList;

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	/*实现action的功能，当进入首页homepage的时候执行该方法来判断是否是已经登陆过的用户*/
	public String execute() throws Exception  {
		if(user!=null){
			ResultSet resultSet = BookDao.Login(user.getUsername(), user.getPassword());
		    resultSet.next();
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			session.put("user", user);
		}
		    specialList = BookService.getSpecialBook();
			suggestList = BookService.getSuggestBook();
			return "succeed";
	}
	/*进入登陆界面，单机登陆按钮后执行的方法，用来判断用户名和密码是否正确！这却跳转到首页，错误的话跳转到错误的页面*/
    public String loginTran() throws Exception  {	
			ResultSet resultSet = BookDao.Login(user.getUsername(), user.getPassword());
		    if(resultSet.next()){
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			session.put("user", user);
			specialList = BookService.getSpecialBook();
			suggestList = BookService.getSuggestBook();
			return "succeed";
		    }else{
		    return "error";	
		    }
		}
		

	public List<BookBean> getSpecialList() {
		return specialList;
	}

	public void setSpecialList(List<BookBean> specialList) {
		this.specialList = specialList;
	}

	public List<BookBean> getSuggestList() {
		return suggestList;
	}

	public void setSuggestList(List<BookBean> suggestList) {
		this.suggestList = suggestList;
	}

	
}
