<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
	margin-left: 450px;
}

.tip td {
	height: 50px;
	width: 50px;
	font-size: 18px;
}

.tip input {
	height: 35px;
	width: 140px;
	font: 18px 微软雅黑;
}

.tip select {
	height: 40px;
	width: 140px;
	font: 18px 微软雅黑;
}

.tip textarea {
	height: 100px;
	width: 400px;
}

#help-left {
	width: 650px;
}
</style>

<body>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>APP上传</summary>
	<form action="superAdmin/uploadApp.do" method="post" enctype="multipart/form-data">
		<div class="tip">
			<!-- 
			<input type="text" name="filename" id="filename"
				style="float:left;width:300px;margin-right:20px;margin-left:20px;">
			<div style="margin-top:20px;margin-left:3px;">
				<a href="javascript:;" class="file" style="color:#fff;">选择文件 <input
					type="file" name="fileid" id="fileid"
					onchange="document.getElementById('filename').value=this.value">
				</a>
			</div>
		 -->
			<input type="file" name="app"
				style="float:left;width:300px;margin-right:20px;margin-left:20px;margin-top:20px;" /><br>
			<table class="tip">
				<tr>
					<td>版本号</td>
					<td><input type="text" name="version"></td>
				</tr>
				<tr>
					<td>更新详情</td>
					<td colspan="3" rowspan="2"><textarea name="updateInfo"></textarea></td>
				</tr>
			</table>
		</div>
		<input type="submit" class="fb" value="提交" />
	</form>

	</details> </section> </section>
</body>
</html>
