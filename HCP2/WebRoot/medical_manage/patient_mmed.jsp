<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<link rel="stylesheet" type="text/css" href="css/record_style.css">
<link rel="stylesheet" type="text/css" href="css/form_style.css">

<script type="text/javascript">
	function page() {
		return document.getElementById(page);
	}
</script>
</head>
<style>
#help-left {
	width: 680px;
	font-family: 'microsoft YaHei';
	float: left
}
</style>


<body>
	<input type="hidden" name="page" id="page" value="1" />

	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>医嘱</summary>
	<div class="box">
		<div>
			<table class="tip">
				<tr>
					<td>姓名</td>
					<td><input readonly="readonly" value="${name }" />
					<td>
					<td>ID</td>
					<td><input readonly="readonly" value="${id }" /></td>
				</tr>
			</table>
		</div>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

		<br />
		<div class="question">病情描述</div>
		<span>补充:</span>
		<div class="test_box" contenteditable="false" id="order">
			${emrs[0].illnessStateDesc }
			<br />
		</div>
		<br />
		<table class="bordered" id="med_form">
			<thead>
				<tr>
					<th>类型</th>
					<th>药物ID</th>
					<th>药物名称</th>
					<th>服用方式</th>
					<th>服用量</th>
				</tr>
			</thead>
			<c:forEach items="${set}" var="item">
				<tr>
					<td>${item.medicine.adaptationDisease}</td>
					<td>${item.medicine.id }</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>每次${item.takingMedicineNumberEachtime}${item.medicineUnit.medicineUnit}
						每天${item.takingMedicineTimesEachday}次</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <br />
		<div class="question">诊断和建议</div>
		<span>补充:</span>
		<div class="test_box" contenteditable="false" id="dac">
			${emrs[0].diagnosisSuggestion }
		</div>
		<br />

		<div class="question">
			医嘱时间 <input class="fbt" style="height:30px;" readonly="readonly"
				value="${emrs[0].createTime }" />
		</div>
		<br />

		<div>
			<button class="fb" style="margin-left:20px;">上一页</button>
			<button class="fb" style="margin-left:350px;">下一页</button>
		</div>
		<br />
	</div>
	</details> </section> </section>

	<script src="js/patient_form.js"></script>
</body>


</html>
