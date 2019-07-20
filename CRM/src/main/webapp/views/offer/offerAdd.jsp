<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../static/layui/css/layui.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<script src="../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../static/js/offer/xadmin.js"></script>
<script type="text/javascript">
 function myFunction() {
	    alert("提交成功");
	}
</script>
<title>Insert title here</title>
<style type="text/css">
.layui-form-label{
	width:200px;
}
</style>
</head>
<body>
<div class="layui-row layui-col-space10">
  <div class="layui-col-md4">
  </div>
  <div class="layui-col-md4">
  	<!-- 上标题 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>报价创建</legend>
</fieldset>
 <!-- 添加表单 -->

<form id="form" class="layui-form layui-form-pane" action="http://localhost:8080/offer/quotaOfferAdd" method="post" onsubmit="myFunction()">
	<input type="hidden" value="1" name="managerId"/>
  <div class="layui-form-item">
    <label class="layui-form-label">订单编号</label>
    <div class="layui-input-inline">
    	<select name="orderId" id="orderId" lay-verify="required" lay-search >
    			<option value>请选择订单编号</option>
    		<c:forEach items="${offer_orders }" var="order_id">
    			<option value="${order_id }">${order_id }</option>
    		</c:forEach>
    	</select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">商品名称</label>
    <div class="layui-input-inline">
      <input type="text" name="productName" id="productName" lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">产品报价</label>
    <div class="layui-input-inline">
      <input type="text" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" name="quodation" id="quodation" lay-verify="required" placeholder="请输入产品报价" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">实施报价</label>
    <div class="layui-input-inline">
      <input type="text" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" name="implQuodation" id="implQuodation" lay-verify="required" placeholder="请输入实施报价" autocomplete="off" class="layui-input">
    </div>
   
  </div>
  
  <div class="layui-form-item">
   <label class="layui-form-label">运维服务报价</label>
    <div class="layui-input-inline">
      <input type="text" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" name="servQuodation" id="servQuodation" lay-verify="required" placeholder="请输入运维服务报价" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">专项服务报价</label>
    <div class="layui-input-inline">
      <input type="text" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" name="specQuodation" id="specQuodation" lay-verify="required" placeholder="请输入专项服务报价" autocomplete="off" class="layui-input">
    </div>
    
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">项目损益报价</label>
    <div class="layui-input-inline">
      <input type="text" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" name="profitOrLoss" id="profitOrLoss" lay-verify="required" placeholder="请输入项目损益报价" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <input type="submit" class="layui-btn" lay-submit="" lay-filter="demo2" value="提交" style="text-align:center;display:block;margin:0 auto"></input>
  </div>
</form>
          

<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
 
  
  
  
});
</script>
  	
  	
  	
  </div>
  <div class="layui-col-md4">
  </div>
</div>

</body>
</html>