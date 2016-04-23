<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>协同诊治安全管理</title>
<base href="<%=basePath%>"></base>

<meta http-equiv="pragma" content="no-cache">
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>

</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_hosadmin.jsp"%>
			<script>
				document.getElementById("m6").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu5.jsp"%>
				<script>
					//document.getElementById("sm1").style.backgroundImage = "url(picture/images/menu_over.png)";
				</script>

			</div>
			<div id="right"></div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>
</body>
</html>
