
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<title>病人注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<base href="<%=basePath%>">
<script>
	function getDoctor() {
		$("#Doctor").empty();
		$
				.ajax({
					url : "user/patient/getDoctors.do",
					data : {
						"hospital_id" : $("#Hospital").val()
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						if (data.result == 1) {
							var doctorList = data.list;
							console.log(doctorList);
							for ( var i = 0; i < doctorList.length; i++)
								$("#Doctor").append(
										"<option value="+doctorList[i].id+">"
												+ doctorList[i].realname
												+ "</option>");
						}
					}
				});
	}
</script>
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>

</head>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

<script type="text/javascript" src="js/register.js"></script>

<body>
	<div id="outpat">
		<div id="ti">注册-病人</div>
		<div id="pat">

			<form id="register_patient" method="post">
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
							name="realname" onBlur="checkrealname()" /> <span
							id="tiprealname" data-tipso=""></span>
						</td>
						<td class="td_2">性别：</td>
						<td class="td_3"><select id="gender" name="gender"
							style="width: 100%">
								<option value="0">男</option>
								<option value="1">女</option>
						</select>
						</td>
						<td class="td_2">民族：</td>
						<td class="td_3"><input type="text" id="nation" name="nation"
							onblur="checknation()"> <span id="tipnation"
							data-tipso=""></span>
						</td>
					</tr>
					<tr>
						<td class="td_2">年龄：</td>
						<td class="td_3"><input type="text" id="age" name="age"
							onblur="checkage()"> <span id="tipage" data-tipso=""></span>
						</td>
						<td class="td_2">婚姻状况：</td>
						<td class="td_3"><select id="marriage" name="marriage"
							style="width: 100%">
								<option value="0">未婚</option>
								<option value="1">已婚</option>
						</select>
						</td>
						<td class="td_2">职业：</td>
						<td class="td_3"><input type="text" id=profession
							name="profession">
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
						<td colspan="5"><input type="text" id="company"
							name="company" size="90%">
						</td>
					</tr>
					<tr>
						<td class="td_2">联系电话：</td>
						<td class="td_3"><input type="text" id="tele" name="tele"
							onblur="checktele()"> <span id="tiptele" data-tipso=""></span>
						</td>
						<td class="td_2">家属电话：</td>
						<td class="td_3"><input type="text" id="tele1" name="tele1"
							onblur="checktele1()"> <span id="tiptele1" data-tipso=""></span>
						</td>
						<td class="td_2">家属电话：</td>
						<td class="td_3"><input type="text" id="tele2" name="tele2"
							onblur="checktele2()"> <span id="tiptele2" data-tipso=""></span>
						</td>
					</tr>
					<tr>
						<td>医生:</td>
						<td><select name="Hospital" id="Hospital"
							onchange="getDoctor()">
								<option value="-1">请选择</option>
								<c:forEach items="${hospital}" var="item">
									<option value='${item.id}'>${item.name}</option>
								</c:forEach>
						</select></td>
						<td><select name="doctor_id" id="Doctor">
								<option value="-1">请选择</option>
						</select> <!--  <input type="text" id="doctor_id" name="doctor_id" /> -->
						</td>
					</tr>

					<tr>
						<td colspan="6" class="td_1">病历信息</td>
					</tr>
					<tr>
						<td>患高血压?</td>
						<td><input type="checkbox" name="htnState" />
						</td>
						<td>患高血糖?</td>
						<td><input type="checkbox" name="gluState" />
						</td>
						<td>患高血脂?</td>
						<td><input type="checkbox" name="hplState" />
						</td>
					</tr>
					<tr>
						<td id="class">患病史：</td>
						<td colspan="5"><input type="text" id="his_1"
							name="illnessHistory" size="90%">
						</td>
					</tr>
					<tr>
						<td class="td_2">过敏史：</td>
						<td colspan="5"><input type="text" id="his_2"
							name="allergicHistory" size="90%">
						</td>
					</tr>
					<tr>
						<td class="td_2">家族病史：</td>
						<td colspan="5"><input type="text" id="his_3"
							name="familyMedicalHistory" size="90%">
						</td>
					</tr>
				</table>
				<div class="fbl2">
					<input class="fb" type="submit" value="提交"> <input
						class="fb" type="reset" value="重置"> <input class="fb"
						type="button" value="取消" onClick="location.href='login/login.jsp'";
>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
