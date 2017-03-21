<%@page import="com.model.dingdanBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("upr_dingdan"); 
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
    <td width="74">订单号</td>
    <td width="75">时间</td>
    <td width="132">导入状态</td>
    <td width="138">收费员</td>
    <td width="120">对账单号</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		dingdanBean cb=al.get(i);
		
    %>
    <td><label><%=cb.getdingdan_ID() %></label></td>
    <td><%=cb.getdate() %></td>
    <%if(cb.getflag()==1){
    	%>
    <td id="flag1">导入成功</td>
    <%} %>
     <%if(cb.getflag()==0){
    	%>
    <td id="flag0">导入失败</td>
    <%} %>
    <td><%=cb.getshoufei_num() %></td>
    <td><%=cb.getduizhang_ID() %></td>
  </tr>
 <% } %>
</table>
  </body>
</html>
