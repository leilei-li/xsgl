<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd"); 
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String str_date1 = formatter.format(currentTime); //将日期时间格式化 
userBean ub=(userBean)request.getSession().getAttribute("userBean");
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript" src="JS/rili.js" ></script>
  </head>
<form action="dingdan__duo_searchServlet?shoufei_num=<%=ub.getre_ID() %>" method="post">
  <body>
<table width="802" height="156" border="0" scrolling= "NO ">
  <tr>
    <td width="177" height="50">开始时间：
      <input name="start" type="text" id="start" onClick="getDateString(this, oCalendarChs)"  size="10" value="20150901" >    </td>
    <td width="176">结束时间：
    <input name="end" type="text" id="end" onClick="getDateString(this, oCalendarChs)"  size="10" value=<%out.print(str_date1); %>></td>
    <td width="215"><label></label>
      员工名字：
      <input name="sales_name" type="text" id="sales_name" size="10"></td>
    <td width="216">客户名字：
    <input name="cus_name" type="text" id="cus_name" size="10"></td>
  </tr>
  <tr>
    <td height="44">订单号码：
    <input name="dingdan_ID" type="text" id="dingdan_ID" size="10"></td>
    <td height="44"> 区 域：
      <input name="area_name" type="text" id="area_name" size="10"></td>
    <td height="44">单 位：
      <input name="danwei" type="text" id="danwei" size="10"></td>
    <td width="215">科室：
      <input name="keshi" type="text" id="keshi" size="10"></td>
  </tr>
  <tr>
    <td height="44">&nbsp;</td>
    <td height="44">&nbsp;</td>
    <td width="215">&nbsp;</td>
    <td width="216"><input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
    <input type="reset" name="Submit2" value="重置"></td>
  </tr>
</table>

  </body>
</html>
