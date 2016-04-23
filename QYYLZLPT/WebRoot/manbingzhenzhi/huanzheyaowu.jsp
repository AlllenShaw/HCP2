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

<title>患者用药查询</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<link href="css/manbingzhenzhi.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/manbingzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>
</head>
<body onload="huanzheyongyaoload()">
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
						<tr>
							<td class="td_1">ID</td>
							<td class="td_1">姓名</td>
							<td class="td_2"></td>
						</tr>
						<tr style="display:none">
							<td class="td_1">123</td>
							<td class="td_1">hello</td>
							<td class="td_2"><input type="button" value="信息" onclick=""></input>
							</td>
						</tr>
					</table>
				</div>

				<div id="detailframe" style="display:none">
					<div class="fold">
						患病用药情况<label class="foldlabelback"
							onclick="backtolist('liebiao','detailframe')" ></label>
					</div>
					<table class="liebiaotable">
						<tr>
							<td class="td_6">ID：</td>
							<td><input id="tid" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
							<td class="td_6">姓名：</td>
							<td><input id="tname" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
						</tr>
					</table>
					<div id="drugframe">
						<div class="fold">
							最近用药<label class="foldlabeloff" 
								onclick="showinfo('drugtable',this)" ></label>
						</div>
						<table id="drugtable" class="liebiaotable">
							<tr>
								<td class="ywtd">药物ID</td>
								<td class="ywtd">名字</td>
								<td class="ywtd">用药时间</td>
								<td class="ywtd">服用方式</td>
								<td class="ywtd">服用量</td>
							</tr>
							<tr style="display:none">
								<td class="ywtd">29094-61-9</td>
								<td class="ywtd">格列吡嗪片</td>
								<td class="ywtd">2015-5-4-20:20</td>
								<td class="ywtd">口服</td>
								<td class="ywtd">2ml</td>
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