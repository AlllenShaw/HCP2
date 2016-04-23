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
<title>协同平台支撑管理</title>
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>

<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/submenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>

</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_supadmin.jsp"%>
			<script>
				document.getElementById("m7").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<div class="submenu">
					<ul>
						<li><a id="sm1" href="javascript:void(0)"
							onclick="mainmenu('hosadmin/pingtaibangzhu.do')">平台帮助</a>
						</li>
						<li><a id="sm2" href="javascript:void(0)"
							onclick="mainmenu('hosadmin/pingtaishezhi.do')">平台设置</a>
						</li>
					</ul>
				</div>
				<script>
					//document.getElementById("sm4").style.backgroundImage = "url(picture/images/submenu_over.png)";
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
