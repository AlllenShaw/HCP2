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

<title>慢病诊治</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/manbingzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>
</head>
<body onload="huanzhexinxiload()">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m2").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu1.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">

				<table border="1">
					<tr>
						<td><input type="text" value="输入病人信息查找" id="searchinfo" onclick="searchFrame()"></input>
						</td>
						<td><input type="button" value="查找"
							onclick="searchcpatient()" />
						</td>
					</tr>
				</table>
				<div class="fold">
					搜索结果<label class="foldlabelon" 
					onclick="showinfo('betable',this)"></label>
				</div>
				<table id="betable" class="liebiaotable" style="display:none">
					<thead>
						<tr style="display:none">
							<td>搜索结果</td>
							<td></td>
							<td><input value="返回" type="button" onclick=""
								style="width: 95%" />
							</td>
						</tr>
						<tr>
							<td class="td_1">ID</td>
							<td class="td_1">姓名</td>
							<td class="td_2"></td>
						</tr>
					</thead>
					<tr style="display: none">
						<td><input type="text" readonly="readonly" style="width: 95%" />
						</td>
						<td><input type="text" readonly="readonly" style="width: 95%" />
						</td>

						<td><input type="button" onclick="deleteThisRow(this)"
							name="delete" value="删除" />
						</td>
					</tr>
				</table>
				<div class="fold">
					名下病人<label class="foldlabeloff" 
					onclick="showinfo('aftable',this)"></label>
				</div>
				<table id="aftable" class="liebiaotable">
					<thead>
						<tr style="display:none">
							<td>名下病人</td>
						</tr>
						<tr>
							<td class="td_1">ID</td>
							<td class="td_1">姓名</td>
							<td class="td_2"></td>
						</tr>
					</thead>
					<tr style="display: none">
						<td><input type="text" readonly="readonly" style="width: 95%" />
						</td>
						<td><input type="text" readonly="readonly" style="width: 95%" />
						</td>

						<td><input type="button" onclick="deleteThisRow(this)"
							name="delete" value="删除" />
						</td>
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