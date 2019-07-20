//此方法是实现增加学生的操作，界面会弹框
function add(){
	layui.use('layer', function(){
		var layer = layui.layer;
		layer.open({
			type: 2, 
			content: 'views/GoodsCRUD/News_add.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			area:['80%','80%'],
			offset: 'auto',
			title:'录入信息'
		});
	});  
}

//实现模糊查询
function find(){
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
		}) 
	});
}





