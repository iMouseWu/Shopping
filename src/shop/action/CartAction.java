package shop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.bean.BookBean;
import shop.bean.BookCartBean;
import shop.service.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	private List<BookCartBean> transList;
        public List<BookCartBean> getTransList() {
		return transList;
	}
	public void setTransList(List<BookCartBean> transList) {
		this.transList = transList;
	}
	public String addGoods() throws ClassNotFoundException, SQLException{
        /*获取HttpServletRequest实例对象*/
        HttpServletRequest request = ServletActionContext.getRequest();
    	String booknumber = request.getParameter("booknumber");
    	String number = request.getParameter("number");
    	/*获取对应booknumber所指向的书本实例*/
    	BookCartBean bookcartBean = BookService.getBook(booknumber,number);
        List<BookCartBean> list =  new ArrayList();
        ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		list = (List<BookCartBean>)session.get("goodslist");
        /*判断是不是第一次添加*/
		if(list == null){
		    List<BookCartBean> newlist = new ArrayList();
		    newlist.add(bookcartBean);
		    session.put("goodslist", newlist);
		    }else{
		    list.add(bookcartBean);
		    session.put("goodslist", list);
		    }
		transList = (List<BookCartBean>)session.get("goodslist");
		return "cart";
		
        }
	public String delGoods() throws ClassNotFoundException, SQLException{
		 /*获取HttpServletRequest实例对象*/
        HttpServletRequest request = ServletActionContext.getRequest();
    	String booknumber = request.getParameter("booknumber");
    	String number = request.getParameter("number");
    	/*获取对应booknumber所指向的书本实例*/
    	BookCartBean bookcartBean = BookService.getBook(booknumber,number);
        List<BookCartBean> list =  new ArrayList();
        ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		list = (List<BookCartBean>)session.get("goodslist");
		for(int i=0;i<list.size();i++){
			BookCartBean bean = list.get(i);
			if(bean.getBooknumber().equals(booknumber)){	
				list.remove(i);
			    break;
			}
			
		}
		session.put("goodslist", list);
		transList = (List<BookCartBean>)session.get("goodslist");
		return "cart";
		
	}
	public String lookCart(){
		return "cart";
	}
}
