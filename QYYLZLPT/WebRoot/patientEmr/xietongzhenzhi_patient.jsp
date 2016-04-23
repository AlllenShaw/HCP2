<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>"></base>

<title>协同诊治</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/testing.js"></script>
</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_patient.jsp"%>
			<script>
				document.getElementById("m3").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu2_patient.jsp"%>
			</div>
			<div id="right"></div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>