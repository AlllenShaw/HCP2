$(function() {
	var tc = [],tg=[],ldlc=[],hdlc=[];
	for ( var i = 0; i < 7; i++) {
		tc.push(Math.floor(Math.random() *7));
		tg.push(Math.floor(Math.random() *3));
		ldlc.push(Math.floor(Math.random() *5));
		hdlc.push(Math.floor(Math.random() *2));
	}
	var data = [ {
		name : '总胆固醇',
		value : tc,
		color : '#1f7e92',
		line_width : 1,
		sign:'round-bar'
	},
	{
		name : '甘油三酯',
		value : tg,
		color : '#89a54e',
		line_width : 1,
		sign:'round-bar'
	},
	{
		name : '低密度脂蛋白',
		value : ldlc,
		color : '#ec4646',
		line_width : 1,
		sign:'round-bar'
	},
	{
		name : '高密度脂蛋白',
		value : hdlc,
		color : '#80699b',
		line_width : 1,
		sign:'round-bar'
	}];
	var labels = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
	var chart = new iChart.LineBasic2D(
			{
				render : 'ichart',
				data : data,
				align : 'center',
				title : {
					text : '血脂最近一周变化曲线图',
					font : '微软雅黑',
					fontsize : 24,
				},
				legend : {
					enable : true,
					row:1,//设置在一行上显示，与column配合使用
					column : 'max',
					valign:'top',
					sign:'bar',
					background_color:null,//设置透明背景
					offsetx:-50,//设置x轴偏移，满足位置需要
					offsety:-10,
					border : true
				},
				footnote : {
					text : '协同平台',
					font : '微软雅黑',
					fontsize : 11,
					fontweight : 600,
					padding : '10 0',
				},
				width : 650,
				height : 450,
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
									+ value+"mmol/L</span>";
						}
					}
				},
				coordinate : {
					height : '90%',
					background_color : '#f6f9fa',
					scale : [ {
						position : 'left',
						start_scale : 0,
						end_scale : 7,
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
			.fillText('血脂', x - 40, y - 12,false)
			.textBaseline('top')
			.fillText('(时间)',x + w + 20, y + h + 10, false);
		}
	}));
	chart.draw();
});