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
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />

<style>
.center_content  iframe{
	width:950px;
	border:1px;
	scroll:auto;
	border-left:0px;
	float:left
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
						<li><a href="#l" title="">登录</a></li>
						<li><a href="#" title="">设置</a></li>
						<li><a href="#" title="">关于</a></li>
					</ul>
				</div>
			</div>
			<hr style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />
			<div class="center_content">
				<iframe name="content" src=<%=request.getParameter("route") %>
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight"> </iframe>
			</div>


			<div class="footer">
				<div class="copyright">
					<a href="#" target="_blank">汕头大学</a> | <a href="#" target="_blank">百度文科</a>
				</div>

				<div class="footer_links">
					<a class="current" href="#" title="">首页</a> <a href="#" title="">关于</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
