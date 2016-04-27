<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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


</head>
<style>
	#help-left{width:680px;font-family:'microsoft YaHei';float:left}
</style>


<body onload="check_med()">
	<section id="conter"> 
	<section id="help-left"> 
	<details class="menu" open> <summary>医嘱</summary>
		<div class="box">
			<div>
				<table class="tip">
					<tr>
						<td>姓名</td>
						<td><input readonly="readonly"><td>
						<td>ID</td>
						<td><input readonly="readonly"></td>
					</tr>
				</table>
			</div>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
			
			<br/>
			<div class="question">临时医嘱
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="false" id="order" readonly="readonly"><br />
			</div>
			<br/>
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
			<br/>
			
			<br/>
			<div class="question">诊断和建议
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="false" id="dac"><br />
			</div>
			<br/>
			
			<div class="question">医嘱时间
				<input class="fbt" style="height:30px;" readonly="readonly"/>
			</div>
			<br/>
			
			<div>
				<button class="fb" style="margin-left:20px;">上一页</button>
				<button class="fb" style="margin-left:350px;">下一页</button>
			</div>
			<br/>
		</div>
	</details>
	</section>
	</section>
	
	<script src="js/patient_form.js"></script>
</body>


</html>
