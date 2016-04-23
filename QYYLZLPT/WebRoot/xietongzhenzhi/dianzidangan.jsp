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

<title>电子档案</title>
<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/bingrenliebiao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xietongzhenzhi.js"></script>
<script type="text/javascript" src="js/testing.js"></script>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/foldstyle.js"></script>

</head>
<body onload="liebiaoonload()">
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
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				<div id="liebiao">

					<table border="1">
						<tr>
							<td>选择医院</td>
                            <td id="hos" width="300px"><select id="sehos" style="width:100%">
							</select>
							</td>
							<td><input type="text" value="输入病人信息查找" id="searchinfo" onclick="searchFrame()"></input>
							</td>
							<td><input type="button" value="查找"
								onclick="searchpatient()" /></td>
						</tr>
					</table>
					<div class="fold">
						搜索结果<label class="foldlabelon" onclick="showinfo('betable',this)"></label>
					</div>
					<table id="betable" class="liebiaotable" style="display:none">
						<thead>
							<tr style="display:none">
								<td>搜索结果</td>
							</tr>
							<tr>
								<td class="td_1">ID</td>
								<td class="td_1">姓名</td>
								<td class="td_2"></td>
							</tr>
						</thead>
						<tr style="display: none">
							<td><input id="patient_id" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
							<td><input id="patient_name" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
							<td><input type="button" onclick="deleteThisRow(this)"
								name="delete" value="删除" />
							</td>
						</tr>

					</table>
					<div class="fold">
						名下病人<label class="foldlabeloff" onclick="showinfo('aftable',this)"></label>
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
							<td><input id="patient_id" type="text" readonly="readonly"
								style="width: 95%" />
							</td>
							<td><input id="patient_name" type="text" readonly="readonly"
								style="width: 95%" />
							</td>

							<td><input type="button" onclick="deleteThisRow(this)"
								name="delete" value="删除" />
							</td>
						</tr>
					</table>
				</div>
				<div id="dangan" style="display:none">
					<div class="fold">
						电子档案<label class="foldlabelback"
							onclick="backtolist('liebiao','dangan')"></label>
					</div>
					<table class="liebiaotable">
						<tr>
							<td class="td_6">ID：</td>
							<td><input id="tid" type="text" readonly="readonly"
								style="width: 95%" /></td>
							<td class="td_6">姓名：</td>
							<td><input id="tname" type="text" readonly="readonly"
								style="width: 95%" /></td>
						</tr>
					</table>
					<div id="frfold" class="fold">
						<!--  基本信息 <label class="foldlabelon"
							onclick="showinfo('fundationinfo',this)"></label>
							-->
					</div>
					<table id="nofrframe" class="liebiaotable" style="display:none">
						<caption>没有权限查看</caption>
					</table>
					<table id="fundationinfo" class="dzdatable" style="display:none">
						<tr>
							<td class="td_4">用户名：</td>
							<td class="td_5"><input type="text" id="username"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">性别：</td>
							<td class="td_5"><input type="text" id="gender"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">民族：</td>
							<td class="td_5"><input type="text" id="race"
								readonly="readonly" class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">年龄：</td>
							<td class="td_5"><input type="text" id="age"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">婚姻状况：</td>
							<td class="td_5"><input type="text" id="marriage"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">职业：</td>
							<td class="td_5"><input type="text" id="job"
								readonly="readonly" class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">现住地址：</td>
							<td colspan="5"><input type="text" id="address"
								readonly="readonly" class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">工作单位：</td>
							<td colspan="5"><input type="text" id="occupation"
								readonly="readonly" class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">联系电话：</td>
							<td class="td_5"><input type="text" id="tel_1"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">家属电话：</td>
							<td class="td_5"><input type="text" id="tel_2"
								readonly="readonly" class="inputclass1" />
							</td>
							<td class="td_4">家属电话：</td>
							<td class="td_5"><input type="text" id="tel_3"
								readonly="readonly" class="inputclass1" />
							</td>
						</tr>
					</table>
					<div id="hrfold" class="fold">
						<!--病历信息<label class="foldlabelon"
							onclick="showinfo('histories',this)"></label>
							-->
					</div>
					<table id="nohrframe" class="liebiaotable" style="display:none">
						<caption>没有权限查看</caption>
					</table>
					<table id="histories" class="dzdatable" style="display:none">
						<tr>
							<td class="td_6">患病史：</td>
							<td><input type="text" id="history_1" readonly="readonly"
								class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">过敏史：</td>
							<td><input type="text" id="history_2" readonly="readonly"
								class="inputclass1" />
							</td>
						</tr>
						<tr>
							<td class="td_4">家族病史：</td>
							<td><input type="text" id="history_3" readonly="readonly"
								class="inputclass1" />
							</td>
						</tr>
					</table>
					<div id="imgfold" class="fold"><!-- 
						临床数据<label class="foldlabelon"
							onclick="showinfo('imagearea',this)"></label>
							 -->
					</div>
					<div id="imagearea" style="display:none">

						<!-- <table id="noirframe" class="liebiaotable" style="display:none">
							<caption>没有权限查看</caption>
					</table> -->
						<div id="fold" class="subfold">
							临床数据--B超<label class="foldlabelon"
								onclick="showinfo('res_b',this)"></label>

						</div>
						<div class="detimg">
							<img class="detimage" id="res_b" src="" alt="不存在数据"
								onclick="window.open(this.src)"></img>
							<!-- picture/medicalpicture/b.jpg  -->
						</div>
						<div id="fold" class="subfold">
							临床数据--CT<label class="foldlabelon"
								onclick="showinfo('res_ct',this)"></label>
						</div>
						<div class="detimg">
							<img class="detimage" id="res_ct" src="" alt="不存在数据"
								onclick="window.open(this.src)"></img>
							<!-- picture/medicalpicture/ct.jpg  -->
						</div>
						<div id="fold" class="subfold">
							临床数据--MRI(核磁共振)<label class="foldlabelon"
								onclick="showinfo('res_mri',this)"></label>
						</div>
						<div class="detimg">
							<img class="detimage" id="res_mri" src="" alt="不存在数据"
								onclick="window.open(this.src)"></img>
							<!-- picture/medicalpicture/x.jpg  -->
						</div>
						<div id="fold" class="subfold">
							临床数据--X光<label class="foldlabelon"
								onclick="showinfo('res_x',this)"></label>
						</div>
						<div class="detimg">
							<img class="detimage" id="res_x" src="" alt="不存在数据"
								onclick="window.open(this.src)"></img>
							<!-- picture/medicalpicture/mri.jpg  -->
						</div>
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
