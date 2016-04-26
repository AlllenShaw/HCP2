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
<script src="js/about.js" type="text/javascript"></script>

<style>
.center_content  iframe{
	width:470px;
	height:470px;
	border:1px;
	scroll:auto;
	border-left:1px solid #ccc;
	float:right
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
				<iframe name="content" src="login/login.jsp"> </iframe>
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
</body>
</html>
