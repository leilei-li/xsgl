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
    <style type="text/css">
<!--
.STYLE1 {color: #0066FF}
-->
    </style>
</head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" border="0">
  
    <tr>
      <td colspan="3"><div align="center">详细发票信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE1">发票号：</span><%=cb.getfapiao_ID() %>
        <label></label></td>
      <td width="264"><span class="STYLE1">时间：</span><%=cb.getcreate_date() %></td>
      <td width="260"><span class="STYLE1">状态：</span><%=cb.getstate() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">订单号：</span><%=cb.getdingdan_ID() %></td>
      <td><span class="STYLE1">客户号：</span><%=cb.getcus_ID() %></td>
      <td><span class="STYLE1">员工号：</span><%=cb.getsales_ID() %> </td>
    </tr>
    
    <tr>
      <td><span class="STYLE1">票面金额：</span><%=cb.getmoney() %></td>
      <td><span class="STYLE1">实收金额：</span><%=cb.getshishou() %></td>
      <td><span class="STYLE1">经手人：</span><%=cb.getuser_ID() %></td>
    </tr>
    
    
    <tr>
      <td colspan="3"><span class="STYLE1">发票抬头：</span><%=cb.getfapiaotaitou() %></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="button" name="Submit2" value="删除" Onclick="window.location.href='fapiao_info_delete?fapiao_ID=<%=cb.getfapiao_ID() %>'"></td>
          <td><input type="button" name="Submit" value="修改" OnClick="window.location.href='fapiao_show_to_modify?fapiao_ID=<%=cb.getfapiao_ID() %>'"></td>
          <td><input type="button" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
