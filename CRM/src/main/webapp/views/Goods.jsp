<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">

<title>产品列表</title>
<script type="text/javascript" src="../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../static/js/JQuery-3.4.js"></script>
<script type="text/javascript" src="../static/js/Goods.js"></script>
<link rel="stylesheet" type="text/css"
	href="../static/layui/css/layui.css" />

</head>

<body>
	<div class="layui-input-inline">
		<input type="text" name="keyword" id="keyword" placeholder="请输入查询关键字"
			class="layui-input-block">
		<button type="button" class="layui-btn" onclick="find()">查询产品</button>
	</div>
	<div class="layui-input-inline">
		<button type="button" class="layui-btn" onclick="add()">增加产品</button>
	</div>
	<div class="layui-input-inline">
		<button class="layui-btn" id="getCheckData">批量删除</button>
	</div>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
      
    </script>
	<script>
		var keyword = $("#keyword").val();
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#test',
				url : "/Goods/list?&keyword=" + keyword + "",
				toolbar : false,
				title : '用户数据表',
				totalRow : false,
				page : true,
				cols : [ [
				    {
				    type:'checkbox'
				    }
					,{
						field : 'gid',
						title : '产品编号',
						sort : true,
					}
					, {
						field : 'title',
						title : '产品名称'
					}
					, {
						field : 'type',
						title : '产品类型'
					}
					, {
						field : 'level',
						title : '产品等级'
					}
					, {
						field : 'price',
						title : '产品价格'
					}
					, {
						field : 'count',
						title : '产品库存'
					}
					, {
						field : 'content',
						title : '产品备注'
						}
					
					, {
						field : 'storehouse',
						title : '所在仓库'
					}
					, {
						field : 'birthday',
						title : '生产时间'
					}
					
					, {
						fixed : 'right',
						title : '操作',
						toolbar : '#barDemo'
					}
				] ],
	           response : {
					statusCode : 200 //重新规定成功的状态码为 200，table 组件默认为 0
				},
				parseData : function(res) { //将原始数据解析成 table 组件所规定的数据
					return {
						"code" : res.status, //解析接口状态
						"msg" : res.message, //解析提示文本
						"count" : res.total, //解析数据长度
						"data" : res.rows //解析数据列表
					};
				}
			});
	
			table.on('tool(test)', function(obj) {
				if (obj.event == "edit") {
					var data = obj.data; //
					$.ajax({
						type : "get",
						url : "Goods/findGoodsById",
						data : {
							gid : data.gid
						},
						dataType : "json",
						success : function(data) {}
					}) //ajax结束
	
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.open({
							type : 2,
							content : 'views/GoodsCRUD/News_update.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							area : [ '80%', '80%' ],
							offset : 'auto',
							title : '更新信息'
						});
					}); //打开更新界面
				} //if结束
				if(obj.event=="find"){
				 var data = obj.data; //本行数据
				 $.ajax({
						type : "get",
						url : "Goods/findGoodsById",
						data : {
							gid : data.gid
						},
						dataType : "json",
						success : function(data) {}
					}) //ajax结束
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.open({
							type : 2,
							content : 'views/GoodsCRUD/News_detail.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							area : [ '80%', '80%' ],
							offset : 'auto',
							title : '具体产品'
						});
					}); //打开更新界面
				}
				
				
				//删除
				if (obj.event == "del") {
					var data = obj.data; //
					layer.confirm('真的删除产品么', function(index) {
							$.ajax({
								type : "get",
								url : "Goods/deleteGoodsById",
								data : {
									gid : data.gid
								},
								dataType : "json",
								success : function(data) {
									
	
								}
							}) //ajax结束
	                         layer.tips("删除成功");
							window.location.reload();
					})
				} //删除结束
			})//监听结束
			
			$("#getCheckData").click(function(){
				var checkStatus = table.checkStatus('test');
	            var ids=[];
	            for(var x=0;x<checkStatus.data.length;x++){
	              ids.push(checkStatus.data[x].gid);
	            }
				if(checkStatus.data.length==0||checkStatus.data.length==null){
				    layer.msg('您还没有选择数据');
				}else{
				 $.ajax({
					type : "get",
					url : "Goods/deleteGoodsByIds",
					traditional: true,
					data : {
							gids : ids
							},
					dataType : "json",
					success : function(data) {
						
			   			}
			      }) //ajax结束
			      layer.tips("删除成功");
			      window.location.reload();
				}//else结束
				
				
			});
	
		});
	
		//});
	</script>
	<script type="text/javascript">
		layui.use('layer', function() {
			var layer = layui.layer;
		})
	</script>
	
	
<script type="text/javascript">
$(function(){
	$.ajax({
		type:"post",
		url:"/News/listAllNewsType",
		data:{},
		dataType:"json",
		success:function(){
			
		}
	})
})
</script>















</body>
</html>
