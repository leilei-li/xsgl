<%@page import="com.model.cusBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String cus_ID = (String) request.getAttribute("cus_ID");
	String info = (String) request.getAttribute("info");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>cus_info_detail</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
 <script type="text/javascript" src="JS/rili.js" ></script>
<link type="text/css" rel="stylesheet" href="css/slimtable.css">
<link type="text/css" rel="stylesheet" href="css/site.css">
<style type="text/css">
#button {
	text-align: right;
}
</style>
</head>
<body>
<form name="new_yinwu" action="yinwuOP?action=newYinwu&cus_ID=<%out.print(cus_ID); %>" method="post">
	<table width="561" border="0" cellspacing="0">
	  <tr style="color:red">
	    <th width="104" scope="col">客户信息：</th>
	    <th colspan="3" scope="col"><% out.print(cus_ID+info); %></th>
      </tr>
	  <tr>
	    <td>引物名称：</td>
	    <td colspan="3"><textarea name="yinwu_name" id="yinwu_name" cols="45" rows="5" placeholder="引物名称用英文逗号 ,  隔开，最后结尾不需要加逗号"></textarea></td>
      </tr>
	  <tr>
	    <td>是否是母液</td>
	    <td><select name="isMu" id="isMu">
	      <option selected="selected">否</option>
	      <option>是</option>
        </select></td>
	    <td>浓度：</td>
	    <td><select name="style" id="style">
	      <option>干粉</option>
	      <option>100p</option>
        </select></td>
      </tr>
	  <tr>
	    <td>数量：</td>
	    <td width="83"><input name="yinwu_num" type="text" id="yinwu_num" size="10" value="0" readonly></td>
	    <td width="83">类型：</td>
	    <td width="261"><select name="type" id="type">
	      <option>干粉</option>
	      <option>母液</option>
	      <option>工作液</option>
	      <option>返还</option>
	      <option>用完</option>
	      <option>过期</option>
        </select></td>
      </tr>
	  <tr>
	    <td>来源:</td>
	    <td><input name="yinwu_laiyuan" type="text" id="yinwu_laiyuan" placeholder="填写来源" size="10"></td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
      </tr>
	  <tr>
	    <td>&nbsp;</td>
	    <td><input type="submit" name="button" id="button" value="提交"></td>
	    <td><input type="reset" name="reformat" id="reformat" value="重置"></td>
	    <td>&nbsp;</td>
      </tr>
</table>
</form>
</body>
</html>
