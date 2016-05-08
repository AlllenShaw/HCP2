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
	width: 180px;
	font: 18px Arial, Helvetica;
}

.tip select {
	height: 40px;
	width: 180px;
	font: 18px Arial, Helvetica;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>药物信息</summary>
	<div align="center">
		<table class="tip">
			<tr>
				<td>药物ID</td>
				<td><input readonly="readonly" value="${medicine.id }" /></td>
				<td>药物名称</td>
				<td><input  readonly="readonly" value="${medicine.name }" /></td>
			</tr>
			<tr>
				<td>适应症</td>
				<td><input readonly="readonly" value="${medicine.adaptationDisease }"/></td>
				<td>不良反应</td>
				<td><input readonly="readonly" value="${medicine.adverseReaction }"/></td>
			</tr>
			<tr>
				<td>用法</td>
				<td><input readonly="readonly" value="${medicine.usage }"/></td>
				<td>用量</td>
				<td><input readonly="readonly" value="${medicine.dosage }"/></td>
			</tr>
			<tr>
				<td>药物禁忌</td>
				<td><input readonly="readonly" value="${medicine.taboo }"/></td>
				<td>注意事项</td>
				<td><input readonly="readonly" value="${medicine.attentions }"/></td>
			</tr>
		</table>
		<button class="fb">修改</button>

	</div>
	</details> </section> </section>
</body>
</html>
