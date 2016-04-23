<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>
<title>人员管理</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<link href="css/supadmin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/supadmin.js"></script>
</head>
<script>
	
</script>
<body onload="hosload()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_supadmin.jsp"%>
			<script>
				document.getElementById("m2").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenuex.jsp"%>
				<script>
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div id="outtopframe">
					<div>
						<label>选择医院:</label> <select id="sechos"
							style="width:285px;margin-top:10px;" onchange="hosinfo()">
						</select>
					</div>
					<div id="outhosframe">
						<div class="ti">医院信息</div>
						<div id="hosframe">
							<div class="as">
								<label>医院ID：</label><input class="ip" type="text"
									id="hospital_id" readonly>
							</div>
							<div class="as">
								<label>医院名字：</label><input class="ip" type="text"
									id="hospital_name" readonly>
							</div>
							<div class="as">
								<label>医院地址：</label><input class="ip" type="text"
									id="hospital_address" readonly>
							</div>

							<div class="as">
								<label>医院级别：</label><input class="ip" type="text"
									id="hospital_level" readonly>
							</div>
							<div class="fbl">
								<input type="button" value="添加医院管理员" onclick="showaddframe()">
							</div>
						</div>
					</div>
					<div id="outaddframe" style="display:none">
						<form action="admin/addHosAdmin.do" method="post">
							<div class="ti">
								<label>添加管理员：</label>
							</div>
							<div id="addframe">
								<div class="as" style="display:none">
									<label>医院ID：</label><input id="hospitalidinp" class="ip"
										type="text" name="hospital_id">
								</div>
								<div class="as">
									<label>用戶名：</label><input class="ip" type="text"
										name="username">
								</div>

								<div class="as">
									<label>密码：</label><input class="ip" type="password"
										name="password">
								</div>
								<div class="as">
									<label>确认密码：</label><input class="ip" type="password">
								</div>

								<div class="as">
									<label>邮箱：</label><input class="ip" type="text" name="mail">
								</div>
								<div class="as">
									<label>联系电话：</label><input class="ip" type="text" name="tele">
								</div>
								<div class="fbl">
									<input class="" type="submit" value="确定">
								</div>
							</div>
						</form>
					</div>


				</div>
				<div>
                <div class="fold">
						医院管理员<label class="foldlabeloff" onclick="showinfo('aftable',this)"></label>
					</div>
					<table id="aftable" border="1" style="width:700px;">
						<thead>
							<!-- td><input value="返回" type="button" onclick="backsearch()"
									style="width: 95%" /></td> -->
							<tr>
								<td class="td_1">ID</td>
								<td class="td_1">姓名</td>
								<td class="td_2"></td>
							</tr>
						</thead>
						<tr style="display: none">
							<td><input id="" type="text" readonly
								style="width: 95%" /></td>
							<td><input id="" type="text" readonly
								style="width: 95%" /></td>
							<td><input type="button" onclick="" name="delete" value="删除" />
							</td>
						</tr>
					</table>
				</div>

				<div id="outdetailframe"  style="display:none">

					<div class="ti">
						<label>管理员信息：</label>
					</div>
					<div id="detailframe">
						<div class="as">
							<label>ID：</label><input id="detid" class="ip" type="text"
								readonly="readonly">
						</div>
						<div class="as">
							<label>用戶名：</label><input id="detusername" class="ip" type="text"
								readonly="readonly">
						</div>
						<div class="as">
							<label>密码：</label><input id="detpassword" class="ip" type="text"
								readonly="readonly">
						</div>
						<div class="as">
							<label>邮箱：</label><input id="detmail" class="ip" type="text"
								readonly="readonly">
						</div>
						<div class="as">
							<label>联系电话：</label><input id="dettele" class="ip" type="text"
								readonly="readonly">
						</div>
						<div class="as">
							<input class="" type="button" value="返回" onclick="addadminback()">
						</div>
					</div>
				</div>



			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
