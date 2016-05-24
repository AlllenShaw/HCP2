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
<link rel="stylesheet" type="text/css" href="css/record_style.css">

</head>

<style>
.fb {
	margin-left: 530px;
}

.tip td {
	height: 50px;
	width: 80px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 230px;
	margin-right:10px;
	font-size: 18px;
}

.tip select {
	height: 40px;
	width: 180px;
	font-size: 18px;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>添加医院</summary> <img
		style="margin-left:200px;margin-top:20px"
		src="picture/cooperation.jpg"></img>
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<div align="center">
		<form action="superAdmin/addHospital.do" method="post">
			<table class="tip">
				<tr>
					<td>医院名称</td>
					<td><input type="text" name="name"/></td>
					<td>医院等级</td>
					<td><input type="text" name="level"/></td>
				</tr>
				<tr>
					<td>医院地址</td>
				</tr>
				<tr>
					
					<td colspan="5"><textarea type="text" name="address" class="htextareatype1"></textarea></td>
				</tr>
				<tr>
					<td>医院简介</td>
				</tr>
				<tr>
					
					<td colspan="5"><textarea type="text" name="introduction" class="htextareatype1"></textarea></td>
				</tr>
			</table>
			<input type="submit" class="fb" value="添加" />
		</form>
	</div>
	</details> </section> </section>
</body>
</html>
