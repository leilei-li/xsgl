<%@page import="com.model.danweiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<danweiBean> al=(ArrayList<danweiBean>)request.getAttribute("danweiArray");
 
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
<table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>所属区域</th>
			<th>单位名称</th>
			<th>负责人</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		danweiBean cb=al.get(i);
		
    %>
    <tr>
    	<td><%=cb.getarea_name() %></td>
    	<td><a href="danwei_info_modify?danwei_name=<%=cb.getdanwei_name() %>"><%=cb.getdanwei_name() %></a></td>
    	<td><%=cb.getchair() %></td>
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
