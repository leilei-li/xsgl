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
var data="fapiao_ID="+$('fapiao_ID').value;
myXmlHttpRequest.open("POST","shoukuan_shishou",true);
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
	<script type="text/javascript" src="JS/rili.js" ></script>
  </head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <form action="shoukuan_newServlet?jizhang=<%=ub.getre_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">新增收款记录（发票必须存在）</div></td>
    </tr>
    <tr>
      <td width="242">订单号：
        <label>
        <input name="dingdan_ID" type="text" id="dingdan_ID" value="123">
      </label></td>
      <td width="264">发票号：
        <input name="fapiao_ID" type="text" id="fapiao_ID" value="11111"></td>
      <td width="260">时间：
        <input name="date" type="text" id="date" onClick="getDateString(this, oCalendarChs)" value=<%out.print(str_date1); %> ></td>
    </tr>
    <tr>
      <td>员工号：
        <input name="sales_ID" type="text" id="sales_ID" value="003" size="20"></td>
      <td>客户号：
        <input name="kehu_ID" type="text" id="kehu_ID" value="004"></td>
      <td>记帐员：
        <%=ub.getre_ID() %></td>
    </tr>
    <tr>
      <td>审核员：
        <input name="shenhe" type="text" id="shenhe" value="大明"></td>
      <td>类型：        
        <select name="type" id="type">
          <option>预付款</option>
          <option>后付款</option>
        </select>        </td>
      <td>实收：
        <input name="shishou" type="text" id="shishou" onClick="checkName()" value="1000"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
      <div align="center">
          <input name="myres" type="text"  id="myres" style="border-width:0 ; color: red" size="30"; >
        </div>
        <div align="center">
          <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
          <label>
          <input type="reset" name="Submit2" value="重置">
          </label>
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
