<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>"></base>

<title>首页</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<script src="js/index.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

</head>
<body onload="recePic()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m1").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
				<div id="midindex">

			<div id="picarea">
				<div id="pic">
					<ul>
						<li id="imgbj_1"><img src="picture/bj_1.gif" width="400px"
							height="250px" /></li>
						<li id="imgbj_2"><img src="picture/bj_2.gif" width="400px"
							height="250px" /></li>
						<li id="imgbj_3"><img src="picture/bj_3.gif" width="400px"
							height="250px" /></li>
						<li id="imgbj_4"><img src="picture/bj_4.gif" width="400px"
							height="250px" /></li>
					</ul>
				</div>

				<div id="piclist">
					<label id="imgtext">风景</label>
					<ul id="imgid">
						<li id="bj_1" class="picList"
							onmouseover="changePic(this.id,'心理健康');">1</li>
						<li id="bj_2" class="picList"
							onmouseover="changePic(this.id,'风景');">2</li>
						<li id="bj_3" class="picList"
							onmouseover="changePic(this.id,'运动');">3</li>
						<li id="bj_4" class="picList"
							onmouseover="changePic(this.id,'学习压力');">4</li>
					</ul>
					<div style="display:none">
					<input id="tbj_1" type="hidden" value="心理健康"/>
					<input id="tbj_2" type="hidden" value="风景"/>
					<input id="tbj_3" type="hidden" value="运动"/>
					<input id="tbj_4" type="hidden" value="学习压力"/>
					</div>
				</div>
			</div>
			<div id="illustration">
				<%@include file="content.jsp"%>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>

</body>
</html>