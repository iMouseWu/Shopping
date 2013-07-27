package shop.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.bean.BookBean;
import shop.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<BookBean> viewList;
	public String execute() throws ClassNotFoundException, SQLException{
		viewList = BookService.getAllBook();
		return "succeed";
		
	}
	public String deletebook() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String number = request.getParameter("number");
		BookService.delectBook(number);
		return "turn";
	}
	public String updateBook() throws ClassNotFoundException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		BookService.updateBook(number, price);
		return "turn";
	}
	public String  insertBook() throws NumberFormatException, ClassNotFoundException, SQLException, UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String sort = request.getParameter("booksort");
		String name = request.getParameter("bookname");
		String price = request.getParameter("bookprice");
		String author = request.getParameter("bookauthor");
		String press = request.getParameter("bookpress");
		String address = request.getParameter("bookaddress");
		BookService.inserBook(sort, name, price, author, press, address);
		return "turn";
	}
	public List<BookBean> getViewList() {
		return viewList;
	}
	public void setViewList(List<BookBean> viewList) {
		this.viewList = viewList;
	}

}
