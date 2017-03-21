<%@page import="com.model.salesBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<salesBean> al=(ArrayList<salesBean>)request.getAttribute("salesArray");
 
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
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="JS/slimtable.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/slimtable.css">
	<link type="text/css" rel="stylesheet" href="css/site.css">
  </head>
  
  <body>

<div>
  <form action="sales_duo_search" name="chazhao" method="post">
  <p style="font-size: 12px">员工号：
    <input name="sales_ID" type="text" id="sales_ID" size="10">
    员工姓名：
    <input name="sales_name" type="text" id="sales_name" size="10">
    电话:
  	<input name="mobile" type="text" id="mobile" size="10">
  </p>
  <p>
    <input type="button" name="button" id="button" value="提交" onclick="document.chazhao.submit()">
    <span style="font-size: 12px; color: #F00;" >支持模糊查找，不输入代表查找全部</span></p>
  </form>
  <p>------------------------------------</p>
</div>

<table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>员工ID</th>
			<th>员工姓名</th>
			<th>电话</th>
			<th>邮箱</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		salesBean cb=al.get(i);
		
    %>
    <tr>
    	<td><%=cb.getsales_ID() %></td>
    	<td><a href="sales_info_detail?sales_ID=<%=cb.getsales_ID() %>" ><%=cb.getName() %></a></td>
    	<td><%=cb.getmobile1() %></td>
    	<td><%=cb.getemail() %></td>
 	</tr>
 <% } %>
</table>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>

  </body>
</html>
