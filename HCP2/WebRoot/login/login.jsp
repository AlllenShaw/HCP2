<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="fort.css">
<style>
.top-banner {
	background-color: #333;
}
.nav {
	margin-bottom: 30px;
}
.nav li.current a{
	background-color: #009DFF;
	color: #fff;
	padding: 10px;
}
.nav a {
	margin: 5px;	
	color: #333;
	text-decoration: none;
	font-size:18px;
	font-family: 微软雅黑;
}
</style>

<script src="../js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body>
<div class="form-wrapper">
	<form name="login" action="user/login.do">
		<div class="form">
		<div class="nav">
			<ul>
				<li id="li1"><a id="a1">医生</a></li>
				<li id="li2" class="current"><a id="a2">病人</a></li>
				<li id="li3"><a id="a3">医院管理员</a></li>
				<li id="li4"><a id="a4">系统管理员</a></li>
			</ul>
		</div>
			<div class="form-item">
				<input type="text" name="username" id="username" required="required" placeholder="用户名" autocomplete="off">
			</div>
			<div class="form-item">
				<input type="password" name="password" id="password" required="required" placeholder="密码" autocomplete="off">
			</div>
			<div class="button-panel">
				<input id="login" type="submit" class="button"  value="登录">
				<input id="registered" type="button" class="button"  value="注册">
			</div>
			<input id="usertype" type="text" style="display:none;" />
		</div>
	</form>
</div>



</body>
</html>
