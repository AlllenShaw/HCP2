<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	margin-left: 450px;
}

.tip td {
	height: 50px;
	width: 50px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 140px;
	font: 18px 微软雅黑;
}

.tip select {
	height: 40px;
	width: 140px;
	font: 18px 微软雅黑;
}

#help-left {
	width: 650px;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>添加合作医院</summary>
	<div align="center">
		<form action="hospitalAdmin/addCoHospital.do" method="post">
			<table class="tip">
				<tr>
					<td>当前医院</td>
					<td>${hospital.name }
					<td>
					<td>合作医院</td>
					<td><select name="hospital_id">
							<c:forEach items="${allHospitals }" var="item">
								<option value="${item.id }">${item.name}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="submit" class="fb" value="添加" />
		</form>
	</div>
	</details> <details class="menu" open> <summary>当前合作医院</summary>

	<div style="margin-top:30px;margin-bottom:10px;">
		<table class="bordered">
			<thead>
				<tr>
					<th>医院ID</th>
					<th>医院名称</th>
					<th>等级</th>
					<th>简介</th>
					<th>移除合作医院</th>
				</tr>
			</thead>
			<c:forEach items="${coHospitals }" var="item">
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.level }</td>
					<td>${item.introduction }</td>
					<td><a href="hospitalAdmin/deleteCoHospital.do?hospital_id=${item.id }">删除</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

	</details> </section> </section>
</body>
</html>
