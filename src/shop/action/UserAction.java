package shop.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.bean.UserBean;
import shop.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserBean user;
	private List<UserBean> userList;
	
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	/*注册用户*/
	public String registerUser() throws ClassNotFoundException, SQLException{
		UserService.insertUser(user.getUsername(),user.getPassword());
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.put("user", user);
		return "succeed";
	}
	/*新增用户*/
	public String insertUser() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService.insertUser(username, password);
		return "turn";
	}
	/*删除用户*/
	public String deleteUser() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		UserService.delteUser(username);
		return "turn";
	}
	/*修改用户信息*/
	public String updateUser() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService.updateUser(username, password);
		return "turn";
	}
	/*显示全部用户信息*/
	public String execute() throws ClassNotFoundException, SQLException{
		userList = UserService.viewUser();
		return "succeed";
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}

}
