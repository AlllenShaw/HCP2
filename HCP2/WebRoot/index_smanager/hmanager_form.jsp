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


<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<body>
	<div class="formtitle">医院管理员列表</div>
	<table class="bordered" id="hmanager_form">
		<thead>
			<tr>
				<th>医院管理员ID</th>
				<th>医院管理员姓名</th>
				<th>医院管理员联系方式</th>
				<th>删除</th>
			</tr>
		</thead>
			<c:forEach items="${hospitalAdministrators }" var="item">
				<tr>
					<td>${item.id }</td>
					<td>${item.realname }</td>
					<td>${item.tele }</td>
					<td><a href="superAdmin/removeHospitalAdmin.do?hospitalAdmin_id=${item.id }">删除</a></td>
				</tr>
			</c:forEach>
		
	</table>
	<br />
	<div class="paging">
	</div>

	<script src="js/all_form.js"></script>
</body>
</html>
