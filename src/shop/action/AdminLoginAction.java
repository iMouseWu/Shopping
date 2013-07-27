package shop.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import shop.bean.AdminBean;
import shop.bean.OrderBean;
import shop.service.AdminService;
import shop.service.OrderService;

public class AdminLoginAction {
    private AdminBean adminbean;
    private List<OrderBean> orderList;

	public AdminBean getAdminbean() {
		return adminbean;
	}

	public void setAdminbean(AdminBean adminbean) {
		this.adminbean = adminbean;
	}
   public String adminLogin() throws ClassNotFoundException, SQLException{
	   System.out.println(adminbean.getAdminusername());
	   if(adminbean.getAdminusername()!=null&&adminbean.getAdminusername()!=""&&adminbean.getAdminpassword()!=null&&adminbean.getAdminpassword()!=""&&AdminService.CheckLogin(adminbean.getAdminusername(),adminbean.getAdminpassword())){
		   ActionContext context = ActionContext.getContext();
		   Map session = context.getSession();
		   session.put("adminbean", adminbean);
		   orderList=OrderService.getallOrder();
		   return "succeed";
	   }else{
		   return "error";
	   }
	   
   }
   public String execute() throws ClassNotFoundException, SQLException{
	   orderList=OrderService.getallOrder();
	   return "succeed";
   }

public List<OrderBean> getOrderList() {
	return orderList;
}

public void setOrderList(List<OrderBean> orderList) {
	this.orderList = orderList;
}
}
