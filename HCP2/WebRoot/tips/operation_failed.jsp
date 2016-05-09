<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>操作失败</title>
</head>

<body>
	<div align="center">
		<img align="middle" src="picture/failed.jpg"></img>
	</div>
	
	<div align="center" style="font-size:25px;font-family:微软雅黑;" id="showtime">
		&nbsp;&nbsp;&nbsp;&nbsp;操作失败！
	</div>
</body>
</html>
