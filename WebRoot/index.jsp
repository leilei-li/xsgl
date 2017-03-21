<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login</title>

<link href="css/style_login.css" rel="stylesheet" type="text/css">

</head>
<form action="loginClServlet" name="login" method="post">
<body class="login">
<div class="login_m">
	<div class="login_logo"><img src="images/logo.png" width="196" height="46"></img></div>
	<div class="login_boder">
		<div class="login_padding">
			<h2>用户名</h2>
			<label>
				<input type="text" name="username" class="txt_input txt_input2" >
			</label>
			<h2>密码</h2>
			<label>
				<input type="password" name="password" id="userpwd" class="txt_input" >
			</label>
			<div class="rem_sub">
				<label>
					<input type="submit" class="sub_button" name="button"  value="登录" style="opacity: 0.7;" >
					<br />
                </label>
                					2017.03.10更新，请联系lileilei258@foxmail.com
			</div>
		</div>
	</div><!--login_boder end-->
</div><!--login_m end-->

<br />
<br />


</body>
</html>