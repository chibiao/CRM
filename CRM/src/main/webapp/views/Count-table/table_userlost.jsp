<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="${pageContext.request.contextPath}"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户流失分析</title>
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<script src="/views/Count-table/js/jquery-3.3.1.js"
	type="text/javascript" charset="utf-8"></script>
<script src="/views/Count-table/js/echarts.min.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="/views/Count-table/css/table_userlost.css">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="../../static/css/font.css">
<!-- <link rel="stylesheet" href="../../static/css/xadmin.css">
 --><script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../static/js/xadmin.js"></script>
<script type="text/javascript" src="../../static/js/cookie.js"></script>
<script type="text/javascript">
	function select() {
		//多条件查询
		var cname = document.getElementById("cname").value;
		var cmname = document.getElementById("cmname").value;
		window.location.href = "/tab/query?cname=" + cname + "&cmname="
				+ cmname;
	}
</script>
</head>

<body>
	
	<div class="x-body">
	
		<div class="layui-row">
		
			<form class="layui-form layui-col-md12  layui-form-pane">
				<div class="layui-form-item" id="x-city">
				<a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend class="layui-bg-green" style="font-size: 35px;">客户流失分析</legend>
					</fieldset>
				</div>
			</form>
		</div>
		
		<!--按钮  -->
		<div class="but_list">
			<button class="layui-btn" onclick="select()">查询</button>
		</div>
		<!--填写栅格  -->
		<div class="container_cus">
			<div class="customer">
				<div class="cus_name div_one">客户名称</div>
				<div class="cus_text">
					<input type="text" name="cname" id="cname" value="${cname}">
				</div>
			</div>
			<div class="cus_manager div_two">
				<div class="cus_name div_one">客户经理</div>
				<div class="cus_text">
					<input type="text" name="cmname" id="cmname" value="${cmname}">
				</div>
			</div>
		</div>
		<!--隐藏的数据查询表格  -->
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>流失时间</th>
					<th>客户名称</th>
					<th>经理</th>
					<th>流失原因</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableList}" var="s">
					<tr>
						<td>${s.lostid}</td>
						<td>${s.lastTime}</td>
						<td>${s.cname}</td>
						<td>${s.cmname}</td>
						<td>${s.lname}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!--形状表  -->
		<div class="tableone_contain">
			<div class="title">各个流失原因饼状图 >>></div>
			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
			<div id="main" class="table_one" style="width: 500px; height: 260px;"></div>
		</div>

		<div class="tabletwo_contain">
			<div class="title">流失原因按年份统计 >>></div>
			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
			<div id="main2" class="table_one"
				style="width: 700px; height: 400px;"></div>
			</pre>

		</div>
		<script type="text/javascript" src="../../static/js/xcity.js"></script>
		<script type="text/javascript">
			$(function() {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/../tab/getTableOne",
							success : function(data) {
								//alert(JSON.stringify(data));
								$
										.each(
												data,
												function(index, obj) {
													// 基于准备好的dom，初始化echarts实例
													var myChart = echarts
															.init(document
																	.getElementById('main'));
													// 指定图表的配置项和数据
													var option = {
														tooltip : {
															trigger : 'item',
															formatter : "{a} <br/>{b}: {c} ({d}%)"
														},
														legend : {
															orient : 'vertical',
															x : 'left',
															data : [ '细节疏忽',
																	'新的诱惑',
																	'缺失诚信',
																	'内部员工' ]
														},
														series : [ {
															name : '各个流失原因饼状图',
															type : 'pie',
															radius : [ '50%',
																	'70%' ],
															avoidLabelOverlap : false,
															label : {
																normal : {
																	show : false,
																	position : 'center'
																},
																emphasis : {
																	show : true,
																	textStyle : {
																		fontSize : '30',
																		fontWeight : 'bold'
																	}
																}
															},
															labelLine : {
																normal : {
																	show : false
																}
															},
															data : [
																	{
																		value : data[0],
																		name : '细节疏忽'
																	},
																	{
																		value : data[1],
																		name : '新的诱惑'
																	},
																	{
																		value : data[2],
																		name : '缺失诚信'
																	},
																	{
																		value : data[3],
																		name : '内部员工'
																	} ]
														} ]
													};

													// 使用刚指定的配置项和数据显示图表。
													myChart.setOption(option);
												});
							}
						});
			});
		</script>
	</div>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/../tab/getTabletwo",
				success : function(data) {
					//alert(JSON.stringify(data));
					$.each(data, function(index, obj) {
						// 基于准备好的dom，初始化echarts实例
						var myChart = echarts.init(document
								.getElementById('main2'));
						// 指定图表的配置项和数据
						var option = {
							title : {
								text : '流失原因按年份统计'
							},
							tooltip : {
								trigger : 'axis'
							},
							legend : {
								data : [ '细节疏忽', '新的诱惑', '缺失诚信', '企业员工' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							toolbox : {
								feature : {
									saveAsImage : {}
								}
							},
							xAxis : {
								type : 'category',
								boundaryGap : false,
								data : [ '2017', '2018', '2019' ]
							},
							yAxis : {
								type : 'value'
							},
							series : [ {
								name : '细节疏忽',
								type : 'line',
								stack : '总量',
								data : data[0]
							}, {
								name : '新的诱惑',
								type : 'line',
								stack : '总量',
								data : data[1]
							}, {
								name : '缺失诚信',
								type : 'line',
								stack : '总量',
								data : data[2]
							}, {
								name : '企业员工',
								type : 'line',
								stack : '总量',
								data : data[3]
							} ]
						};

						// 使用刚指定的配置项和数据显示图表。
						myChart.setOption(option);
					});
				}
			});
		});
	</script>
	<script>
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