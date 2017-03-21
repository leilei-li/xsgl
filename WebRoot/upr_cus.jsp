<%@page import="com.model.cusBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> al=(ArrayList<cusBean>)request.getAttribute("upr_cus"); 
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
    <td width="74">客户号</td>
    <td width="75">客户姓名</td>
    <td width="132">导入状态</td>
    <td width="138">单位</td>
    <td width="120">科室</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		cusBean cb=al.get(i);
		
    %>
    <td><label><%=cb.getcus_ID() %></label></td>
    <td><%=cb.getName() %></td>
    <%if(cb.getflag()==1){
    	%>
    <td id="flag1">导入成功</td>
    <%} %>
     <%if(cb.getflag()==0){
    	%>
    <td id="flag0">导入失败</td>
    <%} %>
    <%if(cb.getflag()==3){
    	%>
    <td id="flag0">客户已存在</td>
    <%} %>
    <td><%=cb.getdanwei_name() %></td>
    <td><%=cb.getkeshi_name() %></td>
  </tr>
 <% } %>
</table>
  </body>
</html>
