<%@page import="com.model.userBean"%>
<%@page import="com.model.salesBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
userBean ub=(userBean)request.getSession().getAttribute("userBean");
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
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="JS/slimtable.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/slimtable.css">
	<link type="text/css" rel="stylesheet" href="css/site.css">
  </head>
<form action="gongzi_tongji" method="post" name="gongzi" >
  <body>
<table width="800" height="50" border="0" scrolling= "NO ">
  <tr>
    <td width="378">查找年份：
      <label>
      <select name="year" id="year">
        <option>2014</option>
        <option selected>2015</option>
        <option>2016</option>
        <option>2017</option>
      </select>
    查找月份：
    <select name="month" id="month">
      <option>一月</option>
      <option>二月</option>
      <option>三月</option>
      <option>四月</option>
      <option>五月</option>
      <option>六月</option>
      <option>七月</option>
      <option>八月</option>
      <option>九月</option>
      <option selected>十月</option>
      <option>十一月</option>
      <option>十二月</option>
    </select>
    </label></td>
    <td width="386"><label>员工号：
        <input name="sales_ID" type="text" size="20">
    </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><label>
      <input type="submit" name="Submit" value="提交" onClick="document.gongzi.submit()">
    </label>
      <label>
      <input type="reset" name="Submit2" value="重置">
    </label></td>
  </tr>
</table>
<p>--------------------------</p>
  <table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>员工姓名编号</th>
			<th>薪水</th>
			<th>提成</th>
			<th>销售额</th>
			<th>工资</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<al.size();i++){
		salesBean cb=al.get(i);
    %>
    <tr>
    	<td><%=cb.getName()%>,<%=cb.getsales_ID() %></a></td>
    	<td><%=cb.getsalary() %></td>
    	<td><%=cb.getroyalty() %>%</td>
    	<td><%out.print(xiaoshou[i]);%></td>
    	<td><%out.print(cb.getsalary()+cb.getroyalty()*0.01*xiaoshou[i]);%></td>
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
