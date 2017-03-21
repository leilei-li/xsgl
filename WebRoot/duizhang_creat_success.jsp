<%@page import="com.model.dingdanBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getSession().getAttribute("duizhang_dingdan");
userBean ub=(userBean)request.getSession().getAttribute("userBean");
Object duizhang_ID=request.getAttribute("duizhang_ID");
String danwei_name = (String)request.getAttribute("danwei_name");
String keshi_name = (String)request.getAttribute("keshi_name");
%>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String str_date1 = formatter.format(currentTime); //将日期时间格式化 
%>
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
    <style type="text/css">
<!--
.STYLE2 {font-size: 12px}
.STYLE3 {
	font-size: 24px;
	font-weight: bold;
}
-->
    </style>
</head>
  
  <body>
  <div id="tableExcel"> 
  <table width="900" border="1" bordercolor="#000000" cellspacing="0">
    <tr>
      <td colspan="10"><div align="center" class="STYLE3"><%out.print(danwei_name); %><%out.print(keshi_name); %>对账单</div></td>
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
      &nbsp;
      </label></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </div>
  <input type="button" value="生成 Excel" onclick="saveCode(tableExcel)">
  </body>
</html>
