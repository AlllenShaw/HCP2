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

<link href="css/manbingzhenzhi.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/manbingzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
</head>
<body onload="yaowuliebiaoload()">
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
					document.getElementById("sm4").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div id="liebiao">
					<div class="fold">
						药物列表<label class="foldlabeloff" onclick="showinfo('aftable',this)"></label>
					</div>
					<table id="aftable" class="liebiaotable">
						<tr>
							<td class="td_1">药物ID</td>
							<td class="td_1">名字</td>
							<td class="td_1">类型</td>
							<td class="td_2">类型</td>
						</tr>
						<tr style="display:none">
							<td class="td_1"></td>
							<td class="td_1"></td>
							<td class="td_1"></td>
							<td class="td_2"><input type="button" value="信息" onclick=""></input>
							</td>
						</tr>
					</table>
					<div id="addframe">
						<div class="fold">
							添加药物<label class="foldlabelon" onclick="showinfo('betable',this)"></label>
						</div>
						<form method="post" action="doctor/addMedicine.do">
							<table id="betable" class="liebiaotable" style="display:none">
								<tr>
									<td class="td_2">名字:</td>
									<td><input name="name" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="td_2">类型:</td>
									<!-- 1血压，2血糖，3血脂 -->
									<td><select name="type" style="width:90%">
											<option value="1">血压</option>
											<option value="2">血糖</option>
											<option value="3">血脂</option>
									</select>
									</td>
								</tr>
								<tr>
									<td class="td_2">效果:</td>
									<td><input name="effect" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">成分:</td>
									<td><input name="constituent" type="text"
										style="width:90%" /></td>
								</tr>

								<tr>
									<td class="">禁忌:</td>
									<td><input name="taboo" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">使用指引:</td>
									<td><input name="direction" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">服用方式:</td>
									<td><input name="takingType" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">服用量:</td>
									<td><input name="dosage" type="text" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">单位:</td>
									<td><input name="unit" type="text" readonly="readonly"
										style="width:90%" />
									</td>
								</tr>
								<tr>
									<td class="">服用时间:</td>
									<td><input name="takingTime" type="text"
										readonly="readonly" style="width:90%" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="提交"
										style="margin-left:290px;" /></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div id="detailframe" style="display:none">
					<div class="fold">
						药物<label class="foldlabelback"
							onclick="backtolist('liebiao','detailframe')"></label>
					</div>
					<table class="liebiaotable">
						<tr>
							<td class="td_6">药物ID：</td>
							<td><input id="tid" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
							<td class="td_6">名字：</td>
							<td><input id="tname" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
						</tr>
					</table>
					<div id="drugframe">
						<div class="fold">
							详细信息<label class="foldlabeloff"
								onclick="showinfo('drugtable',this)"></label>
						</div>
						<table id="drugtable" class="liebiaotable">
							<tr>
								<td class="td_2">类型:</td>
								<!-- 1血压，2血糖，3血脂 -->
								<td><input id="type" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="td_2">效果:</td>
								<td><input id="effect" type="text" style="width:90%" /></td>
							</tr>
							<tr>
								<td class="">成分:</td>
								<td><input id="constituent" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">禁忌:</td>
								<td><input id="taboo" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">使用指引:</td>
								<td><input id="direction" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">服用方式:</td>
								<td><input id="takingType" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">服用量:</td>
								<td><input id="dosage" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">单位:</td>
								<td><input id="unit" type="text" style="width:90%" />
								</td>
							</tr>
							<tr>
								<td class="">服用时间:</td>
								<td><input id="takingTime" type="text" style="width:90%" />
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