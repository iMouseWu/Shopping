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
<div id="login">
</div>
<div id="error">
</div>
<a href="Login"><img  src="images/homepage.jpg"></a>
<div>
<c:forEach var="product" items="${childrenList}" varStatus="cou">
<a href="GoodsDetail!viewGoods?booknumber=${product.booknumber}"><img src="images/${product.bookadress}"  align="middle" border="0"></a>
</c:forEach>
</div>
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest(){
	   if(window.ActiveXObject){
	      try{
		       xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			   }catch(e){
			       try{
				       xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					   }catch(ee){
					       xmlHttp=false;
						   }
				}
			}else if(window.XMLHttpRequest){
			     try{
				     xmlHttp=new XMLHttpRequest();
					 }catch(e){
					    xmlHttp=false;
						}
					}
	} 
function loadpage(){
createXMLHttpRequest();
		 xmlHttp.open("get","AjaxRe!loadajax",true);
		     xmlHttp.onreadystatechange=callback;
	         xmlHttp.send(null);

}
function callback(){
	 if(xmlHttp.readyState == 4){
		 var xmlDoc=xmlHttp.responseText;
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
		var ta = "<input type=\"button\" value=\"退出\" onclick=\"exitlogin();\">";
		document.getElementById("login").innerHTML = ta;
	}else{
		document.getElementById("error").innerHTML = "密码或者用户名错误 ";
	}
}
</script>
</body>
</html>