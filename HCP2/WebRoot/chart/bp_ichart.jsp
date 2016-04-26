<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
	<script type="text/javascript" src="js/bp_ichart.js" charset="utf-8"></script>
	

  </head>
  <body>
		<div id='ichart'></div>
		<br/>
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
						<td>收缩压下限</td>
						<td><input readonly="readonly"><td>
						<td>收缩压上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr>
						<td>舒张压下限 </td>
						<td><input readonly="readonly"><td>
						<td>舒张压上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr>
						<td>心率下限 </td>
						<td><input readonly="readonly"><td>
						<td>心率上限</td>
						<td><input readonly="readonly"><td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</div>
	</div>	
  </body>
</html>
