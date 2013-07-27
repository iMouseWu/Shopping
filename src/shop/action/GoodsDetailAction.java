package shop.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.bean.BookBean;
import shop.bean.BookCartBean;
import shop.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class GoodsDetailAction extends ActionSupport{
	private List<BookBean> detailList;

	


	public List<BookBean> getDetailList() {
		return detailList;
	}




	public void setDetailList(List<BookBean> detailList) {
		this.detailList = detailList;
	}




	public String viewGoods() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
    	String booknumber = request.getParameter("booknumber");
    	detailList = (List<BookBean>) BookService.getBook(booknumber);
		return "detailgoods";
	}
	public String viewGoodsByName() throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
    	String bookname = request.getParameter("bookname");
    	detailList = (List<BookBean>) BookService.getBookByName(bookname);
		return "detailgoods";
	}

}
