<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="../../static/layui/css/layui.css">
<script type="text/javascript" src="../../static/layui/layui.js"></script>
 <script type="text/javascript" src="../../static/js/offer/jquery.js"></script>


<title>报价处理修改</title>
</head>
<body>
<!-- 上标签    	 -->
	<div>
		<div class="layui-card-header">
	报价管理>报价处理>
	</div>
	<!-- 报价信息处理修改提交 -->
	<form class="layui-form" action="">
		 <table class="layui-table" ">
       	 <colgroup>
		  <!--   <col width="15%" >
		    <col width="40%" >
		    <col width="20%" >
		    <col width="25%" > -->
		   	
		 </colgroup>
		 <thead>
		    <tr style="height:40px">
		      <th>客户经理</th>
		      <th>崔展鹏</th>
		      <th>产品名称</th>
		      <th>肥皂</th>
		     
		    </tr> 
		    <tr style="height:40px">
		      <th>订单编号</th>
		      <th>222222222222</th>
		       <th>状态</th>
		      <th>未审核</th>
		    </tr> 
		 </thead>
       </table>

		 <table class="layui-table"">
       	 <colgroup>
		  <!--   <col width="15%" >
		    <col width="40%" >
		    <col width="20%" >
		    <col width="25%" > -->
		   	
		 </colgroup>
		 <thead>
		    <tr style="height:20px">
		      <th>信息</th>
		      <th>金额</th>	      
		    </tr> 
		    </tr> 
		 </thead>
		 <tbody>
			<tr style="height:60px">
					<td style="width: 35%;text-align: center;">产品报价</td>
					<td><input id="num1" type="text" style="width: 50%;height: 60%" value="" />&nbsp;&nbsp;元</td>	      
		  	</tr> 
			<tr style="height:60px">
					<td style="width: 35%;text-align: center;">实施报价</td>
					<td><input id="num2" type="text" style="width: 50%;height: 60%" value=""/>&nbsp;&nbsp;元</td>	      
		  	</tr> 
			<tr style="height:60px">
					<td style="width: 35%;text-align: center;">运维服务报价</td>
					<td><input id="num3" type="text" style="width: 50%;height: 60%" value=""/>&nbsp;&nbsp;元</td>	      
		  	</tr> 
			<tr style="height:60px">
					<td style="width: 35%;text-align: center;">专项服务报价</td>
					<td><input id="num4" type="text" style="width: 50%;height: 60%" value=""/>&nbsp;&nbsp;元</td>	      
		  	</tr> 
			<tr style="height:60px">
					<td style="width: 35%;text-align: center;">项目损益预算</td>
					<td><input id="num5" type="text" style="width: 50%;height: 60%" value=""/>&nbsp;&nbsp;元</td>	      
		  	</tr> 
			
  </tbody>
       </table>
</form>
	<div class="layui-card-header">
		<button class="layui-btn layui-btn-radius"><a><font color='white'>保存</font></a></button>
		<button class="layui-btn layui-btn-radius"><a href="../../views/offer/quotaOffer.jsp"><font color='white'>返回</font></a></button>
	</div>

<script>

//Demo

layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
	</div>
</body>
</html>