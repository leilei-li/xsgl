<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  </head>
<form action="cus__dan_searchServlet"  method="post" target="right2">
  <body>
<table width="800" height="160" border="0" scrolling= "NO ">
  <tr>
    <td width="378"><div align="center">按照神马方式查找：
      <label>
      <select name="select" >
        <option selected>客户号</option>
        <option>客户姓名</option>
        <option>电话号码</option>
      </select>
      </label>
    </div><div align="right"></div></td>
    <td width="386"><label>
      
      <div align="left">
        <input name="text" type="text" id="text">
      </div>
    </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><label>
      <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
    </label>
      <label>
      <input type="reset" name="Submit2" value="重置">
    </label></td>
  </tr>
</table>

  </body>
</html>
