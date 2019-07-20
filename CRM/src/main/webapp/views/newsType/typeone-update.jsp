<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>新闻分类添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
     <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../../static/css/font.css">
    <link rel="stylesheet" href="../../static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js" charset="UTF-8"/></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form">
        <input type="hidden" name="id">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>分类名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
         <div class="layui-inline">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="" lay-filter="editNewsType">立即提交</button>
		    </div>
		  </div>
      </form>
    </div>
  </body>
<script>
layui.use(['form', 'layedit'] ,function(){
  var $ = layui.jquery
  ,form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit; 
  var index = parent.layer.getFrameIndex(window.name); //修改成功的时候点击 确定 会关闭子窗口，这里获取一下子窗口
  form.render();
  //监听提交
  form.on('submit(editNewsType)', function(data){ //这块要跟表单中的lay-filter="editNewsType"对应
    $.ajax({          
              url: "../../newsType/update",       
              type: "post",                
              async: false,   //不要让它异步提交
              data: data.field,                  
              dataType: "json",       
              success: function (data) { 
            	  alert(data);
            	  if(data==1){
            		  layer.alert("修改成功",{icon: 1,time:2000},function () {
                          layer.close(layer.index); 
                          window.parent.location.reload();    //重新加载父页面，进行数据刷新
                    });  
            	  }else{
            		  layer.alert("修改失败，类型名已经存在",{icon: 1,time:2000},function () {
                          layer.close(layer.index); 
            		  });
            	  }    
            }
    });
	    return false;
	 
  });
   
});
</script>

</html>