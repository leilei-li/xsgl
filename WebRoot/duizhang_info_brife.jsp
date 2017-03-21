<%@page import="com.model.duizhangBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<duizhangBean> al=(ArrayList<duizhangBean>)request.getAttribute("duizhangArray");
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
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
    </style>
</head>
  
  <body>
  <table width="800" border="1">
    <tr>
      <td width="180">对账单号码：</td>
      <td width="180">发票号码：</td>
      <td width="180">生成日期：</td>
      <td width="180">操作员：</td>
      <td width="180">&nbsp;</td>
    </tr>
    <%for(int i=0;i<al.size();i++){
		duizhangBean cb=al.get(i);
		
    %>
    <tr>
      <td><a href="duizhang_search_detail?duizhang_ID=<%=cb.getduizhang_ID()%>" ><%=cb.getduizhang_ID() %></a></td>
      <td><%=cb.getfapiao_ID() %></td>
      <td><%=cb.getdate() %></td>
      <td><%=cb.getusername() %></td>
      <td><label>
        <input type="submit" name="Submit" value="删除" Onclick="window.location.href='duizhang_info_delete?duizhang_ID=<%=cb.getduizhang_ID() %>'">
      </label></td>
    </tr>
    <%} %>
  </table>
  </body>
</html>
