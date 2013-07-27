<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>login.jsp</title>
</head> 
<body>
<center>
<h2>用户登录</h2>
<s:form action="Login!loginTran" method="post">
<s:textfield name="user.username"  label="用户名"></s:textfield>
<s:password name="user.password"   label="密码" ></s:password>
<s:submit value="登录">  <a href="register.jsp">注册</a><a href="AdminLogin.jsp">管理页面</a>
</s:submit> 
</s:form>
</center>
</body>
</html>