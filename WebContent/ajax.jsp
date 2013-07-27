<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
   response.setContentType("text/xml;charset=gb2312");
   response.setHeader("Cache-Control","no-cache");
   int i=(int)(Math.random()*20%3);
   out.print("<start>");
   if(i==0){
       out.print("<p>images/sell1.png</p>");
	   }
	if(i==1){
       out.print("<p>images/sell2.png</p>");
	   }
	 if(i==2){
       out.print("<p>images/sell3.png</p>");
	   }
	 out.print("</start>");
	 %>