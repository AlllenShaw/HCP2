<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>互联医疗资源协同诊治平台</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" type="text/css" href="css/record_style.css">
<link rel="stylesheet" href="login/fort.css">
<link rel="stylesheet" href="login/style.css">
<script src="js/about.js" type="text/javascript"></script>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>

<style>
.frame{
	width:470px;
	height:470px;
	scroll:auto;
	border-left:1px solid #ccc;
	float:right;
}
.top-banner {
	background-color: #333;
}
.nav {
	margin-bottom: 30px;
}
.nav li.current a{
	background-color: #009DFF;
	color: #fff;
	padding: 10px;
}
.nav a {
	margin: 5px;	
	color: #333;
	text-decoration: none;
	font-size:18px;
	font-family: 微软雅黑;
}

.nav input
{
	width:335px;
	margin-top: 5px;
}
.button-panel .button
{
	width:335px;
}

</style>

</head>

<body>
	<div id="wrap">
		<div class="top_corner"></div>
		<div id="main_container">
			<div id="header">
				<div id="logo">
					<img src="picture/logo1.png"></img>
				</div>

				<div id="menu">
					<ul>
						<li><a href="#" title="">首页</a></li>
						<li><a href="javascript:void(0)" onclick="show('light')">关于</a></li>
						<li><a href="registered/registered.jsp?route=registered/request_pw.jsp">找回密码</a></li>
					</ul>
				</div>
			</div>


			<hr
				style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />

			
				<div class="center_content">
				<img style="margin-left:18px;margin-top:80px;" src="picture/main_logo.jpg"></img>
						
						<div class="frame">
						<div class="form-wrapper">
							<form name="login" action="user/login.do" method="post">
								
								<div class="nav">
									<ul>
										<li id="li1"><a id="a1">医生</a></li>
										<li id="li2" class="current"><a id="a2">病人</a></li>
										<li id="li3"><a id="a3">医院管理员</a></li>
										<li id="li4"><a id="a4">系统管理员</a></li>
									</ul>
									<div class="form-item">
										<input style="margin-top:15px;" type="text" name="username" id="username" required="required" placeholder="用户名" autocomplete="off">
									</div>
									<div class="form-item">
										<input type="password" name="password" id="password" required="required" placeholder="密码" autocomplete="off">
									</div>
									<div class="button-panel">
										<input id="login" type="submit" class="button"  value="登录">
										<input id="registered" type="button" class="button"  value="注册">
									</div>
									<input id="usertype" name="usertype"
									 type="text" style="display:none;" />
								
							</form>
						</div>
					</div>
				</div>


			<div class="footer">
				<div class="copyright">
					<a href="http://www.stu.edu.cn/" target="_blank">汕头大学</a> | <a href="http://www.baidu.com/" target="_blank">百度</a>
				</div>

				<div class="footer_links">
					<a class="current" href="#" title="">首页</a> <a href="#" title="">关于</a>
				</div>
			</div>
			
			<div id="light" class="white_content">
				<div class="question" style="margin-left:30px;">
					关于互联医疗资源协同诊治平台
				<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
				</div>
				<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基于E-Health电子医疗资源共享协作诊治平台的子系统建设部分，
						主要针对平台PC端的展现使用环境而开展的分析、设计与构建。
						这些功能的分析与建设充实展现了平台共享的医疗数据资源的利益，利用先进的计算机及网络技术，
						使医生和患者以数字化、信息化的形式，充分共享相关医院的医疗数据资源和设备资源，
						从而最终达到提高医疗效率、降低医疗成本、提升医疗服务水平的目标
				</div>
				<br/>
				<br/>
				<button class="fb" style="height:30px;float:right;" onclick="hide('light')">关闭</button>
			</div>
			<div id="fade" class="black_overlay"></div>
			
		</div>
	</div>
	
	<script src="login/fort.js"></script>
</body>
</html>
