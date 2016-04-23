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
<title>没有权限</title>
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>

<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/submenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>

</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m3").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<div class="submenu">
					<ul>
						<li><a id="sm1" href="javascript:void(0)"
							onclick="mainmenu('doctor/huanzhexinxi.do')">患者信息管理</a></li>
						<li><a id="sm2" href="javascript:void(0)"
							onclick="mainmenu('doctor/manbingxinxi.do')">慢病信息管理</a></li>
						<li><a id="sm3" href="javascript:void(0)"
							onclick="mainmenu('doctor/huanzheyaowu.do')">患病用药查询</a></li>
					</ul>
				</div>
			</div>
			<div id="right">
				<%@include file="../nopermisson/nopermisson.jsp"%>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
