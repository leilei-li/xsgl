<%@page import="com.model.userBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
userBean ub=(userBean)request.getSession().getAttribute("userBean");
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
String date = formatter.format(currentTime); //将日期时间格式化
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天一辉远</title>
<link type="text/css" rel="stylesheet" href="css/style_main.css" />
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="JS/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">天一辉远管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><%=request.getSession().getAttribute("quanxian")%>,<%=request.getSession().getAttribute("userName")%></li>
			<li><a href="user_password_modify.jsp" target="right2">修改密码</a></li>
			<li><a href="index.jsp" >退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
    <div></div>
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M9"><span></span>引物管理</h4>
          <div class="list-item none">
            <a href="yinwuOP?action=init" target="right2">新增引物</a>
            <a href="yinwuOP?action=searchYinwu&new_num=&old_num=&start_date=20160901&end_date=20170901&keshi=&danwei=&cus_name=&name="  target="right2">查找引物</a>
            <a href="upload_yinwu.jsp" target="right2">引物导入</a>
            <a href="upload_kaoqing.jsp"  target="right2" >考勤导入</a>
            <a href="kaoqingOP?action=search&date=<%out.print(date); %>" target="right2">查看考勤</a>
            <a href="jixiao_fanying.jsp"  target="right2" >反应组绩效</a>
          </div>
        </li>
      <li>
          <h4 class="M1"><span></span>人员管理</h4>
          <div class="list-item none">
            <a href="cus_new_p" target="right2">新增客户</a>
            <a href='cus__dan_searchServlet?text=&select=客户号' target="right2">显示全部客户</a>
            <a href='upload_cus.jsp' target="right2">批量导入客户</a>
            <a href="sales_new.jsp" target="right2">新增员工</a>
            <a href="sales__dan_searchServlet?text=&select=员工号"  target="right2">显示全部员工</a>
            <a href="upload_sales.jsp" target="right2">批量导入员工</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>订单管理</h4>
          <div class="list-item none">
            <a href="dingdan_new_p" target="right2">新增订单</a>
            <a href="dingdan__dan_searchServlet?text=&re_ID=<%=ub.getre_ID() %>"  target="right2">显示全部订单</a>
            <a href="upload_dingdan.jsp" target="right2">批量导入订单</a>
          </div>
        </li>
				<li>
          <h4 class="M3"><span></span>发票管理</h4>
          <div class="list-item none">
            <a href="fapiao_new.jsp" target="right2">新增发票</a>
            <a href="fapiao__dan_searchServlet?fapiao_ID=&sales_name=&cus_name=&fapiaotaitou=&re_ID=<%=ub.getre_ID() %>"  target="right2">显示全部发票</a>
            <a href="upload_fapiao.jsp" target="right2">批量导入发票</a>
          </div>
        </li>
				<li>
          <h4  class="M4"><span></span>对账单管理</h4>
          <div class="list-item none">
            <a href="duizhang_new_search1"  target="right2">新增对账单</a>
            <a href="duizhang_search_p"  target="right2">显示全部对账单</a>
            <a href="upload_duizhang.jsp"  target="right2">批量导入对账单</a>
          </div>
        </li>
				<li>
          <h4  class="M5"><span></span>团队管理</h4>
          <div class="list-item none">
            <a href="team_new.jsp" target="right2">新增团队</a>
            <a href="team__dan_searchServlet?team_ID=&team_name=" target="right2">显示全部团队</a>
          </div>
        </li>
				<li>
          <h4   class="M6"><span></span>地区管理</h4>
          <div class="list-item none">
            <a href="keshi_new.jsp" target="right2"></>新增科室</a>
            <a href="keshi_dan_search?keshi_name=&danwei_name=" target="right2">增删查询科室</a>
            <a href="danwei_new.jsp" target="right2">新增单位</a>
			<a href="danwei_dan_search?danwei_name=" target="right2">增删查询单位</a>
          </div>
        </li>
				<li>
          <h4  class="M7"><span></span>后勤管理</h4>
          <div class="list-item none">
            <a href="price_new.jsp" target="right2">新增定价</a>
            <a href="price__dan_search?name=&class_name=&action="  target="right2">查看修改定价</a>
            <a href="price__dan_search?name=&class_name=&action=daochu"  target="right2">导出定价</a>
            <a href="gift_new.jsp" target="right2">新增礼物</a>
            <a href="gift__dan_searchServlet?gift_name=&type=1"  target="right2">查看礼物库存</a>
            <a href="gift__dan_searchServlet?gift_name=&type=1"  target="right2">修改礼物库存</a>
          </div>
        </li>
				<li>
          <h4   class="M8"><span></span>事件登记</h4>
          <div class="list-item none">
            <a href="shoukuan_new.jsp" target="right2">收款登记</a>
            <a href="visit_new.jsp" target="right2">添加拜访记录</a>
            <a href="visit__dan_searchServlet?text=<%=ub.getre_ID() %>&select=员工号" target="right2">查找拜访记录</a>
            <a href="shouzhi_search.jsp"  target="right2">收支统计</a>
            <a href="gongzi_tongji?year=2016&month=三月&sales_ID="  target="right2">工资明细</a>
          </div>
        </li>
        <li>
          <h4   class="M10"><span></span>功能测试</h4>
          <div class="list-item none">
            <a href="22222.jsp" target="right2">导出测试</a>
            <a href="upload.jsp"  target="right2">导入测试</a>
            <a href="gift__dan_searchServlet?gift_name=&type=2"  target="right2" >分页测试</a>
            <a href="gongzi_danren" target="right2">兼容测试</a>
          </div>
        </li>
        
  </ul>
		</div>
		<div class="m-right">
		
			<div class="main" >
			<iframe src="welcome.jsp"  name="right2" frameborder="0" class="main"> </iframe>	
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p align=right >请联系我：lileilei258@foxmail.com</p></div>
<script>navList(12);</script>
</body>
</html>
