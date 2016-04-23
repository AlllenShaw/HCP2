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
<title>协同资源共享渠道管理</title>
<base href="<%=basePath%>"></base>

<meta http-equiv="pragma" content="no-cache">
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/xietongzhenzhiziyuan.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/xietongzhezhiziyuan.js"></script>

</head>
<body onload="hosloadadd()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_hosadmin.jsp"%>
			<script>
				document.getElementById("m5").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu4.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div class="outqudao">
					<form>
						<div class="ti">添加合作医院</div>
						<div class="qudao">
							<div class="as">
								<label>当前医院：</label> <label id="hospital1"> </label> <input
									id="hospital1inp" type="hidden">
							</div>
							<div class="as">
								<label>合作医院：</label> <select id="hospital2">
									<!-- <option>B医院</option>
							<option>C医院</option>
							<option>D医院</option> -->
								</select>
							</div>
							<div class="fblist">
								<input type="button" value="添加" onclick="addcohospital()" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>
</body>
</html>
