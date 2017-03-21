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
    <style type="text/css">
<!--
.STYLE1 {color: #0066FF}
-->
    </style>
</head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">团队详细信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE1">团队号：</span><%=cb.getteam_ID() %>
        <label></label></td>
      <td width="264"><span class="STYLE1">团队：</span><%=cb.getteam_name() %></td>
      <td width="260"><span class="STYLE1">领导：</span><%=cb.getleader() %></td>
    </tr>
    
    <tr>
      <td colspan="3"><span class="STYLE1">合作伙伴：</span><%=cb.getteamcole() %></td>
      </tr>
    
    <tr>
      <td colspan="3"><span class="STYLE1">团队目标：</span><%=cb.getteam_goal() %>
        <label></label></td>
      </tr>
    

    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="button" name="Submit2" value="删除" Onclick="window.location.href='team_info_delete?team_ID=<%=cb.getteam_ID() %>'"></td>
          <td><input type="button" name="Submit" value="修改" OnClick="window.location.href='team_show_to_modify?team_ID=<%=cb.getteam_ID() %>'"></td>
          <td><input type="button" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
