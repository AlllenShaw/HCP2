<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<link rel="stylesheet" type="text/css" href="css/record_style.css">
	
	<script type="text/javascript" src="js/ichart.1.2.1.beta.min.js"></script>
	<script type="text/javascript" src="js/ichart.sign.js"></script>
	<script type="text/javascript" src="js/bg_ichart.js" charset="utf-8"></script>

	<script>
	var arrdata=new Array();
	var num=0;
	function getdata(temp)
   {

      arrdata[num]=temp;
      num++;
    }
	</script>
  </head>
  <body>
		<div id='ichart'></div>
		<br/>
		<c:forEach items="${gluPatientRecords }" var="item">
			<script>
						tem='${item.patient.id}';
						getdata(tem);
						tem='${item.bloodGlucose }';
						getdata(tem);
						tem='${item.measureTime }';
						getdata(tem);
			</script>
			</c:forEach>
		<div class="box">
			<div>
				<table class="tip">
					<tr>
						<td>姓名</td>
						<td><input readonly="readonly"><td>
						<td>ID</td>
						<td><input readonly="readonly"></td>
					</tr>
					<tr>
						<td>空腹血糖下限</td>
						<td><input readonly="readonly"><td>
						<td>空腹血糖上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr>
						<td>餐后血糖下限</td>
						<td><input readonly="readonly"><td>
						<td>餐后血糖上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</div>
		</div>
		
	<script>
	 draw(arrdata);
	</script>
  </body>
</html>
