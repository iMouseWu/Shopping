<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
   #title{
   position:absolute;
    left:0px;
    top:0px;
    height:50px;
    width:100%;
    }
    #menu{
    position:absolute;
    left:0px;
    top:250px;
    }
    #spebook{
    position:absolute;
    left:520px;
    top:250px;
    height:50px;
    width:200px
    }
    #supply{
    position:absolute;
    left:250px;
    top:600px;
    }
    #notice{
    position:absolute;
    left:250px;
    top:250px;
    }
    #login{
    position:absolute;
    left:1000px;
    top:0px;
    z-index:2;
    }
    #error{
    position:absolute;
    left:1100px;
    top:47px;}
    #lookcart{
    position:absolute;
    left:1100px;
    top:110px;
    }
    #serchgoods{
    position:absolute;
    left:600px;
    top:200px;
    }
</style>
<link href="css/menu.css" rel="stylesheet" media="screen">
</head>
<body onload="get();">
<div id="serchgoods">请输入商品名字:<input type="text" id="goodsname"><input type="button" value="搜索" onclick="serchgoods();"></div>

<div id="notice"></div>
<div id="error"></div>
<div id="lookcart"><a href="Cart!lookCart"><img src="images/lookcart.jpg"></a></div>
<div id="login"></div>
<div id="title"><img src="images/ntitle.jpg"></div>
<div id="menu">
<!-- ==================================导航栏的显示=============================================== -->
<div class="my_left_category">
	<h1>全部商品分类</h1>
	<div class="my_left_cat_list">
		<h2><a href="#">青春</a></h2>
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href=#>青春文学</a></h3>
			<div class="h3_cat">
				 <div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="Menu!getYoung">青春文学</a></li>
						   <li><a href="#">青春赏析</a></li>
						   <li><a href="#">青春演绎</a></li>
						</ul>
					</div>
				 </div>
			</div>		
		</div> 
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">儿童</a></h3>
			<div class="h3_cat">
				<div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="Menu!getChildren">儿童图书</a></li>
						   <li><a href="#">科学</a></li>
						   <li><a href="#">画图</a></li>
						</ul>
					</div>
				</div>	
			</div>		
		</div> 
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">文学</a></h3>
			<div class="h3_cat">
				<div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">文学1</a></li>
						   <li><a href="#">文学2</a></li>
						   <li><a href="#">文学3</a></li>
						</ul>
					</div>
				</div>	
			</div>		
		</div> 
		<!-- again -->
		<h2><a href="#">生活</a></h2>
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#" style="color:#ff3333;">热销推荐</a></h3>
			<div class="h3_cat">
				 <div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">我的未来不是梦</a></li>
						   <li><a href="#">辰光的美丽</a></li>
						   <li><a href="#">初恋这件小事</a></li>
						</ul>
					</div>
				 </div>
			</div>		
		</div> 
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">经管</a></h3>
			<div class="h3_cat">
				<div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">经济</a></li>
						   <li><a href="#">管理</a></li>
						   <li><a href="#">投资</a></li>
						</ul>
					</div>
				</div>	
			</div>		
		</div> 
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">教育</a></h3>
			<div class="h3_cat">
				<div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">教材</a></li>
						   <li><a href="#">外语</a></li>
						   <li><a href="#">考试</a></li>
						</ul>
					</div>
				</div>	
			</div>		
		</div> 
		<div class="h2_cat_1" onmouseover="this.className='h2_cat_1 active_cat'" onmouseout="this.className='h2_cat_1'">
			<h3><a href="#">其他网站</a></h3>
		</div>
		<!-- again -->
		<h2><a href="#">价位选择</a></h2>
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">低端价位</a></h3>
			<div class="h3_cat">
				 <div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">50元以下</a></li>
						   <li><a href="#">50-100元</a></li>
						</ul>
					</div>
				 </div>
			</div>		
		</div> 
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#">中高端价位</a></h3>
			<div class="h3_cat">
				<div class="shadow">
					<div class="shadow_border">
						<ul>
						   <li><a href="#">100-150元</a></li>
						   <li><a href="#">150-200元</a></li>
						   <li><a href="#">200-300元</a></li>
						   <li><a href="#">300元以上</a></li>
						 </ul>
					</div>
				</div>	
			</div>		
		</div> 
		<!-- again -->
		<h2><a href="#">超值特价区</a></h2>
		<h2><a href="#">现货区</a></h2>	
	</div> 
</div>
</body>
</html>
</div>
<!-- 
====================================================
 -->



<div id="supply">
<table border="1"><tr><td width="20">独家提供</td>
<c:forEach var="product1" items="${suggestList}" varStatus="cou">
<td>
<a href="GoodsDetail!viewGoods?booknumber=${product.booknumber}"><img src="images/${product1.bookadress}"  align="middle" border="0"></a> 
</td>
</c:forEach>
</tr></table></div>

<div id="spebook">
<table border="1" width="700"><tr align="center" ><td><a>特价图书<a></td><tr></table>
<table border="1"  height="300">
<tr>
<c:forEach var="product" items="${specialList}" varStatus="cou">
<td>
<a href="GoodsDetail!viewGoods?booknumber=${product.booknumber}"><img src="images/${product.bookadress}"  align="middle" border="0"></a>
</td>
</c:forEach>
</tr></table>
</div>
<script language="javascript" src="js/xmlhttp.js"></script>
<script type="text/javascript">
     var i = 0;
     var xmlHttp2;
     /*====================实现如果没有session就在右上角出现一个登陆框============================*/
     /*将该方法放入幻灯播放图片的方法里面，并设置全局变量，让其一开始加载就执行Js语句，并且通过全局变量控制值运行一次*/
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
     /*get是幻灯播放图片的方法，在这类方法有判断语句i==0？如果等于0，就进行判断是否有seesion，如果有就显示登陆框，没有救显示退出按钮*/
     function get(){
    	 if(i == 0){
    		 createXMLHttpRequest2();
    		 xmlHttp2.open("get","AjaxRe!loadajax",true);
  		     xmlHttp2.onreadystatechange=callback2;
  	         xmlHttp2.send(null);
    	 }
	       createXMLHttpRequest();
	       xmlHttp.open("get","ajax.jsp",true);
		   xmlHttp.onreadystatechange=callback;
	       xmlHttp.send(null);
	}
    /*显示登陆框的回调函数*/
     function callback2(){
    	 if(xmlHttp2.readyState == 4){
    		 i = i + 1;
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
     /*幻灯播放图片的回调函数*/
	function callback(){
	      if(xmlHttp.readyState == 4){
		    show();
			}
	}
	function show(){
	    var xmlDoc=xmlHttp.responseXML;
		var p=xmlDoc.getElementsByTagName("p");
		for(var i=0;i<p.length;i++){
		    var tag=p[i].firstChild.data;
		    ts = "<img src="+tag+">";
		    document.getElementById("notice").innerHTML = ts;
		    }
			setTimeout("get()",3000);
		}
	/*=============实现登陆框中的登陆按钮与后台进行AJAX交互=====================*/
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
	/*
	**
	*/
	function serchgoods(){
		var name = document.getElementById("goodsname").value;
		window.location.href="GoodsDetail!viewGoodsByName?bookname="+name+"";
	}
	</script>			
</body>
</html>