<%@page import="com.model.userBean"%>
<%@page import="com.model.salesBean"%>
<%@page import="com.model.danweiBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
userBean ub=(userBean)request.getSession().getAttribute("userBean");
ArrayList<danweiBean> al=(ArrayList<danweiBean>)request.getAttribute("areaArray");
ArrayList<salesBean> salesl=(ArrayList<salesBean>)request.getAttribute("salesArray");
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
var data="dingdan_ID="+$('dingdan_ID').value;
myXmlHttpRequest.open("POST","dingdan_new_dingdan_cunzai",true);
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


function getcus_name(index){
    myXmlHttpRequest= getXmlHttpobject();
    if(myXmlHttpRequest) {
    //window.alert("chuli bei diaoyong");
    var data="keshi_name="+$('keshi_name'+index).value+"&danwei_name="+$('danwei_name'+index).value;
    //window.alert(data);
	myXmlHttpRequest.open("POST","dingdan_new_getcus_name",true);
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
		var cusname=document.getElementById('cus_name'+index);
		var getcusname=text.split("/");
		//for(var temp in getcusname){window.alert(getcusname[temp]);}
		cusname.options.length=0;
		delete getcusname[getcusname.length-1];
		cusname.options.add(new Option("--请选择--","--请选择--"));
		for(var temp in getcusname){
			//window.alert(getcusname[temp]);
			var getID=getcusname[temp].split(",");
			var ID=getID[0];
			var name=getID[1];
			
		cusname.options.add(new Option(ID+","+name,ID));
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
  
  <body >
  
  
  <tr class="abc">
    <td align="center">
    <form action="dingdan_newServlet?shoufei_num=<%=ub.getre_ID() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">新增订单</div></td>
    </tr>
    <tr>
      <td width="242">订单ID：
        <label></label></td>
      <td width="264">时间：
        <input name="date" type="text" id="date" onClick="getDateString(this, oCalendarChs)" value=<%out.print(str_date1); %> ></td>
      <td width="260">类型：        
        <select name="type" id="type">
          <option selected>常规引物</option>
          <option>标记引物</option>
          <option>PCR产物测序</option>
          <option>质粒测序（菌液）</option>
          <option>全基因合成</option>
          <option>STR检测</option>
          <option>项目订单</option>
          <option>realtime 检测</option>
          <option>核酸提取</option>
          <option>试剂耗材</option>
        </select>        </td>
    </tr>
    <tr>
      <td>订单号：
        <input name="dingdan_ID" type="text" id="dingdan_ID" onBlur="checkName()" value="11111">        </td>
      <td>员工号：
        <label>
          <select name="sales_ID" id="sales_ID" >
		  <option>--请选择--</option>
		  <%for(int i=0;i<salesl.size();i++){ %>
			  <option value=<%=salesl.get(i).getsales_ID() %>><%=salesl.get(i).getsales_ID() %>,<%=salesl.get(i).getName() %></option>  
		  <%} %>
            </select>
            </label></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><label>
        <div align="right">
        <label>
          <select name="area_name1" id="area_name1" onchange="getdanwei(1)">
		  <option>--请选择--</option>
		  <%for(int i=0;i<al.size();i++){ %>
			  <option value=<%=al.get(i).getarea_name() %>><%=al.get(i).getarea_name() %></option>  
		  <%} %>
            </select>
            </label>
            <label>
          <select name="danwei_name1" id="danwei_name1" onchange="getkeshi(1)">
          <option>--请选择--</option>
          </select>
          </label>
          <label>
          <select name="keshi_name1" id="keshi_name1" onchange="getcus_name(1)">
          <option>--请选择--</option>
          </select>
          </label>
          </div>
      </label></td>
      <td>客户号：        
        <label>
        <select name="cus_ID" id="cus_name1">
        </select>
        </label></td>
    </tr>
    <tr>
      <td>状态：        
        <select name="state" id="state">
          <option>未开发票</option>
          <option>已开发票未回款</option>
          <option>已开发票部分回款</option>
          <option selected>未开对账单未开发票</option>
          <option>已开发票全部回款</option>
        </select>        </td>
      <td>发票号：
        <input name="fapiaohao" type="text" id="fapiaohao" value="66666"></td>
      <td>操作员：
        <%=ub.getre_ID() %></td>
    </tr>
    <tr>
      <td>样品号：
        <input name="sample_num" type="text" id="sample_num" value="112233"></td>
      <td>金额：
        <input name="price" type="text" id="price" value="1000"></td>
      <td>折扣：
        <input name="sell_off" type="text" id="sell_off" value="1"></td>
    </tr>
    
    
    <tr>
      <td colspan="3">样品描述：
        <input name="yangpinmiaoshu" type="text" id="yangpinmiaoshu" value="hehe" size="60"></td>
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
