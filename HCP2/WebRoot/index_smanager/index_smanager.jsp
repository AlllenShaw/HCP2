<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<title>系统管理主界面</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" type="text/css" href="css/folding_menu.css"/>

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
						<li><a href="#l" title="">首页</a></li>
						<li><a href="#" title="">注销</a></li>
					</ul>
				</div>
			</div>



			<hr
				style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />
			<img style="margin-left:5px" src="picture/slider_photo1.png"
				width="965" height="150" alt="" />


			<div class="center_content">
				<div class="home_section_left">
					<section id="conter"> <section id="help-left">
					<details class="menu" open> <summary>首页</summary>
					<ul>
						<li><a href="#">首页</a></li>
					</ul>
					</details> <details class="menu" open> <summary>资源管理</summary>
					<ul>
						<li><a href="superAdmin/hospitalManage.do" target="mainframe">医院管理</a></li>
						<li><a href="superAdmin/HospitalAdminManage.do"
							target="mainframe">医院管理员管理</a></li>
					</ul>
					</details> <details class="menu" open> <summary>APP管理</summary>
					<ul>
						<li><a href="index_smanager/app_upload.jsp"  target="mainframe">APP上传</a></li>
					</ul>
					</details>
				</div>
				<iframe name="mainframe" src="index_doctor/index.jsp" scrolling="no"
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight"> </iframe>

			</div>


			<div class="footer">
				<div class="copyright">
					<a href="http://www.stu.edu.cn/" target="_blank">汕头大学</a> | <a href="http://www.baidu.com/" target="_blank">百度</a>
				</div>

				<div class="footer_links">
					<a class="current" href="#" title="">首页</a> <a href="#" onclick="window.close()">退出</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
