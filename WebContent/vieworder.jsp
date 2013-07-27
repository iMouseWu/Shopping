<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Login"><img  src="images/homepage.jpg"></a>
<table>
<tr><td>订单号</td><td>图片</td><td>书名</td><td>总价</td></tr>
<c:forEach var="product" items="${orderlist}" varStatus="cou">
<tr>
<td>${product.ordernum}</td>
<td><a href="#"><img src="images/${product.image}"  align="middle" border="0"></a></td>
<td>${product.bookname}</td>
<td>${product.price}</td>
</tr>
</c:forEach>
</table>
</body>
</html>