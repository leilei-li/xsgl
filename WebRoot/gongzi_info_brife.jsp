<%@page import="com.model.salesBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<salesBean> al=(ArrayList<salesBean>)request.getAttribute("salesArray");
float[] xiaoshou=new float[al.size()];
for(int i=0;i<al.size();i++)
{
xiaoshou[i] = (Float)request.getAttribute("xiaoshou"+i+"");
}
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

<table width="522" border="0">
 
  <tr>
    <td width="140">员工姓名，号码</td>
    <td width="140">薪水</td>
    <td width="140">提成</td>
    <td width="140">销售额</td>
    <td width="140">工资</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		salesBean cb=al.get(i);
    %>
    <td width="140"><%=cb.getName()%>,<%=cb.getsales_ID() %></a></td>
    <td width="140"><%=cb.getsalary() %></td>
    <td width="140"><%=cb.getroyalty() %>%</td>
    <td width="140"><%out.print(xiaoshou[i]);%></td>
    <td width="140"><label><%out.print(cb.getsalary()+cb.getroyalty()*0.01*xiaoshou[i]);%></label></td>
  </tr>
 <%
  }
  %>
</table>
  </body>
</html>
