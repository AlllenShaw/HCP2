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
	font-size: 18px;
}

.tip select {
	height: 40px;
	width: 180px;
	font-size: 18px;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>用户组权限管理</summary>
	<form action="hospitalAdmin/addGroupPermissions.do" method="post">
		<div align="center">
			<table class="tip">
				<tr>
					<td style="width:180px;">组一名称</td>
					<td><select name="group1_id">
							<option value="-1" selected="selected">选择一个用户组</option>
							<c:forEach items="${ doctorGroups}" var="item">
								<option value="${item.id}">${item.name }</option>
							</c:forEach>
					</select>
					<td>
					<td style="width:180px;">组二名称</td>
					<td><select name="group2_id">
							<option value="-1" selected="selected">选择一个用户组</option>
							<c:forEach items="${paientGroups}" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
					</select>
					<td>
				</tr>
			</table>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
			<table class="tip">
				<tr>
					<td colspan="6">组一对组二权限设置</td>
				</tr>
				<tr>
					<td colspan="6">查看权限设置</td>
				</tr>
				<tr>
					<td>血糖</td>
					<td><input type="checkbox" name="bg" /></td>
					<td>血压</td>
					<td><input type="checkbox" name="bp" /></td>
					<td>血氧</td>
					<td><input type="checkbox" name="bo" /></td>
				</tr>
				<tr>
					<td>血脂</td>
					<td><input type="checkbox" name="tg" /></td>
					<td>心电</td>
					<td><input type="checkbox" name="hd" /></td>
					<td>用药记录</td>
					<td><input type="checkbox" name="medicineRecord" /></td>
				</tr>
				<tr>
					<td>病历</td>
					<td><input type="checkbox" name="emr" /></td>
					<td>医嘱</td>
					<td><input type="checkbox" name="prescription" /></td>
				</tr>

				<tr>
					<td colspan="6">添加权限设置</td>
				</tr>
				<tr>
					<td>病历</td>
					<td><input type="checkbox" name="wEmr"/></td>
					<td>医嘱</td>
					<td><input type="checkbox" name="wPrescription"/></td>
				</tr>
			</table>
			<input type="submit" class="fb" value="确认">
		</div>
	</form>
	</details> </section> </section>
</body>
</html>
