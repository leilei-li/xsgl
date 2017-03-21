<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
userBean ub=(userBean)request.getSession().getAttribute("userBean");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript">

function check()
{
 
  if(document.haha.password1.value==document.haha.password2.value)
  {
    document.haha.submit();
  }
  else
  {
    window.alert("两次输入不正确，请重新输入");
    document.getElementById('password1').value="";
    document.getElementById('password2').value="";
  } 
}

</script> 
<form name="haha" action="user_password_modify?username=<%=ub.getUserName() %>"  method="post">
 <body >
 <div align="center">
   <table width="600" height="150" border="1">
     <tr>
       <td><div align="center"><%=ub.getUserName() %>,修改密码</div></td>
     </tr>
     <tr>
       <td><div align="center">旧密码：
          <input name="password0" type="password" id="password0"  value=<%=ub.getPassword() %>/>
       </div></td>
     </tr>
     <tr>
       <td><label>
         <div align="center">新密码：
           <input name="password1" type="password" id="password1" />
           </div>
       </label></td>
     </tr>
     <tr>
       <td><div align="center">再次确认：
          <input name="password2" type="password" id="password2" />
       </div></td>
     </tr>
     <tr>
       <td><label>
         <div align="center">
           <input type="button" name="Submit" value="提交" onClick="check()" />
           </div>
       </label>
         <label>
         <div align="center">
           <input type="reset" name="Submit2" value="重设" />
           </div>
       </label></td>
     </tr>
    </table>
 </div>
 </body>
</html>
