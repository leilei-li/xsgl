<%@page import="com.model.cusBean"%>
<%@page import="com.model.dingdanBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<cusBean> al=(ArrayList<cusBean>)request.getAttribute("cusArray");
ArrayList<dingdanBean> dl=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
cusBean cb=al.get(0); 
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
  <table width="780"  border="0">
  
    <tr>
      <td colspan="5"><div align="center">客户详细信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE1">客户号：</span><%=cb.getcus_ID() %>
        <label></label></td>
      <td width="264" colspan="3"><span class="STYLE1">姓名：</span><%=cb.getName() %></td>
      <td width="260"><span class="STYLE1">性别：</span><%=cb.getsex() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">类型：</span><%=cb.gettype() %></td>
      <td colspan="3"><span class="STYLE1">手机1：</span><%=cb.getmobile1() %></td>
      <td><span class="STYLE1">手机2：</span><%=cb.getmobile2() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">固话：</span><%=cb.getphone() %></td>
      <td colspan="3"><span class="STYLE1">科室：</span><%=cb.getkeshi_name() %></td>
      <td><span class="STYLE1">角色：</span><%=cb.getrole() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">预付款：</span><%=cb.getadvance_money() %></td>
      <td colspan="3"><span class="STYLE1">积分：</span><%=cb.getjifen() %></td>
      <td><span class="STYLE1">经费：</span><%=cb.getkeyan_money() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">位置：</span><%=cb.getposition() %></td>
      <td colspan="3"><span class="STYLE1">优先级：</span><%=cb.getprotity() %></td>
      <td><span class="STYLE1">状态：</span><%=cb.getstate() %></td>
    </tr>
    <tr>
      <td><span class="STYLE1">邮箱：</span><%=cb.getemail() %>
        <label></label></td>
      <td colspan="3">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="5"><span class="STYLE1">科研任务：</span><%=cb.gettask() %>
        <label></label></td>
    </tr>
    <tr>
      <td colspan="5"><span class="STYLE1">爱     好：</span><%=cb.gethobby() %></td>
    </tr>
    <tr>
      <td colspan="5"><span class="STYLE1">科研成果：</span><%=cb.getchengguo() %></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <input type="button" name="Submit4" value="删除" onClick="window.location.href='cus_info_delete?cus_ID=<%=cb.getcus_ID() %>'">
      </label>
      <td><input type="button" name="Submit5" value="修改" onClick="window.location.href='cus_show_to_modify?cus_ID=<%=cb.getcus_ID() %>'">      
      <td><input type="button" name="Submit22" value="返回" onClick="window.location.href='welcome.jsp'">
      </div>      
    </tr>
  </table>
  <p>------该用户订单详情------</p>
  <table id="exampletable" style="text-align:right;" >
  <thead>
		<tr>
			<tr>
			<th>订单号</th>
			<th>员工号及姓名</th>
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
    	<td><%=cb1.getsales_ID() %>,<%=cb1.getsales_name() %></td>
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
