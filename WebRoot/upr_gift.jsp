<%@page import="com.model.giftBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<giftBean> al=(ArrayList<giftBean>)request.getAttribute("upr_gift"); 
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
  <style type="text/css">
  #flag1 {
	color: #3F0;
}
  #flag0 {
	color: #F00;
}
  #title {
	text-align: center;
	font-size: 18px;
}
  </style>
  </head>
  
  <body>
<p id="title">导入结果，如果失败的话请手动导入</p>
<table border="1" cellspacing="0">
  <tr>
    <td width="74">礼物名称</td>
    <td width="75">导入状态</td>
    <td width="132">礼物数量</td>
    <td width="138">礼物价值</td>
    <td width="120">积分</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		giftBean cb=al.get(i);
		
    %>
    <td><label><%=cb.getgift_name() %></label></td>
    <%if(cb.getflag()==1){
    	%>
    <td id="flag1">导入成功</td>
    <%} %>
     <%if(cb.getflag()==0){
    	%>
    <td id="flag0">导入失败</td>
    <%} %>
    <td><%=cb.getgift_num() %></td>
    <td><%=cb.getgift_value() %></td>
    <td><%=cb.getjifen() %></td>
  </tr>
 <% } %>
</table>
  </body>
</html>
