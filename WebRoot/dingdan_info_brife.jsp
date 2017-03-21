<%@page import="com.model.dingdanBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
userBean ub=(userBean)request.getSession().getAttribute("userBean");

%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd"); 
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
	<script type="text/javascript" src="JS/rili.js" ></script>
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="JS/slimtable.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/slimtable.css">
	<link type="text/css" rel="stylesheet" href="css/site.css">
    <style type="text/css">
 
    </style>
</head>
  
  <body>
  <div>
  <form action="dingdan__duo_searchServlet?shoufei_num=<%=ub.getre_ID() %>" name="dingdan_search" method="post">
  <p style="font-size: 12px">
  开始时间：
  	<input name="start" type="text" id="start" onClick="getDateString(this, oCalendarChs)"  size="10" value="20150901" >
  结束时间：
  	<input name="end" type="text" id="end" onClick="getDateString(this, oCalendarChs)"  size="10" value=<%out.print(str_date1); %>>
  </p>
  <p style="font-size: 12px">
  员工名字：
  	<input name="sales_name" type="text" id="sales_name" size="10">
  客户名字：
    <input name="cus_name" type="text" id="cus_name" size="10">
  订单号码：
    <input name="dingdan_ID" type="text" id="dingdan_ID" size="10">
  </p>
  <p style="font-size: 12px">
  区 域：
    <input name="area_name" type="text" id="area_name" size="10">
  单 位：
      <input name="danwei" type="text" id="danwei" size="10">
  科 室：
      <input name="keshi" type="text" id="keshi" size="10">
  </p>
  <p>
  	<span style="font-size: 12px; color: #F00;" >支持模糊查找，不输入代表查找全部</span></p>
  	<input type="submit" name="Submit" value="提交" onClick="document.dingdan_search.submit()">
    <input type="reset" name="Submit2" value="重置">
  </p>
</form>
  </div>
<p>------------------------------------</p>
<table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>订单号</th>
			<th>客户号及姓名</th>
			<th>员工号及姓名</th>
			<th>开票日期</th>
			<th>科室单位</th>
			<th>状态</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
	dingdanBean cb=al.get(i);
		
    %>
    <tr>
    	<td><a href="dingdan_info_detail?dingdan_ID=<%=cb.getdingdan_ID() %>"><%=cb.getdingdan_ID() %></a></td>
    	<td><%=cb.getcus_ID() %>,<%=cb.getcus_name() %></a></td>
    	<td><%=cb.getsales_ID() %>,<%=cb.getsales_name() %></td>
    	<td><%=cb.getdate() %></td>
    	<td><%=cb.getkeshi_name() %>,<%=cb.getdanwei_name()%></td>
    	<td><%=cb.getstate()%></td>
 	</tr>
 <% } %>
</table>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
  </body>
</html>
