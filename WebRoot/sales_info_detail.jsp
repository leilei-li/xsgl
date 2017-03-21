<%@page import="com.model.salesBean"%>
<%@page import="com.model.dingdanBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<salesBean> al=(ArrayList<salesBean>)request.getAttribute("salesArray");
ArrayList<dingdanBean> dl=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
salesBean cb=al.get(0); 
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
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="JS/slimtable.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/slimtable.css">
	<link type="text/css" rel="stylesheet" href="css/site.css">
    <style type="text/css">
<!--
.STYLE1 {color: #0066FF}
-->
    </style>
</head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" border="0">
  
    <tr>
      <td colspan="3"><div align="center">员工详细信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE1">员工号：</span><%=cb.getsales_ID() %>
        <label></label></td>
      <td width="264"><span class="STYLE1">姓名：</span><%=cb.getName() %></td>
      <td width="260"><span class="STYLE1">性别：</span><%=cb.getsex() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">CN_ID：</span><%=cb.getCN_ID() %></td>
      <td><span class="STYLE1">手机1：</span><%=cb.getmobile1() %></td>
      <td><span class="STYLE1">手机2：</span><%=cb.getmobile2() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">入职时间：</span><%=cb.getinDate() %></td>
      <td><span class="STYLE1">职务：</span><%=cb.getduty() %></td>
      <td><span class="STYLE1">级别：</span><%=cb.getlevel() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">薪水：</span><%=cb.getsalary() %></td>
      <td><span class="STYLE1">royalty：</span><%=cb.getroyalty() %></td>
      <td><span class="STYLE1">Team_ID：</span><%=cb.getTeam_ID() %></td>
    </tr>
    
    <tr>
      <td colspan="3"><span class="STYLE1">邮箱：</span><%=cb.getemail() %>
        <label></label></td>
      </tr>
    <tr>
      <td colspan="3"><span class="STYLE1">性格：</span><%=cb.getcharacter() %>
        <label></label></td>
    </tr>
    <tr>
      <td colspan="3"><span class="STYLE1">爱     好：</span><%=cb.getfavorite() %></td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <td><input type="submit" name="Submit2" value="删除" Onclick="window.location.href='sales_info_delete?sales_ID=<%=cb.getsales_ID() %>'"></td>
          <td><input type="submit" name="Submit" value="修改" OnClick="window.location.href='sales_show_to_modify?sales_ID=<%=cb.getsales_ID() %>'"></td>
          <td><input type="button" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'"></td>
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p>------该员工订单详情------</p>
  <table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>订单号</th>
			<th>客户号及姓名</th>
			<th>开票日期</th>
			<th>科室单位</th>
			<th>状态</th>
		</tr>
		</tr>
	</thead>
<%for(int i=0;i<dl.size();i++){
		dingdanBean cb1=dl.get(i);
		
    %>
    <tr>
    	<td><a href="dingdan_info_detail?dingdan_ID=<%=cb1.getdingdan_ID() %>" ><%=cb1.getdingdan_ID() %></a></td>
    	<td><%=cb1.getcus_ID() %>,<%=cb1.getcus_name() %></td>
    	<td><%=cb1.getdate() %></td>
    	<td><%=cb1.getkeshi_name() %>,<%=cb1.getdanwei_name()%></td>
    	<td><%=cb1.getstate()%></td>
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
