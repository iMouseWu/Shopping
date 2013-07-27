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
#updateview{
 position:absolute;
    left:400px;
    top:100px;
 }
 </style>
</head>
<body>
<div id="updateview">
<h2>增加图书</h2>
<s:form action="BookV!insertBook" method="post" onSubmit="return validate();">
<s:textfield name="booksort"  label="图书种类"></s:textfield>
<s:textfield name="bookname"  label="图书名字"></s:textfield>
<s:textfield name="bookprice"  label="图书单价"></s:textfield>
<s:textfield name="bookauthor"  label="图书作者"></s:textfield>
<s:textfield name="bookpress"  label="图书出版社"></s:textfield>
<s:textfield name="bookaddress"  label="图书图片地址"></s:textfield>
<s:submit value="增加">
</s:submit> 
</s:form>
</div>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>