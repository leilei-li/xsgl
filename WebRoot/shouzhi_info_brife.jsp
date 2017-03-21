<%@page import="com.model.fapiaoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<fapiaoBean> al=(ArrayList<fapiaoBean>)request.getAttribute("fapiaoArray");
String start = (String)request.getAttribute("start"); 
String end = (String)request.getAttribute("end"); 
Float sum_yingshou = (Float)request.getAttribute("sum_yingshou"); 
Float sum_shihsou = (Float)request.getAttribute("sum_shishou"); 
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

<table width="807" border="0">
  <tr>
    <td><span class="STYLE1">应收总额：</span><%=sum_yingshou%></td>
    <td><span class="STYLE1">实收款：</span><%=sum_shihsou%></td>
    <td><span class="STYLE1">差额：</span><%out.print(sum_yingshou-sum_shihsou);%></td>
    <td>从<%=start%></td>
    <td>到<%=end%></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5">还没有回收全款的发票：</td>
  </tr>
  <tr>
    <td width="163">发票号</td>
    <td width="175">开票日期</td>
    <td width="162">应收</td>
    <td width="154">实收</td>
    <td width="131">差额</td>
  </tr> 
  <tr>
   <%for(int i=0;i<al.size();i++){
		fapiaoBean cb=al.get(i);
	if((cb.getmoney()-cb.getshishou())!=0)
	{
    %>
    <td><%=cb.getfapiao_ID()%></a></td>
    <td><%=cb.getcreate_date() %></td>
    <td><%=cb.getmoney() %></td>
    <td><%=cb.getshishou() %></td>
    <td><label><%out.print(cb.getmoney()-cb.getshishou());%></label></td>
  </tr>
 <%
    } 
  }
  %>
</table>
  </body>
</html>
