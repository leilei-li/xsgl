<%@page import="com.model.cusBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> al=(ArrayList<cusBean>)request.getAttribute("cusArray");
cusBean cb=al.get(0); 
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
    <form action="cus_modifyServlet?cus_ID=<%=cb.getcus_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">更改客户信息</div></td>
    </tr>
    <tr>
      <td width="242">客户号：<%=cb.getcus_ID() %>
        <label></label></td>
      <td width="264">姓名：
      <input name="name" type="text" id="name" value=<%=cb.getName() %>></td>
      <td width="260">性别：        
        <select name="sex">
          <option><%=cb.getsex() %></option>
          <option>男</option>
          <option>女</option>
        </select>        </td>
    </tr>
    <tr>
      <td>类型：
<select name="type" id="type">
          <option selected><%=cb.gettype() %></option>
          <option>本单位老师</option>
          <option>本单位学生</option>
          <option>其他单位老师</option>
          <option>其他单位学生</option>
        </select>        
</td>
      <td>手机1：
      <input name="mobile1" type="text" id="mobile1" value=<%=cb.getmobile1() %>></td>
      <td>手机2：
      <input name="mobile2" type="text" id="mobile2" value=<%=cb.getmobile2() %>></td>
    </tr>
    <tr>
      <td>固话：
        <input name="phone" type="text" id="phone" value=<%=cb.getphone()%>></td>
      <td>科室：
      <input name="keshi_ID" type="text" id="keshi_ID" value=<%=cb.getkeshi_name() %>></td>
      <td>角色：
        <input name="role" type="text" id="role" value=<%=cb.getrole() %>></td>
    </tr>
    <tr>
      <td>预付款：
      <input name="advance_money" type="text" id="advance_money" value=<%=cb.getadvance_money() %>></td>
      <td>积分：
      <input name="jifen" type="text" id="jifen" value=<%=cb.getjifen() %>></td>
      <td>经费：
      <input name="keyan_money" type="text" id="keyan_money" value=<%=cb.getkeyan_money() %>></td>
    </tr>
    <tr>
      <td>位置：
      <input name="position" type="text" id="position" value=<%=cb.getposition() %>></td>
      <td>优先级：
<select name="protity" id="protity">
          <option selected><%=cb.getprotity() %></option>
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
        </select></td>
      <td>状态：
      
<select name="state" id="state">
          <option selected><%=cb.getstate() %></option>
          <option>大客户</option>
          <option>潜在客户</option>
          <option>忠实客户</option>
          <option>摇摆客户</option>
          <option>小客户</option>
          <option>黑名单</option>
        </select></td>
    </tr>
    <tr>
      <td>邮箱：
        <label>
        <input name="email" type="text" id="email" value=<%=cb.getemail() %>>
        </label></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3">科研任务：
        <label>
        <input name="task" type="text" id="task" value=<%=cb.gettask() %> size="60">
      </label></td>
    </tr>
    <tr>
      <td colspan="3">爱     好：
      <input name="hobby" type="text" id="hobby" value=<%=cb.gethobby() %> size="60"></td>
    </tr>
    <tr>
      <td colspan="3">科研成果：
      <input name="chengguo" type="text" id="chengguo" value=<%=cb.getchengguo() %> size="60"></td>
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
