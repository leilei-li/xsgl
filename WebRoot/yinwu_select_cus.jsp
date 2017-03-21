<%@page import="com.model.cusBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> cus=(ArrayList<cusBean>)request.getAttribute("cusArray");
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
  <form action="yinwuOP?action=getCus" name="chazhao" method="post">
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
    <span style="font-size: 12px; color: #F00;" >支持模糊查找，不输入代表查找全部,点击客户姓名选择需要的客户</span></p>
  </form>
  <p>------------------------------------</p>
</div>
<div>
  <table width="495" border="0" cellspacing="0">
    <tr>
    <th width="102" scope="col">客户姓名</th>
    <th width="165" scope="col">科室</th>
    <th width="222" scope="col">单位</th>
  </tr>
  <%for(int i=0;i<cus.size();i++){ 
	  cusBean cb=cus.get(i);
  %>
  <tr>
    <th><a href="yinwuOP?action=newPage&cus_ID=<%=cb.getcus_ID()%>&info=<%=cb.getName()%>,<%=cb.getkeshi_name()%>,<%=cb.getdanwei_name() %>" ><%=cb.getName() %></a></th>
    <th><%=cb.getkeshi_name() %></th>
    <th><%=cb.getdanwei_name() %></th>
  </tr>
  <%} %>
  
</table>
</div>

</body>
</html>
