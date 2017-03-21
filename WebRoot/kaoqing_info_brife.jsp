<%@page import="com.model.kaoqingBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ArrayList<kaoqingBean> al = (ArrayList<kaoqingBean>) request.getAttribute("kaoqing");
	ArrayList nameList = (ArrayList) request.getAttribute("nameList");
	String date = (String) request.getAttribute("date");
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
<script type="text/javascript" src="JS/rili.js"></script>
<script type="text/javascript">
	function test() {
		document.getElementById("tableInfo").value = document
				.getElementById("table").innerHTML;
	}
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
<style type="text/css">
#flag1 {
	color: #3F0;
}

#flag0 {
	color: #F00;
}

#title {
	text-align: center;
	font-size: 18px;
}
</style>
</head>

<body>
	<div>
		<form action="kaoqingOP?action=search" name="chazhao" method="post">
			<p style="font-size: 12px">
				日期： <input name="date" type="text" id="date" size="10"
					onClick="getDateString(this, oCalendarChs)"
					value=<%out.print(date);%>>
			</p>
			<p>
				<input type="button" name="button" id="button" value="提交"
					onclick="document.chazhao.submit()"> <span
					style="font-size: 12px; color: #F00;">支持模糊查找，不输入代表查找全部</span>
			</p>
		</form>
		<p>------------------------------------</p>
	</div>
	<p id="title">
		<%
			out.print(date);
		%>考勤结果
	</p>
	<form action="ExportExcelServlet" method="post">
		<span id="table">
			<table border="1" cellspacing="0">
				<tr>

					<td>员工姓名</td>
					<td>打卡时间</td>
				</tr>
				<tr>

					<%
						for (int i = 0; i < nameList.size(); i++) {
					%>
					<td width="75">
						<%
							out.print(nameList.get(i));
						%>
					</td>
					<td width="390">
						<%
							for (int j = 0; j < al.size(); j++) {
									if (al.get(j).getSales_name().equals(nameList.get(i))) {
										out.print(al.get(j).getTime() + "&nbsp&nbsp&nbsp&nbsp");
									}
								}
						%>
					</td>
				</tr>
				<%
					}
				%>

			</table>
		</span> <input type="submit" name="Excel" value="导出表格" onclick="test()" /> <input
			type="hidden" id="tableInfo" name="tableInfo" value="" />
</body>
</html>
