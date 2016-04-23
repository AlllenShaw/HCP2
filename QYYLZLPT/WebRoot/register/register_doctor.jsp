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
<title>医生注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<base href="<%=basePath%>">

<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>

</head>


<body>
	<div id="outpat">
		<div id="ti">注册-医生</div>
		<div id="pat">
			<form id="register_doctor" name="register_doctor"
				action="user/doctor/register.do" method="post"
                onsubmit="return checkdoctor()">
				<table border="0" cellspacing="1" cellpadding="5px">
					<tr>
						<td colspan="6" class="td_1">基本信息</td>
					</tr>
					<tr>
						<td class="td_2">用户名:</td>

						<td><input type="text" id="username" name="username"
							onblur="checkusername()" /> <span id="tipusername" data-tipso=""></span>
						</td>
						<td>密码:</td>
						<td><input type="password" id="fpassword" name="password"
							onblur="checkpassword()" /> <span id="tipfpassword"
							data-tipso=""></span>
						</td>
						<td>确认密码:</td>
						<td><input type="password" id="spassword"
							onblur="rcheckpassword()" /> <span id="tipspassword"
							data-tipso=""></span>
						</td>
					</tr>

					<tr>
						<td class="td_2">姓名：</td>
						<td class="td_3"><input type="text" id="realname"
							name="realname" onblur="checkrealname()" /> <span
							id="tiprealname" data-tipso=""></span>
						</td>
						<td class="td_2">性别：</td>
						<td class="td_3"><select id="gender" name="gender"
							style="width:100%">
								<option value="0">男</option>
								<option value="1">女</option>
						</select></td>
						<td class="td_2">民族：</td>
						<td class="td_3"><input type="text" id="nation" name="nation"
							onblur="checknation()"> <span id="tipnation"
							data-tipso=""></span>
						</td>
					</tr>
					<tr>
						<td class="td_2">年龄：</td>
						<td class="td_3"><input type="text" id="age" name="age"
							onblur="checkage()"><span id="tipage" data-tipso=""></span>
						</td>

					</tr>
					<tr>
						<td class="td_2">现住地址：</td>
						<td colspan="5"><input type="text" id="address"
							name="address" size="90%">
						</td>
					</tr>
					<tr>
						<td class="td_2">工作单位：</td>
						<td colspan="5"><input type="text" id="" name="occupation"
							size="90%">
						</td>
					</tr>
					<tr>

						<td class="td_2">联系电话：</td>
						<td class="td_3"><input type="text" id="tele" name="tele"
							onblur="checktele()"><span id="tiptele" data-tipso=""></span>
						</td>
						<td class="td_2">联系邮箱：</td>
						<td class="td_3"><input type="text" id="mail" name="mail"
							onblur="checkemail()"> <span id="tipmail" data-tipso=""></span>

						</td>
					</tr>
					<tr>
						<td colspan="6" class="td_1">信息</td>
					</tr>
					<tr>
						<td id="class">所属医院：</td>
						<td colspan="5"><select name="hospital_id">
								<c:forEach items="${hospital }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select> 
						<!--  <input type="text" id="hospital" name="hospital_id" size="90%"> -->
						</td>
					</tr>
					<tr>
						<td class="td_2">从医许可证：</td>
						<td colspan="5"><input type="text" id="certificate"
							name="certificate" onblur="checkcer()" size="90%"><span
							id="tipcer" data-tipso=""></span></td>
					</tr>
					<tr>
						<td class="td_2">所属科：</td>
						<td colspan="5"><input type="text" id="belongdepart"
							name="belongdepart" onblur="checkbel()" size="90%"><span
							id="tipbel" data-tipso=""></span></td>
					</tr>
					<tr>
						<td class="td_2" rowspan="5">专长科：</td>
						<td colspan="5" rowspan="3"><input type="text" id="expdepart"
							name="expdepart" onblur="checkexp()" size="90%" /><span
							id="tipexp" data-tipso=""></span></td>
					</tr>

				</table>
				<div class="fbl2">
					<input class="fb" type="submit" value="提交"> <input
						class="fb" type="reset" value="重置"> <input class="fb"
						type="button" value="取消" onclick="location.href='login/login.jsp'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
