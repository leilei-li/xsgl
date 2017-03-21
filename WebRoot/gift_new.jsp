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
    <form action="gift_newServlet"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
    <table width="780" border="0">
      <tr>
        <td colspan="4"><div align="center">新增礼物</div></td>
      </tr>
      <tr>
        <td>礼物名称：
          <label>
          <input name="gift_name" type="text" id="gift_name" value="月饼" size="15">
        </label></td>
        <td>礼物数量：
        <input name="gift_num" type="text" id="gift_num" value="2" size="10"></td>
        <td>积分：
        <input name="jifen" type="text" id="jifen" value="20" size="10"></td>
        <td>礼物单价：        
        <input name="gift_value" type="text" id="gift_value" value="100" size="10"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <div align="center">
            <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
            </div>
        </label></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      </table>
  </div>
  </body>
</html>
