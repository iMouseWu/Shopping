<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>adminlogin.jsp</title>
</head> 
<body>
<center>
<h2>用户登录</h2>
<s:form action="AdminLogin!adminLogin" method="post">
<s:textfield name="adminbean.adminusername"  label="用户名"></s:textfield>
<s:password name="adminbean.adminpassword"   label="密码" ></s:password>
<s:submit value="登录">
</s:submit> 
</s:form>
</center>
</body>
</html>