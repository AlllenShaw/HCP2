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
	.tip textarea{height:100px;width:400px;}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open>
		 <summary>用户组信息</summary>
		 
	<form>
	<div>
		<table class="tip">
				<tr>
					<td>所属医院</td>
					<td><input/><td>
				</tr>
				<tr>
					<td>组名称</td>
					<td><input/><td>
					<td>组ID</td>
					<td><input/><td>
				</tr>
				<tr>
					<td>用户组描述<td>
				</tr>
				<tr>
					<td colspan="4" rowspan="2">
						<textarea></textarea>
					</td>
				</tr>
		</table>
		<input class="fb" type="submit" value="添加" />
	</div>
	</form>
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	
	</details>
	
	</section>
	</section>
</body>
</html>