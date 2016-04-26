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
						<li><a href="registered/registered.jsp?route=registered/resetinfo_patient.jsp" title="" target="_black">修改信息</a></li>
						<li><a href="#" title="">注销</a></li>
					</ul>
				</div>
			</div>
			<hr
				style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />
			<span class="tip">XX医院协同诊治平台</span>
			<img style="margin-left:5px" src="picture/slider_photo1.png"
				width="965" height="150" alt="" />


			<div class="center_content">
				<div class="home_section_left">
					<section id="conter"> <section id="help-left">
					<details class="menu" open> <summary>首页</summary>
					<ul>
						<li><a href="index_doctor/index.jsp" target="mainframe">首页</a></li>
					</ul>
					</details> <details class="menu" open> <summary>个人信息</summary>
					<ul>
						<li><a href="index_patient/bg_patient.jsp" target="mainframe">血糖</a></li>
						<li><a href="index_patient/bp_patient.jsp" target="mainframe">血压</a></li>
						<li><a href="index_patient/spo_patient.jsp" target="mainframe">血氧</a></li>
						<li><a href="">心电</a></li>
						<li><a href="index_patient/case_history.jsp" target="mainframe">病历</a></li>
						<li><a href="index_patient/med_record.jsp" target="mainframe">用药记录</a></li>
					</ul>
					
					</details><details class="menu" open> <summary>曲线图</summary>
					<ul>
						<li><a href="chart/bg_ichart.jsp" target="mainframe">血糖</a></li>
						<li><a href="chart/bp_ichart.jsp" target="mainframe">血压</a></li>
						<li><a href="chart/spo_ichart.jsp" target="mainframe">血氧</a></li>
						<li><a href="">心电</a></li>
					</ul>
					</details> 
					<details class="menu" open> <summary>访谈记录</summary>
					<ul>
						<li><a href="interview_record/patient_record.jsp" target="mainframe">访谈记录</a></li>
					</ul>
					</details>
				</div>
				<iframe name="mainframe" src="index_doctor/index.jsp"
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight"> </iframe>

			</div>


			<div class="footer">
				<div class="copyright">
					<a href="#" target="_blank">汕头大学</a> | <a href="#" target="_blank">百度文科</a>
				</div>

				<div class="footer_links">
					<a class="current" href="#" title="">首页</a> 
				</div>
			</div>

		</div>
	</div>
</body>
</html>
