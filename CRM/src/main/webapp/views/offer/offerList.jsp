<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../static/layui/css/layui.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<script src="../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../static/js/offer/xadmin.js"></script>
<title>报价查询</title>
</head>
<body>

<div class="layui-card">
	<div class="layui-card-body">
		<!-- 表格主体 -->
		<table id="offerList" lay-filter="offerList"></table>
	</div>
</div>
	<div class="layui-card-body" id="fuzzyOffer" hidden>
	    <form class="layui-form layui-col-space5" id="fuzzy_offer">
	    	<!-- //报价状态 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<select name="offerState" id="offerState">
	                <option value="99">全部报价单</option>
	                <option value="5" ${fuzzyOffer.offerState==null?'selected':'' }>未审核</option>
	                <option value="0" ${fuzzyOffer.offerState==0?'selected':'' }>未通过</option>
	                <option value="1" ${fuzzyOffer.offerState==1?'selected':'' }>已通过</option>
	            </select>
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <!-- //产品名称 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="产品名称" name="productName" id="productName" value="${fuzzyOffer.productName }">
	        </div>
	        <!-- //报价单编号 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="报价单编号" name="offerId" id="offerId" value="${fuzzyOffer.offerId }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <!-- //订单编号 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="订单编号" name="orderId" id="orderId" value="${fuzzyOffer.orderId }">
	        </div>
	        <!-- //产品报价范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="产品报价" name="quodationMin" id="quodationMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.quodationMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="产品报价" name="quodationMax" id="quodationMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.quodationMax }">
	        </div>
	        <!-- //实施报价范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="实施报价" name="implQuodationMin" id="implQuodationMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.implQuodationMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="实施报价" name="implQuodationMax" id="implQuodationMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.implQuodationMax }">
	        </div>
	        <!-- //服务报价范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="服务报价" name="servQuodationMin" id="servQuodationMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.servQuodationMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="服务报价" name="servQuodationMax" id="servQuodationMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.servQuodationMax }">
	        </div>
	        <!-- //专项服务报价范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="专项服务报价" name="specQuodationMin" id="specQuodationMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.specQuodationMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="专项服务报价" name="specQuodationMax" id="specQuodationMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.specQuodationMax }">
	        </div>
	        <!-- //项目损益运算范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="项目损益" name="profitOrLossMin" id="profitOrLossMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.profitOrLossMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="项目损益" name="profitOrLossMax" id="profitOrLossMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.profitOrLossMax }">
	        </div>
	        <!-- //总价范围 -->
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="报价总计" name="totalMin" id="totalMin" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.totalMin }">
	        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <div class="layui-input-inline layui-show-xs-block">
	        	<input class="layui-input" placeholder="报价总计" name="totalMax" id="totalMax" onkeyup="this.value=this.value.replace(/[^0-9-.]+/,'');" value="${fuzzyOffer.totalMax }">
	        </div>
	        <!-- //报价创建人 -->
	        <div class="layui-input-inline layui-show-xs-block" style="${userRole.equals('manager')?'display:none':''}">
	        	<select name="managerId" id="managerId">
	                <option value="0">全部创建人</option>
	                <c:forEach items="${managers }" var="manager">
	                	<option value="${manager.id }" ${fuzzyOffer.managerId==manager.id?'selected':'' }>${manager.name }</option>
	                </c:forEach>
	            </select>
	        </div>&nbsp;
	        
	    </form>
	</div>
<!-- 行内工具栏  每行最后一列按钮 -->
<script type="text/html" id="toolbar-line">
  <a class="layui-btn layui-btn-xs" lay-event="examine" id="yes" style="${userRole.equals('manager')?'display:none':''}" >通过</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="examineNo" id="no" style="${userRole.equals('manager')?'display:none':''}">拒绝</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="edit" style="${userRole.equals('director')?'display:none':''}">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" id="del" style="${userRole.equals('director')?'display:none':''}">删除</a>
</script>
<!-- 表头工具栏   -->
<script type="text/html" id="toolbar-fuzzy">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="fuzzy">按条件筛选</button>
  </div>
</script>
	<div id="udpateOffer" hidden>
		<form class="layui-form" action="">
			<table class="layui-table"">
				<colgroup>
					<!--   <col width="15%" >
		    <col width="40%" >
		    <col width="20%" >
		    <col width="25%" > -->
				</colgroup>
				<thead>
					<tr style="height: 40px">
						<th>客户经理</th>
						<th id="manager_name"></th>
						<th>产品名称</th>
						<th id="product_name"></th>

					</tr>
					<tr style="height: 40px">
						<th>订单编号</th>
						<th id="order_id"></th>
						<th>状态</th>
						<th id="offer_state"></th>
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
					<tr style="height: 20px">
						<th>信息</th>
						<th>金额</th>
					</tr>
					</tr>
				</thead>
				<tbody>
					<tr style="height: 60px">
						<td style="width: 35%; text-align: center;">产品报价</td>
						<td><input id="quodation" type="text" name="quodation"
							style="width: 50%; height: 60%" value=""/>&nbsp;&nbsp;元</td>
					</tr>
					<tr style="height: 60px">
						<td style="width: 35%; text-align: center;">实施报价</td>
						<td><input id="implQuodation" type="text" name="implQuodation"
							style="width: 50%; height: 60%" value="" />&nbsp;&nbsp;元</td>
					</tr>
					<tr style="height: 60px">
						<td style="width: 35%; text-align: center;">运维服务报价</td>
						<td><input id="servQuodation" type="text" name="servQuodation"
							style="width: 50%; height: 60%" value="" />&nbsp;&nbsp;元</td>
					</tr>
					<tr style="height: 60px">
						<td style="width: 35%; text-align: center;">专项服务报价</td>
						<td><input id="specQuodation" type="text" name="specQuodation"
							style="width: 50%; height: 60%" value="" />&nbsp;&nbsp;元</td>
					</tr>
					<tr style="height: 60px">
						<td style="width: 35%; text-align: center;">项目损益预算</td>
						<td><input id="profitOrLoss" type="text" name="profitOrLoss"
							style="width: 50%; height: 60%" value="" />&nbsp;&nbsp;元</td>
					</tr>

				</tbody>
			</table>
		</form>

		<script>
			layui.use('form', function() {
				var form = layui.form;
			});
		</script>
	</div>
	<script>
var layer = layui.layer;
layui.use('table', function(){
  var table = layui.table;
  //监听
  table.on('toolbar(offerList)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id);
	  switch(obj.event){
	  case 'fuzzy':
	    	layer.open({
				type:1,
				title:'筛选报价单',
				content:$("#fuzzyOffer"),
				area: ['520px', '500px'],
				btn: ['查询'],
				yes: function(index, layero){
				    tabledata();
				    layer.close(index);
				}
			});
	    break;
	  };
	});
  
  //监听行内工具条
  table.on('tool(offerList)', function(obj){ //注：tool是工具条事件名，offerList是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    var tr = obj.tr; //获得当前行 tr 的DOM对象
    if(layEvent === 'examine'){
    	if(data.offerState==1 || data.offerState==0){
			layer.msg("只能操作未审核的报价单");
		}else{
	    	layer.confirm('确认审核通过吗', function(index){
	            layer.close(index);
	            $.post("http://localhost:8080/offer/examine",
	      			  {
	      			    offerId:data.offerId,
	      			    state:1
	      			  },
	      			  function(data,status){
	      			      console.log("Data: " + data + "\nStatus: " + status);
	      				  tabledata();
	      			  });
	          });
		}
    }else if(layEvent === 'examineNo'){
    	if(data.offerState==1 || data.offerState==0){
			layer.msg("只能操作未审核的报价单");
		}else{
	    	layer.confirm('确认审核不通过吗', function(index){
	            layer.close(index);
	            $.post("http://localhost:8080/offer/examine",
	      			  {
	      			    offerId:data.offerId,
	      			    state:0
	      			  },
	      			  function(data,status){
	      			      console.log("Data: " + data + "\nStatus: " + status);
	      				  tabledata();
	      			  });
	          });
		}
    }else if(layEvent === 'del'){
		if(data.offerState==1){
			layer.msg("报价单已通过审核，不可删除");
		}else{
	    	layer.confirm('真的删除这行么', function(index){
	    						obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
								layer.close(index);
						        //向服务端发送删除指令
						        $.post("http://localhost:8080/offer/delete",
						    			  {
						    			    offerId:data.offerId
						    			  },
						    			  function(data,status){
						    			      console.log("Data: " + data + "\nStatus: " + status);
						    			      tabledata();
						    			  });
						      	});
		}
    } else if(layEvent === 'edit'){
    	if(data.offerState==1){
			layer.msg("报价单已通过审核，不可修改");
		}else{
			//给udpateOffer div 赋值
			var offer_state = data.offerState==null?'未审核':'未通过';
			$('#manager_name').html(data.manager.name);
			$('#product_name').html(data.productName);
			$('#offer_state').html(offer_state);
			$('#order_id').html(data.orderId);
			$('#quodation').val(data.quodation);
			$('#implQuodation').val(data.implQuodation);
			$('#servQuodation').val(data.servQuodation);
			$('#specQuodation').val(data.specQuodation);
			$('#profitOrLoss').val(data.profitOrLoss);
			//弹框
			layer.open({
				type:1,
				title:'修改报价单',
				anim: 5,
				content:$("#udpateOffer"),
				btn: ['保存', '取消'],
				btnAlign: 'c',
				yes: function(index, layero){
				    //修改数据库
				    $.post("http://localhost:8080/offer/update",
			      			  {
				    			offerId:data.offerId,
				    			quodation:$('#quodation').val(),
				    			implQuodation:$('#implQuodation').val(),
				    			servQuodation:$('#servQuodation').val(),
				    			specQuodation:$('#specQuodation').val(),
				    			profitOrLoss:$('#profitOrLoss').val()
			      			  },
			      			  function(data,status){
			      				  layer.msg(data);
			      			  });
				    layer.close(index);
				    //重新读取表格数据
				    tabledata();
				},
				area: ['640px', '560px'],
			});
		}
    }
  });
  tabledata();
  function tabledata(){
	//配置表格属性 内容
	  table.render({
	    elem: '#offerList'
	    ,height: 520
	    ,url: 'http://localhost:8080/offer/offerList' //数据接口
	    ,where:{
	    	offerId : document.getElementById('offerId').value,
			orderId : document.getElementById('orderId').value,
			managerId : document.getElementById('managerId').value,
			offerState : document.getElementById('offerState').value,
			productName : document.getElementById('productName').value,
			quodationMin : document.getElementById('quodationMin').value,
			quodationMax : document.getElementById('quodationMax').value,
			implQuodationMin : document.getElementById('implQuodationMin').value,
			implQuodationMax : document.getElementById('implQuodationMax').value,
			servQuodationMin : document.getElementById('servQuodationMin').value,
			servQuodationMax : document.getElementById('servQuodationMax').value,
			specQuodationMin : document.getElementById('specQuodationMin').value,
			specQuodationMax : document.getElementById('specQuodationMax').value,
			profitOrLossMin : document.getElementById('profitOrLossMin').value,
			profitOrLossMax : document.getElementById('profitOrLossMax').value,
			totalMin : document.getElementById('totalMin').value,
			totalMax : document.getElementById('totalMax').value
	    }
	    ,method:'post'
	    ,page: true //开启分页
	    ,toolbar:'#toolbar-fuzzy'
	    ,defaultToolbar: ['filter', 'print', 'exports']
	  	,limit:10
	  	,limits:[5,10,20,30]
	  	,title:'报价列表'
	  	,text: {
	  		none: '暂无相关数据'
	  	   }
	    ,done:function(res){
	    	//console.log(res.msg);
	    	if(res.msg<1){
	    		location.reload();
	    	}
	    }
	  	,cols:[[
	  		 {field: 'offerId', title: 'ID', width:60, sort: true, fixed: 'left'}
	  	      ,{field: 'orderId', title: '订单编号', width:120}
	  	      ,{field: 'manager', title: '创建人', width:90 , templet: function(d){return d.manager.name}  }
	  	      ,{field: 'offerState', title: '报价单状态', width:120, templet: function(d){return d.offerState==null?"未审核":d.offerState==0?"<p style='color:red'>未通过</p>":"<p style='color:green'>已通过</p>"}  }
	  	      ,{field: 'productName', title: '产品名称', width: 120}
	  	      ,{field: 'quodation', title: '产品报价', width: 120, sort: true}
	  	      ,{field: 'implQuodation', title: '实施报价', width: 120, sort: true}
	  	      ,{field: 'servQuodation', title: '运维报价', width: 120, sort: true}
	  	      ,{field: 'specQuodation', title: '专项报价', width: 120, sort: true}
	  	      ,{field: 'profitOrLoss', title: '损益报价', width: 120, sort: true}
	  	      ,{field: 'total', title: '总计', width: 120, sort: true}
	  	      ,{fixed: 'right', width:140, align:'center', toolbar: '#toolbar-line'} //这里的toolbar值是模板元素的选择器
	  	]]
	  });
  }

});
</script>

</body>
</html>