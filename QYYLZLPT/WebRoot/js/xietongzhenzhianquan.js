function savechange() {

	var did = document.getElementById("sedoc").value;
	if (did == "nosedoc") {
		// console.log(did);
		return;
	}
	var al = 0;
	var bl = 0;
	var cl = 0;
	var length = 0;
	while (document.getElementById("a" + al) != null) {
		al++;
	}
	while (document.getElementById("b" + bl) != null) {
		bl++;
	}
	while (document.getElementById("c" + cl) != null) {
		cl++;
	}
	al = al - 1;
	bl = bl - 1;
	cl = cl - 1;
	// console.log(length+"a ="+al+"b ="+bl+"c ="+cl);
	var out;
	out = "{list:[";
	// a-0-al-1
	for ( var i = 0; i < al; i++) {
		if (document.getElementById("a" + i).checked) {
			out = out + "{id:'a" + i + "',";
			out = out + "value:'true'},";
		} else {
			out = out + "{id:'a" + i + "',";
			out = out + "value:'false'},";
		}
	}
	if (document.getElementById("a" + al).checked) {
		out = out + "{id:'a" + al + "',value:'true'}";
	} else {
		out = out + "{id:'a" + al + "',value:'false'}";
	}
	// b-0-bl-1
	out = out + ",";
	for ( var i = 0; i < bl; i++) {
		if (document.getElementById("b" + i).checked) {
			out = out + "{id:'b" + i + "',";
			out = out + "value:'true'},";
		} else {
			out = out + "{id:'b" + i + "',";
			out = out + "value:'false'},";
		}
	}
	if (document.getElementById("b" + bl).checked) {
		out = out + "{id:'b" + bl + "',value:'true'}";
	} else {
		out = out + "{id:'b" + bl + "',value:'false'}";
	}
	// c-0-cl-1
	out = out + ",";
	for ( var i = 0; i < cl; i++) {
		if (document.getElementById("c" + i).checked) {
			out = out + "{id:'c" + i + "',";
			out = out + "value:'true'},";
		} else {
			out = out + "{id:'c" + i + "',";
			out = out + "value:'false'},";
		}
	}
	if (document.getElementById("c" + cl).checked) {
		out = out + "{id:'c" + cl + "',value:'true'}";
	} else {
		out = out + "{id:'c" + cl + "',value:'false'}";
	}
	out = out + "]}";

	console.log(did + out);
	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "hosadmin/saveDoctorPremission.do",
		async : false,
		data : {
			"fun" : "reviseright",
			"doctor_id" : did,
			"list" : out,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				alert("修改成功");
			} else {
				alert("修改失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}
function checkright() {

	var targetSlect = document.getElementById("sedoc");
	var did = targetSlect.options[targetSlect.selectedIndex].value;
	if (did == "nosedoc") {
		return;
	}
	var al = 0;
	var bl = 0;
	var cl = 0;

	var length = 0;
	while (document.getElementById("a" + al) != null) {
		al++;
	}
	while (document.getElementById("b" + bl) != null) {
		bl++;
	}
	while (document.getElementById("c" + cl) != null) {
		cl++;
	}
	// alert(did);
	$
			.ajax({
				type : "post",
				//url : "servlet/requestServlet",
				url : "hosadmin/queryHospitalDoctorPremission.do",
				async : false,
				data : {
					"fun" : "checkright",
					"doctor_id" : did,
				},
				success : function(data) {
					var obj = new Function("return" + data)();
					/*
					 * var length=0;
					 * while(document.getElementById("cb"+length)!=null){
					 * length++; }
					 */
					if (obj.result == "1") {
						var length = al + bl + cl;
						for ( var i = 0; i < length; i++) {
							// console.log(i + " " + length);
							if (obj.list[i].value == 'true') {
								document.getElementById(obj.list[i].id).checked = "checked";
							}
							if (obj.list[i].value == 'false') {
								document.getElementById(obj.list[i].id).checked = "";
							}
						}
					} else {
						alert("获取信息失败");
					}
				},
				error : function() {
					alert("error");
				},
			});
}
function seadoc(targ) {
	console.log(targ);
	var hosid = document.getElementById("sehosinp").value;
	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "hosadmin/getMyHospitalDoctorList.do",
		async : false,
		data : {
			"fun" : "seadoc",
			"hospital_id" : hosid,
		},
		success : function(data) {
			var obj = new Function("return" + data)();

			if (obj.result == "1") {
				if (targ == "qx")
					qxload(obj);
				if (targ == "yh")
					yhload(obj);
			} else {
				alert("获取医生信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}
function qxload(obj) {

	var ins = "";
	var length = obj.list.length;
	ins = "<option value='nosedoc' style='width:100%'></option>";
	for ( var i = 0; i < length; i++) {
		ins = ins + "<option value='" + obj.list[i].id
		/* + "' onclick='checkright(" + obj.list[i].id + ")' " */
		+ "' style='width:100%'>" + obj.list[i].realname + "</option>";
	}
	document.getElementById("sedoc").innerHTML = ins;
}
function yhload(obj) {

	var tb = document.getElementById("aftable");
	var length = obj.list.length;
	for ( var i = 0; i < length; i++) {
		var row = tb.insertRow();
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		cell1.innerHTML = obj.list[i].id;
		cell2.innerHTML = "<label " + "class='addtype2'" + ">"
				+ obj.list[i].realname + "</label>";
		cell3.innerHTML = "<input type='button' value='删除'onclick='deledoc("
				+ obj.list[i].id + ",this)'  style='width: 95%'>";
	}

}

function deledoc(doctorid,  targetControl) {
	
	if(!confirm("确认删除？"))return;
	// alert(doctorid+" "+" "+patientid);
	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "doctor/deletePatient.do",

		async : false,
		data : {
			"fun" : "dele_doc",
			"doctor_id" : doctorid,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				alert("删除成功");
				deleteThisRow(targetControl);
			} else {
				alert("删除失败");
			}
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

function hosload() {
	var did = document.getElementById("loginuserid").value;
	// var did = "999";

	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "hosadmin/getMyHospital.do",
		async : false,
		data : {
			"fun" : "hosloadright",
			"doctor_id" : did,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				document.getElementById("sehos").innerHTML = obj.name;
				document.getElementById("sehosinp").value = obj.id;
			} else {
				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
}
function bodyload(targ) {
	hosload();
	seadoc(targ);
}
function show(targ, curright) {

	for ( var i = 0; i < 5; i++) {
		document.getElementById("right" + i).style.display = "none";
		document.getElementById("r" + i).style.backgroundColor = "";
		// "#00ff22";
	}
	document.getElementById(curright).style.display = "";
	targ.style.backgroundColor = "#63B8FF";

}
