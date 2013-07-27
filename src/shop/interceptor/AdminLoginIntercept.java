package shop.interceptor;

import java.util.Map;

import shop.bean.AdminBean;
import shop.bean.UserBean;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLoginIntercept extends AbstractInterceptor  {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session = arg0.getInvocationContext().getSession();
		AdminBean user = (AdminBean)session.get("adminbean");
		if(user == null){
			return "error";	
		}else{
		    return arg0.invoke();
		}
	}

}
