//此方法是实现增加学生的操作，界面会弹框
function add(){
	layui.use('layer', function(){
		var layer = layui.layer;
		layer.open({
			type: 2, 
			content: 'views/NewsCRUD/News_add.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
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
			url : "/News/list?&keyword=" + keyword + "",
			toolbar : false,
			title : '用户数据表',
			totalRow : false,
			page : true,
			cols : [ [
				{
					field : 'nid',
					title : 'ID',
					sort : true,
				}
				, {
					field : 'title',
					title : '新闻标题'
				}
				, {
					field : 'writer',
					title : '新闻作者'
				}
				, {
					field : 'birthday',
					title : '发布时间'
				}
				, {
					field : 'classify',
					title : '新闻分类'
				}
				
				
				, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo'
				}
			] ],
            /* done:function(){
              $("[data-field='nid']").css(name="display",value="none");
            }
			, */response : {
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





