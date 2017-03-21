<%@page import="com.model.priceBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<priceBean> al=(ArrayList<priceBean>)request.getAttribute("priceArray");
 
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
  <table width="810" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td>名称</td>
      <td>种类名称</td>
      <td>类型</td>
      <td>范围</td>
      <td>价格</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    <%for(int i=0;i<al.size();i++){
		priceBean pb=al.get(i);
		
    if(i%2==1)
	{
	%>
	  <form action="price_modify?index=<%out.print(i); %>&&ID=<%=pb.getID() %>" name="price_modify<%out.print(i); %>"  method="post">
      <td><label><input name="name<%out.print(i); %>" type="text" size="20" value="<%=pb.getname() %>"></label></td>
      <td><label><input name="class_name<%out.print(i); %>" type="text" size="20" value="<%=pb.getclass_name() %>"></label></td>
      <td><label><input name="type<%out.print(i); %>" type="text" size="20" value="<%=pb.gettype() %>"></label></td>
      <td><%=pb.getqi() %>-<%=pb.getzhi() %></td>
      <td><label><input name="price<%out.print(i); %>" type="text" size="20" value="<%=pb.getprice() %>"></label></td>
      <td><label>
        <input type="submit" name="Submit" value="修改" onClick="document.price_modify<%out.print(i); %>.submit">
        </label>
        <label>
        <input type="button" name="Submit2" value="删除" Onclick="window.location.href='price_delete?ID=<%=pb.getID() %>'">
      </label></td>
      </form>
    </tr>
    <% }
   else{
    %>
      <form action="price_modify?index=<%out.print(i); %>&&ID=<%=pb.getID() %>" name="price_modify<%out.print(i); %>"  method="post">
      <td bgcolor="#99FFFF"><label><input name="name<%out.print(i); %>" type="text" size="20" value="<%=pb.getname() %>"></label></td>
      <td bgcolor="#99FFFF"><label><input name="class_name<%out.print(i); %>" type="text" size="20" value="<%=pb.getclass_name() %>"></label></td>
      <td bgcolor="#99FFFF"><label><input name="type<%out.print(i); %>" type="text" size="20" value="<%=pb.gettype() %>"></label></td>
      <td bgcolor="#99FFFF"><%=pb.getqi() %>-<%=pb.getzhi() %></td>
      <td bgcolor="#99FFFF"><label><input name="price<%out.print(i); %>" type="text" size="20" value="<%=pb.getprice() %>"></label></td>
      <td><label>
        <input type="submit" name="Submit" value="修改" onClick="document.price_modify<%out.print(i); %>.submit">
        </label>
        <label>
        <input type="button" name="Submit2" value="删除" Onclick="window.location.href='price_delete?ID=<%=pb.getID() %>'">
      </label></td>
      </form>
    </tr>
    <%
 		}
 	} %>
  </table>
  </body>
</html>
