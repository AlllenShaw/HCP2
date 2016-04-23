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
<title>协同诊治用户管理</title>
<base href="<%=basePath%>"></base>

<meta http-equiv="pragma" content="no-cache">
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bingrenliebiao.css" type="text/css"></link>
<link rel="stylesheet" href="css/xietongzhenzhianquan.css" type="text/css"></link>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>

<script type="text/javascript" src="js/xietongzhenzhianquan.js"></script>

</head>
<body onload="bodyload('yh')">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_hosadmin.jsp"%>
			<script>
				document.getElementById("m6").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu5.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div class="outrenyuan">
					<div class="as" style="margin-top:10px;margin-left:30px;">
						<label>当前医院:</label><label id="sehos"></label> <input
							type="hidden" id="sehosinp" />
					</div>
					<div class="fold">
						用户管理<label class="foldlabeloff" onclick="showinfo('aftable',this)"></label>
					</div>					<div class="renyuan">
						
						<table id="aftable" class="liebiaotable">
							<thead>
								<tr style="display:none">
									<td></td>
								</tr>
								<tr>
									<td class="td_1">ID</td>
									<td class="td_1">姓名</td>
									<td class="td_2"></td>
								</tr>
							</thead>
							<tr style="display: none">
								<td><input id="patient_id" type="text" readonly
									style="width: 95%" />
								</td>
								<td><input id="patient_name" type="text"
									readonly="readonly" style="width: 95%" />
								</td>
								<td><input type="button" onclick="deleteThisRow(this)"
									name="delete" value="删除" />
								</td>
							</tr>

						</table>

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
