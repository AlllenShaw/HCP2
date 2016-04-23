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

<title>区域统一挂号</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>
</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m3").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>

		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu2.jsp"%>
				<script>
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">

				<table border="1">
					<tr>
						<td style="width:100px"><p>医院</p></td>
						<td style="width:100px"><p>当前挂号人数</p></td>
						<td style="width:100px"></td>
					</tr>
					<tr>
						<td><p>A医院</p></td>
						<td>20</td>
						<td><input type="button" value="挂号" /></td>
					</tr>
					<tr>
						<td><p>B医院</p></td>
						<td>19</td>
						<td><input type="button" value="挂号" /></td>

					</tr>
					<tr>
						<td><p>C医院</p></td>
						<td>18</td>
						<td><input type="button" value="挂号" /></td>

					</tr>
					<tr>
						<td><p>D医院</p></td>
						<td>17</td>
						<td><input type="button" value="挂号" /></td>
					</tr>
				</table>

			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>
</body>
</html>