<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>客户构成分析</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="static/css/font.css">
<link rel="stylesheet" href="static/css/xadmin.css">
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
<script src="../../static/js/echarts.min.js" charset="UTF-8"></script>
	<script src="../../static/layui/layui.js" charset="utf-8"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		//rank饼状图
		$.get("/tab/listrank", function(data) {
			//alert(JSON.stringify(data));//[{"name":"合作伙伴","num":1}]

			var dataArr = new Array();
			$.each(data, function(index, obj) {
				var a = {
					value : obj.num,
					name : obj.name
				}
				dataArr.push(a);
			})
			//	alert(dataArr)
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main2'));
			option = {
				title : {
					text : '客户等级占比',
					subtext : 'crm',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				toolbox : {
					right : '30',
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						restore : {},
						saveAsImage : {}
					}
				},
				legend : {
					orient : 'vertical',
					left : 'left',
				//  data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']

				},
				series : [ {
					name : '访问来源',
					type : 'pie',
					radius : '75%',
					center : [ '50%', '60%' ],
					data : dataArr,
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			// 指定图表的配置项和数据

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		}, "json");

		$("#credit").click(function() {//信誉度图
			$.get("/tab/listCre", function(data) {
				//alert(JSON.stringify(data));
				//[{"name":"战略合作伙伴","num":1,"cusCredi":2},{"name":"重点开发对象","num":2,"cusCredi":3}
				var dataArr = new Array();
				//alert(JSON.stringify(dataArr));
				for (var i = 1; i < 6; i++) {
					var a = 0;
					var b = 0;
					var c = 0;
					$.each(data, function(index, obj) {
						if (i == obj.cusCredi && obj.name == '战略合作伙伴') {
							a = obj.num;
						}
						if (i == obj.cusCredi && obj.name == '重点开发对象') {
							b = obj.num;
						}
						if (i == obj.cusCredi && obj.name == '合作伙伴') {
							c = obj.num;
						}

					})
					var flg = {
						product : i + '星',
						'战略合作伙伴' : a,
						'重点开发对象' : b,
						'合作伙伴' : c
					}
					//alert(JSON.stringify(flg));
					dataArr.push(flg);
				}
				//alert(JSON.stringify(dataArr));

				var myChart3 = echarts.init(document.getElementById('main3'));
				option = {
					legend : {},
					tooltip : {},
					toolbox : {
						feature : {
							right : '30',

							dataView : {
								show : true,
								readOnly : false
							},
							dataZoom : {
								yAxisIndex : 'none'
							},
							restore : {},
							saveAsImage : {}
						}
					},
					dataset : {
						dimensions : [ 'product', '战略合作伙伴', '重点开发对象', '合作伙伴' ],
						source : dataArr
					},
					xAxis : {
						type : 'category'
					},
					yAxis : {},
					// Declare several bar series, each will be mapped
					// to a column of dataset.source by default.
					series : [ {
						type : 'bar'
					}, {
						type : 'bar'
					}, {
						type : 'bar'
					} ]
				};

				myChart3.setOption(option);
			}, "json");

		});
		$("#satisfaction").click(function() {//满意度图
			$.get("/tab/listSati", function(data) {
				//alert(JSON.stringify(data))
				var dataArr = new Array();
				for (var i = 1; i < 6; i++) {
					var a = 0;
					var b = 0;
					var c = 0;
					$.each(data, function(index, obj) {
						if (i == obj.cusSati && obj.name == '战略合作伙伴') {
							a = obj.num;
						}
						if (i == obj.cusSati && obj.name == '重点开发对象') {
							b = obj.num;
						}
						if (i == obj.cusSati && obj.name == '合作伙伴') {
							c = obj.num;
						}

					})
					var flg = {
						product : i + '星',
						'战略合作伙伴' : a,
						'重点开发对象' : b,
						'合作伙伴' : c
					}

					dataArr.push(flg);
				}

				var myChart = echarts.init(document.getElementById('main4'));
				option = {
					legend : {},
					tooltip : {},
					toolbox : {
						right : '30',
						feature : {
							dataView : {
								show : true,
								readOnly : false
							},
							dataZoom : {
								yAxisIndex : 'none'
							},
							restore : {},
							saveAsImage : {}
						}
					},
					dataset : {
						dimensions : [ 'product', '战略合作伙伴', '重点开发对象', '合作伙伴' ],
						source : dataArr
					},
					xAxis : {
						type : 'category'
					},
					yAxis : {},
					// Declare several bar series, each will be mapped
					// to a column of dataset.source by default.
					series : [ {
						type : 'bar'
					}, {
						type : 'bar'
					}, {
						type : 'bar'
					} ]
				};

				myChart.setOption(option);
			}, "json")

		});
		$("#others")
				.click(
						function() {
							$
									.get(
											"/tab/listrank2",
											function(data) {
												var rankArr = new Array();
												var cusArr = new Array();
												$.each(data.list, function(
														index, obj) {
													var a = {
														value : obj.num,
														name : obj.name,
													}
													rankArr.push(a);
												})
												$.each(data.list2, function(
														index, obj) {
													var a = {
														value : obj.num,
														name : obj.name,
													}
													cusArr.push(a);
												})
												var myChart2 = echarts
														.init(document
																.getElementById('main'));

												option2 = {
													tooltip : {
														trigger : 'item',
														formatter : "{a} <br/>{b}: {c} ({d}%)"
													},
													legend : {
														orient : 'vertical',
														x : 'left',
													//data: ['直达', '营销广告', '搜索引擎', '邮件营销', '联盟广告', '视频广告', '百度', '谷歌', '必应', '其他']
													},
													toolbox : {
														right : '30',
														feature : {
															dataView : {
																show : true,
																readOnly : false
															},
															dataZoom : {
																yAxisIndex : 'none'
															},
															restore : {},
															saveAsImage : {}
														}
													},
													series : [
															{
																name : '星级占比',
																type : 'pie',
																selectedMode : 'single',
																radius : [ 0,
																		'30%' ],

																label : {
																	normal : {
																		position : 'inner'
																	}
																},
																labelLine : {
																	normal : {
																		show : false
																	}
																},

																data : rankArr
															},
															{
																name : '星级占比',
																type : 'pie',
																radius : [
																		'40%',
																		'55%' ],
																label : {
																	normal : {
																		formatter : '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
																		backgroundColor : '#eee',
																		borderColor : '#aaa',
																		borderWidth : 1,
																		borderRadius : 4,
																		// shadowBlur:3,
																		// shadowOffsetX: 2,
																		// shadowOffsetY: 2,
																		// shadowColor: '#999',
																		// padding: [0, 7],
																		rich : {
																			a : {
																				color : '#999',
																				lineHeight : 22,
																				align : 'center'
																			},
																			// abg: {
																			//     backgroundColor: '#333',
																			//     width: '100%',
																			//     align: 'right',
																			//     height: 22,
																			//     borderRadius: [4, 4, 0, 0]
																			// },
																			hr : {
																				borderColor : '#aaa',
																				width : '100%',
																				borderWidth : 0.5,
																				height : 0
																			},
																			b : {
																				fontSize : 16,
																				lineHeight : 33
																			},
																			per : {
																				color : '#eee',
																				backgroundColor : '#334455',
																				padding : [
																						2,
																						4 ],
																				borderRadius : 2
																			}
																		}
																	}
																},
																data : cusArr
															} ]
												};
												myChart2.setOption(option2);
											}, "json")

						});
	})
</script>

</head>
<body>
	<div class="x-nav">
		 <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend class="layui-bg-green" style="font-size: 35px;">客户构成分析</legend>
		</fieldset>

		<!-- <div style="padding: 20px; background-color: #F2F2F2;">
			<div class="layui-row layui-col-space15">
				<div class="layui-col-md6">
					<div class="layui-card">
						<div class="layui-card-header">卡片面板</div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
				</div>
				<div class="layui-col-md6">
					<div class="layui-card">
						<div class="layui-card-header">卡片面板</div>
						<div class="layui-card-body">
							结合 layui 的栅格系统<br> 轻松实现响应式布局
						</div>
					</div>
				</div>
				<div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-header">标题</div>
						<div class="layui-card-body">内容</div>
					</div>
				</div>
			</div>
		</div> -->
		<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
		<!-- <blockquote class="layui-elem-quote"> -->
		<div class="layui-tab layui-tab-card">
			<ul class="layui-tab-title">
				<li class="layui-this" id="rank">等级统计</li>
				<li id="credit">信誉度统计</li>
				<li id="satisfaction">满意度统计</li>
				<li id="others">订单分布统计</li>

			</ul>

			<div class="layui-tab-content" style="min-height: 600px;">
				<div class="layui-tab-item layui-show">
					<div id="main2"
						style="width: 60%; height: 550px; margin: 30px auto;"></div>
				</div>
				<div class="layui-tab-item ">
					<div id="main3"
						style="width: 928px; height: 550px; margin: 30px auto;"></div>
				</div>
				<div class="layui-tab-item">
					<div id="main4"
						style="width: 928px; height: 550px; margin: 30px auto;"></div>
				</div>
				<div class="layui-tab-item">
					<div id="main"
						style="width: 80%; height: 650px; margin: 30px auto;"></div>
				</div>


			</div>
		</div>
		<!-- </blockquote> -->


	</div>
	
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui.use('element', function() {
			var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		});

		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>