function check_bg()
{
	var tableid = document.getElementById("bg_form");
}


function check_spo()
{
	var tableid = document.getElementById("spo_form");
	var id=1;
	var time="2016/1/1";
	var bpm="80次/min";
	var pi=0.73;
	var spo_max=99,spo_min=94;
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=id;
		current_value=Math.floor(Math.random() *10)+90;
		cell2.innerHTML=time;
		cell3.innerHTML=bpm;
		cell4.innerHTML=current_value+"%";
		cell5.innerHTML=pi;
		if(current_value<spo_min||current_value>spo_max)
		{
			rows[i].style.color="#f00";
		}
	} 
}

function check_tg()
{
	var tableid = document.getElementById("tg_form");
	var id=1;
	var time="2016/1/1";
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
		
		cell1.innerHTML=id;
		cell2.innerHTML=time;
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
	} 
}


function check_bp()
{
	var tableid = document.getElementById("bp_form");
	var id=1;
	var time="2016/1/1";
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
		
		cell1.innerHTML=id;
		cell2.innerHTML=time;
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
	} 
}


function check_allv()
{
	var tableid = document.getElementById("interview_form");
	var id=1;
	var name="XX";
	var time1="2016/02/01";
	var time2="2016/02/0";
	var temp1,temp2;
	var temp3=new Date("2016/02/02").getTime()-new Date("2016/02/01").getTime();
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=id;
		cell2.innerHTML=name;
		cell3.innerHTML=time1;
		cell4.innerHTML=time2+i;
		
		temp1=new Date(time2+i).getTime();
		temp2=new Date("2016/02/08").getTime();
		
		if(temp1-temp2>=0&&temp1-temp2<=temp3)
		{
			alert("提醒：病人将在这2天进行回访");
			rows[i].style.color="#f00";
		}
		
		rowobj.onclick=function()
		{
			window.location.href='interview_record/patient_record.jsp';
		}
	}
}



function check_med()
{
	var tableid = document.getElementById("med_form");
	var rows = tableid.getElementsByTagName("tr");
	var type="高血压";
	var medID="2012010215";
	var medname="格列吡嗪片";
	var moa="口服";
	var rda="一片";
	for(i=0;i<3;i++)
	{
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		
		cell1.innerHTML=type;
		cell2.innerHTML=medID;
		cell3.innerHTML=medname;
		cell4.innerHTML=moa;
		cell5.innerHTML=rda;
	}
}


function add_med(array,number)
{
	var tableid = document.getElementById("med_form");
	var rows = tableid.getElementsByTagName("tr");
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		alert(array[number*5]);
		alert(array[number*5+1]);
		alert(array[number*5+2]);
		alert(array[number*5+3]);
		alert(array[number*5+4]);
		cell1.innerHTML=array[number*5];
		cell2.innerHTML=array[number*5+1];
		cell3.innerHTML=array[number*5+2];
		cell4.innerHTML=array[number*5+3];
		cell5.innerHTML=array[number*5+4];
		alert("OK");
		
}

function check_medrecord()
{
	var tableid = document.getElementById("medrecord_form");
	var id=29094649;
	var name="格列吡嗪片";
	var time="2016/02/01";
	var wot="睡前";
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		cell1.innerHTML=id;
		cell2.innerHTML=name;
		cell3.innerHTML=time;
		cell4.innerHTML=wot;
		cell5.innerHTML="一片";
		
	}
}



function check_pmed()
{
	var tableid = document.getElementById("pmed_form");
	var id="1";
	var name="XXX";
	var time="2016/02/01";
	var type="高血压";
	var medname="格列吡嗪片";
	var rows = tableid.getElementsByTagName("tr");
	for(var i=1;i<10;i++) 
	{ 
		var rowobj=tableid.insertRow(tableid.rows.length);
		
		var cell1=rowobj.insertCell(rowobj.cells.length);
		var cell2=rowobj.insertCell(rowobj.cells.length);
		var cell3=rowobj.insertCell(rowobj.cells.length);
		var cell4=rowobj.insertCell(rowobj.cells.length);
		var cell5=rowobj.insertCell(rowobj.cells.length);
		cell1.innerHTML=id;
		cell2.innerHTML=name;
		cell3.innerHTML=time;
		cell4.innerHTML=type;
		cell5.innerHTML=medname;
		
		
		rowobj.onclick=function()
		{
			window.location.href='medical_manage/patient_mmed.jsp';
		}
		
	}
}


