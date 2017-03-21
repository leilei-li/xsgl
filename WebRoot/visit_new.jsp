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
    <form action="visit_newServlet"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">新增拜访</div></td>
    </tr>
    <tr>
      <td width="242">员工号：
        <label>
        <input name="sale_ID" type="text" id="sale_ID" value="001">
      </label></td>
      <td width="264">客户号：
        <input name="customer_ID" type="text" id="customer_ID" value="002"></td>
      <td width="260">地点：
        <input name="didian" type="text" id="didian" value="北京朝阳区"></td>
    </tr>
    <tr>
      <td colspan="3">具体时间：
        <input name="date" type="text" id="date" value="20150930"></td>
      </tr>
    <tr>
      <td colspan="3">拜访原因：
        <input name="reason" type="text" id="reason" value="看望"></td>
      </tr>
    <tr>
      <td colspan="3">礼物：
        <input name="gift" type="text" id="gift" value="水果"> 
        数量 ： 
        <input name="gift_num" type="text" id="gift_num" value="88"></td>
      </tr>
    <tr>
      <td colspan="3">结果：
        <input name="result" type="text" id="result" value="较好印象"></td>
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
  </body>
</html>
