<%@page import="com.model.dingdanBean"%>
<%@page import="com.model.userBean"%>
<%@page import="com.model.danweiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
request.getSession().setAttribute("duizhang_dingdan",al);
userBean ub=(userBean)request.getSession().getAttribute("userBean");
ArrayList<danweiBean> dl=(ArrayList<danweiBean>)request.getAttribute("danweiArray");
%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("yyyy-MM-dd");
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String str_date1 = formatter.format(currentTime); //将日期时间格式化 
String str_date2 = formatter2.format(currentTime); //将日期时间格式化 
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

function getdanwei(index){
    myXmlHttpRequest= getXmlHttpobject();
    if(myXmlHttpRequest) {
    //window.alert("chuli bei diaoyong");
    var data="area_name="+$('area_name'+index).value;
    //window.alert(data);
	myXmlHttpRequest.open("POST","cus_new_getdanwei_name",true);
	myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

	myXmlHttpRequest.onreadystatechange=chuli;
	myXmlHttpRequest.send(data);
    
    }
function $(id){
	return document.getElementById(id);
}    
function chuli()
{
//window.alert("chuli bei diaoyong");
if(myXmlHttpRequest.readyState==4){

	if(myXmlHttpRequest.status==200){ 
		//$('myres').value=myXmlHttpRequest.responseText;
		var text=myXmlHttpRequest.responseText;
		//window.alert(text);
		var danwei=document.getElementById('danwei_name'+index);
		var getdanwei=text.split("/");
		danwei.options.length=0;
		delete getdanwei[getdanwei.length-1];
		danwei.options.add(new Option("--请选择--","--请选择--"));
		for(var temp in getdanwei){
		danwei.options.add(new Option(getdanwei[temp],getdanwei[temp]));
		}
  	}
  }
  
}
}

function getkeshi(index){
    myXmlHttpRequest= getXmlHttpobject();
    if(myXmlHttpRequest) {
    //window.alert("chuli bei diaoyong");
    var data="danwei_name="+$('danwei_name'+index).value;
    //window.alert(data);
	myXmlHttpRequest.open("POST","cus_new_getkeshi_name",true);
	myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

	myXmlHttpRequest.onreadystatechange=chuli;
	myXmlHttpRequest.send(data);
    
    }
function $(id){
	return document.getElementById(id);
}    
function chuli()
{
//window.alert("chuli bei diaoyong");
if(myXmlHttpRequest.readyState==4){

	if(myXmlHttpRequest.status==200){ 
		//$('myres').value=myXmlHttpRequest.responseText;
		var text=myXmlHttpRequest.responseText;
		//window.alert(text);
		var keshi=document.getElementById('keshi_name'+index);
		var getkeshi=text.split("/");
		keshi.options.length=0;
		delete getkeshi[getkeshi.length-1];
		keshi.options.add(new Option("--请选择--","--请选择--"));
		for(var temp in getkeshi){
		keshi.options.add(new Option(getkeshi[temp],getkeshi[temp]));
		}
  	}
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
    <style type="text/css">
<!--
.STYLE2 {font-size: 12px}
.STYLE3 {
	font-size: 24px;
	font-weight: bold;
}
-->
    </style>
</head>
  
  <body>
  <form action="duizhang_creat2?username=<%=request.getSession().getAttribute("userName")%>&&date=<%out.print(str_date1); %>" name="duizhang" method="post">
  <table width="900" border="1" bordercolor="#000000">
    <tr>
      <td colspan="10"><div align="center" class="STYLE3">
        <label>
        <select name="area_name" id="area_name1" onChange="getdanwei(1)">
        <option>选择业务区</option>
        <%for(int i=0;i<dl.size();i++)
        { %>
              <option value=<%=dl.get(i).getarea_name() %>><%=dl.get(i).getarea_name() %></option>
              <%} %>
        </select>
        </label>
        <label>
        <select name="danwei_name" id="danwei_name1" onChange="getkeshi(1)">
        <option>选择单位</option>
        </select>
        </label>
        <label>
        <select name="keshi_name" id="keshi_name1">
        <option>选择科室</option>
        </select>
        </label>
        对账单</div></td>
    </tr>
    <tr>
      <td width="54"><div align="center"><span class="STYLE2">姓名</span></div></td>
      <td width="71"><div align="center"><span class="STYLE2">订单日期</span></div></td>
      <td width="80"><div align="center"><span class="STYLE2">订单号</span></div></td>
      <td width="254"><div align="center"><span class="STYLE2">样品名称</span></div></td>
      <td width="61"><div align="center"><span class="STYLE2">产品/服务</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">规格</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">数量</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">单价</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">金额</span></div></td>
      <td width="68"><div align="center"><span class="STYLE2">备注</span></div></td>
    </tr>
   <%for(int i=0;i<al.size();i++){
		dingdanBean cb=al.get(i);
	%>
    <tr>
      <td><span class="STYLE2"><%=cb.getcus_name()%></span></td>
      <td><span class="STYLE2"><%=cb.getdate() %></span></td>
      <td><span class="STYLE2"><%=cb.getdingdan_ID() %></span></td>
      <td><span class="STYLE2"><%=cb.getyangpinmiaoshu() %></span></td>
      <td><span class="STYLE2"><%=cb.gettype() %></span></td>
      <td><span class="STYLE2"><%=cb.getsample_num() %></span></td>
      <td><span class="STYLE2"><%=cb.getnum() %></span></td>
      <td><span class="STYLE2">￥<%=cb.getprice() %></span></td>
      <td><span class="STYLE2">￥<% out.print(cb.getprice()*cb.getnum());%></span></td>
      <td><span class="STYLE2">无</span></td>
    </tr>
    <%} %>
    <tr>
      <td>日期：</td>
      <td><%out.print(str_date2); %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit2" value="取消"></td>
      <td><label>
        <input type="button" name="Submit" value="确认" onClick="document.duizhang.submit()">
      </label></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
