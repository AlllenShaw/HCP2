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
</head>
<style>
	#help-left{width:680px;font-family:'microsoft YaHei';float:left}
</style>


<body>
	<section id="conter"> 
	<section id="help-left"> 
	<details class="menu" open> <summary>访谈记录</summary>
		<div class="box">
			<div>
				<table class="tip">
					<tr>
						<td>姓名</td>
						<td><input readonly="readonly"><td>
						<td>ID</td>
						<td><input readonly="readonly"></td>
					</tr>
					<tr>
						<td>访谈次数</td>
						<td><input readonly="readonly"></td>
					</tr>
				</table>
			</div>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
			<div class="question">1.最近的情况如何？哪里不舒服？
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="true" id="question1"><br />
			</div>
			<div class="question">2.吃过什么药？吃后的效果如何，病情有没变化？
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="true" id="question2"><br />
			</div>
			<div class="question">3.应该注意的事项是什么？对什么过敏？平时的饮食习惯？
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="true" id="question3"><br />
			</div>
			<div class="question">4.医生开的服药信息处方
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="true" id="question3"><br />
			</div>
			<div class="question">5.医生诊断和建议
			</div>
			<span>补充:</span>
			<div class="test_box" contenteditable="true" id="question4"><br />
			</div>
			<div class="question">6.访谈时间
				<input class="fbt" type="date"/>
			</div>
			<br/>
			<div class="question">7.回访时间
				<input class="fbt" type="date"/>
			</div>
			<button class="fb">确定</button>
		</div>
	</details>
	</section>
	</section>
</body>


</html>
