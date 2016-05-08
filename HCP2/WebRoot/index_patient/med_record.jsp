<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<body>
	<h2>${name}的用药记录</h2>
	<table class="bordered" id="medrecord_form">
		<thead>
			<tr>
				<th>药物ID</th>
				<th>名字</th>
				<th>用药时间</th>
				<th>服用方式</th>
				<th>服用量</th>
			</tr>
			<c:forEach items="${gluPatientMedicineRecords }" var="item">
				<tr>
					<td>${item.medicine.id}</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineTime }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>${item.takingMedicineNumberEachtime }</td>
				</tr>
			</c:forEach>
			<c:forEach items="${hdPatientMedicineRecords }" var="item">
				<tr>
					<td>${item.medicine.id}</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineTime }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>${item.takingMedicineNumberEachtime }</td>
				</tr>
			</c:forEach>
			<c:forEach items="${boPatientMedicineRecords }" var="item">
				<tr>
					<td>${item.medicine.id}</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineTime }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>${item.takingMedicineNumberEachtime }</td>
				</tr>
			</c:forEach>
			<c:forEach items="${htnPatientMedicineRecords }" var="item">
				<tr>
					<td>${item.medicine.id}</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineTime }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>${item.takingMedicineNumberEachtime }</td>
				</tr>
			</c:forEach>
			<c:forEach items="${hplPatientMedicineRecords }" var="item">
				<tr>
					<td>${item.medicine.id}</td>
					<td>${item.medicine.name }</td>
					<td>${item.takingMedicineTime }</td>
					<td>${item.takingMedicineWay.takingMedicineWay }</td>
					<td>${item.takingMedicineNumberEachtime }</td>
				</tr>
			</c:forEach>
		</thead>
	</table>
	<br />
	<div class="paging">
		<input type="button" value="上一页" onclick="">
		<%
			int pagesize = 3;//一页显示几条记录
			int pagenow = 1;//希望显示第几页
			int rowcount = 0;//共有几条记录
			int pagecount = 5;//共有几页(计算)

			for (int i = pagenow; i < pagenow + pagecount; i++) {
		%>
		<input class="fb" type="button" value="<%=i%>" onclick="">
		<%
			}
		%>
		<input class="fb" type="button" value="下一页" onclick="">
	</div>

	<script src="js/patient_form.js"></script>

</body>
</html>
