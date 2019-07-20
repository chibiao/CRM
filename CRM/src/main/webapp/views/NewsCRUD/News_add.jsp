<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户增加</title>
<script type="text/javascript" src="../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../static/js/JQuery-3.4.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css"
	href="../../static/layui/css/layui.modbile.css" />


</head>

<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});
</script>
<form class="layui-form" action="News/addNews" method="post"  enctype="multipart/form-data">
	<div class="layui-form-item">
	
		<label class="layui-form-label">新闻标题*</label>
		<div class="layui-input-block">
			<input type="text" name="title" lay-verify="title" autocomplete="off"
				placeholder="请输入标题" class="layui-input" required>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻作者*</label>
		<div class="layui-input-block">
			<input type="text" name="writer" lay-verify="title"
				autocomplete="off" placeholder="请输入作者" class="layui-input" required>
		</div>
	</div>


	<div class="layui-form-item">
		<label class="layui-form-label">新闻分类*</label>
		<div class="layui-input-block">
			<select name="classify" lay-filter="aihao" required>
			<c:forEach items="${AllNewsType}" var="newstype">
			  <option value="${newstype.name }">${newstype.name }</option>
			</c:forEach>
			</select>
		</div>
	</div>
    



	<div class="layui-form-item">
		<label class="layui-form-label">新闻内容*</label>
		<textarea id="demo" name="content" style="display: none;" height="150px" width="800px" "></textarea>
    </div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻备注</label>
		<div class="layui-input-block">
			<input type="text" name="remarks" lay-verify="title"
				autocomplete="off" placeholder="请输入备注" class="layui-input" >
		</div>
	</div>	
		

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button class="layui-btn layui-btn-warm" lay-reset=""
					lay-filter="demo1">重置</button>
			</div>
		</div>
</form>

<!-- 富文本编辑器 -->
<script>
layui.use('layedit', function(){




  var layedit = layui.layedit;
   layedit.set({
        uploadImage: {
        url: '/News/uploadFile' //接口url
        ,type: 'post' //默认post
          }
    });
  layedit.build('demo'); //建立编辑器
});
/* layedit.build('demo', {
  height: 180 //设置编辑器高度
}); */      
</script>
<!-- 表单 -->
<script type="text/javascript">
layui.use('form', function(){
  var form = layui.form; 
  form.render();
});
</script>

<!-- 提交后关闭当前页面 -->
<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name);
	
	//获取iframe父页面索引
    $('form').submit(function() {
    	$.ajax({
            type:"post",
            data:$(this).serialize(),
            success:function(data){
                parent.location.reload(); //刷新父页面
		        parent.layer.close(index);  //关闭当前页面，写在最后面
            },
            error:function(data){
                parent.location.reload();
		        parent.layer.close(index);
            }
       });   
	});
</script>
</body>
</html>
