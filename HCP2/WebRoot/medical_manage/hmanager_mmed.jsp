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
	<section id="conter"> <section id="help-left">
	
	<details class="menu" open>
		 <summary>药物管理</summary>
	<div align="center">
		<table class="tip">
			<tr><td colspan="4">药物信息</td></tr>
			<tr>
				<td>药物ID</td>
				<td><input/></td>
				<td>药物名称<td>
				<td><input/></td>
			</tr>
		</table>
		<button class="fb">查询</button>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		
		<table class="tip">
			<tr><td colspan="4">药物信息</td></tr>
			<tr>
				<td>药物ID</td>
				<td><input/></td>
				<td>药物名称<td>
				<td><input/></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input/></td>
			</tr>
		</table>
		<button class="fb">修改</button>
		
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		
		<div>
			<table class="tip">
				<thead>
					<tr>
						<th>类型</th>
						<th>药物ID</th>
						<th>药物名称</th>
						<th>数量</th>
					</tr>
				</thead>
				<tr>
					<td>
					<select class="size1" style="width:100px" id="type">
						<option value="1">高血压</option>
						<option value="2">高血脂</option>
						<option value="3">高血糖</option>
						<option value="4">其他</option>
					</select>
					</td>
					<td><input/></td>
					<td><input/></td>
					<td><input/></td>
				</tr>
			</table>
		</div>
		
		<button class="fb">添加</button>
	</div>
	</details>
	
	
	</section>
	</section>
</body>
</html>
