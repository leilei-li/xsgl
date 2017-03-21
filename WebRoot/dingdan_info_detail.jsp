<%@page import="com.model.dingdanBean"%>
<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
dingdanBean cb=al.get(0);
userBean ub=(userBean)request.getSession().getAttribute("userBean"); 
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
    <style type="text/css">
<!--
.STYLE2 {color: #0066ff}
-->
    </style>
</head>
  
  <body>
  <tr class="abc">
    <td align="center">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">订单详细信息</div></td>
    </tr>
    <tr>
      <td width="242"><span class="STYLE2">订单ID：</span><%=cb.getdingdan_ID() %>
        <label></label></td>
      <td width="264"><span class="STYLE2">时间：</span><%=cb.getdate() %>       </td> 
      <td width="260"><span class="STYLE2">类型：</span><%=cb.gettype() %>        </td>
    </tr>
    <tr>
      <td><span class="STYLE2">订单号：</span><%=cb.getdingdanhao() %>        </td>
      <td><span class="STYLE2">客户号：</span><%=cb.getcus_ID() %>       </td>
      <td><span class="STYLE2">员工号：</span><%=cb.getsales_ID() %>      </td>
    </tr>
    <tr>
      <td><span class="STYLE2">状态：</span><%=cb.getstate() %>        </td>
      <td><span class="STYLE2">发票号：</span><%=cb.getfapiao() %>        </td>
      <td><span class="STYLE2">收费员：</span><%=cb.getshoufei_num() %>        </td>
    </tr>
    <tr>
      <td><span class="STYLE2">样品号：</span><%=cb.getsample_num() %>        </td>
      <td><span class="STYLE2">价格：</span><%=cb.getprice() %>        </td>
      <td><span class="STYLE2">折扣：</span><%=cb.getsell_off() %>        </td>
    </tr>
    
    
    <tr>
      <td colspan="3"><span class="STYLE2">样品描述：</span><%=cb.getyangpinmiaoshu() %>        </td>
    </tr>
    
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <input type="hidden" name="0" value="0">
          <%if(ub.getType().equals("admin")|ub.getType().equals("caiwu")){ %>
          <input type="submit" name="Submit2" value="删除" Onclick="window.location.href='dingdan_info_delete?dingdan_ID=<%=cb.getdingdan_ID() %>'">
          <input type="submit" name="Submit" value="修改" OnClick="window.location.href='dingdan_show_to_modify?dingdan_ID=<%=cb.getdingdan_ID() %>'">
          <%} %>
          <input type="submit" name="Submit22" value="返回" OnClick="window.location.href='welcome.jsp'">
        </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
