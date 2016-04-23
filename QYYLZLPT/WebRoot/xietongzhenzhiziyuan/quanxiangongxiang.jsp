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
<title>协同资源共享权限管理</title>
<base href="<%=basePath%>"></base>

<meta http-equiv="pragma" content="no-cache">

<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/xietongzhenzhiziyuan.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/xietongzhezhiziyuan.js"></script>

</head>
<body onload="hosload()">
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
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div class="outqx">
					<form>
						<div class="ti">医院</div>
						<!--<div id="hospital1"></div>-->
						<div class="qx">
							<div class="as">
								<label>当前医院：</label><label id="hospital1"></label> <input
									type="hidden" id="hospital1inp" />
							</div>
							<!--<select id="hospital1" style="width:100px">
							<option>A医院</option>
						</select>  -->
							<div class="as">
								<label>选择医院：</label><select id="hospital2">
									<!--  <option>B医院</option>
						<option>C医院</option>
						<option>D医院</option> -->
								</select>
							</div>

							<div class="fblist">
								<input type="button" onclick="quanxianchaxun()" value="查询" />
							</div>
						</div>
						<div class="ti">共享权限</div>

						<div class="qxlist">
							<div id="qxlb"></div>
							<div class="fblist">
								<input type="button" value="修改" onclick="quanxianxiugai()" />
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
