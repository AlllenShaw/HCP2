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
<title>血脂预警</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/foldstyle.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-jqChart-min.js"></script>
<script type="text/javascript" src="js/fuzhuzhenzhi.js"></script>
</head>
<script>
	
</script>
<body onload="xuezhiload()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m4").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu3.jsp"%>
				<script>
					document.getElementById("sm3").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>

			</div>
			<div id="right">
				<div id="liebiao">
					<div class="fold">
						名下病人<label class="foldlabeloff"
							onclick="showinfo('aftable',this)"></label>
					</div>
					<table id="aftable" class="liebiaotable">
						<thead>
							<tr>
								<td class="td_1">ID</td>
								<td class="td_1">姓名</td>
								<td class="td_2"></td>
							</tr>
						</thead>
						<tr style="display: none">
							<td><input type="text" readonly="readonly"
								style="width: 95%" /></td>
							<td><input type="text" readonly="readonly"
								style="width: 95%" /></td>

							<td><input type="button" onclick="" value=""
								style="width: 95%" />
							</td>
						</tr>
					</table>
				</div>

				<div id="chartframe" style="display:none">
				<div class="fold">
						血脂预警信息<label class="foldlabelback"
							onclick="backtolist('liebiao','chartframe')"></label>
					</div>
					<table class="liebiaotable">
							<tr>
								<td class="td_6">ID：</td><td><input id="tid" type="text" readonly="readonly"
								style="width: 95%" /></td>
								<td class="td_6">姓名：</td>
							<td><input id="tname" type="text" readonly="readonly"
								style="width: 95%" /></td>
						</tr>
						<tr id="nore">
							<td colspan="5" style="text-align:center;">没有该项数据</td>
						</tr>
					</table>
					
					<div id="jqChart"></div>
				</div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
