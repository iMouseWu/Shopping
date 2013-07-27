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
    left:80px;
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
      <li><a href="UserV">管理用户</a></li>
      <li class="active"><a href="BookV">管理商品</a></li>
    </ul>
  </div>
</div></div>
<div id="userview">
<table class="table table-hover">
<tr class="success">
<td>图书种类</td>
<td>图书编号</td>
<td>图书名字</td>
<td>图书单价</td>
<td>图书作者</td>
<td>图书出版社</td>
<td>图书图片地址</td>
<td>操作</td>
</tr>
<c:forEach var="product" items="${viewList}" varStatus="cou">
<tr>
<td>${product.booksort}</td>
<td>${product.booknumber}</td>
<td>${product.bookname}</td>
<td><input type="text" id="idvalue_${product.booknumber}" value="${product.bookprice}" size="3"></td>
<td>${product.bookauthor}</td>
<td>${product.bookpress}</td>
<td>${product.bookadress}</td>
<td><a href="BookV!deletebook?number=${product.booknumber}">删除</a><a href="#" onclick="updateInfo(${product.booknumber});">修改</a></td>
</tr>
</c:forEach>
</table>
</div>
<a herf="InsertBook.jsp">添加新的图书</a>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
function updateInfo(number){
	   var price = document.getElementById("idvalue_"+number).value;
	   window.location.href="BookV!updateBook?number="+number+"&price="+price+"";
}
</script>
</body>
</html>