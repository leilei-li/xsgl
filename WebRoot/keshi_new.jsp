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
  
  <body>
   <tr class="abc">
    <td align="center">
    <form action="keshi_newServlet"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
    <table width="780" border="0">
      <tr>
        <td colspan="3"><div align="center">新增科室</div></td>
      </tr>
      <tr>
        <td>科室名称：
          <label>
          <input name="keshi_name" type="text" id="keshi_name" value="计算机学院" size="20">
        </label></td>
        <td>单位名称：
          <input name="danwei_name" type="text" id="danwei_name" value="北京邮电大学" size="20"></td>
        <td>负责人：
          <input name="boss" type="text" id="boss" value="黎雷蕾" size="20"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <div align="center">
            <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
            </div>
        </label></td>
        <td>&nbsp;</td>
      </tr>
      </table>
  </div>
  </body>
</html>
