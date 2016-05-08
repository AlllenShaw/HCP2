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


<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<body>
	<h2>医院管理员列表</h2>
	<table class="bordered" id="hmanager_form">
		<thead>
			<tr>
				<th>医院管理员ID</th>
				<th>医院管理员姓名</th>
				<th>医院管理员联系方式</th>
				<th>删除</th>
			</tr>
		</thead>
			<c:forEach items="${hospitalAdministrators }" var="item">
				<tr>
					<td>${item.id }</td>
					<td>${item.realname }</td>
					<td>${item.tele }</td>
					<td><a href="superAdmin/removeHospitalAdmin.do?hospitalAdmin_id=${item.id }">删除</a></td>
				</tr>
			</c:forEach>
		
	</table>
	<br />
	<div class="paging">
		<input type="button" value="上一页" onclick="">
		<%
			int pagesize = 3;//一页显示几条记录
			int pagenow = 1;//希望显示第几页
			int rowcount = 0;//共有几条记录
			int pagecount = 5;//共有几页(计算)

			for (int i = pagenow; i < pagenow + pagecount; i++) {
		%>
		<input class="fb" type="button" value="<%=i%>" onclick="">
		<%
			}
		%>
		<input class="fb" type="button" value="下一页" onclick="">
	</div>

	<script src="js/all_form.js"></script>
</body>
</html>
