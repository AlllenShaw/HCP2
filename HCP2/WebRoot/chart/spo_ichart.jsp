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
	<script type="text/javascript" src="js/spo_ichart.js" charset="utf-8"></script>
	
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
  <style>
  	.tip input{width:150px;}
  </style>
  
  <body>
		<div id='ichart'></div>
		<br/>
		
		<c:forEach items="${boPatientRecords }" var="item">
				<script>
					tem='${item.measureTime }';
					getdata(tem);
					tem='${item.spo2 }';
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
						<td>脉率下限</td>
						<td><input readonly="readonly"><td>
						<td>脉率上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr>
						<td>血氧饱和度下限</td>
						<td><input readonly="readonly"><td>
						<td>血氧饱和度上限</td>
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
