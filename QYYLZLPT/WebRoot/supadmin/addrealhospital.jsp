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
<title>添加实体医院</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/supadmin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/supadmin.js"></script>
</head>
<script>
</script>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_supadmin.jsp"%>
			<script>
				document.getElementById("m2").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenuex.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div class="outadmin">
					<div class="ti">添加实体医院</div>
					<div class="addhos">
						<form action="admin/addHospital.do" method="post">
							<div class="sti">医院信息：</div>
							<div class="as">
								<label>医院名字：</label><input class="ip" type="text" name="name">
							</div>
							<div class="as">
								<label>医院地址：</label><input class="ip" type="text" name="address">
							</div>

							<div class="as">
								<label>医院级别：</label> 
								<select id="sl1" id="sl1" class="is1" onchange="levelcheck()">
									<option>甲</option>
									<option>乙</option>
									<option>丙</option>
								</select><select id="sl2" class="is2" onchange="levelcheck()">
									<option>三级</option>
									<option>二级</option>
									<option>一级</option>
								</select> 
								<input type="hidden" id="level"name ="level"/>
							</div>
							<div class="as">
								<label>医生列表：</label><input class="ip" type="text">
							</div>
							<div class="sti">设置管理员：</div>

							<div class="as">
								<label>用戶名：</label><input class="ip" type="text" name="username">
							</div>

							<div class="as">
								<label>密码：</label><input class="ip" type="password" name="password">
							</div>
							<div class="as">
								<label>确认密码：</label><input class="ip" type="password">
							</div>

							<div class="as">
								<label>邮箱：</label><input class="ip" type="text" name="mail">
							</div>
							<div class="as">
								<label>联系电话：</label><input class="ip" type="text" name="tele">
							</div>
							<div class="fbl">
								<input type="submit" value="提交"/>
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
