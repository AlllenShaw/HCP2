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
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>
<title>辅助诊治</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-jqChart-min.js"></script>
<script type="text/javascript" src="js/fuzhuzhenzhi.js"></script>
</head>
<script>
	
</script>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m4").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu3.jsp"%>
				<script>
					//document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>

			</div>
			<div id="right">
				<!-- <div id="jqChart" style="width: 600px; height: 300px;"></div>
				<label onclick="aaaa()">click for check</label> -->
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
