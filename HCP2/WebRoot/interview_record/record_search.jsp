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


<link rel="stylesheet" type="text/css" href="css/info_style.css">

</head>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>访谈记录</summary> 
		<div style="margin-left:100px;margin-top:20px">
		<img src="picture/record_logo.jpg"></img>
		</div>
	<div align="center">
	<select class="size1" style="width:100px">
		<option value="1">姓名</option>
		<option value="2">ID</option>
		<option value="3">身份证</option>
		<option value="3">医保号</option>
	</select > 
	<input class="size1" type="text"> 
	<button class="fb" onclick="javascrtpt:window.location.href='interview_record/doctor_record.jsp'">确定</button>
	</div>
	</details>
</body>
</html>
