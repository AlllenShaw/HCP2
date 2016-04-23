
function addcohospital() {// 添加合作医院
	var hos1 = document.getElementById("hospital1inp").value;
	var hos2 = document.getElementById("hospital2").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "hosadmin/addHospital.do",

		async : false,
		data : {
			"fun" : "addcohos",
			"hospital_id_1" : hos1,
			"hospital_id_2" : hos2,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				alert("添加成功");
			} else {
				alert("添加失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}
function hosloadadd() {// 共享渠道load

	hosloadf();
	hosloadt();
}

function hosload() {// 权限load

	hosloadf();
	hosloads();
}
function hosloadf() {// 获取当前医院
	var did = document.getElementById("loginuserid").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "hosadmin/getMyHospital.do",
		async : false,
		data : {
			"fun" : "hosloadf",
			"doctor_id" : did,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				document.getElementById("hospital1").innerHTML = obj.name;
				document.getElementById("hospital1inp").value = obj.id;
			} else {

				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}
function hosloads() {// 获取合作医院列表

	var hosid = document.getElementById("hospital1inp").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "hosadmin/getCollabHospital.do",

		async : false,
		data : {
			"fun" : "hosloads",
			"hospital_id" : hosid,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {

				var ins = "";
				var length = obj.list.length;

				for ( var i = 0; i < length; i++) {
					ins = ins + "<option value='" + obj.list[i].id
							+ "''>" + obj.list[i].name
							+ "</option>";
				}
				document.getElementById("hospital2").innerHTML = ins;
			} else {

				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});

}
function hosloadt() {// 获取未合作医院列表
	var hosid = document.getElementById("hospital1inp").value;
	$.ajax({
		type : "post",
		// url : "servlet/requestServlet",
		url : "hosadmin/getNoCollabHospital.do",

		async : false,
		data : {
			"fun" : "hosloads",
			"hospital_id" : hosid,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {

				var ins = "";
				var length = obj.list.length;

				for ( var i = 0; i < length; i++) {
					ins = ins + "<option value='" + obj.list[i].id
							+ "''>" + obj.list[i].name
							+ "</option>";
				}
				document.getElementById("hospital2").innerHTML = ins;
			} else {

				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
}

function quanxianchaxun() {

	var hos1 = document.getElementById("hospital1inp").value;
	var hos2 = document.getElementById("hospital2").value;
	console.log(hos1 + "    " + hos2);
	$.ajax({
		type : "post",
		// url:"servlet/requestServlet",
		url : "hosadmin/queryPremission.do",

		data : {
			"fun" : "qxchaxun",
			"hospital_id_1" : hos1,
			"hospital_id_2" : hos2,
		/*
		 * "hosp1":index1, "hosp2":index2,
		 */
		},
		async : false,
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				// alert(data);
				var ins = "";
				var length = obj.list.length;
				for ( var i = 0; i < length; i++) {

					ins = ins + "<div class='qxlistitem'>";
					ins = ins + "<input type ='checkbox' id='cb" + i
							+ "'value='" + obj.list[i].id + "'";
					if (obj.list[i].value == "true") {
						ins = ins + "checked='checked'";
					}
					ins = ins + "//>";
					ins = ins + obj.list[i].id;
					ins = ins + "</div>";
				}
				document.getElementById("qxlb").innerHTML = ins;
				// alert("finish");

			} else {
				document.getElementById("qxlb").innerHTML = "";
				alert("没有查询结果");
			}
		},
		error : function() {
			alert("error");
		},
	});
}

function quanxianxiugai() {

	var hos1 = document.getElementById("hospital1inp").value;
	var hos2 = document.getElementById("hospital2").value;
	var length = 0;
	while (document.getElementById("cb" + length) != null) {
		length++;
	}
	if (length == 0) {
		console.log(0);
		return;
	}
	var out = "{list:[";
	for ( var i = 0; i < length - 1; i++) {
		if (document.getElementById("cb" + i).checked) {
			out = out + "{id:'" + document.getElementById("cb" + i).value
					+ "',";
			out = out + "value:'true'},";
		} else {
			out = out + "{id:'" + document.getElementById("cb" + i).value
					+ "',";
			out = out + "value:'false'},";
		}
	}
	length = length - 1;
	if (document.getElementById("cb" + length).checked) {
		out = out + "{id:'" + document.getElementById("cb" + length).value
				+ "',";
		out = out + "value:'true'}";
	} else {
		out = out + "{id:'" + document.getElementById("cb" + length).value
				+ "',";
		out = out + "value:'false'}";
	}
	out = out + "]}";
	// console.log(hos1+""+hos2+""+out);
	$.ajax({
		type : "post",
		// url:"servlet/requestServlet",
		url : "hosadmin/editPremission.do",

		data : {
			"fun" : "qxxiugai2",
			"hospital_id_1" : hos1,
			"hospital_id_2" : hos2,
			"list" : out,
		},
		async : false,
		success : function(data) {
			// alert("success");
			// alert(data);
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				alert("修改失败");
				return;
			} else {
				alert("修改成功");
			}
		},
		error : function() {
			alert("error");
		},
	});
}
