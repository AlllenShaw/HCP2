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
<link rel="stylesheet" type="text/css" href="css/record_style.css">

<style>
.fb {
	margin-top: 20px;
	margin-left: 550px;
}
</style>

</head>

<style>
.bordered {
	width: 650px;
	margin-top: 20px;
	margin-left: 1px;
	margin-raight: 1px;
}

.bordered input {
	width: 110px;
	height: 35px;
}
</style>


<body>
	<form action="hospitalAdmin/setMeasureTime.do" method="post">
		<div>
			<div class="formtitle">${patient.realname}的测试设置</div>
			

			<table class="bordered">
				<thead>
					<tr>
						<th colspan="5" style="text-align:center">测试设置</th>
					</tr>
				</thead>
				<tr>
					<td>项目</td>
					<td>血糖测试次数</td>
					<td>血压测试天数</td>
					<td>血氧测试天数</td>
				</tr>
				<tr>
					<td>数据设置</td>
					<td><input type="text" name="bg_remain_time"></td>
					<td><input type="text" name="bp_remain_time"></td>
					<td><input type="text" name="spo_remain_time"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="patient_id" value="${patient.id}" /> 
		<input type="submit" class="fb" value="设置"/>
	</form>
</body>
</html>
