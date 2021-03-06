<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<base href="<%=basePath%>">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
</head>



<body>

	<div id="wrap">
		<div class="top_corner"></div>
			<div id="main_container">
				
				
				<%@include file="top.jsp"%>
				
				<div class="center_content">
				<div id="outpat">
					<div id="pat">

						<form id="request_pw" name="request_pw"
										action="patient/forgetPassword.do" method="post"
										onsubmit="return checkrequest_pw()">
							<table border="0" cellspacing="2px" cellpadding="2px">
								<tr>
									<td colspan="6" class="td_1">忘记密码</td>
								</tr>
								<tr><td>&nbsp; </td></tr>
								<tr>
									<td class="td_2">用户名</td>

									<td><input type="text" id="username" name="username"
										onblur="checkusername()" /> <span id="tipusername" data-tipso=""></span>
									</td>
									<td>密码</td>
									<td><input type="password" id="fpassword" name="password"
										onblur="checkpassword()" /> <span id="tipfpassword"
										data-tipso=""></span>
									</td>
									<td>确认密码</td>
									<td><input type="password" id="spassword"
										onblur="rcheckpassword()" /> <span id="tipspassword"
										data-tipso=""></span>
									</td>
								</tr>

								<tr>
									<td class="td_2">出生日期</td>
									<td colspan="5"><input type="text" id="security1"
										name="security1" size="90%" onblur="question1()"><span id="que1" data-tipso=""></span>
									</td>					
								</tr>
								<tr>
									<td class="td_2">喜欢的书</td>
									<td colspan="5"><input type="text" id="security2"
										name="security2" size="90%" onblur="question2()"><span id="que2" data-tipso=""></span>
									</td>	
								</tr>
								<tr>
									<td class="td_2">喜欢的人</td>
									<td colspan="5"><input type="text" id="security3"
										name="security3" size="90%" onblur="question3()"><span id="que3" data-tipso=""></span>
									</td>	
								</tr>
							</table>
							<div class="fbl2">
								<input class="fb" type="submit" value="确定"> <input
									class="fb" type="reset" value="重置"> <input class="fb"
									type="button" value="取消" onclick="location.href='main/main.jsp'">
							</div>
						</form>
					
					</div>
				</div>
				</div>
				
				<%@include file="bottom.jsp"%>
				
			</div>
		</div>
</body>
</html>
