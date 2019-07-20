<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
<meta charset="UTF-8">
<title>客户添加界面</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="../../static/css/font.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">



<script type="text/javascript" src="../../static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../static/js/xadmin.js"></script>
<script type="text/javascript" src="../../static/js/cookie.js"></script>



<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body">
		<form class="layui-form">
		<input type="hidden"  name="id" value="${customer.id}">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>公司名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cusname" name="cusname" required=""
						lay-verify="required" autocomplete="off" value="${customer.cusname}" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>创建时间
				</label>

			     <div class="layui-input-inline">
			       <input value="${customer.cuscreatetime}" class="layui-input" name="cuscreatetime" id="getdate" type="text" placeholder="年-月-日">
			     </div>

			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>所在大区
				</label>
				<div class="layui-input-inline">
					<select value="${customer.cusregion }" name="cusregion" type="text" lay-verify="required">
						<option value="">${customer.id }</option>
						<option value="">请选择</option>
						<option value="华北地区">华北地区</option>
						<option value="华东地区">华东地区</option>
						<option value="华南地区">华南地区</option>
						<option value="华中地区">华中地区</option>
						<option value="西南地区">西南地区</option>
						<option value="西北西北">西北地区</option>
						<option value="东北地区">东北地区</option>
					</select>
				</div>
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>详细地址
				</label>
				<div class="layui-input-inline">
					<input value="${customer.cusaddr } type="text" id="cusaddr" name="cusaddr" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>选择经理
				</label>
				<div class="layui-input-inline">
					<select type="text" name="cusmanagerid" lay-verify="required">
						<c:forEach items="${userlist }" var="u">
							<c:if test="${u.id }=${customer.cusmanagerid }">
								<option value="${u.id }">${u.name }</option>
							</c:if>
						</c:forEach>
						<c:forEach items="${userlist }" var="u">
							<option value="${u.id }">${u.name }</option>
						</c:forEach>
					</select>
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>客户等级
				</label>
				<div class="layui-input-inline">
					<select type="text" name="rid" lay-filter="aihao"
						lay-verify="required">
						<option value="">请选择</option>
						<c:forEach items="${ranklist }" var="r">
							<option value="${r.rid }">${r.rname }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>法人姓名
				</label>
				<div class="layui-input-inline">
					<input value="${customer.chieftain }" type="text" id="chieftain" name="chieftain" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>银行账户
				</label>
				<div class="layui-input-inline">
					<input value="${customer.bank }" type="text" id="bank" name="bank" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>开户号码
				</label>
				<div class="layui-input-inline">
					<input value="${customer.bankacount }" type="text" id="bankacount" name="bankacount" required=""
						lay-verify="bankacounts" autocomplete="off" class="layui-input">
				</div>

			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>公司网址
				</label>
				<div class="layui-input-inline">
					<input value="${customer.cuswebsite }" type="text" id="cuswebsite" name="cuswebsite" required=""
						lay-verify="url" autocomplete="off" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>传真
				</label>
				<div class="layui-input-inline">
					<input value="${customer.cusfax }" type="text" id="cusfax" name="cusfax" required=""
						lay-verify="cusfax" autocomplete="off" class="layui-input">
				</div>
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>邮政编码
				</label>
				<div class="layui-input-inline">
					<input value="${customer.cuszip }" type="text" id="cuszip" name="cuszip" required=""
						lay-verify=cuszips autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>客户满意度
				</label>
				
				<div id="test14" class="layui-input-inline" name="cussati"></div>
				
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>客户信用度
				</label>
				
				<div id="test1" class="layui-input-inline" name="cuscredi"></div>
				
				<label class="layui-form-label"> <span
					class="x-red">*</span>客户状态
				</label>
				<div class="layui-input-inline">
					<select type="text" name="cusstatus" lay-filter="aihao"
						lay-verify="required">
						<option value="">请选择</option>
						<option value="1">机会客户</option>
						<option value="2">标准客户</option>
					</select>
				</div>
			</div>

			<!-- <div class="layui-upload">
			  <button class="layui-btn" id="test1" type="button">上传图片</button>
			  <div class="layui-upload-list">
			    <img class="layui-upload-img" id="demo1">
			    <p id="demoText"></p>
			  </div>
			</div>    -->

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					修改</button>
			</div>
		</form>
	</div>
	<script>
		var cuscredi=3;
		var cussati=3;
		layui.use([ 'form', 'layer' ], function() {
			
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				bankacounts : [ /^([0-9]{19})$/, '银行卡号19位' ],
				cuszips: [ /^([0-9]{6})$/, '邮政编码6位' ],
			 	cusfax: [ /^([0-9]{6})$/, '傳真6位' ]
			});
			//监听提交
			form.on('submit(add)', function(data) {
				console.log(data.field);
				data.field.cuscredi=cuscredi;
				data.field.cussati=cussati;
				//发异步，把数据提交给php
				$.ajax({
		            data:data.field,
		            type:"post",
		            url:"${pageInfo.navigatepageNums }/CustomerController/updateCus",
		            dataType:"json",
		            success:function () {
		                layer.alert("修改成功", {
							icon : 6
						}, function() {
							// 获得frame索引
							var index = parent.layer.getFrameIndex(window.name);
							//关闭当前frame
							parent.layer.close(index);
							// 可以对父窗口进行刷新 
							x_admin_father_reload();
						});
		            }
		        });

				return false;
			});

		});
		//layui时间表
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//常规用法
			laydate.render({
			  elem: '#getdate'
			});
		});
		//滑动评分效果
		layui.use([ 'rate' ], function() {
			var rate = layui.rate;
			//基础效果
			rate.render({
				elem : '#test1',
				value : 3,
				choose : function(value) {
					cuscredi=value;
				}
			})
			rate.render({
				elem : '#test14',
				value : 3,
				theme : '#FE0000',
				choose : function(value) {
					cussati = value;
				}
			})
		});
	</script>
	<script>
	
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
	<!-- <script>
	layui.use('upload', function(){
		  var $ = layui.jquery
		  ,upload = layui.upload;
		  
		  //普通图片上传
		  var uploadInst = upload.render({
		    elem: '#test1'
		    ,url: '/upload/'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo1').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		      //如果上传失败
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		      //上传成功
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		  });
		});
	</script> -->
</body>

</html>