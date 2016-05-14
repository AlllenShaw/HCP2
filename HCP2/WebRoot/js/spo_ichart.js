function draw(temp){
	var value = [];
	var labels = [];
	for(var j=0;j<7;j++)
		{
			value.push(temp[2*j+1]);
			labels.push(temp[2*j].substr(0,10));
		}
	var data = [ {
		name : '血氧饱和度',
		value : value,
		color : '#1f7e92',
		line_width : 3
	} ];
	var chart = new iChart.LineBasic2D(
			{
				render : 'ichart',
				data : data,
				align : 'center',
				title : {
					text : '血氧最近7天变化曲线图',
					font : '微软雅黑',
					fontsize : 24,
				},
				subtitle : {
					text : '包含预测',
					font : '微软雅黑',
				},
				footnote : {
					text : '协同平台',
					font : '微软雅黑',
					fontsize : 11,
					fontweight : 600,
					padding : '10 0',
				},
				width : 650,
				height : 400,
				tip : {
					enable : true,
					shadow : true,
					listeners : {
						// tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
						parseText : function(tip, name, value, text, i) {
							return "<span style='color:black;font-size:12px;'>"
									+ labels[i]
									+ name+":<br/>"
									+ "</span><span style='color:black;font-size:20px;'>"
									+ value + "%</span>";
						}
					}
				},
				coordinate : {
					height : '90%',
					background_color : '#f6f9fa',
					scale : [ {
						position : 'left',
						start_scale : 90,
						end_scale : 100,
						scale_space : 10,
						scale_size : 2,
						scale_enable : false,
						label : {
							font : '微软雅黑',
							fontsize : 11,
							fontweight : 600
						},
						scale_color : '#9f9f9f'
					}, {
						position : 'bottom',
						label : {
							font : '微软雅黑',
							fontsize : 11,
							fontweight : 600
						},
						scale_enable : false,
						labels : labels
					} ]
				},
				sub_option : {
					
					label:false,
					hollow:false,
					hollow_inside : false,// 设置一个点的亮色在外环的效果
					point_size : 8
				}
			});
	chart.plugin(new iChart.Custom({
		drawFn : function() {
			// 计算位置
			var coo = chart.getCoordinate(),
			x = coo.get('originx'), 
			y = coo.get('originy'),
			w = coo.width, 
			h = coo.height;
			// 在左上侧的位置，渲染一个单位的文字
			chart.target.textAlign('start')
			.textBaseline('bottom').textFont('600 11px 微软雅黑')
			.fillText('血氧饱和度(%)', x - 40, y - 12,false);
			/*
			.textBaseline('top')
			.fillText('(时间)',x + w + 20, y + h + 10, false);
			*/
			var avg = 95,
			x = coo.get('originx'),
			W = coo.width,
			S = coo.getScale('left'),
			H = coo.height,
			h = (avg - S.start) * H / S.distance,
			y = chart.y + H - h;
		
			chart.target.line(x,y,x+W,y,1,'#b32c0d')
			.textAlign('start')
			.textBaseline('middle')
			.textFont('600 12px Verdana')
			.fillText('下限:'+avg,x+W+5,y,false,'#b32c0d');
			
			avg=98,
			h = (avg - S.start) * H / S.distance,
			y = chart.y + H - h;
		
			chart.target.line(x,y,x+W,y,1,'#b32c0d')
			.textAlign('start')
			.textBaseline('middle')
			.textFont('600 12px Verdana')
			.fillText('上限:'+avg,x+W+5,y,false,'#b32c0d');
		}
	}));
	chart.draw();
}
