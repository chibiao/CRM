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
<style>
	.layui-carousel img{
		width: 100%;
		height: 100%;
	}
</style>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>轮播</legend>
</fieldset>  
<div class="layui-carousel" id="test1" lay-filter="carofilter" style="font-size:larger">
  <div carousel-item id="Lbimg">
      
  </div>

</div> 

    <script>
       

    </script>
    <script type="text/javascript">

	$(function(){
		$.ajax({
        	url:"/Img/list",
        	type:"post",
        	dataType:"json",
        	data:{},
        	success:function(result){
        	    for (var i = 0; i < result.data.length; i++) {
					$("#Lbimg").append("<div><img src='"+result.data[i].photo+"'></div>");
				}
        	    layui.use('carousel', function () {
                    var carousel = layui.carousel;
                    //***************************建造实例
                    var ins=carousel.render({
                        elem: '#test1'
                        , width: '100%'     //设置容器宽度
                        , arrow: 'hover'    //始终显示箭头，可选hover,none
                        //,anim: 'updown'    //切换动画方式，可选fade,default
                        , full: false        //全屏
                        , autoplay: true     //自动切换
                        , interval: 1000     //自动切换的时间间隔
                        , index: 0           //初始化时item索引,默认时0
                        , indicator:'inside' //指示器位置，可选outside,none
                    });
                    ///================
                    	

                    //**************************监听轮播切换事件
                     carousel.on('change(carofilter)', function (obj) { //test1来源于对应HTML容器的 lay-filter="test1" 属性值
                         console.log(obj.index);     //当前条目的索引
                        console.log(obj.prevIndex); //上一个条目的索引
                        console.log(obj.item);      //当前条目的元素对象 
                    }); 
                     
                		
                    
                    //****************************重置轮播
                    //var ins = carousel.render(options);
                     ins.reload({arrow:'hover'});//将arror从alway变成hover 
                  
                });
        	}
        })
	}) 


</script> 
<!-- 轮播列表 -->
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    </div>
    <div class="x-body">
      <div class="demoTable">
		  搜索上传人姓名：
		  <div class="layui-inline">
		    <input class="layui-input" name="imgName" id="demoReload" autocomplete="off">
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
	    ,url:'/Img/list'
	    ,method:"post"
	    ,cols: [[
	      {field:'id',  title: 'ID', sort: true}
	      ,{field:'name',title: '上传人姓名'}
	      ,{field: 'ptoto', title: '图片', width: 150,style:'height:100%;max-width:100%;',templet:'<div><img src="{{ d.photo}}"></div>'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	    ,page: true
	  });
	  
	  var $ = layui.$, active = {
			    reload: function(){
			      var demoReload = $('#demoReload');
			      
			      //查询后执行重载
			      table.reload('test', {
			    	url : '/Img/list',
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	imgName: demoReload.val()
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
			       alert(11);
			        $.ajax({
			        	url:"/Img/del",
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
                        title: "修改轮播图信息",
                        shadeClose: true,
                        shade: 0.8,
                        maxmin: true,
                        area: ['70%', '70%'],
                        content: 'img-update.jsp?id='+data.id+'&name='+data.name+'&photo='+data.photo,//表单界面
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
		                title: '轮播图添加',
		                maxmin: true,
		                area: ['420px', '330px'],
		                shadeClose: false, //点击遮罩关闭
		                content: 'img-add.jsp',
		            });
		        });
			
	});
</script>





    
</body>
</html>