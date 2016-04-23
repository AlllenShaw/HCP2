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
<title>药物实验室</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/foldstyle.js"></script>
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-jqChart-min.js"></script>
<script type="text/javascript" src="js/fuzhuzhenzhi.js"></script>
<script type="text/javascript" src="js/yaowushiyanshi.js"></script>
</head>
<script>
	
</script>
<body onload="yaowu()">
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
					document.getElementById("sm4").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>

			</div>
			<div id="right">
				<div class="fold">
					药物对比<label class="foldlabeloff" onclick="showinfo('liebiao',this)"></label>
				</div>
				<div id="liebiao">
				<div style="margin-left:20px;margin-top:5px;">
					选择药品类型：<select id="drugtype" onchange="yaowu()">
						<option value="1">血压</option>
						<option value="2">血糖</option>
						<option value="3">血脂</option>
					</select>
				</div>
				<div>
					<div style="margin-left:20px;margin-top:5px;">
						选择药品：<select id="druga">
						</select>-<b>A</b>-<input  type="button" value="对比" onclick="compare()"/>-<b>B</b>-<select id="drugb">
						</select>
					</div>
				</div>
				</div>
				<div class="fold">
					对比结果<label class="foldlabeloff" onclick="showinfo('jqChart',this)"></label>
				</div>
				<div id="jqChart"></div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
