<%@page import="com.model.teamBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<teamBean> al=(ArrayList<teamBean>)request.getAttribute("teamArray");
 
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
  <form action="team__dan_searchServlet" name="chazhao" method="post">
  <p style="font-size: 12px">
  	团队编号：
    <input name="team_ID" type="text" id="team_ID" size="10">
    团队姓名：
    <input name="team_name" type="text" id="team_name" size="10">
  </p>
  <p>
    <input type="button" name="button" id="button" value="提交" onclick="document.chazhao.submit()">
    <span style="font-size: 12px; color: #F00;" >支持模糊查找，不输入代表查找全部</span></p>
  </form>
</div>
<p>------------------------------------</p>
<table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>团队ID</th>
			<th>团队名</th>
			<th>领导姓名</th>
			<th>合作伙伴</th>
		</tr>
		</tr>
	</thead>
 <%for(int i=0;i<al.size();i++){
		teamBean cb=al.get(i);
		
    %>
    <tr>
    	<td><a href="team_info_detail?team_ID=<%=cb.getteam_ID() %>"><%=cb.getteam_ID() %></a></td>
    	<td><%=cb.getteam_name() %></td>
    	<td><%=cb.getleader() %></td>
    	<td><%=cb.getteamcole() %></td>
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
