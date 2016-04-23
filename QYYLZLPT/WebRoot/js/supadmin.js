


function levelcheck(){
	var targetSlect = document.getElementById("sl1");
	var s1 = targetSlect.options[targetSlect.selectedIndex].value;
	targetSlect = document.getElementById("sl2");
	var s2 = targetSlect.options[targetSlect.selectedIndex].value;
	// console.log(s1+" "+s2);
	document.getElementById("level").value=s2+","+s1;
}


function showaddframe(){
	
	if(document.getElementById("outaddframe").style.display=="none"){
		document.getElementById("outaddframe").style.display="";
	}
	else{
		document.getElementById("outaddframe").style.display="none";
	}	
}
function addadmin() {

}

function addadminback() {
		document.getElementById("outdetailframe").style.display="none";
}

function hosload() {
	var id = document.getElementById("loginuserid").value;
	// var did = "999";
	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "admin/getAllHospital.do",

		async : false,
		data : {
			"fun" : "hosloadssss",
			"admin_id" : id,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				var ins = "";
				var length = obj.list.length;
				ins = "<option value='nosechos' style='width:100%'></option>";

				for ( var i = 0; i < length; i++) {
					ins = ins + "<option" + " value='" + obj.list[i].id
							+ "' style='width:100%'>" + obj.list[i].name
							+ "</option>";
				}
				document.getElementById("sechos").innerHTML = ins;
			} else {
				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
}
function hosinfo() {

	var targetSlect = document.getElementById("sechos");
	var hosid = targetSlect.options[targetSlect.selectedIndex].value;
	var hosname = targetSlect.options[targetSlect.selectedIndex].innerHTML;
	if (hosid == "nosechos") {
		console.log("nosechos");
		return;
	}
	document.getElementById("hospital_id").value = hosid;
	document.getElementById("hospital_name").value = hosname;
	document.getElementById("hospitalidinp").value = hosid;
			$.ajax({
				type : "post",
				//url : "servlet/requestServlet",
				url : "admin/getHospitalInfo.do",
				async : false,
				data : {
					"fun" : "hosinfo",
					"hospital_id" : hosid,
				},
				success : function(data) {
					var obj = new Function("return" + data)();
					if (obj.result == "1") {
						/* 其他信息 */
						// document.getElementById("hospital_id").value =
						// obj.id;
						// document.getElementById("hospital_name").value =
						// obj.name;
						document.getElementById("hospital_address").value = obj.address;
						document.getElementById("hospital_level").value = obj.level;
						// document.getElementById("hospitalidinp").value =
						// obj.id;

						var length = obj.list.length;
						tb=document.getElementById("aftable");
						if(tb.rows.length>3){
							deleteAllRow("aftable");
						}
						for ( var i = 0; i < length; i++) {
							
							var row = tb.insertRow();
							var cell1 = row.insertCell(0);
							var cell2 = row.insertCell(1);
							var cell3 = row.insertCell(2);
							cell1.innerHTML = obj.list[i].id;
							cell2.innerHTML = "<label " + "onclick='checkadmin("
									+ obj.list[i].id + ")'" + 
									"class='addtype'"
									+ ">" + obj.list[i].username + "</label>";
							cell3.innerHTML = "<input type='button' value='删除'onclick='deleadmin("
									+ obj.list[i].id
									+ ",this)'  style='width: 95%'>";
						}
					} else {
						alert("获取医院信息失败");
					}
				},
				error : function() {
					alert("error");
				},
			});

}
function checkadmin(id) {
	console.log("as"+id);
	document.getElementById("outdetailframe").style.display="";

	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "admin/getHosAdminInfo.do",
		async : false,
		data : {
			"fun" : "checkadmin",
			"admin_id" : id,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				document.getElementById("detid").value=obj.id;
				document.getElementById("detusername").value=obj.username;
				document.getElementById("detpassword").value=obj.password;
				document.getElementById("detmail").value=obj.mail;
				// document.getElementById("detauthority").value=obj.authority;
				document.getElementById("dettele").value=obj.tele;			
			} else {
				alert("获取信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}

function deleadmin(adminid, targetControl) {
	var hosid=document.getElementById("hospital_id").value;
	console.log(adminid);
	$.ajax({
		type : "post",
		//url : "servlet/requestServlet",
		url : "admin/deleteHosAdmin.do",

		async : false,
		data : {
			"fun" : "dele_admin",
			"hospital_id":hosid,
			"admin_id" : adminid,
		},
		success : function(data) {
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
