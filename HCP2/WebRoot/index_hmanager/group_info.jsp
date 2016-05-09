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
<link rel="stylesheet" type="text/css" href="css/form_style.css">

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
	width: 140px;
	font: 18px Arial, Helvetica;
}

.tip select {
	height: 40px;
	width: 180px;
	font: 18px Arial, Helvetica;
}

.tip textarea {
	height: 100px;
	width: 400px;
}

#help-left {
	width: 650px;
	font-family: 'microsoft YaHei';
	float: left
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>用户组信息</summary>
	<div>
		<table class="tip">
			<tr>
				<td>所属医院</td>
				<td><input type="text" value="${group.hospital.name}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>组名称</td>
				<td><input type="text" value="${group.name}"
					readonly="readonly" /></td>
				<td>组ID</td>
				<td><input type="text" value="${group.id}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>用户组描述</td>
			</tr>
			<tr>
				<td colspan="4" rowspan="2"><textarea>${group.description}</textarea></td>
			</tr>
		</table>
	</div>

	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

	<div>
		<table class="bordered">
			<tr>
				<td colspan="4" align="center">组成员列表</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>用户名</td>
				<td>姓名</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${doctorGroups}" var="item">
				<tr>
					<td>${item.doctor.id}</td>
					<td>${item.doctor.username}</td>
					<td>${item.doctor.realname}</td>
					<td><a href="hospitalAdmin/deleteDoctorFromGroup.do?doctor_id=${item.doctor.id}&group_id=${item.doctor.hospital.id}">移除此成员</a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${ patientGroups}" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.patient.username}</td>
					<td>${item.patient.realname}</td>
					<td><a href="hospitalAdmin/deletePatientFromGroup.do?patient_id=${item.patient.id}&group_id=${item.patient.hospital.id}">移除此成员</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	</details> </section> </section>
</body>
</html>
