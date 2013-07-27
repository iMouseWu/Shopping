package shop.interceptor;

import java.util.Map;
import shop.bean.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class LoginIntercept extends AbstractInterceptor  {
	private Map session;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session = arg0.getInvocationContext().getSession();
		UserBean user = (UserBean)session.get("user");
		if(user == null){
			return "error";	
		}else{
		    return arg0.invoke();
		}
	}
	}


