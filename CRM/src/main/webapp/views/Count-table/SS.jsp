<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
<script src="../../static/js/echarts.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function() {
		laylogin("");
		$("#serz").css("display","none");
	});
	function year() {
		var a = $("#years").val();
		laylogin(a);
	}
	function laylogin(ctime) {
		$("#sery").css("display","block");
		$("#serf").css("display","block");
		$("#serz").css("display","none");
		if (ctime == "") {
			ctime = "全部";
		}
		var myChart = echarts.init(document.getElementById('serf'));
		$.post('/Ssel/sel', {
			ctime : ctime
		}, function(data) {
			var num = new Array(3);
			for (var i = 0; i < data.length; i++) {

				if (data[i].tname == "咨询") {
					num[0] = data[i].tsum;
				} else if (data[i].tname == "投诉") {
					num[1] = data[i].tsum;
				} else {
					num[2] = data[i].tsum;
				}
			}

			echarts.init(document.getElementById('sery')).setOption(
					{
						tooltip : {
							formatter : "{a}<br/>{b}:{c}({d}%)"
						},
						toolbox : {
							feature : {
								saveAsImage : {
									show : true
								}
							}
						},
						title : {
							text : ctime + '年份各服务类型的占比',
							x : 'center'
						},
						legend : {
							orient : 'vertical',
							left : 'left',
							data : [ "咨询", "投诉", "建议" ]
						},
						series : {
							type : 'pie',
							radius : [ '50%', '70%' ],
							itemStyle : {
								normal : {
									color : function(params) {
										var colorList = [ '#C33531', '#EFE42A',
												'#64BD3D', '#EE9201',
												'#29AAE3', '#B74AE5',
												'#0AAF9F', '#E89589',
												'#16A085', '#4A235A',
												'#C39BD3 ', '#F9E79F',
												'#BA4A00', '#ECF0F1',
												'#616A6B', '#EAF2F8',
												'#4A235A', '#3498DB' ];
										return colorList[params.dataIndex]
									}
								},
							},
							data : [ {
								name : '咨询',
								value : num[0]
							}, {
								name : '投诉',
								value : num[1]
							}, {
								name : '建议',
								value : num[2]
							} ]
						}
					});

			myChart.setOption({
				toolbox : {
					feature : {
						saveAsImage : {
							show : true
						}
					}
				},
				title : {
					text : ctime + '年份各服务类型数量'
				},
				tooltip : {},
				xAxis : {
					data : [ "咨询", "投诉", "建议" ]
				},
				yAxis : {},
				series : [ {
					name : '总数量',
					type : 'bar',
					itemStyle : {
						normal : {
							color : function(params) {
								var colorList = [ '#C33531', '#EFE42A',
										'#64BD3D', '#EE9201', '#29AAE3',
										'#B74AE5', '#0AAF9F', '#E89589',
										'#16A085', '#4A235A', '#C39BD3 ',
										'#F9E79F', '#BA4A00', '#ECF0F1',
										'#616A6B', '#EAF2F8', '#4A235A',
										'#3498DB' ];
								return colorList[params.dataIndex]
							}
						},
					},
					data : [ num[0], num[1], num[2] ]
				} ]
			});
		}, "json"
		)
	}
	function selz(){
		$("#sery").css("display","none");
		$("#serf").css("display","none");
		$("#serz").css("display","block");
		$.post('/Ssel/sel2', {
		}, function(data) {
			var num = new Array(3);
			var list = new Array(5);
			list[0] =data.sel1;
			list[1] =data.sel2;
			list[2] =data.sel3;
			list[3] =data.sel4;
			list[4] =data.sel5;
			num[0]=new Array(5);
			num[1]=new Array(5);
			num[2]=new Array(5);
			for(var j = 0; j < 5; j++){
				for (var i = 0; i < list[j].length; i++) {
					if (list[j][i].tname == "咨询") {
						num[0][j] = list[j][i].tsum;
					} else if (list[j][i].tname == "投诉") {
						num[1][j] = list[j][i].tsum;
					} else {
						num[2][j] = list[j][i].tsum;
					}
				}
			}
			echarts.init(document.getElementById('serz')).setOption({
				toolbox : {
					feature : {
						saveAsImage : {
							show : true
						}
					}
				},
				title : {
					text : '近五年各服务类型数量'
				},
				tooltip : {},
				legend: {
			        data:["咨询", "投诉", "建议"]
			    },
				xAxis : {
					data : ['2015','2016','2017','2018','2019']
				},
				yAxis : {},
				series : [ 
					{
						name : '咨询',
						type:'line',
						data : [ num[0][0], num[0][1], num[0][2], num[0][3], num[0][4] ]
					},
					{
						name : '投诉',
						type:'line',
						data : [ num[1][0], num[1][1], num[1][2], num[1][3], num[1][4] ]
					},
					{
						name : '建议',
						type:'line',
						data : [ num[2][0], num[2][1], num[2][2], num[2][3], num[2][4] ]
					},
				]
			});
		}, "json"
		)
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="x-nav">
		 <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div >		
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend class="layui-bg-green" style="font-size:35px;">客户服务分析</legend>
		</fieldset>
		<div>
			年份: <select id="years"
				style="width: 200px; height: 40px; margin-left: 100px;">
				<option value="全部">全部</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
			</select>
			<button onclick="year()"
				style="width: 120px; height: 40px; margin-left: 60px;">查询</button>
				<button onclick="selz()"
				style="width: 300px; height: 40px; float: right;">查询近五年每年各服务类型数量</button>
		</div>
		<div id="sery" style="width: 60%; height: 550px; margin: 30px auto;"></div>
		<div id="serf" style="width: 60%; height: 550px; margin: 30px auto;"></div>
		<div id="serz" style="width: 60%; height: 550px; margin: 30px auto;"></div>
	</div>

</body>
</html>