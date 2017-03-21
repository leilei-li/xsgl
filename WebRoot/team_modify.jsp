<%@page import="com.model.teamBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<teamBean> al=(ArrayList<teamBean>)request.getAttribute("teamArray");
teamBean cb=al.get(0); 
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
    <form action="team_modifyServlet?team_ID=<%=cb.getteam_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">更改员工信息</div></td>
    </tr>
    <tr>
      <td width="242">团队号：
        <%=cb.getteam_ID() %>
        <label></label>
        <label></label></td>
      <td width="264">团队名：
        <input name="team_name" type="text" id="team_name" value=<%=cb.getteam_name() %>></td>
      <td width="260">领导：
        <input name="leader" type="text" id="leader" value=<%=cb.getleader() %>></td>
    </tr>
    
    <tr>
      <td colspan="3">合作伙伴：
        <label>
        <input name="teamcol" type="text" id="teamcol" value=<%=cb.getteamcole() %> size="60">
      </label></td>
    </tr>
    <tr>
      <td colspan="3">团队目标：
        <input name="team_goal" type="text" id="team_goal" value=<%=cb.getteam_goal() %> size="60"></td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="button" name="Submit" value="提交" onClick="document.formName.submit()"></td>
          <td><input type="button" name="Submit2" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
