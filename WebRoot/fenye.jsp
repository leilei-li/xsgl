<%@page import="com.model.giftBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<giftBean> al=(ArrayList<giftBean>)request.getAttribute("giftArray");
 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>test</title>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="JS/slimtable.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/slimtable.css">
<link type="text/css" rel="stylesheet" href="css/site.css">
</head>

<body>
<br>
<div>
  <form action="gift__dan_searchServlet?type=2" name="chazhao" method="post">
  <p>按照：
    <label for="select"></label>
    <select name="select" size="1" id="select">
      <option selected="selected">礼物名</option>
      <option>价值</option>
    </select>
    查找：
    <label for="textfield"></label>
    <input type="text" name="gift_name" id="textfield"> 
    <input type="button" name="button" id="button" value="提交" onclick="document.chazhao.submit()">
  </p>
  </form>
  <p>------------------------------------</p>
</div>
<table id="exampletable" style="text-align:right;" >
	<thead>
		<tr>
			<tr>
			<th>ID</th>
			<th>礼物名</th>
			<th>数量</th>
			<th>价值</th>
			<th>积分</th>
		</tr>
		</tr>
	</thead>
	<%for(int i=0;i<al.size();i++){
		giftBean cb=al.get(i);
		
    %>
    <tr>
    <td><%=cb.getgift_ID() %>
    <td><%=cb.getgift_name() %></td>
    <td><%=cb.getgift_num() %></td>
    <td><%=cb.getgift_value() %></td>
    <td><%=cb.getjifen() %></td>
  </tr>
 <% } %>
</table>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>
