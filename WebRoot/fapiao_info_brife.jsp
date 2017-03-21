<%@page import="com.model.fapiaoBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<fapiaoBean> al=(ArrayList<fapiaoBean>)request.getAttribute("fapiaoArray");
userBean ub=(userBean)request.getSession().getAttribute("userBean");
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
  <form action="fapiao__dan_searchServlet?re_ID=<%=ub.getre_ID() %>" name="chazhao" method="post">
  <p style="font-size: 12px">发票号：
    <input name="fapiao_ID" type="text" id="fapiao_ID" size="10">
    发票抬头：
    <input name="fapiaotaitou" type="text" id="fapiaotaitou" size="10">
    客户姓名:
  	<input name="cus_name" type="text" id="cus_name" size="10">
    员工姓名：
    <input name="sales_name" type="text" id="sales_name" size="10">
  </p>
  <p>
    <input type="button" name="button" id="button" value="提交" onclick="document.chazhao.submit()">
    <input type="reset" name="Submit2" value="重置">
    <span style="font-size: 12px; color: #F00;" >支持模糊查找，不输入代表查找全部</span></p>
  </form>
</div>
<p>------------------------------------</p>
<table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>发票号</th>
			<th>员工号及姓名</th>
			<th>客户号及姓名</th>
			<th>发票抬头</th>
			<th>订单号</th>
			<th>经手人</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		fapiaoBean cb=al.get(i);
		
    %>
    <tr>
    	<td><a href="fapiao_info_detail?fapiao_ID=<%=cb.getfapiao_ID() %>" ><%=cb.getfapiao_ID()%></a></td>
    	<td><%=cb.getsales_ID() %>,<%=cb.getsales_name() %></td>
    	<td><%=cb.getcus_ID() %>,<%=cb.getcus_name() %></td>
    	<td><%=cb.getfapiaotaitou() %></td>
    	<td><%=cb.getdingdan_ID() %></td>
    	<td><%=cb.getuser_ID() %></td>
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
