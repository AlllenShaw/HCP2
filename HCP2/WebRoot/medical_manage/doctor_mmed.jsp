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
#help-left {
	width: 680px;
	font-family: 'microsoft YaHei';
	float: left
}
</style>


<body>

	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>医嘱</summary>
	<form action="doctor/addEmr.do" method="post">
		<div class="box">
			<div>
				<table class="tip">
					<tr>
						<td>姓名</td>
						<td><input readonly="readonly" value="${patient.realname }" />
						<td>
						<td>ID</td>
						<td><input readonly="readonly" value="${patient.id }" /></td>
					</tr>
				</table>
			</div>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

			<br />
			<div class="question">病情描述</div>
			<span>补充:</span><br/>
			<div style="margin-left:15px;">
				<textarea name="illnessStateDesc"
					class="test_box"></textarea>
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
					
			</table>
			<br />

			<button class="fb" style="margin-left:450px;" onclick="add_med()">添加</button>

			<br />
			<div class="question">诊断和建议</div>
			<span>补充:</span><br/>
			<div style="margin-left:15px;">
			<textarea class="test_box" id="dac"></textarea>
			</div>
			<br />

			<div class="question">
				医嘱时间 <input class="fbt" type="date" />
			</div>
			<br />

			<button class="fb" style="margin-left:450px;">提交</button>

		</div>
	</form>
	</details> </section> </section>

	<script src="js/patient_form.js"></script>
</body>


</html>
