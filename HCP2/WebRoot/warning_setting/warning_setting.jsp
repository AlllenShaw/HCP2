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


<link rel="stylesheet" type="text/css" href="css/form_style.css">
<link rel="stylesheet" type="text/css" href="css/record_style.css">

<style>
	.fb{margin-top:20px;margin-left:550px;}
</style>

</head>

<style>
	.bordered{width:650px;margin-top:20px;margin-left:1px;margin-raight:1px;}
	.bordered input{width:110px;height:35px;}
</style>


<body>
	<div>
		<H2>XXX的预警值设置</H2>
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
				<td><input></td>
				<td><input></td>
				<td><input></td>
				<td><input></td>
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
				<td><input></td>
				<td><input></td>
				<td><input></td>
				<td><input></td>
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
				<td><input></td>
				<td><input></td>
			</tr>
			<tr>
				<td>舒张压</td>
				<td><input></td>
				<td><input></td>
			</tr>
			<tr>
				<td>心率</td>
				<td><input></td>
				<td><input></td>
			</tr>
		</table>
	</div>
	<button class="fb">确定</button>
</body>
</html>
