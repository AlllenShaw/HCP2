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
	<div class="formtitle">血氧测试值监控</div>
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<br/>
	<div class="formtitle">警告提示列表</div>
	<table class="bordered" id="spo_form1">
		<thead>

			<tr>
				<th>ID</th>
				<th>测试时间</th>
				<th>姓名</th>
				<th>脉率</th>
				<th>血氧饱和度</th>
			</tr>
		</thead>
	</table>
	
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<div class="formtitle">您的病人列表</div>
	<table class="bordered" id="spo_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>测试时间</th>
				<th>姓名</th>
				<th>脉率</th>
				<th>血氧饱和度</th>
			</tr>
		</thead>
			<c:forEach items="${boPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.measureTime }</td>
					<td>${item.patient.realname}</td>
					<td>${item.pulseRate }</td>
					<td>${item.spo2 }</td>
				</tr>
			</c:forEach>
	</table>
	<br />
	
	<audio src="voice/du.wav" id="audio" ></audio>
	<form  method="post" id="formid">
	<input type="hidden" name="selector1" value="3" />
	<input type="hidden" name="selector2" value="4" />
	<input type="hidden" name="type" value="1" />
	</form>

	<script>
	var arrdata=new Array();
		function checkdata()
	   {
	   	  var tableid=document.getElementById("spo_form1");
		  var rows = tableid.getElementsByTagName("tr");
		  for(var i=rows.length-1;i>0;i--)
	         {
				 tableid.deleteRow(i);
			 } 
	      var objTable=document.getElementById("spo_form");
	      var rows = objTable.getElementsByTagName("tr");
	      var audio = document.getElementById("audio");
	      
	      if(objTable)
	      {
	         for(var i=1;i<objTable.rows.length;i++)
	         {          
	         	   var bpm_value=objTable.rows[i].cells[3].innerText;;
	         	   var spo_value=objTable.rows[i].cells[4].innerText; 
	               var spo_max='${boPatientInfo[i].spo2maxMax }',spo_min='${boPatientInfo[i].spo2maxMin }';
				   var bpm_max='${boPatientInfo[i].pulseRateMax }',bpm_min='${boPatientInfo[i].pulseRateMin }';
	               z=0;
	           	   for(var j=0;j<objTable.rows[i].cells.length;j++)
            		{
                		arrdata[z]=objTable.rows[i].cells[j].innerText;
                		z++;
         		   	}  
					if(spo_value<spo_min||spo_value>spo_max)
					{
						rows[i].style.color="#f00";
						adddata(i-1);
						audio.play();
					}
					else if(bpm_value<bpm_min||bpm_value>bpm_max)
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
        var tableid=document.getElementById("spo_form1");
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
