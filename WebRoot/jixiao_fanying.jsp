<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	userBean ub = (userBean) request.getSession().getAttribute("userBean");
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
	String date = formatter.format(currentTime); //将日期时间格式化
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<style type="text/css">
body p {
	font-weight: bold;
	font-size: 26px;
	text-align: center;
}
</style>
<script>
	function sum() {
		total.value = 0;
		total.value = parseFloat(weishentotal.value)
				+ parseFloat(zhuangqiangtoutotal.value)
				+ parseFloat(baiyangpintotal.value)
				+ parseFloat(yinwuxishitotal.value)
				+ parseFloat(yinwudengjitotal.value)
				+ parseFloat(paibantotal.value) + parseFloat(baibantotal.value)
				+ parseFloat(chunhuatotal.value)
				+ parseFloat(jiayangtotal.value);

	}
	function caculate(danjia, zonghe, danwei) {
		if (isNaN(danjia.value)) {
			alert("请输入数字!");
			danjia.value = 0;
			zonghe.value = 0;
			sum();
		} else {
			zonghe.value = danjia.value * danwei;
			sum();
		}
	}
</script>
</head>
<body>
	<p>测序反应组工作统计</p>
	<table width="640" border="1" cellpadding="0" cellspacing="0"
		align="center">
		<tr>
			<th width="129" scope="col">项目</th>
			<th width="109" scope="col">分值</th>
			<th width="125" scope="col">数量</th>
			<th width="267" scope="col">小计</th>
		</tr>
		<tr>
			<td>卫生</td>
			<td>扫地擦地30分</td>
			<td><input name="weishen" type="text" id="weishen" size="10"
				onkeyup="caculate(weishen,weishentotal,30)"> 次</td>
			<td><input name="weishentotal" type="text" id="weishentotal"
				size="10" style="border: none" readonly="readonly" value="0">
			</td>
		</tr>
		<tr>
			<td>装枪头</td>
			<td>2分/盒</td>
			<td><input name="zhuangqiangtou" type="text" id="zhuangqiangtou"
				size="10" onkeyup="caculate(zhuangqiangtou,zhuangqiangtoutotal,2)">
				盒</td>
			<td><input name="zhuangqiangtoutotal" type="text"
				id="zhuangqiangtoutotal" size="10" style="border: none"
				readonly="readonly" value="0"></td>
		</tr>
		<tr>
			<td>摆样品</td>
			<td>0.2分/个</td>
			<td><input name="baiyangpin" type="text" id="baiyangpin"
				size="10" onkeyup="caculate(baiyangpin,baiyangpintotal,0.2)">
				个</td>
			<td><input name="baiyangpintotal" type="text"
				id="baiyangpintotal" size="10" style="border: none"
				readonly="readonly" value="0"></td>
		</tr>
		<tr>
			<td>引物稀释找引物</td>
			<td>1分/条</td>
			<td><input name="yinwuxishi" type="text" id="yinwuxishi"
				size="10" onkeyup="caculate(yinwuxishi,yinwuxishitotal,1)">
				条</td>
			<td><input name="yinwuxishitotal" type="text"
				id="yinwuxishitotal" size="10" style="border: none"
				readonly="readonly" value="0"></td>
		</tr>
		<tr>
			<td>引物登记</td>
			<td>1分/条</td>
			<td><input name="yinwudengji" type="text" id="yinwudengji"
				size="10" onkeyup="caculate(yinwudengji,yinwudengjitotal,1)">
				条</td>
			<td><input name="yinwudengjitotal" type="text"
				id="yinwudengjitotal" size="10" style="border: none"
				readonly="readonly" value="0"></td>
		</tr>
		<tr>
			<td>排版</td>
			<td>10分/版</td>
			<td><input name="paiban" type="text" id="paiban" size="10"
				onkeyup="caculate(paiban,paibantotal,10)"> 版</td>
			<td><input name="paibantotal" type="text" id="paibantotal"
				size="10" style="border: none" readonly="readonly" value="0">
			</td>
		</tr>
		<tr>
			<td>摆版</td>
			<td>15分/版</td>
			<td><input name="baiban" type="text" id="baiban" size="10"
				onkeyup="caculate(baiban,baibantotal,15)"> 版</td>
			<td><input name="baibantotal" type="text" id="baibantotal"
				size="10" style="border: none" readonly="readonly" value="0">
			</td>
		</tr>
		<tr>
			<td>纯化</td>
			<td>25分/版</td>
			<td><input name="chunhua" type="text" id="chunhua" size="10"
				onkeyup="caculate(chunhua,chunhuatotal,25)"> 版</td>
			<td><input name="chunhuatotal" type="text" id="chunhuatotal"
				size="10" style="border: none" readonly="readonly" value="0">
			</td>
		</tr>
		<tr>
			<td>加样</td>
			<td>76.8分/版</td>
			<td><input name="jiayang" type="text" id="jiayang" size="10"
				onkeyup="caculate(jiayang,jiayangtotal,76.8)"> 版</td>
			<td><input name="jiayangtotal" type="text" id="jiayangtotal"
				size="10" style="border: none" readonly="readonly" value="0">
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>总计：</td>
			<td><input name="total" type="text" id="total" size="10"
				style="border: none" readonly="readonly" value="0"></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>时间：</td>
			<td><%out.print(date); %></td>
			<td>登记人:</td>
			<td><%out.print(ub.getUserName()+" , "+ub.getre_ID()); %></td>
		</tr>
	</table>
</body>
</html>