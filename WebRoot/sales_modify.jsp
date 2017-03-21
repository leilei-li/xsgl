<%@page import="com.model.salesBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<salesBean> al=(ArrayList<salesBean>)request.getAttribute("salesArray");
salesBean cb=al.get(0); 
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
    <form action="sales_modifyServlet?sales_ID=<%=cb.getsales_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">更改员工信息</div></td>
    </tr>
    <tr>
      <td width="242">员工号：<%=cb.getsales_ID() %>
        <label></label></td>
      <td width="264">姓名：
      <input name="name" type="text" id="name" value=<%=cb.getName() %>></td>
      <td width="260">性别：
      <input name="sex" type="text" id="sex" value=<%=cb.getsex() %>></td>
    </tr>
    <tr>
      <td>CN_ID：
        <input name="CN_ID" type="text" id="CN_ID" value=<%=cb.getCN_ID() %>></td>
      <td>手机1：
      <input name="mobile1" type="text" id="mobile1" value=<%=cb.getmobile1() %>></td>
      <td>手机2：
      <input name="mobile2" type="text" id="mobile2" value=<%=cb.getmobile2() %>></td>
    </tr>
    <tr>
      <td>入职时间：
        <input name="inDate" type="text" id="inDate" value=<%=cb.getinDate()%>></td>
      <td>职务：
        <input name="duty" type="text" id="duty" value=<%=cb.getduty() %>></td>
      <td>级别：
        <input name="level" type="text" id="level" value=<%=cb.getlevel() %>></td>
    </tr>
    <tr>
      <td>薪水：
        <input name="salary" type="text" id="salary" value=<%=cb.getsalary() %>></td>
      <td>royalty：
        <input name="royalty" type="text" id="royalty" value=<%=cb.getroyalty() %>></td>
      <td>Team_ID：
        <input name="Team_ID" type="text" id="Team_ID" value=<%=cb.getTeam_ID() %>></td>
    </tr>
    
    <tr>
      <td colspan="3">邮箱：
        <label>
        <input name="email" type="text" id="email" value=<%=cb.getemail() %>>
        </label></td>
      </tr>
    <tr>
      <td colspan="3">性格：
        <label>
        <input name="characte" type="text" id="characte" value=<%=cb.getcharacter() %> size="60">
      </label></td>
    </tr>
    <tr>
      <td colspan="3">爱     好：
      <input name="favorite" type="text" id="favorite" value=<%=cb.getfavorite() %> size="60"></td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="submit" name="Submit" value="提交" onClick="document.formName.submit()"></td>
          <td><input type="button" name="Submit2" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
