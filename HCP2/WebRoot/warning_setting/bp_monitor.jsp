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
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>

<body>
	<div class="formtitle">血压测试值监控</div>
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<br/>
	<div class="formtitle">警告提示列表</div>
	<table class="bordered" id="bp_form1">
			<thead>
	
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>收缩压</th>
					<th>舒张压</th>
					<th>心率</th>
				</tr>
				
			</thead>
	</table>
	<h2>您的病人列表</h2>
	<table class="bordered" id="bp_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>收缩压</th>
				<th>舒张压</th>
				<th>心率</th>
			</tr>
			
		</thead>
			<c:forEach items="${htnPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.patient.realname}</td>
					<td>${item.systolicPressure }</td>
					<td>${item.diastolicPressure }</td>
					<td>${item.heartRate }</td>
				</tr>
			</c:forEach>
	</table>
	<br />
	<audio src="voice/du.wav" id="audio" ></audio>
	<form  method="post" id="formid">
	<input type="hidden" name="selector1" value="2" />
	<input type="hidden" name="selector2" value="4" />
	<input type="hidden" name="type" value="1" />
	</form>
	
	<script>
	var arrdata=new Array();
		function checkdata()
	   {
	   	  var tableid=document.getElementById("bp_form1");
		  var rows = tableid.getElementsByTagName("tr");
		  for(var i=rows.length-1;i>0;i--)
	         {
				 tableid.deleteRow(i);
			 } 
	      var objTable=document.getElementById("bp_form");
	      var rows = objTable.getElementsByTagName("tr");
	      var audio = document.getElementById("audio");
	      
	      if(objTable)
	      {
	         for(var i=1;i<objTable.rows.length;i++)
	         {            
	              var sbp_value=objTable.rows[i].cells[2].innerText;
	              var dbp_value=objTable.rows[i].cells[3].innerText;
	              var hr_value=objTable.rows[i].cells[4].innerText;
	              var sbp_max='${htnPatientInfo[i].systolicPressureMax }',sbp_min='${htnPatientInfo[i].systolicPressureMin }';
				  var dbp_max='${htnPatientInfo[i].diastolicPressureMax}',dbp_min='${htnPatientInfo[i].diastolicPressureMin}';
				  var hr_min='${htnPatientInfo[i].heartRateMin}',hr_max='${htnPatientInfo[i].heartRateMax}';
	               z=0;
	           	   for(var j=0;j<objTable.rows[i].cells.length;j++)
            		{
                		arrdata[z]=objTable.rows[i].cells[j].innerText;
                		z++;
         		   	} 
				  if(sbp_value<sbp_min||sbp_value>sbp_max)
					{
						rows[i].style.color="#f00";
							adddata(i-1);
							audio.play();
					}
				  else if(dbp_value<dbp_min||dbp_value>dbp_max)
					{
						rows[i].style.color="#f00";
							adddata(i-1);
							audio.play();
					}
				  else if(hr_value<hr_min||hr_value>hr_max)
					{
						rows[i].style.color="#f00";
							adddata(i-1);
							audio.play();
					}			
	         }
	      }
	     }
	     
	     
	function adddata(temp)
   {
        var tableid=document.getElementById("bp_form1");
	    var rows = tableid.getElementsByTagName("tr");
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=arrdata[temp*5];
		cell2.innerHTML=arrdata[temp*5+1];
		cell3.innerHTML=arrdata[temp*5+2];
		cell4.innerHTML=arrdata[temp*5+3];
		cell5.innerHTML=arrdata[temp*5+4];
   }
	     
  	function flash(){
      $.ajax({
		   type: "POST",
		   url: "doctor/seo.do",
		   data:$("#formid").serialize(),
		});
	checkdata();
  	}
  	checkdata();
  	setInterval("flash()",3000);
	</script>
	
	
	<script src="js/all_form.js"></script>
</body>
</html>
