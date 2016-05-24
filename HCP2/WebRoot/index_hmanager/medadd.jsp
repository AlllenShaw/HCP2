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
	width: 230px;
	margin-right:10px;
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
		class="menu" open> <summary>药物添加</summary>
	<div align="center">
		<form action="hospitalAdmin/addMedicine.do" method="post">
			<div>
				<table class="tip" cellpadding="10px">
					<tr>
						<td>类型</td>
						<td><select class="size1" style="width:100px" id="type">
								<option value="1">高血压</option>
								<option value="2">高血脂</option>
								<option value="3">高血糖</option>
								<option value="4">其他</option>
						</select></td>
						<td>药物名称</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>适应症</td>
						<td colspan="4"><input type="text" name="adaptationDisease" style="width:550px;"/></td>
					</tr>
					<tr>
						<td>服用方式</td>
						<td><input type="text" name="usage"/></td>
					</tr>
					<tr>

						<td>用量</td>
						<td colspan="4"><input type="text" name="dosage" style="width:550px;"/></td>
					</tr>
					<tr>
						<td>不良反应</td>
						<td colspan="4"><input type="text" name="adverseReaction" style="width:550px;"/></td>
					</tr>
					<tr>
						<td>药物禁忌</td>
						<td colspan="4"><input type="text" name="taboo" style="width:550px;"/></td>
					</tr>
					<tr>
						<td>注意事项</td>
					</tr>
					<tr>
						<td colspan="5"><textarea type="text" name="attentions" class="htextareatype1"></textarea></td>
					</tr>
				</table>
			</div>
			<input type="submit" class="fb" value="添加">
			</button>
		</form>
	</div>
	</details> </section> </section>
</body>
</html>
