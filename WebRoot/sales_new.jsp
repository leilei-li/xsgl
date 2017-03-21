<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
//创建ajax引擎
var myXmlHttpRequest="";
function getXmlHttpobject()
{
   
    if(window.ActiveXObject){
    xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else{
    xmlHttpRequest=new XMLHttpRequest();
    }
    return xmlHttpRequest;
}
function checkName()
{
myXmlHttpRequest= getXmlHttpobject();
if(myXmlHttpRequest) {
//window.alert("chuangjianchenggong");

//window.alert(url);
var data="sales_ID="+$('sales_ID').value;
myXmlHttpRequest.open("POST","sales_new_sales_cunzai",true);
myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

myXmlHttpRequest.onreadystatechange=chuli;
myXmlHttpRequest.send(data);
}
function $(id)
{
return document.getElementById(id);
}
function chuli()
{
//window.alert("chuli bei diaoyong");
if(myXmlHttpRequest.readyState==4)
{    
$('myres').value=myXmlHttpRequest.responseText;
}
}

}

</script>
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
    <form action="sales_newServlet"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780"  border="0">
  
    <tr>
      <td colspan="3"><div align="center">新增员工</div></td>
    </tr>
    <tr>
      <td width="242">员工号：
        <label>
        <input name="sales_ID" type="text" id="sales_ID" onBlur="checkName()" value="001">
      </label></td>
      <td width="264">姓名：
      <input name="name" type="text" id="name" value="张三"></td>
      <td width="260">性别：
      <input name="sex" type="text" id="sex" value="男"></td>
    </tr>
    <tr>
      <td>CN_ID：
        <input name="CN_ID" type="text" id="CN_ID" value="11111">        </td>
      <td>手机1：
      <input name="mobile1" type="text" id="mobile1" value="13121908776"></td>
      <td>手机2：
      <input name="mobile2" type="text" id="mobile2" value="13121908776"></td>
    </tr>
    <tr>
      <td>入职时间：
        <input name="inDate" type="text" id="inDate" value="20150926" size="15"></td>
      <td>职责：
        <input name="duty" type="text" id="duty" value="66666"></td>
      <td>级别：
        <input name="level" type="text" id="level" value="拎包小弟"></td>
    </tr>
    <tr>
      <td>薪水：
        <input name="salary" type="text" id="salary" value="0"></td>
      <td>提成：
        <input name="royalty" type="text" id="royalty" value="2"></td>
      <td>团队：
        <input name="team_ID" type="text" id="team_ID" value="55645"></td>
    </tr>
    <tr>
      <td>邮箱：
        <label>
        <input name="email" type="text" id="email" value="abcdef@qq.com">
        </label></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td colspan="3">性 格：
        <input name="character" type="text" id="character" value="hehe" size="60"></td>
    </tr>
    <tr>
      <td colspan="3">爱     好：
      <input name="favourite" type="text" id="hobby" value="睡大觉" size="60"></td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
	  <div align="center">
          <input name="myres" type="text"  id="myres" style="border-width:0 ; color: red" size="30"; >
        </div>
        <div align="center">
          <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
