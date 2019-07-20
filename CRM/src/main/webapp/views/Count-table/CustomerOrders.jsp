<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户贡献分析图</title>
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="../../static/js/echarts.min.js"></script>
<script type="text/javascript">
$(function(){
	 $.get(
		'/getlist',
		{},
		function(data){
			var da=data.list1;
			var va=data.list2;
			var ca=data.list3;
			//柱状图
			var myChart = echarts.init(document.getElementById('main2'));
			var option={
				title : {
					text: '客户总贡献度',
					
				},
				tooltip : {
					trigger: 'axis'
				},
				toolbox:{
					feature:{
						saveAsImage:{},
					}
				},
				legend: {
					data:['贡献度']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis : [
					{
						type : 'category',
						data :da,
						splitLine:{
							show:false
						},
						axisTick: {
							alignWithLabel: true
						}
					}
				],
				yAxis : [
					{
						type : 'value',
						splitLine:{
							show:false
						},
						splitArea:{
							show:true,
						},
					}
				],
				series : [
					{
						name: '贡献度',
						type:'bar',
						label:{
						    normal:{
						        show:true,
						        position:'top'
						    }
						},
						itemStyle:{
							normal:{
								color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
							}
						},
						barWidth:50,
						data:va
					}
				]
	        };
			myChart.setOption(option);
			myChart.on('click', function (params) {
				$.get('/get?m=' + params.name, function (detail) {
			        myChart.setOption({
			        	title : {
							text: '客户贡献详情',
							
						},
						tooltip : {
							trigger: 'axis'
						},
						toolbox:{
							feature:{
								saveAsImage:{},
								myTool2: {  
					                show: true,  
					                title: '返回',
					                icon: 'image://http://echarts.baidu.com/images/favicon.png',
					                onclick: function (){  
					                    myChart.setOption(option);
					                }  
					            }, 
							}
						},
						legend: {
							data:['贡献度']
						},
						grid: {
							left: '3%',
							right: '4%',
							bottom: '3%',
							containLabel: true
						},
						xAxis : [
							{
								type : 'category',
								data :detail.list4,
								splitLine:{
									show:false
								},
								axisTick: {
									alignWithLabel: true
								}
							}
						],
						yAxis : [
							{
								type : 'value',
								splitLine:{
									show:false
								},
								splitArea:{
									show:true,
								},
							}
						],
						series : [
							{
								name: '贡献度',
								type:'bar',
								label:{
								    normal:{
								        show:true,
								        position:'top'
								    }
								},
								itemStyle:{
									normal:{
										color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
									}
								},
								barWidth:50,
								data:detail.list5
							}
						]
			        });
			    });
			});
 			//low B格式断开环形图
			echarts.init(document.getElementById('main1')).setOption({
				toolbox:{
					feature:{
						saveAsImage:{},
					}
				},
				title:{
					text:'客户贡献分布图',
					subtext:'模拟数据',
					itemGap:30,
					 textStyle: {
			              fontSize: 20,
			              fontWeight: 'bolder',
			              color: '#000080'
			            },
				},
				legend: {
		            // orient 设置布局方式，默认水平布局，可选值：'horizontal'（水平） ¦ 'vertical'（垂直）
		            orient: 'vertical',
		            // x 设置水平安放位置，默认全图居中，可选值：'center' ¦ 'left' ¦ 'right' ¦ {number}（x坐标，单位px）
		            x: 'left',
		            // y 设置垂直安放位置，默认全图顶端，可选值：'top' ¦ 'bottom' ¦ 'center' ¦ {number}（y坐标，单位px）
		            y: 'center',
		            itemWidth: 24,   // 设置图例图形的宽
		            itemHeight: 18,  // 设置图例图形的高
		            textStyle: {
		              color: '#666'  // 图例文字颜色
		            },
		            // itemGap设置各个item之间的间隔，单位px，默认为10，横向布局时为水平间隔，纵向布局时为纵向间隔
		            itemGap: 30,
		            backgroundColor: '#eee',  // 设置整个图例区域背景颜色
		            data: da
		          },
				series: {
					type: 'pie',
					radius:[170,200],
					itemStyle: {
		                emphasis: {
		                  shadowBlur: 10,
		                  shadowOffsetX: 0,
		                  shadowColor: 'rgba(30, 144, 255，0.5)'
		              },
		              normal:{
                          color:function(params) {
                          //自定义颜色
                          var colorList = [          
                                  'rgb(254, 67, 101)', 'rgb(252, 157, 154)', 'rgb(249, 205, 173)', 
                                  'rgb(200, 200, 169)', 'rgb(131, 175, 155)', 'rgb(249, 205, 173)',
                                  'rgb(200, 200, 169)', 'rgb(131, 175, 155)','rgb(254, 67, 101)', 
                                  'rgb(252, 157, 154)', 'rgb(249, 205, 173)', 'rgb(200, 200, 169)', 
                              ];
                              return colorList[params.dataIndex]
                           }
                      }
					},
					data:ca
				}
		    })
		    //好看的模式 不想给你看
		    /* var scaleData = data.list3;
				var rich = {
				    white: {
				        color: '#ddd',
				        align: 'center',
				        padding: [5, 0]
				    }
				};
				var placeHolderStyle = {
				    normal: {
				        label: {
				            show: false
				        },
				        labelLine: {
				            show: false
				        },
				        color: 'rgba(0, 0, 0, 0)',
				        borderColor: 'rgba(0, 0, 0, 0)',
				        borderWidth: 0
				    }
				};
				var data = [];
				for (var i = 0; i < scaleData.length; i++) {
				    data.push({
				        value: scaleData[i].value,
				        name: scaleData[i].name,
				        itemStyle: {
				            normal: {
				                borderWidth: 5,
				                shadowBlur: 30,
				                borderColor: new echarts.graphic.LinearGradient(0, 0, 1, 1, [{
				                    offset: 0,
				                    color: '#7777eb'
				                }, {
				                    offset: 1,
				                    color: '#70ffac'
				                }]),
				                shadowColor: 'rgba(142, 152, 241, 0.6)'
				            }
				        }
				    }, {
				        value: 4,
				        name: '',
				        itemStyle: placeHolderStyle
				    });
				}
				var seriesObj = [{
				    name: '',
				    type: 'pie',
				    clockWise: false,
				    radius: [195, 200],
				    hoverAnimation: false,
				    itemStyle: {
				        normal: {
				            label: {
				                show: true,
				                position: 'outside',
				                color: '#ddd',
				                formatter: function(params) {
				                    var percent = 0;
				                    var total = 0;
				                    for (var i = 0; i < scaleData.length; i++) {
				                        total += scaleData[i].value;
				                    }
				                    percent = ((params.value / total) * 100).toFixed(0);
				                    if (params.name !== '') {
				                        return params.name + '\n{white|' + '占比' + percent + '%}';
				                    } else {
				                        return '';
				                    }
				                },
				                rich: rich
				            },
				            labelLine: {
				                show: false
				            }
				        }
				    },
				    data: data
				}];
				echarts.init(document.getElementById('main1')).setOption({
					backgroundColor: '#666', 
				    tooltip: {
				        show: false
				    },
				    legend: {
				        show: false
				    },
				    toolbox: {
				        show: false
				    },
				    series: seriesObj
				}) */
		},
		"json"
	) 
});
</script>
</head>
<body  style="background-color: #F0F0F0;">
<div class="x-nav">
		 <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend class="layui-bg-green" style="font-size:35px;">客户贡献分析</legend>
		</fieldset>
<div id="body"  style="width: 1000px;height:800px;margin: auto;">

<div id="main1" style="width: 1000px;height:800px;"></div>
<div id="main2" style="width: 1000px;height:400px;"></div>
</div>
</body>
</html>