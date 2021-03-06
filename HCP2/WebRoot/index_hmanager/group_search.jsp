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
<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<style>
.fb {
	margin-left: 530px;
}

.tip td {
	height: 50px;
	width: 80px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 140px;
	font: 18px 微软雅黑;
}

.tip select {
	height: 40px;
	width: 180px;
	font: 18px 微软雅黑;
}

</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>用户组管理</summary>
	<form action="" method="post">
		<div style="margin-top:30px;margin-bottom:10px;">
			<table class="bordered">
				<!-- 调一下表格的样式 -->
				<thead>
					<tr>
						<th>用户组ID</th>
						<th>用户组名称</th>
						<th>用户组描述</th>
						<th>操作</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${userGroups }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.description }</td>
						<td><a href="hospitalAdmin/showGroupDetail.do?group_id=${item.id }">查看详情</a></td>
						<td><a href="hospitalAdmin/deleteUserGroup.do?group_id=${item.id }">删除</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>
	<button class="fb"
		onclick="javascript:window.location.href='hospitalAdmin/addUserGroup.do'">添加组</button>
	
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		
	<button class="fb" style="width:150;margin-left:510px;"
		onclick="javascript:window.location.href='hospitalAdmin/addUser2Group.do?hospital_id=${hospital.id}'">添加组成员</button>
	</details> </section> </section>
</body>
</html>
