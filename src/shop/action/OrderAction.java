package shop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.bean.BookCartBean;
import shop.bean.OrderBean;
import shop.bean.UserBean;
import shop.service.OrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private List<OrderBean> orderlist;

	
	public String createOrder() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String price = request.getParameter("price");
		ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		UserBean user = (UserBean)(session.get("user"));
		String username = user.getUsername();
		Date datenow =new Date();
		String date = datenow.toString();
		List<BookCartBean> list = (List<BookCartBean>) session.get("goodslist");
		orderlist = new ArrayList();
		
		for(BookCartBean bookCartBean:list){
			OrderBean orderBean = new OrderBean();
			orderBean.setOrdernum(OrderService.getOrdernumber());
			System.out.println("-------"+"OrderService.getOrdernumber()"+"-------");
			orderBean.setBookname(bookCartBean.getBookname());
			orderBean.setBooknumber(bookCartBean.getBooknumber());
			orderBean.setImage(bookCartBean.getBookadress());
			orderBean.setPrice(price);
			orderBean.setDate(date);
			orderBean.setUser(username);
			OrderService.insertOrder(orderBean);
			System.out.println("======="+OrderService.getOrdernumber()+"==========");
			orderlist.add(orderBean);
		}
	    return "vieworder";
	}
/*删除对应订单号的商品*/
    public static String delOrders() throws ClassNotFoundException, SQLException{
       HttpServletRequest request = ServletActionContext.getRequest();
       String order = request.getParameter("order");
       OrderService.delOrders(order);
       return "succeed";
        	 
         }
	public List<OrderBean> getOrderlist() {
		return orderlist;
	}


	public void setOrderlist(List<OrderBean> orderlist) {
		this.orderlist = orderlist;
	}
}
