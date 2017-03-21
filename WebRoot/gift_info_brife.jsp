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
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
<div class="headeline"></div>
<p><script type="text/javascript" src="JS/scrolltopcontrol.js"></script></p>
<div style="height:1000px;">
<table width="720" border="0">
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
    <td><%=cb.getgift_num() %></td>
    <td><%=cb.getgift_value() %></td>
    <td><%=cb.getjifen() %></td>
    <td><label>
      <input type="hidden" name="0" value="0" >
      <input type="submit" name="Submit2" value="修改"   Onclick="window.location.href='gift_info_modify?gift_name=<%=cb.getgift_name() %>'">      <input type="submit" name="Submit3" value="删除"   Onclick="window.location.href='gift_info_delete?gift_name=<%=cb.getgift_name() %>'"> 
    </label></td>
  </tr>
 <% } %>
</table>
</div>
  </body>
</html>
