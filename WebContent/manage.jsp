<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
 <style type="text/css">
 #order{
    position:absolute;
    left:200px;
    top:200px;
 }
 </style>
</head>
<body>
<div><div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="#">管理</a>
    <ul class="nav">
      <li class="active"><a href="AdminLogin">管理订单</a></li>
      <li><a href="UserV">管理用户</a></li>
      <li><a href="BookV">管理商品</a></li>
    </ul>
  </div>
</div></div>
<div id="order">
<table class="table table-hover">
<tr class="success">
<td>订单号</td>
<td>物品号码</td>
<td>订单总价格</td>
<td>订单日期</td>
<td>购买者</td>
<td>操作</td>
</tr>
<c:forEach var="product" items="${orderList}" varStatus="cou">
<tr>
<td>${product.ordernum}</td>
<td>${product.booknumber}</td>
<td>${product.price}</td>
<td>${product.date}</td>
<td>${product.user}</td>
<td><a href="OrderV!delOrders?order=${product.ordernum}">删除该商品对应的订单</a></td>
</tr>
</c:forEach>
</table>
</div>

<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>