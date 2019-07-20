<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../../static/css/font.css">
    <link rel="stylesheet" href="../../static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js" charset="UTF-8"/></script>
    
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="demoTable">
		  搜索名称：
		  <div class="layui-inline">
		    <input class="layui-input" name="typeonename" id="demoReload" autocomplete="off">
		  </div>
		  <button class="layui-btn" data-type="reload">搜索</button>
		  <a class="layui-btn btn-add btn-default" id="btn-add">添加</a>
	   </div> 
       
      <xblock>
        
        
      </xblock>
     <table class="layui-hide" id="test" lay-filter="demo"></table>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
    
    
    
<script>
layui.use('table', function(){
	  var table = layui.table;
	  //将数据加载到表格中
	  table.render({
	    elem: '#test'
	    ,url:'/newsType/list'
	    ,method:"post"
	    ,cols: [[
	      {field:'id',  title: 'ID', sort: true}
	      ,{field:'name',title: '新闻分类名'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	    ,page: true
	  });
	  
	  var $ = layui.$, active = {
			    reload: function(){
			      var demoReload = $('#demoReload');
			      
			      //查询后执行重载
			      table.reload('test', {
			    	url : '/newsType/list',
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	typeonename: demoReload.val()
			        }
			      }, 'data');
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  }); 
			  
			//监听工具条
			  table.on('tool(demo)', function(obj){
			    var data = obj.data,
			    layEvent = obj.event //获得 lay-event 对应的值（编辑、删除、添加）
			    ,editList=[]; //存放获取到的那条json数据中的value值（不放key）
			    $.each(data,function(name,value) {//循环遍历json数据
			        editList.push(value);//将json数据中的value放入数组中（下面的子窗口显示的时候要用到）
			    });
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        $.ajax({
			        	url:"/newsType/del",
			        	type:"post",
			        	dataType:"json",
			        	data:{id:data.id},
			        	success:function(){
			        		layer.alert("删除成功",{icon: 1,time:2000},function () {
		                          layer.close(layer.index); 
									
		                      }); 
			        	}
			        }) 
			        layer.close(index);
			        window.location.reload();
			      });
			    } else if(obj.event === 'edit'){
		            layer.open({
                        //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                        type: 2,
                        title: "修改新闻类型信息",
                        shadeClose: true,
                        shade: 0.8,
                        maxmin: true,
                        area: ['70%', '70%'],
                        content: 'typeone-update.jsp?id='+data.id+'name'+data.name,//表单界面
                        success: function(layero, index){  
                            var body = layer.getChildFrame('body', index);  
                            var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();  
                            var inputList = body.find("input");//获取到子窗口的所有的input标签
                            for (var i = 0; i < inputList.length; i++ ) { 
                               $(inputList[i]).val(editList[i]); //遍历子窗口的input标签，将之前数组中的值一次放入显示
                            }    
                        }   
                    });
                   
			    }
			  });
			  $('#btn-add').on('click', function () {
		            layer.open({
		                type: 2,
		                title: '新闻类别添加',
		                maxmin: true,
		                area: ['420px', '330px'],
		                shadeClose: false, //点击遮罩关闭
		                content: 'typeone-add.jsp',
		            });
		        });
			
	});
</script>

    
</body>
</html>