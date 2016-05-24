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
	var max=new Array();
	var min=new Array();
	var x=0;
	function getdata(temp1,temp2)
	{
		max[x]=temp1;
		min[x]=temp2;
		x++;
	}
</script>
</head>

<body>
	<div class="formtitle" style="float:left;">血糖测试值监控</div>
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
	<table class="bordered" id="bg_form1">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>血糖值</th>
				<th>测量时间</th>
			</tr>
		</thead>
	</table>
	
	<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />
	<div class="formtitle">您的病人列表</div>
	<table class="bordered" id="bg_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>血糖值</th>
				<th>测量时间</th>
			</tr>
		</thead>
			<c:forEach items="${gluPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.patient.realname}</td>
					<td>${item.bloodGlucose }mmol/L</td>
					<td>${item.measureTime }</td>
				</tr>
			</c:forEach>
	</table>
	<br />
	<audio src="voice/du.wav" id="audio" ></audio>
	
	<c:forEach items="${gluPatientInfos}" var="item">
				<script>
					temp1='${item.bloodGlucoseMax}';
					temp2='${item.bloodGlucoseMin}';
					getdata(temp1,temp2);
				</script>
	</c:forEach>
	<script>
	var arrdata=new Array();
		function checkdata()
	   {
	   	  var tableid=document.getElementById("bg_form1");
		  var rows = tableid.getElementsByTagName("tr");
		  for(var i=rows.length-1;i>0;i--)
	         {
				 tableid.deleteRow(i);
			 } 
	      var objTable=document.getElementById("bg_form");
	      var rows = objTable.getElementsByTagName("tr");
	      var audio = document.getElementById("audio");
	      
	      if(objTable)
	      {
	         for(var i=1;i<objTable.rows.length;i++)
	         {               	   
	               var current_value=objTable.rows[i].cells[2].innerText;
	               var bg_max=max[i-1];
				   var bg_min=min[i-1];
	           	   for(var j=0;j<objTable.rows[i].cells.length;j++)
            		{
                		arrdata[z]=objTable.rows[i].cells[j].innerText;
                		z++;
         		   	} 
	               if(current_value<bg_min||current_value>bg_max)
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
        var tableid=document.getElementById("bg_form1");
	    var rows = tableid.getElementsByTagName("tr");
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=arrdata[temp*4];
		cell2.innerHTML=arrdata[temp*4+1];
		var current_value=arrdata[temp*4+2];
		cell3.innerHTML=current_value;
		cell4.innerHTML=arrdata[temp*4+3];
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
