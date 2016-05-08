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

</head>

<style>
.fb {
	margin-left: 530px;
}

.tip td {
	height: 50px;
	width: 80px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 180px;
	font: 18px Arial, Helvetica;
}

.tip select {
	height: 40px;
	width: 180px;
	font: 18px Arial, Helvetica;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>药物查询</summary>
	<div align="left">
		<form action="hospitalAdmin/getMedicine.do" method="post">
			<table class="tip">
				<tr>
					<td>药物名称</td>
					<td><input type="text" name="name" /></td>
				</tr>
			</table>
			<input type="submit" value="查询" class="fb" />
		</form>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		<button class="fb" onclick="javascript:window.location.href='index_hmanager/medadd.jsp'">添加</button>
	
	</div>
	</details> </section> </section>
</body>
</html>
