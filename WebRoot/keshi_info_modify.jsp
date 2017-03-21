<%@page import="com.model.keshiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<keshiBean> al=(ArrayList<keshiBean>)request.getAttribute("keshiArray");
keshiBean cb=al.get(0);
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
  </head>
  
  <body>
<form action="keshi_modifyServlet?keshi_name=<%=cb.getkeshi_name() %>&danwei_name=<%=cb.getdanwei_name() %>"  method="post">
<table width="661" border="0">
  <tr>
    <td width="152">科室名称</td>
    <td width="125">负责人</td>
    <td width="139">单位名称</td>
    <td width="227">&nbsp;</td>
  </tr> 
  <tr>
    <td><label><%=cb.getkeshi_name() %></label></td>
    <td><input name="boss" type="text" id="boss" value=<%=cb.getboss() %> size="20"></td>
    <td><%=cb.getdanwei_name() %></td>
    <td><label>
      <input type="hidden" name="0" value="0" >
      <input type="submit" name="Submit2" value="修改"   onClick="document.formName.submit()">      
    </label></td>
  </tr>
</table>
  </body>
</html>
