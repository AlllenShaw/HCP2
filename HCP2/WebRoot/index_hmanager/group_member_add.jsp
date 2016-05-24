<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<link rel="stylesheet" type="text/css" href="css/record_style.css">
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>

</head>

<style>
.fb {
	margin-left: 530px;
}

.tip td {
	height: 50px;
	width: 150px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 140px;
	font-size: 18px;
}

.tip select {
	height: 40px;
	width: 300px;
	font-size: 18px;
}

.tip textarea {
	height: 100px;
	width: 400px;
	font-size: 18px;
}
.show
{
	display:block;
}

.hidden
{
	display:none;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>用户组成员添加</summary>

	<form action="hospitalAdmin/addUser2Group.do" method="post">
		<div>
			<table class="tip">
				<tr>
					<td>选择用户组</td>
					<td><select id="group_id" name="groupId">
							<option value="-1" selected="selected">请选择用户组</option>
							<c:forEach items="${userGroups}" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
					</select>
					<td>
				</tr>
				<tr>
					<td>选择用户组类型</td>
					<td><select id="type" name="type">
							<option value="0" selected="selected">医生用户组</option>
							<option value="1">患者用户组</option>
					</select>
					<td>
				</tr>
				<!-- 下面两个下拉框根据上面的用户类型显示 -->
				<tr>
					<td>选择医生用户</td>
					<td><select id="userId1" name="userId1">
							<option value="-1" selected="selected" >请选择用户</option>
							<c:forEach items="${doctors}" var="item">
								<option value="${item.id }">${item.hospital.name}:${item.username}:${item.realname}</option>
							</c:forEach>
					</select>
					<td>
				</tr>
				<tr>
					<td>选择患者用户</td>
					<td><select id="userId2" name="userId2" class="hidden">
							<option value="-1" selected="selected">请选择用户</option>
							<c:forEach items="${patients}" var="item">
								<option value="${item.id }">${item.username}:
									${item.realname}</option>
							</c:forEach>
					</select>
					<td>
				</tr>
			</table>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
			<input class="fb" type="submit" value="添加" />
		</div>
	</form>

	</details> </section> </section>
	<script type="text/javascript" src="js/group.js" charset="utf-8"></script>
</body>
</html>
