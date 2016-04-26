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
	.tip input{height:35px;width:140px;font: 18px Arial, Helvetica;}
	.tip select{height:40px;width:180px;font: 18px Arial, Helvetica;}	
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open>
		 <summary>查询权限</summary>
	<div>
		<table class="tip">
				<tr>
					<td>医生ID</td>
					<td><input/><td>
					<td>医生名称</td>
					<td><input/><td>
				</tr>
		</table>
		<button class="fb">查询</button>
	</div>
	</details>
	
	<details class="menu" open>
		 <summary>权限管理</summary>
	<div align="center">
		<table class="tip">
				<tr>
					<td>医生ID</td>
					<td><input readonly="readonly"><td>
					<td>医生名称</td>
					<td><input readonly="readonly"><td>
				</tr>
		</table>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		<table class="tip">
			<tr><td colspan="6">权限设置</td></tr>
			<tr><td colspan="6">病人信息</td></tr>
			<tr>
				<td>查看<td>
				<td><input type="checkbox"  /></td>
				<td>修改<td>
				<td><input type="checkbox"/></td>
				<td>删除<td>
				<td><input type="checkbox"  /></td>
			</tr>
			
			<tr><td colspan="6">病人用药</td></tr>
			<tr>
				<td>查看<td>
				<td><input type="checkbox"  /></td>
				<td>修改<td>
				<td><input type="checkbox"/></td>
				<td>删除<td>
				<td><input type="checkbox"  /></td>
			</tr>
			
			<tr><td colspan="6">药物库管理</td></tr>
			<tr>
				<td>查看<td>
				<td><input type="checkbox"  /></td>
				<td>修改<td>
				<td><input type="checkbox"/></td>
				<td>删除<td>
				<td><input type="checkbox"  /></td>
			</tr>
			
		</table>
		<button class="fb">修改</button>
	</div>
	</details>
	
	
	</section>
	</section>
</body>
</html>
