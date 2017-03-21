<%@page import="com.model.giftBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<giftBean> al=(ArrayList<giftBean>)request.getAttribute("giftArray");
 
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

<table width="661" border="0">
  <tr>
    <td width="151">礼物名称</td>
    <td width="132">礼物数量</td>
    <td width="138">礼物价值</td>
    <td width="120">积分</td>
    <td width="157">&nbsp;</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		giftBean cb=al.get(i);
		
    %>
    <td><label><%=cb.getgift_name() %></label></td>
    <form action="gift_modifyServlet?gift_name=<%=cb.getgift_name() %>"  method="post">
    <td><input name="gift_num" type="text" id="gift_num" value=<%=cb.getgift_num() %> size="20"></td>
    <td><input name="gift_value" type="text" id="gift_value" value=<%=cb.getgift_value() %> size="20"></td>
    <td><input name="jifen" type="text" id="jifen" value=<%=cb.getjifen() %> size="20"></td>
	<td><label>
      <input type="hidden" name="0" value="0" >
      <input type="submit" name="Submit2" value="修改"   onClick="document.formName.submit()">      
    </label></td>
  </tr>
 <% } %>
</table>
  </body>
</html>
