<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//session.setAttribute(arg0, arg1)
	String usertype;
	String userid;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>"></base>
<title>登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script language="javascript " src="js/jquery-1.11.2.min.js"
	type="text/javascript"></script>
<script language="javascript " src="js/login.js" type="text/javascript"></script>
</head>
<body>
	<div id="out">
		<div id="ti">亲爱的用户,请先登录!</div>
		<div id="login">
			<form name="login" action="user/login.do" method="post">
				<br />
				<div class="as">
					<label>类型&nbsp;&nbsp;:</label> <select id="usertype"
						name="usertype">
						<option value="1">医生</option>
						<option value="2">病人</option>
						<option value="3">管理员</option>
					</select>
				</div>
				<div class="as">
					<label>用户名:</label> <input type="text" name="username"
						id="username"></input>
				</div>
				<div class="as">
					<label>密码&nbsp;&nbsp;:</label> <input type="password"
						name="password" id="password"></input>
				</div>
				<br />
				<div class="fbl">
					<input type="reset" value="重置" class="fb" /> <input type="submit"
						value="登陆" class="fb" /> <input type="button" value="返回"
						class="fb" onclick="location.href='index.jsp'" />
				</div>
				<div class="as">
					<label>注册</label> <a href="user/doctor/register.do">医生</a> <a
						href="user/patient/register.do">病人</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>