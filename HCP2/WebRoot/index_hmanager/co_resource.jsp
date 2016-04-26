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
	.fb{margin-left:530px;}
	.tip td{height:50px;width:80px;font-size:18px;}
	.tip input{height:35px;width:180px;font: 18px Arial, Helvetica;}
	.tip select{height:40px;width:180px;font: 18px Arial, Helvetica;}	
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open>
		 <summary>添加合作医院</summary>
		 <img style="margin-left:200px;margin-top:20px" src="picture/cooperation.jpg"></img>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<div align="center">
		<table class="tip">
				<tr>
					<td>当前医院</td>
					<td><input readonly="readonly" value="有一家医院"><td>
					<td>合作医院</td>
					<td>
						<select>
							<option value="1">有一家医院</option>
							<option value="2">另一家医院</option>
						</select>
					</td>
				</tr>
		</table>
		<button class="fb">添加</button>
	</div>
	</details>
	
	<details class="menu" open>
		 <summary>共享权限管理</summary>
	<div align="center">
		<table class="tip">
				<tr>
					<td>当前医院</td>
					<td><input readonly="readonly" value="有一家医院"><td>
					<td>选择医院</td>
					<td>
						<select>
							<option value="1">有一家医院</option>
							<option value="2">另一家医院</option>
						</select>
					</td>
				</tr>
		</table>
		<button class="fb">查询</button>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		<table class="tip">
			<tr><td colspan="4">共享权限</td></tr>
			<tr>
				<td>病历<td>
				<td><input type="checkbox" name="case_history" /></td>
				<td>血糖<td>
				<td><input type="checkbox" name="case_history" /></td>
			</tr>
			<tr>
				<td>血氧<td>
				<td><input type="checkbox" name="case_history" /></td>
				<td>心电<td>
				<td><input type="checkbox" name="case_history" /></td>
			</tr>
		</table>
		<button class="fb">修改</button>
	</div>
	</details>
	
	
	</section>
	</section>
</body>
</html>
