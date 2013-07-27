<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/loginbut.css" rel="stylesheet" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="loadpage();">
<div id="login">
</div>
<div id="error">
</div>
<a href="Login"><img  src="images/homepage.jpg"></a>
<div>
<table>
<c:forEach var="product" items="${transList}" varStatus="cou">
<tr><td>
<img src="images/${product.bookadress}"  align="middle" border="0"> 
</td>
<td>单价:<label id="price_${product.booknumber}">${product.bookprice}</label></td>
<td>
购买数量：<input type="text" id="number_${product.booknumber}" size="3" value="${product.number}"  onchange="addprice(${product.booknumber},${product.number});">
</td>
<td>总价:<label id="littlenumber_${product.booknumber}">${product.money}</label></td>
<td>
<a href="Cart!delGoods?booknumber=${product.booknumber}&number=${product.number}">删除</a>
</td><tr>
<c:set var="pay" value="${pay + product.money }"/>
</c:forEach>
</table>
你需要付款:<label id="allpay">${pay}</label>
</div>
<div>
<a onclick="goodssubmit();" ><img src="images/gotocash.jpg"></a>
<a href="Login"><img  src="images/shoppingagain.jpg"></a>
</div>
<script language="JavaScript" type="text/javascript">
var allprice = 0;
function addprice(booknumber,oldnumber){
	var price = document.getElementById("price_"+booknumber+"").innerHTML;
	var newnumber = document.getElementById("number_"+booknumber+"").value;
	document.getElementById("allpay").innerHTML = Number(document.getElementById("allpay").innerHTML) + ( price*newnumber - price*oldnumber);
	document.getElementById("littlenumber_"+booknumber+"").innerHTML = newnumber * price;
}
function goodssubmit(){
	var price = document.getElementById("allpay").innerHTML;
	 if(window.confirm('确定付款?')){
		 window.location.href="Order!createOrder?price="+price+"";
		 
	 }
	
}
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
 var xmlHttp1;
	function createXMLHttpRequest1(){
		   if(window.ActiveXObject){
		      try{
			       xmlHttp1=new ActiveXObject("Msxml2.XMLHTTP");
				   }catch(e){
				       try{
					       xmlHttp1=new ActiveXObject("Microsoft.XMLHTTP");
						   }catch(ee){
						       xmlHttp1=false;
							   }
					}
				}else if(window.XMLHttpRequest){
				     try{
					     xmlHttp1=new XMLHttpRequest();
						 }catch(e){
						    xmlHttp1=false;
							}
						}
		} 
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