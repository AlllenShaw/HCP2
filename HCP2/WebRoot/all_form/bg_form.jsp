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

</head>

<body>
	<div class="formtitle">最新血糖列表</div>
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
					<td>${item.bloodGlucose }</td>
					<td>${item.measureTime }</td>
				</tr>
			</c:forEach>
	</table>
	<br />
	
	
	<div class="paging" id="paging">
		
	</div>



	<script>
	var arrdata=new Array();
	var now;
	
	function getdata()
   {
      var objTable=document.getElementById("bg_form");
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
      var tableid=document.getElementById("bg_form");
	  var rows = tableid.getElementsByTagName("tr");
	  for(var i=rows.length-1;i>0;i--)
         {
			 tableid.deleteRow(i);
		 } 
	var temp=12*(pagenow-1);
	  for(var i=0;i<3;i++) 
	{
		if(arrdata[temp+4*i])
		{
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=arrdata[temp+4*i];
		cell2.innerHTML=arrdata[temp+4*i+1];
		var current_value=arrdata[temp+4*i+2];
		cell3.innerHTML=current_value+"mmol/L";
		cell4.innerHTML=arrdata[temp+4*i+3];
		var bg_max='${gluPatientInfos[i].bloodGlucoseMax }';
		var bg_min='${gluPatientInfos[i].bloodGlucoseMin }';
		if(current_value<bg_min||current_value>bg_max)
		{
			rows[i+1].style.color="#f00";
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
		var temp=(arrdata.length)%4;
		if (temp==0)
			{
				temp=(arrdata.length)/4;
			}
		else
			{
			temp=(arrdata.length)/4+1;
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
