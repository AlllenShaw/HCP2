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


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<link rel="stylesheet" type="text/css" href="css/record_style.css">
<link rel="stylesheet" type="text/css" href="css/form_style.css">
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>

<script>
	var arrdata=new Array();
	var num=0;
	var str="";
	function getdata(temp)
  	{
     arrdata[num]=temp;
     num++;
   	}
   	function add_med1()
   	{	
   		var obj=document.getElementById("med_select");
   		var number=obj.selectedIndex;
   		add_med(number);
   	}
   	function add_med(number)
	{
		var tableid = document.getElementById("med_form");
		var rows = tableid.getElementsByTagName("tr");
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);

		cell1.innerHTML="<input type='text' readonly='readonly' id='adaptationDisease"+tableid.rows.length+"' value='"+arrdata[number*5]+"'/>";
		cell2.innerHTML="<input type='text' readonly='readonly' id='id"+tableid.rows.length+"' value='"+arrdata[number*5+1]+"'/>";
		cell3.innerHTML="<input type='text' readonly='readonly' id='name"+tableid.rows.length+"' value='"+arrdata[number*5+2]+"'/>";
		cell4.innerHTML="<input type='text' id='usage"+tableid.rows.length+"' value='"+arrdata[number*5+3]+"'/>";
		cell5.innerHTML="<input type='text' id='dosage"+tableid.rows.length+"' value='"+arrdata[number*5+4]+"'/>";
	}
	
	function remove_med()
	{
	  var tableid=document.getElementById("med_form");
	  var rows = tableid.getElementsByTagName("tr");
	  tableid.deleteRow(tableid.rows.length-1);
	
	}
	
	function checkmed()
	{
	  var objTable=document.getElementById("med_form");
	  var temp2,temp3,temp4;
      if(objTable)
      {
  			
         for(var i=1;i<objTable.rows.length;i++)
         {
         	temp2="adaptationDisease"+(i+1);
         	alert(temp2);
            temp3=document.getElementById(temp2);
            temp4=temp3.value;
            str+=temp4+",";
            temp2="id"+(i+1);
            temp3=document.getElementById(temp2);
            temp4=temp3.value;
            str+=temp4+",";
            temp2="name"+(i+1);
            temp3=document.getElementById(temp2);
            temp4=temp3.value;
            str+=temp4+",";
            temp2="usage"+(i+1);
            temp3=document.getElementById(temp2);
            temp4=temp3.value;
            str+=temp4+",";
            temp2="dosage"+(i+1);
            temp3=document.getElementById(temp2);
            temp4=temp3.value;
            str+=temp4+",";
         }
         alert(str);
         $("#str").attr("value",str);
      }
      return true;
	}
	</script>

</head>
<style>
#help-left {
	width: 680px;
	font-family: 'microsoft YaHei';
	float: left
}
.selecttype1
{
	width:100px;
	height:40px;
	margin-left:330px;
	margin-top:10px;
	float:left;
}
.bordered input
{
	width:100px;
}
html { overflow-x:hidden; }
</style>


<body>
	<c:forEach items="${medicines}" var="item">
		<script>
				var temp;
				temp='${item.adaptationDisease}';
				getdata(temp);
				temp='${item.id }';
				getdata(temp);
				temp='${item.name }';
				getdata(temp);
				temp='${item.usage }';
				getdata(temp);
				temp='${item.dosage}';
				getdata(temp);
		</script>
	</c:forEach>
	<section id="conter"> <section id="help-left"> <details
		class="menu" open> <summary>医嘱</summary>
	<form action="doctor/addEmr.do" method="post" onsubmit="return checkmed()">
		<div class="box">
			<div>
				<table class="tip">
					<tr>
						<td>姓名</td>
						<td><input readonly="readonly" value="${patient.realname }" />
						<td>
						<td>ID</td>
						<td><input readonly="readonly" value="${patient.id }" /></td>
					</tr>
				</table>
			</div>
			<hr style="height:1px;border:none;border-top:1px ridge #ccc;" />

			<br />
			<div class="question">病情描述</div>
			<span>补充:</span><br/>
			<div style="margin-left:15px;">
				<textarea name="illnessStateDesc"
					class="test_box"></textarea>
			</div>
			<br />
			<table class="bordered" id="med_form">
				<thead>
					<tr>
						<th>类型</th>
						<th>药物ID</th>
						<th>药物名称</th>
						<th>服用方式</th>
						<th>服用量</th>
					</tr>
				</thead>	
					
			</table>
			<br />
			<select name="med_select" id="med_select" class="selecttype1">
					<c:forEach items="${medicines}" var="item">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
			</select>
			
			<input class="fb" type="button" style="margin-left:20px;" onclick="add_med1()" value="添加"><br/>
			<input class="fb" type="button"  style="margin-left:453px; margin-top:10px;" onclick="remove_med()" value="移除">
			<input type="hidden" name="str" id="str" />
			
			
			<br />
			<div class="question">诊断和建议</div>
			<span>补充:</span><br/>
			<div style="margin-left:15px;">
			<textarea class="test_box" id="dac"></textarea>
			</div>
			<br />

			
			<input class="fb" type="submit" style="margin-left:450px;" value="提交">

		</div>
	</form>
	</details> </section> </section>

</body>


</html>
