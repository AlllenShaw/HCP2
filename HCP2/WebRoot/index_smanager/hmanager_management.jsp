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
	.tip input{height:35px;width:150px;font: 18px Arial, Helvetica;}
	.tip select{height:40px;width:180px;font: 18px Arial, Helvetica;}	
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open>
		 <summary>医院管理员管理</summary>
		 <img style="margin-left:50px;margin-top:20px" src="picture/smanager_logo.jpg"></img>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<div align="center">
		<table class="tip">
				<tr>
					<td>医院ID</td>
					<td><input/><td>
					<td>医院名称</td>
					<td><input/><td>
				</tr>
		</table>
		<button class="fb" onclick="javascrtpt:window.location.href='index_smanager/hmanager_form.jsp'">查看</button>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		 <div class="tip" align="left">   
		    	医院管理员
		 </div>
		<button class="fb" onclick="javascrtpt:window.open('registered/registered.jsp?route=registered/registered_hmanager.jsp')">添加</button>
		</div>
	</details>

	
	</section>
	</section>
</body>
</html>
