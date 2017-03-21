<%@page import="com.model.cusBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> al=(ArrayList<cusBean>)request.getAttribute("cusArray");
 
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>cus_info_detail</title>
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
  <form action="cus_duo_search" name="chazhao" method="post">
  <p style="font-size: 12px">客户号：
    <input name="cus_ID" type="text" id="cus_ID" size="10">
    客户姓名：
    <input name="cus_name" type="text" id="cus_name" size="10">
    单位:
  	<input name="danwei_name" type="text" id="danwei_name" size="10">
    科室：
    <input name="keshi_name" type="text" id="keshi_name" size="10">
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
			<th>客户ID</th>
			<th>客户姓名</th>
			<th>科室</th>
			<th>单位</th>
			<th>邮箱</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		cusBean cb=al.get(i);
		
    %>
    <tr>
    	<td><%=cb.getcus_ID() %></td>
    	<td><a href="cus_info_detail?cus_ID=<%=cb.getcus_ID()%>" ><%=cb.getName() %></a></td>
    	<td><%=cb.getkeshi_name() %></td>
    	<td><%=cb.getdanwei_name() %></td>
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
