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
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>


</head>

<style>
.center_content  iframe{
	width:950px;
	border:1px;
	scroll:auto;
	border-left:0px;
	float:left
}
</style>


<body>

	<div id="wrap">
		<div class="top_corner"></div>
			<div id="main_container">
				
				
				<%@include file="top.jsp"%>
				
				<div class="center_content">
				<div id="outpat">
					<div id="pat">
						<form id="register_doctor" name="register_doctor"
							action="doctor/register.do" method="post"
			                onsubmit="return checkdoctor()">
							<table border="0" cellspacing="2px" cellpadding="2px">
								<tr>
									<td colspan="6" class="td_1">医生注册</td>
								</tr>
								<tr><td>&nbsp; </td></tr>
								<tr>
									<td class="td_2">用户名</td>
			
									<td><input type="text" id="username" name="username"
										onblur="checkusername()" /> <span id="tipusername" data-tipso=""></span>
									</td>
									<td>密码</td>
									<td><input type="password" id="fpassword" name="password"
										onblur="checkpassword()" /> <span id="tipfpassword"
										data-tipso=""></span>
									</td>
									<td colspan="2" rowspan="6" align="center">
										<div id="preview">
			            					<img id="imghead" width=100 height=125 border=0 src='<%=request.getContextPath()%>/picture/pic_user.gif'/>
			        					</div>
			        					<div style="margin-top:3px;margin-left:3px;">
			        						<a href="javascript:;" class="file">选择文件
			    								<input type="file" name="" id="" onchange="previewImage(this)">
											</a>
			        					</div>
									</td>
								</tr>
			
								<tr>
									<td>确认密码</td>
									<td><input type="password" id="spassword"
										onblur="rcheckpassword()" /> <span id="tipspassword"
										data-tipso=""></span>
									</td>
									<td class="td_2">姓名</td>
									<td class="td_3"><input type="text" id="realname"
										name="realname" onblur="checkrealname()" /> <span
										id="tiprealname" data-tipso=""></span>
									</td>
								</tr>
								
								<tr>
									<td class="td_2">性别</td>
									<td class="td_3"><select id="gender" name="gender">
											<option value="male">男</option>
											<option value="female">女</option>
									</select></td>
									<td class="td_2">民族</td>
									<td class="td_3"><input type="text" id="nation" name="nation"
										onblur="checknation()"> <span id="tipnation"
										data-tipso=""></span>
									</td>
								</tr>
								<tr>
									<td class="td_2">年龄</td>
									<td class="td_3"><input type="text" id="age" name="age"
										onblur="checkage()"><span id="tipage" data-tipso=""></span>
									</td>
									<td class="td_2">身份证</td>
									<td class="td_3"><input type="text" id="id2" name="id2"
									onblur="checkidcard()"> <span id="tipidcard" data-tipso=""></span>
									</td>
								</tr>
								<tr>
									<td class="td_2">现住地址</td>
									<td colspan="5"><input type="text" id="naddress"
										name="naddress" size="62%" value="无">
									</td>
								</tr>
								<tr>
									<td class="td_2">工作方向</td>
									<td colspan="5"><input type="text" id="" name="profession"
										size="62%" value="无">
									</td> 
								</tr>
								<tr>
			
									<td class="td_2">联系电话</td>
									<td class="td_3"><input type="text" id="tele" name="tele"
										onblur="checktele()"><span id="tiptele" data-tipso=""></span>
									</td>
									<td class="td_2">联系邮箱</td>
									<td class="td_3"><input type="text" id="mail" name="mail"
										onblur="checkemail()"> <span id="tipmail" data-tipso=""></span>
			
									</td>
									<td id="class">所属医院</td>
									<td colspan="5"><select name="hospital_id">
											<c:forEach items="${hospitals }" var="item">
												<option value="${item.id }">${item.name }</option>
											</c:forEach>
									</select> 
									<!--  <input type="text" id="hospital" name="hospital_id" size="90%"> -->
									</td>
								</tr>
								<tr>
									<td class="td_2">行医编号</td>
									<td colspan="5"><input type="text" id="certificate"
										name="certificate" onblur="checkcer()" size="90%"><span
										id="tipcer" data-tipso=""></span></td>
								</tr>
								<tr>
									<td class="td_2">所属科</td>
									<td colspan="5"><input type="text" id="belongdepart"
										name="belongdepart" onblur="checkbel()" size="90%"><span
										id="tipbel" data-tipso=""></span></td>
								</tr>
								<tr>
									<td class="td_2" rowspan="5">自我介绍</td>
								</tr>
							</table>
							<textarea class="textarea1" >无</textarea>
							<div class="fbl2">
								<input class="fb" type="submit" value="提交"> <input
									class="fb" type="reset" value="重置"> <input class="fb"
									type="button" value="取消" onclick="location.href='main/main.jsp'">
							</div>
						</form>
					</div>
				</div>
				</div>
				
				<%@include file="bottom.jsp"%>
				
			</div>
		</div>
		<script>
	function isexitname()
	{
		var value1=document.getElementById("username").value;
			$.post('doctor/isExistName.do',{username:value1},function(data){
	        	if(data=="true")
	        	alert("用户名已存在")
			});
	}
	
	function isExistIdNumber()
	{
		var value1=document.getElementById("id2").value;
			$.post('doctor/isExistIdNumber.do',{idNumber:value1},function(data){
				if(data=="true")
	        	alert("身份证已存在");
			});
	}
</script>
</body>
</html>
