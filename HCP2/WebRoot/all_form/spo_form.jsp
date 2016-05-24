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
	<div class="formtitle" style="float:left" onsubmit="return checktext1()">最新血氧列表</div>
	<form  method="post" id="formid">
	<input type="hidden" name="selector1" value="10" />
	<input type="hidden" name="selector2" value="2" />
	<input type="hidden" name="type" value="0" />
	<input type="text" id="text1" name="text1" class="size2" style="margin-left:250px;" placeholder="选择病人">
	<input type="submit" id="text2" name="text2" class="size3"  value="病历">
	</form>
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
	<div class="paging">
		
	</div>

	<script>
	var arrdata=new Array();
	var now;
	function getdata()
   {
      var objTable=document.getElementById("spo_form");
      if(objTable)
      {
  			z=0;
         for(var i=1;i<objTable.rows.length;i++)
         {
            for(var j=0;j<objTable.rows[i].cells.length;j++)
            {
                arrdata[z]=objTable.rows[i].cells[j].innerText;
                z++;
            }
         }
      }
     }
	
	function showdata(pagenow)
   {
		now=pagenow;
      var tableid=document.getElementById("spo_form");
	  var rows = tableid.getElementsByTagName("tr");
	  for(var i=rows.length-1;i>0;i--)
         {
			 tableid.deleteRow(i);
		 } 
	var temp=15*(pagenow-1);
	  for(var i=0;i<3;i++) 
	{ 
	
		var rowobj=tableid.insertRow(tableid.rows.length);
		if(arrdata[temp+5*i])
		{
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=arrdata[temp+5*i];
		cell2.innerHTML=arrdata[temp+5*i+1];
		cell3.innerHTML=arrdata[temp+5*i+2];
		var spo_value=arrdata[temp+5*i+3];
		cell4.innerHTML=spo_value+"次/min";
		var bpm_value=arrdata[temp+5*i+4];
		cell5.innerHTML=bpm_value;
		
		var spo_max='${boPatientInfo[i].spo2maxMax }',spo_min='${boPatientInfo[i].spo2maxMin }';
		var bpm_max='${boPatientInfo[i].pulseRateMax }',bpm_min='${boPatientInfo[i].pulseRateMin }';
		if(spo_value<spo_min||spo_value>spo_max)
		{
			rows[i+1].style.color="#f00";
		}
		else if(bpm_value<bpm_min||bpm_value>bpm_max)
		{
			rows[i+1].style.color="#f00";
		}
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
	} 
   }
	
	var jsPage = function(el, count, pageStep, pageNum, fnGo) {
    this.getLink = function(fnGo, index, pageNum, text) {
    	text=text||index;
        var s = '<input type="button" class="fb" value="'+text+'" onclick="' + fnGo + '(' + 'this' + ');" ';
        if(index == pageNum) {
            s += 'style="color:red;" ';
        }
        s += '>';            
        return s;
    };
    
    //总页数
    var pageNumAll = Math.ceil(count / pageStep);
    if (pageNumAll == 1) {
        divPage.innerHTML = '';
        return;
    }
    var itemNum = 3; //当前页左右两边显示个数
    pageNum = Math.max(pageNum, 1);
    pageNum = Math.min(pageNum, pageNumAll);
    var s = '';
    if (pageNum > 1) {
        s += this.getLink(fnGo, pageNum-1, pageNum, '上一页');
    } else {
        s += '<span>上一页</span> ';
    }
    var begin = 1;
    if (pageNum - itemNum > 1) {
        s += this.getLink(fnGo, 1, pageNum) + '... ';
        begin = pageNum - itemNum;
    }
    var end = Math.min(pageNumAll, begin + itemNum*2);
    if(end == pageNumAll - 1){
        end = pageNumAll;
    }
    for (var i = begin; i <= end; i++) {
        s += this.getLink(fnGo, i, pageNum);
    }
    if (end < pageNumAll) {
        s += '... ' + this.getLink(fnGo, pageNumAll, pageNum);
    }
    if (pageNum < pageNumAll) {
        s += this.getLink(fnGo, pageNum+1, pageNum, '下一页');
    } else {
        s += '<span>下一页</span> ';
    }
    var divPage = document.getElementById(el);
    divPage.innerHTML=s;
};


	function gopage(pageIndex) {
		showdata(pageIndex);
		var temp=(arrdata.length)%5;
		if (temp==0)
			{
				temp=(arrdata.length)/5;
			}
		else
			{
			temp=(arrdata.length)/5+1;
			}
		jsPage('paging',temp, 3, pageIndex, 'gopage1');
	}
	
	function gopage1(pageIndex) {
		if(pageIndex.value=="上一页")
		{
		gopage(now-1);
		}
	else if(pageIndex.value=="下一页")
		{
		gopage(now+1);
		}
	else
		gopage(pageIndex.value);
	}
	getdata();
	gopage(1);
</script>


	<script src="js/all_form.js"></script>
</body>
</html>
