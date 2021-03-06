<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<body onload="check()">
	<div class="formtitle">${name}的血压情况</div>
	<table class="bordered" id="bp_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>测试时间</th>
				<th>收缩压</th>
				<th>舒张压</th>
				<th>心率</th>
			</tr>
		</thead>
		<c:forEach items="${htnPatientRecords }" var="item">
			<tr>
				<td>${item.patient.id}</td>
				<td>${item.measureTime }</td>
				<td>${item.systolicPressure }</td>
				<td>${item.diastolicPressure }</td>
				<td>${item.heartRate }</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<div class="paging" id=paging></div>

	<hr
		style="height:5px;border:none;margin-top:50px;border-top:1px ridge #ccc;" />

	<div style="margin-top:50px">
		<div class="formtitle" style="float:right">${name}剩下的血压测试天数：${remainDay}</div>
	</div>
	<!-- 
	 <div style="margin-top:28px">
	 	<h2 >${name}血压测试有效时间段</h2>					
	 </div>
	 <div style="float:left">
	 	<h2>开始时间</h2>
		<input readonly="readonly">
	 </div>
	 <div style="float:right">
		<h2>结束时间</h2>
		<input readonly="readonly">
	</div>
	 -->

	<script>
		var arrdata = new Array();
		var now;
		var sbp_max='${htnPatientInfo.systolicPressureMax }',sbp_min='${htnPatientInfo.systolicPressureMin }';
		var dbp_max='${htnPatientInfo.diastolicPressureMax}',dbp_min='${htnPatientInfo.diastolicPressureMin}';
		var hr_min='${htnPatientInfo.heartRateMin}',hr_max='${htnPatientInfo.heartRateMax}';
		function getdata() {
			var objTable = document.getElementById("bp_form");
			if (objTable) {
				z = 0;
				for (var i = 1; i < objTable.rows.length; i++) {
					for (var j = 0; j < objTable.rows[i].cells.length; j++) {
						arrdata[z] = objTable.rows[i].cells[j].innerText;
						z++;
					}
				}
			}
		}

		function showdata(pagenow) {
			now = pagenow;
			var tableid = document.getElementById("bp_form");
			var rows = tableid.getElementsByTagName("tr");
			for (var i = rows.length - 1; i > 0; i--) {
				tableid.deleteRow(i);
			}
			var temp = 15 * (pagenow - 1);
			for (var i = 0; i < 3; i++) {

				var rowobj = tableid.insertRow(tableid.rows.length);
				if (arrdata[temp + 5 * i]) {
					var cell1 = rowobj.insertCell(rowobj.cells.length);
					var cell2 = rowobj.insertCell(rowobj.cells.length);
					var cell3 = rowobj.insertCell(rowobj.cells.length);
					var cell4 = rowobj.insertCell(rowobj.cells.length);
					var cell5 = rowobj.insertCell(rowobj.cells.length);

					cell1.innerHTML = arrdata[temp + 5 * i];
					cell2.innerHTML = arrdata[temp + 5 * i + 1];
					var sbp_value=arrdata[temp + 5 * i + 2];
					cell3.innerHTML = sbp_value + "mmHg";
					var dbp_value=arrdata[temp + 5 * i + 3];
					cell4.innerHTML = dbp_value + "mmHg";
					var hr_value=arrdata[temp + 5 * i + 4];
					cell5.innerHTML = hr_value + "次/秒";
					if(sbp_value<sbp_min||sbp_value>sbp_max)
					{
						rows[i+1].style.color="#f00";
					}
					if(dbp_value<dbp_min||dbp_value>dbp_max)
					{
						rows[i+1].style.color="#f00";
					}
					if(hr_value<hr_min||hr_value>hr_max)
					{
						rows[i+1].style.color="#f00";
					}
				}
			}
		}

		var jsPage = function(el, count, pageStep, pageNum, fnGo) {
			this.getLink = function(fnGo, index, pageNum, text) {
				text = text || index;
				var s = '<input type="button" class="fb" value="' + text
						+ '" onclick="' + fnGo + '(' + 'this' + ');" ';
				if (index == pageNum) {
					s += 'style="color:red;" ';
				}
				s += '>';
				return s;
			}

			//总页数
			var pageNumAll = Math.ceil(count / pageStep);
			if (pageNumAll == 1) {
				divPage.innerHTML = '';
				return;
			}
			var itemNum = 3; //当前页左右两边显示个数
			pageNum = Math.max(pageNum, 1);
			pageNum = Math.min(pageNum, pageNumAll);
			var s = '';
			if (pageNum > 1) {
				s += this.getLink(fnGo, pageNum - 1, pageNum, '上一页');
			} else {
				s += '<span>上一页</span> ';
			}
			var begin = 1;
			if (pageNum - itemNum > 1) {
				s += this.getLink(fnGo, 1, pageNum) + '... ';
				begin = pageNum - itemNum;
			}
			var end = Math.min(pageNumAll, begin + itemNum * 2);
			if (end == pageNumAll - 1) {
				end = pageNumAll;
			}
			for (var i = begin; i <= end; i++) {
				s += this.getLink(fnGo, i, pageNum);
			}
			if (end < pageNumAll) {
				s += '... ' + this.getLink(fnGo, pageNumAll, pageNum);
			}
			if (pageNum < pageNumAll) {
				s += this.getLink(fnGo, pageNum + 1, pageNum, '下一页');
			} else {
				s += '<span>下一页</span> ';
			}
			var divPage = document.getElementById(el);
			divPage.innerHTML = s;
		};

		function gopage(pageIndex) {
			showdata(pageIndex);
			var temp = (arrdata.length) % 5;
			if (temp == 0) {
				temp = (arrdata.length) / 5;
			} else {
				temp = (arrdata.length) / 5 + 1;
			}
			jsPage('paging', temp, 3, pageIndex, 'gopage1');
			;
		}

		function gopage1(pageIndex) {
			if (pageIndex.value == "上一页") {
				gopage(now - 1);
			} else if (pageIndex.value == "下一页") {
				gopage(now + 1);
			} else
				gopage(pageIndex.value);
		}
		getdata();
		gopage(1);
		
		function check()
	{
		var remainday='${remainDay}';
		var sbp_max='${htnPatientInfo.systolicPressureMax }';
		if(remainday<3&&remainday>0)
		alert("您的测试次数准备用完，请即使充值");
		else if(remainday<1)
		alert("您的测试次数已不足，请及时充值");
		else if(remainday==null)
		{
			alert("您没权限查看测试记录，请联系管理员并充值");
			window.location.href="index_doctor/index.jsp";
		}
		if(sbp_max=null)
		{
			alert("您还没设置预警值，请联系您的主治医生");
			window.location.href="index_doctor/index.jsp";
		}
	}
	</script>

	<script src="js/patient_form.js"></script>
</body>
</html>
