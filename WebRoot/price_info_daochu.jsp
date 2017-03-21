<%@page import="com.model.priceBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<priceBean> al=(ArrayList<priceBean>)request.getAttribute("priceArray");
 
%>
<script type="text/javascript"> 
<!-- download
function saveCode(obj) { 
          var winname = window.open('', '_blank', 'top=10000'); 
          var strHTML = document.all.tableExcel.innerHTML; 
          winname.document.open('text/html', 'replace'); 
          winname.document.writeln(strHTML); 
          winname.document.execCommand('saveas','','定价表.xls'); 
          winname.close(); 
} 
--> 
</script> 

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
  <div id="tableExcel"> 
  <table width="810" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td>名称</td>
      <td>种类名称</td>
      <td>类型</td>
      <td>范围</td>
      <td>价格</td>
    </tr>
    <tr>
    <%for(int i=0;i<al.size();i++){
		priceBean pb=al.get(i);
	%>
      <td><%=pb.getname() %></td>
      <td><%=pb.getclass_name() %></td>
      <td><%=pb.gettype() %></td>
      <td><%=pb.getqi() %>-<%=pb.getzhi() %></td>
      <td><%=pb.getprice() %></td>
    </tr>
    <%
 	} %>
  </table>
  </div>
  <input type="button" value="另存为 Excel" onClick="saveCode(tableExcel)"> 
  </body>
</html>
