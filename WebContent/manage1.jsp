<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
 <style type="text/css">
 #userview{
    position:absolute;
    left:100px;
    top:200px;
 }
 #updateview{
 position:absolute;
    left:650px;
    top:200px;
 }
 </style>
</head>
<body>
<div><div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href=""AdminLogin"">管理</a>
    <ul class="nav">
      <li><a href="AdminLogin">管理订单</a></li>
      <li class="active"><a href="UserV">管理用户</a></li>
      <li><a href="BookV">管理商品</a></li>
    </ul>
  </div>
</div></div>
<div id="userview">
<table class="table table-hover">
<tr class="success">
<td>用户名</td>
<td>密码</td>
<td>操作</td>
</tr>
<c:forEach var="product" items="${userList}" varStatus="cou">
<tr>
<td>${product.username}</td>
<td><input type="text" id="idvalue_${product.username}" value="${product.password}"></td>
<td><a href="UserV!deleteUser?username=${product.username}">删除</a><a href="#" onclick="updateInfo(${product.username});">修改</a></td>
</tr>
</c:forEach>
</table>
</div>
<div id="updateview">
<h2>增加用户</h2>
<s:form action="UserV!insertUser" method="post" onSubmit="return validate();">
<s:textfield name="username"  label="用户名"></s:textfield>
<s:password name="password" id="firstpasswprd"  label="密码" ></s:password>
<s:password id="secondpassword"   label="确认密码" ></s:password>
<s:submit value="增加">
</s:submit> 
</s:form>
</div>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
   function updateInfo(username){
	   var password = document.getElementById("idvalue_"+username).value;
	   window.location.href="UserV!updateUser?username="+username+"&password="+password+"";
   }
   function validate(){
		var firstpasswprd = document.getElementById("firstpasswprd").value;
		var secondpassword = document.getElementById("secondpassword").value;
		if(firstpasswprd != secondpassword){
			alert("两次密码不一样");
			return false;
		}
		}
</script>
</body>
</html>