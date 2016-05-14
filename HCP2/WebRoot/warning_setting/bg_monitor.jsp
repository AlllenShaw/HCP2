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
	<h2>血糖测试值监控</h2>
	<table class="bordered" id="bg_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>血糖值</th>
				<th>测量时间</th>
			</tr>
		</thead>
			<c:forEach items="${gluPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.patient.realname}</td>
					<td>${item.bloodGlucose }</td>
					<td>${item.measureTime }</td>
				</tr>
			</c:forEach>
			<!-- 
			<c:forEach items="${gluPatientInfos }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.bloodGlucoseMax}</td>
					<td>${item.bloodGlucoseMin }</td>
					<td>${item.remainTime }</td>
				</tr>
			</c:forEach>
			 -->
	</table>
	<br />


	<script src="js/all_form.js"></script>
</body>
</html>
