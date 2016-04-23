
function yaowu() {

	var did = document.getElementById("loginuserid").value;

	var targetSlect = document.getElementById("drugtype");
	var type = targetSlect.options[targetSlect.selectedIndex].value;

	//alert("did= " + did + " type= " + type);

	$.ajax({
		type : "post",
		url : "doctor/getMedicineByType.do",
		async : false,
		data : {
			"fun" : "yaowu",
			"type" : type,
			"doctor_id" : did,
		},
		success : function(data) {
			// alert("success");
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				alert("获取失败，没有此药");

				return;
			}
			var ins = "";
			length = obj.list.length;
			for ( var i = 0; i < length; i++) {
				ins = ins + "<option value='" + obj.list[i].id + "''>"
						+ obj.list[i].name + "</option>";
			}
			document.getElementById("druga").innerHTML = ins;
			document.getElementById("drugb").innerHTML = ins;
		},
		error : function() {
			alert("error");
		},
	});
	// 2-10 mmol/L
}

function compare() {

	var did = document.getElementById("loginuserid").value;
	var targetSlect = document.getElementById("druga");
	var druga = targetSlect.options[targetSlect.selectedIndex].value;
	targetSlect = document.getElementById("drugb");
	var drugb = targetSlect.options[targetSlect.selectedIndex].value;
	var targetSlect = document.getElementById("drugtype");
	var type = targetSlect.options[targetSlect.selectedIndex].value;
	if (druga == drugb) {
		alert("请选择两种不相同的药物");
		return;
	}
	$.ajax({
		type : "post",
		url : "doctor/compare.do",
		async : false,
		data : {
			"fun" : "compare",
			"doctor_id" : did,
			"type" : type,
			"druga" : druga,
			"drugb" : drugb,
			
		},
		success : function(data) {
			// alert("success");
			var obj = new Function("return" + data)();
			if (obj.result == "0") {
				alert("获取失败");
				return;
			}

			if (type == "1") {
				processdataxy(obj.list1,obj.list2);
			}
			if (type == "2") {
				processdataxt(obj.list1,obj.list2);
			}
			if (type == "3") {
				processdataxz(obj.list1,obj.list2);
			}

		},
		error : function() {
			alert("error");
		},
	});

}

function processdataxt(list1, list2) {

	var data1 = {
		type : 'line',
		title : "A-"+list1[0].title,
		data : [ [ '数据1', list1[0].value[0] ], [ '数据2', list1[0].value[1] ],
				[ '数据3', list1[0].value[2] ], [ '数据4', list1[0].value[3] ],
				[ '数据5', list1[0].value[4] ], [ '数据6', list1[0].value[5] ],
				[ '数据7', list1[0].value[6] ], [ '数据8', list1[0].value[7] ] ]
	};
	var data2 = {
		type : 'line',
		title : "B-"+list2[0].title,
		data : [ [ '数据1', list2[0].value[0] ], [ '数据2', list2[0].value[1] ],
				[ '数据3', list2[0].value[2] ], [ '数据4', list2[0].value[3] ],
				[ '数据5', list2[0].value[4] ], [ '数据6', list2[0].value[5] ],
				[ '数据7', list2[0].value[6] ], [ '数据8', list2[0].value[7] ] ]
	};

	odata = [ data1, data2 ];
	var ti = "血糖值---mmol/L";
	var axey = {
		title : {
			text : '血糖值---mmol/L'
		},
		location : 'left',// y轴位置，取值：left,right
		minimum : 0,// y轴刻度最小值
		maximum : 30,// y轴刻度最大值
		interval : 5.0
	};
	drawjqChart(ti, axey, odata);
}

function processdataxy(list1, list2) {

	var data1 = {
		type : 'line',
		title : "A-"+list1[0].title,
		data : [ [ '数据1', list1[0].value[0] ], [ '数据2', list1[0].value[1] ],
				[ '数据3', list1[0].value[2] ], [ '数据4', list1[0].value[3] ],
				[ '数据5', list1[0].value[4] ], [ '数据6', list1[0].value[5] ],
				[ '数据7', list1[0].value[6] ], [ '数据8', list1[0].value[7] ] ]
	};
	var data2 = {
		type : 'line',
		title : "A-"+list1[1].title,
		data : [ [ '数据1', list1[1].value[0] ], [ '数据2', list1[1].value[1] ],
				[ '数据3', list1[1].value[2] ], [ '数据4', list1[1].value[3] ],
				[ '数据5', list1[1].value[4] ], [ '数据6', list1[1].value[5] ],
				[ '数据7', list1[1].value[6] ], [ '数据8', list1[1].value[7] ] ]
	};
	var data3 = {
		type : 'line',
		title : "A-"+list1[2].title,
		data : [ [ '数据1', list1[2].value[0] ], [ '数据2', list1[2].value[1] ],
				[ '数据3', list1[2].value[2] ], [ '数据4', list1[2].value[3] ],
				[ '数据5', list1[2].value[4] ], [ '数据6', list1[2].value[5] ],
				[ '数据7', list1[2].value[6] ], [ '数据8', list1[2].value[7] ] ]
	};

	var data4 = {
		type : 'line',
		title : "B-"+list2[0].title,
		data : [ [ '数据1', list2[0].value[0] ], [ '数据2', list2[0].value[1] ],
				[ '数据3', list2[0].value[2] ], [ '数据4', list2[0].value[3] ],
				[ '数据5', list2[0].value[4] ], [ '数据6', list2[0].value[5] ],
				[ '数据7', list2[0].value[6] ], [ '数据8', list2[0].value[7] ] ]
	};
	var data5 = {
		type : 'line',
		title : "B-"+list2[1].title,
		data : [ [ '数据1', list2[1].value[0] ], [ '数据2', list2[1].value[1] ],
				[ '数据3', list2[1].value[2] ], [ '数据4', list2[1].value[3] ],
				[ '数据5', list2[1].value[4] ], [ '数据6', list2[1].value[5] ],
				[ '数据7', list2[1].value[6] ], [ '数据8', list2[1].value[7] ] ]
	};
	var data6 = {
		type : 'line',
		title : "B-"+list2[2].title,
		data : [ [ '数据1', list2[2].value[0] ], [ '数据2', list2[2].value[1] ],
				[ '数据3', list2[2].value[2] ], [ '数据4', list2[2].value[3] ],
				[ '数据5', list2[2].value[4] ], [ '数据6', list2[2].value[5] ],
				[ '数据7', list2[2].value[6] ], [ '数据8', list2[2].value[7] ] ]
	};
	odata = [ data1, data2, data3, data4, data5, data6 ];
	var ti = "血压---mmol/L";
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

function processdataxz(list1,list2) {

	var data1 = {
		type : 'line',
		title : "A-"+list1[0].title,
		data : [ [ '数据1', list1[0].value[0] ], [ '数据2', list1[0].value[1] ],
				[ '数据3', list1[0].value[2] ], [ '数据4', list1[0].value[3] ],
				[ '数据5', list1[0].value[4] ], [ '数据6', list1[0].value[5] ],
				[ '数据7', list1[0].value[6] ], [ '数据8', list1[0].value[7] ] ]
	};
	var data2 = {
		type : 'line',
		title : "A-"+list1[1].title,
		data : [ [ '数据1', list1[1].value[0] ], [ '数据2', list1[1].value[1] ],
				[ '数据3', list1[1].value[2] ], [ '数据4', list1[1].value[3] ],
				[ '数据5', list1[1].value[4] ], [ '数据6', list1[1].value[5] ],
				[ '数据7', list1[1].value[6] ], [ '数据8', list1[1].value[7] ] ]
	};
	var data3 = {
		type : 'line',
		title : "A-"+list1[2].title,
		data : [ [ '数据1', list1[2].value[0] ], [ '数据2', list1[2].value[1] ],
				[ '数据3', list1[2].value[2] ], [ '数据4', list1[2].value[3] ],
				[ '数据5', list1[2].value[4] ], [ '数据6', list1[2].value[5] ],
				[ '数据7', list1[2].value[6] ], [ '数据8', list1[2].value[7] ] ]
	};
	var data4 = {
		type : 'line',
		title : "A-"+list1[3].title,
		data : [ [ '数据1', list1[3].value[0] ], [ '数据2', list1[3].value[1] ],
				[ '数据3', list1[3].value[2] ], [ '数据4', list1[3].value[3] ],
				[ '数据5', list1[3].value[4] ], [ '数据6', list1[3].value[5] ],
				[ '数据7', list1[3].value[6] ], [ '数据8', list1[3].value[7] ] ]
	};
	
	
	var data5 = {
			type : 'line',
			title : "B-"+list2[0].title,
			data : [ [ '数据1', list2[0].value[0] ], [ '数据2', list2[0].value[1] ],
					[ '数据3', list2[0].value[2] ], [ '数据4', list2[0].value[3] ],
					[ '数据5', list2[0].value[4] ], [ '数据6', list2[0].value[5] ],
					[ '数据7', list2[0].value[6] ], [ '数据8', list2[0].value[7] ] ]
		};
		var data6 = {
			type : 'line',
			title : "B-"+list2[1].title,
			data : [ [ '数据1', list2[1].value[0] ], [ '数据2', list2[1].value[1] ],
					[ '数据3', list2[1].value[2] ], [ '数据4', list2[1].value[3] ],
					[ '数据5', list2[1].value[4] ], [ '数据6', list2[1].value[5] ],
					[ '数据7', list2[1].value[6] ], [ '数据8', list2[1].value[7] ] ]
		};
		var data7 = {
			type : 'line',
			title : "B-"+list2[2].title,
			data : [ [ '数据1', list2[2].value[0] ], [ '数据2', list2[2].value[1] ],
					[ '数据3', list2[2].value[2] ], [ '数据4', list2[2].value[3] ],
					[ '数据5', list2[2].value[4] ], [ '数据6', list2[2].value[5] ],
					[ '数据7', list2[2].value[6] ], [ '数据8', list2[2].value[7] ] ]
		};
		var data8 = {
			type : 'line',
			title : "B-"+list2[3].title,
			data : [ [ '数据1', list2[3].value[0] ], [ '数据2', list2[3].value[1] ],
					[ '数据3', list2[3].value[2] ], [ '数据4', list2[3].value[3] ],
					[ '数据5', list2[3].value[4] ], [ '数据6', list2[3].value[5] ],
					[ '数据7', list2[3].value[6] ], [ '数据8', list2[3].value[7] ] ]
		};
	
	odata = [ data1, data2, data3, data4,  data5, data6, data7, data8 ];
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

