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
<title>修改信息</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
</head>



<body>

	<div id="wrap">
		<div class="top_corner"></div>
		<div id="main_container">


			<%@include file="top.jsp"%>

			<div class="center_content">
				<div id="outpat">
					<div id="pat">

						<form id="register_doctor" name="register_doctor"
							action="doctor/updateDoctorInfo.do" method="post"
							onsubmit="return checkdoctor()">
							<table border="0" cellspacing="2px" cellpadding="2px">
								<tr>
									<td colspan="6" class="td_1">修改信息</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td class="td_2">用户名</td>

									<td><input type="text" id="username" name="username"
										onblur="checkusername()" value="${doctor.username}" /> <span
										id="tipusername" data-tipso=""></span></td>
									<td class="td_2">姓名</td>
									<td class="td_3"><input type="text" id="realname"
										name="realname" onblur="checkrealname()"
										value="${doctor.realname}" /> <span id="tiprealname"
										data-tipso=""></span></td>
									<td colspan="2" rowspan="6" align="center">
										<div id="preview">
											<img id="imghead" width=100 height=125 border=0
												src='<%=request.getContextPath()%>/picture/pic_user.gif' />
										</div>
										<div style="margin-top:3px;margin-left:3px;">
											<a href="javascript:;" class="file">选择文件 <input
												type="file" name="" id="" onchange="previewImage(this)">
											</a>
										</div>
									</td>
								</tr>


								<tr>
									<td class="td_2">性别</td>
									<td class="td_3"><select id="gender" name="gender"
										value="${doctor.gender}">
											<option value="0">男</option>
											<option value="1">女</option>
									</select></td>
									<td class="td_2">民族</td>
									<td class="td_3"><input type="text" id="nation"
										name="nation" value="${doctor.nation}" onblur="checknation()">
										<span id="tipnation" data-tipso=""></span></td>
								</tr>
								<tr>
									<td class="td_2">年龄</td>
									<td class="td_3"><input type="text" id="age" name="age"
										onblur="checkage()" value="${doctor.age}"><span
										id="tipage" data-tipso=""></span></td>
									<td class="td_2">身份证</td>
									<td class="td_3"><input type="text" id="id2" name="id2"
										onblur="checkidcard()" value="${doctor.idNumber}"> <span
										id="tipidcard" data-tipso=""></span></td>
								</tr>
								<tr>
									<td class="td_2">现住地址</td>
									<td colspan="5"><input type="text" id="naddress"
										name="naddress" size="62%" value="${doctor.address}">
									</td>
								</tr>
								<tr>
									<td class="td_2">工作方向</td>
									<td colspan="5"><input type="text" id="" name="profession"
										size="62%" value="${doctor.profession}"></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								<tr>
								<tr>

									<td class="td_2">联系电话</td>
									<td class="td_3"><input type="text" id="tele" name="tele"
										onblur="checktele()" value="${doctor.tele}"><span
										id="tiptele" data-tipso=""></span></td>
									<td class="td_2">联系邮箱</td>
									<td class="td_3"><input type="text" id="mail" name="mail"
										onblur="checkemail()" value="${doctor.mail}"> <span id="tipmail"
										data-tipso=""></span></td>
									<td id="class">所属医院</td>
									<td colspan="5"><select name="hospital_id">
											<c:forEach items="${hospitals }" var="item">
												<option value="${item.id }">${item.name }</option>
											</c:forEach>
									</select> <!--  <input type="text" id="hospital" name="hospital_id" size="90%"> -->
									</td>
								</tr>
								<tr>
									<td class="td_2">行医编号</td>
									<td colspan="5"><input type="text" id="certificate"
										name="certificate" onblur="checkcer()" size="90%" value="${doctor.doctorLicense}"><span
										id="tipcer" data-tipso="" ></span></td>
								</tr>
								<tr>
									<td class="td_2">所属科</td>
									<td colspan="5"><input type="text" id="belongdepart"
										name="belongdepart" onblur="checkbel()" size="90%" value="${doctor.company}"><span
										id="tipbel" data-tipso="" ></span></td>
								</tr>
								<tr>
									<td class="td_2" rowspan="5">自我介绍</td>
								</tr>
								<tr>
									<td><input type="hidden" id="doctor_id" name="doctor_id"
										value="${doctor.id}" /> </td>
								</tr>
							</table>
							<textarea class="textarea1" id="selfintroduce"></textarea>
							<div class="fbl2">
								<input class="fb" type="submit" value="提交"> <input
									class="fb" type="reset" value="重置"> <input class="fb"
									type="button" value="取消"
									onclick="location.href='main/main.jsp'">
							</div>
						</form>

					</div>
				</div>
			</div>

			<%@include file="bottom.jsp"%>

		</div>
	</div>
</body>
</html>
