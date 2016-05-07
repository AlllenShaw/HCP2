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
	<form action="doctor/setWarning.do" method="post">
		<div>
			<H2>${patient.realname}的预警值设置</H2>
			<table class="bordered">
				<thead>
					<tr>
						<th colspan="5" style="text-align:center">血糖预警值设置</th>
					</tr>
				</thead>
				<tr>
					<td>项目</td>
					<td>空腹血糖下限</td>
					<td>空腹血糖上限</td>
					<td>餐后血糖下限</td>
					<td>餐后血糖上限</td>
				</tr>
				<tr>
					<td>血糖值(mmol/L)</td>
					<td><input type="text" name="bloodGlucoseMax"></td>
					<td><input type="text" name="bloodGlucoseMin"></td>
					<td></td>
					<td></td>
				</tr>
			</table>


			<table class="bordered">
				<thead>
					<tr>
						<th colspan="5" style="text-align:center">血氧预警值设置</th>
					</tr>
				</thead>
				<tr>
					<td>项目</td>
					<td>脉率下限</td>
					<td>脉率上限</td>
					<td>血氧饱和度下限</td>
					<td>血氧饱和度上限</td>
				</tr>
				<tr>
					<td>数据设置</td>
					<td><input type="text" name="pulseRateMin" ></td>
					<td><input type="text" name="pulseRateMax"></td>
					<td><input type="text" name="spo2maxMin"></td>
					<td><input type="text" name="spo2maxMax"></td>
				</tr>
			</table>


			<table class="bordered">
				<thead>
					<tr>
						<th colspan="5" style="text-align:center">血压预警值设置</th>
					</tr>
				</thead>
				<tr>
					<td>项目</td>
					<td>上限</td>
					<td>下限</td>
				</tr>
				<tr>
					<td>收缩压</td>
					<td><input type="text" name="systolicPressureMax"></td>
					<td><input type="text" name="systolicPressureMin"></td>
				</tr>
				<tr>
					<td>舒张压</td>
					<td><input type="text" name="diastolicPressureMax"></td>
					<td><input type="text" name="diastolicPressureMin"></td>
				</tr>
				<tr>
					<td>心率</td>
					<td><input type="text" name="heartRateMax"></td>
					<td><input type="text" name="heartRateMin"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="patient_id" value="${patient.id}" /> 
		<input type="submit" class="fb" value="确定"/>
	</form>
</body>
</html>
