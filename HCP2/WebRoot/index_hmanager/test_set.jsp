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
	<form action="hospitalAdmin/getPatient.do" method="post">
		<section id="conter"> <section id="help-left"> <details
			class="menu" open> <summary>病人检测次数或时间设置</summary> <img
			align="middle" src="picture/seo_logo.jpg"></img>

		<div align="center">
			<select id="type" name="type" class="size1" style="width:100px">
				<option value="1">用户名</option>
				<option value="2">ID</option>
				<option value="3">身份证</option>
			</select> 
			<input type="text" id="patient" name="patientInfo" class="size1">
			<input id="search" class="fb" type="submit" value="查询">
		</div>
		</details>
	</form>
</body>

<script src="seo/seo.js"></script>

</html>
