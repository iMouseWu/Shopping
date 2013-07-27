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
    				var ta = "<input type=\"button\" value=\"ÍË³ö\">";
    				document.getElementById("login").innerHTML = ta;
    			}else{
    				var ts = "ÓÃ»§Ãû:<input type=\"text\" id=\"username\"><br>"+
    				"ÃÜ Âë£º<input type=\"password\" id=\"password\"><br>"
    				+"<input type=\"button\" value=\"µÇÂ¼\" onclick=\"getLogin();\">"
    				+"<a href=\"register.jsp\">×¢²á";
    				document.getElementById("login").innerHTML = ts;
    			}
    	 }
    	 
     }