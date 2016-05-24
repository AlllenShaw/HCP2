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
	<link rel="stylesheet" type="text/css" href="css/form_style.css">
	<script type="text/javascript" src="js/ichart.1.2.1.beta.min.js"></script>
	<script type="text/javascript" src="js/ichart.sign.js"></script>
	<script type="text/javascript" src="js/bg_ichart.js" charset="utf-8"></script>

	<script>
	var arrdata=new Array();
	var num=0;
	var max='${gluPatientInfo.bloodGlucoseMax}';
	var min='${gluPatientInfo.bloodGlucoseMin}';
	function getdata(temp)
   {

      arrdata[num]=temp;
      num++;
    }
    function draw1()
    {
    	var text1=document.getElementById("text1");
    	var temp=text1.value;
    	if(temp=="")
    	{
    		alert("请输入测试次数");
    	}
    	else if(temp<2||temp>9)
    	{
    		alert("输入的测试次数范围请保持在2~9");
    	}
    	else if(temp>num/3)
    	{
    		alert("测试次数不够");
    	}
    	else
    	{
    		draw(arrdata,max,min,temp);
    	}
    }
	</script>
  </head>
  <body onload="check()"> 
  		<div class="formtitle" style="float:left;">血糖图</div>
		<input type="text" id="text1" name="text1" class="size2" style="margin-left:330px;text-align:center;" placeholder="测试次数">
		<input type="button" id="text2" name="text2" class="size3"  value="画图" onclick="draw1();">
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
						<td><input readonly="readonly" value="${gluPatientInfo.patient.realname}"><td>
						<td>ID</td>
						<td><input readonly="readonly" value="${gluPatientInfo.patientId}"></td>
					</tr>
					<tr>
						<td>血糖下限</td>
						<td><input readonly="readonly" value="${gluPatientInfo.bloodGlucoseMin}"><td>
						<td>血糖上限</td>
						<td><input readonly="readonly" value="${gluPatientInfo.bloodGlucoseMax}"><td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</div>
		</div>
		<script>
			draw(arrdata,max,min,3);
			function check()
			{
				var remainday='${gluPatientInfo.remainTime}';
				var bg_max='${gluPatientInfo.bloodGlucoseMax}';
				if(remainday<3&&remainday>0)
				alert("您的测试次数准备用完，请即使充值");
				else if(remainday<1)
				alert("您的测试次数已不足，请及时充值");
				else if(remainday==null)
				{
					alert("您没权限查看测试记录，请联系管理员并充值");
					window.location.href="index_doctor/index.jsp";
				}
				if(bg_max=null)
				{
					alert("您还没设置预警值，请联系您的主治医生");
					window.location.href="index_doctor/index.jsp";
				}
			}
		</script>
  </body>
</html>
