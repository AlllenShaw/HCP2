// JavaScript Document

function pdianzidanganonload() {// 病人电子档案

	var pid = document.getElementById("loginuserid").value;
	var pname = document.getElementById("loginusername").value;
	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;
	console.log("pid " + pid + "  pname " + pname);

	$.ajax({
		type : "post",
		url : "patient/queryEmr.do",
		// url : "doctor/getEmr.do",
		async : false,
		data : {
			"fun" : "check_record",
			"patient_id" : pid,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				console.log("no result");
				return;
			}
			document.getElementById("fundationinfo").style.display = "none";
			document.getElementById("nofrframe").style.display = "none";
			document.getElementById("histories").style.display = "none";
			document.getElementById("nohrframe").style.display = "none";
			document.getElementById("frfold").innerHTML = "基本信息<label class=\"foldlabelon\""
				+ "onclick=\"showinfo('fundationinfo',this)\"></label>";
			document.getElementById("hrfold").innerHTML = "病历信息<label class=\"foldlabelon\""
					+ " onclick=\"showinfo('histories',this)\"></label>";
			// document.getElementById("idnumber").value = obj.id;
			document.getElementById("username").value = obj.username;
			if (obj.gender == "0") {
				// alert(obj.marriage+"男");
				document.getElementById("gender").value = "男";
			} else {
				document.getElementById("gender").value = "女";
			}
			document.getElementById("race").value = obj.nation;
			document.getElementById("age").value = obj.age;
			if (obj.marriage == "true") {
				document.getElementById("marriage").value = "已婚";
			} else {
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
		},
		error : function() {
			alert("error");
		},
	});

}
