<%@page import="com.model.fapiaoBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<fapiaoBean> al=(ArrayList<fapiaoBean>)request.getAttribute("fapiaoArray");
 fapiaoBean cb=al.get(0); 
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
  <tr class="abc">
    <td align="center">
    <form action="fapiao_modifyServlet?fapiao_ID=<%=cb.getfapiao_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">更改发票信息</div></td>
    </tr>
    <tr>
      <td width="242">发票号：<%=cb.getfapiao_ID() %>
        <label>
        
        </label></td>
      <td width="264">时间：
        <input name="create_date" type="text" id="create_date" value=<%=cb.getcreate_date() %>></td>
      <td width="260">状态：
        <select name="state" id="state">
          <option><%=cb.getstate() %></option>
          <option>未收款</option>
          <option>已收全款</option>
          <option>丢失</option>
          <option>已收但金额不足</option>
        </select>        </td>
    </tr>
    <tr>
      <td>订单号：
        <input name="dingdan_ID" type="text" id="dingdan_ID" value=<%=cb.getdingdan_ID() %>>        </td>
      <td>客户号：
        <input name="cus_ID" type="text" id="cus_ID" value=<%=cb.getcus_ID() %>></td>
      <td>员工号：
        <input name="sales_ID" type="text" id="sales_ID" value=<%=cb.getsales_ID() %>></td>
    </tr>
    
    <tr>
      <td>票面金额：
        <input name="money" type="text" id="money" value=<%=cb.getmoney() %> size="20"></td>
      <td>实收金额：
        <input name="shishou" type="text" id="shishou" value=<%=cb.getshishou() %> size="20"></td>
      <td>经手人：
        <input name="user_ID" type="text" id="user_ID" value=<%=cb.getuser_ID() %>></td>
    </tr>
    
    
    <tr>
      <td colspan="3">发票抬头：
        <input name="fapiaotaitou" type="text" id="fapiaotaitou" value=<%=cb.getfapiaotaitou() %> size="60"></td>
    </tr>
    
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="submit" name="Submit" value="提交" onClick="document.formName.submit()"></td>
          <td><input type="button" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
