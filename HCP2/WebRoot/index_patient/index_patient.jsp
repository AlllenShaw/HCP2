<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>病人主界面</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" type="text/css" href="css/folding_menu.css">

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
						<li><a
							href="patient/updatePatientInfo.do?patient_id=${patient.id }" target="_black">修改信息</a></li>
						<li><a href="#" title="">注销</a></li>
					</ul>
				</div>
			</div>
			<hr
				style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />
			<span class="tip">${patient.hospital.name}协同诊治平台</span> <img
				style="margin-left:5px" src="picture/slider_photo1.png" width="965"
				height="150" alt="" />


			<div class="center_content">
				<div class="home_section_left">
					<section id="conter"> <section id="help-left">
					<details class="menu" open> <summary>首页</summary>
					<ul>
						<li><a href="index_doctor/index.jsp" target="mainframe">首页</a></li>
					</ul>
					</details> <details class="menu" open> <summary>个人信息</summary>
					<ul>
						<li><a href="patient/seo.do?selector1=1" target="mainframe">血糖</a></li>
						<li><a href="patient/seo.do?selector1=2" target="mainframe">血压</a></li>
						<li><a href="patient/seo.do?selector1=3" target="mainframe">血氧</a></li>
						<li><a href="patient/seo.do?selector1=10" target="mainframe">病历</a></li>
						<li><a href="patient/seo.do?selector1=9" target="mainframe">用药记录</a></li>
					</ul>

					</details> <details class="menu" open> <summary>曲线图</summary>
					<ul>
						<li><a href="patient/seo.do?selector1=5" target="mainframe">血糖</a></li>
						<li><a href="patient/seo.do?selector1=6" target="mainframe">血压</a></li>
						<li><a href="patient/seo.do?selector1=7" target="mainframe">血氧</a></li>
						<li><a href="http://120.76.45.51:8080/dhmap/" target="_blank">心电</a></li>
					</ul>
					</details>
				</div>
				<iframe name="mainframe" src="index_doctor/index.jsp"
					onload="this.height=this.contentWindow.document.documentElement.scrollHeight">
				</iframe>

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
