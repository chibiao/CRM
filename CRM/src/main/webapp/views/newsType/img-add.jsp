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
        <form class="layui-form" enctype="text/plain">
          
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>上传人
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>

           <div class="layui-form-item">
        <label class="layui-form-label">轮播图</label>
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="upload1">上传图片</button>
            <input type="hidden" id="img_url" name="img" value=""/>
            <div class="layui-upload-list">
                <img class="layui-upload-img" width="100px" height="80px" id="demo1"/>
                <p id="demoText"></p>
            </div>
        </div>
    </div>

          
         <div class="layui-inline">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="" lay-filter="Img">立即提交</button>
		    </div>
		  </div>
      </form>
    </div>
  </body>
  <script type="text/javascript">
  layui.use('upload', function(){
      var upload = layui.upload
          , $ = layui.jquery;
      var uploadInst = upload.render({
          elem: '#upload1' //绑定元素
          ,url:'../../Img/upload' //上传接口
          ,before: function(obj){
              //预读本地文件示例，不支持ie8
              obj.preview(function(index, file, result){
            	  alert(file);
                  $('#demo1').attr('src', result); //图片链接（base64）
              });
          }
          ,done: function(res){
              //如果上传失败
              if(res.code > 0){
                  return layer.msg('上传失败');
              }
              //上传成功
              alert("上传成功");
              document.getElementById("img_url").value = res.url;

          }
          ,error: function(){
              //演示失败状态，并实现重传
              var demoText = $('#demoText');
              demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
              demoText.find('.demo-reload').on('click', function(){
                  uploadInst.upload();
              });
          }
      });
  });

  
  
  </script>
<script>
layui.use(['form', 'layedit'] ,function(){
	
  var $ = layui.jquery
  ,form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit; 
  var index = parent.layer.getFrameIndex(window.name); //修改成功的时候点击 确定 会关闭子窗口，这里获取一下子窗口
  form.render();
  //监听提交
  form.on('submit(Img)', function(data){ //这块要跟表单中的lay-filter="editNewsType"对应
	
    $.ajax({          
              url: "../../Img/add",       
              type: "post",                
              async: false,   //不要让它异步提交
              data: data.field,                  
              dataType: "json",       
              success: function (data) {
            	  if(data==1){
            		  layer.alert("添加成功",{icon: 1,time:2000},function () {
                          layer.close(layer.index); 
                          window.parent.location.reload();    //重新加载父页面，进行数据刷新
                    });  
            	  }else{
            		  layer.alert("添加失败，图片为空",{icon: 1,time:2000},function () {
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