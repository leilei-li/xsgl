<%@page import="com.model.danweiBean"%>
<%@page import="com.model.shengshiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<danweiBean> al=(ArrayList<danweiBean>)request.getAttribute("areaArray");
ArrayList<shengshiBean> sl=(ArrayList<shengshiBean>)request.getAttribute("shengshiArray");
String last_cus_ID= (String)request.getAttribute("last_cus_ID");
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
var data="cus_ID="+$('cus_ID').value;
myXmlHttpRequest.open("POST","cus_new_cus_cunzai",true);
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
		window.alert(myXmlHttpRequest.responseText);
	}
}
}

function getcity(index){
    myXmlHttpRequest= getXmlHttpobject();
    if(myXmlHttpRequest) {
    //window.alert("chuli bei diaoyong");
    var data="province="+$('province'+index).value;
    //window.alert(data);
	myXmlHttpRequest.open("POST","cus_new_getcity",true);
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
		var city=document.getElementById('city'+index);
		var getcity=text.split("/");
		city.options.length=0;
		delete getcity[getcity.length-1];
		city.options.add(new Option("--请选择--","--请选择--"));
		for(var temp in getcity){
		city.options.add(new Option(getcity[temp],getcity[temp]));
		}
  	}
  }
  
}
}

function getarea_name(index){
    myXmlHttpRequest= getXmlHttpobject();
    if(myXmlHttpRequest) {
    //window.alert("chuli bei diaoyong");
    var data="city="+$('city'+index).value;
    //window.alert(data);
	myXmlHttpRequest.open("POST","cus_new_getarea_name",true);
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
		var area_name=document.getElementById('area_name'+index);
		var getarea_name=text.split("/");
		area_name.options.length=0;
		delete getarea_name[getarea_name.length-1];
		area_name.options.add(new Option("--请选择--","--请选择--"));
		for(var temp in getarea_name){
		area_name.options.add(new Option(getarea_name[temp],getarea_name[temp]));
		}
  	}
  }
  
}
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
.STYLE2 {
	font-size: 12px;
	text-align: left;
}
.STYLE4 {color: #FF0000}
.STYLE7 {color: #FF0000; font-size: 12px; }
-->
    </style>
</head>
  
  <body>
  <tr class="abc">
    <td align="center" class="STYLE2">
    <form action="danwei_newServlet" name="danwei_new"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>      </tr>
    <table width="813" border="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="left" class="STYLE2"><span class="STYLE4">新增单位:</span>
          <input name="danwei_name" type="text" id="danwei_name" value="北京邮电大学" size="20">
&nbsp;&nbsp;&nbsp;&nbsp;          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位地址：
<input name="address" type="text" id="address" value="西土城路十号" size="30">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name="Submit2" value="提交" onClick="document.danwei_new.submit()">
        </div>  </td>
      </tr>
      <tr>
        <td><span class="STYLE2">省市：</span>
          <label>
          <select name="province" id="province3" onChange="getcity(3)">
          <option>--请选择--</option>
        <%for(int i=0;i<3;i++)
        { %>
          <option value=<%=sl.get(i).getprovince() %>><%=sl.get(i).getprovince() %></option>
        <%} %>
        </select>
          </label>
          <label>
          <select name="city" id="city3" onChange="getarea_name(3)">
		  <option>--请选择--</option>
          </select>
          </label>
          <label>
          &nbsp;&nbsp;&nbsp;&nbsp;<span class="STYLE2">业务区：</span>
          <select name="area_name" id="area_name3" >
		  <option>--请选择--</option>
		  <%for(int i=0;i<al.size();i++)
        { %>
              <option value=<%=al.get(i).getarea_name() %>><%=al.get(i).getarea_name() %></option>
              <%} %>
            </select>
            </label>
		  &nbsp;&nbsp;&nbsp;&nbsp;<span class="STYLE2">负责人：</span>
          <input name="chair" type="text" id="chair" value="黎雷蕾" size="20">
          <br>
          <span class="STYLE2">单位详细信息：</span>
          <input name="info" type="text" id="info" value="就是北京邮电大学" size="30">
&nbsp;&nbsp;</label></td>
        </tr>
      <tr>
        <td><label></label></td>
      </tr>
      </table>
    </form>
<p>-----------------------------</p>
  <tr class="abc">
    <td align="center" class="STYLE2">
    <form action="keshi_newServlet" name="keshi_new"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>      </tr>
    <table width="813" border="0">
      <tr>
        <td><div align="left">
          <p><span class="STYLE7">新增科室：</span><span class="STYLE2">
            <input name="keshi_name" type="text" id="keshi_name" value="计算机学院" size="20">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;负责人：
  <input name="boss" type="text" id="boss" value="黎雷蕾" size="20">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" name="Submit3" value="提交" onClick="document.keshi_new.submit()">
          </p>
          <p>
            <label><span class="STYLE2">业务区：
            <select name="area_name2" id="area_name2" onChange="getdanwei(2)">
              <option>--请选择--</option>
              <%for(int i=0;i<al.size();i++)
        { %>
              <option value=<%=al.get(i).getarea_name() %>><%=al.get(i).getarea_name() %></option>
              <%} %>
            </select>
            </span></label>
            <span class="STYLE2">&nbsp;&nbsp;&nbsp;&nbsp;单位：
            <select name="danwei_name" id="danwei_name2" >
                        <option>--请选择--</option>
            </select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>
        </div></td>
      </tr>
      <tr>
        <td><label></label></td>
        </tr>
      </table>
  </form>
  <p>-----------------------------</p>
  <tr class="abc">
    <td align="center" class="STYLE2">
    <form action="cus_newServlet" name="cus_new"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>      </tr>
  <table width="813" height="241" border="0">
  
    <tr>
      <td height="32" class="STYLE2"><span class="STYLE4">新增客户：</span>
        <input name="name" type="text" id="name" value="张三" size="10">
        &nbsp;&nbsp;&nbsp;&nbsp;客户号：
        <input name="cus_ID" type="text" id="cus_ID"  value=<%out.print(last_cus_ID); %> size="10" readonly="true" style="background:#CCCCCC" >
        
        &nbsp;&nbsp;&nbsp;&nbsp;性别：
        <select name="sex" id="select">
          <option selected>男</option>
          <option>女</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;类型：
        <select name="type" id="select2">
          <option selected>本单位老师</option>
          <option>本单位学生</option>
          <option>其他单位老师</option>
          <option>其他单位学生</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="Submit" value="提交" onClick="document.cus_new.submit()"></td>
    </tr>
    <tr>
      <td height="32" class="STYLE2">手机1：
        <input name="mobile1" type="text" id="mobile1" value="13121908776" size="18">&nbsp;&nbsp;&nbsp;&nbsp;手机2：
        <input name="mobile2" type="text" id="mobile2" value="13121908776" size="18">
        &nbsp;&nbsp;&nbsp;&nbsp;固话：
        <input name="phone" type="text" id="phone" value="13121908776" size="18">
        &nbsp;&nbsp;&nbsp;&nbsp;邮箱：
        <label>
        <input name="email" type="text" id="email" value="abcdef@qq.com">
        </label></td>
      </tr>
    <tr>
      <td height="33" class="STYLE2"><label></label>
        <p>角色：
          <input name="role" type="text" id="role" value="拎包小弟" size="16">
          &nbsp;&nbsp;
          预付款：
          <input name="advance_money" type="text" id="advance_money" value="0" size="8">
  &nbsp;&nbsp;积分：
  <input name="jifen" type="text" id="jifen" value="0" size="8">
  &nbsp;&nbsp;经费：
  <input name="keyan_money" type="text" id="keyan_money" value="10000" size="8">
  &nbsp;&nbsp;位置：
  <input name="position" type="text" id="position" value="组长" size="8">
  &nbsp;</p>
        <p>&nbsp;优先级：
          <select name="protity" id="protity">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option selected>4</option>
                  </select>
  &nbsp;&nbsp;状态：
          <select name="state" id="state">
            <option>大客户</option>
            <option>潜在客户</option>
            <option selected>忠实客户</option>
            <option>摇摆客户</option>
            <option>小客户</option>
            <option>黑名单</option>
          </select>
        </p></td>
      </tr>
    
    <tr>
      <td height="32" class="STYLE2"><label>业务区：
          <select name="area_name" id="area_name1" onChange="getdanwei(1)">
          <option>--请选择--</option>
        <%for(int i=0;i<al.size();i++)
        { %>
          <option value=<%=al.get(i).getarea_name() %>><%=al.get(i).getarea_name() %></option>
        <%} %>
        </select>
        </label>
        &nbsp;&nbsp;&nbsp;&nbsp;单位：        
        <select name="danwei_name" id="danwei_name1" onChange="getkeshi(1)">
          <option>--请选择--</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;科室：        
        <select name="keshi_name" id="keshi_name1">
          <option>--请选择--</option>
        </select></td>
      </tr>
    
    <tr>
      <td height="33" class="STYLE2">科研任务：
        <label>
        <input name="task" type="text" id="task" value="写论文，发论文" size="60">
      </label></td>
    </tr>
    <tr>
      <td height="28" class="STYLE2">爱     好：
      <input name="hobby" type="text" id="hobby" value="睡大觉" size="60"></td>
    </tr>
    <tr>
      <td height="35" class="STYLE2">科研成果：
      <input name="chengguo" type="text" id="chengguo" value="N篇论文" size="60"></td>
    </tr>
  </table>
  </form>
  </body>
</html>
