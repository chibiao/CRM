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

<title>产品增加</title>
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
<form class="layui-form" action="Goods/addGoods" method="post"  >
	<div class="layui-form-item">
	
		<label class="layui-form-label">产品名称*</label>
		<div class="layui-input-block">
			<input type="text" name="title" lay-verify="title" autocomplete="off"
				placeholder="请输入名称" class="layui-input" required>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">产品型号*</label>
		<div class="layui-input-block">
			<input type="text" name="type" lay-verify="title"
				autocomplete="off" placeholder="请输入型号" class="layui-input" required>
		</div>
	</div>
	<div class="layui-form-item">
    <label class="layui-form-label">产品等级*</label>
    <div class="layui-input-block">
      <select name="level" lay-filter="aihao">
        <option value=""></option>
        <option value="甲级" selected="">甲级</option>
        <option value="乙级" >乙级</option>
        <option value="丙级">丙级</option>
       </select>
    </div>
  </div>
	<div class="layui-form-item">
		<label class="layui-form-label">产品单位*</label>
		<div class="layui-input-block">
			<input type="text" name="unit" lay-verify="title"
				autocomplete="off" placeholder="请输入单位" class="layui-input" required>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">产品价格*</label>
		<div class="layui-input-block">
			<input type="text" name="price" 
				autocomplete="off" placeholder="请输入价格" class="layui-input" lay-verify="number">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">产品库存*</label>
		<div class="layui-input-block">
			<input type="text" name="count" 
				autocomplete="off" placeholder="请输入库存" class="layui-input" lay-verify="number">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">产品备注</label>
		<div class="layui-input-block">
			<input type="text" name="content" lay-verify="title"
				autocomplete="off" placeholder="请输入备注" class="layui-input" >
		</div>
	</div>
	<div class="layui-form-item">
    <label class="layui-form-label">所在仓库*</label>
    <div class="layui-input-block">
      <select name="storehouse" lay-filter="aihao">
        <option value=""></option>
        <option value="滨海仓库" selected="">滨海仓库</option>
        <option value="北京仓库" >北京仓库</option>
        <option value="上海仓库">上海仓库</option>
       </select>
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
