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
<title>修改个人信息</title>
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

						<form id="register_patient" method="post"
							action="patient/updatePatientInfo.do">
							<table border="0" cellspacing="1" cellpadding="2px">
								<tr>
									<td colspan="6" class="td_1">修改信息</td>
								</tr>
								<tr>
									<td class="td_2">用户名</td>

									<td><input type="text" id="username" name="username"
										onblur="checkusername()" readonly="readonly"
										value="${patient.username }" /> <span id="tipusername"
										data-tipso=""></span></td>
									<td class="td_2">姓名</td>
									<td class="td_3"><input type="text" id="realname"
										name="realname" readonly="readonly"
										value="${patient.realname }" onBlur="checkrealname()" /> <span
										id="tiprealname" data-tipso=""></span></td>
									<td colspan="2" rowspan="6" align="center">
										<div id="preview"">
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
										style="width: 100%" value="${patient.gender}">
											<option value="male">男</option>
											<option value="female">女</option>
									</select></td>
									<td class="td_2">民族</td>
									<td class="td_3"><input type="text" id="nation"
										name="nation" value="${patient.nation }"
										onblur="checknation()"> <span id="tipnation"
										data-tipso=""></span></td>
								</tr>
								<tr>
									<td class="td_2">年龄</td>
									<td class="td_3"><input type="text" id="age" name="age"
										value="${patient.age }" onblur="checkage()"> <span
										id="tipage" data-tipso=""></span></td>
									<td class="td_2">婚姻状况</td>
									<td class="td_3"><select id="marriage" name="marriage"
										style="width: 100%">
											<option value="0">未婚</option>
											<option value="1">已婚</option>
											<option value="2">离婚</option>
											<option value="3">丧婚</option>
									</select></td>
								</tr>
								<tr>
									<td class="td_2">职业</td>
									<td class="td_3"><input type="text" id=profession
										name="profession" value="${patient.profession}"></td>
									<td class="td_2">身份证</td>
									<td class="td_3"><input type="text" id="id2" name="id2"
										value="${patient.idNumber }" onblur="checkidcard()"> <span
										id="tipidcard" data-tipso=""></span></td>
								<tr />
								<tr>
									<td class="td_2">医保号</td>
									<td class="td_3"><input type="text" id="hin" name="hin"
										value="${patient.hin }"></td>
									<td class="td_2">文化程度</td>
									<td class="td_3"><select id="education" name="education"
										style="width: 100%">
											<option value="0">小学</option>
											<option value="1">初中</option>
											<option value="2">高中</option>
											<option value="3">大学或以上</option>
									</select></td>
								</tr>
								<tr>
									<td class="td_2">出生地址</td>
									<td colspan="5"><input type="text" id="address"
										name="address" size="90%" value="${patient.birAddress}"></td>
								</tr>
								<tr>
									<td class="td_2">现住地址</td>
									<td colspan="5"><input type="text" id="naddress"
										name="naddress" size="90%" value="${patient.address}"></td>
								</tr>
								<tr>
									<td class="td_2">工作单位</td>
									<td colspan="5"><input type="text" id="company"
										name="company" size="90%" value="${patient.company}"></td>
								</tr>
								<tr>
									<td class="td_2">联系电话</td>
									<td class="td_3"><input type="text" id="tele" name="tele"
										value="${patient.tele }" onblur="checktele()"> <span
										id="tiptele" data-tipso=""></span></td>
									<td class="td_2">邮址</td>
									<td class="td_3"><input type="text" id="email"
										name="email" onblur="checkemail()"> <span
										id="tipemail" data-tipso=""></span></td>
								</tr>
								<tr>
									<td>医院</td>
									<td><select name="hospital_id" id="hospital" value="${patient.hospital.name }"
										onchange="getDoctor()">
											<option value="-1">请选择</option>
											<c:forEach items="${hospitals}" var="item">
												<option value='${item.id}'>${item.name}</option>
											</c:forEach>
									</select></td>
									<td>医生</td>
									<td><select name="doctor_id" id="Doctor" >
											<option value="-1">请选择</option>
											<c:forEach items="${doctors}" var="item">
												<option value='${item.id}'>${item.hospital.name}:${item.realname}</option>
											</c:forEach>
									</select> <!--  <input type="text" id="doctor_id" name="doctor_id" /> -->
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="6" class="td_1">家庭成员一</td>
								</tr>
								<tr>
									<td class="td_2">家属姓名</td>
									<td class="td_3"><input type="text" id="fname1"
										name="fname1" value="${patient.familyByFamlily1.name}">
									</td>
									<td class="td_2">关系</td>
									<td class="td_3"><input type="text" id="relationship1"
										name="relationship1"
										value="${patient.familyByFamlily1.relation}"></td>
									<td class="td_2">家属电话</td>
									<td class="td_3"><input type="text" id="tele1"
										name="tele1" value="${patient.familyByFamlily1.tele}">
									</td>
								</tr>
								<tr>
									<td class="td_2">地址</td>
									<td colspan="5"><input type="text" id="faddress1"
										name="faddress1" size="90%" value="${patient.familyByFamlily1.address}"></td>
								</tr>
								<tr>
									<td class="td_2">邮址</td>
									<td colspan="5"><input type="text" id="femail1"
										name="femail1" size="90%" value="${patient.familyByFamlily1.email}"></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="6" class="td_1">家庭成员二</td>
								</tr>
								<tr>
									<td class="td_2">家属姓名</td>
									<td class="td_3"><input type="text" id="fname2"
										name="fname2" value="${patient.familyByFamlily2.name}">
									</td>
									<td class="td_2">关系</td>
									<td class="td_3"><input type="text" id="relationship2"
										name="relationship2"
										value="${patient.familyByFamlily2.relation}"></td>
									<td class="td_2">家属电话</td>
									<td class="td_3"><input type="text" id="tele2"
										name="tele2" value="${patient.familyByFamlily2.tele}">
									</td>
								</tr>
								<tr>
									<td class="td_2">地址</td>
									<td colspan="5"><input type="text" id="faddress2"
										name="faddress2" size="90%" value="${patient.familyByFamlily2.address}"></td>
								</tr>
								<tr>
									<td class="td_2">邮址</td>
									<td colspan="5"><input type="text" id="femail2"
										name="femail2" size="90%" value="${patient.familyByFamlily2.email}"></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>

								<tr>
									<td colspan="6" class="td_1">病历信息</td>
								</tr>
								<tr>
									<td>高血压</td>
									<td><input type="checkbox" name="htnstate" /></td>
									<td>高血糖</td>
									<td><input type="checkbox" name="glustate" /></td>
									<td>高血脂</td>
									<td><input type="checkbox" name="hplstate" /></td>
								</tr>
								<tr>
									<td id="class">患病史</td>
									<td colspan="5"><input type="text" id="his_1"
										name="illnesshistory" size="90%"
										value="${patient.illnessHis }"></td>
								</tr>
								<tr>
									<td class="td_2">过敏史</td>
									<td colspan="5"><input type="text" id="his_2"
										name="allergichistory" size="90%"
										value="${patient.allergicHis }"></td>
								</tr>
								<tr>
									<td class="td_2">家族病史</td>
									<td colspan="5"><input type="text" id="his_3"
										name="familymedicalhistory" size="90%"
										value="${patient.familyHis }"></td>
								</tr>
							</table>
							<input type="hidden" name="patient_id" value="${patient.id}">
							<div class="fbl2">
								<input class="fb" type="submit" value="修改"> <input
									class="fb" type="reset" value="重置"> <input class="fb"
									type="button" value="取消" onClick="">
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
