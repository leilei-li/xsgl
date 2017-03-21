<%@page import="com.model.visitBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<visitBean> al=(ArrayList<visitBean>)request.getAttribute("visitArray");
visitBean cb=al.get(0); 
userBean ub=(userBean)request.getSession().getAttribute("userBean"); 
%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String str_date1 = formatter.format(currentTime); //将日期时间格式化 
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
      <td colspan="3"><div align="center">来访详细信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE1">员工号：</span><%=cb.getsale_ID() %>
        <label></label></td>
      <td width="264"><span class="STYLE1">客户号：</span><%=cb.getcustomer_ID() %></td>
      <td width="260"><span class="STYLE1">地点：</span><%=cb.getdidian() %></td>
    </tr>
    
    <tr>
      <td colspan="3"><span class="STYLE1">具体时间：</span><%=cb.getdate() %></td>
    </tr>
    <tr>
      <td colspan="3"><span class="STYLE1">拜访原因：</span><%=cb.getreason() %> </td>
    </tr>
    <tr>
      <td colspan="3"><span class="STYLE1">礼物：</span><%=cb.getgift() %><span class="STYLE1">数量：</span><%=cb.getgift_num() %></td>
      </tr>
    
    <tr>
      <td colspan="3"><span class="STYLE1">结果：</span><%=cb.getresult() %>
        <label></label></td>
      </tr>
    

    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <input type="hidden" name="0" value="0">
          <%if((ub.getType().equals("admin"))|(cb.getdate().equals(str_date1))){ %>
          <input type="submit" name="Submit2" value="删除" Onclick="window.location.href='visit_info_delete?team_ID=<%=cb.getID() %>'">
          <%} %> 
          <input type="submit" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'">
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
