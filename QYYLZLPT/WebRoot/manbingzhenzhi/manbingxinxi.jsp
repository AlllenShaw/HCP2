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

<title>慢病信息</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<link href="css/manbingzhenzhi.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/manbingzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>
</head>
<body onload="manbingxinxiload()">
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
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div id="liebiao">
					<div class="fold">
						名下病人<label class="foldlabeloff" onclick="showinfo('aftable',this)"></label>
					</div>
					<table id="aftable" class="liebiaotable">
						<tr style="display:none"></tr>
						<tr>
							<td class="td_1">ID</td>
							<td class="td_1">姓名</td>
							<td class="td_2"></td>
						</tr>
						<tr style="display: none">
							<td class="td_1"></td>
							<td class="td_1"></td>
							<td class="td_2"><input type="button" value="信息" id="detail"
								onclick=""></input>
							</td>
						</tr>
					</table>
				</div>
				<div id="detailframe" style="display:none">
					<form action="doctor/updateManBing.do" method="post">
						<div class="fold">
							慢病信息<label class="foldlabelback"
								onclick="backtolist('liebiao','detailframe')"></label>
						</div>
						<table class="liebiaotable">
							<tr>
								<td class="td_6">ID：</td>
								<td><input id="tid" name="patient_id" type="text" readonly="readonly"
									style="width: 95%" /></td>
								<td class="td_6">姓名：</td>
								<td><input id="tname" type="text" readonly="readonly"
									style="width: 95%" /></td>
							</tr>
						</table>
						<div id="xtfold" class="fold">
							<!-- 血糖<label id="xtlab" class="foldlabelon"
								onclick="showinfo('xuetangframe',this)"></label> -->
						</div>
						<table id="noxuetangframe" class="liebiaotable"
							style="display:none">
							<caption>没有该项数据---展开添加<label class="foldlabelon"
								onclick="showinfo('xuetangframe',this)"></label></caption>
						</table>
						<table id="xuetangframe" class="liebiaotable" style="display:none">
							<caption>
								上次更新时间<input type="text" id="glu_upgradetime"
									readonly="readonly" />
							</caption>

							<tr>
								<td class="itemtitle">项目</td>
								<td class="itemvalue">期望最大值</td>
								<td class="itemvalue">期望最小值</td>
							</tr>
							<tr>
								<td class="itemtitle">血糖</td>
								<td class="itemvalue"><input id="blood_glucose_max"
									name="bloodGlucoseMax" type="text" class="inputclass3" />
								mmol/L</td>
								<td class="itemvalue"><input id="blood_glucose_min"
									name="bloodGlucoseMin" type="text" class="inputclass3" />
								mmol/L</td>
							</tr>


						</table>
						<div id="xyfold" class="fold">
							<!-- 血压<label class="foldlabelon" onclick="showinfo('xueyaframe',this)"></label>
						 -->
						</div>
						<table id="noxueyaframe" class="liebiaotable" style="display:none">
							<caption>没有该项数据---展开添加<label class="foldlabelon"
								onclick="showinfo('xueyaframe',this)"></label></caption>
						</table>
						<table id="xueyaframe" class="liebiaotable" style="display:none">
							<caption>
								上次更新时间<input type="text" id="htn_upgradetime"
									readonly="readonly" />
							</caption>
							<tr>
								<td class="itemtitle">项目</td>
								<td class="itemvalue">期望最大值</td>
								<td class="itemvalue">期望最小值</td>
							</tr>
							<tr>
								<td class="itemtitle">收缩压</td>
								<td class="itemvalue"><input id="systolic_pressure_max"
									name="systolicPressureMax" type="text" class="inputclass3" />
								mmHg</td>
								<td class="itemvalue"><input id="systolic_pressure_min"
									name="systolicPressureMin" type="text" class="inputclass3" />
								mmHg</td>
							</tr>
							<tr>
								<td class="itemtitle">舒张压</td>
								<td class="itemvalue"><input id="diastolic_pressure_max"
									name="diastolicPressureMax" type="text" class="inputclass3" />
								mmHg</td>
								<td class="itemvalue"><input id="diastolic_pressure_min"
									name="diastolicPressureMin" type="text" class="inputclass3" />
								mmHg</td>
							</tr>
							<tr>
								<td class="itemtitle">心率</td>
								<td class="itemvalue"><input id="heart_rate_max"
									name="heartRateMax" type="text" class="inputclass3" />
								次/分</td>
								<td class="itemvalue"><input id="heart_rate_min"
									name="heartRateMin" type="text" class="inputclass3" />
								次/分</td>
							</tr>
						</table>
						<div id="xzfold" class="fold">
							<!-- 血脂<label class="foldlabelon" onclick="showinfo('xuezhiframe',this)"></label>
						 -->
						</div>
						<table id="noxuezhiframe" class="liebiaotable"
							style="display:none">
							<caption>没有该项数据---展开添加<label class="foldlabelon"
								onclick="showinfo('xuezhiframe',this)"></label></caption>
						</table>
						<table id="xuezhiframe" class="liebiaotable" style="display:none">
							<caption>
								上次更新时间<input type="text" id="hpl_upgradetime"
									readonly="readonly" />
							</caption>
							<tbody>
                           		<tr>
									<td class="itemtitle">项目</td>
									<td class="itemvalue">期望最大值</td>
									<td class="itemvalue">期望最小值</td>
								</tr>
								<tr>
									<td class="itemtitle">总胆固醇值</td>
									<td class="itemvalue"><input id="tc_max" name="tcMax"
										type="text" class="inputclass3" />
									mmol/L</td>
									<td class="itemvalue"><input id="tc_min" name="tcMin"
										type="text" class="inputclass3" />
									mmol/L</td>
								</tr>
								<tr>
									<td class="itemtitle">甘油三酯值</td>
									<td class="itemvalue"><input id="tg_max" name="tgMax"
										type="text" class="inputclass3" />
									mmol/L</td>
									<td class="itemvalue"><input id="tg_min" name="tgMin"
										type="text" class="inputclass3" />
									mmol/L</td>
								</tr>
								<tr>
									<td class="itemtitle">高密度脂蛋白胆固醇值</td>
									<td class="itemvalue"><input id="hdl_max" name="hdlMax"
										type="text" class="inputclass3" />
									mmol/L</td>
									<td class="itemvalue"><input id="hdl_min" name="hdlMin"
										type="text" class="inputclass3" />
									mmol/L</td>
								</tr>
								<tr>
									<td class="itemtitle">低密度脂蛋白胆固醇值</td>
									<td class="itemvalue"><input id="ldl_max" name="ldlMax"
										type="text" class="inputclass3" />
									mmol/L</td>
									<td class="itemvalue"><input id="ldl_min" name="ldlMin"
										type="text" class="inputclass3" />
									mmol/L</td>
								</tr>
							</tbody>
						</table>
						<input type="hidden" name="doctor_id" value="${userid }"/>
						<div class="mbfblist">
							<input value="修改" type="submit" /> <input value="重置"
								type="reset" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>