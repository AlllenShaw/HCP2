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
	<h2>血氧测试值监控</h2>
	<table class="bordered" id="spo_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>测试时间</th>
				<th>姓名</th>
				<th>脉率</th>
				<th>血氧饱和度</th>
			</tr>
		</thead>
			<c:forEach items="${boPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.measureTime }</td>
					<td>${item.patient.realname}</td>
					<td>${item.pulseRate }</td>
					<td>${item.spo2 }</td>
				</tr>
			</c:forEach>
	</table>
	<br />
	<div class="paging">
		
	</div>



	<script src="js/all_form.js"></script>
</body>
</html>
