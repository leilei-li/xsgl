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
	
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->

    </style>
    
<style>
	.list li{list-style-type:none}
	ul,li{margin:0;padding:0;}
</style>

</head>
  <script>
	function doAction(index){
		var obj = document.getElementById('u' + index);
		if(obj.style.display == 'none'){
			obj.style.display = 'block';
		}else{
			obj.style.display = 'none';
			
		}
	}
	
</script>

 <body >
<table width="1165" border="1" align="center">
  <tr>
    <td height="62" colspan="2" >你好,<%=request.getSession().getAttribute("quanxian")%>,<a href="user_password_modify.jsp"><%=request.getSession().getAttribute("userName")%></a>,<a href="index.jsp" >退出</a></td>
    <td width="988"><span class="STYLE1">若显示不正常，请使用浏览器的兼容模式(css问题,,暂时无法解决) </span></td>
  </tr>
  <tr>
    <td height="796" colspan="2" valign="top">
 <div id="d1" >
	<ul class="list">
		
		<li class="STYLE1">
		<span onclick="doAction(8);">后勤管理</span>		</li>
		<ul class="STYLE1" id="u8" style="display:none;">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="gift_new.jsp" target="right2">新增礼物</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="gift__dan_searchServlet?gift_name=&type=1"  target="right2">查看礼物库存</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="gift__dan_searchServlet?gift_name=&type=1"  target="right2">修改礼物库存</a></li>
		</ul>
		<li class="STYLE1">
		<span onclick="doAction(9);">事件登记</span>		</li>
		<ul class="STYLE1" id="u9" style="display:none;">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">奖惩记录</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="visit_new.jsp" target="right2">添加拜访记录</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="visit_search.jsp" target="right2">查找拜访记录</a></li>
			<li>删除拜访记录</a></li>
		</ul>
	</ul>
   </div>

</td>
      
	<td><iframe src="welcome.jsp" width="980" height="780"  name="right2" frameborder="0"> </iframe></td>
  </tr>
</table>
</body>
</html>
