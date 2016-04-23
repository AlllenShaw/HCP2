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

<title>慢病药物</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/manbingzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
		//		document.getElementById("m2").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu1.jsp"%>
				<script>
			//		document.getElementById("sm5").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<!-- <div>
					<input type="button" value="添加药物" onclick="showtianjiayaowu()"></input>
					<div id=tianjiayaowuxinxi style="display:none">
						<table border="1">
							<tr>
								<td>CAS编号</td>
								<td><input type="text" /></td>
								<td>名字</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td>用药时间</td>
								<td><select>
										<option>餐前</option>
										<option>餐后</option>
								</select>
								</td>
								<td>次数</td>
								<td><input type="text" /></td>
								<td>服用量</td>
								<td><input type="text" /></td>
								<td><input type="button" value="添加" /></td>

							</tr>
						</table>
					</div>
				</div>
				<div id="title">
					<table id="yaowuliebiao" border="1">
						<tr>
							<td class="td_1">CAS编号</td>
							<td class="td_1">名字</td>
						</tr>
						<tr>
							<td class="td_1">29094-61-9</td>
							<td class="td_1">格列吡嗪片</td>
							<td class="td_2"><input type="button" value="信息" id="detail"
								onclick="showyaowuxinxi()"></input></td>
						</tr>
					</table>
				</div>
				<div id=subtitle style="display:none">
					<table border="1">
						<tr>
							<td class="td_1">CAS编号</td>
							<td class="td_1">名字</td>
						</tr>
						<tr>
							<td class="td_1">29094-61-9</td>
							<td class="td_1">格列吡嗪片</td>
							<td class="td_2"><input value="返回" type="button" onclick="back()"
									style="width: 95%" /></td>
						</tr>
					</table>
					<table border="1">
						<tr>
							<td>用药时间</td>
							<td><select>
									<option>餐前</option>
									<option>餐后</option>
							</select>
							</td>
							<td>次数</td>
							<td><input type="text" /></td>
							<td>服用量</td>
							<td><input type="text" /></td>
							<td><input type="button" value="修改" /></td>
							<td><input type="button" value="删除" /></td>
						</tr>
					</table>
				</div>-->
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>
</body>
</html>