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
<title>血压预警</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/foldstyle.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-jqChart-min.js"></script>
<script type="text/javascript" src="js/fuzhuzhenzhi_patient.js"></script>
</head>
<script>
	
</script>
<body onload="pxuetangdetail()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_patient.jsp"%>
			<script>
				document.getElementById("m4").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu3_patient.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>

			</div>
			<div id="right">
			<div class="fold">
						血糖预警信息<label class="foldlabeloff"
							onclick="showinfo('chartframe',this)"></label>
					</div>
				<div id="chartframe">
					<table class="liebiaotable">
						<tr>
							<td class="td_6">ID：</td>
							<td><input id="tid" type="text" readonly
								style="width: 95%" />
							</td>
							<td class="td_6">姓名：</td>
							<td><input id="tname" type="text" readonly
								style="width: 95%" />
							</td>
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
