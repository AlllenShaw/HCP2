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
<script src="../js/jquery-1.8.3.min.js" type="text/javascript"></script>

</head>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>综合查询</summary> <img
		align="middle" src="picture/seo_logo.jpg"></img>
	
	<div align="center">
	<select id="selector1" name="selector1" class="size1" style="width:100px">
		<option value="1">血糖表</option>
		<option value="2">血压表</option>
		<option value="3">血氧表</option>
		<option value="4">访谈记录</option>
		<option value="5">血糖图</option>
		<option value="6">血压图</option>
		<option value="7">血氧图</option>
		<option value="8">心电图</option>
		<option value="9">用药记录</option>
		<option value="10">病历</option>
		<option value="11">医嘱</option>
	</select> 
	<select id="selector2" name="selector2" class="size1" style="width:100px">
		<option value="1">姓名</option>
		<option value="2">ID</option>
		<option value="3">身份证</option>
		<option value="4">所有病人</option>
	</select> <input type="text" id="text1" name="text1" class="size1"> 
	<br/>
	<input id="search" class="fb" type="submit" value="查询">
	</div>
	</details>
</body>

<script src="seo/seo.js"></script>

</html>
