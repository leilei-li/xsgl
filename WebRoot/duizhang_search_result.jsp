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
.STYLE2 {font-size: 12px}
-->
    </style>
</head>
<script type="text/javascript">
    function test(){
       document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
    }
</script>
  <body>
  <form action="ExportExcelServlet" method="post"> 
  <span id="table"> 
  <table width="800" border="1" cellspacing="0">
    <tr>
      <td width="114" class="STYLE2">对账单号码：</td>
      <td width="114" class="STYLE2">发票号码：</td>
      <td width="114" class="STYLE2">生成日期：</td>
      <td width="114" class="STYLE2">操作员：</td>
      <td width="114" class="STYLE2">单位科室</td>
      <td width="114" class="STYLE2">销售员</td>
      <td width="114" class="STYLE2">客户</td>
    </tr>
    <%for(int i=0;i<al.size();i++){
		duizhangBean cb=al.get(i);
		
    %>
    <tr>
      <td><a href="duizhang_search_detail?duizhang_ID=<%=cb.getduizhang_ID()%>" class="STYLE2" ><%=cb.getduizhang_ID() %></a></td>
      <td class="STYLE2"><%=cb.getfapiao_ID() %></td>
      <td class="STYLE2"><%=cb.getdate() %></td>
      <td class="STYLE2"><%=cb.getusername() %></td>
      <td class="STYLE2"><%=cb.getdanwei_name() %>,<%=cb.getkeshi_name() %></td>
      <td class="STYLE2"><%=cb.getsales_ID() %>,<%=cb.getsales_name() %></td>
      <td class="STYLE2"><%=cb.getcus_ID() %>,<%=cb.getcus_name() %></td>
    </tr>
    <%} %>
  </table>
  </span>
  <input type="submit" value="另存为 Excel" onClick="test()"> 
  <input type="hidden" id="tableInfo" name="tableInfo" value=""/>
  </body>
</html>
