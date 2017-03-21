<%@page import="com.model.dingdanBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
request.getSession().setAttribute("dingdanArray1",al);
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
 <form action="duizhang_creat"  method="post">
<table width="843" border="1">
  
    <tr>
     <%for(int i=0;i<al.size();i++){
		dingdanBean cb=al.get(i);
	%>
    <td colspan="2">单位名称：<%=cb.getdanwei_name()%></td>
    </tr> 
    <tr>
      <td><%=cb.getkeshi_name()%></td>
      <td width="675"><input type="checkbox" name="checkbox" value=<%=cb.getdingdan_ID() %> >
          <%=cb.getcus_name()%>,<span class="STYLE1"><%=cb.getdingdan_ID() %></span>,<%=cb.getdate() %>,<%=cb.gettype() %>, <%=cb.getsample_num() %>,<%=cb.getprice()%>*<%=cb.getnum() %>=<span class="STYLE1">
            <%out.print(cb.getprice()*cb.getnum()); %>
      </span></td>
    </tr>
    <%
    } %>
    <tr>
    <td width="100">
      <div align="center">
        <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()" >
        </form>
      </div></td></tr>
</table>
  </body>
</html>
