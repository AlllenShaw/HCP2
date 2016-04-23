<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>平台设置</title>
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>

<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/submenu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<link rel="stylesheet" href="css/pingtaizhicheng.css" type="text/css"></link>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_patient.jsp"%>
			<script>
				document.getElementById("m7").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu6_patient.jsp"%>
				<script>
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div id="outshezhi">
					<div id="ti">用户设置</div>
					<div id="shezhi">
						<form action="patient/setting.do" method="post">
							<div class="as">
								<label>ID:</label> <input class="ip" type="text" id="id"
									name="id" value="${userid}" readonly>
							</div>
							<div class="as">
								<label>用户名:</label> <input class="ip" type="text" id="username"
									name="username" value="${username}" readonly>
							</div>
							<div class="as">
								<label>真实姓名:</label> <input class="ip" type="text" id="realname"
									name="realname" value="${patient.realname}" readonly>
							</div>
							<div id="ti">修改信息</div>
							<div class="as">
								<label>密码:</label> <input class="ip" type="password"
									id="fpassword" name="password" onblur="checkpassword()" /> <span
									id="tipfpassword" data-tipso=""></span>
							</div>
							<div class="as">
								<label>确认密码:</label> <input class="ip" type="password"
									id="spassword" onblur="rcheckpassword()" /> <span
									id="tipspassword" data-tipso=""></span>
							</div>
							<div class="as">
								<label>住址:</label> <input class="ip" value="${address}"
									type="text" id="address" name="address" />
							</div>
							<div class="as">
								<label>联系电话:</label> <input class="ip" value="${tele}"
									type="text" id="tele" name="tele" onblur="checktele()"><span
									id="tiptele" data-tipso=""></span>
							</div>
							<div class="as">
								患高血压?<input type="checkbox" name="htnState" id="htnState"
									<c:if test="${patient.htnState }">
											checked='checked'
									</c:if> />
								患高血糖?<input type="checkbox" name="gluState" id="gluState"
									<c:if test="${patient.gluState }">
											checked='checked'
									</c:if> />
								患高血脂?<input type="checkbox" name="hplState" id="hplState"
									<c:if test="${patient.hplState }">
										checked='checked'
									</c:if> />
							</div>
							<div class="fbl">
								<input type="submit" value="修改">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
