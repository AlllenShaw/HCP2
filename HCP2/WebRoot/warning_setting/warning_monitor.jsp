<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>

</head>

<body>
	<form action="doctor/seo.do" method="post">
		<section id="conter"> <section id="help-left"> <details
			class="menu" open> <summary>预警监控</summary> <img
			align="middle" src="picture/seo_logo.jpg"></img>

		<div align="center">
			<select id="selector1" name="selector1" class="size1"
				style="width:100px">
				<option value="1">血糖表</option>
				<option value="2">血压表</option>
				<option value="3">血氧表</option>
			</select> <select id="selector2" name="selector2" class="size1"
				style="width:100px">
				<option value="4">所有病人</option>
			</select>
			<input type="hidden" name="type" value="1" />
			<input id="search" class="fb" type="submit" value="确定">
		</div>
		</details>
	</form>
</body>

<script src="seo/seo.js"></script>

</html>
