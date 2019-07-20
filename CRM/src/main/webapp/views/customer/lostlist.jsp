<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="utf-8">
      <base href="${pageContext.request.contextPath }/"/>
      <title>table模块快速使用</title>
     <meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="../../static/css/font.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../static/js/xadmin.js"></script>
<script type="text/javascript" src="../../static/js/cookie.js"></script>
    </head>
    <body>
    <table id="lost" lay-filter="test"></table>
     </body>
    <script src="./static/layui/layui.js"></script>
    <script>
    layui.use('table', function(){
      var table = layui.table;
      
      //第一个实例
      table.render({
        elem: '#lost'
        ,height: 600
        ,url: '${pageContext.request.contextPath}/lost/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
          {field: 'lostid', title: 'ID', width:100, sort: true, fixed: 'left'}
          ,{field: 'cusname', title: '客户名', width:250,templet:"<div>{{d.customer.cusname}}</div>"
}
          ,{field: 'cmid', title: '经理名', width:100}
          ,{field: 'lastordertime', title: '上次下单时间', width:300}
          ,{field: 'lasttime', title: '流失时间', width:250}
          ,{field: 'laststatus', title: '状态', width:100,
        	templet:function(res){
        		if(res.laststatus=="0"){
        			return "未流失";
        		}else if(res.laststatus=="1"){
        			return "已流失";
        		}
        	}  
          }
          ,{fixed: 'right', width:200,title: '操作', align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
//           <button type="button" class="layui-btn">操作</button>
//           ,{field: 'city', title: '城市', width:80} 
//           ,{field: 'sign', title: '签名', width: 177}
//           ,{field: 'experience', title: '积分', width: 80, sort: true}
//           ,{field: 'score', title: '评分', width: 80, sort: true}
//           ,{field: 'classify', title: '职业', width: 80}
//           ,{field: 'wealth', title: '财富', width: 135, sort: true}
        ]]
      });    
      
    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
      var data = obj.data //获得当前行数据
      ,layEvent = obj.event; //获得 lay-event 对应的值
      if(layEvent === 'detail'){
      } else if(layEvent === 'del'){
        layer.confirm('真的删除行么', function(index){
        	$.post(
                	"${pageContext.request.contextPath}/lost/del",
                	{
                		lostid:data.lostid
                	},
                	function(date){
                		if(date){
                			 layer.msg('已刪除');
                		}
                	},
                	"json"
                			
                );
          obj.del(); //删除对应行（tr）的DOM结构
          layer.close(index);
          
        });
      } else if(layEvent === 'edit'){
    	  if(data.laststatus!=1){
    		  $.post(
    		        	"${pageContext.request.contextPath}/lost/update",
    		        	{
    		        		laststatus:1,
    		        		lostid:data.lostid
    		        	},
    		        	function(date){
    		        		if(date){
    		        			 layer.msg('修改成功');
    		        			 table.reload('lost');
    		        		}
    		        	},
    		        	"json"
    		        			
    		        );
    	  }else{
    		  layer.msg("该用户已流失不可更改状态!");
       
      }
      }
    });
    });
    </script>
    <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改流失状态</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
   </script>
    </html>
