<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  </head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <form action="fapiao_newServlet?user_ID=<%=ub.getre_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">新增发票</div></td>
    </tr>
    <tr>
      <td width="242">发票号：
        <label>
        <input name="fapiao_ID" type="text" id="fapiao_ID" value="11111">
        </label></td>
      <td width="264">时间：
        <input name="create_date" type="text" id="create_date" onClick="getDateString(this, oCalendarChs)" value=<%out.print(str_date1); %>></td>
      <td width="260">状态：
        <select name="state" id="state">
          <option>未收款</option>
          <option>已收全款</option>
          <option>丢失</option>
          <option selected>已收但金额不足</option>
        </select>        </td>
    </tr>
    <tr>
      <td>订单号：
        <input name="dingdan_ID" type="text" id="dingdan_ID" value="11111">        </td>
      <td>客户号：
        <input name="cus_ID" type="text" id="cus_ID" value="001"></td>
      <td>员工号：
        <input name="sales_ID" type="text" id="sales_ID" value="002"></td>
    </tr>
    
    <tr>
      <td>票面金额：
        <input name="money" type="text" id="money" value="10000" size="20"></td>
      <td>实收金额：
        <input name="shishou" type="text" id="shishou" value="5000" size="20"></td>
      <td>操作员：
        <%=ub.getre_ID() %></td>
    </tr>
    
    
    <tr>
      <td colspan="3">发票抬头：
        <input name="fapiaotaitou" type="text" id="fapiaotaitou" value="hehe" size="60"></td>
    </tr>
    
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
