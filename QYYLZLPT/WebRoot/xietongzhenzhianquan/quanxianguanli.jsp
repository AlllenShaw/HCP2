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
<title>协同诊治功能权限管理</title>
<base href="<%=basePath%>"></base>

<meta http-equiv="pragma" content="no-cache">
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/xietongzhenzhianquan.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/xietongzhenzhianquan.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

</head>
<body onload="bodyload('qx')">
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_hosadmin.jsp"%>
			<script>
				document.getElementById("m6").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu5.jsp"%>
				<script>
					document.getElementById("sm2").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">

				<div id="subleft">
					<div class="selist">
						<label>所属医院:</label> <label id="sehos"></label> <input
							type="hidden" id="sehosinp" />
						<!-- <select id="sehos" class="se">
							<option>A医院</option>
							<option>B医院</option>
							<option>C医院</option>
							<option>D医院</option> 

						</select> -->
					</div>
					<div class="selist">
						<label>选择人员:</label> <select id="sedoc" class="se"
							onchange="checkright()">
							<!-- <option onclick="seardoc('a')">A</option>
							<option onclick="seardoc('b')">B</option>
							<option onclick="seardoc('c')">C</option>
							<option onclick="seardoc('d')">D</option> -->
						</select>
					</div>
					<div id="rilist">
						<div id="r0" class=riglist onclick="show(this,'right0')">慢病诊治管理</div>
						<div id="r1" class=riglist onclick="show(this,'right1')">协同诊治管理</div>
						<div id="r2" class=riglist onclick="show(this,'right2')">辅助诊治管理</div>
						<div id="r3" class=riglist onclick="show(this,'right3')">协同诊治资源管理</div>
						<div id="r4" class=riglist onclick="show(this,'right4')">协同诊治安全管理</div>
						<div class="rlb">
							<input type="button" value="保存" onclick="savechange()" /> <input
								type="button" value="取消" onclick="" />
						</div>
					</div>

				</div>
				<div id="subright">
					<div id="right0" style="display:none">
						<p class="subti">慢病诊治管理</p>
						<div class="rightitem">
							<input type="checkbox" id="a0" /><label>慢病诊治</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a1" /><label>慢病信息管理</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a2" /><label>查看慢病病人信息</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a3" /><label>患者信息管理</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a4" /><label>添加慢病病人</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a5" /><label>查找病人</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a6" /><label>查看慢病病人用药</label>
						</div>

						<div class="rightitem">
							<input type="checkbox" id="a7" /><label>患病用药管理</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="a8" /><label>修改慢病信息</label>
						</div>

						<div class="rightitem" style="visibility:hidden">
							<input type="checkbox" id="a9" /><label>删除药物库药物</label>
						</div>
						<div class="rightitem" style="visibility:hidden">
							<input type="checkbox" id="a10" /><label>查看慢病病人列表</label>
						</div>
						<div class="rightitem" style="visibility:hidden">
							<input type="checkbox" id="a11" /><label>查看药物库药物列表</label>
						</div>

					</div>
					<div id="right1" style="display:none">
						<p class="subti">协同诊治管理</p>
						<div class="rightitem">
							<input type="checkbox" id="b3" /><label>查看电子档案</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="b2" /><label>查看病人病历</label>
						</div>
						<div class="rightitem" style="visibility:hidden">
							<input type="checkbox" id="b0" style="visibility:hidden" /><label>添加病人病历</label>
						</div>
						<div class="rightitem" style="visibility:hidden">
							<input type="checkbox" id="b1" /><label>删除病人病历</label>
						</div>



					</div>
					<div id="right2" style="display:none">
						<p class="subti">辅助诊治管理</p>
						<div class="rightitem">
							<input type="checkbox" id="c0" /><label>药物实验室 </label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="c1" /><label>血压预警</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="c2" /><label>血糖预警</label>
						</div>
						<div class="rightitem">
							<input type="checkbox" id="c3" /><label>血脂预警</label>
						</div>

					</div>
					<div id="right3" style="display:none">
						<p class="subti">未开放</p>

					</div>
					<div id="right4" style="display:none">
						<p class="subti">未开放</p>
					</div>
					<div></div>
				</div>
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>

		</div>
	</div>
</body>
</html>
