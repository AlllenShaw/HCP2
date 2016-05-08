<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>操作失败</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
</head>



<body >

	<div id="wrap">
		<div class="top_corner"></div>
			<div id="main_container">
				
				<div class="center_content" align="center">
					<img align="middle" src="picture/failed.jpg"></img>
				</div>
				
				<div align="center" style="font-size:25px;font-family:微软雅黑;" id="showtime">
				        操作失败!
				</div>
				
			</div>
		</div>
</body>
</html>
