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


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<link rel="stylesheet" type="text/css" href="css/record_style.css">

</head>

<style>
	.fb{margin-left:530px;}
	.tip td{height:50px;width:80px;font-size:18px;}
	.tip input{height:35px;width:150px;font: 18px Arial, Helvetica;}
	.tip select{height:40px;width:180px;font: 18px Arial, Helvetica;}	
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open>
		 <summary>医院管理员管理</summary>
		 <img style="margin-left:50px;margin-top:20px" src="picture/smanager_logo.jpg"></img>
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		
	<div align="center">
	<form action="superAdmin/getHospitalAdminByHospital.do" method="post">
		<table class="tip" align="left">
				<tr>
					<td>医院名称</td>
					<td>
						<select name="hospital_id">
							<c:forEach items="${hospitals }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select> 
					<td>
				</tr>
		</table>
		<button class="fb" type="submit">查看</button>
	</form>	
		<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
		 <div class="tip" align="left">   
		    	医院管理员
		 </div>
		<button class="fb" onclick="javascrtpt:window.open('superAdmin/addHospitalAdmin.do')">添加</button>
		</div>
	</details>

	
	</section>
	</section>
</body>
</html>
