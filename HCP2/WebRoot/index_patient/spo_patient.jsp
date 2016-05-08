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
	<h2>${name}的血氧情况</h2>
	<table class="bordered" id="spo_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>测试时间</th>
				<th>脉率</th>
				<th>血氧饱和度</th>
				<th>灌注指数</th>
			</tr>
			<c:forEach items="${boPatientRecords }" var="item">
				<tr>
					<td>${item.patient.id}</td>
					<td>${item.measureTime }</td>
					<td>${item.pulseRate }</td>
					<td>${item.spo2 }</td>
					<td>${item.pi }</td>
				</tr>
			</c:forEach>
		</thead>
	</table>
	<br />
	<div class="paging">
		<input type="button" value="上一页" onclick="">
		<%
			int pagesize = 3;//一页显示几条记录
			int pagenow = 1;//希望显示第几页
			int rowcount = 0;//共有几条记录
			int pagecount = 5;//共有几页(计算)

			for (int i = pagenow; i < pagenow + pagecount; i++) {
		%>
		<input class="fb" type="button" value="<%=i%>" onclick="">
		<%
			}
		%>
		<input class="fb" type="button" value="下一页" onclick="">
	</div>
	
	<script>
	var arrdata=new Array();
	function getdata()
   {
      var objTable=document.getElementById("bp_form");
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
      var tableid=document.getElementById("bg_form");
	  var rows = tableid.getElementsByTagName("tr");
	  for(var i=rows.length-1;i>0;i--)
         {
			 tableid.deleteRow(i);
		 } 
	var temp=15*(pagenow-1);
	  for(var i=0;i<3;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		
		
		cell1.innerHTML=arrdata[temp+3*i];
		cell2.innerHTML=arrdata[temp+3*i+1];
		cell3.innerHTML=arrdata[temp+3*i+2]+"次/min";
		cell4.innerHTML=arrdata[temp+3*i+3];
		cell5.innerHTML=arrdata[temp+3*i+4];
	} 
   }
	
	var jsPage = function(el, count, pageStep, pageNum, fnGo) {
    this.getLink = function(fnGo, index, pageNum, text) {
        var s = '<input type="button" class="fb" value="'+index+'" onclick="' + fnGo + '(' + 'this' + ');" ';
        if(index == pageNum) {
            s += 'style="color:red;" ';
        }
        text=text||null;
        s += '>' +text;            
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
		jsPage('paging',arrdata.length, 3, pageIndex, 'gopage1');
	}
	
	function gopage1(pageIndex) {
		gopage(pageIndex.value);
	}
	getdata();
	gopage(1);
</script>
	
	
	<script src="js/patient_form.js"></script>
</body>
</html>
