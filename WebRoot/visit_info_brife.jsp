<%@page import="com.model.visitBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<visitBean> al=(ArrayList<visitBean>)request.getAttribute("visitArray");
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
  </head>
  
  <body>

<table width="853" border="0">
  <tr>
    <td width="134">员工号</td>
    <td width="150">客户号</td>
    <td width="135">时间</td>
    <td width="175">地点</td>
    <td width="237">&nbsp;</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		visitBean cb=al.get(i);
		
    %>
    <td><%=cb.getsale_ID() %>,<%=cb.getsales_name() %></td>
    <td><%=cb.getcustomer_ID() %>,<%=cb.getcus_name() %></td>
    <td><%=cb.getdate() %></td>
    <td><%=cb.getdidian() %></td>
    <td><label>
      <div align="right">
        <input type="hidden" name="0" value="0" >
        <input type="submit" name="Submit" value="详细信息" Onclick="window.location.href='visit_info_detail?ID=<%=cb.getID() %>'">
        <%if((ub.getType().equals("admin"))|(cb.getdate().equals(str_date1))){ %>
        <input type="submit" name="Submit2" value="删除"   Onclick="window.location.href='team_info_delete?ID=<%=cb.getID() %>'">
        <%} %>      
      </div>
    </label></td>
  </tr>
 <% } %>
</table>
  </body>
</html>
