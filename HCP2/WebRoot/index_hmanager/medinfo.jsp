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
	width: 230px;
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
				<td colspan="4"><input readonly="readonly" value="${medicine.adaptationDisease }" style="width:550px;"/></td>
			</tr>
			<tr>
				<td>不良反应</td>
				<td colspan="4"><input readonly="readonly" value="${medicine.adverseReaction }" style="width:550px;"/></td>
			</tr>
			<tr>
				<td>服用方式</td>
				<td><input readonly="readonly" value="${medicine.usage }"/></td>
			</tr>
			<tr>
				<td>用量</td>
				<td colspan="4"><input readonly="readonly" value="${medicine.dosage }" style="width:550px;"/></td>
			</tr>
			<tr>
				<td>药物禁忌</td>
				<td colspan="4"><input readonly="readonly" value="${medicine.taboo }" style="width:550px;"/></td>
			</tr>
			<tr>
				<td>注意事项</td>
			</tr>
			<tr>
				<td colspan="5"><textarea readonly="readonly" class="htextareatype1">${medicine.attentions }</textarea></td>
			</tr>
		</table>
	</div>
	</details> </section> </section>
</body>
</html>
