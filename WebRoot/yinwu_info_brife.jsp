<%@page import="com.model.yinwuBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ArrayList<yinwuBean> yl = (ArrayList<yinwuBean>) request.getAttribute("yinwuList");
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
	String str_date1 = formatter.format(currentTime); //将日期时间格式化
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
<link type="text/css" rel="stylesheet" href="css/slimtable.css">
<link type="text/css" rel="stylesheet" href="css/site.css">
<script type="text/javascript" src="JS/rili.js" ></script>
<script type="text/javascript">
    function test(){
       document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
    }
</script>

</head>
<body>
	<div>
		<form action="yinwuOP?action=searchYinwu" name="chazhao" method="post">
			<p style="font-size: 12px">
				引物新编号： <input name="new_num" type="text" id="new_num" size="10">
				引物旧编号： <input name="old_num" type="text" id="old_num" size="10">
				引物名称： <input name="name" type="text" id="name" size="10">
				<br>
				客户名称： <input name="cus_name" type="text" id="cus_name" size="10">
				客户科室： <input name="keshi" type="text" id="keshi" size="10">
				客户单位： <input name="danwei" type="text" id="danwei" size="10">
				<br>
				开始日期: <input name="start_date" type="text" id="start_date" size="10"
					onClick="getDateString(this, oCalendarChs)" value="--请选择--">
				结束日期： <input name="end_date" type="text" id="end_date" size="10"
					onClick="getDateString(this, oCalendarChs)"
					value=<%out.print(str_date1);%>>
			</p>
			<p>
				<input type="button" name="button" id="button" value="提交"
					onclick="document.chazhao.submit()"> <span
					style="font-size: 12px; color: #F00;">支持模糊查找，不输入代表查找全部</span>
			</p>
		</form>
		<p>------------------------------------</p>
	</div>
	<form action="ExportExcelServlet" method="post">
	<span id="table"> 
	<table width="100%" border="1" cellspacing="0">
		<tr>
			<th scope="col">新编号</th>
			<th scope="col">旧编号</th>
			<th scope="col">引物名称</th>
			<th scope="col">日期</th>
			<th scope="col">客户</th>
			<th scope="col">备注</th>
		</tr>
		<%for(int i=0;i<yl.size();i++){
			yinwuBean yb=yl.get(i);
			%>
		<tr>
			<td><%=yb.getNew_num() %></td>
			<td><%=yb.getOld_num() %></td>
			<td><%=yb.getName() %></td>
			<td><%=yb.getDate() %></td>
			<td><%=yb.getCus_name() %>/<%=yb.getKeshi() %>/<%=yb.getDanwei() %></td>
			<td><%=yb.getBeizhu() %></td>
		</tr>
		<%} %>
	</table>
	</span>
	<input type="submit" name="Excel" value="导出表格" onclick="test()"/>
    <input type="hidden" id="tableInfo" name="tableInfo" value=""/>
    
</body>
</html>
