<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<table width="800" height="506" border="0" scrolling= "NO ">
<p><img src="images/dog.gif" width="76" height="44"></p>
<p>解决safari登录的问题了！</p>
<!-- 
<p>160407：所有的上传功能都不能用了，得回去找原因，应该是电脑上的Eclipse出问题了</p>
<p>160328：增加返回页面顶部按钮</p>
<p>160324：以前编的好多数据结构有问题，比如算工资的就不太好用，以后再改</p>
<p>160308：导入的模板可以下载了，这样就不用去现编了</p>
<p>160304：改来改去还是BUG不断</p>
<p>160212：导入能够看到是否成功了，结束后会跳到导入结果的界面</p>
<p>160203：新年快乐</p>
<p>160127：兼容性修复</p>
<p>160124：修正导出excel表格的乱码的问题，导出对账单可以正常使用了。</p>
<p>160123：解决了JDK版本问题，阿里云能够正常访问了。</p>
<p>160122：window迁移mac os的问题，导致了浏览器的不匹配，目前只测试了webkit和ie内核，基本正常。</p>
<p>160121：分页会显示所有页码，造成显示上的不美观。</p>
-->

</body>
</html>
