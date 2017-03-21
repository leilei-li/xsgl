<%@page import="com.model.danweiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<danweiBean> al=(ArrayList<danweiBean>)request.getAttribute("danweiArray");
danweiBean cb=al.get(0);
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
<form action="danwei_modifyServlet?danwei_name=<%=cb.getdanwei_name() %>"  method="post">
<table width="661" border="0">
  <tr>
    <td width="152">区域名称</td>
    <td width="125">负责人</td>
    <td width="139">单位名称</td>
    <td width="227">&nbsp;</td>
  </tr> 
  <tr>
    <td><input name="area_name" type="text" id="area_name" value=<%=cb.getarea_name() %> size="20"></td>
    <td><input name="chair" type="text" id="chair" value=<%=cb.getchair() %> size="20"></td>
    <td><%=cb.getdanwei_name() %></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">地址：
      <label>
      <input name="address" type="text" id="address" value=<%=cb.getaddress() %> size="40">
    </label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">信息：
    <input name="info" type="text" id="info" value=<%=cb.getinfo() %> size="40"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
   
    <td><label></label></td>
    
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><label>
      <input type="hidden" name="0" value="0" >
      <input type="submit" name="Submit2" value="修改"   onClick="document.formName.submit()">      
    </label></td>
  </tr>
</table>
  </body>
</html>
