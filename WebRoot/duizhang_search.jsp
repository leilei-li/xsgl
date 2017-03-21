<%@page import="com.model.cusBean"%>
<%@page import="com.model.salesBean"%>
<%@page import="com.model.danweiBean"%>
<%@page import="com.model.keshiBean"%>
<%@page import="com.model.duizhangBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> cusl=(ArrayList<cusBean>)request.getAttribute("cusArray");
ArrayList<salesBean> salesl=(ArrayList<salesBean>)request.getAttribute("salesArray");
ArrayList<danweiBean> danweil=(ArrayList<danweiBean>)request.getAttribute("danweiArray");
ArrayList<keshiBean> keshil=(ArrayList<keshiBean>)request.getAttribute("keshiArray");
String start=(String)request.getAttribute("start");
String end=(String)request.getAttribute("end");
ArrayList<duizhangBean> duizhangl=(ArrayList<duizhangBean>)request.getAttribute("duizhangArray");
%>
<script type="text/javascript" src="JS/rili.js" ></script>
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
<form action="duizhang_search" name="duizhang_search"  method="post" target="right2">
  <body>
  <table width="800" border="0" cellpadding="0">
    <tr>
      <td width="100"><label>
        <input name="radiobutton" type="radio" value="cus_name" checked>
        客户
      </label></td>
      <td><label>
        <select name="cus_name" id="cus_name">
      <%for(int i=0;i<cusl.size();i++)
        { %>
              <option value=<%=cusl.get(i).getcus_ID() %>><%=cusl.get(i).getcus_ID() %>,<%=cusl.get(i).getName() %></option>
      <%} %>
      </select>
      </label></td>
    </tr>
    <tr>
      <td width="100"><input name="radiobutton" type="radio" value="sales_name">
销售员</td>
      <td><select name="sales_name" id="sales_name">
      <%for(int i=0;i<salesl.size();i++)
        { %>
              <option value=<%=salesl.get(i).getsales_ID() %>><%=salesl.get(i).getsales_ID() %>,<%=salesl.get(i).getName() %></option>
      <%} %>
            </select></td>
    </tr>
    <tr>
      <td width="100"><input name="radiobutton" type="radio" value="danwei_name">
        单位</td>
      <td><select name="danwei_name" id="danwei_name">
      <%for(int i=0;i<danweil.size();i++)
        { %>
              <option value=<%=danweil.get(i).getdanwei_name() %>><%=danweil.get(i).getdanwei_name() %></option>
      <%} %>
            </select></td>
    </tr>
    <tr>
      <td width="100"><input name="radiobutton" type="radio" value="keshi_name">
        科室</td>
      <td><select name="keshi_name" id="keshi_name">
      <%for(int i=0;i<keshil.size();i++)
        { %>
              <option><%=keshil.get(i).getdanwei_name() %>,<%=keshil.get(i).getkeshi_name() %></option>
      <%} %>
            </select></td>
    </tr>
    <tr>
      <td width="100"><input name="radiobutton" type="radio" value="dingdanhao">
对账号 </td>
      <td><label>
        <input name="duizhanghao" type="text" id="duizhanghao">
      </label></td>
    </tr>
    <tr>
      <td width="100"><input name="radiobutton" type="radio" value="dingdanriqi">
订单日期</td>
      <td><input name="start" type="text" id="start" value=<%out.print(start); %> onClick="getDateString(this, oCalendarChs)">
      <input name="end" type="text" id="end" value=<%out.print(end); %> onClick="getDateString(this, oCalendarChs)"></td>
    </tr>
    <tr>
      <td colspan="2"><label>
        <input type="button" name="Submit" value="提交" onClick="document.duizhang_search.submit()">
        <input type="reset" name="Submit2" value="重置">
      </label></td>
    </tr>
  </table>
  <p>------以下默认显示最近一个月的所有对账单------</p>
  <%if(duizhangl.size()>0) {
  %>
  <table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>对账单号码</th>
			<th>发票号码</th>
			<th>生成日期</th>
			<th>操作员</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<duizhangl.size();i++){
		duizhangBean cb=duizhangl.get(i);
		
    %>
    <tr>
    	<td><a href="duizhang_search_detail?duizhang_ID=<%=cb.getduizhang_ID()%>" ><%=cb.getduizhang_ID() %></a></td>
    	<td><a href="fapiao_info_detail?fapiao_ID=<%=cb.getfapiao_ID() %>" ><%=cb.getfapiao_ID()%></a></td>
    	<td><%=cb.getdate() %></td>
    	<td><%=cb.getusername() %></td>
 	</tr>
 <% } %>
</table>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
<%} %>
  </body>
</html>
