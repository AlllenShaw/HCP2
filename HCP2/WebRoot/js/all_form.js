function check_bg()
{
	var tableid = document.getElementById("bg_form");
	var name="小李";
	var bg_max=6.1;
	var bg_min=3.9;
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=i;
		cell2.innerHTML=name+i+"号";
		current_value=(Math.random()*10).toFixed(1);
		cell3.innerHTML=current_value+"mmol/L";
		cell4.innerHTML=bg_max;
		cell5.innerHTML=bg_min;
		if(current_value<bg_min||current_value>bg_max)
		{
			rows[i].style.color="#f00";
		}
		rowobj.onclick=function()
		{
			window.location.href='index_patient/case_history.jsp';
		}
	} 
}

function check_spo()
{
	var tableid = document.getElementById("spo_form");
	var name="小李"
	var bpm="80次/min";
	var spo_max=99,spo_min=94;
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=i;
		current_value=Math.floor(Math.random() *10)+90;
		cell2.innerHTML=name+i+"号";
		cell3.innerHTML=bpm;
		cell4.innerHTML=current_value+"%";
		if(current_value<spo_min||current_value>spo_max)
		{
			rows[i].style.color="#f00";
		}
		rowobj.onclick=function()
		{
			window.location.href='index_patient/case_history.jsp';
		}
	} 
}


function check_bp()
{
	var tableid = document.getElementById("bp_form");
	var name="小李";
	var bpm="80次/min";
	var sbp_max=140,sbp_min=90;
	var dbp_max=90,dbp_min=60;
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=i;
		cell2.innerHTML=name+i+"号";
		var sbp_value=Math.floor(Math.random() *120);
		cell3.innerHTML=sbp_value.toFixed(2)+"mmHg";
		var dbp_value=Math.floor(Math.random() *80);
		cell4.innerHTML=dbp_value.toFixed(2)+"mmHg";
		cell5.innerHTML=bpm;
		if(sbp_value<sbp_min||sbp_value>sbp_max)
		{
			rows[i].style.color="#f00";
		}
		if(dbp_value<dbp_min||dbp_value>dbp_max)
		{
			rows[i].style.color="#f00";
		}
		rowobj.onclick=function()
		{
			window.location.href='index_patient/case_history.jsp';
		}
	} 
}


function check_tg()
{
	var tableid = document.getElementById("tg_form");
	var name="小李";
	var tc_max=5.17,tc_min=2.9;
	var tg_max=1.7,tg_min=0.56;
	var ldlc_max=3.12,ldlc_min=2.07;
	var hdlc_max=2.0,hdlc_min=0.94;
	
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		var cell6=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=i;
		cell2.innerHTML=name+i+"号";
		var tc_value=Math.floor(Math.random() *7);
		cell3.innerHTML=tc_value.toFixed(2)+"mmol/l";
		var tg_value=Math.floor(Math.random() *3);
		cell4.innerHTML=tg_value.toFixed(2)+"mmol/L";
		var hdlc_value=Math.floor(Math.random() *2);
		cell5.innerHTML=hdlc_value.toFixed(2)+"mmol/L";
		var ldlc_value=Math.floor(Math.random() *5);
		cell6.innerHTML=ldlc_value.toFixed(2)+"mmol/L";
		if(tc_value<tc_min||tc_value>tc_max)
		{
			rows[i].style.color="#f00";
		}
		if(tg_value<tg_min||tg_value>tg_max)
		{
			rows[i].style.color="#f00";
		}
		if(ldlc_value<ldlc_min||ldlc_value>ldlc_max)
		{
			rows[i].style.color="#f00";
		}
		if(hdlc_value<hdlc_min||hdlc_value>hdlc_max)
		{
			rows[i].style.color="#f00";
		}
		rowobj.onclick=function()
		{
			window.location.href='index_patient/case_history.jsp';
		}
	} 
}


function check_allnewv()
{
	var tableid = document.getElementById("interview_form");
	var name="小李";
	var time1="2016/02/01";
	var time2="2016/02/01";
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=i;
		cell2.innerHTML=name+i+"号";
		cell3.innerHTML=time1;
		cell4.innerHTML=time2;
		rowobj.onclick=function()
		{
			window.location.href='interview_record/doctor_record.jsp';
		}
	} 
}

