<%@page import="com.model.dingdanBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<dingdanBean> al=(ArrayList<dingdanBean>)request.getAttribute("dingdanArray");
 dingdanBean cb=al.get(0); 
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
  <tr class="abc">
    <td align="center">
    <form action="dingdan_modifyServlet?dingdanhao=<%=cb.getdingdanhao() %>"  method="post">
    <table width="100%" border="0" class="abc">
      <tr>
      </tr>
  <table width="780" height="495" border="0">
  
    <tr>
      <td colspan="3"><div align="center">更改订单信息</div></td>
    </tr>
    <tr>
      <td width="242">订单ID：<%=cb.getdingdan_ID() %>
        <label></label></td>
      <td width="264">时间：
        <input name="date" type="text" id="date" value=<%=cb.getdate() %>></td>
      <td width="260">类型：        
	  <select name="type" id="type">
          <option selected><%=cb.gettype() %></option>
		  <option>常规引物</option>
          <option>标记引物</option>
          <option>PCR产物测序</option>
          <option>质粒测序（菌液）</option>
          <option>全基因合成</option>
          <option>STR检测</option>
          <option>项目订单</option>
          <option>realtime 检测</option>
          <option>核酸提取</option>
          <option>试剂耗材</option>
        </select></td>
    </tr>
    <tr>
      <td>订单号：<%=cb.getdingdanhao() %>
                </td>
      <td>客户号：
        <input name="cus_ID" type="text" id="cus_ID" value=<%=cb.getcus_ID() %>></td>
      <td>员工号：
        <input name="sales_ID" type="text" id="sales_ID" value=<%=cb.getsales_ID() %>></td>
    </tr>
    <tr>
      <td>状态：        
	  <select name="state" id="state">
          <option selected><%=cb.getstate() %></option>
		  <option>未开发票</option>
          <option>已开发票未回款</option>
          <option>已开发票部分回款</option>
          <option>已开发票全部回款</option>
        </select></td>
      <td>发票号：
        <input name="fapiaohao" type="text" id="fapiaohao" value=<%=cb.getfapiao() %>></td>
      <td>收费员：
        <input name="shoufei_num" type="text" id="shoufei_num" value=<%=cb.getshoufei_num() %>></td>
    </tr>
    <tr>
      <td>样品号：
        <input name="sample_num" type="text" id="sample_num" value=<%=cb.getsample_num() %>></td>
      <td>价格：
        <input name="price" type="text" id="price" value=<%=cb.getprice() %>></td>
      <td>折扣：
        <input name="sell_off" type="text" id="sell_off" value=<%=cb.getsell_off() %>></td>
    </tr>
    
    
    <tr>
      <td colspan="3">样品描述：
        <input name="yangpinmiaoshu" type="text" id="yangpinmiaoshu" value=<%=cb.getyangpinmiaoshu() %> size="60"></td>
    </tr>
    
    
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <div align="center">
          <input type="submit" name="Submit" value="提交" onClick="document.formName.submit()">
          <input type="submit" name="Submit2" value="返回" OnClick="window.location.href='welcome.jsp'">
          </div>
      </label></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
