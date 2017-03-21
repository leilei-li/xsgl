<%@page import="com.model.keshiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<keshiBean> al=(ArrayList<keshiBean>)request.getAttribute("keshiArray");
 
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
			<th>科室名称</th>
			<th>负责人</th>
			<th>所属单位</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		keshiBean cb=al.get(i);
		
    %>
    <tr>
    	<td><a href="keshi_info_modify?keshi_name=<%=cb.getkeshi_name() %>&danwei_name=<%=cb.getdanwei_name() %>"><%=cb.getkeshi_name() %></a></td>
    	<td><%=cb.getboss() %></td>
    	<td><%=cb.getdanwei_name() %></td>
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
