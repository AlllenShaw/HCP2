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

<script>
	var sbp_max=new Array();
	var sbp_min=new Array();
	var dbp_max=new Array();
	var dbp_min=new Array();
	var hr_max=new Array();
	var hr_min=new Array();
	var x=0,y=0,z=0;
	function getdata1(temp1,temp2)
	{
		sbp_max[x]=temp1;
		sbp_min[x]=temp2;
		x++;
	}
	function getdata2(temp1,temp2)
	{
		dbp_max[y]=temp1;
		dbp_min[y]=temp2;
		y++;
	}
	function getdata3(temp1,temp2)
	{
		hr_max[z]=temp1;
		hr_min[z]=temp2;
		z++;
	}
</script>

</head>

<body>
	<div class="formtitle" style="float:left;">血压测试值监控</div>
	<form  method="post" id="formid" onsubmit="return checktext1()">
	<input type="hidden" name="selector1" value="10" />
	<input type="hidden" name="selector2" value="2" />
	<input type="hidden" name="type" value="0" />
	<input type="text" id="text1" name="text1" class="size2" style="margin-left:250px;" placeholder="选择病人">
	<input type="submit" id="text2" name="text2" class="size3"  value="病历">
	</form>
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
	<div class="formtitle">您的病人列表</div>
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

	<c:forEach items="${htnPatientInfos }" var="item">
				<script>
				  var sbp_max1='${item.systolicPressureMax }',sbp_min1='${item.systolicPressureMin }';
					getdata1(sbp_max1,sbp_min1);
				  var dbp_max1='${item.diastolicPressureMax}',dbp_min1='${item.diastolicPressureMin}';
				    getdata2(dbp_max1,dbp_min1);
				  var hr_min1='${item.heartRateMin}',hr_max1='${item.heartRateMax}';
				    getdata3(hr_max1,hr_min1);
				</script>
	</c:forEach>
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
	              var sbp_max1=sbp_max[i-1],sbp_min1=sbp_min[i-1];
				  var dbp_max1=dbp_max[i-1],dbp_min1=dbp_min[i-1];
				  var hr_min1=hr_max[i-1],hr_max1=hr_min[i-1];
	           	   for(var j=0;j<objTable.rows[i].cells.length;j++)
            		{
                		arrdata[z]=objTable.rows[i].cells[j].innerText;
                		z++;
         		   	} 
				  if(sbp_value<sbp_min1||sbp_value>sbp_max1)
					{
						rows[i].style.color="#f00";
							adddata(i-1);
							audio.play();
					}
				  else if(dbp_value<dbp_min1||dbp_value>dbp_max1)
					{
						rows[i].style.color="#f00";
							adddata(i-1);
							audio.play();
					}
				  else if(hr_value<hr_min1||hr_value>hr_max1)
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
		rowobj.onclick=function()
		{
			var e = e || window.event;
		    var target = e.target || e.srcElement;
		    if(target.tagName.toLowerCase() === "td") {
		        var rowIdx = target.parentNode.rowIndex-1;
		    }
			$("#text1").attr("value",arrdata[temp+4*rowIdx]);
		}
   }
	     
  	function flash(){
     window.location.reload(); 
  	}
  	var z=0;
  	checkdata();
  	setInterval("flash()",4000);
	</script>
	
	
	<script src="js/all_form.js"></script>
</body>
</html>
