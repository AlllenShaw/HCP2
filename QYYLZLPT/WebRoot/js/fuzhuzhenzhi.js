function xuetangload() {
	var did = document.getElementById("loginuserid").value;
	$
			.ajax({
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
					if(obj.result=="0"){
						alert("获取信息失败");
						return;
					}
					var length = obj.list.length;
					var tb = document.getElementById("aftable");
					for ( var i = 0; i < length; i++) {
						var row = tb.insertRow();
						var cell1 = row.insertCell(0);
						var cell2 = row.insertCell(1);
						var cell3 = row.insertCell(2);
						cell1.innerHTML = obj.list[i].id;
						cell2.innerHTML = "<label class='addtype2'" + ">"
								+ obj.list[i].realname + "</label>";
						cell3.innerHTML = "<input type='button' value='信息' onclick='xuetangdetail("
								+ obj.list[i].id
								+ ",this)' style='width: 95%'></input>";
					}
				},
				error : function() {
					alert("error");
				},
			});
}
function xuetangdetail(pid, targetControl) {

	var did = document.getElementById("loginuserid").value;
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;
	console.log("did= " + did + " pid= " + pid + " pname = " + pname);

	document.getElementById("liebiao").style.display = "none";
	document.getElementById("chartframe").style.display = "";
	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;

	$.ajax({
		type : "post",
		url : "doctor/predictGlu.do",
		async : false,
		data : {
			"fun" : "xuetangyujing",
			"patient_id" : pid,
		},
		success : function(data) {
			// alert("success");
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				document.getElementById("nore").style.display = "";
				document.getElementById("jqChart").style.display="none";
				return;
			}
			document.getElementById("jqChart").style.display="";
			document.getElementById("nore").style.display = "none";
			processdataxt(obj.list);
		},
		error : function() {
			alert("error");
		},
	});
	// 2-10 mmol/L
}

function xueyaload() {
	var did = document.getElementById("loginuserid").value;
	$
			.ajax({
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
					if(obj.result=="0"){
						alert("获取信息失败");
						return;
					}
					var length = obj.list.length;
					var tb = document.getElementById("aftable");
					for ( var i = 0; i < length; i++) {
						var row = tb.insertRow();
						var cell1 = row.insertCell(0);
						var cell2 = row.insertCell(1);
						var cell3 = row.insertCell(2);
						cell1.innerHTML = obj.list[i].id;
						cell2.innerHTML = "<label class='addtype2'" + ">"
								+ obj.list[i].realname + "</label>";
						cell3.innerHTML = "<input type='button' value='信息' onclick='xueyadetail("
								+ obj.list[i].id
								+ ",this)' style='width: 95%'></input>";
					}
				},
				error : function() {
					alert("error");
				},
			});
}
function xueyadetail(pid, targetControl) {
	var did = document.getElementById("loginuserid").value;
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;
	console.log("did= " + did + " pid= " + pid + " pname = " + pname);
	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;

	document.getElementById("liebiao").style.display = "none";
	document.getElementById("chartframe").style.display = "";

	$.ajax({
		type : "post",
		url : "doctor/predictHtn.do",
		async : false,
		data : {
			"fun" : "xueyayujing",
			"patient_id" : pid,
		},
		success : function(data) {
			// alert("success");
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				document.getElementById("nore").style.display = "";
				document.getElementById("jqChart").style.display="none";
				return;
			}
			document.getElementById("jqChart").style.display="";
			document.getElementById("nore").style.display = "none";
			processdataxy(obj.list);
		},
		error : function() {
			alert("error");
		},
	});

}

function xuezhiload() {
	var did = document.getElementById("loginuserid").value;
	$
			.ajax({
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
					if(obj.result=="0"){
						alert("获取信息失败");
						return;
					}
					var length = obj.list.length;
					var tb = document.getElementById("aftable");
					for ( var i = 0; i < length; i++) {
						var row = tb.insertRow();
						var cell1 = row.insertCell(0);
						var cell2 = row.insertCell(1);
						var cell3 = row.insertCell(2);
						cell1.innerHTML = obj.list[i].id;
						cell2.innerHTML = "<label class='addtype2'" + ">"
								+ obj.list[i].realname + "</label>";
						cell3.innerHTML = "<input type='button' value='信息' onclick='xuezhidetail("
								+ obj.list[i].id
								+ ",this)' style='width: 95%'></input>";
					}
				},
				error : function() {
					alert("error");
				},
			});
}

function xuezhidetail(pid, targetControl) {

	var did = document.getElementById("loginuserid").value;
	targetControl = targetControl.parentNode;
	targetControl = targetControl.parentNode;
	var pname = targetControl.cells[1].childNodes[0].innerHTML;
	console.log("did= " + did + " pid= " + pid + " pname = " + pname);
	document.getElementById("tid").value = pid;
	document.getElementById("tname").value = pname;

	document.getElementById("liebiao").style.display = "none";
	document.getElementById("chartframe").style.display = "";

	$.ajax({
		type : "post",
		url : "doctor/predictHpl.do",
		async : false,
		data : {
			"fun" : "xuezhiyujing",
			"patient_id" : pid,
		},
		success : function(data) {
			// alert("success");
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				document.getElementById("nore").style.display = "";
				document.getElementById("jqChart").style.display="none";
				return;
			}
			document.getElementById("jqChart").style.display="";
			document.getElementById("nore").style.display = "none";
			processdataxz(obj.list);
		},
		error : function() {
			alert("error");
		},
	});

}
// 画图
/* var jq; */

// 数据1 数据2 数据3 数据4 数据5
// 预测1 预测2 预测3
function processdataxt(list) {

	var data1 = {
		type : 'line',
		title : list[0].title,
		data : [ [ '数据1', list[0].value[0] ], [ '数据2', list[0].value[1] ],
				[ '数据3', list[0].value[2] ], [ '数据4', list[0].value[3] ],
				[ '数据5', list[0].value[4] ], [ '预测1', list[0].value[5] ],
				[ '预测2', list[0].value[6] ], [ '预测3', list[0].value[7] ] ]
	};
	datatrend1 = {
		type : 'trendline',
		title : '血糖最小值警示线',// 5.0
		data : [ [ '数据1', 1.5 ], [ '数据2', 1.5 ], [ '数据3', 1.5 ],
				[ '数据4', 1.5 ], [ '数据5', 1.5 ], [ '预测1', 1.5 ], [ '预测2', 1.5 ],
				[ '预测3', 1.5 ] ]
	};
	datatrend2 = {
		type : 'trendline',
		title : '血糖最大值警示线',// 7.8
		data : [ [ '数据1', 12.0 ], [ '数据2', 12.0 ], [ '数据3', 12.0 ],
				[ '数据4', 12.0 ], [ '数据5', 12.0 ], [ '预测1', 12.0 ], [ '预测2', 12.0 ],
				[ '预测3', 12.0 ] ]
	};
	odata = [ data1, datatrend1, datatrend2 ];
	var ti = "血糖值---mmol/L";
	var axey = {
		title : {
			text : '血糖值---mmol/L'
		},
		location : 'left',// y轴位置，取值：left,right
		minimum : 0,// y轴刻度最小值
		maximum : 30,// y轴刻度最大值
		interval : 5.0
	// 刻度间距
	};
	drawjqChart(ti, axey, odata);
}

function processdataxy(list) {

	var data1 = {
		type : 'line',
		title : list[0].title,
		data : [ [ '数据1', list[0].value[0] ], [ '数据2', list[0].value[1] ],
				[ '数据3', list[0].value[2] ], [ '数据4', list[0].value[3] ],
				[ '数据5', list[0].value[4] ], [ '预测1', list[0].value[5] ],
				[ '预测2', list[0].value[6] ], [ '预测3', list[0].value[7] ] ]
	};
	var data2 = {
		type : 'line',
		title : list[1].title,
		data : [ [ '数据1', list[1].value[0] ], [ '数据2', list[1].value[1] ],
				[ '数据3', list[1].value[2] ], [ '数据4', list[1].value[3] ],
				[ '数据5', list[1].value[4] ], [ '预测1', list[1].value[5] ],
				[ '预测2', list[1].value[6] ], [ '预测3', list[1].value[7] ] ]
	};
	var data3 = {
		type : 'line',
		title : list[2].title,
		data : [ [ '数据1', list[2].value[0] ], [ '数据2', list[2].value[1] ],
				[ '数据3', list[2].value[2] ], [ '数据4', list[2].value[3] ],
				[ '数据5', list[2].value[4] ], [ '预测1', list[2].value[5] ],
				[ '预测2', list[2].value[6] ], [ '预测3', list[2].value[7] ] ]
	};

	datatrend1 = {
		type : 'trendline',
		title : '收缩压最小警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 60 ], [ '数据2', 60 ], [ '数据3', 60 ], [ '数据4', 60 ],
				[ '数据5', 60 ], [ '预测1', 60 ], [ '预测2', 60 ], [ '预测3', 60 ] ]
	};
	datatrend2 = {
		type : 'trendline',
		title : '收缩压最大警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 220 ], [ '数据2', 220 ], [ '数据3', 220 ], [ '数据4', 220 ],
				[ '数据5', 220 ], [ '预测1', 220 ], [ '预测2', 220 ], [ '预测3', 220 ] ]
	};datatrend3 = {
		type : 'trendline',
		title : '舒张压最小警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 30 ], [ '数据2', 30 ], [ '数据3', 30 ], [ '数据4', 30 ],
				[ '数据5', 30 ], [ '预测1', 30 ], [ '预测2', 30 ], [ '预测3', 30 ] ]
	};datatrend4 = {
		type : 'trendline',
		title : '舒张压最大警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 150 ], [ '数据2', 150 ], [ '数据3', 150 ], [ '数据4', 150 ],
				[ '数据5', 150 ], [ '预测1', 150 ], [ '预测2', 150 ], [ '预测3', 150 ] ]
	};
	datatrend5 = {
		type : 'trendline',
		title : '心率最小警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 60 ], [ '数据2', 60 ], [ '数据3', 60 ], [ '数据4', 60 ],
				[ '数据5', 60 ], [ '预测1', 60 ], [ '预测2', 60 ], [ '预测3', 60 ] ]
	};
	datatrend6 = {
		type : 'trendline',
		title : '心率最大警示线',// 75
		// data : [ [ 0, 75 ], [ 100, 75 ] ]
		data : [ [ '数据1', 140 ], [ '数据2', 140 ], [ '数据3', 140 ], [ '数据4', 140 ],
				[ '数据5', 140 ], [ '预测1', 140 ], [ '预测2', 140 ], [ '预测3', 140 ] ]
	};
	odata = [ data1, data2, data3,  datatrend1,datatrend2,datatrend3,datatrend4,datatrend5,datatrend6 ];
	var ti = "血压---mmHg";
	var axey = {
		title : {
			text : ''
		},
		location : 'left',// y轴位置，取值：left,right
		minimum : 10,// y轴刻度最小值
		maximum : 200,// y轴刻度最大值
		interval : 10
	// 刻度间距
	};
	drawjqChart(ti, axey, odata);
}

function processdataxz(list) {

	var data1 = {
		type : 'line',
		title : list[0].title,
		data : [ [ '数据1', list[0].value[0] ], [ '数据2', list[0].value[1] ],
				[ '数据3', list[0].value[2] ], [ '数据4', list[0].value[3] ],
				[ '数据5', list[0].value[4] ], [ '预测1', list[0].value[5] ],
				[ '预测2', list[0].value[6] ], [ '预测3', list[0].value[7] ] ]
	};
	var data2 = {
		type : 'line',
		title : list[1].title,
		data : [ [ '数据1', list[1].value[0] ], [ '数据2', list[1].value[1] ],
				[ '数据3', list[1].value[2] ], [ '数据4', list[1].value[3] ],
				[ '数据5', list[1].value[4] ], [ '预测1', list[1].value[5] ],
				[ '预测2', list[1].value[6] ], [ '预测3', list[1].value[7] ] ]
	};
	var data3 = {
		type : 'line',
		title : list[2].title,
		data : [ [ '数据1', list[2].value[0] ], [ '数据2', list[2].value[1] ],
				[ '数据3', list[2].value[2] ], [ '数据4', list[2].value[3] ],
				[ '数据5', list[2].value[4] ], [ '预测1', list[2].value[5] ],
				[ '预测2', list[2].value[6] ], [ '预测3', list[2].value[7] ] ]
	};
	var data4 = {
		type : 'line',
		title : list[3].title,
		data : [ [ '数据1', list[3].value[0] ], [ '数据2', list[3].value[1] ],
				[ '数据3', list[3].value[2] ], [ '数据4', list[3].value[3] ],
				[ '数据5', list[3].value[4] ], [ '预测1', list[3].value[5] ],
				[ '预测2', list[3].value[6] ], [ '预测3', list[3].value[7] ] ]
	};
	datatrend1 = {
		type : 'trendline',
		title : '总胆固醇最小警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 1.8 ], [ '数据2', 1.8 ], [ '数据3', 1.8 ], [ '数据4', 1.8 ],
				[ '数据5', 1.8 ], [ '预测1', 1.8 ], [ '预测2', 1.8 ], [ '预测3', 1.8 ] ]
	};
	datatrend2 = {
		type : 'trendline',
		title : '总胆固醇最大警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 12.5 ], [ '数据2', 12.5], [ '数据3', 12.5 ], [ '数据4', 12.5 ],
				[ '数据5', 12.5 ], [ '预测1', 12.5 ], [ '预测2', 12.5 ], [ '预测3', 12.5 ] ]
	};
	datatrend3 = {
		type : 'trendline',
		title : '甘油三酯最小警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 0.2 ], [ '数据2', 0.2 ], [ '数据3', 0.2 ], [ '数据4', 0.2 ],
				[ '数据5', 0.2 ], [ '预测1', 0.2 ], [ '预测2', 0.2 ], [ '预测3', 0.2 ] ]
	};
	datatrend4 = {
		type : 'trendline',
		title : '甘油三酯最大警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 2.3 ], [ '数据2', 2.3 ], [ '数据3', 2.3 ], [ '数据4', 2.3 ],
				[ '数据5', 2.3 ], [ '预测1', 2.3 ], [ '预测2', 2.3 ], [ '预测3', 2.3 ] ]
	};
	datatrend5 = {
		type : 'trendline',
		title : '高密度脂蛋白胆固醇最小警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 0.8 ], [ '数据2', 0.8 ], [ '数据3', 0.8 ], [ '数据4', 0.8 ],
				[ '数据5', 0.8 ], [ '预测1', 0.8 ], [ '预测2', 0.8 ], [ '预测3', 0.8 ] ]
	};
	datatrend6 = {
		type : 'trendline',
		title : '高密度脂蛋白胆固醇最大警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 1.5 ], [ '数据2', 1.5 ], [ '数据3', 1.5 ], [ '数据4', 1.5 ],
				[ '数据5', 1.5 ], [ '预测1', 1.5 ], [ '预测2', 1.5 ], [ '预测3', 1.5 ] ]
	};
	datatrend7 = {
		type : 'trendline',
		title : '低密度脂蛋白胆固醇最小警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 2.2 ], [ '数据2', 2.2 ], [ '数据3', 2.2 ], [ '数据4', 2.2 ],
				[ '数据5', 2.2 ], [ '预测1', 2.2 ], [ '预测2', 2.2 ], [ '预测3', 2.2 ] ]
	};	datatrend = {
		type : 'trendline',
		title : '低密度脂蛋白胆固醇最大警示线',// 75
		// data : [ [ 0, 11 ], [ 100, 11 ] ]
		data : [ [ '数据1', 5.3 ], [ '数据2', 5.3 ], [ '数据3', 5.3 ], [ '数据4', 5.3 ],
				[ '数据5', 5.3 ], [ '预测1', 5.3 ], [ '预测2', 5.3 ], [ '预测3', 5.3 ] ]
	};
	odata = [ data1, data2, data3, data4, datatrend1, datatrend2, datatrend3, datatrend4, datatrend5, datatrend6, datatrend7, datatrend8 ];
	var ti = "血脂---mmol/L";
	var axey = {
		title : {
			text : ''
		},
		location : 'left',// y轴位置，取值：left,right
		minimum : 0,// y轴刻度最小值
		maximum : 15,// y轴刻度最大值
		interval : 1.0
	// 刻度间距
	};
	drawjqChart(ti, axey, odata);
}

function drawjqChart(ti, axe, conf) {
	/*
	 * if(jq){
	 * 
	 * jq=jQuery('#jqChart').jqChart('update',conf); alert(conf); return; }
	 */
	jq = jQuery('#jqChart').jqChart({
		title : {
			text : ti
		},
		animation : {
			duration : 1
		},
		axes : axe,
		series : conf
	});
};
/*
 * // 2-10 mmol/L var ti = "血脂---mmol/L"; var axey = { title : { text : '' },
 * location : 'left',// y轴位置，取值：left,right minimum : 0,// y轴刻度最小值 maximum :
 * 15,// y轴刻度最大值 interval : 1.0 // 刻度间距 }; var data1 = { type : 'line',//
 * 图表类型，取值：column 柱形图，line 线形图 title : '总胆固醇值',// 标题 2.2-11.7 // data: [['一月',
 * 70], ['二月', 40], ['三月', 55], ['四月', 50], ['五月', 60], // ['六月', 40]]//
 * 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] data : [ [ '第一天', 5.5 ], [ '第二天', 5.4 ], [
 * '第三天', 4.5 ], [ '第四天', 8.5 ], [ '第五天', 8.3 ], [ '第六天', 9.5 ], [ '第七天', 10 ], [
 * '第八天', 11 ] ] // 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] }; var data2 = { type :
 * 'line', title : '甘油三酯值',// 0.5-1.7 data : [ [ '第一天', 0.8 ], [ '第二天', 0.9 ], [
 * '第三天', 0.9 ], [ '第四天', 0.95 ], [ '第五天', 1.2 ], [ '第六天', 1.7 ], [ '第七天', 1.5 ], [
 * '第八天', 1.6 ] ] }; var data3 = { type : 'line', title : '高密度脂蛋白胆固醇值',//
 * 1.16-1.42 data : [ [ '数据1', 1.2 ], [ '数据2', 1.3 ], [ '数据3', 1.4 ], [ '数据4',
 * 1.22 ], [ '数据5', 1.10 ], [ '预测1', 1.40 ], [ '预测2', 1.21 ], [ '预测3', 1.33 ] ] };
 * var data4 = { type : 'line', title : '低密度脂蛋白胆固醇值',// 2.7-4.14 data : [ [
 * '第一天', 2.5 ], [ '第二天', 2.55 ], [ '第三天', 2.8 ], [ '第四天', 3.39 ], [ '第五天', 2.4 ], [
 * '预测1', 3.12 ], [ '预测2', 3.89 ], [ '预测3', 4.00 ] ] }; datatrend = {
 * 
 * type : 'trendline', title : '总胆固醇警示线',// 75
 * 
 * data : [ [ 0, 11 ], [ 100, 11 ] ]
 * 
 * data : [ [ '第一天', 75 ], [ '第二天', 75 ], [ '第三天', 75 ], [ '第四天', 75 ], [ '第五天',
 * 75 ], [ '第六天', 75 ], [ '第七天', 75 ], [ '第八天', 75 ] ] }; data = [ data1, data2,
 * data3, data4, datatrend ]; // drawjqChart(ti, axey, data); // 2-10 mmol/L var
 * ti = "血压---mmol/L"; var axey = { title : { text : '' }, location : 'left',//
 * y轴位置，取值：left,right minimum : 10,// y轴刻度最小值 maximum : 200,// y轴刻度最大值 interval :
 * 10 // 刻度间距 }; var data1 = { type : 'line',// 图表类型，取值：column 柱形图，line 线形图
 * title : '收缩压',// 标题 80-200 // data: [['一月', 70], ['二月', 40], ['三月', 55],
 * ['四月', 50], ['五月', 60], // ['六月', 40]]//
 * 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] data : [ [ '第一天', 90 ], [ '第二天', 120 ], [
 * '第三天', 135 ], [ '第四天', 115 ], [ '第五天', 150 ], [ '第六天', 114 ], [ '第七天', 99 ], [
 * '第八天', 113 ] ] // 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] }; var data2 = { type :
 * 'line', title : '舒张压',// 50-130 data : [ [ '第一天', 95 ], [ '第二天', 80 ], [
 * '第三天', 72 ], [ '第四天', 120 ], [ '第五天', 90 ], [ '第六天', 123 ], [ '第七天', 99 ], [
 * '第八天', 85 ] ] }; var data3 = { type : 'line', title : '心率',// 30-120 data : [ [
 * '第一天', 80 ], [ '第二天', 90 ], [ '第三天', 75 ], [ '第四天', 70 ], [ '第五天', 80 ], [
 * '第六天', 71 ], [ '第七天', 76 ], [ '第八天', 75 ] ] }; datatrend = {
 * 
 * type : 'trendline', title : '心率警示线',// 75
 * 
 * data : [ [ 0, 75 ], [ 100, 75 ] ] /* data : [ [ '第一天', 75 ], [ '第二天', 75 ], [
 * '第三天', 75 ], [ '第四天', 75 ], [ '第五天', 75 ], [ '第六天', 75 ], [ '第七天', 75 ], [
 * '第八天', 75 ] ] }; data = [ data1, data2, data3, datatrend ]; drawjqChart(ti,
 * axey, data); var ti = "血糖值---mmol/L"; var axey = { title : { text :
 * '血糖值---mmol/L' }, location : 'left',// y轴位置，取值：left,right minimum : 0,//
 * y轴刻度最小值 maximum : 30,// y轴刻度最大值 interval : 5.0 // 刻度间距 }; var data1 = { type :
 * 'line',// 图表类型，取值：column 柱形图，line 线形图 title : '血糖',// 标题 80-200 // data:
 * [['一月', 70], ['二月', 40], ['三月', 55], ['四月', 50], ['五月', 60], // ['六月', 40]]//
 * 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] data : [ [ '第一天', 3.9 ], [ '第二天', 5.5 ], [
 * '第三天', 5.6 ], [ '第四天', 4.3 ], [ '第五天', 4.8 ], [ '第六天', 4.1 ], [ '第七天', 4.8 ], [
 * '第八天', 28 ] ] // 数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......] };
 * 
 * datatrend1 = { type : 'trendline', title : '餐前血糖警示线',// 5.0 data : [ [ '第一天',
 * 5.0 ], [ '第二天', 5.0 ], [ '第三天', 5.0 ], [ '第四天', 5.0 ], [ '第五天', 5.0 ], [
 * '第六天', 5.0 ], [ '第七天', 5.0 ], [ '第八天', 5.0 ] ] }; datatrend2 = { type :
 * 'trendline', title : '餐后2小时血糖警示线',// 7.8 data : [ [ '第一天', 7.8 ], [ '第二天',
 * 7.8 ], [ '第三天', 7.8 ], [ '第死天', 7.8 ], [ '第五天', 7.8 ], [ '第六天', 7.8 ], [
 * '第七天', 7.8 ], [ '第八天', 7.8 ] ] }; data = [ data1, datatrend1, datatrend2 ];
 * 
 * drawjqChart(ti, axey, data);
 */