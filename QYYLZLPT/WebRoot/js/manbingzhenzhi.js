




function huanzhexinxiload() {
	// 患者信息load
	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		url : "doctor/getPatients.do",
		async : false,
		/* dataType: "json", */
		data : {
		"fun" : "chronic_patient",
		"doctor_id" : did,
		},
		success : function(data) {
		// console.log(data);
		var obj = new Function("return" + data)();
		var length = obj.list.length;
		var tb = document.getElementById("aftable");
		for ( var i = 0; i < length; i++) {
			var row = tb.insertRow();
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			cell1.innerHTML = obj.list[i].id;
			cell2.innerHTML = obj.list[i].realname;
			cell2.innerHTML = "<label class='addtype2'"
			+ ">" + obj.list[i].realname + "</label>";
			cell3.innerHTML = "<input type='button' value='删除'onclick='delecpatient("
				+ did
				+ ","
				+ obj.list[i].id
				+ ",this)'  style='width: 95%'>";
			}
		},
		error : function() {
			alert("error");
			},
	});
}

function searchcpatient() {
	var info = document.getElementById("searchinfo").value;
	var did = document.getElementById("loginuserid").value;
	// console.lo("search info = " + info);
	document.getElementById("betable").style.display = "";

	$.ajax({
		type : "post",
		url : "doctor/searchPatientByDoctor.do",
		async : false,
		data : {
			"fun" : "searchcpatient",
			"keyword" : info,
			"doctor_id":did,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				document.getElementById("betable").style.display = "";
				var tb = document.getElementById("betable");
				if(tb.rows.length>3){
					deleteAllRow("betable");
				}
				var length = obj.list.length;
				for ( var i = 0; i < length; i++) {
					var row = tb.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					cell1.innerHTML = obj.list[i].id;
					cell2.innerHTML = "<label " + "class='addtype2'"
							+ ">" + obj.list[i].realname + "</label>";
					cell3.innerHTML = "<input type='button' value='添加'onclick='addcpatient("
							+ obj.list[i].id
							+ ",this)'  style='width: 95%'>";
				}
			} else {
				alert("查找失败");
			};
		},
		error : function() {
			alert("error");
		},
	});
}

function addcpatient(pid,targetControl) {
	var did = document.getElementById("loginuserid").value;
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;	
	document.getElementById("aftable").style.display = "";
	// console.log("addcpatient pname="+pname);
	// console.lo("ins "+did);
	$.ajax({
		type : "post",
		url : "doctor/addPatient.do",
		async : false,
		data : {
			"fun" : "add_cpatient",
			"doctor_id" : did,
			"patient_id" : pid,
		},
		success : function(data) {
			// console.lo("success");
			// console.lo(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				alert("添加成功");
				addRow(pid, pname);
			} else {
				alert("添加失败");
			}
			;
		}

	});
}

function addRow(pid, pname){
	var did=document.getElementById("loginuserid").value;
	var tb = document.getElementById("aftable");
	var row = tb.insertRow();
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	cell1.innerHTML = pid;
	cell2.innerHTML = "<label class='addtype2'"
		+ ">" + pname + "</label>";
	cell3.innerHTML = "<input type='button' value='删除'onclick='delecpatient("
		+ did
		+ ","
		+ pid
		+ ",this)'  style='width: 95%'>";

}

function manbingxinxiload() {
	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		url : "doctor/getPatients.do",
		async : false,
		data : {
			"fun" : "chronic_patient",
			"doctor_id" : did,
		},
		success : function(data) {
			// console.lo(data);
			var obj = new Function("return" + data)();
			var length = obj.list.length;
			var tb = document.getElementById("aftable");
			for ( var i = 0; i < length; i++) {
				var row = tb.insertRow();
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = obj.list[i].id;
				cell2.innerHTML = "<label class='addtype2'"
					+ ">" + obj.list[i].realname + "</label>";
				cell3.innerHTML = "<input type='button' value='信息' onclick='chronicdetail("
					+ obj.list[i].id + ",this)' style='width: 95%'></input>";
			}
		},
		error : function() {
			alert("error");
		},
	});
}

function chronicdetail(pid, targetControl) {
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;	
	document.getElementById("liebiao").style.display = "none";
	document.getElementById("detailframe").style.display = "";
	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;
	var did = document.getElementById("loginuserid").value;

	
	$.ajax({
		type : "post",
		url : "doctor/getPatientManBingDetails.do",
		async : false,
		data : {
			"fun" : "check_crecord",
			"patient_id" : pid,
			"doctor_id"  : did,
 		},
		success : function(data) {
			// alert(data);
			//var unit="mmol/L";
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				// console.log("获取成功");
				document.getElementById("xuetangframe").style.display="none";
				document.getElementById("noxuetangframe").style.display="none";
				document.getElementById("xueyaframe").style.display="none";
				document.getElementById("noxueyaframe").style.display="none";
				document.getElementById("xuezhiframe").style.display="none";
				document.getElementById("noxuezhiframe").style.display="none";
				if(obj.glu.has=="1"){
					// console.log(obj.glu);
					document.getElementById("xtfold").innerHTML="血糖<label class=\"foldlabelon\"" +
					" onclick=\"showinfo('xuetangframe',this)\"></label>";
					
					document.getElementById("glu_upgradetime").value=obj.glu.upgradeTime;
					document.getElementById("blood_glucose_max").value=obj.glu.bloodGlucoseMax;
					document.getElementById("blood_glucose_min").value=obj.glu.bloodGlucoseMin;
					
				}
				else{
					// console.log(" no glu
					// "+document.getElementById("xtfold").innerHTML);
					clearglu();
					document.getElementById("xtfold").innerHTML="血糖<label class=\"foldlabelon\"" +
							" onclick=\"showinfo('noxuetangframe',this)\"></label>";
				}
				if(obj.htn.has=="1"){
					// console.log(obj.htn);
					document.getElementById("xyfold").innerHTML="血压<label class=\"foldlabelon\"" +
					" onclick=\"showinfo('xueyaframe',this)\"></label>";
					
					document.getElementById("htn_upgradetime").value=obj.htn.upgradeTime;
					document.getElementById("systolic_pressure_max").value=obj.htn.systolicPressureMax;
					document.getElementById("systolic_pressure_min").value=obj.htn.systolicPressureMin;
					document.getElementById("diastolic_pressure_max").value=obj.htn.diastolicPressureMax;
					document.getElementById("diastolic_pressure_min").value=obj.htn.diastolicPressureMin;
					document.getElementById("heart_rate_max").value=obj.htn.heartRateMax;
					document.getElementById("heart_rate_min").value=obj.htn.heartRateMin;

				}
				else{
					clearhtn();
					document.getElementById("xyfold").innerHTML="血压<label class=\"foldlabelon\"" +
					" onclick=\"showinfo('noxueyaframe',this)\"></label>";
				}
				if(obj.hpl.has=="1"){
					// console.log(obj.hpl);
					document.getElementById("xzfold").innerHTML="血脂<label class=\"foldlabelon\"" +
					" onclick=\"showinfo('xuezhiframe',this)\"></label>";

					document.getElementById("hpl_upgradetime").value=obj.hpl.upgradeTime;
					document.getElementById("tc_max").value=obj.hpl.tcMax;
					document.getElementById("tc_min").value=obj.hpl.tcMin;
					document.getElementById("tg_max").value=obj.hpl.tgMax;
					document.getElementById("tg_min").value=obj.hpl.tgMin;
					document.getElementById("hdl_max").value=obj.hpl.hdlMax;
					document.getElementById("hdl_min").value=obj.hpl.hdlMin;
					document.getElementById("ldl_max").value=obj.hpl.ldlMax;
					document.getElementById("ldl_min").value=obj.hpl.ldlMin;

				}
				else{
					
					clearhpl();
					document.getElementById("xzfold").innerHTML="血脂<label class=\"foldlabelon\"" +
					" onclick=\"showinfo('noxuezhiframe',this)\"></label>";
				}
				// var list = obj.list;
				/*
				 * 血糖 glu_patient 血糖 2-10 mmol/L blood_glucose_max
				 * blood_glucose_min 血压 htn_patient 收缩压 80-200
				 * systolic_pressure_max systolic_pressure_min 舒张压 50-130
				 * diastolic_pressure_max diastolic_pressure_min 心率 30-120
				 * heart_rate_max heart_rate_min 血脂 hpl_patient 总胆固醇值 tc_max
				 * tc_min 甘油三酯值 tg_max tg_min 高密度脂蛋白胆固醇值 hdl_max hdl_min
				 * 低密度脂蛋白胆固醇值 ldl_max ldl_min
				 */

			} else {
				document.getElementById("xtfold").innerHTML="血糖<label class=\"foldlabelon\"" +
				" onclick=\"showinfo('noxuetangframe',this)\"></label>";
				document.getElementById("xyfold").innerHTML="血压<label class=\"foldlabelon\"" +
				" onclick=\"showinfo('noxueyaframe',this)\"></label>";
				document.getElementById("xzfold").innerHTML="血脂<label class=\"foldlabelon\"" +
				" onclick=\"showinfo('noxuezhiframe',this)\"></label>";
			//	alert("获取失败");
			}

		},
		error : function() {
			alert("error");
		},
	});
}
function huanzheyongyaoload() {
	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		url : "doctor/getPatients.do",
		async : false,
		data : {
			"fun" : "chronic_patient",
			"doctor_id" : did,
			},
			success : function(data) {
				// alert(data);
				var obj = new Function("return" + data)();
				var length = obj.list.length;
				var tb = document.getElementById("aftable");
				for ( var i = 0; i < length; i++) {
					var row = tb.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					cell1.innerHTML = obj.list[i].id;
					cell2.innerHTML = "<label class='addtype2'"
						+ ">" + obj.list[i].realname + "</label>";
					cell3.innerHTML = "<input type='button' value='信息' onclick='usingdrugdetail("
						+ obj.list[i].id + ",this)' style='width: 95%'></input>";
				}
			},
			error : function() {
				alert("error");
			},
		});
}

function usingdrugdetail(pid, targetControl) {

	// alert("in"+pname.value);
	var did = document.getElementById("loginuserid").value;
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;	
	document.getElementById("liebiao").style.display = "none";
	document.getElementById("detailframe").style.display = "";

	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;

	$.ajax({
		type : "post",
		url : "doctor/patientMedicine.do",
		async : false,
		data : {
			"fun" : "check_usingdrug",
			"patient_id" : pid,
			"doctor_id" : did,
		},
		success : function(data) {
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				// alert("获取成功");
				var length = obj.list.length;
				var tb = document.getElementById("drugtable");
				// console.log(""+tb.rows.length);
				if(tb.rows.length>2){
					deleteAllRow("drugtable");
				}

				for ( var i = 0; i < length; i++) {
					var row = tb.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					
					cell1.innerHTML = obj.list[i].id;
					cell2.innerHTML = obj.list[i].name;
					cell3.innerHTML = obj.list[i].time;
					cell4.innerHTML = obj.list[i].way;
					cell5.innerHTML = obj.list[i].dose;
				}
				

			} else {
				alert("尚无用药数据");
			}

		},
		error : function() {
			alert("error");
		},
	});

}
/*
 * function showInfo() {
 * 
 * document.getElementById("casid").value = "29094-61-9";
 * document.getElementById("name").value = "格列吡嗪片";
 * document.getElementById("time").value = "餐前";
 * document.getElementById("freq").value = "3";
 * document.getElementById("dose").value = "2ml"; }
 */



function delecpatient(doctorid, patientid, targetControl) {
	// alert(doctorid+" "+" "+patientid);
	if(!confirm("确认删除？"))return;

	$.ajax({
		type : "post",
		url : "doctor/deletePatient.do",
		
		async : false,
		data : {
			"fun" : "dele_cpatient",
			"doctor_id" : doctorid,
			"patient_id" : patientid,
		},
		success : function(data) {
			// alert("success");
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				deleteThisRow(targetControl);
				alert("删除成功");
			} else {
				alert("删除失败");
			}
			;
		},
		error : function() {
			alert("error");
		},
	});
}


function yaowuliebiaoload() {
	// alert(doctorid+" "+" "+patientid);
	$.ajax({
		type : "post",
		url : "doctor/getMedicine.do",
		// url : "doctor/huanzheyaowu.do",
		async : false,
		data : {
			"fun" : "druglist",
			// "doctor_id" : did,
			},
			success : function(data) {
				// alert(data);
				var obj = new Function("return" + data)();
				var length = obj.list.length;
				var tb = document.getElementById("aftable");
				for ( var i = 0; i < length; i++) {
					var row = tb.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					
					cell1.innerHTML = obj.list[i].id;
										
					cell2.innerHTML = "<label " + "onclick='drugdetail("
					+ obj.list[i].id + ",this)'" + "class='addtype'"
					+ ">" + obj.list[i].name + "</label>";
					
					/*
					 * cell2.innerHTML = "<label class='addtype2'" + ">" +
					 * obj.list[i].name + "</label>";
					 */
					var type=obj.list[i].type;
					if(type==1){
						cell3.innerHTML = "血压用药";
						
					}
					if(type==2){
						cell3.innerHTML = "血糖用药";
						
					}
					if(type==3){
						cell3.innerHTML = "血脂用药";
						
					}
					
					cell4.innerHTML = "<input type='button' value='删除' onclick='delecdrug("
						+ obj.list[i].id + ",this)' style='width: 95%'></input>";
				}
			},
			error : function() {
				alert("error");
			},
		});
	
}
function drugdetail(id,targetControl){
	
	document.getElementById("liebiao").style.display = "none";
	document.getElementById("detailframe").style.display = "";
	
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var name = targetControl.cells[1].childNodes[0].innerHTML;
	document.getElementById("tid").value=id;
	document.getElementById("tname").value=name;
	console.log(id);
	
	$.ajax({
		type : "post",
		url : "doctor/getMedicineById.do",
		async : false,
		data : {
			"fun" : "check_drug",
			"medicine_id" : id,
		},
		success : function(data) {
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				// alert("获取成功");
				var tb = document.getElementById("drugtable");
				// console.log(""+tb.rows.length);
				type=obj.type;
				if(type=="1"){document.getElementById("type").value="血压";}
				if(type=="2"){document.getElementById("type").value="血糖";}
				if(type=="3"){document.getElementById("type").value="血脂";}
								
				document.getElementById("effect").value=obj.effect;
				document.getElementById("constituent").value=obj.constituent;
				document.getElementById("taboo").value=obj.taboo;
				document.getElementById("direction").value=obj.direction;
				document.getElementById("takingType").value=obj.takingType;
				document.getElementById("dosage").value=obj.dosage;
				document.getElementById("unit").value=obj.unit;
				document.getElementById("takingTime").value=obj.takingTime;
				

			} else {
				document.getElementById("type").value="";
				document.getElementById("effect").value="";
				document.getElementById("constituent").value="";
				document.getElementById("taboo").value="";
				document.getElementById("direction").value="";
				document.getElementById("takingType").value="";
				document.getElementById("dosage").value="";
				document.getElementById("unit").value="";
				document.getElementById("takingTime").value="";
				alert("获取信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
	
}


function delecdrug(id,targetControl) {
	// alert(doctorid+" "+" "+patientid);
	if(!confirm("确认删除？"))return;

	$.ajax({
		type : "post",
		url : "doctor/deleteMedicine.do",
		
		async : false,
		data : {
			"fun" : "dele_drug",
			"medicine_id" : id,
		},
		success : function(data) {
			// alert("success");
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				deleteThisRow(targetControl);
				alert("删除成功");
			} else {
				alert("删除失败");
			}
			;
		},
		error : function() {
			alert("error");
		},
	});
}


function deleteThisRow(targetControl) {
	if (targetControl.tagName == "TR") {
		targetControl.parentNode.removeChild(targetControl);
	} else {
		deleteThisRow(targetControl.parentNode);
	}
}
function deleteAllRow(tableId){
	var tableObj=getTargetControl(tableId);
	var tbodyOnlineEdit=getTableTbody(tableObj);
	for(var i=tbodyOnlineEdit.childNodes.length-1;i>=2;i--){
	    tbodyOnlineEdit.removeChild(tbodyOnlineEdit.childNodes[i]);
	}
}
function getTargetControl(targetControl){
	if(typeof(targetControl)=="string"){
		return document.getElementById(targetControl);
	}
	else return targetControl;
}
function getTableTbody(tableObj){
	var tbodyOnlineEdit=tableObj.getElementsByTagName("TBODY")[0];
	if(typeof(tbodyOnlineEdit)=="undefined"||tbodyOnlineEdit==null){
		tbodyOnlineEdit=document.createElement("tbody");
		tableObj.appendChild(tbodyOnlineEdit);
	}
	return tbodyOnlineEdit;
}
function clearglu(){
	//var unit="mmol/L";
	document.getElementById("glu_upgradetime").value="";
	document.getElementById("blood_glucose_max").value="";
	document.getElementById("blood_glucose_min").value="";
}
function clearhtn(){
	//var unit="mmol/L";
	document.getElementById("htn_upgradetime").value="";
	document.getElementById("systolic_pressure_max").value="";
	document.getElementById("systolic_pressure_min").value="";
	document.getElementById("diastolic_pressure_max").value="";
	document.getElementById("diastolic_pressure_min").value="";
	document.getElementById("heart_rate_max").value="";
	document.getElementById("heart_rate_min").value="";
}
function clearhpl(){
	//var unit="mmol/L";
	document.getElementById("hpl_upgradetime").value="";
	document.getElementById("tc_max").value="";
	document.getElementById("tc_min").value="";
	document.getElementById("tg_max").value="";
	document.getElementById("tg_min").value="";
	document.getElementById("hdl_max").value="";
	document.getElementById("hdl_min").value="";
	document.getElementById("ldl_max").value="";
	document.getElementById("ldl_min").value="";
}
