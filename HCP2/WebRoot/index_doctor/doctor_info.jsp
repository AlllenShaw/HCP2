<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<script src="js/info.js"></script>
</head>

<style>
	.menu input{width:160px}
</style>

<body onload="getdoctorinfo()">
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>个人信息</summary>
		<div align="center">
		<table border="0" cellspacing="1px" cellpadding="6px">
					<tr>
						<td colspan="6" class="td_1">医生基本信息</td>
					</tr>
					<tr>
						<td class="td_2">用户名</td>
						<td><input type="text" id="username" name="username"
							 readonly="readonly"/>
						</td>
						<td class="td_2">姓名</td>
						<td class="td_3"><input type="text" id="realname"
							name="realname" readonly="readonly" />
						</td>
						<td colspan="2" rowspan="4" align="center">
							<div id="preview">
            					<img id="imghead" width=100 height=120 border=0 src='<%=request.getContextPath()%>/picture/pic_user.gif'/>
        					</div>
						</td>
					</tr>

					<tr>
						<td class="td_2">ID</td>
						<td><input type="text" id="id2" name="id2"
							 readonly="readonly"/>
						</td>
						<td class="td_2">性别</td>
						<td class="td_3"><input type="text" id="gender" name="gender"
							readonly="readonly">
						</td>
					<tr/>
					<tr>
						<td class="td_2">年龄</td>
						<td class="td_3"><input type="text" id="age" name="age"
							readonly="readonly">
						</td>
						<td class="td_2">民族</td>
						<td class="td_3"><input type="text" id="nation" name="nation"
							readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="td_2">身份证</td>
						<td class="td_3"><input type="text" id="id2" name="id2"
							readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="td_2">现住地址</td>
						<td colspan="5"><input style="width:550px" type="text" id="address"
							name="address" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="td_2">工作单位</td>
						<td colspan="5"><input style="width:550px" type="text" id="" name="occupation"
							readonly="readonly">
						</td>
					</tr>
					<tr>

						<td class="td_2">联系电话</td>
						<td class="td_3"><input type="text" id="tele" name="tele"
							readonly="readonly">
						</td>
						<td >邮箱</td>
						<td class="td_3"><input type="text" id="mail" name="mail"
							readonly="readonly">

						</td>
					</tr>
					<tr>
						<td id="class">所属医院</td>
						<td colspan="5"><input style="width:550px"  type="text" id="hospital" name="hospital_id" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="td_2">从医许可证</td>
						<td colspan="5"><input style="width:550px" type="text" id="certificate"
							name="certificate" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="td_2">所属科</td>
						<td colspan="5"><input style="width:550px" type="text" id="belongdepart"
							name="belongdepart" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="td_2">专长科</td>
						<td colspan="5"><input style="width:550px" type="text" id="expdepart"
							name="expdepart" readonly="readonly" /></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</div>
	</details>
</body>
</html>
