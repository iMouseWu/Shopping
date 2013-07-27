<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/loginbut.css" rel="stylesheet" media="screen">
</head>
<body onload="loadpage();">
<div id="emptyiy">1111111</div>
<div id="login"></div>
<div id="error"></div>
<a href="Login"><img  src="images/homepage.jpg"></a>
<div>
<table>
<c:forEach var="product" items="${detailList}" varStatus="cou">
<tr>
<td>
<a href="#"><img src="images/${product.bookadress}"  align="middle" border="0"></a>
</td>
<td>单价:<label>${product.bookprice}</label></td>
<td>购买数量：<input type="text" id="number" value="1" size="3"></td>
<td>出版社:<label>${product.bookpress}</label></td>
<td>作者:<label>${product.bookauthor}</label></td>
<td>
<a href="#" onclick="gotoCart(${product.booknumber});"> <img src="images/intocart.jpg"> </a>
</td>
</tr>
</c:forEach>
</table>
</div>
<script language="JavaScript" type="text/javascript">
function emptyjump(){
	if( document.getElementById("number") ==null)
	alert(document.getElementById("emptyiy").innerHTML);
	document.getElementById("emptyiy").innerHTML = "123456789";
		
}
function gotoCart(to)
{
	var ts = document.getElementById("number").value;
	window.location.href="Cart!addGoods?booknumber="+to+"&number="+ts+"";
}
/*=======判断是否有seesion，有的话就出现退出按钮，没有的话就出现登陆框*/
var xmlHttp2;
function createXMLHttpRequest2(){
	   if(window.ActiveXObject){
	      try{
		       xmlHttp2=new ActiveXObject("Msxml2.XMLHTTP");
			   }catch(e){
			       try{
				       xmlHttp2=new ActiveXObject("Microsoft.XMLHTTP");
					   }catch(ee){
					       xmlHttp2=false;
						   }
				}
			}else if(window.XMLHttpRequest){
			     try{
				     xmlHttp2=new XMLHttpRequest();
					 }catch(e){
					    xmlHttp2=false;
						}
					}
	} 
function loadpage(){
	emptyjump();
createXMLHttpRequest2();
		 xmlHttp2.open("get","AjaxRe!loadajax",true);
		     xmlHttp2.onreadystatechange=callback2;
	         xmlHttp2.send(null);

}
function callback2(){
	 if(xmlHttp2.readyState == 4){
		 var xmlDoc=xmlHttp2.responseText;
			if(xmlDoc == 1){
				var ta = "<input type=\"button\" value=\"退出\" onclick=\"exitlogin();\">";
				document.getElementById("login").innerHTML = ta;
			}else{
				var ts = "用户名:<input type=\"text\" id=\"username\"><br>"+
				"密 码：<input type=\"password\" id=\"password\"><br>"
				+"<input type=\"button\" value=\"登录\" onclick=\"getLogin();\">"
				+"<a href=\"register.jsp\">注册";
				document.getElementById("login").innerHTML = ts;
			}
	 }
	 
}

/*================实现退出按钮的清理seesion的功能================*/
/*按退出按钮，则清理seesion，并且讲退出按钮重新换成登陆框*/
var xmlHttp2;
function createXMLHttpRequest2(){
   if(window.ActiveXObject){
      try{
	       xmlHttp2=new ActiveXObject("Msxml2.XMLHTTP");
		   }catch(e){
		       try{
			       xmlHttp2=new ActiveXObject("Microsoft.XMLHTTP");
				   }catch(ee){
				       xmlHttp2=false;
					   }
			}
		}else if(window.XMLHttpRequest){
		     try{
			     xmlHttp2=new XMLHttpRequest();
				 }catch(e){
				    xmlHttp3=false;
					}
				}
} 
function exitlogin(){
	 createXMLHttpRequest2();
       xmlHttp2.open("get","AjaxRe!delesession",true);
	  xmlHttp2.onreadystatechange=callbackdelete;
       xmlHttp2.send(null);
}
function callbackdelete(){
	if(xmlHttp2.readyState == 4){
	    showdelet();
		}
}
function showdelet(){
	var xmlDoc=xmlHttp2.responseText;
	if(xmlDoc == 1){
		var ts = "用户名:<input type=\"text\" id=\"username\"><br>"+
		"密 码：<input type=\"password\" id=\"password\"><br>"
		+"<input type=\"button\" value=\"登录\" onclick=\"getLogin();\">"
		+"<a href=\"register.jsp\">注册";
		document.getElementById("login").innerHTML = ts;
		}
}
/*获取登陆明和密码，一并发送到服务端，服务端通过判断用户名密码是否正确，如果正确的话，登陆框消失，并且生成seesion。退出按钮出现，如果用户名密码错误，则出现提示*/
function getLogin(){
	   createXMLHttpRequest1();
	   var ts = document.getElementById("username").value;
	   var to = document.getElementById("password").value;
       xmlHttp1.open("get","AjaxRe!reajax?username="+escape(ts)+"&password="+escape(to),true);
	  xmlHttp1.onreadystatechange=callbackagain;
       xmlHttp1.send(null);
	
}
function callbackagain(){
	if(xmlHttp1.readyState == 4){
	    showagain();
		}
}
function showagain(){
	var xmlDoc=xmlHttp1.responseText;
	if(xmlDoc == 1){
		var ta = "<input type=\"button\" value=\"退出\">";
		document.getElementById("login").innerHTML = ta;
	}else{
		document.getElementById("error").innerHTML = "密码或者用户名错误 ";
	}
}
</script>
</body>
</html>