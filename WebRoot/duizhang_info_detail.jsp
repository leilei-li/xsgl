<%@page import="com.model.dingdanBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray11");
userBean ub=(userBean)request.getSession().getAttribute("userBean");
Object duizhang_ID=request.getAttribute("duizhang_ID");
request.getSession().setAttribute("dingdanArray12",al);
%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String str_date1 = formatter.format(currentTime); //将日期时间格式化 
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
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
    
<!--
.STYLE2 {font-size: 12px}
.STYLE3 {
	font-size: 24px;
	font-weight: bold;
}
-->
    </style>
<script type="text/javascript"> 
function saveCode(obj) { 
          var winname = window.open('', '_blank', 'top=10000'); 
          var strHTML = document.all.tableExcel.innerHTML; 
          winname.document.open('text/html', 'replace'); 
          winname.document.writeln(strHTML); 
          winname.document.execCommand('saveas','','<%out.print(str_date1);%>.xls'); 
          winname.close(); 
} 
</script>
<script type="text/javascript">
    function test(){
       document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
    }
</script>
</head>
  <body>
<form action="ExportExcelServlet" method="post"> 
<span id="table">
    <table width="900" border="1" bordercolor="#000000" cellspacing="0">
    <tr>
      <td colspan="10"><div align="center" class="STYLE3">XXX对账单</div></td>
    </tr>
    <tr>
      <td width="54"><div align="center"><span class="STYLE2">姓名</span></div></td>
      <td width="71"><div align="center"><span class="STYLE2">订单日期</span></div></td>
      <td width="80"><div align="center"><span class="STYLE2">订单号</span></div></td>
      <td width="254"><div align="center"><span class="STYLE2">样品名称</span></div></td>
      <td width="61"><div align="center"><span class="STYLE2">产品/服务</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">规格</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">数量</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">单价</span></div></td>
      <td width="62"><div align="center"><span class="STYLE2">金额</span></div></td>
      <td width="68"><div align="center"><span class="STYLE2">备注</span></div></td>
    </tr>
   <%for(int i=0;i<al.size();i++){
		dingdanBean cb=al.get(i);
	%>
    <tr>
      <td><span class="STYLE2"><%=cb.getcus_name()%></span></td>
      <td><span class="STYLE2"><%=cb.getdate() %></span></td>
      <td><span class="STYLE2"><%=cb.getdingdan_ID() %></span></td>
      <td><span class="STYLE2"><%=cb.getyangpinmiaoshu() %></span></td>
      <td><span class="STYLE2"><%=cb.gettype() %></span></td>
      <td><span class="STYLE2"><%=cb.getsample_num() %></span></td>
      <td><span class="STYLE2"><%=cb.getnum() %></span></td>
      <td><span class="STYLE2">￥<%=cb.getprice() %></span></td>
      <td><span class="STYLE2">￥<% out.print(cb.getprice()*cb.getnum());%></span></td>
      <td><span class="STYLE2">无</span></td>
    </tr>
    <%} %>
    <tr>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
      <td><span class="STYLE2"></span></td>
    </tr>
    <tr>
      <td><span class="STYLE2">日期：</span></td>
      <td><span class="STYLE2">
      <%out.println(str_date1); %>
      </span></td>
      <td><span class="STYLE2">订单号：</span></td>
      <td><span class="STYLE2">
      <%out.println(duizhang_ID); %>
      </span></td>
      <td><span class="STYLE2">操作员：</span></td>
      <td><span class="STYLE2">
      <%out.println(ub.getUserName()); %>
      </span></td>
      <td><span class="STYLE2"></span></td>
      <td><label>
      </label></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
    </span>
<input type="submit" name="Excel" value="导出表格" onclick="test()"/>
    <input type="hidden" id="tableInfo" name="tableInfo" value=""/>
</body> 
</html>
