<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="utf-8">
      <base href="${pageContext.request.contextPath }/"/>
      <title>table模块快速使用</title>
      <base>
      <link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
    </head>
    <body>
   
    <table id="demo" lay-filter="test"></table>
     
    <script src="../static/layui/layui.js"></script>
    <script>
    layui.use('table', function(){
      var table = layui.table;      
      //第一个实例
      table.render({
        elem: '#demo'
        ,height: 312
        ,url: 'role/user-list' //数据接口
        ,request : {
        		pageName : 'curr' //页码的参数名称，默认：page
        		,
                limitName : 'nums' //每页数据量的参数名，默认：limit
        		,
        	}
       
        ,page: true //开启分页
        ,limits:[5,10,15]
        ,cols: [[ //表头
          {field: 'id', title: 'ID', width:300, sort: true, fixed: 'left'}
          ,{field: 'name', title: '用户名', width:300}
          ,{fixed: 'right',title: '操作', align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
        ]]
      });    
       
    
    //监听行工具事件
    table.on('tool(test)', function(obj){  //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
      var data = obj.data //获得当前行数据
      ,layEvent = obj.event; //获得 lay-event 对应的值
      if(layEvent === 'detail'){
        layer.msg('查看操作');
      } else if(layEvent === 'del'){
        layer.confirm('真的删除行么', function(index){
          obj.del(); //删除对应行（tr）的DOM结构
          layer.close(index);
          //向服务端发送删除指令
        });
      } else if(layEvent === 'edit'){
        layer.msg('编辑操作');
  	    layer.open({
		   type:2,
		   skin:"demo-class",
		   title:"编辑操作",
		   maxmin:true,
		   shadeClose:true,
		   area:[ '100%', '100%' ],
		  /*  btn:['修改'],
		   yes:function(index,layro){
			 
			 
			 layer.close(index);  
		   } */
// 		   content : 'views/role/edit.jsp'
		   content : 'role/getById?id='+data.id
	  })
      }
    });
    });
    </script>
    <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>

   </script>
 
    </body>
    </html>