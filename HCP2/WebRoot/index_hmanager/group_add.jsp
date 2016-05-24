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
	width: 300px;
	font-size: 18px;
}

.tip select {
	height: 40px;
	width: 180px;
	font-size: 18px;
}

.tip textarea {
	height: 100px;
	width: 500px;
	font-size: 18px;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>用户组信息</summary>

	<form action="hospitalAdmin/addUserGroup.do" method="post">
		<div>
			<table class="tip">
				<tr>
					<td>组名称</td>
					<td><input type="text" name="groupName" />
					<td>
				</tr>
				<tr>
					<td>组描述</td>
				</tr>
				<tr>
					<td colspan="4" rowspan="2"><textarea name="description"></textarea></td>
				</tr>
			</table>
			<input type="hidden" name="hospital_id" value="${hospital.id }">
			<input class="fb" type="submit" value="添加" />
		</div>
	</form>
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

	</details> </section> </section>
</body>
</html>
