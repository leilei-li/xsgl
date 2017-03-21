<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 <script type="text/javascript">
 function daoru_tishi()
 {
	 document.daoru.submit();
	 displayMessage();
	 
 }
 function displayMessage(){
	 if(navigator.userAgent.indexOf("Firefox")==-1){
	  var obj = document.getElementsByTagName('SELECT');
	     for(var i=0;i<obj.length;i++){
	         if(obj[i].type.indexOf("select")!=-1)
	          obj[i].style.visibility = 'hidden';
	     }  
	  mask.style.visibility = 'visible';
	  massage_box.style.visibility = 'visible';
	 }   
	 }
 </script> 
 <%!public String getIpAddr(HttpServletRequest request) { 
    String ip = request.getHeader("x-forwarded-for");    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getHeader("Proxy-Client-IP");    
    }    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getHeader("WL-Proxy-Client-IP");    
    }    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getRemoteAddr();    
    }    
    return ip;    
}%>
 <style type="text/css">
#massage_box{ position:absolute; left:expression((body.clientWidth-350)/2); 
				top:expression(body.scrollTop+(body.clientHeight-this.offsetHeight)/2); 
				width:350px; height:130px;filter:dropshadow(color=#666666,offx=3,offy=3,positive=2); z-index:2; visibility:hidden;}
#mask{ position:absolute; top:0; left:0; width:expression(body.clientWidth); 
		height:expression(body.scrollHeight>body.clientHeight?body.scrollHeight:body.clientHeight); 
		background:#666; filter:ALPHA(opacity=60); z-index:1; visibility:hidden}
.massage{border:#036 solid; border-width:1 1 3 1; width:95%; height:95%; background:#fff; color:#036; font-size:12px; line-height:150%}
.header{background:#554295; height:10%; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12px; padding:3 5 0 5; color:#fff}
</style>
 
  <body>
  <div id="massage_box">
  <div class="massage">
   <div class="header" onmousedown="MDown(massage_box);">
    <div style="display:inline; width:150px; position:absolute">System Information</div>
    <span onClick="massage_box.style.visibility='hidden'; mask.style.visibility='hidden'" 
    style="float:right; display:inline; cursor:hand">×</span>
   </div>
   <div style="margin-top:30px;margin-left:30px">
    <img src="images/loading.gif" align="absmiddle"  style="width:50px;height:50px" />&nbsp;&nbsp;&nbsp;正在上传，请等待页面的自动跳转...
   </div>
  </div>
 </div>
 <div id="mask">
 </div>
 
  
  
<table width="800" height="506" border="0" scrolling= "NO ">

<form action="Inport_gift" name="daoru"  method="post" enctype="multipart/form-data" >
<lable><input type="file" name="file" id="file"></lable>
<lable><input type="button" name="Submit" value="导入" onClick="daoru_tishi()"></lable>
</form>
<p><a href="/xsgl/moban/moban_ceshi.xls" >下载模板</a></p>
<p>-----------------------------</p>
<p>下面可以写上一大堆的各种说明: <br/>
由于主流的浏览器都不再支持获取本地文件绝对路径，所以采用的办法是把文件转化成二进制上传到服务器，再从服务器里面导入了</p>
</body>
</html>
