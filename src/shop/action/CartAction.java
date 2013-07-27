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
        /*��ȡHttpServletRequestʵ������*/
        HttpServletRequest request = ServletActionContext.getRequest();
    	String booknumber = request.getParameter("booknumber");
    	String number = request.getParameter("number");
    	/*��ȡ��Ӧbooknumber��ָ����鱾ʵ��*/
    	BookCartBean bookcartBean = BookService.getBook(booknumber,number);
        List<BookCartBean> list =  new ArrayList();
        ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		list = (List<BookCartBean>)session.get("goodslist");
        /*�ж��ǲ��ǵ�һ�����*/
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
		 /*��ȡHttpServletRequestʵ������*/
        HttpServletRequest request = ServletActionContext.getRequest();
    	String booknumber = request.getParameter("booknumber");
    	String number = request.getParameter("number");
    	/*��ȡ��Ӧbooknumber��ָ����鱾ʵ��*/
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
