package shop.action;

import java.util.List;

import shop.bean.BookBean;
import shop.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	private List<BookBean> childrenList;
	private List<BookBean> youngList;
	public List<BookBean> getYoungList() {
		return youngList;
	}
	public void setYoungList(List<BookBean> youngList) {
		this.youngList = youngList;
	}
	public List<BookBean> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<BookBean> childrenList) {
		this.childrenList = childrenList;
	}
	public String getChildren() throws Exception{
		childrenList = BookService.getChildrenBook();
		return "childrensucceed";
	}
	public String getYoung() throws Exception{
		youngList = BookService.getYoungBook();
		return "youngsuceeed";
	}

}
