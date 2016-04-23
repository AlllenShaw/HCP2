// JavaScript Document


function liebiaoonload(type, id) {
	hosload();
	bingrenliebiaoonload();
}

function hosload() {

	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url:"doctor/getHospitals.do",
		async : false,
		data : {
			 "fun":"hosloadss",
			"doctor_id" : did,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			obj.result;
			var length = obj.list.length;
			var ins = "";
			for ( var i = 0; i < length; i++) {
				ins = ins + "<option value='" + obj.list[i].id
						+ "''>" + obj.list[i].name
						+ "</option>";
			}
			document.getElementById("sehos").innerHTML = ins;
		},
		error : function() {
			alert("error");
		},
	});

}

function searchpatient() {
	var hosid = document.getElementById("sehos").value;
	var info = document.getElementById("searchinfo").value;
	// alert("hosid = " + hosid + "info = " + info);
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "doctor/searchPatient.do",
		async : false,
		data : {
			"fun" : "search",
			"hospital_id" : hosid,
			"keyword" : info,
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
					cell3.innerHTML = "<input type='button' value='添加'onclick='addpatient("
							+ obj.list[i].id
							+ ",this)'  style='width: 95%'>";
				}
			} else if(obj.result=="2"){
				alert("无结果");
			}else{
				alert("查找失败");
				
			}
		},
		error : function() {
			alert("error");
		},
	});
}

function bingrenliebiaoonload() {

	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "doctor/getPatients.do",
		async : false,
		data : {
			"fun" : "check_patientlist",
			"doctor_id" : did,
			},
		success : function(data) {
			var obj = new Function("return" + data)();
			var result = obj.result;
			if (obj.result == "0") {
				console.log("no result");
				return;
			} else {
				var list = obj.list;
				var length = obj.list.length;
				var tb = document.getElementById("aftable");
				for ( var i = 0; i < length; i++) {
					var row = tb.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					cell1.innerHTML = obj.list[i].id;
					cell2.innerHTML = "<label " + "onclick='jum("
						+ obj.list[i].id + ",this)'" + "class='addtype'"
						+ ">" + obj.list[i].realname + "</label>";
					cell3.innerHTML = "<input type='button' value='删除'onclick='delepatient("
						+ did
						+ ","
						+ obj.list[i].id
						+ ",this)'  style='width: 95%'>";
				}
			}
		},
		error : function() {
			alert("error");
		},
	});
}

function jum(id,targetControl) {
	console.log("junfunction " + id);
	document.getElementById("liebiao").style.display="none";
	document.getElementById("dangan").style.display="";
	dianzidanganonload(id,targetControl);
	// imageareaload(id);

}
function dianzidanganonload(pid,targetControl) {
	console.log("pid " + pid);
	
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;	
	// console.log("pid= "+pid+" pname = "+pname);
	document.getElementById("tid").value=pid;
	document.getElementById("tname").value=pname;
	var did = document.getElementById("loginuserid").value;
	var hosid = document.getElementById("sehos").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "doctor/getEmr.do",
		async : false,
		data : {
			"fun" : "check_record",
			"patient_id" : pid,
			"hospital_id" : hosid,
			"doctor_id" : did,
		},
		success : function(data) {					
			var obj = new Function("return" + data)();
			if(obj.result=="0"){
				console.log("no result");
				return;
			}
			
			
			document.getElementById("fundationinfo").style.display="none";
			document.getElementById("nofrframe").style.display="none";
			document.getElementById("histories").style.display="none";
			document.getElementById("nohrframe").style.display="none";
			document.getElementById("imagearea").style.display="none";
			/*
			 * document.getElementById("xuezhiframe").style.display="none";
			 * document.getElementById("noxuezhiframe").style.display="none";
			 */
			console.log(data);
			var length=obj.list.length;
			for(var recordindex=0;recordindex<length;recordindex++){
				if(obj.list[recordindex].id=="电子病历"){
					console.log(recordindex);
					break;	
				}
			}
			
			if(obj.list[recordindex].value=="1"){
				
				document.getElementById("frfold").innerHTML="基本信息<label class=\"foldlabelon\""+
				"onclick=\"showinfo('fundationinfo',this)\"></label>";
				document.getElementById("hrfold").innerHTML="病历信息<label class=\"foldlabelon\""+
				" onclick=\"showinfo('histories',this)\"></label>";	
				
				// document.getElementById("idnumber").value = obj.id;
				document.getElementById("username").value = obj.username;
				if(obj.gender=="0"){
					// alert(obj.marriage+"男");
					document.getElementById("gender").value ="男";
				}
				else{
					document.getElementById("gender").value = "女";
				}
				// document.getElementById("gender").value = obj.gender;
				document.getElementById("race").value = obj.nation;
				document.getElementById("age").value = obj.age;
				if(obj.marriage=="true"){
					document.getElementById("marriage").value ="已婚";
				}
				else{
					document.getElementById("marriage").value = "未婚";
				}
				document.getElementById("job").value = obj.profession;
				document.getElementById("address").value = obj.address;
				document.getElementById("occupation").value = obj.company;
				document.getElementById("tel_1").value = obj.tele;
				document.getElementById("tel_2").value = obj.tele1;
				document.getElementById("tel_3").value = obj.tele2;
				document.getElementById("history_1").value = obj.illnessHistory;
				document.getElementById("history_2").value = obj.allergicHistory;
				document.getElementById("history_3").value = obj.familyMedicalHistory;
			}
			else{
				// no bl
				document.getElementById("frfold").innerHTML="基本信息<label class=\"foldlabelon\""+
							"onclick=\"showinfo('nofrframe',this)\"></label>";
				document.getElementById("hrfold").innerHTML="病历信息<label class=\"foldlabelon\""+
					" onclick=\"showinfo('nohrframe',this)\"></label>";				
			}
			
			document.getElementById("imgfold").innerHTML="临床数据<label class=\"foldlabelon\""+
				" onclick=\"showinfo('imagearea',this)\"></label>";

			for(var i=0;i<length;i++){
				console.log(obj.list[i].value);
				if(i==recordindex)continue;
				if(obj.list[i].id=="CT"){
					if(obj.list[i].value=="2"){
						document.getElementById("res_ct").alt="没有权限";
					}
					document.getElementById("res_ct").src=obj.list[i].value;
				}
				if(obj.list[i].id=="B超"){
					if(obj.list[i].value=="2"){
						document.getElementById("res_b").alt="没有权限";
					}
					document.getElementById("res_b").src=obj.list[i].value;
				}
				if(obj.list[i].id=="X光"){
					if(obj.list[i].value=="2"){
						document.getElementById("res_x").alt="没有权限";
					}
					document.getElementById("res_x").src=obj.list[i].value;
				}
				if(obj.list[i].id=="MRI"){
					if(obj.list[i].value=="2"){
						document.getElementById("res_mri").alt="没有权限";
					}
					
					document.getElementById("res_mri").src=obj.list[i].value;
				}
				document.getElementById("res_b").style.display="none";
				document.getElementById("res_ct").style.display="none";
				document.getElementById("res_mri").style.display="none";
				document.getElementById("res_x").style.display="none";
			}
		},
		error : function() {
			alert("error");
		},
	});

}

function addpatient(pid,targetControl) {
	
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;	
	var did = document.getElementById("loginuserid").value;
	console.log(pid);
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "doctor/addPatient.do",
		async : false,
		data : {
			"fun" : "add_patient",
			"doctor_id" : did,
			"patient_id" : pid,
		},
		success : function(data) {
			// alert("success");
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				alert("添加成功");
				addRow(pid, pname, did);
			}
			else{
				alert("添加失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
}
function addRow(pid, pname, doctorid) {
	var tb = document.getElementById("aftable");
	var i = tb.rows.length - 2;
	var row = tb.insertRow();
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);

	cell1.innerHTML = pid;
	cell2.innerHTML = "<label " + "onclick='jum(" + pid + ",this)'"
			+ "class='addtype'" + ">" + pname + "</label>";
	cell3.innerHTML = "<input type='button' value='删除'onclick='delepatient("
			+ doctorid + "," + pid + ",this)'  style='width: 95%'>";

}
function delepatient(doctorid, patientid, targetControl) {
	
	
	if(!confirm("确认删除？"))return;
	// alert(doctorid+" "+" "+patientid);
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "doctor/deletePatient.do",

		async : false,
		data : {
			"fun" : "dele_patient",
			"doctor_id" : doctorid,
			"patient_id" : patientid,
		},
		success : function(data) {
			// console.log("success");
			// console.log(data);
			var obj = new Function("return" + data)();

			if (obj.result == "1") {
				alert("删除成功");
				deleteThisRow(targetControl);
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
	} else
		deleteThisRow(targetControl.parentNode);
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
