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
    <form action="price_newServlet" name="price_new" method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
    <table width="780" border="0">
      <tr>
        <td colspan="3"><div align="center">新增定价</div></td>
      </tr>
      <tr>
        <td>名称：
          <label>
          <input name="name" type="text" id="name" value="暂时可以不填" size="20">
        </label></td>
        <td>类型名：
          <select name="class_name" id="class_name">
            <option selected>DNA</option>
            <option>质粒</option>
                                        </select></td>
        <td>类型：        
          <select name="type" id="type">
            <option>研磨</option>
            <option>合成</option>
            <option>测序</option>
            <option>重组</option>
                    </select></td>
      </tr>
      <tr>
        <td>起止：
          <select name="qizhi" id="qizhi">
            <option>1-7</option>
            <option>7-14</option>
            <option>14-21</option>
            <option>21-28</option>
                    </select></td>
        <td>价格：
        <input name="price" type="text" id="price" value="20" size="10"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <div align="center">
            <input type="submit" name="Submit" value="提交" onClick="document.price_new.submit()">
            </div>
        </label></td>
        <td>&nbsp;</td>
      </tr>
      </table>
  </div>
  </body>
</html>
